package kr.co.codemaker.user.lessoninfo.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class SubjectVO extends BaseVO{

	private String subOut;
	private String subNm;
	private String subId;
	public void setSubOut(String subOut) {
		this.subOut = subOut; 
	}
	public String getSubOut() {
		return subOut; 
	}
	public void setSubNm(String subNm) {
		this.subNm = subNm; 
	}
	public String getSubNm() {
		return subNm; 
	}
	public void setSubId(String subId) {
		this.subId = subId; 
	}
	public String getSubId() {
		return subId; 
	}

}
