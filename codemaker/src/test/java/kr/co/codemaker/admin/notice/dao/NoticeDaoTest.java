//package kr.co.codemaker.admin.notice.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//
//import kr.co.codemaker.ModelTestConfig;
//import kr.co.codemaker.common.dao.NoticeMapper;
//import kr.co.codemaker.common.vo.NoticeVO;
//
//public class NoticeDaoTest extends ModelTestConfig {
//	
//	@Resource(name="noticeMapper")
//	NoticeMapper noticeMapper;
//	
//	@Test
//	public void selectNoticeTest() throws Exception {
//		/***Given***/
//		String noticeId = "NOTICE1";
//		/***When***/
//		NoticeVO nv = noticeMapper.selectNotice(noticeId);
//		/***Then***/
//		assertEquals(nv.getNoticeId(), "NOTICE1");
//	}
//	
//	@Test
//	public void noticeTotalCntTest() throws Exception {
//		/***Given***/
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("page", 1);
//		map.put("pageSize", 5);
//		
//		/***When***/
//		int cnt = noticeMapper.noticeTotalCnt(map);
//		
//		/***Then***/
//		assertEquals(cnt, 5);
//	}
//	
//	@Test
//	public void selectAllNoticeTest() throws Exception {
//		/***Given***/
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("page", 1);
//		map.put("pageSize", 5);
//		
//		/***When***/
//		List<NoticeVO> noticeList = noticeMapper.selectAllNotice(map);
//
//		/***Then***/
//		assertEquals(noticeList.size(), 5);
//	}
//	
//	@Test
//	public void insertNoticeTest() throws Exception {
//		/***Given***/
//		NoticeVO noticeVo = new NoticeVO();
//		/***When***/
//		noticeVo.setNoticeTitle("테스트");
//		noticeVo.setNoticeCont("테스트");
//		noticeVo.setNoticeHead("1");
//		noticeVo.setAdminId("admin");
//		
//		int cnt = noticeMapper.insertNotice(noticeVo);
//		/***Then***/
//		assertEquals(cnt, 1);
//	}
//	@Test
//	public void updateNoticeTest() throws Exception {
//		/***Given***/
//		NoticeVO noticeVo = noticeMapper.selectNotice("NOTICE5");
//		
//		/***When***/
//		noticeVo.setNoticeCont("테스트");
//		
//		int cnt = noticeMapper.updateNotice(noticeVo);
//		
//		/***Then***/
//		assertEquals(cnt, 1);
//	}
//	
//	@Test
//	public void deleteNoticeTest() throws Exception {
//		/***Given***/
//		String noticeId = "NOTICE5";
//		/***When***/
//		int cnt = noticeMapper.deleteNotice(noticeId);
//		/***Then***/
//		assertEquals(cnt, 1);
//	}
//
//}
