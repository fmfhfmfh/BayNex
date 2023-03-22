<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html lang="en">
<head>
<title>로그인🔑</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<!-- <link rel="icon" type="image/png" href="/images/icons/favicon.ico" /> -->
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/main.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/admin/login/util.css">
<!--===============================================================================================-->
<!-- Font Icon -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- Main css -->
<link rel="stylesheet" href="/css/admin/signup/style.css">
<!--===============================================================================================-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/admin/login/js.cookie-2.2.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.12.0.js"></script>

<!-- captcha api 적용 js -->
<script src="https://www.google.com/recaptcha/api.js" async defer></script>

<style>
	#apiBox{
		margin: 0 auto;
	}
</style>

<script>

// 이미지 클릭시 이벤트
$(function(){
	$("#teacherImg").click(function(){
		$(this).attr("src", "/images/admin/signup/teacher.png");
		$("#adminImg").attr("src", "/images/admin/signup/admin (3).png");
		$("#inputEmail").attr("name", "tchId");
		$("#inputPass").attr("name", "tchPass");
		$(".hiddenDiv").show();
		
	});
	$("#adminImg").click(function(){
		$("#teacherImg").attr("src", "/images/admin/signup/teacher (1).png");
		$(this).attr("src", "/images/admin/signup/admin (2).png");
		$("#loginForm").attr("action", "${cp}/admin/login");
		$("#inputEmail").attr("name", "adminId");
		$("#inputPass").attr("name", "adminPass");
		$(".hiddenDiv").hide();
	});
});

// 쿠키 조회 메소드
	function getCookieValue(cookieName){
		var cookies = document.cookie.split("; ") 
		
		for(i=0; i<cookies.length; i++) {
			var cookie = cookies[i].split("="); 
			if(cookie[0] == cookieName) {
				var cookieValue = cookie[1];
				//console.log(cookieValue);
				return cookieValue;
			}
		}
		return "";
	}
// 쿠키 저장 메소드
	function setCookie(cookieName, cookieValue, expires){
		var today = new Date();
		today.setDate(today.getDate() + expires);
		
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
		console.log(document.cookie);
	}
	
	function deleteCookie(cookieName){
		setCookie(cookieName, "", -1);
	}
	
	$(function() {
		var rememberme = Cookies.get('REMEMBERME');
		if(rememberme == "Y"){
			$('#ckb1').prop('checked', true);
			
			var userid = Cookies.get('A_T_ID');
			$('#inputEmail').val(userid);
		}
		
		$('#Login').on('click', function(e){
			if($('#ckb1').prop('checked')){
				Cookies.set('REMEMBERME', 'Y');
				Cookies.set('A_T_ID', $('#inputEmail').val());
				
			}else{
				Cookies.remove('REMEMBERME');
				Cookies.remove('A_T_ID');
			}
			
			// 캡챠 체크 박스 체크 여부
			var captcha = 1;
			var currentUrl = $("#loginForm").attr("action");
			$.ajax({
				url: '/login/VerifyRecaptcha',
				type: 'post',
				data: {
					recaptcha: $("#g-recaptcha-response").val()
				},
				success: function(data) {
					switch (data) {
						case 0:
							var currentUrl = $("#loginForm").attr("action");
						    $.ajax({
								type : "POST",
								url : currentUrl,
								data : $('#loginForm').serialize(),
								dataType : 'text',
								success : function(data){
									console.log(data);
									if(currentUrl.indexOf("teacher") > 0){
										console.log("강사 확인");
										if(data == 'Y'){
											document.location="/teacher/main";
										}else{
											alert("아이디 또는 비밀번호가 일치하지 않습니다.");
										}
									}
									else if(currentUrl.indexOf("admin") > 0) {
											// 음수일 때 실행되어서 -1로 실행이 안됐음,, 0보다 클때를 꼭 ,,
										console.log("관리자 확인");
										if(data == 'Y'){
											document.location="/admin/main";
										}else{
											alert("아이디 또는 비밀번호가 일치하지 않습니다.");
										}
									}
								},
								error : function(er){
										alert("사용자를 선택해 주세요.");
								}
							});
							break;
						case 1:
							alert("자동 가입 방지 봇을 확인 한 뒤 진행 해 주세요.");
		 					break;
						default:
							alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
							break;
					}
				}
			});
			
			if(captcha != 0) {
				return false;
			}
		});
	});
	

</script>
</head>
<body class="loginBody">

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form class="login100-form validate-form flex-sb flex-w" id="loginForm" action="${cp}/teacher/login" method="post" onsubmit="return checkrecaptachSubmit();">
					<span class="login100-form-title p-b-51"> 로그인 </span> 
					<img id="teacherImg" alt="교사" src="/images/admin/signup/teacher.png" style="height: 120px; width: 120px;" >
					<img id="adminImg" alt="관리자" src="/images/admin/signup/admin (3).png" style="height: 120px; width: 120px;">

					<div class="wrap-input100 validate-input m-b-16"> 
						<input class="input100" type="text" id="inputEmail" name="tchId" placeholder="아이디">
						<span class="focus-input100"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="password" id="inputPass" name="tchPass" placeholder="비밀번호">
						<span class="focus-input100"></span>
					</div>
					<div class="flex-sb-m w-full p-t-3 p-b-24">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="rememberme" value="rememberme">
							<label class="label-checkbox100" for="ckb1"> 아이디 저장 </label>
						</div>
					</div>
					<div id="apiBox">
						<div id="recaptcha" class="g-recaptcha" data-sitekey="6Le8jQgaAAAAAJTJKh0nADqggMH6WjGDpmcwtXOe"></div>
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button type="button" id="Login" class="login100-form-btn">로그인</button>
					</div>

					<div class="searchuser" id="">
						<a href="" id="findIdPass" class="hiddenDiv" data-tiara-action-name="아이디/비밀번호찾기_링크">ID/비밀번호 찾기</a>
						<span class="hiddenDiv">|</span>
						<!-- Trigger the modal with a button -->
						<c:url value="teacher/signupView" var="tSignup"/>
						<a class="hiddenDiv" href="${tSignup}" id="findID" >회원가입</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script src="/js/admin/login/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="/js/admin/login/popper.js"></script>
	<script src="/js/admin/login/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="/js/admin/login/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="/js/admin/login/moment.min.js"></script>
	<script src="/js/admin/login/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="/js/admin/login/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="/js/admin/login/main.js"></script>
	<!--===============================================================================================-->
	<!-- JS -->
	<script src="/js/admin/signup/jquery.min.js"></script>
</body>
</html>