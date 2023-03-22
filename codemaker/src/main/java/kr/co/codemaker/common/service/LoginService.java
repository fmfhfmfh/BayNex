package kr.co.codemaker.common.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.vo.AdminVO;
import kr.co.codemaker.common.dao.LoginMapper;
import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
* LoginService.java
*
* @author 최민준
* @version 1.0
* @since 2020. 11. 30.
* 수정자 수정내용
* ------ ------------------------
* 최민준  최초작성
*
 */
@Service("loginService")
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Resource(name="loginMapper")
	private LoginMapper loginMapper;
	
	public UserVO selectUser(String userId) throws Exception {
		return loginMapper.selectUser(userId);
	}
	
	public UserVO findUserInfo(UserVO userVo) throws Exception{
		return loginMapper.findUserInfo(userVo);
	}
	
	public int updateUserPass(UserVO userVo) throws Exception {
		return loginMapper.updateUserPass(userVo);
	}

/**
 * 관리자 로그인, 강사 로그인
 * @param adminId, tchId
 * @return
 * @author 이은지
 * @throws Exception
 */
	public AdminVO getAdmin(String adminId) throws Exception{
		logger.debug("관리자 로그인");
		return loginMapper.getAdmin(adminId);
	}
	
	public TeacherVO getTeacher(String tchId) throws Exception{
		return loginMapper.getTeacher(tchId);
	}
}
