package kr.co.codemaker.teacher.schedule.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.schedule.dao.ScheduleTeacherMapper;
import kr.co.codemaker.teacher.schedule.vo.ScheduleVO;

/**
 * 
* ScheduleService.java
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
@Service("ScheduleTeacherService")
public class ScheduleTeacherService {
	
	@Resource(name = "scheduleTeacherMapper")
	private ScheduleTeacherMapper scheduleTeacherMapper;
	
	/**
	 * 전체 스케줄 정보를 가져오는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<ScheduleVO> selectAllSchedule() throws Exception{
		return scheduleTeacherMapper.selectAllSchedule();
	}
	

}
