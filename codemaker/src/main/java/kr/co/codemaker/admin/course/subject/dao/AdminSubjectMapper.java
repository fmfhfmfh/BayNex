package kr.co.codemaker.admin.course.subject.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.course.subject.vo.SubjectVO;

/**
 * AdminSubjectMapper.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 8.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
@Mapper("adminSubjectMapper")
public interface AdminSubjectMapper {
	List<SubjectVO> selectAllSubject(SubjectVO subjectVO) throws Exception;		// 과목 전체 조회
	
	int insertSubject(SubjectVO subjectVO) throws Exception;	// 과목 등록
	
	int updateSubject(SubjectVO subjectVO) throws Exception; 	// 과목 수정
	
	int deleteSubject(SubjectVO subjectVO) throws Exception;	// 과목 삭제

	
	

}
