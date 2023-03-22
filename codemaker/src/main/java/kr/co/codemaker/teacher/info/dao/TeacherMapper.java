package kr.co.codemaker.teacher.info.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.teacher.vo.LessonVO;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
* TeacherMapper.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 23.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Mapper("teacherMapper")
public interface TeacherMapper {
	
	/**
	 * 선생님 정보 수정을 위한 메서드
	 * @author 박경호
	 * @param teacherVo
	 * @return 정보를 수정이 성공시 1
	 * @throws Exception
	 */
	public int updateTeacher(TeacherVO teacherVo) throws Exception;
	
	/**
	 * 선생님 정보를 확인하는 메서드
	 * @author 박경호
	 * @param teacherVo
	 * @return 로그인한 선생님의 정보
	 * @throws Exception
	 */
	public TeacherVO selectTeacher(TeacherVO teacherVo) throws Exception;
	
	/**
	 * 선생님의 이력서를 조회하는 메서드
	 * @author 박경호
	 * @param resId
	 * @return 선생님이 작성한 이력서 정보
	 * @throws Exception
	 */
	public ResumeVO selectResume(String resId) throws Exception;
	
	/**
	 * 선생님의 강의 목록을 조회하는 메서드
	 * @author 박경호
	 * @param teacherVo
	 * @return 선생님의 강의목록
	 * @throws Exception
	 */
	public List<LessonVO> selectAllLesson(TeacherVO teacherVo) throws Exception;
}
