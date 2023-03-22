package kr.co.codemaker.admin.course.resume.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.course.resume.dao.ResumeAdminMapper;
import kr.co.codemaker.teacher.signup.vo.ResumeVO;

@Service("resumeAdminService")
public class ResumeAdminService {
	
	@Resource(name="resumeAdminMapper")
	private ResumeAdminMapper resumeAdminMapper;
	
	/**
	 * 이력서 전체를 조회하는 메서드
	 * @param resumeVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public List<ResumeVO> selectAllResume(ResumeVO resumeVO) throws Exception{
		return resumeAdminMapper.selectAllResume(resumeVO);
	}
	
	/**
	 * 하나의 이력서를 조회하는 메서드
	 * @param resumeVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public ResumeVO getAllResume(ResumeVO resumeVO) throws Exception{
		return resumeAdminMapper.getAllResume(resumeVO);
	}
	
	/**
	 * 이력서의 상태값을 업데이트 하는 메서드
	 * @param resumeVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int updateResume(ResumeVO resumeVO) throws Exception{
		return resumeAdminMapper.updateResume(resumeVO);
	}
}
