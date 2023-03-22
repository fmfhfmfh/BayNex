package kr.co.codemaker.admin.teacher.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.admin.teacher.service.AdminTeacherService;
import kr.co.codemaker.admin.teacher.vo.LessonVO;
import kr.co.codemaker.admin.teacher.vo.ResumeVO;
import kr.co.codemaker.admin.teacher.vo.TeacherVO;

@Controller
public class AdminTeacherController {
	private static final Logger logger = LoggerFactory.getLogger(AdminTeacherController.class);
	
	@Resource(name="adminTeacherService")
	private AdminTeacherService adminTeacherService;
	
	@RequestMapping(path="/admin/selectAllTeacher")
	public String selectAllTeacherView(Model model,@RequestParam(name="gubun", required = false) String gubun) {
		List<TeacherVO> teacherList = null;
		TeacherVO teacherVo = new TeacherVO();
		if(gubun != null && gubun != "") {
			if(gubun.equals("1")) {
				teacherVo.setTchGn("N");
			}else if(gubun.equals("2")) {
				teacherVo.setTchGn("Y");
			}
			try {teacherList = adminTeacherService.selectAllTeacher(teacherVo);} catch (Exception e) {e.printStackTrace();}
			model.addAttribute("teacherList", teacherList);
			return "/admin/teacher/searchTeacher";
		}
		try {teacherList = adminTeacherService.selectAllTeacher(teacherVo);} catch (Exception e) {e.printStackTrace();}
		model.addAttribute("teacherList", teacherList);
		return "adminPage/admin/teacher/selectTeacherInfo";
	}
	
	@RequestMapping(path="/admin/selectTeacher")
	public String selectTeacherView(String tchId, Model model) {
		TeacherVO tvo = new TeacherVO(tchId);
		TeacherVO teacherVo = null;
		ResumeVO rvo = new ResumeVO();
		ResumeVO resumeVo = null;
		LessonVO lvo = new LessonVO();
		List<LessonVO> lessonList = null;
		try {
			teacherVo = adminTeacherService.selectTeacher(tvo);	//선생님 정보 조회
			rvo.setResCode(teacherVo.getTchCode());
			resumeVo = adminTeacherService.selectResume(rvo);	//이력서 정보 조회
			lvo.setTchId(teacherVo.getTchId());
			lessonList = adminTeacherService.selectLesson(lvo);	//담당 과목 조회
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("lessonList", lessonList);
		model.addAttribute("teacherVo", teacherVo);
		model.addAttribute("resumeVo", resumeVo);
		return "adminPage/admin/teacher/detailSelectTeacher";
	}
	
	//상세조회에서 이미지 처리
	@RequestMapping(path="/admin/teacherImg")
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
