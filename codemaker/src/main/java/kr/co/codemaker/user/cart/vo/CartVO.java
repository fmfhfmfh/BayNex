package kr.co.codemaker.user.cart.vo;

import java.util.List;

public class CartVO {
	private String lesId;
	private String userId;
	private List<CartVO> cartList;
	
	public List<CartVO> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartVO> cartList) {
		this.cartList = cartList;
	}

	public CartVO() {
	}

	public CartVO(String userId) {
		this.userId = userId;
	}

	public void setLesId(String lesId) {
		this.lesId = lesId; 
	}
	public String getLesId() {
		return lesId; 
	}
	public void setUserId(String userId) {
		this.userId = userId; 
	}
	public String getUserId() {
		return userId; 
	}
	
	@Override
	public String toString() {
		return "CartVO [lesId=" + lesId + ", userId=" + userId + "]";
	}
	
	
}
