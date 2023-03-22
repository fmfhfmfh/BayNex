<%@page import="javax.annotation.Resource"%>
<%@page import="kr.co.codemaker.common.service.NotificationService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.codemaker.common.vo.UserVO"%>
<%@page import="kr.co.codemaker.common.vo.NotificationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#imglogo{width: 200px;}
#imgicon{width: 40px; height:40px; }
.imgMain{width: 250px;height: 300px;}
#at{color: #2c2e2e;}
.span-w{
	width: 40px;
    height: 40px;
    margin: 15px 0 0 0;
}
</style>

<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light topbar static-top shadow" style="background: #005F86">
	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>
	
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

	<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
		<div class="input-group">
			<a href="${cp}/user/main">
				<img id="imglogo" src="/images/codemaker_name3.png">
			</a>
		</div>
	</form>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">
		<!-- 로그인시에 떠야할 Nav Item - Alerts -->
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
				<span class="badge badge-danger badge-counter span-w" style="font-size: 22px;">${notifyCnt}</span>
			</a>
			<div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
				<h6 class="dropdown-header"></h6>
				<c:forEach items="${notifyList}" var="notify">
					<c:if test="${MEMBER_INFO.userId != notify.senderId}">
						<c:choose>
							<c:when test="${notifyCnt == 0 || notifyCnt == ''}">
								<span class="font-weight-bold">새로운 알림이 없습니다</span>
							</c:when>
							<c:otherwise>
								<a id="url" class="dropdown-item d-flex align-items-center" href="${notify.url}" notify="${notify.notifyId}">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">${notify.notifyDate}</div>
										<span class="font-weight-bold">${notify.notifyCont}</span>
									</div>
								</a>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach> 
			</div>
		</li>

		<!-- 로그인시에 떠야할 Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow">
			<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
				<span class="mr-2 d-none d-lg-inline text-white-600 middle" style="font-size:1.2em;">${MEMBER_INFO.userNm}님</span> 
				<img id="navicon" class="img-profile rounded-circle" src="/images/user/main/mypage_icon.png">
			</a>
			<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
				<c:url value="/mypage/myinfoSelect" var="myinfoSelect"/>
				<a class="dropdown-item" href="${myinfoSelect}"> 
					<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 마이페이지
				</a> 
				<c:url value="/user/myLesson" var="myLesson"/>
				<a class="dropdown-item" href="${myLesson}"> 
					<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> 내강의실
				</a>
				<c:url value="/user/cartView" var="cartView"/>
				<a class="dropdown-item" href="${cartView}"> 
					<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> 장바구니
				</a>
				<div class="dropdown-divider"></div>
				<c:url value="/user/logout" var="logOut"/>
				<a class="dropdown-item" href="${logOut}"> 
					<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그아웃
				</a>
			</div>
		</li>

		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="space" role="button" aria-haspopup="true" aria-expanded="false">&emsp;&emsp;&emsp;&emsp;&emsp;</a>
		</li>
		
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="space" role="button" aria-haspopup="true" aria-expanded="false">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>
		</li>
		
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="space" role="button" aria-haspopup="true" aria-expanded="false">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>
		</li>

		<!-- <div class="topbar-divider d-none d-sm-block"></div> -->
	</ul>
</nav>
<script>
	$(function(){
		$('a[id^=url]').on("click", function(){
			var notifyId = $(this).attr('notify');
			var notificationVo = {notifyId : notifyId};
			$.ajax({
				url : "/readNotification",
				data : notificationVo,
				dataType : 'json',
				success : function(){

				}
			})
		})
	})
	
	$(function(){
		window.onbeforeunload = function(){
			$.ajax({
				url : "/selectAllNotification",
				dataType : 'json',
				success : function(){
					
				}
			})
		}
	})
</script>



<!-- End of Topbar -->