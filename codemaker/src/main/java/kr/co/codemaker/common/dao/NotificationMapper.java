package kr.co.codemaker.common.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.codemaker.common.vo.NotificationVO;

/**
* NotificationMapper.java
*
* @author 박경호
* @version 1.0
* @since 2020. 12. 21.
*
* 수정자 수정내용
* ------ ------------------------
* 박경호 최초 생성
*
 */
@Mapper("notificationMapper")
public interface NotificationMapper {
	
	/**
	 * 자신에게 온 모든 알림을 조회하는 메서드
	 * @author 박경호
	 * @param notificationVo
	 * @return 모든 알림
	 */
	public List<NotificationVO> selectAllNotification(NotificationVO notificationVo) throws Exception;
	
	/**
	 * 알림을 보내는 메서드
	 * @author 박경호
	 * @param notificationVo
	 * @return 보낸 알림의 갯수
	 */
	public int insertNotification(NotificationVO notificationVo) throws Exception;
	
	/**
	 * 알림을 확인하는 메서드
	 * @author 박경호
	 * @param notificationVo
	 * @return 읽은 알림의 갯수
	 */
	public int readNotification(NotificationVO notificationVo) throws Exception;
	
	/**
	 * 읽지 않은 알림의 수를 조회하는 메서드
	 * @author 박경호
	 * @param notificationVo
	 * @return 읽지 않은 알림의 갯수
	 * @throws Exception
	 */
	public int selectNotReadCount(NotificationVO notificationVo) throws Exception; 
	
	/**
	 * 자신에게 온 모든 알림을 조회하는 메서드
	 * @author 박경호
	 * @param notificationVo
	 * @return 모든 알림
	 */
	public List<NotificationVO> selectAllNotificationView(NotificationVO notificationVo) throws Exception;
	
	/**
	 * 알림을 삭제하는메서드
	 * @author 박경호
	 * @param notifyId
	 * @return 알림이 삭제된 갯수
	 * @throws Exception
	 */
	public int deleteNotification(String notifyId) throws Exception;

}
