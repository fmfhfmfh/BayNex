<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/css/user/coding/coding-solution.css" rel="stylesheet"/>
<div id="sol-box">
	<div class="main-box">
		<!-- 사진 -->
		<div id="demo" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>
			<!-- The slideshow -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="/img/coding/covidLesson.jpg" alt="Los Angeles" width="1139" height="218">
				</div>
				<div class="carousel-item">
					<img src="/img/coding/python.jpg" alt="Chicago" width="1139" height="218">
				</div>
				<div class="carousel-item">
					<img src="/img/coding/data.jpg" alt="New York" width="1139" height="218">
				</div>
			</div>
	
			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
				class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
		<!-- 문제영역 -->
		<div class="cd-sol-container">
			<!-- 문제 -->
			<div class="box">
				<!-- 문제명 -->
				<c:url value="/user/coding/test/1" var="cdtest1"></c:url>
				<div>
					<a href="${cdtest1}">문자열을 정수로 바꾸기
						<div class="info-sub"><span>Java</span></div>
					</a>
				</div>
			</div>
			<!-- 문제 -->
			<div class="box">
				<!-- 문제명 -->
				<c:url value="/user/coding/test/2" var="cdtest2"></c:url>
				<div>
					<a href="${cdtest2}">짝수와 홀수
						<div class="info-sub"><span>Java</span></div>
					</a>	
				</div>
			</div>
			<!-- 문제 -->
			<div class="box">
				<!-- 문제명 -->
				<c:url value="/user/coding/test/3" var="cdtest3"></c:url>
				<div>
					<a href="${cdtest3}">두 정수 사이의 합
						<div class="info-sub"><span>Java</span></div>
					</a>	
				</div>
			</div>
			<!-- 문제 -->
			<div class="box">
				<!-- 문제명 -->
				<c:url value="/user/coding/test/4" var="cdtest4"></c:url>
				<div>
					<a href="${cdtest4}">가운데 글자 가져오기
						<div class="info-sub"><span>Java</span></div>
					</a>	
				</div>
			</div>
			<!-- 문제 -->
			<div class="box">
				<!-- 문제명 -->
				<c:url value="/user/coding/test/5" var="cdtest5"></c:url>
				<div>
					<a href="${cdtest5}">직사각형 별찍기
						<div class="info-sub"><span>Java</span></div>
					</a>
				</div>
			</div>
			<!-- 문제 -->
			<div class="box">
				<!-- 문제명 -->
				<c:url value="/user/coding/test/6" var="cdtest6"></c:url>
				<div>
					<a href="#">문제가 뭘까요
						<div class="info-sub"><span>Java</span></div>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$(".carousel").carousel({ interval:10000 });
</script>