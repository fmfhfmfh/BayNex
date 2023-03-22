package kr.co.codemaker.user.cart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.cart.dao.UserPayMapper;
import kr.co.codemaker.user.cart.vo.CartVO;
import kr.co.codemaker.user.cart.vo.LessonVO;
import kr.co.codemaker.user.cart.vo.PayVO;
import kr.co.codemaker.user.cart.vo.PointVO;

/**
* UserPayService.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 4.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 최초작성
*
 */
@Service("userPayService")
public class UserPayService {
	
	@Resource(name="userPayMapper")
	private UserPayMapper userPayMapper;
	
	public int insertPay(PayVO payVo) throws Exception {
		return userPayMapper.insertPay(payVo);
	}
	
	public LessonVO selectLessonInfo(LessonVO lessonVo) throws Exception {
		return userPayMapper.selectLessonInfo(lessonVo);
	}
	
	public int insertCart(CartVO cartVo) throws Exception {
		return userPayMapper.insertCart(cartVo);
	}
	
	public CartVO selectCart(CartVO cartVo) throws Exception {
		return userPayMapper.selectCart(cartVo);
	}
	
	public List<CartVO> selectCartList(CartVO cartVo) throws Exception{
		return userPayMapper.selectCartList(cartVo);
	}
	
	public int deleteCart(CartVO cartVo) throws Exception {
		return userPayMapper.deleteCart(cartVo);
	}
	
	public PointVO selectPoint(PointVO pointVo) throws Exception{
		return userPayMapper.selectPoint(pointVo);
	}
	
	public int usePoint(PointVO pointVo) throws Exception{
		return userPayMapper.usePoint(pointVo);
	}
	
	public List<PayVO> selectCheckPay(PayVO payVo) throws Exception{
		return userPayMapper.selectCheckPay(payVo);
	}
}
