package kr.co.codemaker.user.board.community.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.board.community.dao.PostFileMapper;
import kr.co.codemaker.user.board.community.vo.PostFileVO;

@Service("postFileService")
public class PostFileService {
	
	@Resource(name="postFileMapper")
	private PostFileMapper postFileMapper;
	
	public int insertPostFile(PostFileVO postFileVO) throws Exception {
		return postFileMapper.insertPostFile(postFileVO);
	}
	
	public int deletePostFile(String fileNo) throws Exception {
		return postFileMapper.deletePostFile(fileNo);
	}
	
	public PostFileVO selectPostFile(String fileNo) throws Exception {
		return postFileMapper.selectPostFile(fileNo);
	}
	
}
