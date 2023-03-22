package kr.co.codemaker.admin.course.subject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.course.subject.dao.AdminSubjectMapper;
import kr.co.codemaker.admin.course.subject.vo.SubjectVO;

/**
 * AdminSubjectService.java
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
@Service("adminSubjectService")
public class AdminSubjectService {
	
	@Resource(name="adminSubjectMapper")
	private AdminSubjectMapper adminSubjectMappser;
	
	public List<SubjectVO> selectAllSubject(SubjectVO subjectVO) throws Exception{
		return adminSubjectMappser.selectAllSubject(subjectVO);
	}
	
	public int insertSubject(SubjectVO subjectVO) throws Exception{
		return adminSubjectMappser.insertSubject(subjectVO);
	}
	
	public int updateSubject(SubjectVO subjectVO) throws Exception{
		return adminSubjectMappser.updateSubject(subjectVO);
	}
	
	public int deleteSubject(SubjectVO subjectVO) throws Exception{
		return adminSubjectMappser.deleteSubject(subjectVO);
	}

}
