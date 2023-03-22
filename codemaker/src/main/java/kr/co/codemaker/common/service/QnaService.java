package kr.co.codemaker.common.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.QnaMapper;
import kr.co.codemaker.common.vo.QnaVO;

/**
* QnaService.java
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
@Service("qnaService")
public class QnaService {
	
	private static final Logger logger = LoggerFactory.getLogger(QnaService.class);
	
	@Resource(name="qnaMapper")
	private QnaMapper qnaMapper;
	
	public Map<String, Object> selectAllQna(Map<String, Object> map) throws Exception {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("qnaList", qnaMapper.selectAllQna(map));
		
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		
		int cnt = qnaMapper.qnaTotalCnt();
		
		
		int pages =(int) Math.ceil((double)cnt/(int) map.get("pageSize"));
		map2.put("pages", pages); 
		return map2;
	}
	
	public Map<String, Object> selectAllQnaT(Map<String, Object> map) throws Exception {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("qnaList", qnaMapper.selectAllQnaT(map));
		
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		String tchId = (String) map.get("tchId");
		logger.debug("-----------------------{}--------------------------", map);
		
		int cnt = qnaMapper.qnaTotalCntT(tchId);
		
		
		int pages =(int) Math.ceil((double)cnt/(int) map.get("pageSize"));
		map2.put("pages", pages); 
		return map2;
	}

	
	public QnaVO selectQna(String qnaId) throws Exception {
		return qnaMapper.selectQna(qnaId);
	}

	
	public int insertQna(QnaVO qnaVo) throws Exception {
		return qnaMapper.insertQna(qnaVo);
	}

	
	public int deleteQna(String qnaId) throws Exception {
		return qnaMapper.deleteQna(qnaId);
	}
	
	public String selectQnaTeacher(String qnaId) throws Exception {
		return qnaMapper.selectQnaTeacher(qnaId);
	}
}
