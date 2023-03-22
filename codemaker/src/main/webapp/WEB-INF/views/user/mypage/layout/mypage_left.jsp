<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" style="background: #005F86">
	<br><br><br>
	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
		<div class="sidebar-brand-icon">
			<c:url value="/mypage/profileImg" var="userProfile"></c:url>
			<img id="usericon" src="${userProfile}"> <br>
			<br>${MEMBER_INFO.userNm}님 <br>
		</div>
	</a>
	<br><br><br>
	<!-- Divider -->
	<hr class="sidebar-divider my-0">
	<!-- Divider -->
	<hr class="sidebar-divider">
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> 
			<i class="fas fa-fw fa-folder"></i> <span>마이페이지</span>
		</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="/mypage/myinfoSelect">◾ 내정보조회</a> 
				<a class="collapse-item" href="/mypage/deleteUserView">◾ 회원탈퇴</a> 
				<a class="collapse-item" href="/mypage/selectPoint">◾ 포인트</a> 
				<a class="collapse-item" href="/user/selectAllNotification">◾ 알림</a>
			</div>
		</div>
	</li>
	<!-- Nav Item - Tables -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo2" aria-expanded="true" aria-controls="collapseTwo">
			<i class="fas fa-fw fa-folder"></i><span>내 강의실</span>
		</a>
		<div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
			<c:url value="/user/myLesson" var="myLesson"/>
				<a class="collapse-item" href="${myLesson}">◾ 수강 목록</a> 
				<a class="collapse-item" href="/note/selectPageNote">◾ 필기 노트</a> 
			</div>
		</div>
	</li>
	<!-- Nav Item - Tables -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo3" aria-expanded="true" aria-controls="collapseTwo">
			<i class="fas fa-fw fa-folder"></i><span>장바구니</span>
		</a>
		<div id="collapseTwo3" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<c:url value="/user/cartView" var="cartView"/>
				<a class="collapse-item" href="${cartView}">◾ 장바구니</a> 
				<a class="collapse-item" href="/mypage/selectAllMyPay">◾ 결제내역</a> 
			</div>
		</div>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">
	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>