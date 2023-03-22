package kr.co.codemaker.common.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.codemaker.admin.vo.AdminVO;
import kr.co.codemaker.common.service.LoginService;
import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

@Controller
public class AdminLoginController { 
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="notificationService")
	private NotificationService notificationService;
	
	//로그인 화면
	/**
	 * 로그인 화면
	 * @author 이은지
	 * @return
	 */
	@RequestMapping(path="/loginView", method = RequestMethod.GET)
	public String getView() {
		logger.debug("AdminLoginController.getView()");
		return "admin/login/adminLogin";
	}
	
	// 관리자 로그인
	/**
	 * 관리자가 로그인하는 메서드
	 * @author 이은지
	 * @param dbAdminVO
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="/admin/login", method=RequestMethod.POST)
	@ResponseBody
	public String getAdmin(AdminVO dbAdminVO, HttpServletRequest request, HttpSession session, Model model) throws Exception{
		AdminVO adminVO = null;
		try {
			adminVO = loginService.getAdmin(dbAdminVO.getAdminId());
			logger.debug("관리자 아이디=========== : {}", dbAdminVO.getAdminId());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		NotificationVO notificationVo = new NotificationVO();
		notificationVo.setRecipientId(adminVO.getAdminId());
		
		List<NotificationVO> notifyList = new ArrayList<NotificationVO>();
		int notifyCnt = 0;
		try {
			notifyList = notificationService.selectAllNotification(notificationVo);
			notifyCnt = notificationService.selectNotReadCount(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(adminVO != null && dbAdminVO.getAdminPass().equals(adminVO.getAdminPass())) {
			session.setAttribute("S_ADMIN", adminVO);
			session.setAttribute("notifyList", notifyList);
			session.setAttribute("notifyCnt", notifyCnt);
			return "Y";
		}
		return "N";
	}
	
	// 로그아웃
	/**
	 * 로그아웃 하는 메서드
	 * @param session
	 * @author 이은지
	 * @return
	 */
	@RequestMapping(path="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		logger.debug("로그아웃했땅!!!!!!!!!!======", session);
		return "redirect:/loginView";
	}
	
	
	/**
	 * 강사가 로그인하는 메서드
	 * @param dbTeacherVO
	 * @param response
	 * @param session
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="/teacher/login", method=RequestMethod.POST)
	@ResponseBody
	public String getTeacher(TeacherVO dbTeacherVO, HttpServletResponse response,
								HttpSession session) throws Exception{
		TeacherVO teacherVO = null;
		try {
			teacherVO = loginService.getTeacher(dbTeacherVO.getTchId());
			logger.debug("선생님 아이디=============== : {}", dbTeacherVO.getTchId());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		NotificationVO notificationVo = new NotificationVO();
		notificationVo.setRecipientId(teacherVO.getTchId());
		
		List<NotificationVO> notifyList = new ArrayList<NotificationVO>();
		int notifyCnt = 0;
		try {
			notifyList = notificationService.selectAllNotification(notificationVo);
			notifyCnt = notificationService.selectNotReadCount(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(teacherVO != null && dbTeacherVO.getTchPass().equals(teacherVO.getTchPass())) {
			session.setAttribute("S_TEACHER", teacherVO);
			session.setAttribute("notifyList", notifyList);
			session.setAttribute("notifyCnt", notifyCnt);
			
			return "Y";
		}
		return "N";
	}
	
	/**
	 * 구글 reCaptcha API
	 * @param request
	 * @author 이은지
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/login/VerifyRecaptcha", method=RequestMethod.POST)
	public int VerifyRecaptcha(HttpServletRequest request) {
		VerifyRecaptcha.setSecretKey("6Le8jQgaAAAAAMiEzVgjpuUPkZgyxJJP-tkUCEO7");
		String gRecaptchaResponse = request.getParameter("recaptcha");
		try {
			if(VerifyRecaptcha.verify(gRecaptchaResponse)) {
				return 0; // 성공
			}
			else return 1; // 실패
		} catch (Exception e) {
			logger.debug("리캡챠!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! : {}", gRecaptchaResponse);
			e.printStackTrace();
			return -1; //에러
		}
	}
	
	/**
	 * 로그인 성공 시 관리자 메인화면
	 * @return
	 * @author 이은지
	 */
	@RequestMapping(path="/admin/main")
	public String adminMain() {
		return "redirect:/admin/selectAdminAllSchedule";
	}
	
	/**
	 * 로그인 성공 시 강사 메인화면
	 * @author 이은지
	 * @return
	 */
	@RequestMapping(path="/teacher/main")
	public String teacherMain() {
		
		return "redirect:/admin/selectTeacherAllSchedule";
	}
	
}

