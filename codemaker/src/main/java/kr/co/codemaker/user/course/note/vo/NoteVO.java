package kr.co.codemaker.user.course.note.vo;

import java.util.Date;

import kr.co.codemaker.common.vo.BaseVO;

public class NoteVO extends BaseVO {

	private String noteId; 		// 노트 아이디
	private String noteTitle; 	// 노트 제목
	private String noteCont; 	// 노트 내용
	private Date noteDate; 		// 노트 작성일
	private String userId; 		// 회원아이디

	// 페이징 작업 추가
	private int page; 		// 현재 보여주는 페이지 번호
	private int startPage; 	// 시작 페이지
	private int endPage; 	// 마지막 페이지
	
	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteCont() {
		return noteCont;
	}
	public void setNoteCont(String noteCont) {
		this.noteCont = noteCont;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
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
