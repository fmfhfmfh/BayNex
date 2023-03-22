package kr.co.codemaker.admin.course.resume.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;

@Mapper("resumeAdminMapper")
public interface ResumeAdminMapper {
	
	/**
	 * 이력서 전체를 조회하는 메서드
	 * @param resumeVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	List<ResumeVO> selectAllResume(ResumeVO resumeVO) throws Exception;
	
	/**
	 * 하나의 이력서를 조회하는 메서드
	 * @param resumeVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	ResumeVO getAllResume(ResumeVO resumeVO) throws Exception;
	
	/**
	 * 이력서의 상태값을 업데이트 하는 메서드
	 * @param resumeVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	int updateResume(ResumeVO resumeVO) throws Exception;
}
