package kr.co.codemaker.admin.teacher.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class LessonVO extends BaseVO{

	private String lesState;	//강의상태
	private String lesId;		//강의아이디
	private String lesCont;		//강의소개
	private String subId;		//과목아이디
	private String lesNm;		//강의명
	private String tchId;		//선생님아이디
	private int lesTerm;		//강의기간
	private int lesCash;		//강의료
	private String subNm;		//과목명 => 과목테이블
	
	public String getSubNm() {
		return subNm;
	}
	public void setSubNm(String subNm) {
		this.subNm = subNm;
	}
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
	public void setLesTerm(int lesTerm) {
		this.lesTerm = lesTerm; 
	}
	public int getLesTerm() {
		return lesTerm; 
	}
	public void setLesCash(int lesCash) {
		this.lesCash = lesCash; 
	}
	public int getLesCash() {
		return lesCash; 
	}

}
