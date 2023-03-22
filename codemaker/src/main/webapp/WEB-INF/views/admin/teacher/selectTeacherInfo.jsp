<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/css/admin/teacher/selectTeacher.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<div class="card">
	<div class="select-container-area">
		<div class="header-container">
			<h3>선생님조회</h3>
			<div class="header-item2">
				<div>
			        <button id="btn1" data-val="1" class="item-btn">정규직원</button>
				</div>
				<div>
			        <button id="btn2" data-val="2" class="item-btn">기업직원</button>
				</div>
				<div>
			        <button id="btn3" data-val="3" class="item-btn">전체보기</button>
				</div>
	    	</div>
		</div>
		<div class="divide"></div>
		<div class="select-container" id="div">
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
						<tr class="tr-cl">
							<c:choose> 
								 <c:when test="${teacher.tchGn == 'Y'}"> 
									<td style="color:orange;">기업직원</td>
								</c:when>
								<c:otherwise>
									<td style="color:rgb(0,95,134);">정규직원</td>
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
		</div>
	</div>
</div>
<script>
$(function(){
	$(".item-btn").on('click',function(){
		var gubun = $(this).data('val');
		console.log(gubun);
		$.ajax({
			url : '/admin/selectAllTeacher',
			method : 'get',
			data : {"gubun" : gubun},
			dataType : 'html',
			success : function(data){
				$("#div").html(data);
			},
			error : function(){
				console.log("실패");
			}
			
		})
	})
	$(".tr-cl").on('click',function(){
		var tchId = $(this).children().eq(1).text();
		console.log(tchId);
		document.location = "/admin/selectTeacher?tchId="+tchId;
	})
})
</script>