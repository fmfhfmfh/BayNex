package kr.co.codemaker.user.mypage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stringtemplate.v4.compiler.STParser.mapExpr_return;

import com.mysql.fabric.xmlrpc.base.Array;

import kr.co.codemaker.admin.chart.vo.PayVO;
import kr.co.codemaker.common.vo.PageVo;
import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.mypage.service.MyPayService;
import kr.co.codemaker.user.mypage.vo.MyPayVO;
import kr.co.codemaker.user.mypage.vo.PointVO;
/**
* MyPayController.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 결제정보/환불
*
*/
@Controller
public class MyPayController {
	private static final Logger logger = LoggerFactory.getLogger(MyPayController.class);
	
	@Resource(name="myPayService")
	private MyPayService myPayService;
	
	/**
	 * 결제내역 조회
	 * @param model
	 * @param session
	 * @param request
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/mypage/selectAllMyPay")
	public String selectAllMyPay(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(name="page",required = false, defaultValue = "1")int page,
			@RequestParam(name="pageSize", required = false, defaultValue = "5")int pageSize) {
		
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		String userId = userVo.getUserId();
		
		model.addAttribute("page",page);
		model.addAttribute("pageSize", pageSize);
	
		PageVo pageVo = new PageVo();
		pageVo.setUserId(userId);
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		model.addAttribute("pageVo", pageVo);
		
		Map<String, Object> map = myPayService.selectAllMyPay(pageVo);
	
		
		model.addAttribute("myPay", map.get("myPay"));
		model.addAttribute("pages", map.get("pages"));
		
		return "mypageT/user/mypay/mypayTest";
	}
	
	/**
	 * 환불시 상세 결제내역을 조회
	 * @param model
	 * @param payId
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(path="/mypage/payRefundView")
	public String payRefundView(Model model, String payId, HttpSession session, HttpServletRequest request) {
		
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		String userId = userVo.getUserId();
		
		PayVO payVo = new PayVO();
		//파라미터로 가져갈것.. userid, payId
		payVo.setUserId(userId);
		payVo.setPayId(payId);
		
		MyPayVO mypayVo = new MyPayVO();
		try {
			mypayVo =myPayService.selectMyPay(payVo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("mypayVo", mypayVo);
		
		return "user/mypay/mypay_refund";
	}

	/**
	 * 환불진행
	 * @param payId
	 * @param paySum
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/mypage/payRefund")
	public String payRefund(String payId, int paySum, HttpSession session, HttpServletRequest request) {
		
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		String userId = userVo.getUserId();

		int updateCnt = 0;
		//강의 환불시 강의 상태값 변경
		try {
			//환불 여부 변경 N->Y
			updateCnt = myPayService.payRefund(payId);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		} catch (Exception e) {
			e.printStackTrace();
		}

		PointVO pointVo = new PointVO();
		pointVo.setPointUpdate(paySum);
		pointVo.setUserId(userId);

		int insertCnt = 0;
		if (updateCnt == 1) {
			//환불 시 포인트로 환불
			try {
				//환불진행 후 포인트로 적립해준다.
				insertCnt = myPayService.insertRefund(pointVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "1";
	}

}
