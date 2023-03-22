<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

<title>관리자 공지사항</title>
<script>
$(document).ready(function(){
	
	$("#keywords").keypress(function(event) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			ins();
			return false;
		}
		event.stopPropagation();
	});
		
	$("#btnWrite").on("click", function(){
		document.location="/admin/insertNotice";
	});
	
	
	$("#searchBtn").on("click", function(){
		ins();
	});
	
	$("#notice1").on("click", function(){
		var searchOption = $("select[name='searchOption']").val();
		var keyWord = $("input[name='keyWord']").val();
		document.location="/admin/selectAllNotice?searchOption=1&keyWord="+keyWord+"&page=1";
	});
	
	$("#notice2").on("click", function(){
		var searchOption = $("select[name='searchOption']").val();
		var keyWord = $("input[name='keyWord']").val();
		document.location="/admin/selectAllNotice?searchOption=2&keyWord="+keyWord+"&page=1";
	});
})


function ins(){
	var searchOption = $("select[name='searchOption']").val();
	var keyWord = $("input[name='keyWord']").val();
	document.location="/admin/selectAllNotice?searchOption="+searchOption+"&keyWord="+keyWord+"&page=1";
}
</script>

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
	width: 30px;
}
.formDiv{
	margin: 30px;
}
.aClass{
	color:#0621b9;
}
</style>

<div id="containerId">
	<div class="row shadow" style="background-color: white;">
		<div class="col-12">
		<div class="card">
	
			<div id="banner">
				<h2>CodeMaker 공지 사항</h2>
				<div style="text-align:center;">
					<c:if test="${param.searchOption == '1' || param.searchOption == '' || param.searchOption == null}">
						<button id="notice1" type="button" class="btn btn-info btn-lg active">공지사항</button>
						<button id="notice2" type="button" class="btn btn-info btn-lg">자주묻는질문</button>
					</c:if>
					<c:if test="${param.searchOption == '2'}">
						<button id="notice1" type="button" class="btn btn-info btn-lg">공지사항</button>
						<button id="notice2" type="button" class="btn btn-info btn-lg active">자주묻는질문</button>
					</c:if>
				</div>
			</div>
			
		<div class="table-responsive">
		<button type="button" id="btnWrite" class="btn btn-info btn-sm" style="float:right; width:100px; height:30px; margin-bottom:5px;">공지 작성</button>
			<table class="table">
				<tr style="text-align:center;">
					<th>공지사항 번호</th>
					<th>공지사항 아이디</th>
					<th>공지사항 제목</th>
					<th>공지사항 작성일</th>
					<th>작성자아이디</th>
					<th>삭제여부</th>
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
					<c:forEach items="${noticeList}" var="notice">
						<tr>
							<td>${num}</td>
							<td>${notice.noticeId}</td>
							<td style="text-align:left;"><a class="aClass" href="${cp}/admin/selectNotice?noticeId=${notice.noticeId}">${notice.noticeTitle}</a></td>
							<td><fmt:formatDate value="${notice.noticeDate}" pattern="yyyy-MM-dd" /></td>
							<td>${notice.adminId}</td>
							<c:choose>
								<c:when test="${notice.noticeOut == 'N'}">
									<td></td>
								</c:when>
								<c:when test="${notice.noticeOut == 'Y'}">
									<td><img class="checkImg" src="/images/admin/company/check.png"></td>
								</c:when>
							</c:choose>
						</tr>
						<c:set var="num" value="${num-1}"/>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
		<div class="text-center">
			<ul class="pagination justify-content-center m-0">
				<c:choose>
					<c:when test="${page != 1 and page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) - 1 ) * 5 + 1}"/>
						<c:if test="${page > 5}">
							<li class="page-item"><a class="page-link"
								href="/admin/selectAllNotice?searchOption=${param.searchOption}&keyWord=${param.keyWord}&page=${pg}">이전</a></li>
						</c:if>
					</c:when>
				</c:choose>
		
				<c:forEach var="i" begin="1" end="${pages}">
					<c:choose>
						<c:when test="${i == page}">
							<li class="page-item active"><a class="page-link">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="/admin/selectAllNotice?searchOption=${param.searchOption}&keyWord=${param.keyWord}&page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
				
				<c:choose>
					<c:when test="${page != pages && page != null}">
						<fmt:parseNumber var="pg" value="${((page / 5 ) + 1 ) * 5 + 1 }"/>
						<c:if test="${pages >= pg}">
						  <li class="page-item"><a class="page-link" href="${cp}/admin/selectAllNotice?searchOption=${param.searchOption}&keyWord=${param.keyWord}&page=${pg}">다음</a></li>
						</c:if>
					</c:when>
				</c:choose> 	
			</ul>
			
			
			<div class="formDiv">
				<form name="form1" method="post">
					<select name="searchOption">
						<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
						<c:if test="${param.searchOption == 1 || param.searchOption == null || param.searchOption == ''}">
							<option value="1" selected>공지사항</option>
							<option value="2">자주묻는질문</option>
						</c:if>
						<c:if test="${param.searchOption == 2}">
							<option value="1">공지사항</option>
							<option value="2" selected>자주묻는질문</option>
						</c:if>
					</select> 
					<input type="text" id="keywords" name="keyWord" value="${param.keyWord}" >
					<button id="searchBtn" type="button" class="btn btn-warning btn-sm">조회</button>
				</form>
			</div>
		</div>
		</div>		
	</div>
	</div>
</div>
