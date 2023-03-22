<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/css/admin/teacher/select-resume.css" rel="stylesheet" />
<title>이력서 상세조회</title>
<!-- Table -->
<div class="card shadow">
	<div class="resume-header">
		<h1 class="fw-600">이력서</h1>
		<div>
			<c:url value="/admin/resume/state" var="resumeState"></c:url>
			<form class="form-horiaontal" action="${resumeState}" method="post" id="ff">
				<div class="stateBox">
					<div>
						<c:choose>
						<c:when test="${resume.resState == '2' }">
								<button id="resY" value="Y"  class="resBtn">승인</button>
								<button id="resN" value="N"  class="resBtn">미승인</button>
							</c:when>
						</c:choose>
					</div>
					<input type="hidden" name="resId" value="${resume.resId }">
					<input type="hidden" name="resState" value="" id="resState">
				</div>
			</form>
			<button class="fw-600" onclick="location.href='/admin/resumeList'">이력서 목록</button>
		</div>
	</div>
	<div class="divider"></div>
		
	<div class="box">
		<!-- 인적사항 -->
		<div class="resume-info1">
			<!-- 프로필 -->
			<div >
				<c:url value="/resume/teacherImg" var="resumeImg">
					<c:param name="resProfile" value="${resume.resProfile}"/>
				</c:url>
				<img id="resume-profile" alt="profile" src="${resumeImg}">
			</div>
			<!-- 기본정보 -->
			<div class="resume-info1-person">
				<div>
					<span class="p-info">승인코드</span>
					<span>${resume.resCode}</span>
				</div>
				<div>
					<span class="p-info">이름</span>
					<span>${resume.resNm}</span>
				</div>
				<div>
					<span class="p-info">전화번호</span>
					<span>${resume.resTel}</span>
				</div>
				<div>
					<span class="p-info">이메일</span>
					<span>${resume.resMail}</span>
				</div>
				
			</div>
		</div>
			
		<!-- 자기소개 -->
		<div class="resume-intro">
			<fieldset class="fs-b" style="height: 147px;">
				<legend>자격증</legend>
				<div>
					<span>${resume.resLicense}</span>
				</div>
			</fieldset>
			<fieldset class="fs-b">
				<legend>학력</legend>
				<div>
					<span>${resume.resEdu}</span>
				</div>
			</fieldset>
			<fieldset class="fs-b">
				<legend>경력</legend>
				<div>
					<span>${resume.resCareer}</span>
				</div>
			</fieldset>
		</div>
		<div>
			<fieldset class="fs-b" style="height: 200px;">
				<legend>지원동기</legend>
				<div>
					<span>${resume.resMotive}</span>
				</div>
			</fieldset>
		</div>
	</div>
</div>	

<script>
$(function(){
	$('.resBtn').on('click', function(){
		var resState = $(this).val();
		$('#resState').val(resState);
		$('#ff').submit();
	});
});
</script>