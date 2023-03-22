package kr.co.codemaker.admin.company.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import kr.co.codemaker.admin.company.service.CompanyService;
import kr.co.codemaker.admin.company.service.AdminFilesService;
import kr.co.codemaker.admin.company.vo.CompanyVO;
import kr.co.codemaker.admin.company.vo.FilesVO;

/**
* CompanyController.java
*
* @author 박다미
* @version 1.0
* @since 2020. 12. 15.
*
* 수정자 수정내용
* ------ ------------------------
* 박다미 최초 생성
*
 */

@Controller
public class CompanyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Resource(name="companyService")
	private CompanyService companyService;
	
	@Resource(name="adminFilesService")
	private AdminFilesService adminFilesService;
	
	
	
	/**
	 * 관리자 - 기업리스트 조회
	 * @param page
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/admin/company/selectAllCompany")
	public String selectAllCompany(@RequestParam(name="page", required = false, defaultValue = "1") int page, 
			@RequestParam(name="pageSize", required = false, defaultValue = "5")int pageSize,Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		logger.debug("map {}", map);
		
		try {
			map = companyService.selectAllCompany(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("companyList",map.get("companyList"));
		model.addAttribute("page",page);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("pages", map.get("pages"));
		return "adminPage/admin/company/companyAllSelect";
	}
	
	
	/**
	 * 관리자 - 기업 계약서 조회
	 * @param comId
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/admin/company/companyContract")
	public String contractTest(String comId, Model model) {
		CompanyVO companyVO = new CompanyVO();
		companyVO.setComId(comId);
		
		try {
			companyVO = companyService.selectCompany(companyVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("companyVO", companyVO);
		return "admin/company/companyContract";
	}

	/**
	 * 사인한 계약서 pdf파일로 변경
	 * @param comId
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/admin/company/companyPdf" ,method=RequestMethod.POST)
	public void contractPdf(@RequestParam(value="imgData", required= false) String imgData,String comId,HttpServletResponse response, HttpServletRequest request) {
		logger.debug("이미지 url:{}",imgData);
		FilesVO filesVO = new FilesVO();
		CompanyVO companyVO = new CompanyVO();
		companyVO.setComId(comId);
		
		
		try {
			companyVO = companyService.selectCompany(companyVO);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.debug("회사VO@@!!:{}",companyVO);
		
		String filePath = "";
		String filename = "";
		
		try{
            if(imgData == null || imgData=="") {
                throw new Exception();    
            }
            
            imgData = imgData.replaceAll("data:image/png;base64,", "");
            byte[] file = Base64.decodeBase64(imgData);
            // pdf 업로드할 경로 설정
            
            filePath = "C:\\pdf\\";
            filename = companyVO.getComNm()+".pdf";
            File root = new File(filePath);
            
//            logger.debug("파일!!:{}",file);
            
            // jsp에서 받은 canvas를 png로 만들기
            Image image = Image.getInstance(file);
            // pdf 사이즈 설정
            float imageWidth = 595;
            float pageHeight = (float) (imageWidth * 1.414);
            logger.debug("길이!!!:{},{}",image.getHeight(),image.getWidth());
            float imageHeight = image.getHeight() * imageWidth / image.getWidth();
//            float imageHeight = 300;
            float heightLeft = imageHeight;
            
            // pdf형식의 document를 생성
            Document document = new Document();
            
            // PdfWriter를 취득하고, 파일IO 스트림을 취득
            PdfWriter.getInstance(document, new FileOutputStream(new File(root,filename)));
            float position = 300;
            image.scaleAbsolute(imageWidth, imageHeight);
            image.setAbsolutePosition(0, position);
            // document open
            document.open();
            document.newPage();

            // pdf에 만든 png추가
            document.add(image);
            heightLeft -= pageHeight;
            document.close();
            
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.debug("파일이름,패스:{},{}", filename, filePath);
		filesVO.setFilesNm(filename);
		filesVO.setFilesPath(filePath+filename);
		
		logger.debug("fileVO!!:{}", filesVO);
		try {
			// 파일VO insert
			adminFilesService.insertFiles(filesVO);
			// 해당 기업에 생성된 파일id update
			
			if(!companyVO.getComState().equals("Y")) {
				companyService.updateCompany(companyVO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(path="/admin/company/companyPdfDown")
	public void companyPdfDown(String filesId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		FilesVO filesVO = new FilesVO();
		filesVO.setFilesId(filesId);
		
		try {
			filesVO = adminFilesService.selectFiles(filesVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 파일이름 한글로 다운받기
		String filesNm = new String(filesVO.getFilesNm().getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"\"" + filesNm + "\"");
		response.setContentType("application/octet-stream");
		response.setCharacterEncoding("UTF-8");
		
		FileInputStream fis = new FileInputStream(filesVO.getFilesPath());
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
