package kr.co.codemaker.admin.course.lesson.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class LessonIndexVO extends BaseVO {

	private String lidxId;	 // 강의 목차 아이디
	private int lidxNum; 	 // 강의 차수
	private String lidxCont; // 강의 목차 내용
	private String lidxPath; // 강의 동영상
	private String lesId; 	 // 강의 아이디


	public String getLidxId() {
		return lidxId;
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId;
	}
	public int getLidxNum() {
		return lidxNum;
	}
	public void setLidxNum(int lidxNum) {
		this.lidxNum = lidxNum;
	}
	public String getLidxCont() {
		return lidxCont;
	}
	public void setLidxCont(String lidxCont) {
		this.lidxCont = lidxCont;
	}
	public String getLidxPath() {
		return lidxPath;
	}
	public void setLidxPath(String lidxPath) {
		this.lidxPath = lidxPath;
	}
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	
	

}
