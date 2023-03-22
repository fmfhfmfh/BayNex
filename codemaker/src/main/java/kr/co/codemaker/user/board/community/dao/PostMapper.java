package kr.co.codemaker.user.board.community.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.user.board.community.vo.PostVO;

@Mapper("postMapper")
public interface PostMapper {
	
	/**
	 * 게시글을 전체를 조회하는 메서드
	 * @param postNo
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public List<PostVO> getAllPost(PostVO postVO) throws Exception;
	
	/**
	 * 선택한 하나의 게시글을 조회하는 메서드
	 * @param postVO
	 * @return
	 * @throws Exception
	 */
	public PostVO getPost(PostVO postVO) throws Exception;
	
	/**
	 * 게시글을 작성하는 메서드
	 * @param postVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int insertPost(PostVO postVO) throws Exception;
	
	/**
	 * 게시글을 수정하는 메서드
	 * @param postVO
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int updatePost(int postNo) throws Exception;
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param postNo
	 * @author 이은지
	 * @return
	 * @throws Exception
	 */
	public int deletePost(int postNo) throws Exception;

}
