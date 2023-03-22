package kr.co.codemaker.teacher.replyController;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.service.ReplyService;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.common.vo.ReplyVO;

@Controller
public class TeacherReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherReplyController.class);
	
	@Resource(name="replyService")
	private ReplyService replyService;
	
	@Resource(name="notificationService")
	private NotificationService notificationService;
	
	@RequestMapping(path="/teacher/insertReply")
	public String insertReply(ReplyVO replyVo, Model model, @RequestParam("quserId") String userId) {
		
		NotificationVO notificationVo = new NotificationVO();
		notificationVo.setNotifyCont(replyVo.getReplyWriter()+" 선생님이 댓글을 남겼습니다.");
		notificationVo.setRecipientId(userId);
		notificationVo.setUrl("/user/selectQna?qnaId="+replyVo.getQnaId());
		notificationVo.setSenderId(replyVo.getReplyWriter());
		
		try {
			replyService.insertReply(replyVo);
			notificationService.insertNotification(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("replyVo", replyVo);
		
		return "redirect:/teacher/selectQna?qnaId="+replyVo.getQnaId();
	}
	
	@RequestMapping(path="/teacher/insertrReply")
	public String insertrReply(ReplyVO replyVo, @RequestParam("rreplyCont") String replyCont, @RequestParam("root") String replyRoot, Model model) {
		
		ReplyVO reVo = new ReplyVO();
		
		try {
			reVo = replyService.selectReply(replyRoot);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		NotificationVO notificationVo = new NotificationVO();
		notificationVo.setRecipientId(reVo.getReplyWriter());
		notificationVo.setNotifyCont(replyVo.getReplyWriter()+" 선생님이 댓글을 남겼습니다.");
		notificationVo.setSenderId(replyVo.getReplyWriter());
		notificationVo.setUrl("/user/selectQna?qnaId="+replyVo.getQnaId());
		
		replyVo.setReplyCont(replyCont);
		replyVo.setReplyRoot(replyRoot);
		
		try {
			replyService.insertReply(replyVo);
			notificationService.insertNotification(notificationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("replyVo", replyVo);
		
		return "redirect:/teacher/selectQna?qnaId="+replyVo.getQnaId();
	}
	
	@RequestMapping(path="/teacher/deleteReply")
	public String deleteReply(ReplyVO replyVo, String qnaId) {
		
		logger.debug("delete replyVo {}", replyVo);
		
		try {
			replyService.deleteReply(replyVo.getReplyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/teacher/selectQna?qnaId="+replyVo.getQnaId();
	}
}
