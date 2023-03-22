package kr.co.codemaker.user.classroom.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.classroom.exam.dao.ExamScoreUserMapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamScoreVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;

/**
 * 
* ExamScoreUserService.java
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
@Service("examScoreUserService")
public class ExamScoreUserService {
	
	@Resource(name = "examScoreUserMapper")
	private ExamScoreUserMapper examScoreUserMapper;
	
	/**
	 * 회원의 모든 성적을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public List<ExamScoreVO> selectAllExamScore(ExamVO examVO) throws Exception {
		return examScoreUserMapper.selectAllExamScore(examVO);
	}
	
	/**
	 * 회원의 성적 1개를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public ExamScoreVO selectExamScore(ExamVO examVO) throws Exception {
		return examScoreUserMapper.selectExamScore(examVO);
	}
	
	/**
	 * 회원의 성적을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examScoreVO
	 * @return
	 * @throws Exception
	 */
	public int insertExamScore(ExamScoreVO examScoreVO) throws Exception {
		return examScoreUserMapper.insertExamScore(examScoreVO);
	}
	
	/**
	 * 회원의 성적을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param examScoreVO
	 * @return
	 * @throws Exception
	 */
	public int updateExamScore(ExamScoreVO examScoreVO) throws Exception {
		return examScoreUserMapper.updateExamScore(examScoreVO);
	}

}
