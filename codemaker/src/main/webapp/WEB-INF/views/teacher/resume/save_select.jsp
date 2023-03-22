<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/teacher/resume/resume-insert.css" rel="stylesheet"/>
<div class="article">
	<div class="mb-15">
		<h2 class="fw-600">이력서 작성</h2>
	</div>
	<c:url value="/resume/save/sumit" var="teacherResume"/>
	<form action="${teacherResume}" id="insertForm" class="form-horizontal" method="POST" enctype="multipart/form-data" name="insertForm">
		<div class="">
			<div class="img-box mb-15">
				<span class="fw-600">이력서 프로필</span>
				<div class="resume_photo">
					<img id="img" src="/images/teacher/imageAdd.PNG" class="redius-3" >
					<input type="file" id="resProfile" name="profile" onchange="loadImg(this)">
					<input type="hidden" name="target_url"/>
				</div>
			</div>
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">이름</span>
				<input readonly name=resNm type="text" id="resNm" class="form-control ih-30 border-box redius-3" value="${resumeVo.resNm}">
			</div>
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">휴대폰번호</span>
				<div class="resume-info-tel">
					<input readonly type="text" id="resTel" name="resTel" value="${resumeVo.resTel}"/>
				</div>
			</div>
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">이메일</span>
				<div class="ds-flex">
					<input type="text" id="resMail" name="resMail" value="${resumeVo.resMail}"/>
				</div>
			</div>
		</div>
		<!-- 학력사항 -->
		<div class="instruction_table_title">
			<span class="fw-600 mb-15">학력사항</span>
		</div>
		<div class="divider"></div>
		<div class="instruction_table_wrapper">
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">기간</span>
				<div>
					<span class="input_text1">
						<input name="resEdu1" type="date" id="resEdu1" class="border-box redius-3">&nbsp;-&nbsp;
					</span>
					<span class="input_text1">
						<input name="resEdu2" type="date" id="resEdu2" class="border-box redius-3">
					</span>
				</div>
			</div>
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">학교명</span>
				<span class="input_text2">
					<input name="resEdu3" type="text" id="resEdu3" class="border-box redius-3" maxlength="50">
				</span>
			</div>
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">학과 (전공)</span>
				<span class="input_text3">
					<input name="resEdu4" type="text" id="resEdu4" class="border-box redius-3" maxlength="50">
					<input type="hidden" id="resEdu" name="resEdu"/>
				</span>
			</div>
			<!-- 자격증 -->
			<div class=" mb-15">
				<div class="ds-flex mb-15">
					<span class="fw-600 resume-info-header">자격증</span>
					<div>
						<span class=" text-box">
							<textarea name="resLicense" class="border-box redius-3" id="license" style="width: 350px; height: 40px;">${resumeVo.resLicense}</textarea>
						</span>
					</div>
				</div>
			</div>
		</div>

		<!-- 자기소개 -->
		<div class="instruction_table_title">
			<div class="ds-flex mb-15">
				<span class="fw-600 resume-info-header">자기소개</span>
			</div>
			<div class="divider"></div>
			<div class="instruction_table_wrapper none_border">
				<!-- 지원동기 -->
				<div class="ds-flex mb-15">
					<span class="fw-600 resume-info-header">지원동기</span>
					<div>
						<textarea name="resMotive" id="resMotive" class="border-box redius-3" >${resumeVo.resMotive}</textarea>
					</div>
				</div>
				<!-- 경력기술서 -->
				<div class="ds-flex mb-15">
					<span class="fw-600 resume-info-header">경력기술서</span>
					<div>
						<textarea name="resCareer" id="resCareer" class="border-box redius-3">${resumeVo.resCareer}</textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="btn-float">
			<input type="button" id="cancel" class="fw-600 sub-btn" value="돌아가기" onclick="location.href='/user/main'"/>
<!-- 			<input type="button" id="saveBtn" class="fw-600 sub-btn" value="임시저장" onclick="location.href='/user/main'"/> -->
			<input type="button" id="insertBtn" class="fw-600 sub-btn" value="제출하기"/>
		</div>
	</form>
</div>

<script>
	$(document).ready(function(){
		$('#insertBtn').on('click', function(){
			var resEdu1 = $("#resEdu1").val();
			var resEdu2 = $("#resEdu2").val();
			var resEdu3 = $("#resEdu3").val();
			var resEdu4 = $("#resEdu4").val();
			
			$("#resEdu").val(resEdu1 + '~' + resEdu2 + ' ' + resEdu3 + ' ' + resEdu4);
			$('#insertForm').submit();
		});
	});
	
	// 파일 첨부시 미리보기 창
	function loadImg(value){
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$('#img').attr('src', e.target.result);
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
</script>