package kr.co.codemaker.user.classroom.exam.vo;


public class ExamResultVO extends QuestionVO {
	
	private String queId;		// 문제 아이디
	private String userId;		// 회원 아이디
	private String erAnswer;	// 학생 정답
	private int erCheck;		// 오답 여부
	private String examId;		// 시험 아이디
	
	private int answerCount;	// 정답 개수
	
	
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public int getErCheck() {
		return erCheck;
	}
	public void setErCheck(int erCheck) {
		this.erCheck = erCheck;
	}
	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getErAnswer() {
		return erAnswer;
	}
	public void setErAnswer(String erAnswer) {
		this.erAnswer = erAnswer;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	
}
