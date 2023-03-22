package kr.co.codemaker.teacher.course.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.course.exam.vo.ExamVO;
import kr.co.codemaker.teacher.course.exam.vo.LessonVO;
import kr.co.codemaker.teacher.course.exam.vo.SubjectVO;

/**
 * 
* ExamMapper.java
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
@Mapper("examMapper")
public interface ExamMapper {
	
	/**
	 * 과목을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param subjectVO
	 * @return
	 * @throws Exception
	 */
	public List<SubjectVO> selectAllSubject(SubjectVO subjectVO) throws Exception;
	
	/**
	 * 강의을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param lessonVO
	 * @return
	 * @throws Exception
	 */
	public List<LessonVO> selectAllLesson(LessonVO lessonVO) throws Exception;
	
	/**
	 * 자신이 출제한 시험 문제를 전체 조회하는 메서드 
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public List<ExamVO> selectAllExam(ExamVO examVO) throws Exception;
	
	/**
	 * 자신이 출제한 시험 문제 전체수를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public int selectTotalCntExam(ExamVO examVO) throws Exception;
	
	/**
	 * 해당 시험을 조회하는 메서드
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public ExamVO selectExam(ExamVO examVO) throws Exception;
	
	/**
	 * 시험을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public int updateExam(ExamVO examVO) throws Exception;
	
	/**
	 * 시험을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public int insertExam(ExamVO examVO) throws Exception;
	
	/**
	 * 시험을 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public int deleteExam(ExamVO examVO) throws Exception;
	
}
