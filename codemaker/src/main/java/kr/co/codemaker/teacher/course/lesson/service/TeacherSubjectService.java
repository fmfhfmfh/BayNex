package kr.co.codemaker.teacher.course.lesson.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.course.lesson.dao.TeacherSubjectMapper;
import kr.co.codemaker.teacher.course.lesson.vo.SubjectVO;

/**
 * TeacherSubjectService.java
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
@Service("TeacherSubjectService")
public class TeacherSubjectService {
	
	@Resource(name="TeacherSubjectMapper")
	private TeacherSubjectMapper subjectMapper;
	
	
	public List<SubjectVO> selectSubject() throws Exception{
		return subjectMapper.selectSubject();
	}

	
}
