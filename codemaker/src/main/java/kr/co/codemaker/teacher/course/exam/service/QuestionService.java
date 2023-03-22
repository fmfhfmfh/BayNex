package kr.co.codemaker.teacher.course.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.course.exam.dao.QuestionMapper;
import kr.co.codemaker.teacher.course.exam.vo.ExamVO;
import kr.co.codemaker.teacher.course.exam.vo.QuestionVO;

/**
 * 
* QuestionService.java
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
@Service("questionService")
public class QuestionService {
	
	@Resource(name = "questionMapper")
	private QuestionMapper questionMapper;

	public int insertQuestion(QuestionVO questionVO) throws Exception {
		return questionMapper.insertQuestion(questionVO);
	}

	public int updateQuestion(QuestionVO questionVO) throws Exception {
		return questionMapper.updateQuestion(questionVO);
	}
	
	public List<QuestionVO> selectQuestion(ExamVO examVO) throws Exception {
		return questionMapper.selectQuestion(examVO);
	}
	
	/**
	 * 시험문제를 삭제하는 메서드
	 * 
	 * @author 김미연
	 * @param questionVO
	 * @return 
	 */
	public int deleteQuestion(QuestionVO questionVO) throws Exception {
		return questionMapper.deleteQuestion(questionVO);
	}

}
