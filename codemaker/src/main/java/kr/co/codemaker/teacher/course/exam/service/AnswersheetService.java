package kr.co.codemaker.teacher.course.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.course.exam.dao.AnswersheetMapper;
import kr.co.codemaker.teacher.course.exam.vo.AnswersheetVO;
import kr.co.codemaker.teacher.course.exam.vo.QuestionVO;

/**
 * 
* AnswersheetService.java
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
@Service("answersheetService")
public class AnswersheetService {
	
	@Resource(name = "answersheetMapper")
	private AnswersheetMapper answersheetMapper;

	public int insertAnswersheet(AnswersheetVO answersheetVO) throws Exception {
		return answersheetMapper.insertAnswersheet(answersheetVO);
	}

	public int updateAnswersheet(AnswersheetVO answersheetVO) throws Exception {
		return answersheetMapper.updateAnswersheet(answersheetVO);
	}

	public List<AnswersheetVO> selectAnswersheet(QuestionVO questionVO) throws Exception {
		return answersheetMapper.selectAnswersheet(questionVO);
	}
	
	/**
	 * 시험보기를 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param answersheetVO
	 * @return 
	 */
	public int deleteAnswersheet(AnswersheetVO answersheetVO) throws Exception{
		return answersheetMapper.deleteAnswersheet(answersheetVO);
	};


}
