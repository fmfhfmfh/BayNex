package kr.co.codemaker.user.classroom.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.classroom.exam.dao.AnswersheetUserMapper;
import kr.co.codemaker.user.classroom.exam.dao.ExamScoreUserMapper;
import kr.co.codemaker.user.classroom.exam.dao.ExamUserMapper;
import kr.co.codemaker.user.classroom.exam.dao.QuestionUserMapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;


/**
 * 
* ExamUserService.java
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
@Service("examUserService")
public class ExamUserService {
	
	@Resource(name = "examUserMapper")
	private ExamUserMapper examUserMapper;
	
	@Resource(name = "questionUserMapper")
	private QuestionUserMapper questionUserMapper;
	
	@Resource(name = "answersheetUserMapper")
	private AnswersheetUserMapper answersheetUserMapper;

	/**
	 * 시험 문제를 전체 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public List<ExamVO> selectAllExam(ExamVO examVO) throws Exception {
		return examUserMapper.selectAllExam(examVO);
	}
	
	/**
	 * 시험 문제를 전체 조회하는 메서드 - 강의 조회
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public List<ExamVO> selectExamLesson(ExamVO examVO) throws Exception{
		return examUserMapper.selectExamLesson(examVO);
	}
	
	/**
	 * 페이징 처리를 위해 출제한 문제의 전체 수를 조회하는 메서드
	 * 
	 * @param examVO
	 * @return
	 */
	public int selectTotalCntExam(ExamVO examVO) throws Exception{
		return examUserMapper.selectTotalCntExam(examVO);
	}
	
	/**
	 * 해당 시험을 조회하는 메서드
	 * @param examVO
	 * @return 
	 * @throws Exception 
	 */
	public ExamVO selectExam(ExamVO examVO) throws Exception {
		return examUserMapper.selectExam(examVO);
	}
	
	/**
	 * 해당 강의의 시험 개수를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public int selectExamCnt(ExamVO examVO) throws Exception{
		return examUserMapper.selectExamCnt(examVO);
	}
	
}
