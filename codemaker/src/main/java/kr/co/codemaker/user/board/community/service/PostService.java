package kr.co.codemaker.user.board.community.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.board.community.dao.PostMapper;
import kr.co.codemaker.user.board.community.vo.PostVO;

@Service("postService")
public class PostService {
	
	@Resource(name="postMapper")
	private PostMapper postMapper;
	
	/**
	 * 게시글 전체를 조회하는 메서드
	 * @param postVO
	 * @return
	 * @throws Exception
	 */
	public List<PostVO> getAllPost(PostVO postVO) throws Exception{
		return postMapper.getAllPost(postVO);
	}
	
	/**
	 * 선택한 하나의 게시글을 조회하는 메서드
	 * @param postVO
	 * @return
	 * @throws Exception
	 */
	public PostVO getPost(PostVO postVO) throws Exception {
		return postMapper.getPost(postVO);
	}
	
	/**
	 * 게시글을 작성하는 메서드
	 * @param postVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int insertPost(PostVO postVO) throws Exception{
		return postMapper.insertPost(postVO);
	}
	
	/**
	 * 게시글을 수정하는 메서드
	 * @param postVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int updatePost(int postNo) throws Exception{
		return postMapper.updatePost(postNo);
	}
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param postNo
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int deletePost(int postNo) throws Exception{
		return postMapper.deletePost(postNo);
	}
}
