package kr.co.codemaker.admin.course.schedule.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.course.schedule.dao.ScheduleMapper;
import kr.co.codemaker.admin.course.schedule.vo.ScheduleVO;

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
@Service("scheduleService")
public class ScheduleService {
	
	@Resource(name = "scheduleMapper")
	private ScheduleMapper scheduleMapper;
	
	/**
	 * 전체 스케줄 정보를 가져오는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<ScheduleVO> selectAllSchedule() throws Exception{
		return scheduleMapper.selectAllSchedule();
	}
	
	/**
	 * 스케줄을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	public int insertSchedule(ScheduleVO scheduleVO) throws Exception{
		return scheduleMapper.insertSchedule(scheduleVO);
	}
	
	/**
	 * 스케줄을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	public int updateSchedule(ScheduleVO scheduleVO) throws Exception{
		return scheduleMapper.updateSchedule(scheduleVO);
	}
	
	/**
	 * 스케줄을 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	public int deleteSchedule(ScheduleVO scheduleVO) throws Exception{
		return scheduleMapper.deleteSchedule(scheduleVO);
	}

}
