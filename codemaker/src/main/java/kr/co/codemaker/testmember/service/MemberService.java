package kr.co.codemaker.testmember.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.testmember.dao.MemberMapper;
import kr.co.codemaker.testmember.vo.MemberVO;

@Service("memberService")
public class MemberService {
	
	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	public List<MemberVO> selectMember(){
		try {
			return memberMapper.selectMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
