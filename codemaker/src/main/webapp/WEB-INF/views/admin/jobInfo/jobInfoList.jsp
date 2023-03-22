<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 취업공고</title>

<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">


<script>
$(document).ready(function(){
	
	$("#keywords").keypress(function(key) {
		if (key.keyCode == 13) {
			var keyWord = $("input[name='keyWord']").val();
				
			document.location="/admin/selectAllJobInfo?&keyWord="+keyWord+"&page=1";
			return false;
		}
	});
		
	$("#btnWrite").on("click", function(){
		document.location="${cp}/admin/insertJobInfo";
	});
	
	$("#searchBtn").on("click", function(){
		
		var keyWord = $("input[name='keyWord']").val();
	
		document.location="/admin/selectAllJobInfo?keyWord="+keyWord+"&page=1";
		
	});
})
</script>
<style>
.card{
	width:1500px;
	height:700px;
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
  line-height: 40px;
}
.table tr{
	border-top: 2px solid #bdbdbd;
    border-bottom: 2px solid #bdbdbd;
}
.card .table {
   margin-bottom: 70px;
}
#contImg{
	width: 50px;
    height: 45px;
    margin-top: -7px;
}
#contImgN{
	width: 40px;
    height: 40px;
}
#contImgY{
	width: 35px;
    height: 35px;
}
#banner{
	margin: 20px;
}
.checkImg{
	width: 40px;
}
</style>

<div id="containerId">
	<div class="row shadow" style="background-color: white;">
		<div class="col-12">
		<div class="card">
		<div id="banner">
			<h2>CodeMaker 취업 공고 현황</h2>
			<br>
		</div>
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th>취업공고 번호</th>
					<th>취업공고 아이디</th>
					<th>취업공고 제목</th>
					<th>취업공고 작성일</th>
					<th>작성자아이디</th>
					<th>삭제여부</th>
				</tr>
				<tbody id="jobInfoList">
				<c:choose>
					<c:when test="${page != null}">
						<c:set var="num" value="${totalCnt - ((page-1)*10) }"/>
					</c:when>
					<c:otherwise>
						<c:set var="num" value="${totalCnt}"/>
					</c:otherwise>
				</c:choose>
					<c:forEach items="${jobInfoList}" var="jobInfo">
						<tr>	
							<td>${num}</td>
							<td>${jobInfo.jobinfoId}</td>
							<td><a href="/admin/selectJobInfo?jobinfoId=${jobInfo.jobinfoId}">${jobInfo.jobinfoTitle}</a></td>
							<td><fmt:formatDate value="${jobInfo.jobinfoDate}" pattern="yyyy-MM-dd" /></td>
							<td>${jobInfo.adminId}</td>
							<c:choose>
								<c:when test="${jobInfo.jobinfoOut == 'N'}">
									<td></td>
								</c:when>
								<c:when test="${jobInfo.jobinfoOut == 'Y'}">
									<td><img class="checkImg" src="/images/admin/company/check.png"></td>
								</c:when>
							</c:choose>
						</tr>
						<c:set var="num" value="${num-1}"/>
					</c:forEach>
				</tbody>
			</table>
			
		</div>	
		</div>
		 <div class="text-center">
            <ul class="pagination justify-content-center m-0">
				<c:choose>
					<c:when test="${page != 1 and page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) - 1 ) * 5 + 1}"/>
						<c:if test="${page > 5}">
							<li class="page-item"><a class="page-link"
								href="/admin/selectAllJobInfo?keyWord=${keyWord}&page=${pg}">이전</a></li>
						</c:if>
					</c:when>
				</c:choose>
		
				<c:forEach var="i" begin="1" end="${pages}">
					<c:choose>
						<c:when test="${i == page}">
							<li class="page-item active"><a class="page-link">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="/admin/selectAllJobInfo?keyWord=${keyWord}&page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
				
				<c:choose>
					<c:when test="${page != pages && page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) + 1 ) * 5 + 1 }"/>
						<c:if test="${pages >= pg}">
						  <li class="page-item"><a class="page-link" href="/admin/selectAllJobInfo?keyWord=${keyWord}&page=${pg}">다음</a></li>
						</c:if>
					</c:when>
				</c:choose> 	
			</ul>
            <button type="button" id="btnWrite" class="btn btn-info btn-sm" style="float:right; width:100px; height:30px;">공고등록</button>
            <div>
            <hr>
				<form name="form1"  method="post">
			       <span>검색&nbsp;</span><input type="text" id="keywords" name="keyWord" value="${param.keyWord}" style="border : 1px solid black;">
			       <input id="searchBtn" type="button" class="btn btn-warning btn-sm" value="조회">
			    </form>
			</div>
			</div>		
		</div>
	</div>
</div>