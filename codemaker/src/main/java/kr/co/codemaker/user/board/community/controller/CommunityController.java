package kr.co.codemaker.user.board.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import kr.co.codemaker.common.vo.UserVO;
import kr.co.codemaker.fileUpload.FileUploadUtil;
import kr.co.codemaker.user.board.community.service.PostFileService;
import kr.co.codemaker.user.board.community.service.PostService;
import kr.co.codemaker.user.board.community.vo.PostFileVO;
import kr.co.codemaker.user.board.community.vo.PostVO;

/**
 * 
 * CommunityController.java
 * 
 * @author 이은지
 * @version 1.0
 * @since 2020.12.28
 *   
 *	수정자	수정내용		
 *	------	------------------------
 *	이은지	최초 생성
 *
 */

@Controller
public class CommunityController {
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@Resource(name="postService")
	private PostService postService;
	
	@Resource(name="postFileService")
	private PostFileService postFileService;
	
	@RequestMapping(path="/user/community")
	public String getAllPost(Model model, PostVO postVO) throws Exception {
		List<PostVO> postList = postService.getAllPost(postVO);
		model.addAttribute("postList", postList);
		logger.debug("postList!!!!!!!!!!!!!!!!!!!!!!!!!! : {}", postList);
		
		return "mainT/user/community/allSelect";
	}
	
	@RequestMapping(path="/user/community/select")
	public String getPost(PostVO postVO, Model model) throws Exception {
		
		postVO = postService.getPost(postVO);
		model.addAttribute("PostVO", postVO);
		logger.debug("postVO : {}", postVO);
		
		return "mainT/user/community/select";
	}
	
	@RequestMapping(path="/user/community/insertView")
	public String insertView() throws Exception {
		
		return "mainT/user/community/insert";
	}
	
	
	
	@RequestMapping(path="/user/community/insert")
	public String insertPost(PostVO postVO, MultipartHttpServletRequest filePath, HttpSession session, Model model) throws Exception{
		
		List<MultipartFile> list = filePath.getFiles("fileName");
		logger.debug("제목 : {}", postVO.getPostTitle());
		
		UserVO userVO = (UserVO) session.getAttribute("MEMBER_INFO");
		String userId = userVO.getUserId();
		postVO.setUserId(userId);
		
		logger.debug("postVO : {}", postVO);
		
		int cnt = postService.insertPost(postVO);
		logger.debug("insertCnt : {}", cnt);
		
		String filename = "";
		String filePaths = "";
		String extension = "";
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getOriginalFilename() != null && !(list.get(i).getOriginalFilename().equals(""))) {
				try {
					filename = UUID.randomUUID().toString();
					extension = FileUploadUtil.getExtenstion(list.get(i).getOriginalFilename());
					logger.debug("확장자 : {} ", extension);
					filePaths = "c:\\file\\" + filename + "." + extension;
					File uploadFile = new File(filePaths);
					list.get(i).transferTo(uploadFile);					
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				PostFileVO fileVO = new PostFileVO();
				fileVO.setPostNo(postVO.getPostNo());
				fileVO.setFileName(list.get(i).getOriginalFilename());
				fileVO.setFilePath(filePaths);
				
				int insertCnt = postFileService.insertPostFile(fileVO);
				
				logger.debug("무슨 파일을 업로드 했으까~~~!! : {}", insertCnt);
			}
		}
		return "redirect:/user/community";
	}
	
	@RequestMapping(path="/user/community/update")
	public String updatePost(PostVO postVO) {
		int postNo = postVO.getPostNo();
		logger.debug("postNo이야아아앙아아아아아아아ㅏㅇ미나이ㅏㄴ미아!!!!!!!!!!!!!!!!!!!!!!!! : {}", postNo);
		
		return "mainT/user/community/update?=" + postNo;
	}
	
	@RequestMapping(path="/user/community/delete")
	public String deletePost(int postNo) throws Exception {
		
		int cnt = postService.deletePost(postNo);
		logger.debug("cnt : {}", cnt);
		
		return "redirect:/user/community";
	}
}
