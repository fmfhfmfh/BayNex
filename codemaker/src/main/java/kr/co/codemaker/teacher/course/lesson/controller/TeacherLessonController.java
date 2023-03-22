package kr.co.codemaker.teacher.course.lesson.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.bean.conf.loader.annotation.Validatable;

import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.teacher.course.exam.vo.ExamVO;
import kr.co.codemaker.teacher.course.lesson.service.LessonIndexService;
import kr.co.codemaker.teacher.course.lesson.service.LessonService;
import kr.co.codemaker.teacher.course.lesson.service.TeacherSubjectService;
import kr.co.codemaker.teacher.course.lesson.vo.LessonIndexVO;
import kr.co.codemaker.teacher.course.lesson.vo.LessonVO;
import kr.co.codemaker.teacher.course.lesson.vo.SubjectVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
 * TeacherLessonController.java
 *
 * @author 박다미
 * @version 1.0
 * @since 2020. 12. 1.
 *
 *   수정자 수정내용 
 *   ------ ------------------------ 
 *   박다미 최초 생성
 *
 */
@Controller
public class TeacherLessonController {

	private static final Logger logger = LoggerFactory.getLogger(TeacherLessonController.class);

	@Resource(name = "lessonService")
	private LessonService lessonService;

	@Resource(name = "TeacherSubjectService")
	private TeacherSubjectService subjectService;

	@Resource(name = "lessonIndexService")
	private LessonIndexService lessonIndexService;
	
    @Resource(name = "notificationService")
    private NotificationService notificationService;

