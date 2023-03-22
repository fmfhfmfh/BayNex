package kr.co.codemaker.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class NotifyHandler extends TextWebSocketHandler {
	
	
	private static final Logger logger = LoggerFactory.getLogger(NotifyHandler.class);
	
	public List<Map<String, Object>> memList = new ArrayList<Map<String,Object>>();
	private Map<String, Object> members; 
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		members = new HashMap<String, Object>();
		Map<String, Object> memberSession = session.getAttributes();
		
		members.put("nofityCont", "");
		members.put("recipientId", "");
		members.put("senderId", "");


	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		
		

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		
		

	}
}