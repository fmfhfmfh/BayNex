package kr.co.codemaker.admin.company.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class CompanyVO extends BaseVO{

	private String comCode;	// 기업 인증코드
	private String comOwner;	// 기업 대표자
	private String comTel;		// 기업 전화번호
	private String comAdd;		// 기업 주소
	private String comId;		// 기업 아이디
	private String comNm;		// 기업명
	private String comState;	// 기업 계약서 승인여부
	private String filesId;	// 첨부파일 아이디
	private String comImg;		// 기업 서명이미지
	
	
	
	public String getFilesId() {
		return filesId;
	}
	public void setFilesId(String filesId) {
		this.filesId = filesId;
	}
	public String getComImg() {
		return comImg;
	}
	public void setComImg(String comImg) {
		this.comImg = comImg;
	}
	public String getComState() {
		return comState;
	}
	public void setComState(String comState) {
		this.comState = comState;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode; 
	}
	public String getComCode() {
		return comCode; 
	}
	public void setComOwner(String comOwner) {
		this.comOwner = comOwner; 
	}
	public String getComOwner() {
		return comOwner; 
	}
	public void setComTel(String comTel) {
		this.comTel = comTel; 
	}
	public String getComTel() {
		return comTel; 
	}
	public void setComAdd(String comAdd) {
		this.comAdd = comAdd; 
	}
	public String getComAdd() {
		return comAdd; 
	}
	public void setComId(String comId) {
		this.comId = comId; 
	}
	public String getComId() {
		return comId; 
	}
	public void setComNm(String comNm) {
		this.comNm = comNm; 
	}
	public String getComNm() {
		return comNm; 
	}

}
