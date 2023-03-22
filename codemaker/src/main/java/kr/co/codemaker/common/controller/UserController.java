package kr.co.codemaker.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.codemaker.common.service.UserService;
import kr.co.codemaker.common.vo.UserVO;
/**
* UserController.java
*
* @author 우송이
* @version 1.0
* @see 2020. 12.
*
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 회원가입
*
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	
	@RequestMapping("/join/insertUserView")
	public String insertUserView() {
		
		return "mainT/user/signup/signtest";
	}
	
	/**
	 * 회원가입
	 * @param userVo
	 * @param file
	 * @return
	 */
	@RequestMapping("/join/insertUser")
	public String insertUser(UserVO userVo, MultipartFile file) {
		
		//프로필사진등록
		String fileName = UUID.randomUUID().toString();

		File uploadFile = new File("d:\\upload\\" + file.getOriginalFilename());
		if (file.getSize() > 0) {
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		userVo.setUserProfile("d:\\upload\\" + file.getOriginalFilename());
		
		int insertCnt = 0;
		int poinsertCnt = 0; 
		
		try {
			insertCnt = userService.insertUser(userVo);

			if (insertCnt == 1) { //회원가입을 성공했으면 포인트를 기본값 0으로 셋팅해주기 위해 insert해준다.
				String userId = userVo.getUserId();
				poinsertCnt = userService.joinPoint(userId);
				
				//회원가입 성공시 리턴
				return "mainT/user/signup/success"; 
			}

		} catch (Exception e) {
		}


		return "mainT/user/signup/signtest";
	}
	
	
	/**
	 * 회원가입 ID중복체크
	 * @param userVo
	 * @return
	 */
    @ResponseBody
    @RequestMapping("/join/idchk")
    public String idchk(UserVO userVo) {
        int result=0;
        
		try {
			result = userService.idchk(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if(result == 1) { //결과 값이 있으면 아이디 존재 -> 1리턴
            return "1";
        } else {          //없으면 아이디 존재하지 않음 -> 0리턴
            return "0";
        }
    }
    
    
}
