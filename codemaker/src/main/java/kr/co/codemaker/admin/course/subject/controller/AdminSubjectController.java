package kr.co.codemaker.admin.course.subject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.codemaker.admin.course.subject.service.AdminSubjectService;
import kr.co.codemaker.admin.course.subject.vo.SubjectVO;
import kr.co.codemaker.teacher.course.lesson.controller.TeacherLessonController;

/**
 * AdminSubjectController.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 8.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
@Controller
public class AdminSubjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherLessonController.class);
	@Resource(name="adminSubjectService")
	private AdminSubjectService adminSubjectService;
	
	/**
	 * 관리자 - 과목 전체 조회
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/admin/selectAllSubject")
	public String selectAllSubject(Model model) {
		SubjectVO subjectVO = new SubjectVO();
		List<SubjectVO> subList;
		
		try {
			subList = adminSubjectService.selectAllSubject(subjectVO);
			model.addAttribute("subList", subList);
			return "adminPage/admin/subject/subjectAllSelect";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 관리자 - 과목 등록
	 * @param subNm 과목명
	 * @return
	 */
	@RequestMapping(path="/admin/insertSubject")
	public String insertSubject(String subNm) {
		
		logger.debug("과목이름:{}",subNm);
		SubjectVO subjectVO = new SubjectVO();
		subjectVO.setSubNm(subNm);
		
		try {
			int cnt = adminSubjectService.insertSubject(subjectVO);
			if(cnt ==1 ) {
				return "redirect:/admin/selectAllSubject";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 관리자 - 과목 수정
	 * @param subjectVO
	 * @return
	 */
	@RequestMapping(path="/admin/updateSubject")
	public String updateSubject(SubjectVO subjectVO) {
//		SubjectVO subjectVO = new SubjectVO();
//		String subId, String subNm
		subjectVO.setSubId(subjectVO.getSubId());
		subjectVO.setSubNm(subjectVO.getSubNm());
		
		try {
			int cnt = adminSubjectService.updateSubject(subjectVO);
			if(cnt ==1) {
				return "redirect:/admin/selectAllSubject";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 관리자 - 과목 삭제
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/admin/deleteSubject")
	public String deleteSubject(@RequestParam(value="checkArr[]")List<String> checkArr) {
		logger.debug("과목아디 배열:{}",checkArr);
		String subId;
		SubjectVO subjectVO = new SubjectVO();
		int cnt =0;
		
//		logger.debug("subId:{}",subId);
		try {
			for(int i=0; i<checkArr.size(); i++) {
				subId = checkArr.get(i);
				subjectVO.setSubId(subId);
				cnt = adminSubjectService.deleteSubject(subjectVO);
			}
			logger.debug("cnt:{}",cnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cnt >0) {
			return "redirect:/admin/selectAllSubject";
		}else {
			return null;
		}
	}
	
}
