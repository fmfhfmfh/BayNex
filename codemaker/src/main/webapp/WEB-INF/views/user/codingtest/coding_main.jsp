<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<link rel="stylesheet" href="/css/user/coding/coding-main.css"/>
<div class="cmenu-container">
	<div class="cmenu-box shadow">
		<c:url value="/user/coding/practice" var="cdpractice"/>
		<div class="cont-box">
			<a href="${cdpractice}"><img alt="" src="/img/coding/character 7.svg">코딩연습하기</a>
		</div>
	</div>
	<div class="cmenu-box shadow">
		<c:url value="/user/coding/solution" var="cdsolution"></c:url>
		<div class="cont-box">
			<a href="${cdsolution}"><img alt="" src="/img/coding/character 20.svg">문제풀기</a>
		</div>
	</div>
</div>