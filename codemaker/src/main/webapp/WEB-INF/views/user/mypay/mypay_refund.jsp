<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<script>
$(function(){
	$("#refundBtn").on("click", function(){
		
		if($("#checkcheck").is(":checked") == false){
			alert("약관에 동의해 주세요.");
			return false;
		}
		
		var payId= $("#payId").text();
		var paySum = $("#paySum").text();
		

			$.ajax({
				url : "/mypage/payRefund",
				type : "post",
				dataType : "json",
				data : { payId : payId, paySum : paySum},
				success : function(res) {
					if(res=="1"){
						alert("환불이 완료되었습니다.");
						// 부모창 리로드
						opener.location.reload();
						window.close();
					}		
				}
			}); //
		})

});

</script>
<style>
.paycontainer{
	background-color: white;
}
.paybox{
	background-color:#005F86;
    width: 450px;
    height: 50px;
}
p {
    color: white;
    font-size: 23px;
    font-weight: 600;
    text-align: center;
    padding: 5px;
}
.listbox{
	background-color: #e1e4e833;
    border: 1px solid #cbcdd2;
    height: 513px;
    margin: 28px 15px 0px 15px;
}
.title {
	text-align: center;
    display: inline-block;
    background-color: #1a346b;
    color: white;
    width: 130px;
    height: 28px;
    margin: 12px 0px 1px 32px;
}
.refundCheck {
    margin: 20px 0px 18px 22px;
}
input#refundBtn {
    margin: 1px 0 11px 351px;
}

</style>
<body>
<div class="paycontainer">
<div class="paybox">
	<p>강의 환불</p>
	</div>
	<div class="listbox">
	<table>
		<tbody id="mypayVo">
				<tr>
					<td><span class="title">결제ID</span></td>
					<td><span id="payId">${mypayVo.payId }</span></td>
				</tr>
				<tr>
					<td><span class="title">강의명</span></td>
					<td>${mypayVo.lesNm}</td>
				</tr>
				<tr>
					<td><span class="title">결제일</span></td>
					<td><fmt:formatNumber value="${mypayVo.paySum }"></fmt:formatNumber></td>
				</tr>
				<tr>
					<td><span class="title">결제방식</span></td>
					<td>${mypayVo.payWay }</td>
				</tr>
				<tr>
						<td><span class="title">결제금액</span></td>
					<td><span id="paySum">${mypayVo.paySum }</span></td>
				</tr>
		</tbody>
	</table>
		<div class="refundCheck">
			<input type="checkbox" name="checkcheck" id="checkcheck">&nbsp;<b>약관동의</b><br>
			<span><b>환불 안내</b></span><br>
			<span><i class="fa fa-exclamation-circle"></i>&nbsp;CODEMAKER의 모든 강의는 환불 시 포인트 적립으로 환불됩니다.</span><br>
			<span><i class="fa fa-exclamation-circle"></i>&nbsp;강의 결제 후 수강진행을 시작한 강의는 환불할 수 없습니다.</span><br>
			<span><i class="fa fa-exclamation-circle"></i>&nbsp;강의 결제 후 수강진행을 시작하지 않은 강의는 위약금 없이 100% 환불 가능합니다.</span>
		</div>
			<input type="button" id="refundBtn" value="환불">
	</div>
</div>


</body> 