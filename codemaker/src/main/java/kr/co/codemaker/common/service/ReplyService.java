package kr.co.codemaker.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.ReplyMapper;
import kr.co.codemaker.common.vo.ReplyVO;

/**
* ReplyService.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 1.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Service("replyService")
public class ReplyService {
	
	@Resource(name="replyMapper")
	private ReplyMapper replyMapper;
	
	public List<ReplyVO> selectAllReply(String qnaId) throws Exception {
		return replyMapper.selectAllReply(qnaId);
	}
	
	public int insertReply(ReplyVO replyVo) throws Exception {
		return replyMapper.insertReply(replyVo);
	}
	
	public int updateReply(ReplyVO replyVo) throws Exception {
		return replyMapper.updateReply(replyVo);
	}
	
	public int deleteReply(String replyId) throws Exception {
		return replyMapper.deleteReply(replyId);
	}
	
	public ReplyVO selectReply(String replyId) throws Exception {
		return replyMapper.selectReply(replyId);
	}
}
