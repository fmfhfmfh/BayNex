package kr.co.codemaker.user.course.note.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class NoteRequestVO extends BaseVO {

	private String userId;	// 회원 아이디
	
	// 페이징 작업 추가
	private int page; 		// 현재 보여주는 페이지 번호
	private int startPage; 	// 시작 페이지
	private int endPage; 	// 마지막 페이지
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	

}
