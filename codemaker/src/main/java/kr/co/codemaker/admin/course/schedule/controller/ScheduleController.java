package kr.co.codemaker.admin.course.schedule.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.admin.course.schedule.service.ScheduleService;
import kr.co.codemaker.admin.course.schedule.vo.ScheduleVO;
import kr.co.codemaker.admin.vo.AdminVO;

/**
 * 
* ScheduleController.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 8.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Controller
public class ScheduleController {
	
	@Resource(name = "scheduleService")
	private ScheduleService scheduleService;
	
	/**
	 * 전체 스케줄 정보를 가져오는 메서드 - 관리자
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping("/admin/selectAdminAllSchedule")
	public String selectAdminAllSchedule(Model model) {
		List<ScheduleVO> scheduleList = null;
		try {
			scheduleList = scheduleService.selectAllSchedule();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scheduleList", scheduleList);
		
		JSONArray jarray = new JSONArray();
		for(ScheduleVO scheduleVO : scheduleList) {
			JSONObject sobj = new JSONObject();
			sobj.put("title", scheduleVO.getSchCont());
			sobj.put("start", scheduleVO.getSchSfdate());
			sobj.put("end", scheduleVO.getSchEfdate());
			sobj.put("id", scheduleVO.getSchId());
			
			jarray.add(sobj);
		}
		model.addAttribute("jarray", jarray);
		
		return "adminPage/admin/main/adminMain";
	}
	
	/**
	 * 스케줄을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	@RequestMapping("/admin/insertSchedule")
	public String insertSchedule(ScheduleVO scheduleVO, HttpSession session) {
		String adminId = ((AdminVO)session.getAttribute("S_ADMIN")).getAdminId();
		scheduleVO.setAdminId(adminId);
		
		String schAllday = scheduleVO.getSchAllday();
		if(schAllday == null) {
			scheduleVO.setSchAllday("false");
		}
		
		try {
			scheduleService.insertSchedule(scheduleVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/selectAdminAllSchedule";
	}
	
	/**
	 * 스케줄을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	@RequestMapping("/admin/updateSchedule")
	public String updateSchedule(ScheduleVO scheduleVO, HttpSession session) {
		String adminId = ((AdminVO)session.getAttribute("S_ADMIN")).getAdminId();
		scheduleVO.setAdminId(adminId);
		
		String schAllday = scheduleVO.getSchAllday();
		if(schAllday == null) {
			scheduleVO.setSchAllday("false");
		}
		
		try {
			scheduleService.updateSchedule(scheduleVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/selectAdminAllSchedule";
	}
	
	/**
	 * 스케줄을 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	@RequestMapping("/admin/deleteSchedule")
	public String deleteSchedule(ScheduleVO scheduleVO) {
		try {
			scheduleService.deleteSchedule(scheduleVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/selectAdminAllSchedule";
	}

}
