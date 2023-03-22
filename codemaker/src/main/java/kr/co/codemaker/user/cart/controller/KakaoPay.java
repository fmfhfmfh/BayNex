package kr.co.codemaker.user.cart.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.cart.vo.KakaoPayApprovalVO;
import kr.co.codemaker.user.cart.vo.KakaoPayReadyVO;
import kr.co.codemaker.user.cart.vo.PayVO;

@Service("kakao")
public class KakaoPay {
	private static final Logger logger = LoggerFactory.getLogger(KakaoPay.class);
	private static final String HOST = "https://kapi.kakao.com/v1/payment/ready";
	private KakaoPayReadyVO kakaoPayReadyVo;
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	
	public String kakaoPayReady(String total,HttpSession session) {
		RestTemplate restTemplate = new RestTemplate();
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		logger.debug("카카오서비스 결제정보 :{}",total);
		logger.debug("유저정보 : {}",userVo.getUserId());
		//서버로 요청할 header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 80498dac11d5ee25d3fd2a587144ded1");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		//서버로 요청할 body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1233");
		params.add("partner_user_id", "a001");
		params.add("item_name", "코드메이커 강의");
		params.add("quantity", "1");
		params.add("total_amount", total);
		params.add("tax_free_amount", "0");
		params.add("approval_url", "http://192.168.44.59/kakaoPaySuccess?total="+total);
		params.add("cancel_url", "http://192.168.44.59/user/login");
		params.add("fail_url", "http://192.168.44.59/user/selectSubject");
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		try {
			kakaoPayReadyVo = restTemplate.postForObject(new URI(HOST), body, KakaoPayReadyVO.class);
			return kakaoPayReadyVo.getNext_redirect_pc_url();
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return "/user/payView";
	}
	
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token,String total) {
		RestTemplate restTemplate = new RestTemplate();
		
		logger.debug("받은토큰 :{}",pg_token);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 80498dac11d5ee25d3fd2a587144ded1");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", kakaoPayReadyVo.getTid());
		params.add("partner_order_id", "1233");
		params.add("partner_user_id", "a001");
		params.add("pg_token", pg_token);
		params.add("total_amount", total);
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		try {
			kakaoPayApprovalVO = restTemplate.postForObject(new URI("https://kapi.kakao.com/v1/payment/approve"), body,KakaoPayApprovalVO.class);
			return kakaoPayApprovalVO;
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
