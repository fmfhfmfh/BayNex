package kr.co.codemaker.common.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.common.service.LoginService;
import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.common.vo.UserVO;

/**
* UserLoginController.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 회원 로그인
*
 */
@Controller
public class UserLoginController {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	//커밋
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="notificationService")
	private NotificationService notificationService;
	
	@RequestMapping(path="user/login", method = RequestMethod.GET)
	public String userLoginView(@RequestParam(required=false) String msg, Model model) {
		if(msg !=null) {
			model.addAttribute("msg", msg);
		}
		return "user/main/login";
	}
	
	@RequestMapping(path="user/login", method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String userLogin(UserVO userVo,
			@RequestParam(name="rememberMe", required=false, defaultValue="0") int rememberMe, Model model, HttpSession session,
			HttpServletResponse response) throws UnsupportedEncodingException{
		UserVO getUserVo = null;
		try {
			getUserVo = loginService.selectUser(userVo.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Cookie userCookie=null;
		Cookie remember = null;
		//아이디 저장 버튼 클릭시 쿠키에 아이디 정보 저장
		if(rememberMe == 1) {
			userCookie = new Cookie("userid", URLEncoder.encode(userVo.getUserId(),"UTF-8"));
			remember = new Cookie("remember", Integer.toString(rememberMe));
			userCookie.setMaxAge(60*60*24*30);
			remember.setMaxAge(60*60*24*30);
			response.addCookie(userCookie);
			response.addCookie(remember);
		}else {
			userCookie = new Cookie("userid", null);
			remember = new Cookie("remember", null);
			userCookie.setMaxAge(0);
			remember.setMaxAge(0);
			response.addCookie(userCookie);
			response.addCookie(remember);
		}
		
		//회원이 탈퇴한 경우
		if(getUserVo.getUserOut().equals("Y")){
			String msg = "Y";
			model.addAttribute("msg", msg);
			return "redirect:/user/login";
		}
		
		// 로그인 성공시 메인홈페이지로 이동
		if(getUserVo != null && userVo.getUserPass().equals(getUserVo.getUserPass())) {
			session.setAttribute("MEMBER_INFO", getUserVo);
			
			//회원에 대한 알림 조회
			NotificationVO notificationVo = new NotificationVO();
			notificationVo.setRecipientId(getUserVo.getUserId());
			List<NotificationVO> notifyList = new ArrayList<NotificationVO>();
			int notifyCnt = 0;
			try {
				notifyList = notificationService.selectAllNotification(notificationVo);
				notifyCnt = notificationService.selectNotReadCount(notificationVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("notifyList", notifyList);
			session.setAttribute("notifyCnt", notifyCnt);
			return "mainT/user/main/main_content";
		// 비밀번호 틀렸을때 문구출력
		}else if(getUserVo != null && !userVo.getUserPass().equals(getUserVo.getUserPass())) {
			String msg = URLEncoder.encode("비밀번호를 확인해주세요","UTF-8");
			return "redirect:/user/login?msg="+msg;
		// 일치하는 아이디가 없을때 문구 출력
		}else {
			String msg = URLEncoder.encode("존재하는 회원 정보가 없습니다","UTF-8");
			return "redirect:/user/login?msg="+msg;
		}
	}
	
	@RequestMapping(path="user/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/main";
	}
	
	@RequestMapping(path="user/findInfo")
	public String userFindInfo(String info,Model model) {
		model.addAttribute("info", info);
		return "user/main/find_info";	
	}
	
	@RequestMapping(path="user/findId")
	public String userFindId(UserVO userVo, String certi, Model model) {
		UserVO getUserVo = null;
		try {
			getUserVo = loginService.findUserInfo(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("UserVO", getUserVo);
		return "user/main/ajax/find_id";
	}
	
	@RequestMapping(path="user/findPw")
	public String userFindPw(UserVO userVo, String certi,Model model) {
		UserVO getUserVo = null;
		try {
			getUserVo = loginService.findUserInfo(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("UserVO", getUserVo);
		return "user/main/ajax/find_pw";
	}
	
	@RequestMapping(path="user/changePw")
	public String userChangePw(UserVO userVo,String userId) {
		logger.debug("가져온값 : {}",userVo);
		int updateCnt=0;
		try {
			updateCnt = loginService.updateUserPass(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(updateCnt > 0) {
			logger.debug("수정 성공");
		}else {
			logger.debug("수정 실패");
		}
		return "redirect:/user/login";
	}
	
	@RequestMapping(path="/signup")
	public String userSignupView() {
		return "user/signup/signup";
	}
	
	@RequestMapping(path="user/main")
	public String contentTest() {
		return "mainT/user/main/main_content";
	}

	@RequestMapping(path="/mypage")
	public String userMypageView() {
		return "mypageT/user/mypage/mypage_content";
	}
	
	@RequestMapping(path="/mypagebck")
	public String userMypageBckView() {
		return "user/mypage/layout/mypage_bck";
	}
	
	@RequestMapping(path="/mypagetest")
	public String userMypageNewView() {
		return "user/mypage/test";
	}
	
	@RequestMapping(path="/test")
	public String testView() {
		return "mainT/user/lesson/home";
	}

}
