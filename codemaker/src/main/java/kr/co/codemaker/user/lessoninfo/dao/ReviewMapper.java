package kr.co.codemaker.user.lessoninfo.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.lessoninfo.vo.PayVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewStarVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewVO;
/**
* ReviewMapper.java
*
* @author 우송이
* @version 1.0
* @Since 2020.12
*
* 수정자 수정내용
* ------ ------------------------
* 우송이 최초 생성
*
 */
@Mapper("reviewMapper")
public interface ReviewMapper {

	/**
	 * 수강후기 조회
	 * @param lesId
	 * @return
	 * @throws Exception
	 */
	List<ReviewVO> selectReview(String lesId)throws Exception;

	/**
	 * 수강후기 작성
	 * @param reviewVo
	 * @return
	 * @throws Exception
	 */
	int insertReview(ReviewVO reviewVo)throws Exception;

	/**
	 * 수강후기 삭제
	 * @param reviewId
	 * @return
	 * @throws Exception
	 */
	int deleteReview(String reviewId)throws Exception;

	/**
	 * 수강후기 별점 평균 조회
	 * @param lesId
	 * @return
	 * @throws Exception
	 */
	float selectReviewAvg(String lesId)throws Exception;

	/**
	 * 수강후기 별점 갯수 조회
	 * @param lesId
	 * @return
	 * @throws Exception
	 */
	ReviewStarVO selectReviewStar(String lesId)throws Exception;

	/**
	 * 수강후기 작성시 결제내역이 있는지 조회
	 * @param payVo
	 * @return
	 * @throws Exception
	 */
	String checkPayId(PayVO payVo)throws Exception;

	String checkWrite(PayVO payVo)throws Exception;
}
