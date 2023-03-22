package kr.co.codemaker.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.ComplainMapper;
import kr.co.codemaker.common.vo.ComplainVO;
import kr.co.codemaker.common.vo.UserVO;

@Service("complainService")
public class ComplainService {
	
	@Resource(name="complainMapper")
	private ComplainMapper complainMapper;
	
	public Map<String, Object> selectAllComplain(Map<String, Object> map) throws Exception{
		
		map.put("complainList", complainMapper.selectAllComplain(map));
		
		int cnt = complainMapper.complainTotalCnt();
		
		int pages = (int)Math.ceil((double)cnt/(int)map.get("pageSize"));
		
		map.put("pages", pages);
		
		return map;
	}
	
	public int insertComplain(ComplainVO complainVo) throws Exception{
		return complainMapper.insertComplain(complainVo);
	}
	
	public ComplainVO selectComplain(ComplainVO complainVo) throws Exception {
		return complainMapper.selectComplain(complainVo);
	}
	
	public int checkComplain(ComplainVO complainVo) throws Exception {
		return complainMapper.checkComplain(complainVo);
	}
	
	public String selectReplyQna(ComplainVO complainVo) throws Exception {
		return complainMapper.selectReplyQna(complainVo);
	}
	
	public List<UserVO> selectBlackList() throws Exception{
		return complainMapper.selectBlackList();
	}
	
	public int insertBlackList(UserVO userVo) throws Exception {
		return complainMapper.insertBlackList(userVo);
	}
}
