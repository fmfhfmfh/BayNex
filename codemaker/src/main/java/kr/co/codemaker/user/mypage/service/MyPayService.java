package kr.co.codemaker.user.mypage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.chart.vo.PayVO;
import kr.co.codemaker.common.vo.PageVo;
import kr.co.codemaker.user.mypage.dao.MyPayMapper;
import kr.co.codemaker.user.mypage.vo.MyPayVO;
import kr.co.codemaker.user.mypage.vo.PointVO;
/**
* MyPayService.java
*
* @author 우송이
* @version 1.0
* @Since 2020.12
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 최초 생성
*
 */
@Service("myPayService")
public class MyPayService {
	@Resource(name="myPayMapper")
	private MyPayMapper myPayMapper;


	/**
	 * 결제내역 조회
	 * @param pageVo
	 * @return
	 */
	public Map<String, Object> selectAllMyPay(PageVo pageVo)  {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			map.put("myPay", myPayMapper.selectAllMyPay(pageVo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalCnt=0;
		
		try {
			totalCnt = myPayMapper.selectTotalCnt(pageVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int pages = (int)Math.ceil((double)totalCnt/5); 
		map.put("pages", pages);
		
		return map;
	}


	/**
	 * 환불시 상세 결제내역을 조회
	 * @param payVo
	 * @return
	 * @throws Exception
	 */
	public MyPayVO selectMyPay(PayVO payVo) throws Exception {
		return myPayMapper.selectMyPay(payVo);
	}


	/**
	 * 환불여부 변경
	 * @param payId
	 * @return
	 * @throws Exception
	 */
	public int payRefund(String payId) throws Exception {
		return myPayMapper.payRefund(payId);
	}

	/**
	 * 환불 후 포인트 적립
	 * @param pointVo
	 * @return
	 * @throws Exception
	 */
	public int insertRefund(PointVO pointVo) throws Exception {
		return myPayMapper.insertRefund(pointVo);
	}


	

	
}
