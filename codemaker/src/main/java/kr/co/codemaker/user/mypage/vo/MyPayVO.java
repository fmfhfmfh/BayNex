package kr.co.codemaker.user.mypage.vo;

import java.util.Date;
/**
 * 
* MyPayVO.java
*
* @author 우송이
* @version 1.0 
* @Since 2020.12
*
* 수정자 수정내용
* ------ ------------------------
* 환불 내역을 조회하기 위한 VO
*
 */
public class MyPayVO {

	private String payId;  		//결제ID
	private String lesId; 	 	//강의ID
	private int paySum;   	 	//결제금액
	private String lesNm; 		//강의명
	private int lesTotal; 		//회원수강진행도
	private String lesId2; 		//강의명2
	private Date payDate;  		//결제일
	private String payWay; 		//결제방식
	private String payRefund; 	//환불여부
	private Date cosTerm;	 	//수강기간
	private String rn;
	
	
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
	public int getLesTotal() {
		return lesTotal;
	}
	public void setLesTotal(int lesTotal) {
		this.lesTotal = lesTotal;
	}
	public String getLesId2() {
		return lesId2;
	}
	public void setLesId2(String lesId2) {
		this.lesId2 = lesId2;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getPayRefund() {
		return payRefund;
	}
	public void setPayRefund(String payRefund) {
		this.payRefund = payRefund;
	}
	public Date getCosTerm() {
		return cosTerm;
	}
	public void setCosTerm(Date cosTerm) {
		this.cosTerm = cosTerm;
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	


}
