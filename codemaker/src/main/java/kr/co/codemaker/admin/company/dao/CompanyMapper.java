package kr.co.codemaker.admin.company.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.company.vo.CompanyVO;

/**
* CompanyMapper.java
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
@Mapper("companyMapper")
public interface CompanyMapper {
	
	/**
	 * 기업리스트 조회
	 * @author 박다미
	 * @param companyVO
	 * @return 
	 * @throws Exception
	 */
	public List<CompanyVO> selectAllCompany(Map<String, Object> map) throws Exception;	
	
	/**
	 * 기업 조회
	 * @author 박다미
	 * @param companyVO
	 * @return
	 * @throws Exception
	 */
	public CompanyVO selectCompany(CompanyVO companyVO) throws Exception;
	
	/**
	 * 전체 기업리스트 수
	 * @author 박다미
	 * @return
	 * @throws Exception
	 */
	public int selectCompanyCnt() throws Exception;	
	
	/**
	 * 해당기업에 계약서 업로드
	 * @param companyVO
	 * @return
	 * @throws Exception
	 */
	public int updateCompany(CompanyVO companyVO) throws Exception;
	
	

}
