package kr.co.codemaker.teacher.course.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.codemaker.teacher.signup.vo.TeacherVO;
import kr.co.codemaker.teacher.course.exam.service.AnswersheetService;
import kr.co.codemaker.teacher.course.exam.service.ExamService;
import kr.co.codemaker.teacher.course.exam.service.QuestionService;
import kr.co.codemaker.teacher.course.exam.vo.AnswersheetVO;
import kr.co.codemaker.teacher.course.exam.vo.ExamVO;
import kr.co.codemaker.teacher.course.exam.vo.LessonVO;
import kr.co.codemaker.teacher.course.exam.vo.QuestionVO;
import kr.co.codemaker.teacher.course.exam.vo.SubjectVO;

/**
 * 
* ExamController.java
*
* @author 김미연
* @version 1.0
* @since 2020. 11. 24.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Controller
public class ExamController {

	@Resource(name = "examService")
	private ExamService examService;

	@Resource(name = "questionService")
	private QuestionService questionService;

	@Resource(name = "answersheetService")
	private AnswersheetService answersheetService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

	/**
	 * 시험 리스트 조회 - 과목 조회, 강의 조회, 시험 조회
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/selectAllExam")
	public String selectAllExam(Model model, HttpSession session, ExamVO examVO) {
		String tchId = ((TeacherVO)session.getAttribute("S_TEACHER")).getTchId();
		
		examVO.setTchId(tchId);
		
//		examVO.setTchId("200ser@maker.com");
		
		List<SubjectVO> subjectList = new ArrayList<>();
		List<LessonVO> lessonList = new ArrayList<>();
		List<ExamVO> examList = new ArrayList<>();
		int totalCnt = 0;
		
		try {
			lessonList = examService.selectAllLesson(examVO);
			subjectList = examService.selectAllSubject(examVO);
			examList = examService.selectAllExam(examVO);
			totalCnt = examService.selectTotalCntExam(examVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int pages = (int) Math.ceil((double) totalCnt / 10);
		
		model.addAttribute("pages", pages);
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("lessonList", lessonList);
		model.addAttribute("examList", examList);
		
		return "teacherPage/teacher/exam/examAllSelect";
	}
	
	/**
	 * 강의 조회를 위한 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/selectAllLesson")
	public String selectAllLesson(Model model, LessonVO lessonVO, HttpSession session) {
		String tchId = ((TeacherVO)session.getAttribute("S_TEACHER")).getTchId();
		
		lessonVO.setTchId(tchId);
		
		List<LessonVO> lessonList = new ArrayList<>();
		try {
			lessonList = examService.selectAllLesson(lessonVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("lessonList", lessonList);
		return "jsonView";
	}
	
	/**
	 * 등록한 시험문제를 상세 조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/selectExam")
	public String selectExam(ExamVO examVO, Model model) {
		ExamVO ev = new ExamVO();
		List<QuestionVO> questionList = new ArrayList<>();
		List<AnswersheetVO> answersheetLists = new ArrayList<AnswersheetVO>();
		
		try {
			ev = examService.selectExam(examVO);
			questionList = questionService.selectQuestion(examVO);
			for (QuestionVO questionVO : questionList) {
				List<AnswersheetVO> answersheetList = answersheetService.selectAnswersheet(questionVO);
				
				for (AnswersheetVO answersheetVO : answersheetList) {
					answersheetLists.add(answersheetVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("ev", ev);
		model.addAttribute("questionList", questionList);
		model.addAttribute("answersheetLists", answersheetLists);

		return "teacherPage/teacher/exam/examUpdate";
	}
	
	/**
	 * 시험을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/updateExam")
	public String updateExam(ExamVO examVO, RedirectAttributes redirectAttributes) {
		int index = 0;
		
		try {
			// 기존 문제의 수정
			examService.updateExam(examVO);
			for (QuestionVO questionVO : examVO.getQuestionList()) {
				questionService.updateQuestion(questionVO);
			}
			
			for (AnswersheetVO answersheetVO : examVO.getAnswersheetLists()) { // 보기가 4개씩 존재
				answersheetService.updateAnswersheet(answersheetVO);
			}
			
			// 기존문제를 삭제할 경우
			if(examVO.getDelqueIdList() != null) {
				for(String queId : examVO.getDelqueIdList()) {
					AnswersheetVO answersheetVO = new AnswersheetVO();
					answersheetVO.setQueId(queId);
					
					QuestionVO questionVO = new QuestionVO();
					questionVO.setQueId(queId);
					
					answersheetService.deleteAnswersheet(answersheetVO);
					questionService.deleteQuestion(questionVO);
				}
			}
			
			// 새로운 문제 추가
			if(examVO.getQueContList() != null) {
				for (int i=0; i < examVO.getQueContList().size(); i++) {
					// 시험 아이디를 셋팅
					QuestionVO questionVO = new QuestionVO();
					questionVO.setExamId(examVO.getExamId());
					questionVO.setQueCont(examVO.getQueContList().get(i));
					questionVO.setQueAnswer(examVO.getQueAnswerList().get(i));
					questionVO.setQueExplain(examVO.getQueExplainList().get(i));
					questionVO.setQueScore(examVO.getQueScoreList().get(i));
					
					questionService.insertQuestion(questionVO);
					
					for (int j = index; j < index + 4; j++) { // 보기가 4개씩 존재
						// 시험 문제 아이디를 셋팅
						AnswersheetVO answersheetVO = new AnswersheetVO();
						answersheetVO.setAnsCont(examVO.getAnsContList().get(j));
						answersheetVO.setQueId(questionVO.getQueId());
						
						answersheetService.insertAnswersheet(answersheetVO);
					}
					index =+4;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// redirect Attribute
		redirectAttributes.addFlashAttribute("examVO", examVO);
		
		// 수정된 시험 화면으로 이동
		return "redirect:/exam/selectExam";
	}
	
	/**
	 * 시험 등록화면을 요청하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/insertExamView")
	public String insertViewExam(ExamVO examVO) {
		return "teacher/exam/examInsert";
	}

	/**
	 * 시험을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/insertExam")
	@ResponseBody
	public void insertExam(ExamVO examVO) {
		int index = 0;
		
		try {
				examService.insertExam(examVO);
				for (int i=0; i < examVO.getQueContList().size(); i++) {
					// 시험 아이디를 셋팅
					QuestionVO questionVO = new QuestionVO();
					questionVO.setExamId(examVO.getExamId());
					questionVO.setQueCont(examVO.getQueContList().get(i));
					questionVO.setQueAnswer(examVO.getQueAnswerList().get(i));
					questionVO.setQueExplain(examVO.getQueExplainList().get(i));
					questionVO.setQueScore(examVO.getQueScoreList().get(i));
					
					questionService.insertQuestion(questionVO);
	
				for (int j = index; j < index + 4; j++) { // 보기가 4개씩 존재
					// 시험 문제 아이디를 셋팅
					AnswersheetVO answersheetVO = new AnswersheetVO();
					answersheetVO.setAnsCont(examVO.getAnsContList().get(j));
					answersheetVO.setQueId(questionVO.getQueId());
					
					answersheetService.insertAnswersheet(answersheetVO);
				}
				index =+4;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 등록한 시험문제를 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/exam/deleteExam")
	public String deleteExam(ExamVO examVO, RedirectAttributes redirectAttributes) {
		AnswersheetVO answersheetVO = new AnswersheetVO();
		try {
			if(examVO.getQuestionList() != null) {
				for(QuestionVO questionVO : examVO.getQuestionList()) {
					answersheetVO.setQueId(questionVO.getQueId());
					answersheetService.deleteAnswersheet(answersheetVO);
					
					questionService.deleteQuestion(questionVO);
				}
			}
			examService.deleteExam(examVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("examVO", examVO);
		
		return "redirect:/exam/selectAllExam";
	}

}
