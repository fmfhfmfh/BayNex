package kr.co.codemaker.user.board.chat.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class ChatVO extends BaseVO{

	private String chatroomId;
	private String chatId;
	private String userId;
	private String chatCont;
	private String chatTime;
	
	private String userNm;
	private String subId;
	
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getChatroomId() {
		return chatroomId;
	}
	public void setChatroomId(String chatroomId) {
		this.chatroomId = chatroomId;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChatCont() {
		return chatCont;
	}
	public void setChatCont(String chatCont) {
		this.chatCont = chatCont;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	
}
