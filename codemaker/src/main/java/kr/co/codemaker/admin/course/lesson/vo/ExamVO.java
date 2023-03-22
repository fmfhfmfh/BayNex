package kr.co.codemaker.admin.course.lesson.vo;

import java.util.Date;

/**
 * 
* ExamVO.java
*
* @author 김미연
* @version 1.0
* @since 2020. 11. 24.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
public class ExamVO extends LessonVO {

	private String examId; 		// 시험 아이디
	private String examNm; 		// 시험명
	private String examState; 	// 시험 등록 상태
	private Date examDate; 		// 시험 작성일
	private String lidxCont;	// 목차명
	private String lidxId;		// 강의 목차 아이디
	private String lesId;		// 강의 아이디
	
	
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public String getExamNm() {
		return examNm;
	}
	public void setExamNm(String examNm) {
		this.examNm = examNm;
	}
	public String getExamState() {
		return examState;
	}
	public void setExamState(String examState) {
		this.examState = examState;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public String getLidxCont() {
		return lidxCont;
	}
	public void setLidxCont(String lidxCont) {
		this.lidxCont = lidxCont;
	}
	public String getLidxId() {
		return lidxId;
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId;
	}

}
