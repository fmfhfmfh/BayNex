package kr.co.codemaker.user.board.chat.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.codemaker.common.service.LoginService;
import kr.co.codemaker.user.board.chat.service.ChatRoomService;
import kr.co.codemaker.user.board.chat.service.ChatService;
import kr.co.codemaker.user.board.chat.vo.ChatRoomVO;
import kr.co.codemaker.user.board.chat.vo.ChatVO;


@Controller
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Resource(name="chatService")
	private ChatService chatService;
	
	@Resource(name="chatRoomService")
	private ChatRoomService chatRoomService;
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(path="/chat/realchat", method=RequestMethod.GET)
	public String realchatView(Model model, String lesId, HttpSession session) {
		ChatVO chatVo = new ChatVO();
		
		logger.debug("---------lesId-----------------{}", lesId);
		
		ChatRoomVO chatroomVo = chatRoomService.selectChatRoom(lesId);
		logger.debug("---------chatroomVo-----------------{}", chatroomVo);
		chatVo.setSubId(chatroomVo.getSubId());
		List<ChatVO> chattingList = chatService.selectAllChat(chatVo);
		
		session.setAttribute("chatroomId", chatroomVo.getChatroomId());
		logger.debug("------chatroomId-----------------------{}", chatroomVo.getChatroomId());
		
		logger.debug("---------------------------{}", chattingList);
		model.addAttribute("chatroomVo", chatroomVo);
		model.addAttribute("chattingList", chattingList);
		
		return "user/chat/chat";
	}
	
	@RequestMapping(path="/chat/realchat", method=RequestMethod.POST)
	public String realchat(ChatVO chatVo, Model model, HttpSession session) {
		List<ChatVO> chattingList = chatService.selectAllChat(chatVo);
		
		session.setAttribute("chatroomId", chatVo.getChatroomId());
		
		model.addAttribute("chattingList", chattingList);
		
		return "jsonView";
	}
	
	@ResponseBody
	@RequestMapping(path="/chat/insertChat", method=RequestMethod.POST)
	public int insertChat(ChatVO chatVo, Model model) {
		int cnt = 0;
		if(chatVo.getChatCont() != "") {
			cnt = chatService.insertChat(chatVo);
		}
		return cnt;
	}
	
	
}
