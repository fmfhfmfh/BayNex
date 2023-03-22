package kr.co.codemaker.admin.course.lesson.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.admin.course.lesson.dao.AdminLessonMapper;
import kr.co.codemaker.admin.course.lesson.vo.ExamVO;
import kr.co.codemaker.admin.course.lesson.vo.LessonIndexVO;
import kr.co.codemaker.admin.course.lesson.vo.LessonVO;
import kr.co.codemaker.admin.course.lesson.vo.SubjectVO;

/**
 * 
 * AdminLessonService.java
 *
 * @author 김미연
 * @version 1.0
 * @since 2020. 12. 4.
 *
 *        수정자 수정내용 ------ ------------------------ 김미연 최초 생성
 *
 */
@Service("adminLessonService")
public class AdminLessonService {

	@Resource(name = "adminLessonMapper")
	private AdminLessonMapper adminLessonMapper;
	
	/**
	 * 등록된 요청을 전체조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<LessonVO> selectAgreeCnt(LessonVO lessonVO) throws Exception{
		return adminLessonMapper.selectAgreeCnt(lessonVO);
	}
	
	/**
	 * 등록된 요청을 상세조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public List<LessonVO> selectAllLesson(LessonVO lessonVO) throws Exception{
		return adminLessonMapper.selectAllLesson(lessonVO);
	}
	
	/**
	 * 강의를 상세조회하는 메서드
	 * 
	 * @author 김미연
	 * @return
	 */
	public LessonVO selectLesson(LessonVO lessonVO) throws Exception{
		return adminLessonMapper.selectLesson(lessonVO);
	}
	
	/**
	 * 선택한 강의에 해당하는 강의목차를 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param lessonVO
	 * @return
	 */
	public List<LessonIndexVO> selectLessonIndex(LessonVO lessonVO) throws Exception {
		return adminLessonMapper.selectLessonIndex(lessonVO);
	}
	
	/**
	 * 해당 강의의 상태를 변경하는 메서드
	 * 
	 * @author 김미연
	 * @param lessonVO
	 * @return
	 */
	public int updateLesson(LessonVO lessonVO) throws Exception{
		return adminLessonMapper.updateLesson(lessonVO);
	}

	/**
	 * 해당 시험의 상태를 변경하는 메서드
	 * 
	 * @author 김미연
	 * @param examVO
	 */
	public int updateExam(ExamVO examVO) throws Exception {
		return adminLessonMapper.updateExam(examVO);
		
	}
	
	public String selectTeacher(String lesId) throws Exception {
		return adminLessonMapper.selectTeacher(lesId);
	}


}
