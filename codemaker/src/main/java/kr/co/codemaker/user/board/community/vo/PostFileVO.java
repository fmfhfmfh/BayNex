package kr.co.codemaker.user.board.community.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class PostFileVO extends BaseVO{

	private String fileNo;		//파일번호
	private String fileName;	//파일실제이름
	private String filePath;	//파일경로
	private int postNo;		//게시글번호
	
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	@Override
	public String toString() {
		return "PostFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", postNo="
				+ postNo + "]";
	}
}
