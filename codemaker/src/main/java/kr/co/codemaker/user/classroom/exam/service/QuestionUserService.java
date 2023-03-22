package kr.co.codemaker.user.classroom.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.classroom.exam.dao.QuestionUserMapper;
import kr.co.codemaker.user.classroom.exam.vo.ExamVO;
import kr.co.codemaker.user.classroom.exam.vo.QuestionVO;

/**
 * 
* QuestionUserService.java
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
@Service("questionUserService")
public class QuestionUserService {
	
	@Resource(name = "questionUserMapper")
	private QuestionUserMapper questionUserMapper;
	
	/**
	 * 해당 시험문제를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 * @return 
	 */
	public List<QuestionVO> selectQuestion(ExamVO examVO) throws Exception {
		return questionUserMapper.selectQuestion(examVO);
	}
	
}
