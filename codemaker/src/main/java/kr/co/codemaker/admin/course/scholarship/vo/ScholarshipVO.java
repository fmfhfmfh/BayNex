package kr.co.codemaker.admin.course.scholarship.vo;

import java.util.Date;
import java.util.List;

/**
* ScholarshipVO.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 17.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
public class ScholarshipVO {
	
	private String schlId;		// 장학금 아이디
    private int schlPay;		// 장학금 금액
	private Date schlDate;		// 장학금 지급일
	private String schlState;	// 장학금 지급사유
	private String lesId;		// 강의 아이디
	private String userId;		// 회원 아이디
	
	private String lesNm;		// 강의명
	private String userNm;		// 회원명
	private String userTel;		// 회원전화번호
	private float userAvg;		// 회원 평균 성적
	
	private int completeExamCnt;	// 완강하고 시험까지 모두 푼 회원 수
	private int completeLesCnt;		// 완강한 회원의 수
	private int totalCnt;			// 수강중인 회원 수
	
	private String searchSubject;	// 선택한 과목	- 지급할 장학금 내역
	private String searchASubject;	// 선택한 과목 - 지급한 장학금 내역
	
	private int totalPay;			// 총 지급액
	private int completeLesPay;		// 완강 지급 수
	private int completeExamPay;	// 시험 지급 수
	
	private List<String> userIdList;	// 지급할 회원 리스트
	
	private String curGn;	// 조회 구분
	private String excelGn;	// 엑셀 다운 구분
	
	private String searchGn;	// 조회 탭 구분
	
	
	public String getSearchGn() {
		return searchGn;
	}
	public void setSearchGn(String searchGn) {
		this.searchGn = searchGn;
	}
	public String getExcelGn() {
		return excelGn;
	}
	public void setExcelGn(String excelGn) {
		this.excelGn = excelGn;
	}
	public String getCurGn() {
		return curGn;
	}
	public void setCurGn(String curGn) {
		this.curGn = curGn;
	}
	public List<String> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}
	public float getUserAvg() {
		return userAvg;
	}
	public void setUserAvg(float userAvg) {
		this.userAvg = userAvg;
	}
	public int getCompleteLesPay() {
		return completeLesPay;
	}
	public void setCompleteLesPay(int completeLesPay) {
		this.completeLesPay = completeLesPay;
	}
	public int getCompleteExamPay() {
		return completeExamPay;
	}
	public void setCompleteExamPay(int completeExamPay) {
		this.completeExamPay = completeExamPay;
	}
	public int getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}
	public String getSearchASubject() {
		return searchASubject;
	}
	public void setSearchASubject(String searchASubject) {
		this.searchASubject = searchASubject;
	}
	public String getSearchSubject() {
		return searchSubject;
	}
	public void setSearchSubject(String searchSubject) {
		this.searchSubject = searchSubject;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public String getLesNm() {
		return lesNm;
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public int getCompleteExamCnt() {
		return completeExamCnt;
	}
	public void setCompleteExamCnt(int completeExamCnt) {
		this.completeExamCnt = completeExamCnt;
	}
	public int getCompleteLesCnt() {
		return completeLesCnt;
	}
	public void setCompleteLesCnt(int completeLesCnt) {
		this.completeLesCnt = completeLesCnt;
	}
	public String getSchlId() {
		return schlId;
	}
	public void setSchlId(String schlId) {
		this.schlId = schlId;
	}
	public int getSchlPay() {
		return schlPay;
	}
	public void setSchlPay(int schlPay) {
		this.schlPay = schlPay;
	}
	public Date getSchlDate() {
		return schlDate;
	}
	public void setSchlDate(Date schlDate) {
		this.schlDate = schlDate;
	}
	public String getSchlState() {
		return schlState;
	}
	public void setSchlState(String schlState) {
		this.schlState = schlState;
	}
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
