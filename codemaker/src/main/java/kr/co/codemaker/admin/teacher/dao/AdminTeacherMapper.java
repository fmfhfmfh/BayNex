package kr.co.codemaker.admin.teacher.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.teacher.vo.LessonVO;
import kr.co.codemaker.admin.teacher.vo.ResumeVO;
import kr.co.codemaker.admin.teacher.vo.TeacherVO;

/**
* AdminTeacherMapper.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 14.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 선생님 전체 조회
*
 */
@Mapper("adminTeacherMapper")
public interface AdminTeacherMapper {

	/**
	 * 관리자 선생님 전체 조회
	 * @return
	 */
	public List<TeacherVO> selectAllTeacher(TeacherVO teacherVo) throws Exception;
	
	/**
	 * 선생님 상세조회
	 * @param 선생님 아이디
	 * @return	아이디에 해당하는 선생님 정보
	 */
	public TeacherVO selectTeacher(TeacherVO teacherVo) throws Exception;
	
	/**
	 * 이력서 조회 (상세조회시 필요한 컬럼 추가용)
	 * @param 이력서 승인코드 => teacherVO의 tchCode
	 * @return 승인코드에 해당하는 이력서 정보
	 */
	public ResumeVO selectResume(ResumeVO resumeVo) throws Exception;
	
	/**
	 * 선생님 상세조회시 하단에 담당하고있는 과목 조회 
	 * @param 선생님 아이디
	 * @return 아이디에 해당하는 강의정보
	 */
	public List<LessonVO> selectLesson(LessonVO lessonVo) throws Exception;
}
