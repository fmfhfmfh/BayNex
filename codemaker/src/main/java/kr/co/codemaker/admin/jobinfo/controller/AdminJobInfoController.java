package kr.co.codemaker.admin.jobinfo.controller;

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
import kr.co.codemaker.common.service.JobInfoService;
import kr.co.codemaker.common.vo.FilesVO;
import kr.co.codemaker.common.vo.JobInfoVO;
import kr.co.codemaker.fileUpload.FileUploadUtil;


/**
* AdminJobInfoController.java
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
public class AdminJobInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminJobInfoController.class);
	
	@Resource(name="jobInfoService")
	private JobInfoService jobInfoService;
	
	@Resource(name="filesService")
	private FilesService filesService;
	
	@RequestMapping(path="/admin/selectAllJobInfo")
	public String selectAllJobInfo(@RequestParam(name="page", required = false, defaultValue = "1") int page, 
			@RequestParam(name="pageSize", required = false, defaultValue = "7") int pageSize, 
			@RequestParam(name="searchOption", required = false, defaultValue = "1") String searchOption, String keyWord, Model model) {	
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("searchOption", searchOption);
		map.put("keyWord", keyWord);
		map.put("pages", map.get("pages"));
		
		
		logger.debug("map {}", map);
		
		Map<String, Object> map2 = new HashMap<>();
		try {
			map2 = jobInfoService.selectAllJobInfo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("map2 {}", map2.get("jobInfoList"));
		
		model.addAttribute("totalCnt", map2.get("totalCnt"));
		model.addAttribute("jobInfoList", map2.get("jobInfoList"));
		model.addAttribute("pages", map2.get("pages"));
		model.addAttribute("page", page);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyWord", keyWord);
 		
		return "adminPage/admin/jobInfo/jobInfoList";
	}
	
	@RequestMapping(path="/admin/selectJobInfo")
	public String selectJobInfo(String jobinfoId, Model model) {
		
		JobInfoVO jobInfoVo = new JobInfoVO();
		try {
			jobInfoVo = jobInfoService.selectJobInfo(jobinfoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("jobInfoVo", jobInfoVo);
		logger.debug("jobInfoVo : {}", jobInfoVo);
		
		List<FilesVO> filesList = filesService.selectAllFiles(jobinfoId);	
		logger.debug("filesList {}", filesList);
	
		model.addAttribute("filesList", filesList);
		
		return "adminPage/admin/jobInfo/jobInfo";
	}
	
	
	@RequestMapping(path="/admin/insertJobInfo", method={RequestMethod.GET})
	public String insertViewJobInfo() {
		
		return "adminPage/admin/jobInfo/jobInfoInsert";
	}
	
	@RequestMapping(path="/admin/insertJobInfo", method={RequestMethod.POST})
	public String insertJobInfo(JobInfoVO jobInfoVo, MultipartHttpServletRequest files) {
	 	
		List<MultipartFile> filesList = files.getFiles("realfile");
		
		int cnt = 0;
		try {
			cnt = jobInfoService.insertJobInfo(jobInfoVo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		logger.debug("filesList.size {}", filesList.size());
		
		int filecnt = 0;
		for(int i = 0; i < filesList.size(); i++) {
			MultipartFile profile = filesList.get(i);
			
			FilesVO filesVo = new FilesVO();
			
			logger.debug("파일 업로드 filecnt : {}", filecnt);
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
					
					
					
					filesVo.setFilesGroup(jobInfoVo.getJobinfoId());
					filesVo.setFilesNm(filesNm);
					filesVo.setFilesPath(filesPath);
					
					filesService.insertFiles(filesVo);
					filecnt++;
					
					logger.debug("파일 후 filecnt {}", filecnt);
				}
			}
		}
		
		if(cnt == 1) {
			return "redirect:selectAllJobInfo?keyWord=&page=1";
		}else {
			return "adminPage/admin/jobInfo/jobInfoInsert";
		}
	}
	
	@RequestMapping(path="/admin/updateJobInfo", method={RequestMethod.GET})
	public String updateViewJobInfo(JobInfoVO jobinfoVo, Model model) {
		
		JobInfoVO jobinfoVo2 = new JobInfoVO();
		List<FilesVO> filesList = new ArrayList<FilesVO>();
		try {
			jobinfoVo2 = jobInfoService.selectJobInfo(jobinfoVo.getJobinfoId());
			filesList = filesService.selectAllFiles(jobinfoVo.getJobinfoId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("filesList", filesList);
		model.addAttribute("jobinfoVo", jobinfoVo2);
		
		return "adminPage/admin/jobInfo/jobInfoUpdate";
	}
	
	@RequestMapping(path="/admin/updateJobInfo", method= {RequestMethod.POST})
	public String updateJobInfo(JobInfoVO jobinfoVo, MultipartHttpServletRequest files, HttpServletRequest request) {
		
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
			cnt = jobInfoService.updateJobInfo(jobinfoVo);
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
					
					filesVo.setFilesGroup(jobinfoVo.getJobinfoId());
					filesVo.setFilesNm(filesNm);
					filesVo.setFilesPath(filesPath);
					
					filesService.insertFiles(filesVo);
				}
			}
		}
		
		if(cnt == 1) {
			return "redirect:selectJobInfo?jobinfoId="+jobinfoVo.getJobinfoId();
		}else {
			return "adminPage/admin/jobInfo/jobInfoUpdate?jobinfoId="+jobinfoVo.getJobinfoId();
		}
	}
	
	@RequestMapping(path="/admin/deleteJobInfo")
	public String deleteJobInfo(String jobinfoId) {
		
		try {
			jobInfoService.deleteJobInfo(jobinfoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:selectAllJobInfo?keyWord=&page=1";
		
	}
	
	@RequestMapping(path="admin/downloadJobInfo")
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
