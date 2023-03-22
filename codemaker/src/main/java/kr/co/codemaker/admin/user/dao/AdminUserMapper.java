package kr.co.codemaker.admin.user.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.user.vo.UserVO;

/**
* AdminUserMapper.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 14.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 관리자 회원정보조회 최초작성
*
 */
@Mapper("adminUserMapper")
public interface AdminUserMapper {
	
	/**
	 * 관리자 전체 회원 조회
	 * @return 전체 회원정보
	 */
	public List<UserVO> selectAllUser(UserVO userVo) throws Exception;
}
