package kr.co.codemaker.common.vo;

public class FilesVO extends BaseVO{

	private String filesGroup;
	private String filesNm;
	private String filesId;
	private String filesPath;
	
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
