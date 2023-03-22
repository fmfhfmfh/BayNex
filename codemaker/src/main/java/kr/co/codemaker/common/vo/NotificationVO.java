package kr.co.codemaker.common.vo;

public class NotificationVO extends BaseVO {

	private String notifyDate;
	private String senderId;
	private String notifyCont;
	private String notifyId;
	private String recipientId;
	private String readCheck;
	private String url;
	
	public String getReadCheck() {
		return readCheck;
	}
	public void setReadCheck(String readCheck) {
		this.readCheck = readCheck;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setNotifyDate(String notifyDate) {
		this.notifyDate = notifyDate; 
	}
	public String getNotifyDate() {
		return notifyDate; 
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId; 
	}
	public String getSenderId() {
		return senderId; 
	}
	public void setNotifyCont(String notifyCont) {
		this.notifyCont = notifyCont; 
	}
	public String getNotifyCont() {
		return notifyCont; 
	}
	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId; 
	}
	public String getNotifyId() {
		return notifyId; 
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId; 
	}
	public String getRecipientId() {
		return recipientId; 
	}

}
