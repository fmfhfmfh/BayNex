package kr.co.codemaker.user.notice.controller;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.common.service.FilesService;
import kr.co.codemaker.common.service.NoticeService;
import kr.co.codemaker.common.vo.FilesVO;
import kr.co.codemaker.common.vo.NoticeVO;


/**
* NoticeController.java
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
@Controller
public class UserNoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserNoticeController.class);
	
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@Resource(name="filesService")
	private FilesService filesService;
	
	@RequestMapping(path="/user/selectAllNotice")
	public String selectAllNotice(@RequestParam(name="page", required = false, defaultValue = "1") int page, 
			@RequestParam(name="pageSize", required = false, defaultValue = "7") int pageSize, 
			String searchOption, String keyWord, Model model) {	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("searchOption", searchOption);
		map.put("keyWord", keyWord);
		map.put("pages", map.get("pages"));
		
		
		logger.debug("map {}", map);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		try {
			map2 = noticeService.selectAllNoticeU(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("map2 {}", map2);
		
		model.addAttribute("totalCnt", map2.get("totalCnt"));
		model.addAttribute("noticeList", map2.get("noticeList"));
		model.addAttribute("pages", map2.get("pages"));
		model.addAttribute("page", map2.get("page"));
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyWord", keyWord);
 		
		return "mainT/user/notice/noticeList";
	}
	
	@RequestMapping(path="/user/selectNotice")
	public String selectNotice(String noticeId, Model model) {
		
		NoticeVO noticeVo = new NoticeVO();
		
		try {
			noticeVo = noticeService.selectNotice(noticeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<FilesVO> filesList = filesService.selectAllFiles(noticeId);	
		
		model.addAttribute("noticeVo", noticeVo);
		model.addAttribute("filesList", filesList);
		
		return "mainT/user/notice/notice";
	}
	@RequestMapping(path="/user/downloadNotice")
	public void downloadJobInfo(String filesId, HttpServletResponse response) throws Exception {
		
		FilesVO filesVo = filesService.selectFiles(filesId);
		
		String filesNm = new String(filesVo.getFilesNm().getBytes("UTF-8"), "ISO-8859-1");
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+filesNm+"\"");
		response.setContentType("application/octet-stream");
		
		FileInputStream fis = new FileInputStream("C:\\profile\\" + filesVo.getFilesNm());
		
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
	}
	
}
