<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	#teachericon{
		width: 145px;
		height: 155px;
		margin-top: 14px;
	}
</style>
<aside class="left-sidebar bg-sidebar">
	<div id="sidebar" class="sidebar sidebar-with-footer">
		<div class="app-brand">
			<a href="<c:url value="/teacher/main" />">
				<img src="/images/codemaker_name3.png">
				<span class="brand-name">강사</span>
			</a>
		</div>
		<c:url value="/teacher/selectTeacher" var="selectTeacher">
			<c:param name="tchId" value="${S_TEACHER.tchId}"/>
		</c:url>
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="${selectTeacher}">
			<div class="sidebar-brand-icon">
				<c:url value="/teacher/teacherImg" var="teacherImg">
					<c:param name="tchProfile" value="${S_TEACHER.tchProfile}"/>
				</c:url>
				<img id="teachericon" alt="" src="${teacherImg}"> <br>
				<br>${S_TEACHER.tchNm}님<br>
			</div>
		</a>
		
		<div class="sidebar-scrollbar">
			<ul class="nav sidebar-inner" id="sidebar-menu">
				<li  class="has-sub" >
					<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#ui-elements" aria-expanded="false" aria-controls="ui-elements">
						<i class="mdi mdi-book-open-page-variant"></i>
						<span class="nav-text">수강</span> <b class="caret"></b>
					</a>
					<ul class="collapse"  id="ui-elements" data-parent="#sidebar-menu">
						<div class="sub-menu">
							<li  class="has-sub" >
								<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#components" aria-expanded="false" aria-controls="components">
									<span class="nav-text">수강 관리</span> <b class="caret"></b>
								</a>
								<ul class="collapse" id="components">
									<div class="sub-menu">
										<li>
											<a href="<c:url value="/teacherL/selectSubject"/>">강의 개설 및 수정</a>
										</li>
										<li>
											<a href="/exam/selectAllExam">시험 등록 및 수정/삭제</a>
										</li>
									</div>
								</ul>
							</li>
							<li class="has-sub" >
								<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#icons" aria-expanded="false" aria-controls="icons">
									<span class="nav-text">과목별 게시판</span> <b class="caret"></b>
								</a>
								<ul class="collapse" id="icons">
									<div class="sub-menu">
										<li>
											<a href="<c:url value="/teacher/selectAllQna"/>">질문 응답 게시판</a>
										</li>
									</div>
								</ul>
							</li>
						</div>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</aside>