package kr.co.codemaker.user.board.chat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.board.chat.dao.ChatRoomMapper;
import kr.co.codemaker.user.board.chat.vo.ChatRoomVO;

@Service("chatRoomService")
public class ChatRoomService {
	
	@Resource(name="chatRoomMapper")
	private ChatRoomMapper chatRoomMapper;
	
	public List<ChatRoomVO> selectAllChatRoom(){
		return chatRoomMapper.selectAllChatRoom();
	}
	
	public ChatRoomVO selectChatRoom(String lesId) {
		return chatRoomMapper.selectChatRoom(lesId);
	}
}
