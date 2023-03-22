package kr.co.codemaker.teacher.signup.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class ResumeVO extends BaseVO{

	private String resId;		//이력서 아이디
	private String resCode;		//이력서 승인코드
	private String resNm;		//이력서 이름
	private String resTel;		//이력서 전화번호
	private String resMail;		//이력서 이메일
	private String resProfile;	//이력서 프로필
	private String resMotive;	//이력서 지원동기
	private String resEdu;		//이력서 학력
	private String resLicense;	//이력서 자격증
	private String resCareer;	//이력서 경력
	private String resState;	//이력서 관리자 승인상태
	
	public ResumeVO() {
	}
	
	public ResumeVO(String resId, String resCode, String resNm, String resTel, 
					String resMail, String resProfile_path, String resMotive, String resEdu,
					String resLicense, String resCareer, String resState) {
		this.resId = resId;
		this.resCode = resCode;
		this.resNm = resNm;
		this.resTel = resTel;
		this.resMail = resMail;
		this.resProfile = resProfile_path;
		this.resMotive = resMotive;
		this.resEdu = resEdu;
		this.resLicense = resLicense;
		this.resCareer = resCareer;
		this.resState = resState;
	}
	
	public String getResProfile() {
		return resProfile;
	}

	public void setResProfile(String resProfile) {
		this.resProfile = resProfile;
	}

	public ResumeVO(String resCode) {
		super();
		this.resCode = resCode;
	}

	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResNm() {
		return resNm;
	}
	public void setResNm(String resNm) {
		this.resNm = resNm;
	}
	public String getResTel() {
		return resTel;
	}
	public void setResTel(String resTel) {
		this.resTel = resTel;
	}
	public String getResMail() {
		return resMail;
	}
	public void setResMail(String resMail) {
		this.resMail = resMail;
	}
	
	public String getResMotive() {
		return resMotive;
	}
	public void setResMotive(String resMotive) {
		this.resMotive = resMotive;
	}
	public String getResEdu() {
		return resEdu;
	}
	public void setResEdu(String resEdu) {
		this.resEdu = resEdu;
	}
	public String getResLicense() {
		return resLicense;
	}
	public void setResLicense(String resLicense) {
		this.resLicense = resLicense;
	}
	public String getResCareer() {
		return resCareer;
	}
	public void setResCareer(String resCareer) {
		this.resCareer = resCareer;
	}
	public String getResState() {
		return resState;
	}
	public void setResState(String resState) {
		this.resState = resState;
	}
}
