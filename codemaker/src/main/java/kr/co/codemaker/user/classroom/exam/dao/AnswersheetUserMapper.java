package kr.co.codemaker.user.classroom.exam.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.classroom.exam.vo.AnswersheetVO;
import kr.co.codemaker.user.classroom.exam.vo.QuestionVO;

/**
 * 
* AnswersheetUserMapper.java
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
@Mapper("answersheetUserMapper")
public interface AnswersheetUserMapper {
	
	/**
	 * 해당 시험보기를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param questionVO
	 * @return 
	 */
	public List<AnswersheetVO> selectAnswersheet(QuestionVO questionVO) throws Exception;

}
