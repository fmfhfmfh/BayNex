package kr.co.codemaker.admin.course.lesson.dao;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.course.lesson.vo.ExamVO;
import kr.co.codemaker.admin.course.lesson.vo.LessonIndexVO;
import kr.co.codemaker.admin.course.lesson.vo.LessonVO;
import kr.co.codemaker.admin.course.lesson.vo.SubjectVO;

/**
 * 
* AdminLessonMapper.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 4.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Mapper("adminLessonMapper")
public interface AdminLessonMapper {
	
	/**
	 * 등록된 전체 과목을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<LessonVO> selectAgreeCnt(LessonVO lessonVO) throws Exception;
	
	/**
	 * 등록된 요청을 상세조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<LessonVO> selectAllLesson(LessonVO lessonVO) throws Exception;
	
	/**
	 * 강의를 상세조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public LessonVO selectLesson(LessonVO lessonVO) throws Exception;

	
	/**
	 * 선택한 강의에 해당하는 강의목차를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param lessonVO
	 * @return
	 */
	public List<LessonIndexVO> selectLessonIndex(LessonVO lessonVO) throws Exception;
	
	/**
	 * 해당 강의의 상태를 변경하는 메서드
	 * 
	 * @author 김미연
	 * @param lessonVO
	 * @return
	 */
	public int updateLesson(LessonVO lessonVO) throws Exception;

	/**
	 * 해당 시험의 상태를 변경하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 */
	public int updateExam(ExamVO examVO) throws Exception;
	
	
	/**
	 * 선생님 아이디를 가져오는 메서드
	 * @author 박경호
	 * @param lesId 강의 아이디
	 * @return 선생님 아이디
	 * @throws Exception
	 */
	public String selectTeacher(String lesId) throws Exception;
}
