package kr.co.codemaker.common.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.JobInfoMapper;
import kr.co.codemaker.common.vo.JobInfoVO;

/**
* JobInfoService.java
*
* @author 박경호
* @version 1.0
* @since 2020. 11. 25.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Service("jobInfoService")
public class JobInfoService{
	
	private static final Logger log = LoggerFactory.getLogger(JobInfoService.class);

	@Resource(name="jobInfoMapper")
	private JobInfoMapper jobInfoMapper;

	public Map<String, Object> selectAllJobInfo(Map<String, Object> map) throws Exception {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("jobInfoList", jobInfoMapper.selectAllJobInfo(map));
		log.debug("탐탐탐?2");
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		
		int cnt = jobInfoMapper.jobInfoTotalCnt(map);
		map2.put("totalCnt", cnt);
		
		
		int pages =(int) Math.ceil((double)cnt/(int) map.get("pageSize"));
		map2.put("pages", pages); 
		return map2;
	}
	
	public Map<String, Object> selectAllJobInfoU(Map<String, Object> map) throws Exception {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("jobInfoList", jobInfoMapper.selectAllJobInfoU(map));
		log.debug("탐탐탐?2 {}", jobInfoMapper.selectAllJobInfoU(map));
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		
		int cnt = jobInfoMapper.jobInfoTotalCntU(map);
		map2.put("totalCnt", cnt);
		
		
		int pages =(int) Math.ceil((double)cnt/(int) map.get("pageSize"));
		map2.put("pages", pages); 
		return map2;
	}

	public JobInfoVO selectJobInfo(String jobInfoId) throws Exception {
		return jobInfoMapper.selectJobInfo(jobInfoId);
	}

	public int insertJobInfo(JobInfoVO jobInfoVo) throws Exception {
		return jobInfoMapper.insertJobInfo(jobInfoVo);
	}

	public int updateJobInfo(JobInfoVO jobInfoVo) throws Exception {
		return jobInfoMapper.updateJobInfo(jobInfoVo);
	}

	public int deleteJobInfo(String jobInfoId) throws Exception {
		return jobInfoMapper.deleteJobInfo(jobInfoId);
	}

}
