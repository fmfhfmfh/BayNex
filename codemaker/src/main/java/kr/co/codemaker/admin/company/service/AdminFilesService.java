package kr.co.codemaker.admin.company.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.admin.company.dao.AdminFilesMapper;
import kr.co.codemaker.admin.company.vo.FilesVO;

/**
* AdminFilesyService.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 18.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */

@Service("adminFilesService")
public class AdminFilesService {
	
	@Resource(name="adminFilesMapper")
	private AdminFilesMapper adminFilesMapper;
	
	public FilesVO selectFiles(FilesVO filesVO) throws Exception{
		return adminFilesMapper.selectFiles(filesVO);
	}
	
	public int insertFiles(FilesVO filesVO) throws Exception{
		return adminFilesMapper.insertFiles(filesVO);
	}
	
	

}
