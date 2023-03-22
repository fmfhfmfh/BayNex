package kr.co.codemaker.user.mypage.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.common.vo.PageVo;
import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.mypage.vo.PointVO;

@Mapper("myPageMapper")
public interface MyPageMapper{

	/**
	 * 회원정보 조회
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserVO myinfoSelect(String userId) throws Exception;

	/**
	 * 회원탈퇴
	 * @param userVo
	 * @return
	 * @throws Exception
	 */
	int deleteUser(UserVO userVo)throws Exception;

	/**
	 * 회원정보수정
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int updateUser(UserVO userId)throws Exception;

	/**
	 * 포인트내역 조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	List<PointVO> selectPoint(PageVo pageVo)throws Exception;

	/**
	 * 포인트내역 목록 총 갯수를 구하기 위한 메서드
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	int selectTotalCnt(PageVo pageVo)throws Exception;

	/**
	 * 포인트적립
	 * @param pointVo
	 * @return
	 * @throws Exception
	 */
	int insertPoint(PointVO pointVo)throws Exception;

	/**
	 * 포인트환불
	 * @param pointVo
	 * @return
	 * @throws Exception
	 */
	int deletePoint(PointVO pointVo)throws Exception;

	/**
	 * 환불시 회원이 환불하려는 금액과 회원의 포인트 잔액과 조회
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int deletePointCompare(String userId)throws Exception;

}
