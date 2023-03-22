package kr.co.codemaker.admin.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.user.dao.AdminUserMapper;
import kr.co.codemaker.admin.user.vo.UserVO;

@Service("adminUserService")
public class AdminUserService {

	@Resource(name="adminUserMapper")
	private AdminUserMapper adminUserMapper;
	
	public List<UserVO> selectAllUser(UserVO userVO) throws Exception{
		return adminUserMapper.selectAllUser(userVO);
	}
}
