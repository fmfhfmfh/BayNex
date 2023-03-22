package kr.co.codemaker.admin.vo;

import kr.co.codemaker.common.vo.BaseVO;

public class AdminVO extends BaseVO {

	private String adminId;		// 관리자 아이디
	private String adminPass;	// 관리자 비밀번호
	
	public AdminVO() {
	}
	
	public AdminVO(String adminId, String adminPass) {
		this.adminId = adminId;
		this.adminPass = adminPass;
	}
	
	public void setAdminId(String adminId) {
		this.adminId = adminId; 
	}
	public String getAdminId() {
		return adminId; 
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass; 
	}
	public String getAdminPass() {
		return adminPass; 
	}
	@Override
	public String toString() {
		return "AdminVO [adminId=" + adminId + ", adminPass=" + adminPass + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((adminPass == null) ? 0 : adminPass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminVO other = (AdminVO) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (adminPass == null) {
			if (other.adminPass != null)
				return false;
		} else if (!adminPass.equals(other.adminPass))
			return false;
		return true;
	}
	
	
}
