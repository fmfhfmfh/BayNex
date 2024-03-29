package kr.co.codemaker.fileUpload;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//maxFileSize= 파일 하나당 최대 허용 크기
// maxRequestSize : 요청에 담긴 모든 사이즈
//단위 byte
//1MB = 1024KB = 1024&1024
//10MB= 1024*1024 *15
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize =1024*1024*5, maxRequestSize = 1024*1024*26)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.debug("get request.getContentType() : {} ", request.getContentType());
		request.getRequestDispatcher("/fileUpload/uploadView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("post request.getContentType() : {} " ,request.getContentType());
		
		String userid = request.getParameter("userid");
		String img = request.getParameter("img");
		

		logger.debug("userid : {} " +userid);
		logger.debug("img : {} " +img);
		
		Part imgPart = request.getPart("img");
		logger.debug("getName() : {}" , imgPart.getName());
		logger.debug("getSize() : {}" , imgPart.getSize());
		logger.debug("getContentType() : {}" , imgPart.getContentType());
		logger.debug("Content-Disposition : {} ", imgPart.getHeader("Content-Disposition"));
		
		String fileName = FileUploadUtil.getFileName(imgPart.getHeader("Content-Disposition"));
		
		imgPart.write("c:\\img\\"+fileName);
		imgPart.delete();
	}

}
