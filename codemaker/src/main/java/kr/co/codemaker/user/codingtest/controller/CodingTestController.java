package kr.co.codemaker.user.codingtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodingTestController {
	private static final Logger logger = LoggerFactory.getLogger(CodingTestController.class);
	
	//메인 - 코딩테스트메인뷰 
	@RequestMapping(path="/user/codingtest")
	public String codingMain() {
		return "mainT/user/codingtest/coding_main";
	}
	
	//메인 - 코딩테스트메인뷰 - 코딩연습하기
	@RequestMapping(path="/user/coding/practice")
	public String codingPractice() {
		return "mainT/user/codingtest/coding_practice";
	}
	
	//메인 - 코딩테스트메인뷰 - 코딩테스트(솔루션뷰)
	@RequestMapping(path="/user/coding/solution")
	public String codingSolutionView() {
		return "mainT/user/codingtest/coding_sol_main";
	}
	
	//메인 - 코딩테스트메인뷰 - 솔루션뷰 - N번문제
	@RequestMapping(path="/user/coding/test/{number}")
	public String codingTest(@PathVariable("number") String number) {
		return "mainT/user/codingtest/coding_test_"+number;
	}
}
