<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("br", "\n"); %>
<link href="/css/admin/teacher/detailSelectTeacher.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

var flag;
	$(function(){
		$("#picture").change(function(){
		   readURL(this);
		});
		
		$('#saveBtn').on("click", function(){
			if($("#tchPass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#tchPass").focus();
				return false;
				
			}else if($("#tchTel").val()==""){
				alert("휴대폰 번호를 입력해주세요.");
				$("#tchTel").focus();
				return false;
				
			}else if($("#tchIntro").val()==""){
				alert("소개말을 입력해주세요.");
				$("#tchIntro").focus();
				return false;
				
			}else if(confirm("저장하시겠습니까?")){
				
				$('#upBtn').submit();
			}else{
				return;
			}
				
		})
		
		
		$('#cancleBtn').on("click", function(){
			if(confirm("이전페이지로 가시겠습니까?")){
				document.location="/teacher/selectTeacher?tchId=${teacherVo.tchId}"
			}else{
				return;
			}
		})
		
		
		$('#tchPass').on('keyup',function() {
			idval = $(this).val();

			// 비밀번호 유효성 검사
			// 영문자가 포함된 8~20자
			// 영문 소문자로 시작 하고 두 번째 문자부터 영문대소문자와 숫자를 조합. 숫자로 시작되면 안됨.
			var regex = /^[a-z][a-zA-Z0-9]{8,20}/;
			result = regex.test(idval);

			if (result) {
				$("#regex2").html("");
			} else {
				$("#regex2").html("영소문자로 시작하는 8~20자로 입력해주세요.");
				$("#regex2").css("color", "red");
				return false;
			}

			flag = false;
		})
		
	})
	
	function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
	  
		reader.onload = function (e) {
			$('#img-teacher').attr('src', e.target.result);  
		}
		reader.readAsDataURL(input.files[0]);
	}
}
</script>
<div class="card">
	<div class="select-container-area">
		<div class="header-container">
			<h3>선생님 정보수정 
				<button style="float:right; margin-left:10px;" id="cancleBtn" type="button" class="btn btn-info" name="cancleBtn">취소</button>
				<button style="float:right; margin-left:10px;" id="saveBtn" type="button" class="btn btn-primary" name="updateBtn">저장</button></h3>
			<div class="divider"></div>
		</div>
		<form action="/teacher/updateTeacher" id="upBtn" method="post" enctype="multipart/form-data">
			<div class="info-teacher">
				<div class="info-first">
					<div>
					<div style="width: 230px;height: 300px;">
						<c:url value="/teacher/teacherUpImg" var="teacherImg">
							<c:param name="tchProfile" value="${teacherVo.tchProfile}"/>
						</c:url>
						<img style="width:230px; height:300px;" id="img-teacher" alt="" src="${teacherImg}">
						<input id="picture" class="form-control" type="file" name="profile" accept=".gif, .jpg, .png" style="width:230px;" value="${teacherVo.tchProfile}"/>
					</div>
					</div>
					<div class="info-first-2" style="width:300px;">
						<div>
							<c:choose>
								<c:when test="${teacherVo.tchGn == 'Y'}">
									<span style="background: #f94040a1; color: white;" class="sp-ib">
										<em>기업강사</em>
									</span>
									<span>${teacherVo.tchNm}</span>
									<input type="hidden" id="tchNm" name="tchNm" value="${teacherVo.tchNm}">
								</c:when>
								<c:otherwise>
									<span style="background: #8415ffad; color: white;" class="sp-ib">
										<em>정규강사</em>
									</span>
									<span>${teacherVo.tchNm}</span>
									<input type="hidden" id="tchNm" name="tchNm" value="${teacherVo.tchNm}">
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							<span class="nametag sp-ib">
								<em>아이디</em>
							</span>
							<span>${teacherVo.tchId}</span>
							<input type="hidden" id="tchId" name="tchId" value="${teacherVo.tchId}">
						</div>
						<div>
							<span class="nametag sp-ib">
								<em>전화번호</em>
							</span>
							<span><input type="text" style="width: 185px;" name="tchTel" id="tchTel" value="${teacherVo.tchTel}"></span>
						</div>
						<div>
							<span class="nametag sp-ib">
								<em>이메일</em>
							</span>
							<span>${resumeVo.resMail}</span>
						</div>
						<div>
							<span class="nametag sp-ib">
								<em>입사일</em>
							</span>
							<span><fmt:formatDate value="${teacherVo.tchJoin}" pattern="yyyy-MM-dd"/></span>
						</div>
						<div>
							<span class="nametag sp-ib">
								<em>비밀번호</em>
							</span>
							<span><input type="text" style="width: 185px;" name="tchPass" id="tchPass" value="${teacherVo.tchPass}"></span>
							<br><span id="regex2" class="check" style="font-size:14px;"></span>
						</div>
						<!-- 이력서 정보 -->
					</div>
					<div class="info-first-3" style="margin-left:35px;">
						<fieldset id="career-f">
							<legend>경력</legend>
							<div>
								<span>${fn:replace(resumeVo.resCareer, br, "<br/>")}</span>
									${resumeVo.resCareer}
							</div>
						</fieldset>
					</div>
				</div>
				<div class="info-second">
					<fieldset class="info-second-f1">
						<legend>소개말</legend>
						<div class="t-field-div">
							<span class="fs-16"><textarea cols="80" rows="5" name="tchIntro" id="tchIntro" style="resize:none;">${teacherVo.tchIntro}</textarea></span>
						</div>
					</fieldset>
					<fieldset class="info-second-f1">
						<legend>자격증</legend>
						<div class="t-field-div">
							<span class="fs-16">${resumeVo.resLicense}</span>
						</div>
					</fieldset>		
					<fieldset class="info-second-f1">
						<legend>담당과목</legend>
						<div class="t-field-div">
							<c:forEach items="${lessonList}" var="lesson">
								<div class="info-les-box">
									<img alt="" src="/img/icon/cube-solid.svg">
									<div class="info-les">
										<span>${lesson.subNm}</span>
										<span>${lesson.lesNm}</span>
									</div>
								</div>
							</c:forEach>
						</div>
					</fieldset>
				</div>
			</div>
		</form>
	</div>
</div>