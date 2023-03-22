package kr.co.codemaker.user.board.community.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.board.community.vo.PostFileVO;

@Mapper("postFileMapper")
public interface PostFileMapper {

	public int insertPostFile(PostFileVO postFileVO);
	
	public int deletePostFile(String fileNo);
	
	/**
	 * 파일을 조회하는 메서드
	 * @param fileNo
	 * @return
	 */
	public PostFileVO selectPostFile(String fileNo);
}
