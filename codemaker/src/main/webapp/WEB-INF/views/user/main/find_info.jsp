<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
	<title>회원정보 찾기</title>
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
<!--===============================================================================================-->
<!-- 유저 정보 찾기 css -->
	<link rel="stylesheet" type="text/css" href="/css/userFindInfo.css">
</head>
<script>
$(function(){
// 	$("#findPw").hide();
	if(${param.info}==1){
		findIdShow();
	}else{
		findPwShow();
	}
	
	$("#findIdBtn").on('click',function(){
		$.ajax({
			type : 'post',
			url : '/user/findId',
			data : $("#findIdFrm").serialize(),
			dataType : 'html',
			error:function(xhr){
				alert(xhr);
			},
			success : function(res){
				$("#cng").html(res);
			}
		})
	})
	
	$("#findPwBtn").on('click',function(){
		$.ajax({
			type : 'post',
			url : '/user/findPw',
			data : $("#findPwFrm").serialize(),
			dataType : 'html',
			error:function(xhr){
				alert(xhr);
			},
			success : function(res){
				$("#cng").html(res);
			}
		})
	})
	
	$("#fPBtn").on('click',function(){
		$("#findIdFrm")[0].reset();
	})
	
	$("#fIBtn").on('click',function(){
		$("#findPwFrm")[0].reset();
	})
})

function findIdShow(){
	$("#last").attr('class','findLi lastCol addLine-b');
	$("#first").attr('class','findLi firstCol addLine');
	$("#fCId").css({
		color : "#007fb2",
		"font-weight" : "bold"
	})
	$("#fCPw").css({
		color : "black",
		"font-weight": "normal"
	})
	$("#findPw").hide();
	$("#findId").show();
}

function findPwShow(){
	$("#first").attr('class','findLi firstCol addLine-b');
	$("#last").attr('class','findLi lastCol addLine');
	$("#fCPw").css({
		color : "#007fb2",
		"font-weight" : "bold"
	})
	$("#fCId").css({
		color : "black",
		"font-weight": "normal"
	})
	$("#findPw").show();
	$("#findId").hide();
}
</script>
<body>
	
	<div class="limiter" style="background-color:#f4f4f4">
		<div class="container-login100" >
		<div id="di">
			<a href="${cp}/user/main"><img id="logo" src="/img/mj/로고 작업.png"/></a>
		</div>
			<div class="row" style="border:1px solid #ededed; padding:20px;background-color:white;">
				<div id="cng" class="div2">
					<div class="find">
						<ul>
							<li class="findLi firstCol" id="first">
								<button id="fIBtn" class="findAtag" type="button" onclick="findIdShow()">
									<span id="fCId">아이디 찾기</span>
								</button>
							</li>
							<li class="findLi lastCol" id="last">
								<button id="fPBtn" class="findAtag" type="button" onclick="findPwShow()">
									<span id="fCPw">비밀번호 찾기</span>
								</button>
							</li>
						</ul>
					</div>
					
					<div class="dropdown dropFind" id="findId"> <!-- 아이디 찾기 -->
						<span style="font-size:0.8em;">아이디 찾기 방법을 선택해주세요</span><br>
						<button type="button" class="button button4 hpClick dropdown-toggle" data-toggle="dropdown">등록된 휴대폰 번호로 찾기</button>
						<form action="" method="post" id="findIdFrm" >
							<div class="infoDiv dropdown-menu">
								<div class="form-group">
									<input class="form-control hpInfo certifi" name="userNm" type="text" placeholder="이름"/>
								</div>
								<div class="form-group tableFix">
									<input id="hp" class="form-control hpInfo" type="text" name="userTel" placeholder="휴대폰 번호 ('-'없이 입력)" />
									<button id="certiBtn" class="btn btn-light">인증번호 요청</button>
								</div>
								<div class="form-group">
									<input class="form-control hpInfo certifi" type="text" name="certi" placeholder="인증번호 (6자리)"/>
								</div>
								<div class="form-group">
									<input class="btn hpInfo certifi subBtn" id="findIdBtn" type="button" value="확인">
								</div>
							</div>
						</form>
					</div>
					
					<div class="dropdown dropFind" id="findPw"> <!-- 비밀번호 찾기 -->
						<span style="font-size:0.8em;">비밀번호 찾기 방법을 선택해주세요</span><br>
						<button type="button" class="button button4 hpClick dropdown-toggle" data-toggle="dropdown">등록된 휴대폰 번호로 찾기</button>
						<form action="" method="post" id="findPwFrm">
							<div class="infoDiv dropdown-menu">
								<div class="form-group">
									<input class="form-control hpInfo certifi" type="text" name="userId" placeholder="아이디" />
								</div>
								<div class="form-group">
									<input id="hp" class="form-control hpInfo" type="text" name="userTel" placeholder="휴대폰 번호 ('-'없이 입력)"/>
									<button class="btn btn-light">인증번호 요청</button>
								</div>
								<div class="form-group">
									<input class="form-control hpInfo certifi" type="text" name="certi" placeholder="인증번호 (6자리)"/>
								</div>
								<div class="form-group">
									<input class="btn hpInfo certifi subBtn" id="findPwBtn" type="button" value="확인">
								</div>
							</div>
						</form>
					</div>
					
					
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