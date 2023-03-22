package kr.co.codemaker.user.cart.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.cart.service.UserPayService;
import kr.co.codemaker.user.cart.vo.CartVO;
import kr.co.codemaker.user.cart.vo.LessonVO;
import kr.co.codemaker.user.cart.vo.PayVO;
import kr.co.codemaker.user.cart.vo.PointVO;
import kr.co.codemaker.user.lessoninfo.service.LessonIndexService;
import kr.co.codemaker.user.lessoninfo.vo.IndexTimeVO;

/**
 * @author 최민준
 *
 */
@Controller
public class UserPayController {
	private static final Logger logger = LoggerFactory.getLogger(UserPayController.class);
	
	@Resource(name="userPayService")
	private UserPayService userPayService;
	
	@Resource(name="userLessonIndexService")
	private LessonIndexService lessonIndexService;
	
	//단 건 결제시
	@RequestMapping(path="user/payView", produces="application/json; charset=utf-8")
	public String payView(HttpSession session, Model model, PayVO payVo, LessonVO lessonVo){
		// 회원아이디, 강의 아이디 필요함
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");	//로그인한 회원아이디 세션에서 가져오기
		LessonVO getLessonVo = null;
		PointVO pointVo = null;
		try {
			pointVo = userPayService.selectPoint(new PointVO(userVo.getUserId()));	//회원이 가지고 있는 포인트 조회
		} catch (Exception e) {e.printStackTrace();}
		try {
			getLessonVo = userPayService.selectLessonInfo(lessonVo);	//회원이 선택한 과목 정보 조회
		} catch (Exception e) {
			e.printStackTrace();
		}
		//화면에서 출력하기 위해 회원, 강의, 포인트 정보 전달
		model.addAttribute("userVo", userVo);
		model.addAttribute("lessonVo", getLessonVo);
		model.addAttribute("pointVo", pointVo);
		return "mainT/user/payment/pay";
	}
	
	//다 건 결제시
	@RequestMapping(path="user/payViewList")
	public String payViewList(HttpSession session, PayVO payVo,Model model, LessonVO lessonList) {
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		PointVO pointVo = null;
		
		try {
			pointVo = userPayService.selectPoint(new PointVO(userVo.getUserId()));
		} catch (Exception e) {e.printStackTrace();}
		List<LessonVO> lesson = new ArrayList<>();
		for(int i=0; i<lessonList.getLessonList().size();i++) {
			if(lessonList.getLessonList().get(i).getLesId() != null) {
				lesson.add(lessonList.getLessonList().get(i));
			}
		}
		model.addAttribute("userVo", userVo);
		model.addAttribute("lessonVoList", lesson);
		model.addAttribute("pointVo", pointVo);
		return "mainT/user/payment/payList";
	}
	
