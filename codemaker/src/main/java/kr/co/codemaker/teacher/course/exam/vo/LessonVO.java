package kr.co.codemaker.teacher.course.exam.vo;

import java.util.List;

import kr.co.codemaker.common.vo.BaseVO;

/**
 * 
* LessonVO.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 9.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
public class LessonVO extends SubjectVO{

	private String lesState;	// 강의 상태코드
	private String lesId;		// 강의 아이디
	private String lesCont;		// 강의 소개
	private String subId;		// 과목 아이디
	private String lesNm;		// 강의명
	private String tchId;		// 선생님 아이디
	private int lesTerm;		// 강의 기간
	private int lesCash;		// 강의 수강료
	private String subNm;		// 과목명
	
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
