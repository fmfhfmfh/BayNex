<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="/css/teacher/lesson/lesson.css"> -->
<!-- <link rel="stylesheet" href="/css/user/mypage/mypage-style3.css"> -->
<!-- <link rel="stylesheet" href="/css/user/mypage/mypage-style.css"> -->
<!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet"> -->
<link href="/css/user/board/job-info.css" rel="stylesheet"/>
<div class="card shadow job-info-box">
<!-- 		<div class="table-responsive"> -->
	<div class="job-info-item1">
		<div class="job-info-header">
			<div><h2>CODE MAKER 취업정보</h2></div>
			<div class="search-bar">
	        	<span class="fw-600">검색</span>
	        	<input type="text" id="keywords" name="keyWord" value="${param.keyWord}">
		        <button id="searchBtn" type="button" class="fw-600">조회</button>
			</div>
		</div>
		<div>
			<div>
				<table class="table">
					<tr>
						<th>글 번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>작성자</th>
					</tr>
					<tbody id="jobinfoList">
						<c:set var="num" value="${totalCnt - ((param.page-1)*10) }"/>
						<c:forEach items="${jobinfoList}" var="jobinfo">
							<c:if test="${jobinfo.jobinfoOut == 'N'}">
								<tr>
									<td>${num}</td>
									<td style="text-align:left;"><a style="color : black; font-size : 20px;" href="${cp}/user/selectJobInfo?jobinfoId=${jobinfo.jobinfoId}">${jobinfo.jobinfoTitle}</a></td>
									<td><fmt:formatDate value="${jobinfo.jobinfoDate}" pattern="yyyy-MM-dd" /></td>
									<td>${jobinfo.adminId}</td>
								</tr>
							</c:if>
							<c:set var="num" value="${num-1}"/>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="job-info-item2" >
		<ul class="pagination justify-content-center m-0">
			<c:choose>
				<c:when test="${param.page != 0 and param.page != 1 and param.page != null}">
					<fmt:parseNumber var="pg" value="${((page / 5 ) - 1 ) * 5 + 1}"/>
					<c:if test="${page > 5}">
					  <li class="page-item"><a class="page-link" href="${cp}/user/selectAllJobInfo?keyWord=${param.keyWord}&page=${1}">이전</a></li>
					</c:if>
				</c:when>
			</c:choose>
			
			<c:forEach var="i" begin="1" end="${pages}">
				<c:choose>
					<c:when test="${i == param.page}">
						<li class="page-item active"><a class="page-link">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="${cp}/user/selectAllJobInfo?keyWord=${param.keyWord}&page=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>	
			</c:forEach>
			
			<c:choose>
				<c:when test="${param.page != pages && param.page != null}">
					<fmt:parseNumber var="pg" value="${((page / 5 ) + 1 ) * 5 + 1 }"/>
					<c:if test="${pages >= pg}">
					  <li class="page-item"><a class="page-link" href="${cp}/user/selectAllJobInfo?keyWord=${param.keyWord}&page=${pages}">다음</a></li>
					</c:if>
				</c:when>
			</c:choose> 	
		</ul>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#keywords").keydown(function(key) {
		if (key.keyCode == 13) {
			var searchOption = $("select[name='searchOption']").val();
			var keyWord = $("input[name='keyWord']").val();
			document.location="${cp}/user/selectAllJobInfo?&keyWord="+keyWord+"&page=1";
		}
	});
	
	$("#searchBtn").on("click", function(){
		var keyWord = $("input[name='keyWord']").val();
		document.location="${cp}/user/selectAllJobInfo?keyWord="+keyWord+"&page=1";
	});
})
</script>