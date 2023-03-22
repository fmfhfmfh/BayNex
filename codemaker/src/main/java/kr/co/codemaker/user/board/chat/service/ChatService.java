package kr.co.codemaker.user.board.chat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.board.chat.dao.ChatMapper;
import kr.co.codemaker.user.board.chat.vo.ChatVO;

@Service("chatService")
public class ChatService {
	
	@Resource(name="chatMapper")
	private ChatMapper chatMapper;
	
	public List<ChatVO> selectAllChat(ChatVO chatVo){
		return chatMapper.selectAllChat(chatVo);
	}
	
	public int insertChat(ChatVO chatVo) {
		return chatMapper.insertChat(chatVo);
	}
	
}
