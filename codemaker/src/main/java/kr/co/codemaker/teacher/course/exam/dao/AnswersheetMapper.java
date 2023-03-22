package kr.co.codemaker.teacher.course.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.course.exam.vo.AnswersheetVO;
import kr.co.codemaker.teacher.course.exam.vo.QuestionVO;

/**
 * 
* AnswersheetMapper.java
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
@Mapper("answersheetMapper")
public interface AnswersheetMapper {
	
	/**
	 * 시험문제 보기를 등록하는 메서드
	 * 
	 * @author 김미연
	 * @param answersheetVO
	 * @return 
	 */
	public int insertAnswersheet(AnswersheetVO answersheetVO) throws Exception;

	/**
	 * 시험보기를 수정하는 메서드
	 * 
	 * @author 김미연
	 * @param answersheetVO
	 * @return 
	 */
	public int updateAnswersheet(AnswersheetVO answersheetVO) throws Exception;

	/**
	 * 해당 시험보기를 조회하는 메서드
	 * @param questionVo
	 * @return 
	 */
	public List<AnswersheetVO> selectAnswersheet(QuestionVO questionVo) throws Exception;

	/**
	 * 시험보기를 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param answersheetVO
	 * @return 
	 */
	public int deleteAnswersheet(AnswersheetVO answersheetVO) throws Exception;

}
