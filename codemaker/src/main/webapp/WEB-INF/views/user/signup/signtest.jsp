<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />

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
		
		if($("#checkbox").is(":checked") == false){
			alert("약관에 동의해 주세요.");
			return false;
		}
		
		//아이디 중복체크 했는지 여부
		if($("input[name='checked_id']").val()==''){
	        alert('아이디중복 확인을 해주세요.');
	        $("input[name='checked_id']").eq(0).focus();
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
			document.getElementById('idcheck').setAttribute('class','far fa-check-circle');
			document.getElementById('user_id').setAttribute('style','border-color: #4AB56A');
			$("#regex1").css("color", "#4AB56A");
		} else {
			document.getElementById('idcheck').setAttribute('class','fa fa-exclamation-circle');
			document.getElementById('user_id').setAttribute('style','border-color: red');
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
			var regex = /^[a-z][a-zA-Z0-9]{7,20}/;
			result = regex.test(idval);

			if (result) {
				document.getElementById('passcheck').setAttribute('class','far fa-check-circle');
				document.getElementById('user_pass').setAttribute('style','border-color: #4AB56A');
				$("#regex2").css("color", "#4AB56A");
			} else {
				document.getElementById('passcheck').setAttribute('class','fa fa-exclamation-circle');
				document.getElementById('user_pass').setAttribute('style','border-color: red');
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
			var regex = /^[가-힣]{2,5}$/;
			result = regex.test(vname);

			if (result) {
				document.getElementById('nmcheck').setAttribute('class','far fa-check-circle');
				document.getElementById('user_nm').setAttribute('style','border-color: #4AB56A');
				$("#regex3").css("color", "#4AB56A");
			} else {
				document.getElementById('nmcheck').setAttribute('class','fa fa-exclamation-circle');
				document.getElementById('user_nm').setAttribute('style','border-color: red');
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
				document.getElementById('phcheck').setAttribute('class','far fa-check-circle');
				document.getElementById('phone2').setAttribute('style','border-color: #4AB56A');
				$("#regex4").css("color", "#4AB56A");
			} else {
				document.getElementById('phcheck').setAttribute('class','fa fa-exclamation-circle');
				document.getElementById('phone2').setAttribute('style','border-color: red');
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
				document.getElementById('phcheck').setAttribute('class','far fa-check-circle');
				document.getElementById('phone3').setAttribute('style','border-color: #4AB56A');
				$("#regex5").css("color", "#4AB56A");
			} else {
				document.getElementById('phcheck').setAttribute('class','fa fa-exclamation-circle');
				document.getElementById('phone3').setAttribute('style','border-color: red');
				$("#regex5").css("color", "red");
				return false;
			}

			flag=false;
	})
	
	
	//id중복체크
	$('#idchk').on("click",function(){
		$("#idregex").html(""); //초기화
		
		$("input[name=checked_id]").val('y'); //중복체크 했는지 여부를  체크하기 위해
		
		userId = $("#user_id").val();
		
		var regex =/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/
			result = regex.test(userId);
		
		
		if(result){
			
		$.ajax({
			url : "${cp}/join/idchk",
			type : "post",
			dataType : "json",
			data : {"userId" : userId},
			success : function(data) {
				console.log('ddd');
				if (data == 1) {
					$("#idregex").html("중복된 아이디 입니다.");
					$("#idregex").css("color", "red");
				} else if (data == 0) {
					alert("사용가능한 아이디 입니다.");
					$("#idregex").css("color", "#4AB56A");
				}
			}
		}) // idchk
		
		
		}else{
			
			document.getElementById('idcheck').setAttribute('class','fa fa-exclamation-circle');
			document.getElementById('user_id').setAttribute('style','border-color: red');
			$("#regex1").css("color", "red");
		}
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
<style>
.signbox{
	margin: 73px 0px 0px 507px;
}
.signheader {
    border-bottom: 1px solid #e7e8ea;
    line-height: normal;
    width: 65%;
}
.p_desc {
    margin-top: 32px;
    color: #333;
    line-height: 2.8rem;
    font-size: 1.2rem;
}
.middlebox{
    display: table;
    border-top: 1px solid #e7e8ea;
    width: 65%;
}
.smallbox{
	display: table-row;
    box-sizing: border-box;
    transition: all .3s ease;
}
.smallbox_1{
	display: table-cell;
    padding: 21px 30px;
    vertical-align: middle;
    width: 210px;
    background-color: white;
    color: #323232;
    text-align: left;
    font-weight: bold;
    word-break: break-all;
    border-bottom: 1px solid #e7e8ea;

}
.smallbox_2{
    display: table-cell;
    padding: 21px 30px;
    vertical-align: middle;
    border-bottom: 1px solid #e7e8ea;
    color: #323232;
}
.field-input{
	width: 86%;
    height: 32px;
    padding: 0px 7px;
    border: 1px solid #e8e8ea;
    color: #323232;
    box-sizing: border-box;	
}
select {
    width: 170px;
    height: 32px;
    border: 1px solid #e7e8ea;
    border-radius: 0;
    text-indent: 10px;
    background: #fff;
}
.tel-input{
	width: 28%;
    height: 32px;
    padding: 0px 7px;
    border: 1px solid #e8e8ea;
    color: #323232;
    box-sizing: border-box;	
}
li{
	color:grey;
}
.checkcheck {
    border-bottom: 1px solid #e7e8ea;
    background: white;
    width: 65%;
    margin-top: 23px;
}

.qG4_EI5YvxOtVXEkmWG0V._2GJ-rsCTFRiQnW-Qk5Di_j .XCRfVqa80XhpTwZaFBFId._1bRM6EPoRiYNpMlknzO20z {
    opacity: 0.5;
 }

.qG4_EI5YvxOtVXEkmWG0V._2GJ-rsCTFRiQnW-Qk5Di_j .XCRfVqa80XhpTwZaFBFId._1_uy3nE-UsmWXNx6uZt7vx {
    background-color: #03D182;
    border-color: #03D182;
}
.qG4_EI5YvxOtVXEkmWG0V._2GJ-rsCTFRiQnW-Qk5Di_j .XCRfVqa80XhpTwZaFBFId {
    background-color: #787878;
    border-color: #787878;
    font-size: 16px;
    line-height: 20px;
    font-weight: normal;
    color: #fff;
    height: 53px;
    padding: 0 47px;
}
.qG4_EI5YvxOtVXEkmWG0V .XCRfVqa80XhpTwZaFBFId {
    margin: 0px;
    border: 1px solid #e7e8ea;
    color: #666;
    font-size: 18px;
    min-width: 150px;
    line-height: 57px;
    font-weight: bold;
    padding: 0 18px;
    text-decoration: none;
    display: inline;
    display: inline-table;
    display: inline-block;
    box-sizing: border-box;
}
.btnbox {
    margin: 18px 0px 20px 287px;
}
img{
	margin: 0px 0 8px 0;
}
#idchk {
    background-color: #005F86;
    border: 1px solid #e8e8ea;
    color: white;
    padding: 3px 3px 2px 3px;
}
</style>

<body>
<div class="signbox">
<div class="signheader">
<h2>회원가입</h2>
</div>
		<p class="p_desc">
			<i class="fas fa-angle-right"></i>&nbsp;CODEMAKER 회원가입을 진행합니다. 회원가입을 위해 필수 기본정보를 입력해주시고 약관에 동의해주세요.
		</p>
		
		
		<div class="largebox">
		<form method="POST" class="register-form" id="register-form" action="${cp}/join/insertUser" enctype="multipart/form-data">
			<div class="middlebox">
			
			<div class="smallbox"> 
					<div class="smallbox_1">
						<span>프로필사진</span>
					</div>
					<div class="smallbox_2">
						<div>
							<img id="pictureViewImg" style="width: 140px; height: 160px;"/>
							<div class="id-label">
								<label for="picture"></label>
								<input type="file" id="picture" name="file" accept=".gif, .jpg, .png" style="font-size: 12px;" />
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="smallbox"> 
					<div class="smallbox_1">
						<span>ID</span>
					</div>
					<div class="smallbox_2">
						<div>
						<input class="field-input" name="userId" id="user_id" placeholder="ID를 입력해주세요">
						<input type="hidden" name="checked_id" value="">
						<button id="idchk" type="button">중복체크</button>
						<span id="regex1" class="check"><i id="idcheck"></i></span><br>
						<span id="idregex" class="check"></span>
							<div class="id-label">
								<ul>
									<li>ID는 이메일형식으로 작성해주세요.</li>
								</ul>
							</div>
							<i class="xi-error-o"></i>
						</div>
					</div>
				</div>
				
				<div class="smallbox"> 
					<div class="smallbox_1">
						<span>비밀번호</span>
					</div>
					<div class="smallbox_2">
						<div>
						<input type="password" class="field-input" name="userPass" id="user_pass" placeholder="비밀번호를 입력해주세요">
							<span id="regex2" class="check"><i id="passcheck"></i></span>
							<div class="id-label">
								<ul>
									<li>비밀번호는 영소문자로 시작하는 8~20자로 입력해주세요.</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				<div class="smallbox"> 
					<div class="smallbox_1">
						<span>이름</span>
					</div>
					<div class="smallbox_2">
						<div>
						<input class="field-input" name="userNm" id="user_nm" placeholder="이름을 입력해주세요">
						<span id="regex3" class="check"><i id="nmcheck"></i></span>
							<div class="id-label">
								<ul>
									<li>이름은 한글 2-5글자로 입력해주세요.</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				<div class="smallbox"> 
					<div class="smallbox_1">
						<span>전화번호</span>
					</div>
					<div class="smallbox_2">
						<div>
						<select id="phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="019">019</option>
							<option value="016">016</option>
							<option value="017">017</option>
						</select>-
							<input class="tel-input" type="text"  id="phone2" size="4" placeholder="4자리" maxlength="4">-
							<input class="tel-input" type="text"  id="phone3" size="4" placeholder="4자리" maxlength="4">
							<input type ="hidden" name="userTel">
							<span id="regex4" class="check"><i id="phcheck"></i></span>
							<div class="id-label">
								<ul>
									<li>0-9까지의 숫자 3-4-4자리를 입력해주세요.</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
			
			
			<div class="checkcheck">
				<span><b>&nbsp;[개인정보 수집 및 이용에 대한 안내]</b></span>
				<div class="smallbox"> 
					<div class="smallbox_2">
						<div>
							<div class="id-label">
								<ul>
									<li>CODEMAKER는 다음의 목적을 위해 개인정보를 수집 및 이용합니다.</li>
									<li>[수집항목]</li>
									<li>아이디, 비밀번호, 이름, 연락처, 결제정보</li>
									<li>[수집목적]</li>
									<li>정보주체의 동의에 의한 정보수집</li>
									<li>[보유 및 이용기간]</li>
									<li>이용자 정보는 원칙적으로 개인정보의 처리목적이 달성되면 지체없이 파기합니다.</li>
									<li>[거부에 관한 사항]</li>
									<li>개인정보수집에 관한 동의 여부를 결정하실 수 있으며, 미 동의시 회원가입이 되지 않습니다.</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<input type="checkbox" id="checkbox">&nbsp;개인정보수집에 동의합니다.
			
		</div>

	<div class="qG4_EI5YvxOtVXEkmWG0V _2GJ-rsCTFRiQnW-Qk5Di_j _25YNwZVVXYHTJ8NN9EqsVI">
		<div class="btnbox">
			<button type="submit" name="signup" id="signup" class="XCRfVqa80XhpTwZaFBFId _1_uy3nE-UsmWXNx6uZt7vx _1bRM6EPoRiYNpMlknzO20z" >등록하기</button>
			<button type="button" class="XCRfVqa80XhpTwZaFBFId" onclick="location.href='/user/main'">취소</button>
		</div>
	</div>
	
</div>

</body>




