package kr.co.codemaker.admin.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.admin.user.service.AdminUserService;
import kr.co.codemaker.admin.user.vo.UserVO;

@Controller
public class AdminUserController {
	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	@Resource(name="adminUserService")
	private AdminUserService adminUserService;
	
	//관리자페이지의 main.left에서 학생관리 - 정보조회로 이동
	@RequestMapping(path="/admin/selectUserInfo")
	public String selectUserInfoView(Model model,@RequestParam(name="gubun", required = false) String gubun) {
		List<UserVO> userList = null;
		UserVO userVo = new UserVO();
		if(gubun != null && gubun !="") {
			if(gubun.equals("1")) {			//정상회원일때
				userVo.setUserOut("N");
				userVo.setUserBlack("N");
			}else if(gubun.equals("2")) {	//정지회원일때
				userVo.setUserOut("N");
				userVo.setUserBlack("Y");
			}else if(gubun.equals("3")) {	//탈퇴회원일때
				userVo.setUserOut("Y");
				userVo.setUserBlack("N");
			}
			try {userList = adminUserService.selectAllUser(userVo);} catch (Exception e) {e.printStackTrace();}
			model.addAttribute("userList", userList);
			return "/admin/user/searchUser";
		}
			
		try {
			userList = adminUserService.selectAllUser(userVo);	//회원정보 조회
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("userList", userList);
		return "adminPage/admin/user/selectUserInfo";
	}
}
