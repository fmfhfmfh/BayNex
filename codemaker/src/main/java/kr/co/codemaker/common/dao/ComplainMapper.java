package kr.co.codemaker.common.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.common.vo.ComplainVO;
import kr.co.codemaker.common.vo.UserVO;

@Mapper("complainMapper")
public interface ComplainMapper {
	
	/**
	 * 모든 신고에대한 조회
	 * @author 박경호
	 * @return 들어온 모든 신고
	 */
	public List<ComplainVO> selectAllComplain(Map<String, Object> map) throws Exception;
	
	/**
	 * 글에 대한 신고내역을 작성하는 메서드
	 * @author 박경호
	 * @param complainVo 신고 객체
	 * @return 신고가 완료된 횟수
	 */
	public int insertComplain(ComplainVO complainVo) throws Exception;
	
	/**
	 * 하나의 신고내역을 조회하는 메서드
	 * @author 박경호
	 * @param complainVo 하나의 신고내역 정보
	 * @return 하나의 신고내역
	 */
	public ComplainVO selectComplain(ComplainVO complainVo) throws Exception;
	
	/**
	 * 신고를 처리하는 메서드
	 * @author 박경호
	 * @param complainVo
	 * @return 신고를 처리한 횟수
	 */
	public int checkComplain(ComplainVO complainVo) throws Exception;
	
	/**
	 * 댓글이 있는 qna를 조회하는 메서드
	 * @author 박경호
	 * @param complainVo
	 * @return 해당 댓글을 포함한 qna정보
	 */
	public String selectReplyQna(ComplainVO complainVo) throws Exception;
	
	/**
	 * 블랙리스트 조건에 부합하는 회원을 조회하는 메서드
	 * @author 박경호
	 * @return 블랙리스트 조건에 부합하는 회원
	 */
	public List<UserVO> selectBlackList() throws Exception;
	
	/**
	 * 블랙리스트에 등록하는 메서드
	 * @author 박경호
	 * @param userVo
	 * @return 블랙리스트에 추가된 회원 수
	 */
	public int insertBlackList(UserVO userVo) throws Exception;
	
	/**
	 * 모든 신고횟수를 조회하는메서드
	 * @author 박경호
	 * @return 총 신고횟수
	 */
	public int complainTotalCnt() throws Exception;
	
}
