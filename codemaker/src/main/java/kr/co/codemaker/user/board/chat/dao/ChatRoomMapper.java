package kr.co.codemaker.user.board.chat.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.board.chat.vo.ChatRoomVO;

@Mapper("chatRoomMapper")
public interface ChatRoomMapper {
	
	/**
	 * 모든 채팅방을 조회하는 메서드
	 * @author 박경호
	 * @return 모든 채팅방
	 */
	List<ChatRoomVO> selectAllChatRoom();
	
	/**
	 * 하나의 채팅방을 조회하는메서드
	 * @author 박경호
	 * @param lesId 강의아이디
	 * @return 하나의 채팅방
	 */
	ChatRoomVO selectChatRoom(String lesId);
}
