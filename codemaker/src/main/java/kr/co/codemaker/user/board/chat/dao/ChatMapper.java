package kr.co.codemaker.user.board.chat.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.board.chat.vo.ChatVO;

/**
* ChatMapper.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 9.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Mapper("chatMapper")
public interface ChatMapper {
	/**
	 * 채팅내역을 조회하는 메서드
	 * @author 박경호
	 * @param chatroomId 채팅방 아이디
	 * @return 채팅내역
	 */
	public List<ChatVO> selectAllChat(ChatVO chatVo);
	
	/**
	 * @author 박경호
	 * @param chatVo
	 * @return
	 */
	public int insertChat(ChatVO chatVo); 
}
