package kr.co.codemaker.testmember.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.testmember.service.MemberService;
import kr.co.codemaker.testmember.vo.MemberVO;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource
	MemberService memberService;
	
	@RequestMapping("/testMember/select")
	public String memberSelect() {
		logger.debug("select controller 진입");
		List<MemberVO> memberVo = memberService.selectMember();
		
		logger.debug("가져온 VO {}",memberVo);
		return "";
	}
}
