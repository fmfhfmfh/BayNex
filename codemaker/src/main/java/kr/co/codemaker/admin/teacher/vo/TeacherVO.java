package kr.co.codemaker.admin.teacher.vo;

import java.util.Date;

import kr.co.codemaker.common.vo.BaseVO;

public class TeacherVO extends BaseVO{

	private String tchGn;		//기업구분자
	private String tchPass;		//비밀번호
	private String tchTel;		//전화번호
	private String tchId;		//아이디
	private String tchCode;		//가입인증코드
	private String resId;		//이력서아이디
	private String tchNm;		//이름
	private Date tchJoin;		//입사일
	private String tchIntro;	//소개말
	private String tchProfile;	//프로필
	private Date tchRetire;		//퇴사일
	private String comId;		//기업아이디
	
	public TeacherVO() {}
	
	public TeacherVO(String tchId) {
		this.tchId = tchId;
	}
	public String getTchProfile() {
		return tchProfile;
	}
	public void setTchProfile(String tchProfile) {
		this.tchProfile = tchProfile;
	}
	public Date getTchRetire() {
		return tchRetire;
	}
	public void setTchRetire(Date tchRetire) {
		this.tchRetire = tchRetire;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public void setTchGn(String tchGn) {
		this.tchGn = tchGn; 
	}
	public String getTchGn() {
		return tchGn; 
	}
	public void setTchPass(String tchPass) {
		this.tchPass = tchPass; 
	}
	public String getTchPass() {
		return tchPass; 
	}
	public void setTchTel(String tchTel) {
		this.tchTel = tchTel; 
	}
	public String getTchTel() {
		return tchTel; 
	}
	public void setTchId(String tchId) {
		this.tchId = tchId; 
	}
	public String getTchId() {
		return tchId; 
	}
	public void setTchCode(String tchCode) {
		this.tchCode = tchCode; 
	}
	public String getTchCode() {
		return tchCode; 
	}
	public void setResId(String resId) {
		this.resId = resId; 
	}
	public String getResId() {
		return resId; 
	}
	public void setTchNm(String tchNm) {
		this.tchNm = tchNm; 
	}
	public String getTchNm() {
		return tchNm; 
	}
	public void setTchJoin(Date tchJoin) {
		this.tchJoin = tchJoin; 
	}
	public Date getTchJoin() {
		return tchJoin; 
	}
	public void setTchIntro(String tchIntro) {
		this.tchIntro = tchIntro; 
	}
	public String getTchIntro() {
		return tchIntro; 
	}

}
