package kr.co.codemaker.teacher.signup.vo;

import java.util.Date;

import kr.co.codemaker.common.vo.BaseVO;

public class TeacherVO extends BaseVO{
	private String tchId;		//선생님아이디
	private String tchPass;    //선생님비밀번호
	private String tchNm;      //선생님이름
	private String tchTel;     //선생님전화번호
	private String tchProfile; //선생님프로필
	private Date tchJoin;    //선생님입사일
	private Date tchRetire;  //선생님퇴사일
	private String tchIntro;   //선생님소개말
	private String tchCode;    //가입인증코드
	private String tchGn;      //기업구분자
	private String resId;      //이력서아이디
	private String comId;      //기업아이디
	public TeacherVO() {
	}
	
	public TeacherVO(String tchId) {
		super();
		this.tchId = tchId;
	}

	public TeacherVO(String tchId, String tchPass, String tchNm, String tchTel, String tchProfile, String tchIntro,
			String tchCode, String tchGn, String resId, String comId) {
		super();
		this.tchId = tchId;
		this.tchPass = tchPass;
		this.tchNm = tchNm;
		this.tchTel = tchTel;
		this.tchProfile = tchProfile;
		this.tchIntro = tchIntro;
		this.tchCode = tchCode;
		this.tchGn = tchGn;
		this.resId = resId;
		this.comId = comId;
	}

	public String getTchId() {
		return tchId;
	}
	public void setTchId(String tchId) {
		this.tchId = tchId;
	}
	public String getTchPass() {
		return tchPass;
	}
	public void setTchPass(String tchPass) {
		this.tchPass = tchPass;
	}
	public String getTchNm() {
		return tchNm;
	}
	public void setTchNm(String tchNm) {
		this.tchNm = tchNm;
	}
	public String getTchTel() {
		return tchTel;
	}
	public void setTchTel(String tchTel) {
		this.tchTel = tchTel;
	}
	public String getTchProfile() {
		return tchProfile;
	}
	public void setTchProfile(String tchProfile) {
		this.tchProfile = tchProfile;
	}
	public Date getTchJoin() {
		return tchJoin;
	}
	public void setTchJoin(Date tchJoin) {
		this.tchJoin = tchJoin;
	}
	public Date getTchRetire() {
		return tchRetire;
	}
	public void setTchRetire(Date tchRetire) {
		this.tchRetire = tchRetire;
	}
	public String getTchIntro() {
		return tchIntro;
	}
	public void setTchIntro(String tchIntro) {
		this.tchIntro = tchIntro;
	}
	public String getTchCode() {
		return tchCode;
	}
	public void setTchCode(String tchCode) {
		this.tchCode = tchCode;
	}
	public String getTchGn() {
		return tchGn;
	}
	public void setTchGn(String tchGn) {
		this.tchGn = tchGn;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	

}
