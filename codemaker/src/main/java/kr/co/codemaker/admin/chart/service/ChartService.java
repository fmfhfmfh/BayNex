package kr.co.codemaker.admin.chart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.chart.dao.ChartMapper;
import kr.co.codemaker.admin.chart.vo.LessonChartVO;
import kr.co.codemaker.admin.chart.vo.PayVO;
import kr.co.codemaker.admin.chart.vo.TeacherChartVO;
import kr.co.codemaker.admin.chart.vo.TeacherPayVO;
import kr.co.codemaker.common.vo.PageVo;
/**
* ChartService.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 최초 생성
*
 */
@Service("chartService")
public class ChartService {

	@Resource(name="chartMapper")
	private ChartMapper chartMapper;

	/**
	 * 강의별 매출 내역 조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectLessonPay(PageVo pageVo) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("lesPayList", chartMapper.selectLessonPay(pageVo));
		
		int totalCnt = 0;
		
		totalCnt = chartMapper.selectTotalCnt(pageVo);
		
		
		int pages = (int)Math.ceil((double)totalCnt/5); 
		map.put("pages", pages);
		
		return map;
	}


	/**
	 * 강의별 매출 통계 조회(Excel)
	 * @return
	 * @throws Exception
	 */
	public List<PayVO> lessonPayExcel() throws Exception{
		return chartMapper.lessonPayExcel();
	}

	/**
	 * 강의별 매출 통계 조회(Chart)
	 * @return
	 * @throws Exception
	 */
	public List<LessonChartVO> lessonPayTotal(String selectYear) throws Exception {
		return chartMapper.lessonPayTotal(selectYear);
	}

	/**
	 * 강사별 매출 내역 조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectTeacherPay(PageVo pageVo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("tchPayList", chartMapper.selectTeacherPay(pageVo));
		
		int totalCnt = 0;
		
		totalCnt = chartMapper.teacherPayCnt(pageVo);
		
		int pages = (int)Math.ceil((double)totalCnt/5); 
		map.put("pages", pages);
		
		return map;
	}

	/**
	 * 강사별 매출 통계 조회(Excel)
	 * @return
	 * @throws Exception
	 */
	public List<TeacherPayVO> teacherPayExcel() throws Exception {
		return chartMapper.teacherPayExcel();
	}

	/**
	 * 강사별 매출 통계 조회(Chart)
	 * @return
	 * @throws Exception
	 */
	public List<TeacherChartVO> teacherPayTotal(String selectYear) throws Exception {
		return chartMapper.teacherPayTotal(selectYear);
	}

	/**
	 * 강의별 학생 수 내역 조회
	 * @return
	 * @throws Exception
	 */
	public List<TeacherChartVO> lessonUserCnt() throws Exception {
		return chartMapper.lessonUserCnt();
	}

	/**
	 * 강의별 학생수 조회(Chart)
	 * @return
	 * @throws Exception
	 */
	public int lessonUserTotal() throws Exception {
		return chartMapper.lessonUserTotal();
	}




}
