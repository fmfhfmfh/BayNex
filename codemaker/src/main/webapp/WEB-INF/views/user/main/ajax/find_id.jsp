<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/userFindId.css">
<div class="div3">
	<div class="schResulrBox">
		<div class="schResult">
			<div class="schResultCell">
				<p class="text">회원님의 아이디는 <span class="userid">${UserVO.userId}</span> 입니다
				</p>
			</div>
		</div>
	</div>
	<div class="addBoxArea">
		<div class="addBox">
			<span class="addBoxCell findPw">
				<a href="${cp}/user/findInfo?info=2" class="addAtag">
					<span>비밀번호 찾기</span>
				</a>	
			</span>
			<span class="addBoxCell login">
				<a href="${cp}/user/login" class="addAtag">
					<span style="color:white;">로그인</span>
				</a>	
			</span>
		</div>
	</div>
</div>