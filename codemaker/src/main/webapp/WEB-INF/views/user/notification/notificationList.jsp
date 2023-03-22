<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link rel="stylesheet" href="/css/user/mypage/notification-list.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

<div class="card shadow">
	<div class="card-header border-0">
		<h3 class="">알림 목록</h3>
	</div>
	<div class="table-responsive">
		<table class="table align-items-center table-flush">
			<thead class="thead-light">
				<tr>
					<th>알림 내용</th>
					<th>발신자</th>
					<th>알림 날짜</th>
					<th></th>
				</tr>
			</thead>

			<tbody id="pointList">
				<c:forEach items="${notifyList}" var="notify">
					<c:if test="${notify.senderId != MEMBER_INFO.userId}">
						<tr>
							<td class="notify-tr" data-url="${notify.url}">
								<span class="badge badge-dot mr-4">${notify.notifyCont}</span>
							</td>
							<td>
								<span class="badge badge-dot mr-4">${notify.senderId}</span>
							</td>
							<td>
								<span class="badge badge-dot mr-4">${notify.notifyDate}</span>
							</td>
							<td>
								<span class="badge badge-dot mr-4">
									<button type="button" name="delBtn" class="delBtn" value="${notify.notifyId}">지우기</button>
								</span>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script>
$(function() {
	$("button[name^='delBtn']").on("click", function() {
		var del = $(this).val();
		if (confirm("삭제 하시겠습니까?")) {
			document.location = "/user/deleteNotification?notifyId=" + del;
		} else {
			return;
		}
	})
	
	$(".notify-tr").on("click",function(){
		var url = $(this).attr("data-url");
		console.log("유알"+url);
		window.open(url,'_blank');
// 		location.href=url;
	})
})
</script>