package kr.co.codemaker.user.mypage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.mypage.dao.MyPayLessonMapper;
import kr.co.codemaker.user.mypage.vo.PayLessonInfoVO;

/**
* MyPayLessonService.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 15.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 최초작성
*
 */
@Service("myPayLessonService")
public class MyPayLessonService {
	
	@Resource(name="myPayLessonMapper")
	private MyPayLessonMapper lessonMapper;
	
	public List<PayLessonInfoVO> selectAllPayLesson(PayLessonInfoVO plVo) throws Exception{
		return lessonMapper.selectAllPayLesson(plVo);
	};
	
	public List<PayLessonInfoVO> selectAllPayEnd(PayLessonInfoVO plVo) throws Exception{
		return lessonMapper.selectAllPayEnd(plVo);
	}
}
