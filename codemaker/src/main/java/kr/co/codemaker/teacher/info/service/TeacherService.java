package kr.co.codemaker.teacher.info.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.teacher.vo.LessonVO;
import kr.co.codemaker.teacher.info.dao.TeacherMapper;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
* TeacherService.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 23.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Service("teacherService")
public class TeacherService {
	
	@Resource(name="teacherMapper")
	private TeacherMapper teacherMapper;
	
	public int updateTeacher(TeacherVO teacherVo) throws Exception {
		return teacherMapper.updateTeacher(teacherVo);
	}
	
	public TeacherVO selectTeacher(TeacherVO teacherVo) throws Exception {
		return teacherMapper.selectTeacher(teacherVo);
	}
	
	public ResumeVO selectResume(String resId) throws Exception {
		return teacherMapper.selectResume(resId);
	}
	
	public List<LessonVO> selectAllLesson(TeacherVO teacherVo) throws Exception {
		return teacherMapper.selectAllLesson(teacherVo);
	}
}
