<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link href="/css/teacher/resume/resume-view.css" rel="stylesheet"/>
<div class="resume-view-box">
	<div>
		<!-- 이름, 휴대폰 번호 입력 -->
		<div>
			<h3>이력서 조회</h3>
			<form action="<c:url value="/resume/search"/>" method="post"> 
				<div class="input-info">
					<input type="text" name="resNm" placeholder="이름"/><br>
					<input type="text" name="resTel" placeholder="전화번호"/>
				</div>
				<button type="submit" class="search-btn">조회</button>
			</form>
		</div>
	</div>
</div>