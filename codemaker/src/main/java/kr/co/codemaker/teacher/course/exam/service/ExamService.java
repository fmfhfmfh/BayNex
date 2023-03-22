package kr.co.codemaker.teacher.course.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.course.exam.dao.AnswersheetMapper;
import kr.co.codemaker.teacher.course.exam.dao.ExamMapper;
import kr.co.codemaker.teacher.course.exam.dao.QuestionMapper;
import kr.co.codemaker.teacher.course.exam.vo.ExamVO;
import kr.co.codemaker.teacher.course.exam.vo.LessonVO;
import kr.co.codemaker.teacher.course.exam.vo.QuestionVO;
import kr.co.codemaker.teacher.course.exam.vo.SubjectVO;

/**
 * 
 * ExamService.java
 *
 * @author 김미연
 * @version 1.0
 * @since 2020. 11. 24.
 *
 *        수정자 수정내용 ------ ------------------------ 김미연 최초 생성
 *
 */
@Service("examService")
public class ExamService {

	@Resource(name = "examMapper")
	private ExamMapper examMapper;

	@Resource(name = "questionMapper")
	private QuestionMapper questionMapper;

	@Resource(name = "answersheetMapper")
	private AnswersheetMapper answersheetMapper;
	
	
	/**
	 * 과목을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param subjectVO
	 * @return
	 * @throws Exception
	 */
	public List<SubjectVO> selectAllSubject(SubjectVO subjectVO) throws Exception{
		return examMapper.selectAllSubject(subjectVO);
	}
	
	/**
	 * 강의을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param lessonVO
	 * @return
	 * @throws Exception
	 */
	public List<LessonVO> selectAllLesson(LessonVO lessonVO) throws Exception{
		return examMapper.selectAllLesson(lessonVO);
	}
	
	/**
	 * 자신이 출제한 시험 문제를 전체 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 */
	public List<ExamVO> selectAllExam(ExamVO examVO) throws Exception {
		return examMapper.selectAllExam(examVO);
	}
	
	/**
	 * 자신이 출제한 시험 문제 전체수를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public int selectTotalCntExam(ExamVO examVO) throws Exception{
		return examMapper.selectTotalCntExam(examVO);
	}
	
	/**
	 * 해당 시험을 조회하는 메서드
	 * 
	 * @param examVO
	 * @return
	 */
	public ExamVO selectExam(ExamVO examVO) throws Exception{
		return examMapper.selectExam(examVO);
	}

	/**
	 * 시험을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 */
	public int updateExam(ExamVO examVO) throws Exception{
		return examMapper.updateExam(examVO);
	}

	/**
	 * 시험을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 */
	public int insertExam(ExamVO examVO) throws Exception {
		return examMapper.insertExam(examVO);
	}
	
	/**
	 * 시험을 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 */
	public int deleteExam(ExamVO examVO)  throws Exception {
		// 시험 삭제
		return examMapper.deleteExam(examVO);
	}

}
