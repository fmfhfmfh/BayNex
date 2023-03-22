package kr.co.codemaker.user.lessoninfo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.lessoninfo.service.ReviewService;
import kr.co.codemaker.user.lessoninfo.vo.PayVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewStarVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewVO;
import kr.co.codemaker.user.mypage.service.MypageService;
/**
* ReviewController.java
*
* @author 우송이
* @version 1.0
* @Since 2020.12
*
* 수정자 수정내용
* ------ ------------------------
* 수강후기
*
 */
@Controller
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Resource(name="reviewService")
	private ReviewService reviewService;

	/**
	 * 수강후기 조회
	 * @param model
	 * @param lesId
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/user/selectReview")
	public String selectReview(Model model, String lesId, HttpServletResponse response) throws IOException{

		List<ReviewVO> reviewList=new ArrayList<ReviewVO>();
		//수강후기 조회
		try {
			reviewList = reviewService.selectReview(lesId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//수강후기 별점 평균
		float reviewAvg=0;
		try {
			reviewAvg = reviewService.selectReviewAvg(lesId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//수강후기 별점 갯수
		ReviewStarVO reviewStarVo = new ReviewStarVO();
		try {
			reviewStarVo = reviewService.selectReviewStar(lesId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("lesId", lesId);
		model.addAttribute("reviewAvg", reviewAvg);
		model.addAttribute("reviewStarVo", reviewStarVo);
		
		return "mainT/user/lesson/reviewTest";
	}
	
	/**
	 * 회원후기 조회시 회원 프로필 조회
	 * @param userProfile
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/user/reviewprofile")
	public void profileImg(String userProfile, HttpServletResponse response,HttpServletRequest request) throws Exception {

			
			FileInputStream fis = new FileInputStream(userProfile);
			ServletOutputStream sos =  response.getOutputStream();
			
			byte[] buffer = new byte[512];
			
			while (fis.read(buffer) != -1) {
				sos.write(buffer);
			}
			
			fis.close();
			sos.flush(); 
			sos.close();
			
	}

	/**
	 * 수강후기 작성
	 * @param model
	 * @param reviewVo
	 * @param lesId
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user/insertReview")
	public String insertReview(Model model , ReviewVO reviewVo, String lesId, HttpSession session, HttpServletRequest request) {
		
		UserVO userVo = (UserVO) session.getAttribute("MEMBER_INFO");
		
		String reviewUser = userVo.getUserId();
		String userId = reviewUser;
		 
		reviewVo.setUserId(userId);
		
		PayVO payVo = new PayVO();
		payVo.setLesId(lesId);
		payVo.setUserId(userId);
		
		
		model.addAttribute("reviewVo", reviewVo);
		
		String checkPayId="";
		try {
			//수강후기 작성시 결제한 회원인지 아닌지 체크
			checkPayId = reviewService.checkPayId(payVo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String checkWrite="";
		
		try {
			checkWrite= reviewService.checkWrite(payVo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		int insertCnt=0;
		
		//결제한 회원이면
		if(checkPayId!=null) {
			
			//결제한 회원이지만, 이미 후기를 작성한 아이디가 존재하면 후기를 작성할 수 없다.
			if(checkWrite!=null) {
				return "2";
				
			//결제한 회원이고, 후기를 작성한 내역이 없으면 수강후기를 작성
			}else {
				try {
					//수강후기 작성
					insertCnt = reviewService.insertReview(reviewVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "1";
			} 
			
		}else {
			return "0";
		}
	}
	
	/**
	 * 수강후기 삭제
	 * @param reviewVo
	 * @param lesId
	 * @return
	 */
	@RequestMapping("/user/deleteReview")
	public String deleteReview(ReviewVO reviewVo, String lesId) {

		String reviewId =reviewVo.getReviewId();

		int deleteCnt = 0;
		
		try {
			deleteCnt = reviewService.deleteReview(reviewId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/selectReview?lesId="+lesId;
	}
	
}
