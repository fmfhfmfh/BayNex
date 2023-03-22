package kr.co.codemaker.teacher.info.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.codemaker.admin.teacher.vo.LessonVO;
import kr.co.codemaker.common.util.MkDir;
import kr.co.codemaker.teacher.info.service.TeacherService;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

@Controller
public class TeacherController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@Resource(name="teacherService")
	private TeacherService teacherService;
	
//	@RequestMapping(path="/teacher/selectTeacher", method=RequestMethod.GET)
//	public String selectViewTeacher() {
//		
//		return "";
//	}
	@RequestMapping(path="/teacher/selectTeacher")
	public String selectTeacher(String tchId, Model model) {
		
		TeacherVO teacherVo = new TeacherVO();
		teacherVo.setTchId(tchId);
		ResumeVO resumeVo = new ResumeVO();
		List<LessonVO> lessonList = new ArrayList<>();
		
		try {
			teacherVo = teacherService.selectTeacher(teacherVo);
			resumeVo = teacherService.selectResume(teacherVo.getResId());
			lessonList = teacherService.selectAllLesson(teacherVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("-----------------------{}", lessonList);
		
		model.addAttribute("teacherVo", teacherVo);
		model.addAttribute("resumeVo", resumeVo);
		model.addAttribute("lessonList", lessonList);
		
		return "teacherPage/teacher/mypage/teacher";
	}
	
	@RequestMapping(path="/teacher/updateTeacher", method=RequestMethod.GET)
	public String updateViewTeacher(String tchId, Model model) {
		
		TeacherVO teacherVo = new TeacherVO();
		teacherVo.setTchId(tchId);
		ResumeVO resumeVo = new ResumeVO();
		List<LessonVO> lessonList = new ArrayList<>();
		
		try {
			teacherVo = teacherService.selectTeacher(teacherVo);
			resumeVo = teacherService.selectResume(teacherVo.getResId());
			lessonList = teacherService.selectAllLesson(teacherVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("-----------------------{}", lessonList);
		
		model.addAttribute("teacherVo", teacherVo);
		model.addAttribute("resumeVo", resumeVo);
		model.addAttribute("lessonList", lessonList);
		
		return "teacherPage/teacher/mypage/teacherUpdate";
	}
	
	@RequestMapping(path="/teacher/updateTeacher", method=RequestMethod.POST)
	public String updateTeacher(TeacherVO teacherVo, @RequestParam(name="profile") MultipartFile file, HttpSession session ) {
		
		
		
		MkDir dir = new MkDir();
		dir.mkdirTeacher();	//아래 해당하는 경로에 폴더가 없을시 폴더 생성 하는 클래스
		Path path = Paths.get("C:","file","teacher","profile",file.getOriginalFilename());	//파일구분자를 운영체제에 맞게 잡아줌
		File fileUpload = path.toFile();
		if(file.getSize() > 0) {
			try {
				file.transferTo(fileUpload);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			teacherVo.setTchProfile(path.toString());
		}else {
			TeacherVO tchVo = new TeacherVO();
			try {
				tchVo = teacherService.selectTeacher(teacherVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			teacherVo.setTchProfile(tchVo.getTchProfile());
		}
		
		try {
			teacherService.updateTeacher(teacherVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TeacherVO tv = new TeacherVO();
		try {
			tv = teacherService.selectTeacher(teacherVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("S_TEACHER", tv);
		
		return "redirect:/teacher/selectTeacher?tchId="+teacherVo.getTchId();
	}
	
	@RequestMapping(path="/teacher/teacherUpImg")
	public void imgView(String tchProfile, HttpServletResponse response) throws IOException {
		response.setContentType("image");
		FileInputStream fis = new FileInputStream(tchProfile);
		ServletOutputStream sos = response.getOutputStream();
		byte[] buffer = new byte[512];
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		fis.close();
		sos.flush();
		sos.close();
	}
}