	//결제하기
	@RequestMapping(path="user/pay")
	public String pay(PayVO payVo, PointVO pointVo,HttpSession session,Model model) {
		Date now = new Date();	//수강기간을 알려주기 위한 객체 초기화
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
		LessonVO lvo = null;
		List<IndexTimeVO> lidxIds = new ArrayList<>();
		IndexTimeVO indexTimeVO = new IndexTimeVO(); 
		
		String payGroup = UUID.randomUUID().toString();	//결제 그룹에 랜덤ID부여
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");	//로그인 되어있는 회원 정보 가져오기
		pointVo.setUserId(userVo.getUserId());
		if(pointVo.getPointUpdate() !=null) {
			try {
				userPayService.usePoint(pointVo);
			} catch (Exception e) {e.printStackTrace();}
		}
		//장바구니에서 결제할때
		if(payVo.getPayList() != null) {
			List<LessonVO> lessonList = new ArrayList<>();
			for(int i=0; i<payVo.getPayList().size();i++) {
				CartVO cartVo = new CartVO();
				cartVo.setLesId(payVo.getPayList().get(i).getLesId());
				cartVo.setUserId(payVo.getPayList().get(i).getUserId());
				try {
					payVo.getPayList().get(i).setPayGroup(payGroup);
					userPayService.insertPay(payVo.getPayList().get(i));	//결제
					userPayService.deleteCart(cartVo);	//결제 시 장바구니에 있던 목록 삭제
					//수강기간을 나타내기 위해 강의정보 조회
					lvo = userPayService.selectLessonInfo(new LessonVO(payVo.getPayList().get(i).getLesId()));
					
					indexTimeVO.setUserId(payVo.getPayList().get(i).getUserId());
					indexTimeVO.setLesId(payVo.getPayList().get(i).getLesId());
					lidxIds = lessonIndexService.selectLidxId(indexTimeVO);
					
					for(int j=0; j<lidxIds.size(); j++) {
						  String lidxId = lidxIds.get(j).getLidxId();
						  indexTimeVO.setLidxId(lidxId);
						  indexTimeVO.setUserId(userVo.getUserId());
						  lessonIndexService.insertIndexTime(indexTimeVO);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				cal.setTime(now);
				cal.add(Calendar.DATE, lvo.getLesTerm());
				lvo.setLesDate(cal.getTime());
				lessonList.add(lvo);
			}
			model.addAttribute("payList", payVo.getPayList());
			model.addAttribute("pointVo", pointVo);
			model.addAttribute("lessonList", lessonList);
			return "mainT/user/payment/payment-complete";
		//강의 페이지에서 바로 결제 할때
		}else if(payVo !=null) {
			try {
				payVo.setPayGroup(payGroup);
				userPayService.insertPay(payVo);
				lvo = userPayService.selectLessonInfo(new LessonVO(payVo.getLesId()));
				
				indexTimeVO.setUserId(payVo.getUserId());
				indexTimeVO.setLesId(payVo.getLesId());
				lidxIds = lessonIndexService.selectLidxId(indexTimeVO);
				
				for(int j=0; j<lidxIds.size(); j++) {
					  String lidxId = lidxIds.get(j).getLidxId();
					  indexTimeVO.setLidxId(lidxId);
					  indexTimeVO.setUserId(userVo.getUserId());
					  lessonIndexService.insertIndexTime(indexTimeVO);
				}
				
			} catch (Exception e) {e.printStackTrace();}
			cal.setTime(now);
			cal.add(Calendar.DATE, lvo.getLesTerm());
			lvo.setLesDate(cal.getTime());
			model.addAttribute("payVo", payVo);
			model.addAttribute("pointVo", pointVo);
			model.addAttribute("lessonVo", lvo);
			return "mainT/user/payment/paymentOne-complete";
		}
		return "redirect:/user/main";
	}
	
	//강의 결제시 수강중인지 확인
	@RequestMapping(path="/user/payCheck")
	public String payCheck(Model model, HttpSession session,PayVO payVo) {
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		String code="";
		String msg="";
		//이미 결제한 강의가 있고 수강이 안끝났을때
		PayVO pvo = new PayVO();
		pvo.setLesId(payVo.getLesId());
		pvo.setUserId(userVo.getUserId());
		//결제내역에 있는지, 수강중인지 확인
		List<PayVO> getPay = new ArrayList<>();
		try {
			getPay = userPayService.selectCheckPay(pvo);
		} catch (Exception e2) {e2.printStackTrace();}
		if(!getPay.isEmpty() && getPay.get(0).getPayId() !=null) {
			code="0";
			msg="이미 수강중인 강의내역이 있습니다";
			model.addAttribute("msg", msg);
			model.addAttribute("code", code);
			return "jsonView";
		}else {
			code="1";
			model.addAttribute("code", code);
			return "jsonView";
		}
	}
	
	//강의담기 (장바구니 기능)
	@RequestMapping(path="/user/cart")
	public String addCart(CartVO cartVo, Model model) {
		CartVO getCartVo = null;
		String msg = "";
		String code="";
		//이미 결제한 강의가 있고 수강이 안끝났을때
		PayVO payVo = new PayVO();
		payVo.setLesId(cartVo.getLesId());
		payVo.setUserId(cartVo.getUserId());
		
		//결제내역에 있는지, 수강중인지 확인
		List<PayVO> getPay = new ArrayList<>();
		try {
			getPay = userPayService.selectCheckPay(payVo);
		} catch (Exception e2) {e2.printStackTrace();}
		
		if(!getPay.isEmpty() && getPay.get(0).getPayId() !=null) {
			code="0";
			msg="이미 수강중인 강의내역이 있습니다";
			model.addAttribute("msg", msg);
			model.addAttribute("code", code);
			return "jsonView";
		}
		
		//똑같은 강의를 담았을때 메세지 출력
		try {
			getCartVo = userPayService.selectCart(cartVo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(getCartVo != null) {
			code="0";
			msg="이미 장바구니에 강의를 담았습니다";
			model.addAttribute("msg", msg);
			model.addAttribute("code", code);
			return "jsonView";
		}
		
		//강의담기
		int insertCnt =0;
		try {
			insertCnt = userPayService.insertCart(cartVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(insertCnt >0) {
			code="1";
			msg ="success";
		}else {
			msg="fail";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("msg", code);
		return "jsonView";
	}
	
	//장바구니로 이동, 담은강의 리스트 조회
	@RequestMapping(path="/user/cartView")
	public String cartView(HttpSession session,Model model,LessonVO lessonVo) {
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		List<CartVO> cartList = null;
		try {
			//장바구니에 등록된 강의 조회
			cartList = userPayService.selectCartList(new CartVO(userVo.getUserId()));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<LessonVO> lessonList = new ArrayList<>();
		for(int i=0; i<cartList.size(); i++) {
			LessonVO lesson =null;
			try {
				//조회된 장바구니 강의 아이디를 이용해 강의 정보 조회
				lesson = userPayService.selectLessonInfo(new LessonVO(cartList.get(i).getLesId()));	
			} catch (Exception e) {
				e.printStackTrace();
			}
			lessonList.add(lesson);
		}
		model.addAttribute("lessonList", lessonList);
		
		return "mainT/user/payment/cart";
	}
	
	@RequestMapping(path="/user/cartDelete")
	public String cartDelete(String[] data,HttpSession session) throws Exception {
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");	//현재 로그인된 회원정보 가져오기
		CartVO cartVo = new CartVO();
		cartVo.setUserId(userVo.getUserId());
		for(int i=0; i<data.length; i++) {
			cartVo.setLesId(data[i]);
			userPayService.deleteCart(cartVo);
			logger.debug("카트정보 :{}",data[i]);
		}
		return "jsonView";
	}

}
