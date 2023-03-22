<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>회원로그인 페이지</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/user/login/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/fonts/user/login/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/fonts/user/login/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/user/login/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/vendor/user/login/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/user/login/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/user/login/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/vendor/user/login/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/user/login/util.css">
	<link rel="stylesheet" type="text/css" href="/css/user/login/main.css">
	<link rel="stylesheet" type="text/css" href="/css/user/login/userLogin.css">
<!--===============================================================================================-->
</head>
<style>
@font-face {
	font-family: 'LotteMartDream';
	font-style: normal;
	font-weight: 300;
	src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
#body, #body *{
	font-family: 'LotteMartDream';
}
</style>

<script>
$(function(){
	var msg = "${msg}";
	console.log(msg);
	if(msg == 'Y'){
		alert("탈퇴한 회원입니다");
	}else if(msg !=''){
		$("#msg-span").text(msg);
	}
	//눈 이미지 눌렀을때 비밀번호 보이게/안보이게 설정 , 기본값은 1-안보이게 2-보이게
	$("#chkToggle").on('click',function(){
		var flag = $(this).data("flag");
		if(flag==1){
			$("#userPass").attr('type','text');
			$(this).data("flag","2");
			$("#imgEye").attr('src','/img/icon/openEye.png')
		}else{
			$("#userPass").attr('type','password');
			$(this).data("flag","1");
			$("#imgEye").attr('src','/img/icon/closeEye.png')
		}
	})	
	var remem = $("#rememCookie").val();
	if(remem==1){
		var userid = $("#user").data("userid");
		$("input:checkbox[id='ckb1']").prop('checked',true);
		$("#userId").val(userid);
	}else{
		$("input:checkbox[id='ckb1']").prop('checked',false);
		$("#userId").val('');
	}
	console.log("저장된 유저아이디" + $("#user").data("userid"));
})
</script>
<body id="body">
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			Cookie c = cookies[i];
			URLDecoder.decode(c.getValue(),"UTF-8");
			String cValue = URLDecoder.decode(c.getValue(),"UTF-8");
			if(c.getName().equals("userid")){
				out.print("<input id='user' data-userid='"+cValue+"' type='hidden'/>");
			}
			if(c.getName().equals("remember")){
				out.print("<input type='hidden' id='rememCookie' value='"+cValue+"'/>");
			}
		}
	}
%> 
	<div class="limiter" style="background-color:#f4f4f4">
		<div class="container-login100" >
			<div id="di">
				<a class="loginlogo" href="${cp}/user/main"><img id="logo" src="/img/mj/로고 작업.png"/></a>
			</div>
			<div class="row" style="border:1px solid #ededed; padding:20px;background-color:white;">
				<div class="cldiv col-xs-3 wrap-login100 p-t-50 p-b-90" style="margin-right:10px;">
					<form class="login100-form validate-form flex-sb flex-w" action="${cp}/user/login" method="post">
						<span class="login100-form-title p-b-51">Login</span>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
							<input class="input100" type="text" id="userId" name="userId" placeholder="아이디">
							<span class="focus-input100"></span>
						</div>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required" style="height: 64px;">
							<div class="passBox">
								<input class="input100" type="password" name="userPass" id="userPass" placeholder="비밀번호">
								<span id="chkToggle" value="비밀번호 확인" data-flag="1">
									<img id="imgEye" src="/img/icon/closeEye.png" >
								</span>
<!-- 								<span class="focus-input100"></span> -->
							</div>
						</div>
						
						<div class="flex-sb-m w-full p-t-3 p-b-24">
							<div class="contact100-form-checkbox">
								<input class="input-checkbox100" id="ckb1" type="checkbox" name="rememberMe" value="1">
								<label class="label-checkbox100" for="ckb1">아이디 저장</label>
							</div>
							<div>
								<a href="${cp}/user/findInfo?info=1" class="txt1">아이디</a>•
								<a href="${cp}/user/findInfo?info=2" class="txt1">비밀번호찾기</a>
							</div>
						</div>
						<span id="msg-span" style="color:red;">
<%-- 						<c:if test="${param.msg !=null}">${param.msg}</c:if> --%>
						</span>
						<div class="container-login100-form-btn m-t-17">
							<button class="login100-form-btn" style="font-size: 21px;">
								코딩GO!
							</button>
						</div>
						<div style="margin:0 auto;">
							<a href="#"><img class="loginapi" src="/img/mj/네이버로그인.jpg"></a><br>
							<a href="#"><img class="loginapi" src="/img/mj/카카오로그인.jpg"></a>
						</div>
					</form>
				</div>
				
				<div class="cldiv col-xs-3 mb-4 wrap-login100 p-t-50 p-b-90" style="margin-left:5px;">
					<img src="/img/mj/로그인페이지사진.jpg"/>
				</div>
			</div>
		</div>
	</div>

	<div id="dropDownSelect1"></div>
<!--===============================================================================================-->
	<script src="/vendor/user/login/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/vendor/user/login/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/vendor/user/login/bootstrap/js/popper.js"></script>
	<script src="/vendor/user/login/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/vendor/user/login/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/vendor/user/login/daterangepicker/moment.min.js"></script>
	<script src="/vendor/user/login/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/vendor/user/login/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/js/user/login/main.js"></script>
</body>
</html>