package kr.co.codemaker.user.classroom.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.classroom.exam.service.AnswersheetUserService;
import kr.co.codemaker.user.classroom.exam.service.ExamResultUserService;
import kr.co.codemaker.user.classroom.exam.service.ExamScoreUserService;
import kr.co.codemaker.user.classroom.exam.service.ExamUserService;
import kr.co.codemaker.user.classroom.exam.service.QuestionUserService;
import kr.co.codemaker.user.classroom.exam.vo.AnswersheetVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamResultVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamScoreVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;
import kr.co.codemaker.user.classroom.exam.vo.QuestionVO;

/**
 * 
* ExamController.java
*
* @author 김미연
* @version 1.0
* @since 2020. 11. 30.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Controller
public class ExamUserController {
	
	@Resource(name = "examUserService")
	private ExamUserService examUserService;
	
	@Resource(name = "questionUserService")
	private QuestionUserService questionUserService;
	
	@Resource(name = "answersheetUserService")
	private AnswersheetUserService answersheetUserService;
	
	@Resource(name = "examScoreUserService")
	private ExamScoreUserService examScoreUserService;
	
	@Resource(name = "examResultUserService")
	private ExamResultUserService examResultUserService;
	
	/**
	 * 시험문제를 전체 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/examUser/selectAllExam")
	public String selectAllExam(ExamVO examVO, Model model, HttpSession session) {
		String userId = ((UserVO)session.getAttribute("MEMBER_INFO")).getUserId();
		
		examVO.setUserId(userId);
		
		List<ExamVO> examList = new ArrayList<>();
		int totalCnt = 0;
		
		try {
			examList = examUserService.selectAllExam(examVO);
			totalCnt = examUserService.selectTotalCntExam(examVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int pages = (int) Math.ceil((double) totalCnt / 10);
		
		model.addAttribute("examList", examList);      
		model.addAttribute("pages", pages);
		
		return "mypageT/user/exam/examUserAllSelect";
	}
	
	/**
	 * 시험문제 화면을 요청하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/examUser/selectViewExam")
	public String selectViewExam(ExamVO examVO, Model model, HttpSession session) {
		ExamVO ev = new ExamVO();
		List<QuestionVO> questionList = new ArrayList<>();
		List<AnswersheetVO> answersheetLists = new ArrayList<AnswersheetVO>();
		
		String userId = ((UserVO)session.getAttribute("MEMBER_INFO")).getUserId();
		examVO.setUserId(userId);
		
		try {
			ev = examUserService.selectExam(examVO);
			questionList = questionUserService.selectQuestion(examVO);
			for (QuestionVO questionVO : questionList) {
				List<AnswersheetVO> answersheetList = answersheetUserService.selectAnswersheet(questionVO);
				
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
		
		return "/user/exam/examUserInsert";
	}
	
	/**
	 * 시험점수와 시험결과를 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examScoreVO
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "/examUser/insertExamResult")
	public void insertExamResult(ExamVO examVO, HttpSession session) {
		String userId = ((UserVO)session.getAttribute("MEMBER_INFO")).getUserId();
		
		ExamScoreVO examScoreVO = new ExamScoreVO();
		examScoreVO.setExamId(examVO.getExamId());
		examScoreVO.setEsFscore(examVO.getEsFscore());
		examScoreVO.setEsLscore(examVO.getEsLscore());
		examScoreVO.setUserId(userId);
		
		try {
			if(examVO.getSearchEsScore().equals("0")) {
				examScoreUserService.insertExamScore(examScoreVO);
				for(int i=0; i < examVO.getQueIdList().size(); i++) {
					ExamResultVO examResultVO = new ExamResultVO();
					examResultVO.setQueId(examVO.getQueIdList().get(i));
					examResultVO.setErAnswer(examVO.getStudentAnswers().get(i));
					examResultVO.setErCheck(examVO.getErCheckList().get(i));
					examResultVO.setUserId(userId);
					examResultVO.setExamId(examVO.getExamId());
					
					examResultUserService.insertExamResult(examResultVO);
				}
			}else {
				examScoreUserService.updateExamScore(examScoreVO);
				for(int i=0; i < examVO.getQueIdList().size(); i++) {
					ExamResultVO examResultVO = new ExamResultVO();
					examResultVO.setQueId(examVO.getQueIdList().get(i));
					examResultVO.setErAnswer(examVO.getStudentAnswers().get(i));
					examResultVO.setErCheck(examVO.getErCheckList().get(i));
					examResultVO.setUserId(userId);
					
					examResultUserService.updateExamResult(examResultVO);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 회원의 성적 1개를 조회하는 메서드 - 상세조회 : 점수조회 + 문제조회
	 * 
	 * @author 김미연
	 * @param examScoreVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/examUser/selectExamScore")
	public String selectExamScore(ExamVO examVO, Model model, HttpSession session) {
		String userId = ((UserVO)session.getAttribute("MEMBER_INFO")).getUserId();
		examVO.setUserId(userId);
		
		ExamScoreVO examScoreVO = new ExamScoreVO();
		List<ExamResultVO> examResultList = new ArrayList<>();
		List<AnswersheetVO> answersheetLists = new ArrayList<AnswersheetVO>();
		
		try {
			examScoreVO = examScoreUserService.selectExamScore(examVO);
			examResultList = examResultUserService.selectAllExamResult(examVO);
			for (QuestionVO questionVO : examResultList) {
				List<AnswersheetVO> answersheetList = answersheetUserService.selectAnswersheet(questionVO);
				
				for (AnswersheetVO answersheetVO : answersheetList) {
					answersheetLists.add(answersheetVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("examScoreVO", examScoreVO);
		model.addAttribute("examResultList", examResultList);
		model.addAttribute("answersheetLists", answersheetLists);
		
		if(examVO.getResultState() != null && examVO.getResultState().equals("0")) {
			return "mypageT/user/exam/examUserSelect";
		}
		
		return "user/exam/examUserResult";
	}
	

}
