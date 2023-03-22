package kr.co.codemaker.user.classroom.exam.vo;

import java.util.Date;
import java.util.List;

public class ExamScoreVO extends ExamResultVO {
	
	private String examId;	// 시험 아이디
	private String userId;	// 회원 아이디
	private int esFscore;	// 첫점수
	private int esLscore;	// 다시풀기 점수
	private Date esEdate;	// 시험을 마지막으로 푼 날짜
	
	private String examNm;	// 시험명
	
	
	public String getExamNm() {
		return examNm;
	}
	public void setExamNm(String examNm) {
		this.examNm = examNm;
	}
	public Date getEsEdate() {
		return esEdate;
	}
	public void setEsEdate(Date esEdate) {
		this.esEdate = esEdate;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getEsFscore() {
		return esFscore;
	}
	public void setEsFscore(int esFscore) {
		this.esFscore = esFscore;
	}
	public int getEsLscore() {
		return esLscore;
	}
	public void setEsLscore(int esLscore) {
		this.esLscore = esLscore;
	}
	
	
}
