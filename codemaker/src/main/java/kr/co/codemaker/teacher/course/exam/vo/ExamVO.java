package kr.co.codemaker.teacher.course.exam.vo;

import java.util.Date;
import java.util.List;

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
	
	private String searchSubId;		// 선택한 과목 아이디
	private String searchLesId;		// 선택한 강의 아이디
	private String searchExamState;	// 선택한 등록 상태
	
	private List<QuestionVO> questionList;			// 문제 리스트
	private List<AnswersheetVO> answersheetLists;	// 보기 리스트
	
	private List<String> queContList;		// 문제 리스트
	private List<String> queAnswerList;		// 정답 리스트
	private List<String> queExplainList;	// 해설 리스트
	private List<Integer> queScoreList;		// 점수 리스트

	private List<String> ansContList;		// 보기 리스트
	
	private List<String> delqueIdList;	// 삭제하는 리스트
	
	// 페이징 작업 추가
	private int page; 			// 현재 보여주는 페이지 번호
	
	public List<String> getDelqueIdList() {
		return delqueIdList;
	}
	public void setDelqueIdList(List<String> delqueIdList) {
		this.delqueIdList = delqueIdList;
	}
	public List<String> getQueContList() {
		return queContList;
	}
	public void setQueContList(List<String> queContList) {
		this.queContList = queContList;
	}
	public List<String> getQueAnswerList() {
		return queAnswerList;
	}
	public void setQueAnswerList(List<String> queAnswerList) {
		this.queAnswerList = queAnswerList;
	}
	public List<String> getQueExplainList() {
		return queExplainList;
	}
	public void setQueExplainList(List<String> queExplainList) {
		this.queExplainList = queExplainList;
	}
	public List<Integer> getQueScoreList() {
		return queScoreList;
	}
	public void setQueScoreList(List<Integer> queScoreList) {
		this.queScoreList = queScoreList;
	}
	public List<String> getAnsContList() {
		return ansContList;
	}
	public void setAnsContList(List<String> ansContList) {
		this.ansContList = ansContList;
	}
	public String getLidxId() {
		return lidxId;
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId;
	}
	public List<QuestionVO> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionVO> questionList) {
		this.questionList = questionList;
	}
	public List<AnswersheetVO> getAnswersheetLists() {
		return answersheetLists;
	}
	public void setAnswersheetLists(List<AnswersheetVO> answersheetLists) {
		this.answersheetLists = answersheetLists;
	}
	public String getSearchExamState() {
		return searchExamState;
	}
	public void setSearchExamState(String searchExamState) {
		this.searchExamState = searchExamState;
	}
	public String getSearchSubId() {
		return searchSubId;
	}
	public void setSearchSubId(String searchSubId) {
		this.searchSubId = searchSubId;
	}
	public String getSearchLesId() {
		return searchLesId;
	}
	public void setSearchLesId(String searchLesId) {
		this.searchLesId = searchLesId;
	}
	public String getLidxCont() {
		return lidxCont;
	}
	public void setLidxCont(String lidxCont) {
		this.lidxCont = lidxCont;
	}
	public int getPage() {
		if(page == 0) page = 1;
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
