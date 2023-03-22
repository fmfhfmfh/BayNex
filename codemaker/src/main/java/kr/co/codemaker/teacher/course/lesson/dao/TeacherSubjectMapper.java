package kr.co.codemaker.teacher.course.lesson.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.course.lesson.vo.SubjectVO;

/**
 * TeacherSubjectMapper.java
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
@Mapper("TeacherSubjectMapper")
public interface TeacherSubjectMapper {
	
	List<SubjectVO> selectSubject() throws Exception;		// 과목 조회

	
}
