package kr.co.codemaker.teacher.course.lesson.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.teacher.course.lesson.dao.LessonIndexMapper;
import kr.co.codemaker.teacher.course.lesson.dao.TeacherSubjectMapper;
import kr.co.codemaker.teacher.course.lesson.vo.LessonIndexVO;

/**
 * TeacherIndexService.java
 *
 * @author 박다미
 * @version 1.0
 * @since 2020. 12. 1.
 *
 *   수정자 수정내용 
 *   ------ ------------------------ 
 *   박다미 최초 생성
 *
 */
@Service("lessonIndexService")
public class LessonIndexService {
	
	@Resource(name="lessonIndexMapper")
	private LessonIndexMapper lessonIndexMapper;
	
	public List<LessonIndexVO> selectLessonIndex(String lesId) throws Exception {
		return lessonIndexMapper.selectLessonIndex(lesId);
	}
	
	
	public int insertLessonIndex(LessonIndexVO lesIdxVO) throws Exception{
		return lessonIndexMapper.insertLessonIndex(lesIdxVO);
	}
	
	public int updateLessonIndex(LessonIndexVO lesIdxVO) throws Exception{
		return lessonIndexMapper.updateLessonIndex(lesIdxVO);
	}
	
	public int deleteLessonIndex(String lidxId) throws Exception{
		return lessonIndexMapper.deleteLessonIndex(lidxId);
	}
	
	
}
