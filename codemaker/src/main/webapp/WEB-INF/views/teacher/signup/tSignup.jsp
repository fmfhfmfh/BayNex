<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>선생님 회원가입</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/teacher/signup/tSignup.css">
<link rel="stylesheet" type="text/css" href="/css/teacher/signup/tSignupForm.css">
<body class="bg-default" style="background-color:#212a39 !important;">
<div class="main-content">
	<!-- Header -->
	<div class="header bg-primary py-7 py-lg-8">
	</div>
	<!-- Page content -->
	<div class="pCnt container mt--8 pb-5">
		<!-- Table -->
		<div class="row justify-content-center" style="display:table;table-layout:fixed;">
			<div class="headmsg">
				<h1 style="text-align:center;">선생님 가입</h1>
			</div>
			<div class="col-lg-6 col-md-8">
				<div class="card bg-secondary shadow border-0">
					<div class="divC card-header bg-transparent pb-5">
						<div class="text-muted text-center mt-2 mb-4" style="margin-top: 10px;"><small style="font-size:120%;">회원가입</small></div>
					</div>
					<div class="card-body px-lg-5 py-lg-5">
						<c:url value="/teacher/signup" var="signup"/>
						<form:form action="${signup}" id="frm" commandName="teacherVO" method="post" enctype="multipart/form-data">
							<div class="bigBox">
								<div class="form-group marginB">
									<div style="width:70%;">
										<div class="input-group input-group-alternative">
											<div class="input-group-prepend" style="width:15%;">
												<span class="input-group-text"><i class="ni ni-email-83"></i></span>
											</div>
											<div class="cB1" style="width:85%;">
												<form:input path="tchId" id="tchId" cssClass="form-control" placeholder="아이디(4~20자리)"/>
												<input type="hidden" id="idHidden" value="no"/>
											</div>
										</div>
									</div>
									<div class="cB2" style="width:30%;">
										<button class="btn btn-light chkBtn" style="padding:0;" type="button" onclick="idChk()">아이디 중복체크</button>
									</div>
								</div>
								<div class="text-muted font-italic"><small id="tchIdMsg"></small></div>
							</div>
							
							<div class="bigBox">
								<div class="form-group marginB">
									<div class="input-group input-group-alternative">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
										</div>
										<form:password path="tchPass" id="tchPass" placeholder="비밀번호(영문자 8~20자리)" cssClass="form-control"/>
										<input type="hidden" id="passHidden" />
										<span id="chkToggle" value="비밀번호 확인" data-flag="1">
											<img id="imgEye" src="/img/icon/closeEye.png" >
										</span>
									</div>
								</div>
								<div class="text-muted font-italic"><small id="tchPassMsg"></small></div>
							</div>
							
							<div class="bigBox">
								<div class="form-group marginB">
									<div class="input-group input-group-alternative">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
										</div>
										<input type="password" class="form-control" placeholder="비밀번호 확인" id="chkPass">
										<input type="hidden" id="chkPassHidden" />
									</div>
								</div>
								<div class="text-muted font-italic"><small id="chkPassMsg"></small></div>
							</div>
							
							<div class="form-group crtDiv">
								<label for="resCode" class="fontCl">가입인증코드</label>
								<div class="certiBox" style="display:flex;">
									<div class="input-group input-group-alternative cB1" style="width:70%;">
										<form:input path="tchCode" id="resCode" placeholder="인증코드(5자리)" cssClass="form-control" cssStyle="width:100%;"/>
									</div>
									<div class="cB2">
										<button id="crtBtn" class="btn btn-light" type="button" onclick="codeChk()">인증코드 확인</button>
										<input type="hidden" id="chkCode" value=""/>
									</div>
								</div>
							</div>
							<label for="tchIntro" class="fontCl">소개말(강사소개시 보여지는 문구입니다)</label>
							<div class="form-group">
								<form:textarea path="tchIntro" id="tchIntro" rows="3" cols="30"/>
							</div>
							<div class="text-center">
								<button onclick="subFrm()" type="button" class="btn btn-primary mt-4">가입하기</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<script>
