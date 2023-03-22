package kr.co.codemaker.user.classroom.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamScoreVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;

/**
 * 
* ExamScoreUserMapper.java
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
@Mapper("examScoreUserMapper")
public interface ExamScoreUserMapper {
	
	/**
	 * 회원의 모든 성적을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public List<ExamScoreVO> selectAllExamScore(ExamVO examVO) throws Exception;
	
	/**
	 * 회원의 성적 1개를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public ExamScoreVO selectExamScore(ExamVO examVO) throws Exception;
	
	/**
	 * 회원의 성적을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examScoreVO
	 * @return
	 * @throws Exception
	 */
	public int insertExamScore(ExamScoreVO examScoreVO) throws Exception;
	
	/**
	 * 회원의 성적을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param examScoreVO
	 * @return
	 * @throws Exception
	 */
	public int updateExamScore(ExamScoreVO examScoreVO) throws Exception;

}
