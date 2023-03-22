package kr.co.codemaker.user.lessoninfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.signup.vo.TeacherVO;
import kr.co.codemaker.user.lessoninfo.dao.LessonMapper;
import kr.co.codemaker.user.lessoninfo.vo.LessonVO;
import kr.co.codemaker.user.lessoninfo.vo.PayVO;

/**
 * UserLessonController.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 19.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
@Service("userLessonService")
public class LessonService{
	
	@Resource(name="userLessonMapper")
	private LessonMapper lessonMapper;
	
	
	
	public List<LessonVO> selectLesson() throws Exception {
			return lessonMapper.selectLesson();
	}
	
	public LessonVO selectDetailLesson(LessonVO lessonVO) throws Exception{
		return lessonMapper.selectDetailLesson(lessonVO);
	}
	
	public TeacherVO selectTeacher(String lesId) throws Exception{
		return lessonMapper.selectTeacher(lesId);
	}
	
	public PayVO selectPay(PayVO payVO) throws Exception{
		return lessonMapper.selectPay(payVO);
	}
}
