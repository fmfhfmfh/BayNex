package kr.co.codemaker.admin.complain.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.codemaker.common.service.ComplainService;
import kr.co.codemaker.common.service.NotificationService;
import kr.co.codemaker.common.vo.ComplainVO;
import kr.co.codemaker.common.vo.NotificationVO;
import kr.co.codemaker.common.vo.UserVO;

@Controller
public class AdminComplainController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminComplainController.class);
	
	@Resource(name="complainService")
	private ComplainService complainService;
	
	@Resource(name="notificationService")
	private NotificationService notificationService;
	
	@RequestMapping(path="/admin/selectAllComplain")
	public String selectAllComplain(@RequestParam(name="page", required = false, defaultValue = "1") int page, 
			@RequestParam(name="pageSize", required = false, defaultValue = "5") int pageSize, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		try {
			map = complainService.selectAllComplain(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("complainList",map.get("complainList"));
		model.addAttribute("page", page);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pages", map.get("pages"));
		
		return "adminPage/admin/complain/complainList";
	}
	
	@RequestMapping(path="/admin/selectComplain")
	public String selectComplain(ComplainVO complainVo, Model model) {
		ComplainVO cpVo = new ComplainVO();
		try {
			cpVo = complainService.selectComplain(complainVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cpVo.getReplyId() != null) {
			String reId = "";
			try {
				reId = complainService.selectReplyQna(cpVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("reId", reId);
		}
		
		model.addAttribute("cpVo", cpVo);
		
		return "admin/complain/complain";
	}
	
	@RequestMapping(path="/admin/checkComplain")
	public String checkComplain(ComplainVO complainVo) {
		
		try {
			complainService.checkComplain(complainVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "jsonView";
	}
	
	@RequestMapping(path="/admin/selectBlackList")
	public String selectBlackList(Model model) {
		
		List<UserVO> blacklist = new ArrayList<UserVO>();
		try {
			blacklist = complainService.selectBlackList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("blacklist", blacklist);
		
		return "adminPage/admin/complain/complainBlack";
	}
	
	@RequestMapping(path="/admin/insertBlackList")
	public String insertBlackList(UserVO userVo) {
		
		try {
			complainService.insertBlackList(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/selectBlackList";
	}
}
