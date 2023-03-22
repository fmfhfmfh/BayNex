<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	
<style>
#imglogo {
	width: 200px;
}

#imgicon {
	width: 40px;
	height: 40px;
}

.imgMain {
	width: 250px;
	height: 300px;
}

#at {
	color: #2c2e2e;
}

</style>

<!-- header -->
<nav class="navbar navbar-expand navbar-light topbar static-top" style="background: #005F86">
	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop"
		class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	<div class="input-group">
		<a href="<c:url value="/user/main"/>"><img id="imglogo" src="/images/codemaker_name3.png"></a>
	</div>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">
		<!-- 로그인 -->
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="<c:url value="/user/login"/>" id="login" role="button" aria-haspopup="true" aria-expanded="false">로그인</a>
		</li>

		<!-- 회원가입 -->
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="<c:url value="/join/insertUserView"/>" id="signin" role="button" aria-haspopup="true" aria-expanded="false">회원가입</a>
		</li>
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="<c:url value="/resume/view"/>" id="resume" role="button" aria-haspopup="true" aria-expanded="false">채용정보</a>
		</li>
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="space" role="button" aria-haspopup="true" aria-expanded="false">&emsp;&emsp;&emsp;&emsp;&emsp;</a>
		</li>
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="space" role="button" aria-haspopup="true" aria-expanded="false">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</li>
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="space" role="button" aria-haspopup="true" aria-expanded="false">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</li>
	</ul>
</nav>
<!-- End of header -->