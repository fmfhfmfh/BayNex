package kr.co.codemaker.user.board.chat.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class ChatRoomVO extends BaseVO{

	private String chatroomId;	// 채팅방 아이디
	private String chatroomNm;	// 채팅방 이름
	private String subId;		// 과목 아이디

	public void setChatroomId(String chatroomId) {
		this.chatroomId = chatroomId; 
	}

	public String getChatroomNm() {
		return chatroomNm;
	}

	public void setChatroomNm(String chatroomNm) {
		this.chatroomNm = chatroomNm;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getChatroomId() {
		return chatroomId; 
	}

}
