package kr.co.codemaker.admin.company.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class FilesVO extends BaseVO{

	private String filesGroup;	// 첨부파일그룹
	private String filesNm;	// 첨부파일명
	private String filesId;	// 첨부파일 아이디
	private String filesPath;	// 첨부파일 경로
	
	public void setFilesGroup(String filesGroup) {
		this.filesGroup = filesGroup; 
	}
	public String getFilesGroup() {
		return filesGroup; 
	}
	public void setFilesNm(String filesNm) {
		this.filesNm = filesNm; 
	}
	public String getFilesNm() {
		return filesNm; 
	}
	public void setFilesId(String filesId) {
		this.filesId = filesId; 
	}
	public String getFilesId() {
		return filesId; 
	}
	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath; 
	}
	public String getFilesPath() {
		return filesPath; 
	}

}
