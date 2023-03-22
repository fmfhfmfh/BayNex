package kr.co.codemaker.teacher.course.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.course.exam.vo.ExamVO;
import kr.co.codemaker.teacher.course.exam.vo.QuestionVO;

/**
 * 
* QuestionMapper.java
*
* @author 김미연
* @version 1.0
* @since 2020. 11. 24.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Mapper("questionMapper")
public interface QuestionMapper {
	
	/**
	 * 시험문제를 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param questionVO
	 * @return 
	 */
	public int insertQuestion(QuestionVO questionVO) throws Exception;
	
	/**
	 * 시험문제를 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param questionVO
	 * @return 
	 */
	public int updateQuestion(QuestionVO questionVO) throws Exception;
	
	/**
	 * 해당 시험문제를 조회하는 메서드
	 * @param examVo
	 * @return 
	 */
	public List<QuestionVO> selectQuestion(ExamVO examVo) throws Exception;
	
	/**
	 * 시험문제를 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param questionVO
	 * @return 
	 */
	public int deleteQuestion(QuestionVO questionVO) throws Exception;
	
}
