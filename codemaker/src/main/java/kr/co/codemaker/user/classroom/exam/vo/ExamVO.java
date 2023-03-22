package kr.co.codemaker.user.classroom.exam.vo;

import java.util.Date;
import java.util.List;


/**
 * 시험VO
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
public class ExamVO extends ExamScoreVO {
	
	private String examId;		// 시험 아이디
	private String examNm;		// 시험명
	private String examState;	// 시험 등록 상태
	private Date examDate;		// 시험 작성일
	private String lidxId;		// 강의 목차 아이디
	private String lidxCont;	// 목차명
	private String lesId;		// 강의 아이디
	private String lesNm;		// 강의명
	
	private String userId;		// 회원 아이디
	
	private String searchEsFscore;	// 시험 점수 유무
	private float avgScore;			// 평균 점수
	
	private List<String> queIdList;			// 문제 아이디 리스트
	private List<String> studentAnswers;	// 학생 정답 리스트
	private List<Integer> erCheckList;		// 학생 오답 여부
	
	private String searchEsScore;	// 시험 점수 유무
	private int queTotal;			// 총점

	// 페이징 작업 추가
	private int page; 			// 현재 보여주는 페이지 번호
	
	private String resultState;		// 시험 결과 보여주는 유무
	
	
	
	public String getLesNm() {
		return lesNm;
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm;
	}
	public String getResultState() {
		return resultState;
	}
	public void setResultState(String resultState) {
		this.resultState = resultState;
	}
	public List<String> getStudentAnswers() {
		return studentAnswers;
	}
	public void setStudentAnswers(List<String> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
	public int getQueTotal() {
		return queTotal;
	}
	public void setQueTotal(int queTotal) {
		this.queTotal = queTotal;
	}
	public String getSearchEsScore() {
		return searchEsScore;
	}
	public void setSearchEsScore(String searchEsScore) {
		this.searchEsScore = searchEsScore;
	}
	public List<String> getQueIdList() {
		return queIdList;
	}
	public void setQueIdList(List<String> queIdList) {
		this.queIdList = queIdList;
	}
	public List<Integer> getErCheckList() {
		return erCheckList;
	}
	public void setErCheckList(List<Integer> erCheckList) {
		this.erCheckList = erCheckList;
	}
	public float getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}
	public String getSearchEsFscore() {
		return searchEsFscore;
	}
	public void setSearchEsFscore(String searchEsFscore) {
		this.searchEsFscore = searchEsFscore;
	}
	public String getLidxId() {
		return lidxId;
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId;
	}
	public String getLidxCont() {
		return lidxCont;
	}
	public void setLidxCont(String lidxCont) {
		this.lidxCont = lidxCont;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPage() {
		if(page == 0) page = 1;
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
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
	
}
