<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="left-sidebar bg-sidebar">
	<div id="sidebar" class="sidebar sidebar-with-footer">
		<div class="app-brand">
			<a href="${cp }/admin/main"><img src="/images/codemaker_name3.png"><span class="brand-name">관리자</span></a>
		</div>
		<div class="sidebar-scrollbar">
			<ul class="nav sidebar-inner" id="sidebar-menu">
				<li  class="has-sub" >
					<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#ui-elements" aria-expanded="false" aria-controls="ui-elements">
						<i class="mdi mdi-folder-multiple-outline"></i>
						<span class="nav-text">전체 관리</span> <b class="caret"></b>
					</a>
					<ul  class="collapse"  id="ui-elements" data-parent="#sidebar-menu">
						<div class="sub-menu">
							<!-- 회원관리 -->
							<li class="has-sub" >
								<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#student" aria-expanded="false" aria-controls="components">
									<span class="nav-text">회원 관리</span> <b class="caret"></b>
								</a>
								<ul  class="collapse"  id="student">
									<div class="sub-menu">
										<li>
											<c:url value="/admin/selectUserInfo" var="selectUserInfo"/>
											<a href="${selectUserInfo}">정보조회</a>
										</li>
										<li >
											<c:url value="/admin/selectAllComplain" var="selectAllComplain"/>
											<a href="${selectAllComplain}">블랙리스트 관리</a>
										</li>
										<li>
											<c:url value="/scholarship/selectAllScholarship" var="selectAllScholarship"/>
											<a href="${selectAllScholarship}">장학제도</a>
										</li>
									</div>
								</ul>
							</li>
							<!-- 직원관리 -->
							<li class="has-sub">
								<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#employee" aria-expanded="false" aria-controls="icons">
									<span class="nav-text">직원 관리</span> <b class="caret"></b>
								</a>
								<ul  class="collapse"  id="employee">
									<div class="sub-menu">
										<li>
											<c:url value="/admin/selectAllTeacher" var="selectAllTeacher"/>
											<a href="${selectAllTeacher}">강사 조회</a>
										</li>
										<li>
											<c:url value="/admin/resumeList" var="resumeList"/>
											<a href="${resumeList}">이력서 조회</a>
										</li>
									</div>
								</ul>
							</li>
							<!-- 기업관리 -->
							<li class="has-sub">
								<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#company" aria-expanded="false" aria-controls="forms">
									<span class="nav-text">기업 관리</span> <b class="caret"></b>
								</a>
								<ul class="collapse"  id="company">
								<c:url value="/admin/company" var="company"/>
									<div class="sub-menu">
										<li>
											<c:url value="/admin/company/selectAllCompany" var="selectAllCompany"/>
											<a href="${selectAllCompany}">기업 정보</a>
										</li>
									</div>
								</ul>
							</li>
							<!-- 게시판관리 -->
							<li class="has-sub">
								<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#notice" aria-expanded="false" aria-controls="icons">
									<span class="nav-text">게시판 관리</span> <b class="caret"></b>
								</a>
								<ul class="collapse" id="notice">
									<div class="sub-menu">
										<li>
											<c:url value="/admin/selectAllJobInfo" var="selectAllJobInfo"></c:url>
											<a href="${selectAllJobInfo}">취업 공고</a>
										</li>
										<li>
											<c:url value="/admin/selectAllNotice" var="selectAllNotice"></c:url>
											<a href="${selectAllNotice}">공지 사항 조회</a>
										</li>
									</div>
								</ul>
							</li>
						</div>
					</ul>
				</li>
				
				<!-- 줄바뀌고 통계관리 -->
				<li class="has-sub" >
					<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#charts" aria-expanded="false" aria-controls="charts">
						<i class="mdi mdi-chart-pie"></i>
						<span class="nav-text">통계 관리</span> <b class="caret"></b>
					</a>
					<ul  class="collapse"  id="charts" data-parent="#sidebar-menu">
						<div class="sub-menu">
							<!-- 매출조회 -->
							<li class="section-title">매출 조회</li>
							<li>
								<c:url value="/admin/selectLessonPay" var="selectLessonPay"/>
								<a class="sidenav-item-link" href="${selectLessonPay}">
									<span class="nav-text">강의별 조회</span>
								</a>
							</li>
							<li>
								<c:url value="/admin/selectTeacherPay" var="selectTeacherPay"/>
								<a class="sidenav-item-link" href="${selectTeacherPay}">
									<span class="nav-text">강사별 조회</span>
								</a>
							</li>
							<li>
								<c:url value="/admin/lessonUserChart" var="lessonUserChart"/>
								<a class="sidenav-item-link" href="${lessonUserChart}">
									<span class="nav-text">회원 조회</span>
								</a>
							</li>
						</div>
					</ul>
				</li>
			                
				<li  class="has-sub" >
					<a class="sidenav-item-link" href="#" data-toggle="collapse" data-target="#documentation" aria-expanded="false" aria-controls="documentation">
						<i class="mdi mdi-book-open-page-variant"></i>
						<span class="nav-text">수강 관리</span> <b class="caret"></b>
					</a>
					<ul  class="collapse"  id="documentation" data-parent="#sidebar-menu">
						<div class="sub-menu">
							<li class="section-title">
								수강 관리 조회
							</li>
							<li>
								<c:url value="/admin/selectAllSubject" var="selectAllSubject"/>
								<a class="sidenav-item-link" href="${selectAllSubject}">
									<span class="nav-text">과목 조회</span>
								</a>
							</li>
							<li>
								<c:url value="/admin/selectAllAgree" var="selectAllAgree"></c:url>
								<a class="sidenav-item-link" href="${selectAllAgree}">
									<span class="nav-text">강의 조회</span>
								</a>
							</li>
						</div>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</aside>