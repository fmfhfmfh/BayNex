package kr.co.codemaker.user.complain.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.common.service.ComplainService;
import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.vo.ComplainVO;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.common.vo.UserVO;

@Controller
public class UserComplainController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserComplainController.class);
	
	@Resource(name="complainService")
	private ComplainService complainService;
	
	@Resource(name="notificationService")
	private NotificationService notificationService;
	
	@RequestMapping(path="/user/insertComplain", method=RequestMethod.GET)
	public String insertViewComplain(String qnaId, String replyId, String defendant, Model model) {
		
		if(qnaId != null) {
			model.addAttribute("qnaId", qnaId);
		}else {
			model.addAttribute("replyId", replyId);
		}
		model.addAttribute("defendant", defendant);
		return "user/complain/complainInsert";
	}
	
	
	@RequestMapping(path="/user/insertComplain", method=RequestMethod.POST)
	public String insertComplain(ComplainVO complainVo, HttpSession session) {
		
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		
		NotificationVO notificationVo = new NotificationVO();
		
		notificationVo.setNotifyCont(userVo.getUserId()+" 님이 글을 신고 하였습니다");
		notificationVo.setRecipientId("admin");
		notificationVo.setSenderId(userVo.getUserId());
		notificationVo.setUrl("/admin/selectAllComplain");
		
		logger.debug("-----------------------------{}",complainVo);
		try {
			complainService.insertComplain(complainVo);
			notificationService.insertNotification(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "jsonView";
	}
}
