package kr.co.codemaker.teacher.schedule.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.teacher.schedule.service.ScheduleTeacherService;
import kr.co.codemaker.teacher.schedule.vo.ScheduleVO;

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
public class ScheduleTeacherController {
	
	@Resource(name = "ScheduleTeacherService")
	private ScheduleTeacherService scheduleTeacherService;
	
	/**
	 * 전체 스케줄 정보를 가져오는 메서드 - 선생님
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping("/admin/selectTeacherAllSchedule")
	public String selectTeacherAllSchedule(Model model) {
		List<ScheduleVO> scheduleList = null;
		try {
			scheduleList = scheduleTeacherService.selectAllSchedule();
			
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
		
		return "teacherPage/teacher/main/teacherMain";
	}
	
}
