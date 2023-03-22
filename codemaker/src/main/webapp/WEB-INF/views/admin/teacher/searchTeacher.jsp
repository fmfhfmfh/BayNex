<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/css/admin/teacher/selectTeacher.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<table>
	<thead>
		<tr>
			<th>구분</th> <!-- 선생님구분 N : 직원 Y : 기업 -->
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>입사일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${teacherList}" var="teacher">
			<tr>
				<c:choose> 
					 <c:when test="${teacher.tchGn == 'Y'}"> 
						<td style="color:orange;">기업강사</td>
					</c:when>
					<c:otherwise>
						<td style="color:rgb(0,95,134);">정규강사</td>
					</c:otherwise>
				</c:choose>
				<td>${teacher.tchId}</td>
				<td>${teacher.tchNm}</td>
				<td>${teacher.tchTel}</td>
				<td><fmt:formatDate value="${teacher.tchJoin}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>