package kr.co.codemaker.user.lessoninfo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;
import kr.co.codemaker.user.classroom.exam.service.ExamUserService;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;
import kr.co.codemaker.user.lessoninfo.service.LessonIndexService;
import kr.co.codemaker.user.lessoninfo.service.LessonService;
import kr.co.codemaker.user.lessoninfo.service.UesrSubjectService;
import kr.co.codemaker.user.lessoninfo.vo.IndexTimeVO;
import kr.co.codemaker.user.lessoninfo.vo.LessonIndexVO;
import kr.co.codemaker.user.lessoninfo.vo.LessonVO;
import kr.co.codemaker.user.lessoninfo.vo.PayVO;
import kr.co.codemaker.user.lessoninfo.vo.SubjectVO;


/**
 * UserLessonController.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 19.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
@Controller
public class UserLessonController {

	private static final Logger logger = LoggerFactory.getLogger(UserLessonController.class);

	@Resource(name="userLessonService")
	private LessonService lessonService;
	
	@Resource(name="userSubjectService")
	private UesrSubjectService subjectService;
	
	@Resource(name="userLessonIndexService")
	private LessonIndexService lessonIndexService;
	
	@Resource(name = "examUserService")
	private ExamUserService examUserService;
	
	@RequestMapping(path="/user/selectSubject")
	public String selectLesson(Model model) {
		List<SubjectVO> subjectList = subjectService.selectSubject();
		List<LessonVO> lessonList = new ArrayList<>();
		try {
			lessonList = lessonService.selectLesson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("lessonList", lessonList);
		
		return "mainT/user/lesson/subjectSelect";
	}
	
	/**
	 * 회원 - 강의목차 조회페이지
	 * @param model
	 * @param lessonIndexVO
	 * @return
	 */
	@RequestMapping(path="/user/selectLessonPage")
	public String selectLessonPage(Model model,HttpSession session,String lesId ) {
		// 1. 파라미터 lesId -> VO객체로 받기
		// 2. lidxId , lidxCurtime(int타입) 값 가져오기
		LessonIndexVO lessonIndexVO = new LessonIndexVO();
		LessonVO lessonVO = new LessonVO();
		PayVO payVO = new PayVO();
		
        UserVO userVO = new UserVO();
        userVO = (UserVO) session.getAttribute("MEMBER_INFO");
        logger.debug("유저VO!!:{}",userVO);
		
		List<LessonIndexVO> lesIdxList =  new ArrayList<LessonIndexVO>();
		
		TeacherVO teacherVo = new TeacherVO();
		
		// 시험
		List<ExamVO> examList = new ArrayList<ExamVO>();
		ExamVO examVO = new ExamVO();
		examVO.setLesId(lesId);
		
		lessonIndexVO.setLesId(lesId);
		String userId = "";
		int examCnt = 0;
		
		if(userVO!=null) {
			lessonIndexVO.setUserId(userVO.getUserId());
			examVO.setUserId(userVO.getUserId());
			payVO.setUserId(userVO.getUserId());
		}
		lessonVO.setLesId(lesId);
		payVO.setLesId(lesId);
		try {
			lesIdxList = lessonIndexService.selectLessonIndex(lessonIndexVO);
			lessonVO = lessonService.selectDetailLesson(lessonVO);
			teacherVo = lessonService.selectTeacher(lesId);
			payVO = lessonService.selectPay(payVO);
			
			logger.debug("lessonVO:{}",lessonVO);
			logger.debug("teacherVo:{}",teacherVo);
			
			examList = examUserService.selectExamLesson(examVO);
			examCnt = examUserService.selectExamCnt(examVO);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		logger.debug("강의번호:{}",lessonIndexVO.getLesId());
		logger.debug("강의목차:{}",lesIdxList);
		logger.debug("강의VO@@@@@:{}",lessonVO);
		model.addAttribute("lesIdxList", lesIdxList);
		model.addAttribute("lesId", lessonIndexVO.getLesId());
		model.addAttribute("lessonVO",lessonVO);
		model.addAttribute("teacherVo", teacherVo);
		model.addAttribute("payVO",payVO);
		
		model.addAttribute("examList",examList);
		model.addAttribute("examCnt",examCnt);
		
		return "mainT/user/lesson/lessonSelect";
	}
	
	/**
	 * 회원 - 강의목차 진행률 수정
	 * @param model
	 * @param lidxId
	 * @param curTime
	 */
	@ResponseBody
	@RequestMapping(path="/user/updateLessonPage")
	public void updateLessonPage(Model model,String lidxId,@RequestParam(required=false)String curTime,HttpSession session ) {
		LessonIndexVO lesIdxVO = new LessonIndexVO();
		// 1. 파라미터 lesId -> VO객체로 받기
		// 2. lidxId , lidxCurtime(int타입) 값 가져오기
		// 3. 진행률 업데이트
		
		// 로그인세션 가져오기
		UserVO userVO = new UserVO();
		userVO = (UserVO) session.getAttribute("MEMBER_INFO");
		int cnt=0;
		
		
		logger.debug("userVO : {}", userVO);
		logger.debug("재생시간 : {}", curTime);
		
		int time = ((int)Double.parseDouble(curTime)/60);
		
		logger.debug("curArray: {}", time);
		
		IndexTimeVO indexTimeVO = new IndexTimeVO();
		indexTimeVO.setUserId(userVO.getUserId());
		indexTimeVO.setLidxId(lidxId);
		indexTimeVO.setLidxCurtime(time);
		
		logger.debug("indexTimeVO: {}", indexTimeVO);
		try {
			cnt = lessonIndexService.updateIndexTime(indexTimeVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 회원 - 강의 동영상 보기
	 * @param lidxPath
	 * @param model
	 * @param lidxId
	 * @return
	 */
	@RequestMapping(path="/user/selectYoutube")
	public String selectYou(String lidxPath, Model model,String lidxId) {
		model.addAttribute("lidxPath",lidxPath);
		model.addAttribute("lidxId", lidxId);
		return "user/lesson/lessonYoutube";
	}
	
	
	@RequestMapping(path="/user/teacherImg")
	public void imgView(String tchProfile, HttpServletResponse response) throws IOException {
		response.setContentType("image");
		FileInputStream fis = new FileInputStream(tchProfile);
		ServletOutputStream sos = response.getOutputStream();
		byte[] buffer = new byte[512];
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		fis.close();
		sos.flush();
		sos.close();
	}
	
	
}
