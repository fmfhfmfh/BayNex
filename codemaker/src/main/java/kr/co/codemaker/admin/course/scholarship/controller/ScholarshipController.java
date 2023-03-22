package kr.co.codemaker.admin.course.scholarship.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.codemaker.admin.course.scholarship.service.ScholarshipService;
import kr.co.codemaker.admin.course.scholarship.vo.PointVO;
import kr.co.codemaker.admin.course.scholarship.vo.ScholarshipVO;
import kr.co.codemaker.admin.course.scholarship.vo.SubjectVO;

/**
 * 
 * ScholarshipController.java
 *
 * @author 김미연
 * @version 1.0
 * @since 2020. 12. 17.
 *
 *        수정자 수정내용 ------ 
 *        ------------------------ 김미연 최초 생성
 *
 */
@Controller
public class ScholarshipController {

	// admin/scholarship

	@Resource(name = "scholarshipService")
	private ScholarshipService scholarshipService;

	/**
	 * 강의별로 장학금을 지급할 회원 + 강의별로 장학금을 지급한 내역을 조회하는 메서드 (간략 조회)
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectAllScholarship")
	public String selectAllScholarship(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		List<ScholarshipVO> scholarshipAList = new ArrayList<ScholarshipVO>();
		List<SubjectVO> subjectList = new ArrayList<>();

		try {
			scholarshipList = scholarshipService.selectAllScholarshipCnt(scholarshipVO);
			subjectList = scholarshipService.selectAllSubject(scholarshipVO);
			scholarshipAList = scholarshipService.selectAllScholarship(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("scholarshipList", scholarshipList);
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("scholarshipAList", scholarshipAList);

		return "adminPage/admin/scholarship/scholarshipAllSelect";
	}

	/**
	 * 수강중인 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectCurAllLesson")
	public String selectCurAllLesson(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		try {
			scholarshipList = scholarshipService.selectCurAllLesson(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scholarshipList", scholarshipList);

		return "adminPage/admin/scholarship/lessonScholarshipSelect";
	}

	/**
	 * 완강한 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectLessonScholarship")
	public String selectLessonScholarship(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		try {
			scholarshipList = scholarshipService.selectLessonScholarship(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scholarshipList", scholarshipList);

		return "adminPage/admin/scholarship/lessonScholarshipSelect";
	}

	/**
	 * 완강한 회원들 중에서 모든 시험을 푼 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectExamScholarship")
	public String selectExamScholarship(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		try {
			scholarshipList = scholarshipService.selectExamScholarship(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scholarshipList", scholarshipList);

		return "adminPage/admin/scholarship/examScholarshipSelect";
	}

	/**
	 * 상세조회한 회원들의 목록을 엑셀 파일로 저장
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/excelScholarship")
	public void excelScholarship(ScholarshipVO scholarshipVO, HttpServletRequest request, HttpServletResponse response) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		
		// 받은 데이터를 맵에 담는다.
		Map<String, Object> beans = new HashMap<String, Object>();

		try {
			// 수강중인 회원 목록
			if (scholarshipVO.getExcelGn().equals("1")) {
				scholarshipList = scholarshipService.selectCurAllLesson(scholarshipVO);
			}
			// 완강 목록
			else if (scholarshipVO.getExcelGn().equals("2")) {
				scholarshipList = scholarshipService.selectLessonScholarship(scholarshipVO);
			}
			// 시험 완료
			else if (scholarshipVO.getExcelGn().equals("3")) {
				scholarshipList = scholarshipService.selectExamScholarship(scholarshipVO);
			}
			// 완강 지급
			else if (scholarshipVO.getExcelGn().equals("4")) {
				scholarshipList = scholarshipService.selectLessonPayScholarship(scholarshipVO);
				beans.put("totalPay", scholarshipList.size()*100000);
			}
			// 시험 지급
			else if (scholarshipVO.getExcelGn().equals("5")) {
				scholarshipList = scholarshipService.selectExamPayScholarship(scholarshipVO);
				beans.put("totalPay", scholarshipList.size()*150000);
			}
			// 전체 지급
			else if (scholarshipVO.getExcelGn().equals("6")) {
				scholarshipList = scholarshipService.selectTotalPayScholarship(scholarshipVO);
				for(ScholarshipVO schol : scholarshipList) {
					if(schol.getSchlState().equals("1")) {
						schol.setSchlState("완강");
					}else if(schol.getSchlState().equals("2")) {
						schol.setSchlState("시험 완료");
					}
				}
				beans.put("totalPay", scholarshipVO.getTotalPay());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		beans.put("scholarshipList", scholarshipList);
		beans.put("count", scholarshipList.size());

		try {
			ExcelUtil excelUtil = new ExcelUtil();
			// 수강중인 회원 목록
			if (scholarshipVO.getExcelGn().equals("1")) {
				String filesNm = new String("수강 회원 목록".getBytes("UTF-8"), "ISO-8859-1");
				excelUtil.download(request, response, beans, filesNm , "scholarshipCurLessonList.xlsx");
			}
			// 완강 목록
			else if (scholarshipVO.getExcelGn().equals("2")) {
				String filesNm = new String("완강 회원 목록".getBytes("UTF-8"), "ISO-8859-1");
				excelUtil.download(request, response, beans, filesNm, "scholarshipLessonList.xlsx");
			}
			// 시험 완료
			else if (scholarshipVO.getExcelGn().equals("3")) {
				String filesNm = new String("시험 완료 회원 목록".getBytes("UTF-8"), "ISO-8859-1");
				excelUtil.download(request, response, beans, filesNm, "scholarshipExamList.xlsx");
			}
			// 완강 지급
			else if (scholarshipVO.getExcelGn().equals("4")) {
				String filesNm = new String("장학금 완강 회원 목록".getBytes("UTF-8"), "ISO-8859-1");
				excelUtil.download(request, response, beans, filesNm, "scholarshipLessonPayList.xlsx");
			}
			// 시험 지급
			else if (scholarshipVO.getExcelGn().equals("5")) {
				String filesNm = new String("장학금 시험완료 회원 목록".getBytes("UTF-8"), "ISO-8859-1");
				excelUtil.download(request, response, beans, filesNm, "scholarshipExamPayList.xlsx");
			}
			// 통합 지급
			else if (scholarshipVO.getExcelGn().equals("6")) {
				String filesNm = new String("장학금 통합 회원 목록".getBytes("UTF-8"), "ISO-8859-1");
				excelUtil.download(request, response, beans, filesNm, "scholarshipTotalPayList.xlsx");
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 장학금을 지급하는 메서드
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/insertScholarship")
	public String insertScholarship(ScholarshipVO scholarshipVO) {
		try {
			// 완강한 회원 장학금 지급 -> 10만원
			if (scholarshipVO.getSchlState().equals("1")) {
				for (String userId : scholarshipVO.getUserIdList()) {
					PointVO pointVO = new PointVO();
					pointVO.setUserId(userId);
					pointVO.setPointUpdate(100000);
					scholarshipService.insertPoint(pointVO);

					scholarshipVO.setSchlPay(100000);
					scholarshipVO.setSchlState("1");
					scholarshipVO.setUserId(userId);
					scholarshipService.insertScholarship(scholarshipVO);
				}
			}
			// 완강하고 시험평균도 일정 이상이 회원 지급 -> 15만원
			else if (scholarshipVO.getSchlState().equals("2")) {
				for (String userId : scholarshipVO.getUserIdList()) {
					PointVO pointVO = new PointVO();
					pointVO.setUserId(userId);
					pointVO.setPointUpdate(150000);
					scholarshipService.insertPoint(pointVO);

					scholarshipVO.setSchlPay(150000);
					scholarshipVO.setSchlState("2");
					scholarshipVO.setUserId(userId);
					scholarshipService.insertScholarship(scholarshipVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/scholarship/selectAllScholarship";
	}

	
	/**
	 * 장학금 지급 완강한 회원 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectLessonPayScholarship")
	public String selectLessonPayScholarship(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		try {
			scholarshipList = scholarshipService.selectLessonPayScholarship(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scholarshipList", scholarshipList);

		return "adminPage/admin/scholarship/lessonScholarshipSelect";
	}

	
	/**
	 * 장학금 지급 시험 완료 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectExamPayScholarship")
	public String selectExamPayScholarship(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		try {
			scholarshipList = scholarshipService.selectExamPayScholarship(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scholarshipList", scholarshipList);

		return "adminPage/admin/scholarship/lessonScholarshipSelect";
	}

	
	/**
	 * 장학금 지급 전체 회원들을 상세조회
	 * 
	 * @author 김미연
	 * @param scholarshipVO
	 * @return
	 */
	@RequestMapping(path = "scholarship/selectTotalPayScholarship")
	public String selectTotalPayScholarship(ScholarshipVO scholarshipVO, Model model) {
		List<ScholarshipVO> scholarshipList = new ArrayList<ScholarshipVO>();
		try {
			scholarshipList = scholarshipService.selectTotalPayScholarship(scholarshipVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("scholarshipList", scholarshipList);

		return "adminPage/admin/scholarship/lessonScholarshipSelect";
	}
}
