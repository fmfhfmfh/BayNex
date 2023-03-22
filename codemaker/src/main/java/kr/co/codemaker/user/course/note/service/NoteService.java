package kr.co.codemaker.user.course.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.user.course.note.dao.NoteMapper;
import kr.co.codemaker.user.course.note.vo.NoteVO;

/**
 * 
* NoteService.java
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
@Service("noteService")
public class NoteService {

	@Resource(name = "noteMapper")
	private NoteMapper noteMapper;

	/**
	 * 회원의 노트 목록을 페이징 처리하여 가져오는 메서드
	 * 
	 * @author 김미연
	 * @param noteVO
	 * @return
	 * @throws Exception 
	 */
	public List<NoteVO> selectPageNote(NoteVO noteVO) throws Exception {
		return noteMapper.selectPageNote(noteVO);
	}

	/**
	 * 회원의 노트 목록의 총 개수를 가져오는 메소드
	 * 
	 * @author 김미연
	 * @param noteVO
	 * @return
	 * @throws Exception 
	 */
	public int selecTotalCntNote(NoteVO noteVO) throws Exception {
		return noteMapper.selecTotalCntNote(noteVO);
	}

	/**
	 * 회원 노트 1개의 정보를 가져오는 메소드
	 * 
	 * @author 김미연
	 * @param noteId
	 * @return
	 * @throws Exception 
	 */
	public NoteVO selectNote(String noteId) throws Exception {
		return noteMapper.selectNote(noteId);
	}

	/**
	 * 노트를 등록하는 메소드
	 * 
	 * @author 김미연
	 * @param noteVo
	 * @return
	 * @throws Exception 
	 */
	public int insertNote(NoteVO noteVo) throws Exception {
		return noteMapper.insertNote(noteVo);
	}

	/**
	 * 노트를 수정하는 메소드
	 * 
	 * @author 김미연
	 * @param noteVo
	 * @return
	 * @throws Exception 
	 */
	public int updateNote(NoteVO noteVo) throws Exception {
		return noteMapper.updateNote(noteVo);
	}

	/**
	 * 노트를 삭제하는 메소드
	 * 
	 * @author 김미연
	 * @param noteVo
	 * @return
	 * @throws Exception 
	 */
	public int deleteNote(NoteVO noteVo) throws Exception {
		return noteMapper.deleteNote(noteVo);
	}

}
