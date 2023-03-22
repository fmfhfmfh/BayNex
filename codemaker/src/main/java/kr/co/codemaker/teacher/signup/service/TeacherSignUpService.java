package kr.co.codemaker.teacher.signup.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.signup.dao.TeacherSignUpMapper;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
* TeacherSignUpService.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 2.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 선생님 회원가입 서비스 최초작성
*
 */
@Service("teacherSignUpService")
public class TeacherSignUpService {
	private static final Logger logger = LoggerFactory.getLogger(TeacherSignUpService.class);
	
	@Resource(name="teacherSignUpMapper")
	private TeacherSignUpMapper teacherMapper;
	
	public int insertTeacher(TeacherVO teacherVo) throws Exception {
		return teacherMapper.insertTeacher(teacherVo);
	}
	
	public ResumeVO selectResume(ResumeVO resumeVo) throws Exception {
		return teacherMapper.selectResume(resumeVo);
	}
	
	public TeacherVO tchIdChk(TeacherVO teacherVo) throws Exception {
		return teacherMapper.tchIdChk(teacherVo);
	}
}
