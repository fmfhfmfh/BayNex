package kr.co.codemaker.testmember.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.testmember.vo.MemberVO;

@Mapper("memberMapper")
public interface MemberMapper {
	List<MemberVO> selectMember() throws Exception;
	
}
