package kr.co.codemaker.teacher.signup.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.codemaker.teacher.signup.service.TeacherSignUpService;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
 * @author 최민준
 */
@Controller
public class TeacherSignUpController {
	private static final Logger logger = LoggerFactory.getLogger(TeacherSignUpController.class); 
	
	@Resource(name="teacherSignUpService")
	private TeacherSignUpService tService;
	
	@RequestMapping(path="teacher/signupView")
	public String teacherSignUpView(TeacherVO teacherVO) {
		return "teacher/signup/tSignup";
	}
	
	@RequestMapping(path="teacher/signup")
	public String teacherSignUp(TeacherVO teacherVO, MultipartFile picture) {
		ResumeVO getInfo = null;
		ResumeVO rVo = new ResumeVO(teacherVO.getTchCode());
		try {
			getInfo = tService.selectResume(rVo);
		} catch (Exception e) {e.printStackTrace();}
		
		teacherVO.setTchNm(getInfo.getResNm());
		teacherVO.setTchTel(getInfo.getResTel());
		teacherVO.setTchCode(getInfo.getResCode());
		teacherVO.setTchGn("N");	//기업강사이면 Y 정규강사면 N
		teacherVO.setResId(getInfo.getResId());
		teacherVO.setTchProfile(getInfo.getResProfile());
		
		try {
			tService.insertTeacher(teacherVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/loginView";
	}
	
	@RequestMapping(path="teacher/chkResCode", method=RequestMethod.GET)
	public String chkResCode(@RequestParam(name="resCode") String chkResCode, Model model) {
		ResumeVO resumeVo = new ResumeVO(chkResCode); 
		ResumeVO getResumeVo = null;
		try {
			getResumeVo = tService.selectResume(resumeVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(getResumeVo.getResCode().equals(chkResCode)) {
			model.addAttribute("chkMsg", "success");
			return "jsonView";
		}else {
			model.addAttribute("chkMsg", "fail");
			return "jsonView";
		}
	}
	
	@RequestMapping(path="/teacher/chkId")
	public String chkId(@RequestParam(name="tchId") String tchId, Model model) {
		TeacherVO teacherVo = new TeacherVO(tchId);
		TeacherVO getTVo = null;
		try {
			getTVo = tService.tchIdChk(teacherVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String msg="";
		String color="";
		String pass="";
		if(getTVo == null) {
			msg="사용가능한 아이디 입니다";	// 아이디가 중복이 아니면 ok
			color="blue";
			pass="ok";
		}else {
			msg="이미 사용중인 아이디 입니다";	// 아이디가 중복되면 no
			color="red";
			pass="no";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("color", color);
		model.addAttribute("pass", pass);
		return "jsonView";
	}
}
