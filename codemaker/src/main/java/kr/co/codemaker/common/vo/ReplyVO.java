package kr.co.codemaker.common.vo;

import java.util.Date;

/**
* ReplyVO.java
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
public class ReplyVO {

	private String qnaId;
	private String replyRoot;
	private String replyId;
	private Date replyDate;
	private String replyWriter;
	private String replyOut;
	private String replyCont;
	private int replylevel;
	
	
	public int getReplylevel() {
		return replylevel;
	}
	public void setReplylevel(int replylevel) {
		this.replylevel = replylevel;
	}
	public void setQnaId(String qnaId) {
		this.qnaId = qnaId; 
	}
	public String getQnaId() {
		return qnaId; 
	}
	public void setReplyRoot(String replyRoot) {
		this.replyRoot = replyRoot; 
	}
	public String getReplyRoot() {
		return replyRoot; 
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId; 
	}
	public String getReplyId() {
		return replyId; 
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate; 
	}
	public Date getReplyDate() {
		return replyDate; 
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter; 
	}
	
	public String getReplyWriter() {
		return replyWriter; 
	}
	public void setReplyOut(String replyOut) {
		this.replyOut = replyOut; 
	}
	public String getReplyOut() {
		return replyOut; 
	}
	public void setReplyCont(String replyCont) {
		this.replyCont = replyCont; 
	}
	public String getReplyCont() {
		return replyCont; 
	}
	@Override
	public String toString() {
		return "ReplyVO [qnaId=" + qnaId + ", replyRoot=" + replyRoot + ", replyId=" + replyId + ", replyDate="
				+ replyDate + ", replyWriter=" + replyWriter + ", replyOut=" + replyOut + ", replyCont=" + replyCont
				+ ", replyLevel=" + replylevel + "]";
	}


}
