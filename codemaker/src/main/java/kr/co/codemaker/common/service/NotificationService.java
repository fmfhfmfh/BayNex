package kr.co.codemaker.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.codemaker.common.dao.NotificationMapper;
import kr.co.codemaker.common.vo.NotificationVO;

/**
* NotificationService.java
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
@Service("notificationService")
public class NotificationService {

	@Resource(name="notificationMapper")
	private NotificationMapper notificationMapper;
	
	public List<NotificationVO> selectAllNotification(NotificationVO notificationVo) throws Exception{
		return notificationMapper.selectAllNotification(notificationVo);
	}
	
	public int insertNotification(NotificationVO notificationVo) throws Exception {
		return notificationMapper.insertNotification(notificationVo);
	}
	
	public int readNotification(NotificationVO notificationVo) throws Exception {
		return notificationMapper.readNotification(notificationVo);
	}
	
	public int selectNotReadCount(NotificationVO notificationVo) throws Exception {
		return notificationMapper.selectNotReadCount(notificationVo);
	}
	
	public List<NotificationVO> selectAllNotificationView(NotificationVO notificationVo) throws Exception{
		return notificationMapper.selectAllNotificationView(notificationVo);
	}
	
	public int deleteNotification(String notifyId) throws Exception{
		return notificationMapper.deleteNotification(notifyId);
	}
}
