package kr.co.codemaker.common.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.NoticeMapper;
import kr.co.codemaker.common.vo.NoticeVO;


/**
* NoticeService.java
*
* @author 박경호
* @version 1.0
* @since 2020. 11. 24.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Service("noticeService")
public class NoticeService {
	
	private static final Logger log = LoggerFactory.getLogger(NoticeService.class);
	
	@Resource(name="noticeMapper")
	private NoticeMapper noticeMapper;

	
	public Map<String, Object> selectAllNotice(Map<String, Object> map) throws Exception {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("noticeList", noticeMapper.selectAllNotice(map));
		log.debug("탐탐탐?2");
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		
		int cnt = noticeMapper.noticeTotalCnt(map);
		
		
		int pages =(int) Math.ceil((double)cnt/(int) map.get("pageSize"));
		map2.put("pages", pages); 
		map2.put("totalCnt", cnt);
		return map2;
	}
	public Map<String, Object> selectAllNoticeU(Map<String, Object> map) throws Exception {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("noticeList", noticeMapper.selectAllNoticeU(map));
		log.debug("탐탐탐?2");
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		
		int cnt = noticeMapper.noticeTotalCntU(map);
		
		
		int pages =(int) Math.ceil((double)cnt/(int) map.get("pageSize"));
		map2.put("pages", pages); 
		map2.put("totalCnt", cnt);
		return map2;
	}

	
	public NoticeVO selectNotice(String noticeId) throws Exception {
		return noticeMapper.selectNotice(noticeId);
	}

	
	public int insertNotice(NoticeVO noticeVo) throws Exception {
		return noticeMapper.insertNotice(noticeVo);
	}

	
	public int updateNotice(NoticeVO noticeVo) throws Exception {
		return noticeMapper.updateNotice(noticeVo);
	}

	
	public int deleteNotice(String noticeId) throws Exception {
		return noticeMapper.deleteNotice(noticeId);
	}

}
