package kr.co.codemaker.user.lessoninfo.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.lessoninfo.vo.SubjectVO;

/**
 * UserLessonController.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 8. ???????언제지?
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
@Mapper("userSubjectMapper")
public interface UserSubjectMapper {
	
	List<SubjectVO> selectSubject() throws Exception;

}
