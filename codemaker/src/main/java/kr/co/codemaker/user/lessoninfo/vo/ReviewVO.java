package kr.co.codemaker.user.lessoninfo.vo;

import java.util.Date;
/**
 * 
* ReviewVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 수강후기를 조회하기 위한 VO
*
 */
public class ReviewVO extends PayVO {

	private String payId;		//결제ID
	private String reviewCont;	//수강후기 내용
	private String reviewId;	//수강후기 ID
	private Date reviewDate;	//수강후기 작성일
	private String reviewStar;	//수강후기 별점
	private String userNm;		//작성자 이름
	private String userProfile;	//작성자 프로필사진
	

	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getReviewCont() {
		return reviewCont;
	}
	public void setReviewCont(String reviewCont) {
		this.reviewCont = reviewCont;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(String reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}



	@Override
	public String toString() {
		return "ReviewVO [payId=" + payId + ", reviewCont=" + reviewCont + ", reviewId=" + reviewId + ", reviewDate="
				+ reviewDate + ", reviewStar=" + reviewStar + ", userNm=" + userNm + ", userProfile=" + userProfile
				+ "]";
	}

	
}
