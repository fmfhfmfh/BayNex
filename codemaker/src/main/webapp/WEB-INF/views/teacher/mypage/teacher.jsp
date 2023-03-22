<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("br", "\n"); %>

<title>선생님 마이페이지</title>
<link href="/css/admin/teacher/detailSelectTeacher.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#updateBtn').on("click", function(){
			document.location="/teacher/updateTeacher?tchId=${teacherVo.tchId}";
		})
	})
</script>
<div class="card">
	<div class="select-container-area">
		<div class="header-container">
			<h3>마이페이지 <button style="float:right;" id="updateBtn" type="button" class="btn btn-primary" name="updateBtn">수정</button></h3>
			<div class="divider"></div>
		</div>
		<div class="info-teacher">
			<div class="info-first">
				<div>
				<div style="width: 230px;height: 300px;">
					<c:url value="/teacher/teacherImg" var="teacherImg">
						<c:param name="tchProfile" value="${teacherVo.tchProfile}"/>
					</c:url>
					<img style="width: 230px; height: 300px;" id="img-teacher" alt="" src="${teacherImg}">
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
							</c:when>
							<c:otherwise>
								<span style="background: #8415ffad; color: white;" class="sp-ib">
									<em>정규강사</em>
								</span>
								<span>${teacherVo.tchNm}</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div>
						<span class="nametag sp-ib">
							<em>아이디</em>
						</span>
						<span>${teacherVo.tchId}</span>
					</div>
					<div>
						<span class="nametag sp-ib">
							<em>전화번호</em>
						</span>
						<span>${teacherVo.tchTel}</span>
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
							<em>학교</em>
						</span>
						<span>${resumeVo.resEdu}</span>
					</div>
					<!-- 이력서 정보 -->
				</div>
				<div class="info-first-3" style="margin-left:35px;">
					<fieldset id="career-f">
						<legend>경력</legend>
						<div>
							<span>${fn:replace(resumeVo.resCareer, br, "<br/>")}</span>
<%-- 								${resumeVo.resCareer} --%>
						</div>
					</fieldset>
				</div>
			</div>
			<div class="info-second">
				<fieldset class="info-second-f1">
					<legend>소개말</legend>
					<div class="t-field-div">
						<span class="fs-16">${teacherVo.tchIntro}</span>
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
	</div>
</div>