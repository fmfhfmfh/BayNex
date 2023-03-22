package kr.co.codemaker.user.mypage.vo;

import java.util.Date;

import kr.co.codemaker.common.vo.BaseVO;

public class PayLessonInfoVO extends BaseVO{

	private String subNm;		//과목이름
	private String lesNm;		//강의제목
	private Date payDate;		//강의시작일
	private Date cosTerm;		//강의종료일
	private String tchNm;		//선생님이름
	private String userId;		//회원아이디
	private int lesTerm;		//강의기간
	private String lesId;		//강의아이디
	private String lesCont;		//강의내용
	
	public String getLesCont() {
		return lesCont;
	}
	public void setLesCont(String lesCont) {
		this.lesCont = lesCont;
	}
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public int getLesTerm() {
		return lesTerm;
	}
	public void setLesTerm(int lesTerm) {
		this.lesTerm = lesTerm;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setSubNm(String subNm) {
		this.subNm = subNm; 
	}
	public String getSubNm() {
		return subNm; 
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm; 
	}
	public String getLesNm() {
		return lesNm; 
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate; 
	}
	public Date getPayDate() {
		return payDate; 
	}
	public void setCosTerm(Date cosTerm) {
		this.cosTerm = cosTerm; 
	}
	public Date getCosTerm() {
		return cosTerm; 
	}
	public void setTchNm(String tchNm) {
		this.tchNm = tchNm; 
	}
	public String getTchNm() {
		return tchNm; 
	}

}
