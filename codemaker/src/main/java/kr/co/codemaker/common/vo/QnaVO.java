package kr.co.codemaker.common.vo;

import java.util.Date;

/**
* QnaVO.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 1.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
public class QnaVO extends BaseVO{

	private String qnaOut;
	private Date qnaDate;
	private String lesId;
	private String qnaId;
	private String qnaCont;
	private String userId;
	private String qnaTitle;
	
	private String subNm; 	// 과목 이름
	private String lesNm;  // 강의 이름
	
	
	
	public String getSubNm() {
		return subNm;
	}
	public void setSubNm(String subNm) {
		this.subNm = subNm;
	}
	public String getLesNm() {
		return lesNm;
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm;
	}
	public void setQnaOut(String qnaOut) {
		this.qnaOut = qnaOut; 
	}
	public String getQnaOut() {
		return qnaOut; 
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate; 
	}
	public Date getQnaDate() {
		return qnaDate; 
	}
	public void setLesId(String lesId) {
		this.lesId = lesId; 
	}
	public String getLesId() {
		return lesId; 
	}
	public void setQnaId(String qnaId) {
		this.qnaId = qnaId; 
	}
	public String getQnaId() {
		return qnaId; 
	}
	public void setQnaCont(String qnaCont) {
		this.qnaCont = qnaCont; 
	}
	public String getQnaCont() {
		return qnaCont; 
	}
	public void setUserId(String userId) {
		this.userId = userId; 
	}
	public String getUserId() {
		return userId; 
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle; 
	}
	public String getQnaTitle() {
		return qnaTitle; 
	}

}
