package kr.co.codemaker.user.classroom.exam.vo;

import kr.co.codemaker.common.vo.BaseVO;

/**
 * 문제 VO
* QuestionVO.java
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
public class QuestionVO extends AnswersheetVO {
	
	private String queId;		// 시험 문제 아이디
	private String queCont;		// 시험 문제
	private String queAnswer;	// 시험 정답
	private String queExplain;	// 문제 해설
	private int queScore;		// 문제 배점
	private String examId;		// 시험 아이디
	
	public QuestionVO() {
	}
	
	public QuestionVO(String queId, String queCont, String queAnswer, String queExplain, int queScore, String examId) {
		this.queId = queId;
		this.queCont = queCont;
		this.queAnswer = queAnswer;
		this.queExplain = queExplain;
		this.queScore = queScore;
		this.examId = examId;
	}

	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	public String getQueCont() {
		return queCont;
	}
	public void setQueCont(String queCont) {
		this.queCont = queCont;
	}
	public String getQueAnswer() {
		return queAnswer;
	}
	public void setQueAnswer(String queAnswer) {
		this.queAnswer = queAnswer;
	}
	public String getQueExplain() {
		return queExplain;
	}
	public void setQueExplain(String queExplain) {
		this.queExplain = queExplain;
	}
	public int getQueScore() {
		return queScore;
	}
	public void setQueScore(int queScore) {
		this.queScore = queScore;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}

	
}
