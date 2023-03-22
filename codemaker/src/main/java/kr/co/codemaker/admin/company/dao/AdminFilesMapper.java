package kr.co.codemaker.admin.company.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.admin.company.vo.FilesVO;

/**
* AdminFilesMappe.java
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
@Mapper("adminFilesMapper")
public interface AdminFilesMapper {

	/**
	 * 파일VO 조회
	 * @param filesVO
	 * @return
	 * @throws Exception
	 */
	public FilesVO selectFiles(FilesVO filesVO) throws Exception;
	
	/**
	 * pdf파일 업로드(추가)
	 * @param filesVO
	 * @return
	 * @throws Exception
	 */
	public int insertFiles(FilesVO filesVO) throws Exception;
}
