package kr.co.codemaker.teacher.schedule.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.schedule.vo.ScheduleVO;

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
@Mapper("scheduleTeacherMapper")
public interface ScheduleTeacherMapper {
	
	/**
	 * 전체 스케줄 정보를 가져오는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<ScheduleVO> selectAllSchedule() throws Exception;
	
	
}
