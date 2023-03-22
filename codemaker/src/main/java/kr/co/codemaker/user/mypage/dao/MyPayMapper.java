package kr.co.codemaker.user.mypage.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.chart.vo.PayVO;
import kr.co.codemaker.common.vo.PageVo;
import kr.co.codemaker.user.mypage.vo.MyPayVO;
import kr.co.codemaker.user.mypage.vo.PointVO;
/**
* MyPayMapper.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 최초 생성
*
 */
@Mapper("myPayMapper")
public interface MyPayMapper {

	/**
	 * 결제내역조회
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	List<MyPayVO> selectAllMyPay(PageVo pageVo)throws Exception;

	/**
	 * 결제내역 목록 총 갯수를 구하기 위한 메서드
	 * @param pageVo
	 * @return
	 * @throws Exception
	 */
	int selectTotalCnt(PageVo pageVo)throws Exception;

	/**
	 * 환불시 상세 결제내역을 조회
	 * @param payVo
	 * @return
	 * @throws Exception
	 */
	MyPayVO selectMyPay(PayVO payVo)throws Exception;

	/**
	 * 환불여부 변경
	 * @param payId
	 * @return
	 * @throws Exception
	 */
	int payRefund(String payId)throws Exception;

	/**
	 * 환불 후 포인트 적립
	 * @param pointVo
	 * @return
	 * @throws Exception
	 */
	int insertRefund(PointVO pointVo)throws Exception;
}
