package kr.co.codemaker.admin.chart.vo;
/**
* LessonVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 강의 매출 내역을 조회하기 위한 VO
*
 */
public class LessonVO {

	private String lesState;	//강의상태
	private String lesId;		//강의ID
	private String lesCont;		//강의소개
	private String subId;		//과목ID
	private String lesNm;		//강의명
	private String tchId;		//강사ID
	private String lesTerm;		//강의기간
	private String lesCash;		//강의수강료
	
	public void setLesState(String lesState) {
		this.lesState = lesState; 
	}
	public String getLesState() {
		return lesState; 
	}
	public void setLesId(String lesId) {
		this.lesId = lesId; 
	}
	public String getLesId() {
		return lesId; 
	}
	public void setLesCont(String lesCont) {
		this.lesCont = lesCont; 
	}
	public String getLesCont() {
		return lesCont; 
	}
	public void setSubId(String subId) {
		this.subId = subId; 
	}
	public String getSubId() {
		return subId; 
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm; 
	}
	public String getLesNm() {
		return lesNm; 
	}
	public void setTchId(String tchId) {
		this.tchId = tchId; 
	}
	public String getTchId() {
		return tchId; 
	}
	public void setLesTerm(String lesTerm) {
		this.lesTerm = lesTerm; 
	}
	public String getLesTerm() {
		return lesTerm; 
	}
	public void setLesCash(String lesCash) {
		this.lesCash = lesCash; 
	}
	public String getLesCash() {
		return lesCash; 
	}

}
