package kr.co.codemaker.user.classroom.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;
import kr.co.codemaker.user.classroom.exam.vo.QuestionVO;

/**
 * 
* QuestionUserMapper.java
*
* @author 김미연
* @version 1.0
* @since 2020. 11. 30.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Mapper("questionUserMapper")
public interface QuestionUserMapper {
	
	/**
	 * 해당 시험문제를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public List<QuestionVO> selectQuestion(ExamVO examVO) throws Exception;
	
	
}
