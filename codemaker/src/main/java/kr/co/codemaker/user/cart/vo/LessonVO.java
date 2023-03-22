package kr.co.codemaker.user.cart.vo;

import java.util.Date;
import java.util.List;

import kr.co.codemaker.common.vo.BaseVO;

public class LessonVO {

	private String lesId;      //강의아이디
	private String lesNm;      //강의명
	private String lesCont;    //강의소개
	private String lesState;   //강의상태
	private int lesCash;    //강의수강료
	private int lesTerm;    //강의기간
	private String tchId;      //선생님아이디
	private String subId;		//과목아이디
	private String tchNm;	//선생님 이름
	private Date lesDate;	//강의 기간 , 필요에의해 만든 필드
	
	public Date getLesDate() {
		return lesDate;
	}

	public void setLesDate(Date lesDate) {
		this.lesDate = lesDate;
	}
	private List<LessonVO> lessonList;

	public List<LessonVO> getLessonList() {
		return lessonList;
	}

	public void setLessonList(List<LessonVO> lessonList) {
		this.lessonList = lessonList;
	}

	public LessonVO(String lesId) {
		this.lesId = lesId;
	}
	
	public LessonVO() {
	}
	public LessonVO(String lesId, int lesCash, int lesTerm) {
		super();
		this.lesId = lesId;
		this.lesCash = lesCash;
		this.lesTerm = lesTerm;
	}
	
	public String getTchNm() {
		return tchNm;
	}
	public void setTchNm(String tchNm) {
		this.tchNm = tchNm;
	}
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public String getLesNm() {
		return lesNm;
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm;
	}
	public String getLesCont() {
		return lesCont;
	}
	public void setLesCont(String lesCont) {
		this.lesCont = lesCont;
	}
	public String getLesState() {
		return lesState;
	}
	public void setLesState(String lesState) {
		this.lesState = lesState;
	}
	public int getLesCash() {
		return lesCash;
	}
	public void setLesCash(int lesCash) {
		this.lesCash = lesCash;
	}
	public int getLesTerm() {
		return lesTerm;
	}
	public void setLesTerm(int lesTerm) {
		this.lesTerm = lesTerm;
	}
	public String getTchId() {
		return tchId;
	}
	public void setTchId(String tchId) {
		this.tchId = tchId;
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	@Override
	public String toString() {
		return "LessonVO [lesId=" + lesId + ", lesNm=" + lesNm + ", lesCont=" + lesCont + ", lesState=" + lesState
				+ ", lesCash=" + lesCash + ", lesTerm=" + lesTerm + ", tchId=" + tchId + ", subId=" + subId + "]";
	}
	
}
