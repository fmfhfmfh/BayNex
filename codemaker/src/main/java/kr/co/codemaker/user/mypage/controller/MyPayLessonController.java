package kr.co.codemaker.user.mypage.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.mypage.service.MyPayLessonService;
import kr.co.codemaker.user.mypage.vo.PayLessonInfoVO;

/**
* MyPayLessonController.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 회원 - 마이페이지 - 내 강의실에서 수강하는 강의목록
*
 */
@Controller
public class MyPayLessonController {
	private static final Logger logger = LoggerFactory.getLogger(MyPayLessonController.class);
	
	@Resource(name="myPayLessonService")
	private MyPayLessonService myPayLessonService;
	
	//강의 목록에서 현재 수강중인 강의들 목록 
	@RequestMapping(path="/user/myLesson")
	public String selectAllPayLesson(HttpSession session, Model model) {
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		PayLessonInfoVO plVo = new PayLessonInfoVO();
		plVo.setUserId(userVo.getUserId());
		List<PayLessonInfoVO> plList = null;
		try {
			plList = myPayLessonService.selectAllPayLesson(plVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("plList", plList);
		model.addAttribute("point", "studying");
		
		return "mypageT/user/mypage/mypage_lesson";
	}
	
	//강의 목록에서 수강이 완료된 강의들 목록
	@RequestMapping(path="/user/myLesson/finish")
	public String selectAllPayEnd(HttpSession session, Model model) {
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		PayLessonInfoVO plVo = new PayLessonInfoVO();
		plVo.setUserId(userVo.getUserId());
		List<PayLessonInfoVO> plList = null;
		try {
			plList = myPayLessonService.selectAllPayEnd(plVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("plList", plList);
		model.addAttribute("point", "complete");
		
		model.addAttribute("fin", "fin");
		
		return "mypageT/user/mypage/mypage_lesson";
	}
}
