<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/teacher/lesson/button.css">
<!-- css made -->
<link rel="stylesheet" href="/css/admin/lesson/lesson-all-select.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<div class="card shadow">
	<div class="lesson-request">
		<h2 class="fw-600">강의 개설 요청</h2>
		<table class="request-info">
			<thead class="fw-600">
				<tr class="thead-tr">
					<td>과목명</td>
					<td>승인요청</td>
					<td>승인완료</td>
					<td>반려</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lessonList}" var="lesson">
					<tr class="fw-600">
						<td class="fw-600">${lesson.subNm}</td>
						<td><a class="a2" href="/admin/selectAllLesson?subId=${lesson.subId }&lesState=2">${lesson.agreeCnt}건</a></td>
						<td><a href="/admin/selectAllLesson?subId=${lesson.subId }&lesState=3">${lesson.sagreeCnt}건</a></td>
						<td><a class="a4" href="/admin/selectAllLesson?subId=${lesson.subId }&lesState=4">${lesson.dagreeCnt}건</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<table class="request-result">
				<thead>
					<tr class="result-tr">
						<th scope="col">강의No.</th>
						<th scope="col">강의명</th>
						<th scope="col">담당선생님</th>
						<th scope="col">강의승인상태</th>
					</tr>
				</thead>
				<tbody id="lesidx">
					<c:if test="${lessonLists.size() ne 0}">
					<c:forEach items="${lessonLists}" var="lesson" varStatus="status">
					<tr data-lesid='${lesson.lesId }'>
						<td>${status.count }</td>
						<td>${lesson.lesNm }</td>
						<td>${lesson.tchNm }</td>
						<td>
							<c:choose>
								<c:when test="${lesson.lesState == 2 }">승인요청</c:when>
								<c:when test="${lesson.lesState == 3 }">승인완료</c:when>
								<c:when test="${lesson.lesState == 4 }">반려</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
$(function(){
	// 강의 상세조회 페이지로
	$('#lesidx tr td').on('click', function(){
		if($(this).attr('class') != 'chb'){
			var lesId = $(this).parent('tr').data('lesid');
			var windowObj = window.open('/admin/lessonSelect?lesId='+lesId,'lessonSelect', 'width=800,height=800,resizable=no,scrollbars=yes,left=500,top=50');
		}
	});
	
});
</script>