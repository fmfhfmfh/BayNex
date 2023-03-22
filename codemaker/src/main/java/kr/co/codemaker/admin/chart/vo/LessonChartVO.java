package kr.co.codemaker.admin.chart.vo;
/**
* LessonChartVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 강의별 매출 통계 차트를 조회하기 위한 VO
*
 */
public class LessonChartVO {

	private String lesId;	//강의ID
	private String result;	//매출통계
	
	public void setLesId(String lesId) {
		this.lesId = lesId; 
	}
	public String getLesId() {
		return lesId; 
	}
	public void setResult(String result) {
		this.result = result; 
	}
	public String getResult() {
		return result; 
	}
	
	@Override
	public String toString() {
		return "LessonChartVO [lesId=" + lesId + ", result=" + result + "]";
	}

}