function codeChk(){
	var resCode = $("#resCode").val();
	$.ajax({
		url : "/teacher/chkResCode",
		data : {resCode : resCode},
		method : "get",
		dataType : "json",
		success : function(data){
			var msg = data.chkMsg; 
			if(msg == "success"){
				alert("확인되었습니다");
				$("#chkCode").val("1");
			}
		},
		error : function(xhr){
				alert("미승인상태이거나 존재하지 않습니다");
		}
	})
}

function idChk(){
	var tchId = $("#tchId").val();
	$.ajax({
		url : "/teacher/chkId",
		data : {tchId : tchId},
		method : "post",
		dataType : "json",
		success : function(data){
			$("#tchIdMsg").text(data.msg).css("color",data.color);
			if(data.pass == "ok"){
				$("#idHidden").val(data.pass);
			}else{
				$("#idHidden").val(data.pass)
			}
		},
		error : function(xhr){
			alert("에러" + xhr);
		}
		
	})
}

function subFrm(){
// 	var frmCont = $("#frm").serialize();
	var code = $("#chkCode").val();
	if($("#idHidden").val()=="no"){
		$("#tchId").focus();
		alert("아이디 중복체크를 해주세요");
		return false;
	}
	if($("#chkPassHidden").val() != $("#passHidden").val()){
		alert("비밀번호를 확인해주세요");
		$("#passHidden").focus();
		return false;
	}
	if(code != 1){
		alert("인증코드를 확인해주세요");
		$("#resCode").focus();
		return false;
	}
	
	$("#frm").submit();
}

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#pictureViewImg').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

$(function(){
	//눈 이미지 눌렀을때 비밀번호 보이게/안보이게 설정 , 기본값은 1-안보이게 2-보이게
	$("#chkToggle").on('click',function(){
		var flag = $(this).data("flag");
		if(flag==1){
			$("#tchPass").attr('type','text');
			$(this).data("flag","2");
			$("#imgEye").attr('src','/img/icon/openEye.png')
		}else{
			$("#tchPass").attr('type','password');
			$(this).data("flag","1");
			$("#imgEye").attr('src','/img/icon/closeEye.png')
		}
	})	
	
	// picture input의 파일 변경시 이벤트 
	$("#picture").change(function() {
		readURL(this);
	});
	
	$("#tchId").on('keyup',function(){
		var idReg = RegExp(/[a-z]/gi);
		var id = $("#tchId").val();
		if(!idReg.test(id) || id.length <4){
			$("#tchIdMsg").text("영문자 6~20자리로 입력해주세요").css("color","red");
			return;
		}else{
			$("#tchIdMsg").text("");
		}
	})
	
	$("#tchPass").on('keyup',function(){
		var passReg = RegExp(/[a-z]/gi);
		var pass = $("#tchPass").val();
		pass2 = $("#chkPass").val();
		if(!passReg.test(pass) || pass.length <8){
			$("#tchPassMsg").text("영문자 8~20자리로 입력해주세요").css("color","red");
			$("#passHidden").val("no");
		}else{
			$("#tchPassMsg").text("사용가능한 비밀번호 입니다").css("color","blue");
			$("#passHidden").val("ok");
		}
		
		if(pass != pass2){
			$("#chkPassMsg").text("비밀번호가 다릅니다").css("color","red");
			$("#chkPassHidden").val("no");
		}else{
			$("#chkPassMsg").text("비밀번호가 일치합니다").css("color","blue");
			$("#chkPassHidden").val("ok");
		}
	})
	
	$("#chkPass").on('keyup',function(){
		pass1 = $("#tchPass").val();
		pass2 = $("#chkPass").val();
		if(pass1 != pass2){
			$("#chkPassMsg").text("비밀번호가 다릅니다").css("color","red");
			$("#chkPassHidden").val("no");
		}else{
			$("#chkPassMsg").text("비밀번호가 일치합니다").css("color","blue");
			$("#chkPassHidden").val("ok");
		}
	})
	
})
</script>