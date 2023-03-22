<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!-- main(css)  -->
<link href="/vendor/user/main/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- main Custom styles for this template  -->
<link href="/css/user/main/sb-admin-2.min.css" rel="stylesheet">

<!-- Illustrations -->
<div class="text-center">
	<img class="img-fluid" style="width: 130rem;" src="/images/main_mid.jpg" alt="">
</div>
<style>
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
.container-fluid, .container-fluid a{
	font-family: 'LotteMartDream' !important;
}
</style>
<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- Content Row -->
	<div class="row">
		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card shadow h-100 py-2">
				<div class="card-body2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-3">
							<img class="imgMain" src="/images/user/main/drawkit-grape-pack-illustration-1.svg"> <br>
							<div class="text-xm font-weight-bold text-primary text-uppercase mb-1">개발 커리어를 쌓아보는</div>
							<div class="h1 mb-0 font-weight-bold text-gray-900">
								<a id="at" href="${cp}/user/selectSubject" style="font-size: 1.1em;">전체강의 </a> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card shadow h-100 py-2">
				<div class="card-body2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-3">
							<img class="imgMain" src="/images/user/main/drawkit-grape-pack-illustration-2.svg"> <br>
							<div class="text-xm font-weight-bold text-primary text-uppercase mb-1"> 코드메이커와 준비하는</div>
							<div class="h1 mb-0 font-weight-bold text-gray-900">
								<c:url value="/user/codingtest" var="codingtest"/>
								<a id="at" href="${codingtest}" style="font-size: 1.1em;">코딩테스트</a> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card shadow h-100 py-2">
				<div class="card-body2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-3">
							<img class="imgMain" src="/images/user/main/drawkit-grape-pack-illustration-6.svg"> <br>
							<div class="text-xm font-weight-bold text-primary text-uppercase mb-1"> 자유롭게 소통하는</div>
							<div class="h1 mb-0 font-weight-bold text-gray-900">
								<c:url value="/user/selectAllNotice" var="selectAllNotice">
									<c:param name="searchOption" value="1"/>
									<c:param name="keyWord" value="${param.keyWord}"/>
									<c:param name="page" value="1"/>
								</c:url>
								<a id="at" href="${selectAllNotice}" style="font-size: 1.1em;">게시판</a> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Pending Requests Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card shadow h-100 py-2">
				<div class="card-body2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-3">
							<img class="imgMain" src="/images/user/main/drawkit-grape-pack-illustration-18.svg"><br>
							<div class="text-xm font-weight-bold text-primary text-uppercase mb-1"> 필요한 정보 쏙쏙!</div>
							<div class="h1 mb-0 font-weight-bold text-gray-900">
								<c:url value="/user/selectAllJobInfo" var="selectAllJobInfo">
									<c:param name="keyWord" value="${param.keyWord}"/>
									<c:param name="page" value="1"/>
								</c:url>
								<a id="at" href="${selectAllJobInfo}" style="font-size: 1.1em;">취업정보</a><br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Content Row -->
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
</div>