package kr.co.codemaker.admin.course.scholarship.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.course.scholarship.vo.PointVO;
import kr.co.codemaker.admin.course.scholarship.vo.ScholarshipVO;
import kr.co.codemaker.admin.course.scholarship.vo.SubjectVO;

/**
 * 
* ScholarshipMapper.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 17.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Mapper("scholarshipMapper")
public interface ScholarshipMapper {
	
	/**
	 * 과목을 조회하는 메서드
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 * @throws Exception
	 */
	public List<SubjectVO> selectAllSubject(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 강의별로 장학금을 지급할 회원들을 조회하는 메서드 (간략 조회)
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectAllScholarshipCnt(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 수강중인 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectCurAllLesson(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 완강한 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectLessonScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 완강한 회원들 중에서 모든 시험을 푼 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectExamScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 장학금을 지급하는 메서드
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public int insertScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 장학금을 지급하는 메서드 -> 포인트
	 * 
	 * @author 김미연
	 * @param pointVO
	 * @return
	 */
	public int insertPoint(PointVO pointVO) throws Exception;
	
	/**
	 * 장학금을 지급한 전체 목록 조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectAllScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 장학금을 지급 완강 회원 목록 조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectLessonPayScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 장학금을 지급 시험 완료 회원 목록 조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectExamPayScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	/**
	 * 장학금을 지급한 전체 회원 목록 조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	public List<ScholarshipVO> selectTotalPayScholarship(ScholarshipVO scholarshipVO) throws Exception;
	
	

}
