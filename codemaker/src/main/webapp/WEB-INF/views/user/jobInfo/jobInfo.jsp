<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<title>취업공고</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link href="/css/user/jobinfo/jobinfo.css" rel="stylesheet"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
$(document).ready(function(){
	
	$("#listbutton").on("click", function(){
		document.location="/user/selectAllJobInfo?keyWord=&page=1";
	})
	
	
	$("button[id^=fileDownBtn]").on("click", function(){
		filesId = $(this).val();
		document.location="/user/downloadJobInfo?jobinfoId=${noticeVo.noticeId}&filesId="+filesId;
	});
});

</script>
<body>
	<div class="card shadow">
		<div class="titleDiv">
			<h2 id="title">${jobinfoVo.jobinfoTitle}</h2>
		</div>
		
		<div class="header">
			<button type="button" id="listbutton" class="btn btn-primary">목록</button>
			<div>
				<label class="headerId"><img id="idImg" src="/images/admin/notice/id.png">&nbsp;&nbsp;${jobinfoVo.adminId}</label>
				<label class="headerDate"><fmt:formatDate value="${jobinfoVo.jobinfoDate}" pattern="yyyy-MM-dd HH:mm" /></label>
			</div>
		</div>
		
		<div>	
			<c:if test="${filesList.size() != 0}">
				<span style="margin-left:30px;">첨부파일 :</span> 
			</c:if>
			<c:forEach items="${filesList}" var="filesVo">
				<button id="fileDownBtn" type="button" class="btn filesButton"
					value="${filesVo.filesId}">${filesVo.filesNm}</button>
			</c:forEach>
		</div>
	
		<div class="contentDiv">
			<label class="control-label">${jobinfoVo.jobinfoCont}</label>
		</div>
	</div>
</body>	