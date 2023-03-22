<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/userFindPw.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$(".inFocus").on('focus',function(){
		$(this).prev().css('visibility','hidden');
	})
	
	$(".inFocus").on('blur',function(){
		if($("#userPass1").val() == null || $("#userPass1").val() ==''){
		    $("#userPass1").prev().css('visibility','visible');
		}else{
		    $("#userPass1").prev().css('visibility','hidden');
		};
		
		if($("#userPass2").val() == null || $("#userPass2").val() ==''){
		    $("#userPass2").prev().css('visibility','visible');
		}else{
		    $("#userPass2").prev().css('visibility','hidden');
		};
	})
	
	$("#userPass2").on('keyup',function(){
		var pass1 = $("#userPass1").val();
		var pass2 = $("#userPass2").val();
		console.log(pass1 , pass2);
		if(pass1 == pass2){
			$("#pass2").text("비밀번호가 일치합니다").css('color','blue');
		}else{
			$("#pass2").text("비밀번호가 일치하지 않습니다").css('color','red');
		}
	})
})
function submit(userid){
	var pass1 = $("#userPass1").val();
	var pass2 = $("#userPass2").val();
	if(pass1 == pass2){
		cngFrm.submit();
	}else{
		alert("비밀번호를 확인해주세요");
		return false;
	}
}
</script>
<div class="div3">
	<div class="cngResulrBox">
		<div class="cngResult">
			<div class="cngBox">
				<span class="cngSpan">
					<form id="cngFrm" action="${cp}/user/changePw" method="post">
						<label for="userPass1" class="lp1">
							새 비밀번호 &nbsp;<em class="textS">사용하실 비밀번호</em>
						</label>
						<input class="inFocus" class="" id="userPass1" type="password" name="userPass"/>
						<input name="userId" type="hidden" value="${UserVO.userId}"/>
					</form>
				</span>
			</div>
			<span id="pass1"></span>
			<div class="cngBox mar">
				<span class="cngSpan">
					<label class="lp1" for="userPass2">
						새 비밀번호 재입력 &nbsp; <em class="textS">확인을 위해 재입력해 주세요</em>
					</label>
					<input class="inFocus" id="userPass2" type="password" name="userPass"/>
				</span>
			</div>
			<span id="pass2"></span>
			<div class="cngBox mar" style="background-color: #005f86;">
				<a onclick="submit()">
					<span class="cngSpan">
						<em class="txt">변경완료</em>
					</span>
				</a>
			</div>
		</div>
	</div>
</div>