<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="/css/user/signup/join-style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>

$(document).ready(function(){
$('#userOut').on("click", function(){
	console.log("클클릭");
	var flag=true;
	$.ajax({
		url : "${cp}/mypage/deleteUser",
		type : "post",
		dataType : "json",
		data : { userId : $('#userId').val(), userPass: $('#userPass').val()},
		async: false, //비동기식인 ajax를 동기식으로 설정
		success : function(res) {
			console.log("dd");
			if (res == "0") {
				alert("비밀번호를 다시 입력해 주세요");
				$('#userPass').val('');
				flag=false;
			} else {
				alert("회원탈퇴를 진행합니다.");
				location.href="${cp}/user/main";
			}
		}
	});
		return flag;
	})
});

</script>
<body>
<div class="formbox">
	<div class="xtop">
		<div class="headerbox">
		<img alt="logo" src="/img/mj/로고 작업.png" class="codemakerLogo">
		<p>&nbsp;&nbsp;&nbsp;회원 탈퇴를 진행하시겠습니까?</p>
		</div>
		<form class="formform">
			<p class="titleText">회원 ID</p>
			<div class="InteractiveInput">
				<input type="text" id="userId" name="userId" value="${MEMBER_INFO.userId}" READONLY><br><br>
			</div>
			<p class="titleText">비밀번호</p>
			<div class="InteractiveInput">
				<input type="password" id="userPass" name="userPass" placeholder="비밀번호를 입력해 주세요."><br>
			</div>
		</form>
		<div class="SignForm__submitBtnWrapper">
			<button id="userOut" class="ButtonGeneral SignForm__submitBtn ButtonGeneral__purple">
				<span>회원탈퇴</span>
			</button>
		</div>
	</div>
</div>
</body>

