package kr.co.codemaker.user.classroom.exam.vo;

import kr.co.codemaker.common.vo.BaseVO;

/**
 * 문제 보기VO
* AnswersheetVO.java
*
* @author 김미연
* @version 1.0
* @since 2020. 11. 26.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
public class AnswersheetVO extends BaseVO {
	
	private String ansId;		// 보기 아이디
	private String ansCont;		// 보기 내용
	private String queId;		// 시험문제 아이디
	
	public AnswersheetVO() {
	}
	
	public AnswersheetVO(String ansId, String ansCont, String queId) {
		
		this.ansId = ansId;
		this.ansCont = ansCont;
		this.queId = queId;
	}

	public String getAnsId() {
		return ansId;
	}
	public void setAnsId(String ansId) {
		this.ansId = ansId;
	}
	public String getAnsCont() {
		return ansCont;
	}
	public void setAnsCont(String ansCont) {
		this.ansCont = ansCont;
	}
	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	
}
