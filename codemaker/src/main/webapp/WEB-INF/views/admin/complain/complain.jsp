<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신고내역</title>

<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<style>

@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
th{
font-family: 'LotteMartDream';
  font-weight: 700;
  font-size: 1.5em;
  text-align: center;
}
td{
font-family: 'LotteMartDream';
  font-weight: 500;
  font-size: 1.2em;
  text-align: center;
  line-height: 30px;
  padding : 20px;
}
tr{
	border-top: 2px solid #bdbdbd;
    border-bottom: 2px solid #bdbdbd;
}
div, li{
 font-family: 'LotteMartDream';
  font-weight: 500;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#cancle").on("click", function(){
			self.close();
		});
		
		$("#check").on("click", function(){
			var cpId = $("#cpId").val();
			var plaintiff = $("#plaintiff").val();
			var defendant = $("#defendant").val();
			var select = confirm("처리하시겠습니까?");
			var complainVo = {cpId : cpId,
					defendant:defendant,
					plaintiff:plaintiff};
			
			if(select){
				$.ajax({
					url : "/admin/checkComplain",
					type : "post",
					data : complainVo,
					dataType : 'json',
					success : function(){
						opener.parent.location.reload();
						self.close();
					}
				})
			}else{
				return;
			}
			
		});
		
		$("#show").on("click", function(){
			var url = "";
			var option = "";
			if(${cpVo.qnaId != null}){
				url = "/teacher/selectQna?qnaId=${cpVo.qnaId}";
				option = "width = 1500, height = 800, top = 100, left = 200, location = no";
			}else if(${cpVo.replyId != null}){
				url = "/teacher/selectQna?qnaId=${reId}";
				option = "width = 1500, height = 800, top = 100, left = 200, location = no";
			}
			window.open(url, "_blank", option);
		});
	})
</script>
</head>
<body>
<input type="hidden" name="cpId" id="cpId" value="${cpVo.cpId}">
<input type="hidden" name="plaintiff" id="plaintiff" value="${cpVo.plaintiff}">
<input type="hidden" name="defendant" id="defendant" value="${cpVo.defendant}">
<div id="contains" style="text-align:center; border:3px solid gray;">
<table style="border:3px solid gray; margin-left:auto; margin-right:auto;">
	<tr>
		<td>신고 아이디</td>
		<td><label>${cpVo.cpId}</label></td>
	</tr>
	<tr>
		<td>신고 날짜</td>
		<td><label><fmt:formatDate value="${cpVo.cpDate}" pattern="yyyy-MM-dd"/></label></td>
	</tr>
	<tr>
		<td>신고 내용</td>
		<td><label>${cpVo.cpCont}</label></td>
	</tr>
	<tr>
		<td>처리 상태</td>
		<td><label>${cpVo.cpState}</label></td>
	</tr>
	<tr>
		<td>신고 구분</td>
		<td>
			<c:choose>
				<c:when test="${cpVo.replyId != null}">
					<div>${cpVo.replyId}</div>
				</c:when>
				<c:otherwise>
					<div>${cpVo.qnaId}</div>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>신고자</td>
		<td>
			<label>${cpVo.plaintiff}</label>
		</td>
	</tr>
	<tr>
		<td>신고 대상</td>
		<td>
			<label>${cpVo.defendant}</label>
		</td>
	</tr>
</table>
<br>
<input type="button" class="btn btn-primary" id="cancle" name="cancle" value="닫기">
<c:if test="${cpVo.cpState != 'Y'}">
	<input type="button" class="btn btn-warning" id="check" name="check" value="신고접수">
</c:if>
<input type="button" class="btn btn-info" id="show" name="show" value="글보러가기">
</div>

</body>
</html>