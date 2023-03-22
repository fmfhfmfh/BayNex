<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/teacher/resume/search-resume.css" rel="stylesheet" />
<c:choose>
	<c:when test="${resumeVo != null}">
		<div class="resume-box">
			<table>
				<thead>
					<tr>
						<th>이름</th>
						<th>전화번호</th>
						<th>이력서 상태</th>
					</tr>
				</thead>
				<tbody>
					<tr id="res-tr" data-resNm="${resumeVo.resNm}" data-resTel="${resumeVo.resTel}" data-state="${resumeVo.resState}">
						<td>${resumeVo.resNm}</td>
						<td>${resumeVo.resTel}</td>
						<td>
							<c:choose>
								<c:when test="${resumeVo.resState =='N'}"><span class="res-fail">불합격</span></c:when>
								<c:when test="${resumeVo.resState =='Y'}"><span class="res-success">합격</span></c:when>
								<c:when test="${resumeVo.resState =='1'}"><span class="res-save">임시저장</span></c:when>
								<c:when test="${resumeVo.resState =='2'}"><span class="res-com">제출완료</span></c:when>
							</c:choose>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div class="empty-resume">
			<span>작성된 이력서가 없습니다</span>
			<button onclick="location.href='<c:url value="/resume/insertView"/>'">이력서 작성</button>
		</div>
	</c:otherwise>
</c:choose>

<script>
$(function(){
	$("#res-tr").on('click',function(){
		var resNm = $(this).attr('data-resNm');
		var resTel = $(this).attr('data-resTel');
		location.href="/resume/save/select?resNm="+resNm+"&resTel="+resTel;
		console.log('가져온값 '+resNm + '전화번호'+resTel);
	})
})
</script>