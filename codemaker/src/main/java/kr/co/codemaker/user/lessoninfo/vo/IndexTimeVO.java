package kr.co.codemaker.user.lessoninfo.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class IndexTimeVO extends BaseVO{

	private String userId;		// 사용자 아이디
	private String lidxId;		// 강의목차 아이디
	private int lidxCurtime;	// 강의 재생시간
	
	private String lesId;		// 강의 아이디
	
	
	
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public void setUserId(String userId) {
		this.userId = userId; 
	}
	public String getUserId() {
		return userId; 
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId; 
	}
	public String getLidxId() {
		return lidxId; 
	}
	public void setLidxCurtime(int lidxCurtime) {
		this.lidxCurtime = lidxCurtime; 
	}
	public int getLidxCurtime() {
		return lidxCurtime; 
	}

}
