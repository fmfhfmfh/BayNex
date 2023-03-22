package kr.co.codemaker.common.vo;

import java.util.Date;

/**
* NoticeVO.java
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
public class NoticeVO extends BaseVO {

	private String noticeOut;
	private String noticeCont;
	private String noticeId;
	private Date noticeDate;
	private String noticeHead;
	private String adminId;
	private String noticeTitle;
	private String noticeUdate;
	private String noticeUwriter;
	
	public void setNoticeOut(String noticeOut) {
		this.noticeOut = noticeOut; 
	}
	public String getNoticeUdate() {
		return noticeUdate;
	}
	public void setNoticeUdate(String noticeUdate) {
		this.noticeUdate = noticeUdate;
	}
	public String getNoticeUwriter() {
		return noticeUwriter;
	}
	public void setNoticeUwriter(String noticeUwriter) {
		this.noticeUwriter = noticeUwriter;
	}
	public String getNoticeOut() {
		return noticeOut; 
	}
	public void setNoticeCont(String noticeCont) {
		this.noticeCont = noticeCont; 
	}
	public String getNoticeCont() {
		return noticeCont; 
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId; 
	}
	public String getNoticeId() {
		return noticeId; 
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate; 
	}
	public Date getNoticeDate() {
		return noticeDate; 
	}
	public void setNoticeHead(String noticeHead) {
		this.noticeHead = noticeHead; 
	}
	public String getNoticeHead() {
		return noticeHead; 
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId; 
	}
	public String getAdminId() {
		return adminId; 
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle; 
	}
	public String getNoticeTitle() {
		return noticeTitle; 
	}

}
