package kr.co.codemaker.user.board.community.vo;

import java.util.Date;

import kr.co.codemaker.common.vo.BaseVO;

public class PostVO extends BaseVO{
	
	private int postNo;			//게시글번호
	private String postTitle;		//게시글제목
	private Date postDate;		//게시글작성일자
	private int postViews;		//게시글조회수
	private String postContent;	//게시글내용
	private String userId;		//회원아이디
	
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getPostViews() {
		return postViews;
	}
	public void setPostViews(int postViews) {
		this.postViews = postViews;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "CommunityVO [postNo=" + postNo + ", postTitle=" + postTitle + ", postDate=" + postDate + ", postViews="
				+ postViews + ", postContent=" + postContent + ", userId=" + userId + "]";
	}
}
