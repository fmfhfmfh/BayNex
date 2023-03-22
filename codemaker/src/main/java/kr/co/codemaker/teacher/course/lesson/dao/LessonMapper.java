package kr.co.codemaker.teacher.course.lesson.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.course.lesson.vo.LessonVO;

/**
 * TeacherMapper.java
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
@Mapper("lessonMapper")
public interface LessonMapper {
	List<LessonVO> selectLesson(LessonVO lessonVO) throws Exception;		// 과목에 대한 강의 조회
	
	List<LessonVO> selectNoLesson(String tchId) throws Exception;		// 해당강의에 대한 강의목차 조회
	
	LessonVO selectDetailLesson(LessonVO lessonVO) throws Exception;	// 선택한 강의ID의 VO조회
	
	int deleteLesson(String lesId) throws Exception;		// 강의 삭제
	
	int insertLesson(LessonVO lessonVO) throws Exception; 	// 강의 추가
	
	int updateLesson(LessonVO lessonVO) throws Exception;  //강의 수정

	int updateTempoLesson(LessonVO lessonVO) throws Exception;  //강의 임시저장
	
	int updatePermissionLesson(LessonVO lessonVO) throws Exception; // 강의 요청
	
	int updatePremissionExam(LessonVO lessonVO) throws Exception; // 시험 요청
	
	int selectExamCnt(LessonVO lessonVO) throws Exception; // 승인안된 시험갯수 조회

	
}
