package kr.co.codemaker.user.mypage.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import kr.co.codemaker.common.vo.PageVo;
import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.lessoninfo.vo.ReviewVO;
import kr.co.codemaker.user.mypage.dao.MyPageMapper;
import kr.co.codemaker.user.mypage.vo.PointVO;
/**
* MypageService.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* PC-24 최초 생성
*
 */

@Service("mypageService")
public class MypageService{

	@Resource(name="myPageMapper")
	private MyPageMapper myPageMapper;
	
	/**
	 * 회원정보 조회
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserVO myinfoSelect(String userId) throws Exception {
		return myPageMapper.myinfoSelect(userId);
	}

	/**
	 * 회원탈퇴
	 * @param userVo
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(UserVO userVo) throws Exception {
		return myPageMapper.deleteUser(userVo);
	}

	/**
	 * 회원정보 수정
	 * @param userVo
	 * @return
	 * @throws Exception
	 */
	public int updateUser(UserVO userVo) throws Exception {
		return myPageMapper.updateUser(userVo); 
	}

	/**
	 * 포인트 내역 조회
	 * @param pageVo
	 * @return
	 */
	public Map<String, Object> selectPoint(PageVo pageVo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("pointList", myPageMapper.selectPoint(pageVo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int totalCnt = 0;
		
		try {
			totalCnt = myPageMapper.selectTotalCnt(pageVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int pages = (int)Math.ceil((double)totalCnt/5); 
		map.put("pages", pages);
		
		return map;
	}

	/**
	 * 포인트 적립
	 * @param pointVo
	 * @return
	 * @throws Exception
	 */
	public int insertPoint(PointVO pointVo)throws Exception {
		return myPageMapper.insertPoint(pointVo);
	}

	/**
	 * 포인트 환불
	 * @param pointVo
	 * @return
	 * @throws Exception
	 */
	public int deletePoint(PointVO pointVo) throws Exception {
		return myPageMapper.deletePoint(pointVo);
	}

	/**
	 * 환불시 회원이 환불하려는 금액과 회원의 포인트 잔액과 조회
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int deletePointCompare(String userId)throws Exception {
		return myPageMapper.deletePointCompare(userId);
	}




	
	
}
