package kr.co.codemaker.admin.teacher.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.teacher.dao.AdminTeacherMapper;
import kr.co.codemaker.admin.teacher.vo.LessonVO;
import kr.co.codemaker.admin.teacher.vo.ResumeVO;
import kr.co.codemaker.admin.teacher.vo.TeacherVO;

/**
* AdminTeacherService.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 14.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 관리자 선생님 정보 조회
*
 */
@Service("adminTeacherService")
public class AdminTeacherService {

	@Resource(name="adminTeacherMapper")
	private AdminTeacherMapper adminTeacherMapper;
	
	public List<TeacherVO> selectAllTeacher(TeacherVO teacherVo) throws Exception{
		return adminTeacherMapper.selectAllTeacher(teacherVo);
	}
	
	public TeacherVO selectTeacher(TeacherVO teacherVo) throws Exception{
		return adminTeacherMapper.selectTeacher(teacherVo);
	}
	
	public ResumeVO selectResume(ResumeVO resumeVo) throws Exception{
		return adminTeacherMapper.selectResume(resumeVo);
	}
	
	public List<LessonVO> selectLesson(LessonVO lessonVo) throws Exception{
		return adminTeacherMapper.selectLesson(lessonVo);
	}
}
