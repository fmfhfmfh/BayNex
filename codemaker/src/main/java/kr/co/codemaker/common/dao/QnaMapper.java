package kr.co.codemaker.common.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.common.vo.QnaVO;

/**
* QnaMapper.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 1.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Mapper("qnaMapper")
public interface QnaMapper {
	
	/**
	 * 모든 qna를 조회하는 메서드
	 * @author 박경호
	 * @param map qna를 조회하기위한 조건
	 * @return 조건에 맞는 모든 qna
	 * @throws Exception
	 */
	public List<QnaVO> selectAllQna(Map<String, Object> map) throws Exception;
	
	/**
	 * 모든 qna를 조회하는 메서드
	 * @author 박경호
	 * @param map qna를 조회하기위한 조건
	 * @return 조건에 맞는 모든 qna
	 * @throws Exception
	 */
	public List<QnaVO> selectAllQnaT(Map<String, Object> map) throws Exception;
	
	/**
	 * qna의 총 갯수를 조회하는 메서드
	 * @author 박경호
	 * @return qna의 총 갯수
	 * @throws Exception
	 */
	public int qnaTotalCnt() throws Exception;
	
	/**
	 * qna의 총 갯수를 조회하는 메서드
	 * @author 박경호
	 * @return qna의 총 갯수
	 * @throws Exception
	 */
	public int qnaTotalCntT(String tchId) throws Exception;
	
	/**
	 * 하나의 qna를 조회하는 메서드
	 * @author 박경호
	 * @param qnaId 조회하려는 qnaId
	 * @return qna의 상세정보
	 * @throws Exception
	 */
	public QnaVO selectQna(String qnaId) throws Exception;
	
	/**
	 * qna를 등록하는 메서드
	 * @author 박경호
	 * @param qnaVo 등록하려는 qna객체
	 * @return 등록된 qna 갯수
	 * @throws Exception
	 */
	public int insertQna(QnaVO qnaVo) throws Exception;
	
	/**
	 * qna를 삭제하기 위한 메서드
	 * @author 박경호
	 * @param qnaId 삭제하려는 qnaId
	 * @return 삭제된 qna 갯수
	 * @throws Exception
	 */
	public int deleteQna(String qnaId) throws Exception;
	
	/**
	 * qna게시판에 해당하는 담당선생님을 조회하는 메서드
	 * @author 박경호
	 * @param qnaId qna아이디
	 * @return 선생님 아이디
	 * @throws Exception
	 */
	public String selectQnaTeacher(String qnaId) throws Exception;
	
}
