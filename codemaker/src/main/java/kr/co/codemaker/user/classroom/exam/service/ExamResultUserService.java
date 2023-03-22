package kr.co.codemaker.user.classroom.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.classroom.exam.dao.ExamResultUserMapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamResultVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamScoreVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;

/**
 * 
* ExamResultUserService.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 14.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Service("examResultUserService")
public class ExamResultUserService {
	
	@Resource(name = "examResultUserMapper")
	private ExamResultUserMapper examResultUserMapper;
	
	/**
	 * 회원의 성적을 조회하는 메서드 - 상세페이지
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public List<ExamResultVO> selectAllExamResult(ExamVO examVO) throws Exception {
		return examResultUserMapper.selectAllExamResult(examVO);
	}
	
	/**
	 * 회원의 성적을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examResultVO
	 * @return
	 * @throws Exception
	 */
	public int insertExamResult(ExamResultVO examResultVO) throws Exception {
		return examResultUserMapper.insertExamResult(examResultVO);
	}
	
	/**
	 * 회원의 성적을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param examResultVO
	 * @return
	 * @throws Exception
	 */
	public int updateExamResult(ExamResultVO examResultVO) throws Exception {
		return examResultUserMapper.updateExamResult(examResultVO);
	}

}
