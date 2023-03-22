<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 기업정보</title>

<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">


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
	width: 45px;
    margin-top: -7px;
    cursor: pointer;
}
#banner{
	margin: 20px 0px 20px 0;
}
</style>

<script>

$(function(){
	$('a[id^="contract_"]').on('click',function(){
		var comId = $(this).attr('value');
		window.open("/admin/company/companyContract?comId="+comId, "video_popup","width=1000,height=900, left=400, top=30");
	})
	
	$('a[id^="down_"]').on('click',function(){
		var filesId = $(this).attr('value');
		document.location="/admin/company/companyPdfDown?filesId="+filesId;
	})
	
	
})
</script>

<div id="containerId">
	<div class="row shadow" style="background-color: white;">
		<div class="col-12">
			<div class="card">
		<div id="banner">
			<h2>기업 정보</h2>
			<br>
		</div>
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th>기업 아이디</th>
					<th>기업명</th>
					<th>주소</th>
					<th>대표자</th>
					<th>전화번호</th>
					<th></th>
				</tr>
				<tbody id="companyList">
					<c:forEach items="${companyList}" var="company" varStatus="status">
						<tr>
							<td>${company.comId}</td>
							<td>${company.comNm}</td>
							<td style="text-align: left;">${company.comAdd}</td>
							<td>${company.comOwner}</td>
							<td>${company.comTel}</td>
							<c:choose>
								<c:when test="${company.comState =='Y'}">
									<td><a id="down_${status.index}" value="${company.filesId}"><img id="contImg" src="/images/admin/company/down.png"></a></td>
								</c:when>
								<c:when test="${company.comState =='N'}">
									<td><a id="contract_${status.index}" value="${company.comId}"><img id="contImg" src="/images/admin/company/pdfCreate.png"></a></td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		
		   <div class="text-center">
            <ul class="pagination justify-content-center m-0">
              <c:if test="${page != 1}">
              	<li class="page-item active"><a class="page-link pageMove pageMV" href="${cp}/admin/company/selectAllCompany?page=${1}">&laquo;</a></li>
              	<li class="page-item active"><a class="page-link pageMove pageMV" href="${cp}/admin/company/selectAllCompany?page=${page-1}">&lt;</a></li>
              </c:if>
               
               <c:forEach var="i" begin="1" end="${pages}">
                  <c:choose>
                     <c:when test="${i == page}">
                        <li class="page-item active"><a class="page-link pageMove pageMV">${i}</a></li>
                     </c:when>
                     <c:otherwise>
                        <li class="page-item"><a class="page-link pageMove pageMV" href="${cp}/admin/company/selectAllCompany?page=${i}">${i}</a></li>
                     </c:otherwise>
                  </c:choose>   
               </c:forEach>
               
               <c:if test="${page != pages}">
              	<li class="page-item active"><a class="page-link pageMove pageMV" href="${cp}/admin/company/selectAllCompany?page=${page +1}">&gt;</a></li>
              	<li class="page-item active"><a class="page-link pageMove pageMV" href="${cp}/admin/company/selectAllCompany?page=${pages}">&raquo;</a></li>
              </c:if>
            </ul>
            <div>
            </div>
         </div>      
      </div>
   </div>
</div>
</div>