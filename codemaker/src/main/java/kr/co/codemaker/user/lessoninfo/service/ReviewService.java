package kr.co.codemaker.user.lessoninfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.lessoninfo.dao.ReviewMapper;
import kr.co.codemaker.user.lessoninfo.vo.PayVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewStarVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewVO;
/**
* ReviewService.java
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
@Service("reviewService")
public class ReviewService {

	@Resource(name="reviewMapper")
	private ReviewMapper reviewMapper;

	/**
	 * 수강후기 조회
	 * @param lesId
	 * @return
	 * @throws Exception
	 */
	public List<ReviewVO> selectReview(String lesId) throws Exception{
		return reviewMapper.selectReview(lesId);
	}

	/**
	 * 수강후기 작성
	 * @param reviewVo
	 * @return
	 * @throws Exception
	 */
	public int insertReview(ReviewVO reviewVo) throws Exception {
		return reviewMapper.insertReview(reviewVo);
	}

	/**
	 * 수강후기 삭제
	 * @param reviewId
	 * @return
	 * @throws Exception
	 */
	public int deleteReview(String reviewId) throws Exception {
		return reviewMapper.deleteReview(reviewId);
	}

	/**
	 * 수강후기 별점 평균 조회
	 * @param lesId
	 * @return
	 * @throws Exception
	 */
	public float selectReviewAvg(String lesId) throws Exception {
		return reviewMapper.selectReviewAvg(lesId);
	}

	/**
	 * 수강후기 별점 갯수 조회
	 * @param lesId
	 * @return
	 * @throws Exception
	 */
	public ReviewStarVO selectReviewStar(String lesId) throws Exception {
		return reviewMapper.selectReviewStar(lesId);
	}

	/**
	 * 수강후기 작성시 결제내역이 있는지 조회
	 * @param payVo
	 * @return
	 * @throws Exception
	 */
	public String checkPayId(PayVO payVo) throws Exception {
		return reviewMapper.checkPayId(payVo);
	}


	public String checkWrite(PayVO payVo) throws Exception {
		return reviewMapper.checkWrite(payVo);
	}

}
