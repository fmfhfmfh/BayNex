package kr.co.codemaker.teacher.course.exam.vo;


import kr.co.codemaker.common.vo.BaseVO;

public class SubjectVO extends BaseVO{

	private String subOut;	// 과목 삭제 여부
	private String subNm;	// 과목명
	private String subId;	// 과목아이디
	
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
