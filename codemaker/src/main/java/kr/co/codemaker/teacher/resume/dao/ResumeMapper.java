package kr.co.codemaker.teacher.resume.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;

@Mapper("resumeMapper")
public interface ResumeMapper {
	
	/**
	 * 이력서 작성 메서드
	 * @param resumeVO
	 * @return
	 * @author 이은지
	 * @throws Exception
	 */
	public int insertResume(ResumeVO resumeVO) throws Exception;
	
	/**
	 * 이력서 임시저장
	 * @param resumeVo
	 */
	public int saveResume(ResumeVO resumeVo) throws Exception;
	
	/**
	 * 임시저장 이력서 제출
	 * @param resumeVo
	 */
	public int updateResume(ResumeVO resumeVo) throws Exception;
	
	/**
	 * 이력서 조회
	 * @param resumeVo
	 * @return 이력서 정보가 있으면 이력서Vo 반환
	 */
	public ResumeVO selectResume(ResumeVO resumeVo) throws Exception;
	
}
