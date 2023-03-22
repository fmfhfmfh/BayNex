package kr.co.codemaker.user.cart.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@Resource(name="kakao")
	private KakaoPay kakaoPay;
	
	@RequestMapping("/kakaoPay")
	public String kakaoPay(@RequestParam(required = false)String total, Model model, HttpSession session,@RequestParam(required = false)String test) {
		logger.debug("받은 정보 :{}", total);
		if(total != null) {
			String url = kakaoPay.kakaoPayReady(total,session);
			model.addAttribute("url", url);
		}
		return "jsonView";
	}
	
	@RequestMapping("/kakaoPaySuccess")
	public String kakaoPaySuccess(Model model,@RequestParam(name="pg_token") String pg_token, HttpServletRequest request, String total) {
		logger.debug("새로운");
		logger.debug("토큰 :{}", pg_token);
		model.addAttribute("info", kakaoPay.kakaoPayInfo(pg_token, total));
		return "user/payment/temp";
		
	}
}
