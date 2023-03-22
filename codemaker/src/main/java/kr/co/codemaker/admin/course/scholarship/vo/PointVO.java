package kr.co.codemaker.admin.course.scholarship.vo;

import java.util.Date;

/**
 * 
* PointVO.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 17.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
public class PointVO {

	private String pointId;		// 포인트 아이디
	private Date pointDate;		// 포인트 사용일
	private int pointUpdate;	// 포인트 사용금액
	private String pointGn;		// 포인트 구분
	private int pointSum;		// 남은 포인트
	private String userId;		// 회원 아이디
	
	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public Date getPointDate() {
		return pointDate;
	}
	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}
	public int getPointUpdate() {
		return pointUpdate;
	}
	public void setPointUpdate(int pointUpdate) {
		this.pointUpdate = pointUpdate;
	}
	public String getPointGn() {
		return pointGn;
	}
	public void setPointGn(String pointGn) {
		this.pointGn = pointGn;
	}
	public int getPointSum() {
		return pointSum;
	}
	public void setPointSum(int pointSum) {
		this.pointSum = pointSum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
