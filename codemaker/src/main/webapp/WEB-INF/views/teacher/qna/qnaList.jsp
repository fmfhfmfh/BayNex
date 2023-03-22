<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<!-- <link rel="stylesheet" href="/css/teacher/lesson/lesson.css"> -->

<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

<title>Insert title here</title>
<style>
	.card{
	width:1500px;
	height:900px;
	margin:auto;
	border: none;
}
h2{
	color : #1d25af;
	font-size: 2.0em;
}
#ff{
	margin: 50px 130px 0;
	background-color: white;
}
.pagination .page-item:first-child .page-link, .pagination .page-item:last-child .page-link
{
 height: 37px; 
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
div, li{
 font-family: 'LotteMartDream';
  font-weight: 500;
}
.table th{
font-family: 'LotteMartDream';
  font-weight: 700;
  font-size: 1.5em;
  text-align: center;
}
.table td{
font-family: 'LotteMartDream';
  font-weight: 500;
  font-size: 1.2em;
  text-align: center;
  line-height: 30px;
}
.table tr{
	border-top: 2px solid #bdbdbd;
    border-bottom: 2px solid #bdbdbd;
}
.card .table {
   margin-bottom: 70px;
}
</style>

<div id="containerId">
	<div class="row shadow" style="background-color: white;">
		<div class="col-12">
		<div class="card">
			<div>
				<h2>CodeMaker QNA</h2>
			</div>
			<hr>
		
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th>QNA 번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>강의 아이디</th>
					<th>작성회원</th>
				</tr>
				<tbody id="noticeList">
					<c:choose>
						<c:when test="${page != null}">
							<c:set var="num" value="${totalCnt - ((page-1)*10) }"/>
						</c:when>
						<c:otherwise>
							<c:set var="num" value="${totalCnt}"/>
						</c:otherwise>
					</c:choose>
					<c:forEach items="${qnaList}" var="qna">
						<c:if test="${qna.qnaOut == 'N'}">
							<tr>
								<td>${qna.qnaId}</td>
								<c:url value="/teacher/selectQna" var="selectQna">
									<c:param name="qnaId" value="${qna.qnaId}"/>
								</c:url>
								<td style="text-align: left;"><a href="${selectQna}">${qna.qnaTitle}</a></td>
								<td><fmt:formatDate value="${qna.qnaDate}" pattern="yyyy-MM-dd" /></td>
								<td>${qna.lesId}</td>
								<td>${qna.userId}</td>
							</tr>
						</c:if>
						<c:set var="num" value="${num-1}"/>
					</c:forEach>
				</tbody>
			</table>
		
	
		<div class="text-center">
			<ul class="pagination justify-content-center m-0">
				<c:choose>
					<c:when test="${page != 1 and page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) - 1 ) * 5 + 1}"/>
						<c:if test="${page > 5}">
							<li class="page-item"><a class="page-link"
								href="/teacher/selectAllQna?page=${pg}">이전</a></li>
						</c:if>
					</c:when>
				</c:choose>
		
				<c:forEach var="i" begin="1" end="${pages}">
					<c:choose>
						<c:when test="${i == page}">	
							<li class="page-item active"><a class="page-link">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="/teacher/selectAllQna?page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
				
				<c:choose>
					<c:when test="${page != pages && page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) + 1 ) * 5 + 1 }"/>
						<c:if test="${pages >= pg}">
						  <li class="page-item"><a class="page-link" href="/teacher/selectAllQna?page=${pg}">다음</a></li>
						</c:if>
					</c:when>
				</c:choose> 	
			</ul>
			</div>
			</div>
		</div>		
	</div>
</div>
</div>