package kr.co.codemaker.user.course.note.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.user.course.note.service.NoteService;
import kr.co.codemaker.user.course.note.vo.NoteRequestVO;
import kr.co.codemaker.user.course.note.vo.NoteVO;

/**
 * 
* NoteController.java
*
* @author 김미연
* @version 1.0
* @since 2020. 12. 1.
*
* 수정자 수정내용
* ------ ------------------------
* 김미연 최초 생성
*
 */
@Controller
public class NoteController {

	@Resource(name = "noteService")
	private NoteService noteService;

	/**
	 * 회원의 노트 목록을 페이징 처리하여 가져오는 메서드
	 * 
	 * @author 김미연
	 * @param noteVO
	 * @return
	 */
	@RequestMapping(path = "/note/selectPageNote")
	public String selectPageFNote(NoteVO noteVO, HttpSession session, Model model) {
		String userId = ((UserVO)session.getAttribute("MEMBER_INFO")).getUserId();
		
//		String userId = "a001@naver.com";

		noteVO.setUserId(userId);
		if (noteVO.getPage() == 0) {
			noteVO.setPage(1);
		}

		List<NoteVO> noteList = new ArrayList<>();
		int totalCnt = 0;
		try {
			noteList = noteService.selectPageNote(noteVO);
			totalCnt = noteService.selecTotalCntNote(noteVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int pages = (int) Math.ceil((double) totalCnt / 10);

		noteVO.setEndPage(pages);
		noteVO.setStartPage(1);

		model.addAttribute("noteList", noteList);
		model.addAttribute("pages", pages);
		model.addAttribute("noteRequestVO", noteVO);

		return "mypageT/user/note/noteAllSelect";
	}
	
	/**
	 * 회원 노트 1개의 정보를 가져오는 메소드
	 * 
	 * @author 김미연
	 * @param noteId
	 * @return
	 */
	@RequestMapping(path = "/note/selectNote")
	public String selectNote(String noteId, Model model) {

		NoteVO noteVO = null;
		try {
			noteVO = noteService.selectNote(noteId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("noteVO", noteVO);

		return "mypageT/user/note/noteSelect";
	}

	/**
	 * 노트를 등록하는 화면을 요청하는 메소드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/note/insertViewNote")
	public String insertViewNote() {
		return "user/note/noteInsert";
	}

	/**
	 * 노트를 등록하는 메소드
	 * 
	 * @author 김미연
	 * @param noteVo
	 * @return
	 */
	@RequestMapping(path = "/note/insertNote")
	@ResponseBody
	public void insertNote(NoteVO noteVO, HttpSession session) {
		String userId = ((UserVO)session.getAttribute("MEMBER_INFO")).getUserId();
		
//		noteVO.setUserId("a001@naver.com");
		noteVO.setUserId(userId);

		try {
			noteService.insertNote(noteVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 노트를 수정하는 화면을 요청하는 메소드
	 * 
	 * @author 김미연
	 * @return
	 */
	@RequestMapping(path = "/note/updateViewNote")
	public String updateViewNote(String noteId, Model model) {
		NoteVO noteVO = null;
		try {
			noteVO = noteService.selectNote(noteId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("noteVO", noteVO);
		
		return "mypageT/user/note/noteUpdate";
	}

	/**
	 * 노트를 수정하는 메소드
	 * 
	 * @author 김미연
	 * @param noteVo
	 * @return
	 */
	@RequestMapping(path = "/note/updateNote")
	public String updateNote(NoteVO noteVO) {
		try {
			noteService.updateNote(noteVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/note/selectNote?noteId=" + noteVO.getNoteId();
	}

	/**
	 * 노트를 삭제하는 메소드
	 * 
	 * @author 김미연
	 * @param noteVo
	 * @return
	 */
	@RequestMapping(path = "/note/deleteNote")
	public String deleteNote(NoteVO noteVO) {
		try {
			noteService.deleteNote(noteVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/note/selectPageNote";
	}

	/**
	 * 노트를 압축파일로 저장하는 메소드
	 * 
	 * @author 김미연
	 * @param noteList
	 * @param response
	 */
	@RequestMapping(value = "/note/noteDownload")
	public void downloadPdf(@RequestParam(value="noteIds")List<String> noteIds, HttpServletResponse response, HttpServletRequest request) {
		List<NoteVO> noteLists = new ArrayList<NoteVO>();
		
		// DB에서 정보 가져오기
		for (String noteId : noteIds) {
			NoteVO noteVO = null;
			try {
				noteVO = noteService.selectNote(noteId);
				noteLists.add(noteVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// ------------------------------ pdf 파일 생성
		List<File> files = new ArrayList<>();
		for (NoteVO noteVO : noteLists) {
			// PDF를 작성하는 html
			String html2 = noteVO.getNoteCont().replaceAll("<br>", "<br/>");
			String html = "<html><head></head><body>"+ html2 +"</body></html>";
			
			File downloadFile = new File(noteVO.getNoteTitle() + ".pdf");
			files.add(downloadFile);
			
			// 파일 IO 스트림을 취득한다.
			try (FileOutputStream os = new FileOutputStream(noteVO.getNoteTitle() + ".pdf")) {
				// Pdf형식의 document를 생성한다.
				Document document = new Document(PageSize.A4, 10, 10, 10, 10);
				// PdfWriter를 취득한다.
				PdfWriter writer = PdfWriter.getInstance(document, os);
				// document Open한다.
				document.open();
				
				// css를 설정할 resolver 인스턴스 생성
				StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver();
				
				// Css 파일 설정 (css1.css 파일 설정)
				String fileName = request.getServletContext().getRealPath("/css/css1.css");
				try (FileInputStream cssStream = new FileInputStream(fileName)) {
					cssResolver.addCss(XMLWorkerHelper.getCSS(cssStream));
				}
				// 폰트 설정
				XMLWorkerFontProvider font = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
				// window 폰트 설정
				font.register("c:/windows/fonts/malgun.ttf", "MalgunGothic");
				// 폰트 인스턴스를 생성한다.
				CssAppliersImpl cssAppliers = new CssAppliersImpl(font);
				// htmlContext의 pipeline 생성. (폰트 인스턴스 생성)
				HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
				htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

				// pdf의 pipeline 생성.
				PdfWriterPipeline pdfPipeline = new PdfWriterPipeline(document, writer);
				// Html의pipeline을 생성 (html 태그, pdf의 pipeline설정)
				HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, pdfPipeline);
				// css의pipeline을 합친다.
				CssResolverPipeline cssResolverPipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
				// Work 생성 pipeline 연결
				XMLWorker worker = new XMLWorker(cssResolverPipeline, true);
				// Xml 파서 생성(Html를 pdf로 변환)
				XMLParser xmlParser = new XMLParser(true, worker, Charset.forName("UTF-8"));
				// 출력한다.
				try (StringReader strReader = new StringReader(html)) {
					xmlParser.parse(strReader);
				}
				// document의 리소스 반환
				document.close();

			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		// -------------------------- zip 파일 생성
		ZipOutputStream zout = null;
		String zipName = "codemakerNote.zip";
		
		byte[] buffer = new byte[1024];

		if (files.size() > 0) {
			try {
				zout = new ZipOutputStream(new FileOutputStream(zipName));
				FileInputStream in = null;

				for (int i = 0; i < files.size(); i++) {
					in = new FileInputStream(files.get(i));
					zout.putNextEntry(new ZipEntry(files.get(i).getName()));

					int len;
					while ((len = in.read(buffer)) > 0) {
						zout.write(buffer, 0, len);
					}
					zout.closeEntry();
					in.close();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (zout != null)
						zout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// -------------------------- 파일 다운로드
		// response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=" + zipName);
		response.setContentType("application/octet-stream");

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(zipName));

			bos = new BufferedOutputStream(response.getOutputStream());

			int nn = 0;
			while ((nn = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, nn);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
