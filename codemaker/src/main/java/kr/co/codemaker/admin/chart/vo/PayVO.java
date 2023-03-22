package kr.co.codemaker.admin.chart.vo;

import java.util.Date;
/**
* PayVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 최초 생성
*
 */
public class PayVO extends LessonVO{

	private String payId;	//결제ID
	private String lesId;	//강의ID
	private int paySum;		//결제금액
	private String payWay;	//결제방법
	private Date payDate;	//결제일
	private String payRefund;	//환불여부
	private String userId;	//회원ID
	private Date cosTerm;	//수강기간
	private int cosProcess;	//수강진행도
	private int payGroup;	//결제그룹
	
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
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getPayRefund() {
		return payRefund;
	}
	public void setPayRefund(String payRefund) {
		this.payRefund = payRefund;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCosTerm() {
		return cosTerm;
	}
	public void setCosTerm(Date cosTerm) {
		this.cosTerm = cosTerm;
	}
	public int getCosProcess() {
		return cosProcess;
	}
	public void setCosProcess(int cosProcess) {
		this.cosProcess = cosProcess;
	}
	public int getPayGroup() {
		return payGroup;
	}
	public void setPayGroup(int payGroup) {
		this.payGroup = payGroup;
	}
	
	

}
