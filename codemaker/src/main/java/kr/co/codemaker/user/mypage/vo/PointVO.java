package kr.co.codemaker.user.mypage.vo;

import java.util.Date;

public class PointVO {

	private int pointSum;
	private Date pointDate;
	private String pointId;
	private String pointGn;
	private String userId;
	private int pointUpdate;
	
	public int getPointSum() {
		return pointSum;
	}
	public void setPointSum(int pointSum) {
		this.pointSum = pointSum;
	}
	public Date getPointDate() {
		return pointDate;
	}
	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}
	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public String getPointGn() {
		return pointGn;
	}
	public void setPointGn(String pointGn) {
		this.pointGn = pointGn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPointUpdate() {
		return pointUpdate;
	}
	public void setPointUpdate(int pointUpdate) {
		this.pointUpdate = pointUpdate;
	}
	@Override
	public String toString() {
		return "PointVO [pointSum=" + pointSum + ", pointDate=" + pointDate + ", pointId=" + pointId + ", pointGn="
				+ pointGn + ", userId=" + userId + ", pointUpdate=" + pointUpdate + "]";
	}


	
	
}
