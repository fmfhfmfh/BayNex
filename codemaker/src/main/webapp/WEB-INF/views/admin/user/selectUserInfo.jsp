<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/admin/user/selectUser.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<div class="card">
	<div class="select-container-area">
		<div class="header-container">
			<h3>회원조회</h3>
			<div class="header-item2">
				<div>
			        <button id="btn1" data-val="1" class="item-btn">정상회원</button>
				</div>
				<div>
			        <button id="btn2" data-val="2" class="item-btn">정지회원</button>
				</div>
				<div>
			        <button id="btn3" data-val="3" class="item-btn">탈퇴회원</button>
				</div>
				<div>
			        <button id="btn4" data-val="4" class="item-btn">전체보기</button>
				</div>
	    	</div>
		</div>
		<div class="divide"></div>
		<div class="select-container" id="div">
			<table>
				<thead>
					<tr>
						<th>구분</th> <!-- 회원 탈퇴 구분 N : 정상회원 | Y : 탈퇴회원 -->
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>블랙리스트</th> <!-- 블랙유저면 Y 아니면 N -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr class="tr-cl">
							<c:choose> 
								 <c:when test="${user.userOut == 'Y'}"> 
									 <td style="color:#ff0000b8;">탈퇴</td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${user.userBlack == 'Y'}">
											<td style="color:orange;">정지</td>
										</c:when>
										<c:otherwise>
											<td style="color:rgb(0,95,134);">정상</td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<td>${user.userId}</td>
							<td>${user.userNm}</td>
							<td>${user.userTel}</td>
							<td>${user.userBlack}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
$(function(){
	$(".item-btn").on('click',function(){
		var gubun = $(this).data('val');
		console.log(gubun);
		$.ajax({
			url : '/admin/selectUserInfo',
			method : 'get',
			data : {"gubun" : gubun},
			dataType : 'html',
			success : function(data){
				console.log(data);
				$("#div").html(data);
			},
			error : function(){
				console.log("실패");
			}
			
		})
	})
})
</script>