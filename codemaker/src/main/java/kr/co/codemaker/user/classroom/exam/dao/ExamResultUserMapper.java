package kr.co.codemaker.user.classroom.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamResultVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamScoreVO;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;

/**
 * 
* ExamResultUserMapper.java
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
@Mapper("examResultUserMapper")
public interface ExamResultUserMapper {
	
	/**
	 * 회원의 성적을 조회하는 메서드 - 상세페이지
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return
	 * @throws Exception
	 */
	public List<ExamResultVO> selectAllExamResult(ExamVO examVO) throws Exception;
	
	/**
	 * 회원의 성적을 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param examResultVO
	 * @return
	 * @throws Exception
	 */
	public int insertExamResult(ExamResultVO examResultVO) throws Exception;
	
	/**
	 * 회원의 성적을 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param examResultVO
	 * @return
	 * @throws Exception
	 */
	public int updateExamResult(ExamResultVO examResultVO) throws Exception;
	

}
