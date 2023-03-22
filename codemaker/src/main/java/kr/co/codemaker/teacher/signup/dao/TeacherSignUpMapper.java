package kr.co.codemaker.teacher.signup.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;
import kr.co.codemaker.teacher.signup.vo.TeacherVO;

/**
* TeacherSignUpMapper.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 2.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준  선생님 회원가입 최초작성
*		  이력서 정보 조회
*  		  아이디 중복체크
 */
@Mapper("teacherSignUpMapper")
public interface TeacherSignUpMapper {
	
	/**
	 * 선생님 회원가입 
	* @param 선생님 회원가입시 필요한 정보 입력
	*/
	public int insertTeacher(TeacherVO teacherVo) throws Exception;
	
	/**
	 * 선생님 회원가입이 이력서 정보 조회
	* @param 이력서 승인코드를 가지고 조회 
	*/
	public ResumeVO selectResume(ResumeVO resumeVo) throws Exception; 
	
	
	/**
	* @param 아이디 중복체크를 위한 아이디 정보
	*/
	public TeacherVO tchIdChk(TeacherVO teacherVo) throws Exception;
}
