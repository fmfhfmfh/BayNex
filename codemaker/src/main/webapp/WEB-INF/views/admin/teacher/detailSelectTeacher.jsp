<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("br", "\n"); %>
<link href="/css/admin/teacher/detailSelectTeacher.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<div class="card">
	<div class="select-container-area">
		<div class="header-container">
			<h3>선생님 상세조회</h3>
			<div class="divider"></div>
		</div>
		<div class="info-teacher">
			<div class="info-first">
				<div>
				<div class="teacher-img-box">
					<c:url value="/admin/teacherImg" var="teacherImg">
						<c:param name="tchProfile" value="${teacherVo.tchProfile}"/>
					</c:url>
					<img id="img-teacher" alt="" src="${teacherImg}">
				</div>
				</div>
				<div class="info-first-2">
					<div>
						<c:choose>
							<c:when test="${teacherVo.tchGn == 'Y'}">
								<span style="background: #f94040a1;color: white;" class="sp-ib">
									<em>기업강사</em>
								</span>
								<span>${teacherVo.tchNm}</span>
							</c:when>
							<c:otherwise>
								<span style="background: #8415ffad;color: white;" class="sp-ib">
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
				<div class="info-first-3">
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