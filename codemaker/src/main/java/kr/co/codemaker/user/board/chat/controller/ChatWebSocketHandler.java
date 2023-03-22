package kr.co.codemaker.user.board.chat.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import kr.co.codemaker.common.vo.UserVO;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ChatWebSocketHandler.class);

    // 접속한 유저들의 목록을 담기 위한 Map 선언
    // ConcurrentHashMap은 Hashtable과 유사하지만 멀티스래드 환경에서 더 안전하다
	public List<Map<String, Object>> usersList = SocketServer.usersList;
	public List<Map<String, Object>> userList = new ArrayList<>();
			
//    private Map<String, WebSocketSession> users = new ConcurrentHashMap<>();
	private Map<String, Object> users; 

    @Override
    public void afterConnectionEstablished(
            WebSocketSession session) throws Exception {
    	
    	users = new HashMap<String, Object>();
    	
    	Map<String, Object> userSessionMap = session.getAttributes();
    	String chatRoomId = (String) userSessionMap.get("chatroomId");
    	UserVO userVo = (UserVO) userSessionMap.get("MEMBER_INFO");
    
    	
//    	logger.debug("세션??");
    	users.put("userId", userVo.getUserId());
    
    	users.put("userNm", userVo.getUserNm());
    
    	users.put("userSocketID", session.getId());
    	
    	users.put("userSocketSession", session);
    	users.put("chatRoomId", chatRoomId);
    	
    	
    	usersList.add(users);
    	
//    	logger.debug("userList : {}" , userList);
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session, CloseStatus status) throws Exception {

        // map에서 세션에서 연결 종료된 유저를 없애는 이유는
        // 더 이상 메세지를 보낼 필요가 없기 때문에 목록에서 지우는 것이다
//        users.remove(session.getId());
    	
    	String userKey = ((UserVO) session.getAttributes().get("MEMBER_INFO")).getUserId();
    	
    	Map<String, Object> user = new HashMap<>();
    	if(usersList != null) {
    		for(int i = 0; i < usersList.size(); i++) {
    			if(usersList.get(i).get("userId") == userKey) {
    				user = usersList.get(i);
    			}
    		}
    	}
        usersList.remove(user);
    }
    
    @Override
    protected void handleTextMessage(
            WebSocketSession session, TextMessage message) throws Exception {
//        log(session.getId() + "로부터 메시지 수신: " + message.getPayload());

        // 클라이언트로부터 메세지를 받으면 동작하는 handleTextMessage 함수!
        // 수신한 하나의 메세지를 users 맵에 있는 모든 유저(세션)들에게
        // 맵을 반복으로 돌면서 일일이 보내주게 되도록 처리
        
        String userId = "";
		String userNm = "";
		String chatroomId = "";
		
		for(int i = 0; i < usersList.size(); i++) {
//			session = (WebSocketSession) (usersList.get(i).get("userSocketSession"));
			if((session.getId()).equals(usersList.get(i).get("userSocketID"))) {
				userId = (String) usersList.get(i).get("userId");
				userNm = (String) usersList.get(i).get("userNm");
				chatroomId = (String) usersList.get(i).get("chatRoomId");
				break;
			}
		}
        
		for(int i = 0; i < usersList.size(); i++) {
			if(chatroomId.equals(usersList.get(i).get("chatRoomId"))) {
				session = (WebSocketSession) (usersList.get(i).get("userSocketSession"));
				session.sendMessage(message);
			}
		}
        
    }

    @Override
    public void handleTransportError(
            WebSocketSession session, Throwable exception) throws Exception {
        log(session.getId() + " 익셉션 발생: " + exception.getMessage());
    }

    private void log(String logmsg) {
        System.out.println(new Date() + " : " + logmsg);
    }

}


//	// 클라이언트가 서버로 메세지 전송 처리
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		
//		String empId = "";
//		String empNm = "";
//		String chatRoomId = "";
//		
//		// 현재 접속한 세션의 정보와 list에 추가한 세션정보가 같은 유저(본 브라우저 접속자)의 아이디를 추출
//		for(int i = 0; i < empMapList.size(); i++) {
//			WebSocketSession s = (WebSocketSession) (empMapList.get(i).get("userSocketSession"));
//			if((session.getId()).equals(empMapList.get(i).get("userSocketID"))) {
//				empId = (String) empMapList.get(i).get("empId");
//				empNm = (String) empMapList.get(i).get("empNm");
//				chatRoomId = (String) empMapList.get(i).get("chatRoomId");
//				break;
//			}
//		}
//		
//		// 추출된 아이디를 사용하여 접속한 전체 인원에게 메시지 전달
//		for(int i = 0; i < empMapList.size(); i++) {
//			if(chatRoomId.equals(empMapList.get(i).get("chatRoomId"))) {
//				WebSocketSession s = (WebSocketSession) (empMapList.get(i).get("userSocketSession"));
//				s.sendMessage(new TextMessage(empId + ":+:" + empNm + ":+:" + message.getPayload()));
//			}
//		}
//	}





