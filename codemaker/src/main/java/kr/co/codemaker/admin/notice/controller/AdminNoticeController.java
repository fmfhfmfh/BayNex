package kr.co.codemaker.admin.notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.codemaker.common.service.FilesService;
import kr.co.codemaker.common.service.NoticeService;
import kr.co.codemaker.common.vo.FilesVO;
import kr.co.codemaker.common.vo.NoticeVO;
import kr.co.codemaker.fileUpload.FileUploadUtil;


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
public class AdminNoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminNoticeController.class);
	
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@Resource(name="filesService")
	private FilesService filesService;
	
	@RequestMapping(path="/admin/selectAllNotice")
	public String selectAllNotice(@RequestParam(name="page", required = false, defaultValue = "1") int page, 
			@RequestParam(name="pageSize", required = false, defaultValue = "5") int pageSize, 
			@RequestParam(name="searchOption", required = false, defaultValue = "1") String searchOption, String keyWord, Model model) {	
		
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("searchOption", searchOption);
		map.put("keyWord", keyWord);
		map.put("pages", map.get("pages"));
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		try {
			map2 = noticeService.selectAllNotice(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("map2 {}", map2);
		
		model.addAttribute("totalCnt", map2.get("totalCnt"));
		model.addAttribute("noticeList", map2.get("noticeList"));
		model.addAttribute("pages", map2.get("pages"));
		model.addAttribute("page", page);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyWord", keyWord);
 		
		return "adminPage/admin/notice/noticeList";
	}
	
	@RequestMapping(path="/admin/selectNotice")
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
		
		return "adminPage/admin/notice/notice";
	}
	
	
	@RequestMapping(path="/admin/insertNotice", method={RequestMethod.GET})
	public String insertViewNotice() {
		
		return "adminPage/admin/notice/noticeInsert";
	}
	
	@RequestMapping(path="/admin/insertNotice", method={RequestMethod.POST})
	public String insertNotice(NoticeVO noticeVo, MultipartHttpServletRequest files) {
	 	
		List<MultipartFile> filesList = files.getFiles("realfile");
		
		logger.debug("files {}", filesList);
		int cnt = 0;
		try {
			cnt = noticeService.insertNotice(noticeVo);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for(int i = 0; i < filesList.size(); i++) {
			MultipartFile profile = filesList.get(i);
			FilesVO filesVo = new FilesVO();
			
			String filesNm = profile.getOriginalFilename();
			if(profile != null && !profile.equals("")) {
				
//				String ext = FileUploadUtil.getExtenstion(filesNm);
				String fileName = filesNm;
				String filesPath = "";
				
				if (profile.getSize() > 0) {
					filesPath = "C:\\profile\\" + fileName;
					File file = new File("C:\\profile\\" + filesNm);
					try {
						profile.transferTo(file);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
					
					filesVo.setFilesGroup(noticeVo.getNoticeId());
					filesVo.setFilesNm(filesNm);
					filesVo.setFilesPath(filesPath);
					
					logger.debug("파일에서의 filesGroup : {}", noticeVo.getNoticeId());
					
					filesService.insertFiles(filesVo);
					
				}
			}
		}
		logger.debug("파일 후 cnt {}", cnt);
		
		if(cnt == 1) {
			return "redirect:selectAllNotice?searchOption=1&keyWord=&page=1";
		}else {
			return "adminPage/admin/notice/noticeInsert";
		}
	}
	
	@RequestMapping(path="/admin/updateNotice", method={RequestMethod.GET})
	public String updateViewNotice(NoticeVO noticeVo, Model model) {
		
		NoticeVO noticeVo2 = new NoticeVO();
		List<FilesVO> filesList = new ArrayList<FilesVO>();
		try {
			noticeVo2 = noticeService.selectNotice(noticeVo.getNoticeId());
			filesList = filesService.selectAllFiles(noticeVo.getNoticeId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("noticeVo", noticeVo2);
		model.addAttribute("filesList", filesList);
		
		return "adminPage/admin/notice/noticeUpdate";
	}
	
	@RequestMapping(path="/admin/updateNotice", method= {RequestMethod.POST})
	public String updateNotice(NoticeVO noticeVo, MultipartHttpServletRequest files, HttpServletRequest request) {
		
		logger.debug("notice update : {}", noticeVo);
		
		String[] arr = request.getParameterValues("del_files");
		
		List<MultipartFile> fileslist = files.getFiles("realfile");
		
		if(arr != null) {
			for (int i = 0; i < arr.length; i++) {
				String filesId = arr[i];
				filesService.deleteFiles(filesId);
			}
		}
		
		int cnt = 0;
		try {
			cnt = noticeService.updateNotice(noticeVo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for(int i = 0; i < fileslist.size(); i++) {
			
			MultipartFile profile = fileslist.get(i);
			
			String filesNm = profile.getOriginalFilename();
			if(profile != null && !profile.equals("")) {
				
//				String ext = FileUploadUtil.getExtenstion(filesNm);
				String fileName = filesNm;
				String filesPath = "";
				
				if (profile.getSize() > 0) {
					filesPath = "C:\\profile\\" + fileName;
					File file = new File("D:\\profile\\" + filesNm);
					try {
						profile.transferTo(file);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
					
					FilesVO filesVo = new FilesVO();
					
					filesVo.setFilesGroup(noticeVo.getNoticeId());
					filesVo.setFilesNm(filesNm);
					filesVo.setFilesPath(filesPath);
					filesService.insertFiles(filesVo);
				}
			}
		}
		
		if(cnt == 1) {
			return "redirect:selectNotice?noticeId="+noticeVo.getNoticeId();
		}else {
			return "adminPage/admin/notice/noticeUpdate?noticeId="+noticeVo.getNoticeId();
		}
	}
	
	@RequestMapping(path="/admin/deleteNotice")
	public String deleteNotice(String noticeId) {
		
		try {
			noticeService.deleteNotice(noticeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:selectAllNotice?searchOption=1&keyWord=&page=1";
	}
	
	@RequestMapping(path="/admin/downloadNotice")
	public void downloadNotice(String filesId, HttpServletResponse response) throws Exception {
		
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
