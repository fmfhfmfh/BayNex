package kr.co.codemaker.admin.chart.vo;

import java.util.Date;
/**
* TeacherPayVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 강사별 매출 조회를 하기위한 VO
*
 */
public class TeacherPayVO {

	private String payId;	//결제ID
	private String lesId;	//강의ID
	private int paySum;		//결제금액
	private String lesNm;	//강의명
	private Date payDate;	//결제일
	private String tchId;	//강사Id
	private String tchNm;	//강사명
	
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public int getPaySum() {
		return paySum;
	}
	public void setPaySum(int paySum) {
		this.paySum = paySum;
	}
	public String getLesNm() {
		return lesNm;
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getTchId() {
		return tchId;
	}
	public void setTchId(String tchId) {
		this.tchId = tchId;
	}
	public String getTchNm() {
		return tchNm;
	}
	public void setTchNm(String tchNm) {
		this.tchNm = tchNm;
	}
	

}
