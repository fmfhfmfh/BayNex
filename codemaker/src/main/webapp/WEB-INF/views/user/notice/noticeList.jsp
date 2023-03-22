<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <link rel="stylesheet" href="/css/teacher/lesson/lesson.css"> -->
<!-- <link rel="stylesheet" href="/css/user/mypage/mypage-style3.css"> -->
<!-- <link rel="stylesheet" href="/css/user/mypage/mypage-style.css"> -->
<!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet"> -->
<link href="/css/user/board/notice-list.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="notice-box card shadow">
	<div class="notice-item1">
		<div class="notice-header">
			<div class="notice-header-left">
				<c:if test="${param.searchOption == '1' || param.searchOption == '' || param.searchOption == null}">
					<button id="notice1" type="button" class="btn btn-info btn-lg active fw-600">공지사항</button>
					<button id="notice2" type="button" class="btn btn-info btn-lg fw-600">자주묻는질문</button>
				</c:if>
				<c:if test="${param.searchOption == '2'}">
					<button id="notice1" type="button" class="btn btn-info btn-lg fw-600">공지사항</button>
					<button id="notice2" type="button" class="btn btn-info btn-lg active fw-600">자주묻는질문</button>
				</c:if>
			</div>
			<div class="notice-header-right">
		        <select name="searchOption" class="fw-600">
		            <c:if test="${searchOption == '1' || searchOption == '' || searchOption == null}">
			            <option value="1" selected>공지사항</option>
			            <option value="2">자주묻는질문</option>
		            </c:if>
		            <c:if test="${searchOption == '2'}">
			            <option value="1">공지사항</option>
			            <option value="2" selected>자주묻는질문</option>
		            </c:if>
		        </select>
		        <input id="keywords" type="text" name="keyWord" value="${param.keyWord}">
		        <button id="searchBtn" type="button" class="fw-600">조회</button>
			</div>
		</div>
		<div>
			<div>
				<table class="table" >
					<tr style="text-align:center;">
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>작성자</th>
					</tr>
					<tbody id="noticeList">
						<c:set var="num" value="${totalCnt - ((param.page-1)*10) }"/>
							<c:forEach items="${noticeList}" var="notice" >
								<c:if test="${notice.noticeOut == 'N'}">
									<tr>
										<td>${num}</td>
										<td style="text-align:left;"><a style="color : black; font-size : 20px;" href="${cp}/user/selectNotice?noticeId=${notice.noticeId}">${notice.noticeTitle}</a></td>
										<td><fmt:formatDate value="${notice.noticeDate}" pattern="yyyy-MM-dd" /></td>
										<td>${notice.adminId}</td>
									</tr>
								</c:if>
								<c:set var="num" value="${num-1}"/>
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="notice-item2">
		<div class="text-center" >
			<ul class="pagination justify-content-center m-0">
				<c:choose>
					<c:when test="${param.page != 0 and param.page != 1 and param.page != null}">
					<fmt:parseNumber var="pg" value="${((page / 5 ) - 1 ) * 5 + 1}"/>
						<c:if test="${page > 5}">
						  <li class="page-item"><a class="page-link" href="${cp}/user/selectAllNotice?searchOption=${param.searchOption}&keyWord=${param.keyWord}&page=${pg}">이전</a></li>
						</c:if>
					</c:when>
				</c:choose>
				
				<c:forEach var="i" begin="1" end="${pages}">
					<c:choose>
						<c:when test="${i == param.page}">
							<li class="page-item active"><a class="page-link">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="${cp}/user/selectAllNotice?searchOption=${param.searchOption}&keyWord=${param.keyWord}&page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
				
				<c:choose>
					<c:when test="${param.page != pages && param.page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) + 1 ) * 5 + 1 }"/>
						<c:if test="${pages >= pg}">
						  <li class="page-item"><a class="page-link" href="${cp}/user/selectAllNotice?searchOption=${param.searchOption}&keyWord=${param.keyWord}&page=${pg}">다음</a></li>
						</c:if>
					</c:when>
				</c:choose> 	
			</ul>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	$("#keywords").keydown(function(key) {
		if (key.keyCode == 13) {
			var searchOption = $("select[name='searchOption']").val();
			var keyWord = $("input[name='keyWord']").val();
		
			document.location="/user/selectAllNotice?searchOption="+searchOption+"&keyWord="+keyWord+"&page=1";
		}
	});
	$("#searchBtn").on("click", function(){
		var searchOption = $("select[name='searchOption']").val();
		var keyWord = $("input[name='keyWord']").val();
		document.location="/user/selectAllNotice?searchOption="+searchOption+"&keyWord="+keyWord+"&page=1";
	});
	$("#notice1").on("click", function(){
		var searchOption = $("select[name='searchOption']").val();
		var keyWord = $("input[name='keyWord']").val();
		document.location="/user/selectAllNotice?searchOption=1&keyWord="+keyWord+"&page=1";
	});
	$("#notice2").on("click", function(){
		var searchOption = $("select[name='searchOption']").val();
		var keyWord = $("input[name='keyWord']").val();
		document.location="/user/selectAllNotice?searchOption=2&keyWord="+keyWord+"&page=1";
	});
})
</script>