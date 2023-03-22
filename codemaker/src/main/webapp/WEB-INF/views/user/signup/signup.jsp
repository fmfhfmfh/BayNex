<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Font Icon -->
<link rel="stylesheet" href="/fonts/user/signup/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="/css/user/signup/style.css">

<script>

var result = ""; 

$(document).ready(function(){
	// picture input의 파일 변경시 이벤트 
	$("#picture").change(function(){
	   readURL(this);
	});
	
	$("#signup").on("click",function(){

		var phone4 = $("#phone1").val();
		phone4+= $("#phone2").val();
		phone4+= $("#phone3").val();
		
		$("input[name='userTel']").val(phone4);

// 		$("#register-form").submit();
		

		if($("#picture").val()==""){
			alert("프로필사진을 첨부해주세요.");
			$("#picture").focus();
			return false;
		}
		if($("#user_id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#user_id").focus();
			return false;
		}
		
		
		if($("#user_pass").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#user_Pass").focus();
			return false;
		}
		if($("#user_nm").val()==""){
			alert("성명을 입력해주세요.");
			$("#user_nm").focus();
			return false;
		}
		if($("#phone2").val()==""){
			alert("휴대폰 번호를 입력해주세요.");
			$("#phone2").focus();
			return false;
		}
		if($("#phone3").val()==""){
			alert("휴대폰 번호를 입력해주세요.");
			$("#phone3").focus();
			return false;
		}
		
		
		//정규식 <span> 태그에 텍스트가 존재하면 등록안되게 하기
		if($(".check").text()!=""){
			alert("형식에 맞게 입력해 주세요.")
			return false;
		}
		else{
			$("#register-form").submit();
		}

	});

	//id 정규식
	$('#user_id').on('keyup',function() {
		idval = $(this).val();

		// 아이디 유효성 검사
		// 이메일형식
		var regex =/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/
		result = regex.test(idval);

		if (result) {
			$("#regex1").html("");
		} else {
			$("#regex1").html("email 형식에 맞게 입력해주세요.");
			$("#regex1").css("color", "red");
			return false;
		}

		flag=false;
	})

	// 비밀번호 정규식
	$('#user_pass').on('keyup',function() {
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

			flag=false;
	})
	
	// 이름 정규식
	$('#user_nm').on('keyup',function() {
			vname = $(this).val();

			// 이름 유효성 검사
			// 한글로만 2~5사이 입력
			var regex = /[가-힣]{2,6}/;
			result = regex.test(vname);

			if (result) {
				$("#regex3").html("");
			} else {
				$("#regex3").html("한글 2-5글자로 입력해주세요.");
				$("#regex3").css("color", "red");
				return false;
			}

			flag=false;
	})
	
	// 전화번호 정규식1
	$('#phone2').on('keyup',function() {
			idval = $(this).val();

			// 전화번호 유효성 검사
			// 가운데 전화번호 4자리 
			var regex =  /[0-9]{4}/;
			result = regex.test(idval);

			if (result) {
				$("#regex4").html("");
			} else {
				$("#regex4").html("0-9까지의 숫자 4자리를 입력해주세요.");
				$("#regex4").css("color", "red");
				return false;
			}

			flag=false;
	})
	
	// 전화번호 정규식2
	$('#phone3').on('keyup',function() {
			idval = $(this).val();

			// 전화번호 유효성 검사
			// 마지막 전화번호 4자리 
			var regex =  /[0-9]{4}/;
			result = regex.test(idval);

			if (result) {
				$("#regex4").html("");
			} else {
				$("#regex4").html("0-9까지의 숫자 4자리를 입력해주세요.");
				$("#regex4").css("color", "red");
				return false;
			}

			flag=false;
	})
	
	
	//id중복체크
	$('#idchk').on("click",function(){
		
		userId = $("#user_id").val();
		
		$.ajax({
			url : "${cp}/join/idchk",
			type : "post",
			dataType : "json",
			data : {"userId" : userId},
			success : function(data) {
				console.log('ddd');
				if (data == 1) {
					$("#regex1").html("중복된 아이디 입니다.");
				} else if (data == 0) {
					alert("사용가능한 아이디입니다.");
				}
			}
		}) // idchk
	})

});


function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
	  
		reader.onload = function (e) {
			$('#pictureViewImg').attr('src', e.target.result);  
		}
		reader.readAsDataURL(input.files[0]);
	}
}

</script>
</head>
<style>
#phone1 {
	width: 65px;
}

#phone2 {
	width: 95px;
	display: inline-block;
}

#phone3 {
	width: 95px;
	display: inline-block;
}

#signimg {
	display: inline-block;
	height: 350px;
	width: 300px;
}
</style>


<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">
							CODE MAKER<br> 회원가입
						</h2>
						<form method="POST" class="register-form" id="register-form"
							action="${cp}/join/insertUser" enctype="multipart/form-data">

							<div class="input-group mb-3">
								<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
									<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 100px; width: 100px; margin: 0 auto;">
										<img id="pictureViewImg" style="width: 100%; height: 100%;" />
									</div>
									<div class="mailbox-attachment-info">
										<div class="input-group input-group-sm">
											<input id="picture" class="form-control" type="file" name="file" accept=".gif, .jpg, .png" style="height: 37px" />
										</div>
									</div>
								</div>
								<br/>
							</div>

							<input type="hidden" name="userOut">
							<input type="hidden" name="userBlack">
							
							<div class="form-group">
                                <label for="userid"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="userId" id="user_id"  placeholder="ID"/><button id="idchk" type="button">중복체크</button>
                                <br><span id="regex1" class="check"></span>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label><br>
                                <input type="password" name="userPass" id="user_pass" placeholder="Password"/>
                                <br><span id="regex2" class="check"></span>
                            </div>

                             <div class="form-group">  
                              <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label><br>
                                <input type="text" name="userNm" id="user_nm" placeholder="Name"/>
                                <br><span id="regex3" class="check"></span>
                            </div>
                            <div class="form-group">
                              <label for="tel"></label>
								<i class="zmdi zmdi-account material-icons-name"></i>&nbsp;&nbsp;
								<select id="phone1" >
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="019">019</option>
										<option value="019">016</option>
										<option value="019">017</option>
								</select>-
									<input type="text"  id="phone2" size="4" placeholder="4자리" maxlength="4">-
									<input type="text"  id="phone3" size="4" placeholder="4자리" maxlength="4">
									<input type ="hidden" name="userTel">
									<br><span id="regex4"  class="check"></span>
								<br>
							</div>
							
							<div class="form-group">
								<dt>
									가입하면 <strong>이용 약관</strong> 및 <strong>개인정보</strong> 수집 및 활용에
									&nbsp;&nbsp;<strong>동의</strong>하게 됩니다.
								</dt>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img id="signimg" src="/images/signmain.PNG" alt="sing up image">
						</figure>
					</div>
				</div>
			</div>
		</section>


	</div>

	<!-- JS -->
	<script src="/vendor/user/signup/jquery/jquery.min.js"></script>
	<script src="/js/user/signup/main.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>