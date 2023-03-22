package kr.co.codemaker.teacher.course.lesson.vo;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.InitBinder;

import kr.co.codemaker.common.vo.BaseVO;

public class LessonVO extends BaseVO{

	private String lesState;	// 강의 상태코드
	private String lesId;		// 강의 아이디
	private String lesCont;	// 강의 소개
	private String subId;		// 과목 아이디
	private String lesNm;		// 강의명
	private String tchId;		// 선생님 아이디
	private int lesTerm;		// 강의 기간
	private int lesCash;		// 강의 수강료
	private String lesDetail; 	// 강의 상세내용
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lesSdate;		// 강의 개설날짜
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lesEdate; 	// 강의 종료날짜
	
	private String subNm;		// 과목명
	
	private String lidxId;		// 강의목차 아이디
	private int lidxDurtime;	// 강의 전체시간
	private int lidxCurtime;	// 강의 재생시간
	
	private List<LessonIndexVO> lesIdxList;	// 강의 목차 리스트(수정)
	private List<LessonIndexVO> lesIdxListInsert;	// 강의 목차 리스트(추가)
	private List<String> lesIdxListDelete;		// 강의 목차 리스트(삭제)
	
	private String modalChk;	// 강의등록 후 시험등록 여부
	
	private String lessonCnt; 	// 영상 갯수
	private String examCnt;	// 시험 갯수 
	
	
	public String getLessonCnt() {
		return lessonCnt;
	}
	public void setLessonCnt(String lessonCnt) {
		this.lessonCnt = lessonCnt;
	}
	public String getExamCnt() {
		return examCnt;
	}
	public void setExamCnt(String examCnt) {
		this.examCnt = examCnt;
	}
	public String getModalChk() {
		return modalChk;
	}
	public void setModalChk(String modalChk) {
		this.modalChk = modalChk;
	}
	public List<String> getLesIdxListDelete() {
		return lesIdxListDelete;
	}
	public void setLesIdxListDelete(List<String> lesIdxListDelete) {
		this.lesIdxListDelete = lesIdxListDelete;
	}
	public List<LessonIndexVO> getLesIdxList() {
		return lesIdxList;
	}
	public void setLesIdxList(List<LessonIndexVO> lesIdxList) {
		this.lesIdxList = lesIdxList;
	}
	public List<LessonIndexVO> getLesIdxListInsert() {
		return lesIdxListInsert;
	}
	public void setLesIdxListInsert(List<LessonIndexVO> lesIdxListInsert) {
		this.lesIdxListInsert = lesIdxListInsert;
	}
	public String getLesDetail() {
		return lesDetail;
	}
	public void setLesDetail(String lesDetail) {
		this.lesDetail = lesDetail;
	}
	public Date getLesSdate() {
		return lesSdate;
	}
	public void setLesSdate(Date lesSdate) {
		this.lesSdate = lesSdate;
	}
	public Date getLesEdate() {
		return lesEdate;
	}
	public void setLesEdate(Date lesEdate) {
		this.lesEdate = lesEdate;
	}
	public String getLidxId() {
		return lidxId;
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId;
	}
	public int getLidxDurtime() {
		return lidxDurtime;
	}
	public void setLidxDurtime(int lidxDurtime) {
		this.lidxDurtime = lidxDurtime;
	}
	public int getLidxCurtime() {
		return lidxCurtime;
	}
	public void setLidxCurtime(int lidxCurtime) {
		this.lidxCurtime = lidxCurtime;
	}
	
	public String getSubNm() {
		return subNm;
	}
	public void setSubNm(String subNm) {
		this.subNm = subNm;
	}
	public void setLesState(String lesState) {
		this.lesState = lesState; 
	}
	public String getLesState() {
		return lesState; 
	}
	public void setLesId(String lesId) {
		this.lesId = lesId; 
	}
	public String getLesId() {
		return lesId; 
	}
	public void setLesCont(String lesCont) {
		this.lesCont = lesCont; 
	}
	public String getLesCont() {
		return lesCont; 
	}
	public void setSubId(String subId) {
		this.subId = subId; 
	}
	public String getSubId() {
		return subId; 
	}
	public void setLesNm(String lesNm) {
		this.lesNm = lesNm; 
	}
	public String getLesNm() {
		return lesNm; 
	}
	public void setTchId(String tchId) {
		this.tchId = tchId; 
	}
	public String getTchId() {
		return tchId; 
	}
	public void setLesTerm(int lesTerm) {
		this.lesTerm = lesTerm; 
	}
	public int getLesTerm() {
		return lesTerm; 
	}
	public void setLesCash(int lesCash) {
		this.lesCash = lesCash; 
	}
	public int getLesCash() {
		return lesCash; 
	}

}
