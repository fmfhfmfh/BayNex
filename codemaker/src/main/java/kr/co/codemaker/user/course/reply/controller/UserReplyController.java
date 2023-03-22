package kr.co.codemaker.user.course.reply.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.service.QnaService;
import kr.co.codemaker.common.service.ReplyService;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.common.vo.ReplyVO;

@Controller
public class UserReplyController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserReplyController.class);
	
	@Resource(name="replyService")
	private ReplyService replyService;
	
	@Resource(name="notificationService")
	private NotificationService notificationService;
	
	@Resource(name="qnaService")
	private QnaService qnaService;
	
	@RequestMapping(path="/user/insertReply")
	public String insertReply(ReplyVO replyVo, String lesId, Model model, @RequestParam("quserId") String userId) {
		
		String tchId = "";
		try {
			tchId = qnaService.selectQnaTeacher(lesId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		NotificationVO notificationVo = new NotificationVO();
		notificationVo.setNotifyCont(replyVo.getReplyWriter()+" 님이 댓글을 남겼습니다.");
		if(tchId != null) {
			notificationVo.setRecipientId(tchId);
			notificationVo.setUrl("/teacher/selectQna?qnaId="+replyVo.getQnaId());
		}else {
			notificationVo.setRecipientId(userId);
			notificationVo.setUrl("/user/selectQna?qnaId="+replyVo.getQnaId());
		}
		
		notificationVo.setSenderId(replyVo.getReplyWriter());
		
		try {
			replyService.insertReply(replyVo);
			notificationService.insertNotification(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("replyVo", replyVo);
		
		return "redirect:/user/selectQna?qnaId="+replyVo.getQnaId();
	}
	
	@RequestMapping(path="/user/insertrReply")
	public String updateReply(ReplyVO replyVo, String lesId, @RequestParam("rreplyCont") String replyCont, @RequestParam("root") String replyRoot, Model model) {
		
		replyVo.setReplyCont(replyCont);
		replyVo.setReplyRoot(replyRoot);
		
		logger.debug("--------------{}=====",replyVo.getReplyWriter());
		
		ReplyVO reVo = new ReplyVO();
		
		try {
			reVo = replyService.selectReply(replyRoot);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		NotificationVO notificationVo = new NotificationVO();
		notificationVo.setRecipientId(reVo.getReplyWriter());
		notificationVo.setNotifyCont(replyVo.getReplyWriter()+" 님이 댓글을 남겼습니다.");
		notificationVo.setSenderId(replyVo.getReplyWriter());
		
		try {
			replyService.insertReply(replyVo);
			notificationService.insertNotification(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("replyVo", replyVo);
		
		return "redirect:/user/selectQna?qnaId="+replyVo.getQnaId();
	}
	
	@RequestMapping(path="/user/deleteReply")
	public String deleteReply(ReplyVO replyVo, String qnaId) {
		try {
			replyService.deleteReply(replyVo.getReplyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/selectQna?qnaId="+replyVo.getQnaId();
	}
	
	
}
