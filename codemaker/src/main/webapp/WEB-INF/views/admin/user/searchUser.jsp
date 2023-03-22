<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/admin/user/selectUser.css" rel="stylesheet" />    
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
			<tr>
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
