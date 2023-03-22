package kr.co.codemaker.admin.chart.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.chart.vo.LessonChartVO;
import kr.co.codemaker.admin.chart.vo.PayVO;
import kr.co.codemaker.admin.chart.vo.TeacherChartVO;
import kr.co.codemaker.admin.chart.vo.TeacherPayVO;
import kr.co.codemaker.common.vo.PageVo;

/**
* ChartMapper.java
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
@Mapper("chartMapper")
public interface ChartMapper {

	/**
	 * 강의별 매출 내역조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	List<PayVO> selectLessonPay(PageVo pageVo)throws Exception;

	/**
	 * 강의별 매출 내역 조회 시 목록 총 갯수 조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	int selectTotalCnt(PageVo pageVo)throws Exception;

	/**
	 * 강의별 매출 통계 조회(Excel)
	 * @return
	 * @throws Exception
	 */
	List<PayVO> lessonPayExcel()throws Exception;

	/**
	 * 강의별 매출 통계 조회(Chart)
	 * @return
	 * @throws Exception
	 */
	List<LessonChartVO> lessonPayTotal(String selectYear)throws Exception;

	/**
	 * 강사별 매출 내역 조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	List<TeacherPayVO> selectTeacherPay(PageVo pageVo)throws Exception;

	/**
	 * 강사별 매출 내역 조회시 목록 총 갯수 조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	int teacherPayCnt(PageVo pageVo)throws Exception;

	/**
	 * 강사별 매출 통계 조회(Excel)
	 * @return
	 * @throws Exception
	 */
	List<TeacherPayVO> teacherPayExcel()throws Exception;

	/**
	 * 강사별 매출 통계 조회(Chart)
	 * @return
	 * @throws Exception
	 */
	List<TeacherChartVO> teacherPayTotal(String selectYear)throws Exception;

	/**
	 * 강의별 학생 수 내역 조회
	 * @return
	 * @throws Exception
	 */
	List<TeacherChartVO> lessonUserCnt()throws Exception;

	/**
	 * 강의별 학생수 조회(Chart)
	 * @return
	 * @throws Exception
	 */
	int lessonUserTotal()throws Exception;

}
