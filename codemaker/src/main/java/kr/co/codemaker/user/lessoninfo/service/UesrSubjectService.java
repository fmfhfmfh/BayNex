package kr.co.codemaker.user.lessoninfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.lessoninfo.dao.UserSubjectMapper;
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
@Service("userSubjectService")
public class UesrSubjectService {
	
	@Resource(name="userSubjectMapper")
	private UserSubjectMapper subjectMapper;
	
	
	public List<SubjectVO> selectSubject(){
		try {
			return subjectMapper.selectSubject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
