package kr.co.codemaker.admin.company.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hsqldb.lib.HashMap;
import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.company.dao.CompanyMapper;
import kr.co.codemaker.admin.company.vo.CompanyVO;

/**
* CompanyService.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 15.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */
@Service("companyService")
public class CompanyService {
	
	@Resource(name="companyMapper")
	private CompanyMapper companyMapper;
	
	public Map<String, Object> selectAllCompany(Map<String, Object> map) throws Exception{
		map.put("companyList", companyMapper.selectAllCompany(map));
		
		int cnt = companyMapper.selectCompanyCnt();
		
		int pages = (int)Math.ceil((double)cnt/(int)map.get("pageSize"));
		map.put("pages", pages);
		return map;
	}
	
	public CompanyVO selectCompany(CompanyVO companyVO) throws Exception{
		return companyMapper.selectCompany(companyVO);
	}
	
	public int updateCompany(CompanyVO companyVO) throws Exception{
		return companyMapper.updateCompany(companyVO);
	}

}
