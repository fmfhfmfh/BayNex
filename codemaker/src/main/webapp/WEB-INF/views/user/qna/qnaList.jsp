<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/user/qna/qnaList.css">

<title>Insert title here</title>
<script>
$(document).ready(function(){
	
	$("#insertqna").on("click", function(){
		document.location="/user/insertQna?lesId=${param.lesId}";
	});
	
})
</script>

<style>

</style>
<div class="ff shadow">
	<div>
		<div class="card">
			<div class="banner">
				<h2>질문게시판</h2>
			</div>
			<br>
		<div class="table-responsive table-margin">
			<div class="qanList-size-div">
			총 게시글 수 <span class="qnd-num">${qnaList.size()}</span>개
			</div>
			<table class="table">
				<tr class="tr-1st">
					<th class="thd-1st">번호</th>
					<th class="thd-2nd">제목</th>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
				<tbody id="noticeList">
					<c:forEach items="${qnaList}" var="qna" varStatus="status">
						<c:if test="${qna.qnaOut == 'N'}">
							<tr class="tr-2nd">
								<td class="thd-1st">${status.count}</td>
								<c:url value="/user/selectQna" var="selectQna">
									<c:param name="qnaId" value="${qna.qnaId}"/>
								</c:url>
								<td class="thd-2nd" style="text-align: left;">
									<a href="${selectQna}">${qna.qnaTitle}</a>
								</td>
								<td><fmt:formatDate value="${qna.qnaDate}" pattern="yyyy-MM-dd" /></td>
								<td>${qna.userId}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<button type="button" id="insertqna" class="btn btn-color">QNA작성</button>
		</div>
	
		<div class="text-center">
			<ul class="pagination justify-content-center m-0">
				<c:choose>
					<c:when test="${param.page != null and param.page != 1 and param.page != ''}">
						<li class="page-item">
							<c:url value="/user/selectAllQna" var="page1">
								<c:param name="lesId" value="${param.lesId}"/>
								<c:param name="page" value="1"/>
							</c:url>
							<a class="page-link" href="${page1}"></a>
						</li>
						<li class="page-item">
							<c:url value="/user/selectAllQna" var="pageminus">
								<c:param name="lesId" value="${param.lesId}"/>
								<c:param name="page" value="${param.page-1}"/>
							</c:url>
							<a class="page-link" href="${pageminus}"></a>
						</li>
					</c:when>
				</c:choose>
		
				<c:forEach var="i" begin="1" end="${pages}">
					<c:choose>
						<c:when test="${i == param.page or param.page == ''}">
							<li class="page-item active"><a class="page-link" href="${cp}/user/selectAllQna?lesId=${param.lesId}&page=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="${cp}/user/selectAllQna?lesId=${param.lesId}&page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
				
				<c:choose>
					<c:when test="${param.page != pages and param.page != 1 and param.page != null}">
						  <li class="page-item"><a class="page-link" href="${cp}/user/selectAllQna?lesId=${param.lesId}&page=${param.page+1}">></a></li>
						  <li class="page-item"><a class="page-link" href="${cp}/user/selectAllQna?lesId=${param.lesId}&page=${pages}">>></i></a></li>
					</c:when>
				</c:choose> 	
			</ul>
			</div>
		</div>		
	</div>
</div>
