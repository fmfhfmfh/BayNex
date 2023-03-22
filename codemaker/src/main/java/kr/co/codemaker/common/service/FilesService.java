package kr.co.codemaker.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.FilesMapper;
import kr.co.codemaker.common.vo.FilesVO;

@Service("filesService")
public class FilesService  {

	@Resource(name="filesMapper")
	private FilesMapper filesMapper;
	
	
	public int insertFiles(FilesVO filesVo) {
		return filesMapper.insertFiles(filesVo);
	}

	
	public List<FilesVO> selectAllFiles(String filesGroup) {
		return filesMapper.selectAllFiles(filesGroup);
	}

	
	public int deleteFiles(String filesId) {
		return filesMapper.deleteFiles(filesId);
	}

	
	public FilesVO selectFiles(String filesId) {
		return filesMapper.selectFiles(filesId);
	}
	
	
}
