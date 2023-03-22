package kr.co.codemaker.admin.chart.vo;
/**
* TeacherChartVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 강의별 학생수, 강사별 매출통계를 조회하기위한 VO
*
 */
public class TeacherChartVO {

	private String tchNm;	//강사명
	private String result;	//매출통계
	private String lesNm;	//강의명
	private String lesId;	//강의ID
	private int cnt;		//강의별학생수
	
	public String getTchNm() {
		return tchNm;
	}
	public void setTchNm(String tchNm) {
		this.tchNm = tchNm;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getLesNm() {
		return lesNm;
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm;
	}
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "TeacherChartVO [tchNm=" + tchNm + ", result=" + result + ", lesNm=" + lesNm + ", lesId=" + lesId
				+ ", cnt=" + cnt + "]";
	}
	
	
}