	/**
	 * 선생님 - 강의조회
	 */
	@RequestMapping(path = "/teacherL/selectSubject", method = RequestMethod.GET)
	public String selecSubject(Model model, HttpSession session) {
		TeacherVO teacherVO = (TeacherVO) session.getAttribute("S_TEACHER");
		String tchId = teacherVO.getTchId();

		List<LessonVO> noLessonList = new ArrayList<LessonVO>();
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		
		try {
			noLessonList = lessonService.selectNoLesson(tchId);
			subjectList = subjectService.selectSubject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("noLessonList", noLessonList);
		model.addAttribute("subjectList", subjectList);
		
		logger.debug("개설안된강의!!:{}", noLessonList);
		return "teacherPage/teacher/lesson/lessonAllSelect";
	}

	/**
	 * 선생님 - 과목명-> 강의 조회
	 */
	@ResponseBody
	@RequestMapping(path = "/teacherL/selectLesson")
	public List<LessonVO> selectLesson(Model model, String subId, HttpSession session) {
		logger.debug("과제아디!!:{}", subId);

		TeacherVO teacherVO = (TeacherVO) session.getAttribute("S_TEACHER");
		logger.debug("로그인한 선생님VO:{}", teacherVO);

//		String tchId = teacherVO.getTchId();
		LessonVO lessonVO = new LessonVO();
		lessonVO.setTchId(teacherVO.getTchId());
		lessonVO.setSubId(subId);
		List<LessonVO> leList = new ArrayList<LessonVO>();
		
		try {
			leList = lessonService.selectLesson(lessonVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("lessonList", leList);
		logger.debug("리스트!!:{}", leList);
		return leList;
	}

	/**
	 * 선생님 - 강의선택 -> 강의목차조회
	 */
	@ResponseBody
	@RequestMapping(path = "/teacherL/selectAllLessonIndex")
	public List<LessonIndexVO> selectLessonPage(Model model, String lesId) {
		LessonIndexVO lesIdxVO = new LessonIndexVO();
		lesIdxVO.setLesId(lesId);

		logger.debug("강의번호:{}", lesId);
		List<LessonIndexVO> lesIdxList = new ArrayList<LessonIndexVO>();
		try {
			lesIdxList = lessonIndexService.selectLessonIndex(lesId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("강의목차:{}", lesIdxList);
		model.addAttribute("lesIdxList", lesIdxList);
		return lesIdxList;
	}

	/**
	 * 선생님 - 강의 삭제&요청
	 */
	@RequestMapping(path = "/teacherL/deleteLesson", method = RequestMethod.GET)
	public String deleteLesson(Model model, String lesId, HttpSession session, String check, RedirectAttributes redirectAttributes) {
		TeacherVO teacherVO = (TeacherVO) session.getAttribute("S_TEACHER");
		LessonVO lessonVO = new LessonVO();
		lessonVO.setLesId(lesId);
		
        NotificationVO notificationVo = new NotificationVO();
        
        notificationVo.setRecipientId("admin");
        notificationVo.setSenderId(teacherVO.getTchId());
        notificationVo.setNotifyCont(teacherVO.getTchId() + " 님께서 강의 등록요청을 하였습니다");
        notificationVo.setUrl("/admin/selectAllAgree");
		
		String tchId = teacherVO.getTchId();
		logger.debug("lesId값!!!:{}", lesId);
		logger.debug("로그인한 선생님VO:{}", teacherVO);
		logger.debug("check:{}",check);

		int lesIdxCnt = 0;
		int examCnt = 0;
		try {
			if(check.equals("1")) {
				// 1 : 삭제 
				lesIdxCnt = lessonService.deleteLesson(lesId);
				if (lesIdxCnt == 1) {
					return "redirect:/teacherL/selectSubject";
				}
			}
			else {
				// 2 : 승인요청
				
				// 시험이 수정중인 갯수
				examCnt = lessonService.selectExamCnt(lessonVO);
				logger.debug("시험cnt:{}",examCnt);
				
				if (examCnt == 0) {
					lessonService.updatePermissionLesson(lessonVO);
					lessonService.updatePremissionExam(lessonVO);
                    notificationService.insertNotification(notificationVo);
					return "redirect:/teacherL/selectSubject";
				}else {
					redirectAttributes.addFlashAttribute("no", "등록된 시험이 수정중입니다.");
					return "redirect:/teacherL/selectSubject";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 선생님 - 강의 등록(페이지만 띄우기)
	 */
	@RequestMapping(path = "/teacherL/insertViewLesson")
	public String insertViewLesson(Model model) {
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		
			try {
				subjectList = subjectService.selectSubject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("subjectList", subjectList);
			return "teacherPage/teacher/lesson/lessonInsert";
	}

	/**
	 * 선생님 - 강의등록(값 받고 넘겨서 데이터 입력)
	 */
	@RequestMapping(path = "/teacherL/insertLesson", method = RequestMethod.POST)
	public String insertLesson(LessonVO lessonVO, HttpSession session, RedirectAttributes redirectAttributes) throws ParseException {
		TeacherVO teacherVO = (TeacherVO) session.getAttribute("S_TEACHER");
		String tchId = teacherVO.getTchId();

		logger.debug(" 날 짜 확 인 : {}", lessonVO.getLesEdate());
		logger.debug(" 날 짜 확 인 : {}", lessonVO);
		logger.debug("과목,선생:{}", tchId);
		
		lessonVO.setTchId(tchId);
		logger.debug("강의123123123123123 추가됐니?:{}", lessonVO);
		
		int lesCnt = 0;
		int lesIdxCnt = 0;

		try {
			lesCnt = lessonService.insertLesson(lessonVO);
			logger.debug("강의 추가됐니?:{}", lessonVO);
			String lesId = lessonVO.getLesId();
			List<LessonIndexVO> lesIdxList = lessonVO.getLesIdxList();
			for (LessonIndexVO lesIdxVO : lesIdxList) {
				if(lesIdxVO.getLidxCont() != null && !lesIdxVO.getLidxCont().equals("")) {
					lesIdxVO.setLesId(lesId);
					lesIdxCnt = lessonIndexService.insertLessonIndex(lesIdxVO);
					logger.debug("강의목차!!!!:{}", lesIdxVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (lesCnt == 1 && lesIdxCnt == 1 && lessonVO.getModalChk().equals("Y")) {
			ExamVO examVO = new ExamVO();
			examVO.setSearchLesId(lessonVO.getLesId());
			examVO.setSearchSubId(lessonVO.getSubId());
			
			redirectAttributes.addFlashAttribute("examVO",examVO);
			return "redirect:/exam/selectAllExam?";
		}
		else if(lesCnt == 1 && lesIdxCnt == 1 && lessonVO.getModalChk().equals("N")) {
			return "redirect:/teacherL/selectSubject";
		}
		else {
			return "teacherPage/teacher/lesson/lessonInsert";
		}
	}

	/**
	 * 선생님 - 강의수정화면
	 */
	@RequestMapping(path = "/teacherL/updateViewLesson")
	public String updateViewLesson(LessonVO lessonVO, Model model, String lesId, String subId) {
		// 1. 강의, 강의목차 조회하기
		// 2. 강의목차 옆에 삭제버튼달기 - 삭제시 화면이 load되어야함
		// 3. 강의목차 옆에 수정버튼 달기
		// 3. 강의목차 추가하기 버튼달기
		// 4. 등록버튼

		logger.debug("강의아디랑 과목아디!!!:{},{}", lesId, subId);
		List<LessonIndexVO> lesIdxList = new ArrayList<>();
		lessonVO.setLesId(lesId);
		try {
			lessonVO = lessonService.selectDetailLesson(lessonVO);
			lesIdxList = lessonIndexService.selectLessonIndex(lesId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("강의객체!!:{}", lessonVO);
		logger.debug("강의목차는???:{C}", lesIdxList);
		model.addAttribute("lessonVO", lessonVO);
		model.addAttribute("lesIdxList", lesIdxList);
		return "teacherPage/teacher/lesson/lessonUpdate";
	}

//	/**
//	 * 선생님 - 강의목차 삭제
//	 */
//	@RequestMapping(path = "/teacherL/deleteLessonIndex")
//	public String deleteViewLessonIndex(String lidxId, Model model, String lesId, LessonIndexVO lesIdxVO) {
//		List<LessonIndexVO> lesIdxList = new ArrayList<>();
//		int delCnt = 0;
//		int upCnt = 0;
//		logger.debug("넘어온 값:{},{}", lidxId, lesId);
//		logger.debug("lesIdxVO!!!:{}", lesIdxVO);
//		try {
//			// 강의목차 삭제
//			delCnt = lessonIndexService.deleteLessonIndex(lidxId);
//			// 삭제한거 제외한 강의목차 조회
//			logger.debug("delCnt값,delCnt값:{},{}", delCnt, upCnt);
//			lesIdxList = lessonIndexService.selectLessonIndex(lesId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (delCnt == 1) {
//			model.addAttribute("lesIdxList", lesIdxList);
//			return "teacher/lesson/lessonIndexUpdateHTML";
//		}
//		return null;
//	}
//
//	
//	/**
//	 * 선생님 - 강의목차 수정
//	 */
//	@RequestMapping(path = "/teacherL/updateLessonIndex")
//	public String updateViewLessonIndex(String lidxId, Model model, String lesId, LessonIndexVO lesIdxVO,
//			String lidxCont, int lidxNum) {
//		List<LessonIndexVO> lesIdxList = new ArrayList<>();
//		int delCnt = 0;
//		int upCnt = 0;
//		logger.debug("넘어온 값:{},{}", lidxId, lesId);
//		logger.debug("넘어온 강의넘버,강의내용:{},{}", lidxNum, lidxCont);
//		logger.debug("lidxId넣은 VO:{}", lesIdxVO);
//		lesIdxVO.setLidxNum(lidxNum);
//		lesIdxVO.setLidxCont(lidxCont);
//		logger.debug("셋!!!!넣은 VO:{}", lesIdxVO);
//		try {
//			// 강의목차 수정
//			upCnt = lessonIndexService.updateLessonIndex(lesIdxVO);
//			logger.debug("delCnt값,delCnt값:{},{}", delCnt, upCnt);
//			lesIdxList = lessonIndexService.selectLessonIndex(lesId);
//			logger.debug("레슨인덱스 리스트:{}", lesIdxList);
//			if (upCnt == 1) {
//				model.addAttribute("lesIdxList", lesIdxList);
//				return "teacher/lesson/lessonIndexUpdateHTML";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * 선생님 - 강의 수정(강의목차 추가,삭제,수정)
	 */
	@RequestMapping(path = "/teacherL/updateLesson", method = RequestMethod.POST)
	public String updateLesson(LessonVO lessonVO) {
		logger.debug("강의VO:{}", lessonVO);
		int upCnt = 0;
		int upTempoCnt = 0;
		int lesIdxUpCnt = 0;
		int lesIdxInsertCnt = 0;
		try {
			upTempoCnt = lessonService.updateTempoLesson(lessonVO);
			logger.debug("강의목차 리스트 :{}", lessonVO.getLesIdxList());

			// 강의목차 수정
			if(lessonVO.getLesIdxList() !=null) {
				for (LessonIndexVO lesIdxVO : lessonVO.getLesIdxList()) {
					if (lesIdxVO.getLidxId() != null) {
						lesIdxVO.setLesId(lessonVO.getLesId());
						lesIdxUpCnt = lessonIndexService.updateLessonIndex(lesIdxVO);
						logger.debug("수정된 강의목차!!!!:{}", lesIdxVO);
					}
				}
			}
			
			// 강의목차 추가
			if(lessonVO.getLesIdxListInsert() != null) {
				for (LessonIndexVO lesIdxVO : lessonVO.getLesIdxListInsert()) {
					if (lesIdxVO != null) {
						lesIdxVO.setLesId(lessonVO.getLesId());
						lesIdxInsertCnt = lessonIndexService.insertLessonIndex(lesIdxVO);
						logger.debug("추가된 강의목차!!!!:{}", lesIdxVO);
					}
				}
			}
			// 강의목차 삭제
			if(lessonVO.getLesIdxListDelete() != null) {
				for(String lidxId : lessonVO.getLesIdxListDelete()) {
					lessonIndexService.deleteLessonIndex(lidxId);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (upCnt == 1 || lesIdxUpCnt == 1 || lesIdxInsertCnt == 1) {
			return "redirect:/teacherL/selectSubject";
		}
		return "";
	}

}
