package kr.co.codemaker.common.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.common.vo.FilesVO;

@Mapper("filesMapper")
public interface FilesMapper {
	
	/**
	 * 파일을 추가하기 위한 메서드
	 * @author 박경호
	 * @param filesVo 파일 정보
	 * @return 파일을 추가한 갯수
	 */
	public int insertFiles(FilesVO filesVo);
	
	/**
	 * 여러개의 파일을 조회하기 위한 메서드
	 * @author 박경호
	 * @param filesGroup 파일을 가져오기위한 구분자
	 * @return 여러개의 파일 정보
	 */
	public List<FilesVO> selectAllFiles(String filesGroup);
	
	/**
	 * 파일을 삭제하기 위한 메서드
	 * @author 박경호
	 * @param filesId 파일 아이디
	 * @return 삭제된 파일 갯수
	 */
	public int deleteFiles(String filesId);
	
	/**
	 * 하나의 파일 정보를 조회하기 위한 메서드
	 * @author 박경호
	 * @param filesId 파일아이디 
	 * @return 하나의 파일정보
	 */
	public FilesVO selectFiles(String filesId);
}
