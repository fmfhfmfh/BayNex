<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
.joinbox{
	margin: 73px 0px 0px 507px;
}
.signheader {
    border-bottom: 1px solid #e7e8ea;
    line-height: normal;
    width: 65%;
}
.finishbox {
    background: white;
    width: 65%;
    height: 500px;
    margin: 69px 0 110px 0px;
    text-align: center;
}
.checkimg {
    width: 104px;
    margin: 82px 0 11px 0%;
}
.a_class {
    font-size: 26px;
}
button.finishLogin {
    width: 130px;
    height: 49px;
    background-color: #005F86;
    color: white;
}
button.finishHome {
    width: 130px;
    height: 49px;
    background-color: #808080f2;
    color: white;
}
.finishBtn {
    margin: 55px 0 0 0px;
}
</style>

<body>
<div class="joinbox">
	<div class="signheader">
		<h2>가입완료</h2>
	</div>

	<div class="finishbox">
		<img class="checkimg" src="/images/user/icons/check.png"><br>
		<br> <span class="a_class">회원가입이 <b>완료</b> 되었습니다.
		</span> <br> <span>CODEMAKER의 가입을 진심으로 환영합니다.</span>

		<div class="finishBtn">
			<button class="finishLogin" onclick="location.href='/user/login'">로그인</button>
			<button class="finishHome" onclick="location.href='/user/main'">홈으로</button>
		</div>
	</div>
	
</div>
</body>
