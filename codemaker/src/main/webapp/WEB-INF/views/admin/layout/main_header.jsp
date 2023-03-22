<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	@font-face {
		font-family: 'LotteMartDream';
		font-style: normal;
		font-weight: 300;
		src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
	}
	header{
		font-family: 'LotteMartDream';
	}
	.dropdown-list{
		width: 400px !important;
	}
	
	.a-fw{
		color: white;
		font-weight: 500;
		font-size: 16px;
	}
	a:hover {
    color: #fff;
    text-decoration: underline;
	}
	

	
</style>
<header class="main-header " id="header">
	<nav class="navbar navbar-static-top navbar-expand-lg" style="width: 1670px; background: #212a39; height: 80px;" >
		<div class="search-form d-none d-lg-inline-block">
			<div id="search-results-container" style="background-color: #212a39;">
				<ul id="search-results"></ul>
			</div>
		</div>

		<div class="navbar-right" style="margin-right: 60px;" >
			<ul class="nav navbar-nav">
				<!-- Github Link Button -->
				<li class="dropdown notifications-menu" style="margin-right: 20px;" >
					<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
<!-- 						<i class="fas fa-bell fa-fw"></i>  -->
						<span class="badge badge-danger badge-counter">${notifyCnt}</span>
					</a>
					<div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
					<h6 class="dropdown-header"></h6>
						<c:choose>
							<c:when test="${notifyCnt == 0}">
								<div style="text-align:center;">
									<span class="font-weight-bold">새로운 알림이 없습니다</span>
								</div>
								<h6 class="dropdown-header"></h6>
							</c:when>
							<c:otherwise>
								<c:forEach items="${notifyList}" var="notify">
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
								</c:forEach> 
							</c:otherwise>
						</c:choose>
					</div>
				</li>
				<!-- User Account -->
				<li class="dropdown-footer">
					<c:choose>
						<c:when test="${S_ADMIN != null}">
							<a href="${cp }/logout" style="color: #b7c0cd;"> 
								<i class="mdi mdi-logout" style="color: #005F86;"></i>로그아웃 
							</a>
						</c:when>
						<c:otherwise>
							<a href="${cp }/loginView" style="color: #b7c0cd;"> 
								<i class="mdi mdi-logout" style="color: #005F86;"></i>로그인 
							</a>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
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
	
	
</header>