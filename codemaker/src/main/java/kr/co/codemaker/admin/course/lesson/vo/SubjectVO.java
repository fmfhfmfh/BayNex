package kr.co.codemaker.admin.course.lesson.vo;

/**
 * 
* SubjectVO.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 4.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
public class SubjectVO {

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
