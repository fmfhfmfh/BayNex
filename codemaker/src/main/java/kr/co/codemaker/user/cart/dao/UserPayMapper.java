package kr.co.codemaker.user.cart.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.cart.vo.CartVO;
import kr.co.codemaker.user.cart.vo.LessonVO;
import kr.co.codemaker.user.cart.vo.PayVO;
import kr.co.codemaker.user.cart.vo.PointVO;

/**
* UserPayMapper.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 3.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준  결제 최초 작성
* 		  결제페이지에서 보여질 강의 정보 작성
*		  포인트 조회 및 사용(12.09)
*		  강의결제 / 장바구니에 담을때 결제내역에 있는지, 있다면 수강기간이 안끝났는지 확인(12.23)
 */
@Mapper("userPayMapper")
public interface UserPayMapper {
	
	/**
	 * 회원이 강의를 결제하는 기능
	 * @param 결제정보를 담은 vo
	 */
	public int insertPay(PayVO payVo) throws Exception;
	
	
	/**
	 * 결제페이지에서 보여줄 강의 정보
	 * @param 결제페이지로 넘어갈때 가져가는 강의아이디
	 */
	public LessonVO selectLessonInfo(LessonVO lessonVo) throws Exception;
	
	/**
	 * 강의페이지에서 강의담기 클릭했을때 실행
	 * @param 강의아이디와 회원아이디
	 */
	public int insertCart(CartVO cartVo) throws Exception;
	
	/**
	 * 강의를 담기전에 담겨있는지 확인
	 * @param 강의아이디와 회원아이디
	 */
	public CartVO selectCart(CartVO cartVo) throws Exception;
	
	/**
	 * 장바구니에 담긴 강의리스트 조회
	 * @param 회원아이디
	 */
	public List<CartVO> selectCartList(CartVO cartVo) throws Exception;
	
	/**
	 * 결제 시 장바구니에 담긴 목록 삭제
	 * @param 회원아이디와, 강의 아이디
	 */
	public int deleteCart(CartVO cartVo) throws Exception;
	
	/**
	 * 회원의 결제페이지가 로드될때 포인트조회
	 * @param 회원아이디가 담긴 vo
	 */
	public PointVO selectPoint(PointVO pointVo) throws Exception;
	
	/**
	 * 회원이 결제시 포인트 사용등록
	 * @param 포인트합계, 사용포인트, 회원아이디가 담긴 vo
	 */
	public int usePoint(PointVO pointVo) throws Exception;
	
	/**
	 * 바로결제 또는 장바구니에 담을때 결제내역확인 => 결제내역이없거나, 수강기간이 끝났을때만 가능
	 * @param payVo
	 * @return 결제가가능하면 null ,아니면 결제정보가 나옴
	 */
	public List<PayVO> selectCheckPay(PayVO payVo) throws Exception;
}
