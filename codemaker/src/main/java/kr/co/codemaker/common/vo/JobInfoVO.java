package kr.co.codemaker.common.vo;

import java.util.Date;

/**
* JobInfoVO.java
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
public class JobInfoVO extends BaseVO{

	private String jobinfoTitle;
	private String jobinfoOut;
	private String jobinfoId;
	private String adminId;
	private Date jobinfoDate;
	private String jobinfoCont;
	private String jobinfoUdate;
	private String jobinfoUwriter;
	
	public String getJobinfoUdate() {
		return jobinfoUdate;
	}
	public void setJobinfoUdate(String jobinfoUdate) {
		this.jobinfoUdate = jobinfoUdate;
	}
	public String getJobinfoUwriter() {
		return jobinfoUwriter;
	}
	public void setJobinfoUwriter(String jobinfoUwriter) {
		this.jobinfoUwriter = jobinfoUwriter;
	}
	public void setJobinfoTitle(String jobinfoTitle) {
		this.jobinfoTitle = jobinfoTitle; 
	}
	public String getJobinfoTitle() {
		return jobinfoTitle; 
	}
	public void setJobinfoOut(String jobinfoOut) {
		this.jobinfoOut = jobinfoOut; 
	}
	public String getJobinfoOut() {
		return jobinfoOut; 
	}
	public void setJobinfoId(String jobinfoId) {
		this.jobinfoId = jobinfoId; 
	}
	public String getJobinfoId() {
		return jobinfoId; 
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId; 
	}
	public String getAdminId() {
		return adminId; 
	}
	public void setJobinfoDate(Date jobinfoDate) {
		this.jobinfoDate = jobinfoDate; 
	}
	public Date getJobinfoDate() {
		return jobinfoDate; 
	}
	public void setJobinfoCont(String jobinfoCont) {
		this.jobinfoCont = jobinfoCont; 
	}
	public String getJobinfoCont() {
		return jobinfoCont; 
	}

}
