package kr.co.codemaker.common.vo;

public class UserVO extends BaseVO{

	private String userPass;
	private String userTel;
	private String userNm;
	private String userId;
	private String userOut;
	private String userBlack;
	private String userProfile;
	
	private String count; // 신고당한 횟수
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
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
	@Override
	public String toString() {
		return "UserVO [userPass=" + userPass + ", userTel=" + userTel + ", userNm=" + userNm + ", userId=" + userId
				+ ", userOut=" + userOut + ", userBlack=" + userBlack + ", userProfile=" + userProfile + "]";
	}
	
	

}
