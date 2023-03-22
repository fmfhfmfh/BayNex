package kr.co.codemaker.user.board.jobinfo.controller;

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
import kr.co.codemaker.common.service.JobInfoService;
import kr.co.codemaker.common.vo.FilesVO;
import kr.co.codemaker.common.vo.JobInfoVO;

@Controller
public class UserJobInfoController {
	@Resource(name="jobInfoService")
	private JobInfoService jobInfoService;
	
	@Resource(name="filesService")
	private FilesService filesService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserJobInfoController.class);
	
	@RequestMapping(path="/user/selectAllJobInfo")
	public String selectAllJobInfo(@RequestParam(name="page", required = false, defaultValue = "1") int page, 
			@RequestParam(name="pageSize", required = false, defaultValue = "7") int pageSize, 
			String keyWord, Model model) {	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("keyWord", keyWord);
		map.put("pages", map.get("pages"));
		
		
		
		Map<String, Object> map2 = new HashMap<>();
		try {
			map2 = jobInfoService.selectAllJobInfoU(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("totalCnt", map2.get("totalCnt"));
		
		logger.debug("user {}", map2.get("totalCnt"));
		
		model.addAttribute("jobinfoList", map2.get("jobInfoList"));
		model.addAttribute("pages", map2.get("pages"));
		model.addAttribute("page", map2.get("page"));
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("keyWord", keyWord);
 		
		return "mainT/user/jobInfo/jobInfoList";
	}
	
	
	@RequestMapping(path="/user/selectJobInfo")
	public String selectJobInfo(String jobinfoId, Model model) {
		
		JobInfoVO jobInfoVo = new JobInfoVO();
		try {
			jobInfoVo = jobInfoService.selectJobInfo(jobinfoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("jobinfoVo", jobInfoVo);
		logger.debug("jobInfoVo : {}", jobInfoVo);
		
		List<FilesVO> filesList = filesService.selectAllFiles(jobinfoId);	
		logger.debug("filesList {}", filesList);
	
		model.addAttribute("filesList", filesList);
		
		return "mainT/user/jobInfo/jobInfo";
	}
	
	@RequestMapping(path="/user/downloadJobInfo")
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
