package kr.co.codemaker.common.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.common.vo.ReplyVO;

@Mapper("replyMapper")
public interface ReplyMapper {
	
	/**
	 * qna별 모든 댓글을 조회하는 메서드
	 * @author 박경호
	 * @param qnaId 댓글을 조회하는 qnaId
	 * @return qna에 해당하는 모든 댓글
	 */
	List<ReplyVO> selectAllReply(String qnaId) throws Exception;
	
	/**
	 * 댓글을 작성하는 메서드
	 * @author 박경호
	 * @param replyVo 작성하려는 댓글 객체
	 * @return 댓글이 작성된 갯수
	 */
	int insertReply(ReplyVO replyVo) throws Exception;
	
	/**
	 * 댓글을 수정하는 메서드
	 * @author 박경호
	 * @param replyVo 수정하려는 댓글 객체
	 * @return 댓글이 수정된 갯수
	 */
	int updateReply(ReplyVO replyVo) throws Exception;
	
	/**
	 * 댓글을 삭제하는 메서드
	 * @author 박경호
	 * @param replyId 삭제하려는 댓글 아이디
	 * @return 삭제된 댓글 갯수
	 */
	int deleteReply(String replyId) throws Exception;
	
	/**
	 * 댓글하나를 조회하는 메서드
	 * @author 박경호
	 * @param replyId 댓글아이디
	 * @return 댓글정보
	 * @throws Exception
	 */
	ReplyVO selectReply(String replyId) throws Exception; 
}
