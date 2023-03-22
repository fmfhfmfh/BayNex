package kr.co.codemaker.teacher.schedule.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.co.codemaker.common.vo.BaseVO;

public class ScheduleVO extends BaseVO {

	private String schCont;		// 스케줄 내용
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date schEdate;		// 스케줄 종료일
	
	private String schId;		// 스케줄 아이디
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date schSdate;		// 스케줄 시작일
	
	private String schAllday;	// 스케줄 종일 여부
	private String adminId;		// 관리자 아이디
	
	private String schSfdate;	// 응답을 받을때 스케줄 시작일
	private String schEfdate;	// 응답을 받을때 스케줄 종료일
	
	
	public String getSchSfdate() {
		return schSfdate;
	}
	public void setSchSfdate(String schSfdate) {
		this.schSfdate = schSfdate;
	}
	public String getSchEfdate() {
		return schEfdate;
	}
	public void setSchEfdate(String schEfdate) {
		this.schEfdate = schEfdate;
	}
	public void setSchCont(String schCont) {
		this.schCont = schCont; 
	}
	public String getSchCont() {
		return schCont; 
	}
	public void setSchId(String schId) {
		this.schId = schId; 
	}
	public Date getSchEdate() {
		return schEdate;
	}
	public void setSchEdate(Date schEdate) {
		this.schEdate = schEdate;
	}
	public String getSchId() {
		return schId; 
	}
	public void setSchAllday(String schAllday) {
		this.schAllday = schAllday; 
	}
	public Date getSchSdate() {
		return schSdate;
	}
	public void setSchSdate(Date schSdate) {
		this.schSdate = schSdate;
	}
	public String getSchAllday() {
		return schAllday; 
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId; 
	}
	public String getAdminId() {
		return adminId; 
	}

}
