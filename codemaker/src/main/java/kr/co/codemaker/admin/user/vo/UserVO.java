package kr.co.codemaker.admin.user.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class UserVO extends BaseVO{

	private String userPass;	//회원비밀번호
	private String userTel;		//회원전화번호
	private String userNm;		//회원이름
	private String userId;		//회원아이디
	private String userOut;		//회원구분 N면 정상 Y면 탈퇴
	private String userBlack;	//회원 블랙리스트구분 N정상 Y 블랙
	private String userProfile;	//회원 프로필
	
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass; 
	}
	public String getUserPass() {
		return userPass; 
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel; 
	}
	public String getUserTel() {
		return userTel; 
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm; 
	}
	public String getUserNm() {
		return userNm; 
	}
	public void setUserId(String userId) {
		this.userId = userId; 
	}
	public String getUserId() {
		return userId; 
	}
	public void setUserOut(String userOut) {
		this.userOut = userOut; 
	}
	public String getUserOut() {
		return userOut; 
	}
	public void setUserBlack(String userBlack) {
		this.userBlack = userBlack; 
	}
	public String getUserBlack() {
		return userBlack; 
	}

}
