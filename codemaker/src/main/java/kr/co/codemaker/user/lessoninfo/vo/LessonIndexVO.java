package kr.co.codemaker.user.lessoninfo.vo;

import java.util.List;

import kr.co.codemaker.common.vo.BaseVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;

/**
 * 
* LessonIndexVO.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 8.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
public class LessonIndexVO extends BaseVO{

	private String lidxCont;	// 목차 과정내용
	private String lesId;		// 강의 아이디
	private String lidxNum;		// 목차 강의차수
	private String lidxId;		// 목차 아이디
	private String lidxPath;	// 강의 주소
	private int lidxDurtime;	// 강의 전체시간
	private int lidxCurtime;	// 강의 재생시간
	
	private String userId;		// 회원 아이디
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public void setLidxCont(String lidxCont) {
		this.lidxCont = lidxCont; 
	}
	public String getLidxCont() {
		return lidxCont; 
	}
	public void setLesId(String lesId) {
		this.lesId = lesId; 
	}
	public String getLesId() {
		return lesId; 
	}
	public void setLidxNum(String lidxNum) {
		this.lidxNum = lidxNum; 
	}
	public String getLidxNum() {
		return lidxNum; 
	}
	public void setLidxId(String lidxId) {
		this.lidxId = lidxId; 
	}
	public String getLidxId() {
		return lidxId; 
	}
	public String getLidxPath() {
		return lidxPath;
	}
	public void setLidxPath(String lidxPath) {
		this.lidxPath = lidxPath;
	}
	
	

}
