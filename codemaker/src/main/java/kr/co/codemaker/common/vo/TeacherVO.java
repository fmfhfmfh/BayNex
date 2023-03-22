package kr.co.codemaker.common.vo;

import java.util.Date;

public class TeacherVO extends BaseVO {
	
	private String tchId;
	private String tchPass;
	private String tchNm;
	private String tchTel;
	private String tchProfile;
	private Date tchJoin;
	private Date tchRetire;
	private String tchIntro;
	private String tchCode;
	private String tchGn;
	private String resId;
	private String comId;
	
	
	public TeacherVO() {
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
	@Override
	public String toString() {
		return "TeacherVO [tchId=" + tchId + ", tchPass=" + tchPass + ", tchNm=" + tchNm + ", tchTel=" + tchTel
				+ ", tchProfile=" + tchProfile + ", tchJoin=" + tchJoin + ", tchRetire=" + tchRetire + ", tchIntro="
				+ tchIntro + ", tchCode=" + tchCode + ", tchGn=" + tchGn + ", resId=" + resId + ", comId=" + comId
				+ "]";
	}
	
	
}
