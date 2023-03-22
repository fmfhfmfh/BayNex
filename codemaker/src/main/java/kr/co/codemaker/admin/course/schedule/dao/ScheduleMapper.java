package kr.co.codemaker.admin.course.schedule.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.course.schedule.vo.ScheduleVO;

/**
 * 
* ScheduleMapper.java
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
@Mapper("scheduleMapper")
public interface ScheduleMapper {
	
	/**
	 * 전체 스케줄 정보를 가져오는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<ScheduleVO> selectAllSchedule() throws Exception;
	
	/**
	 * 스케줄을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	public int insertSchedule(ScheduleVO scheduleVO) throws Exception;
	
	/**
	 * 스케줄을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	public int updateSchedule(ScheduleVO scheduleVO) throws Exception;
	
	/**
	 * 스케줄을 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param scheduleVO
	 * @return
	 */
	public int deleteSchedule(ScheduleVO scheduleVO) throws Exception;

	
}
