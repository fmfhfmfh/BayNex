<%@page import="kr.co.codemaker.user.cart.vo.LessonVO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/css/user/cart/user-pay.css" rel="stylesheet" />   
<div class="payBoxArea">
	<h1>결제하기</h1>
	<div class="divide"></div>
	<c:url value="/user/pay" var="pay"/>
	<div class="row">
		<div class="col">
			<h3>결제내역</h3>
			<form action="${pay}" method="post" id="payFrm">
				<% int sum=0; %>
				<input type="hidden" id="paySum" name="paySum" value="${lessonVo.lesCash}"/>
				<input type="hidden" name="payWay" value="1"/>
				<input type="hidden" name="lesTerm" value="${lessonVo.lesTerm}"/>
				<input type="hidden" name="userId" value="${userVo.userId}"/>
				<input type="hidden" name="lesId" value="${lessonVo.lesId}" class="lesson"/>
				<c:set value="${lessonVo.lesTerm}" var="lesTerm"/>
				<c:set value="${lessonVo.lesCash}" var="lesCash"/>
				<%
					int lesTerm =(int)(pageContext.getAttribute("lesTerm")); 
					Date now = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					Calendar cal = Calendar.getInstance();
					cal.setTime(now);
					cal.add(Calendar.DATE, lesTerm);
					sum += (int)(pageContext.getAttribute("lesCash"));
				%>
				<div class="cont">
					<img src="/img/icon/cube.png">
					<div class="title">
						<h3>${lessonVo.lesNm}</h3>
					</div>
					<ul class="lessonInfo">
						<li><span>강사</span><b>${lessonVo.tchNm}</b></li>
						<li><span>수강기간</span><b><%=sdf.format(now)%> ~ <%= sdf.format(cal.getTime()) %></b></li>
						<fmt:formatNumber value="${lessonVo.lesCash}" var="lesCash" maxFractionDigits="3"/>
						<li><span>결제금액</span><b>${lesCash}원</b></li>
					</ul>
					<div class="logo">
						<img src="/img/icon/logo.png"/>
					</div>
				</div>
				
				<div class="row justify-content-center">
					<div class="payinfo row">
						<div class="buyer col-md-6 col-12">
							<h3>구매자 정보</h3>
							<div class="input-group"><span class="buyer-id">${userVo.userId}</span></div>
							<div class="info-point">
								<h3>포인트 결제</h3>
								<div class="point-box">
									<div class="point-group">
										<div class="point-div">
											<fmt:formatNumber value="${pointVo.pointSum}" var="havePoint" maxFractionDigits="3"/>
											<span>보유</span>
											<span class="have-point">${havePoint} P</span>
											<input type="hidden" id="havePoint" value="${pointVo.pointSum}"/>
										</div>
										<div>
											<span>사용</span>
											<span class="use-point"><input type="text" name="usePoint" id="usePoint"/> P</span>
										</div>
										<div id="point-btn">
											<input type="button" id="totalPointUse" value="전액사용"/>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="pay-method col-md-6 col-12">
							<h3>결제 수단</h3>
							<div class="payWayBoxArea form-group row">
								<div class="payWayBox col-sm-5" style="padding-right: 0px;">
									<div class="payB">
										<input class="pay-way" name="payWay" type="radio" id="kakaopay" value="kakaopay" />
										<label for="kakaopay">
											<img src="/img/icon/payment_icon_yellow_small.png">카카오페이
										</label>
									</div>
								</div>
								<div class="payWayBox col-sm-4">
									<div class="payB">
										<input class="pay-way" name="payWay" type="radio" id="creditcard" value="creditcard"/>
										<label for="creditcard">신용카드</label>
									</div>
								</div>
							</div>
							<div class="pay-information col">
								<div class="divider"></div>
								<h3 style="padding-top: .8em;">결제 정보</h3>
								<div class="cash-info row">
									<div class="col">정가</div>
									<div class="cash-info-text">
										<fmt:formatNumber value="<%=sum%>" var="sum" maxFractionDigits="3"/>
										<span id="sumVal">${sum}<i>원</i></span>
									</div>
								</div>
								<div class="cash-info row">
									<div class="col">포인트</div>
									<div class="cash-info-text">
										<span id="pay-info-point">0<i>&nbsp;P</i></span>
										<input type="hidden" id="pointSum" name="pointSum"/>
										<input type="hidden" id="pointUpdate" name="pointUpdate"/>
									</div>
								</div>
								<div class="cash-info row">
									<div class="pay-divide"></div>
									<div class="col">결제금액</div>
									<div class="cash-info-text">
										<span id="totalCash">${sum}<i>원</i></span>
									</div>
								</div>
								<div class="pay-check">
									<div class="pay-check-div">
										<input type="checkbox" id="terms1" name="agree1" class="agree"/>
										<label for="terms1">
											<p>
												<b>
													<a href="https://www.notion.so/470057a434ca4eefbf2e0599a2f9dd36" target="_blank">결제 및 환불 규정</a><!--  
												--></b><!-- 
												 -->에 동의합니다 (필수)
											</p>
										</label>
									</div>
									<div class="pay-check-div">
										<input type="checkbox" id="terms2" name="agree2" class="agree"/>
										<label for="terms2">
											<p>
												구매조건 확인 및 
												 	<b><!-- 
													 --><a href="https://www.notion.so/566609b9392542329ab99e1946f8e3f5" target="_blank">개인정보처리약관</a><!-- 
												 --></b><!-- 
												 -->에 동의합니다 (필수)
											</p>
										</label>
									</div>
								</div>
								<button type="button" id="payBtn" disabled="disabled">결제하기</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
$(function(){
	
	$("input[type=radio]").on('click',function(){
		$(this).attr('checked',true);	
	})
	
	$("#totalPointUse").on('click',function(){
		var haveP = parseInt($("#havePoint").val());//보유포인트
		var sumVal = parseInt($("#sumVal").text().replace(",",''));//상품 총 금액
		var sumValTrans = "";
		if(haveP > sumVal){//보유포인트가 상품금액보다 클때
			sumValTrans = sumVal.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#usePoint").val(sumValTrans);//사용포인트를 상품금액으로 변경
			$("#pay-info-point").text(sumValTrans+" P");//결제정보 포인트 텍스트를 변경
			var	pointInfo = parseInt($("#usePoint").val().replace(",",''));//사용포인트를 int로변경
			var op = (sumVal - pointInfo).toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#totalCash").text(op+" 원");
			$("#paySum").val(0);
		}else{
			havePTrans = haveP.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#usePoint").val(havePTrans);
			$("#pay-info-point").text(havePTrans+" P");//결제정보 포인트 텍스트를 변경
			var	pointInfo = parseInt($("#usePoint").val().replace(",",''));//사용포인트를 int로변경
			var op = (sumVal - pointInfo).toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#totalCash").text(op+" 원");
			paySum = parseInt($("#totalCash").text().replace(',',''));
			$("#paySum").val(paySum);
		}
	})
	
	$("#usePoint").on('keyup',function(){
		$(this).val($(this).val().replace(/^0/g,""));
		$(this).val($(this).val().replace(/[^0-9]/g,""));
		var point = $(this).val().toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
		var haveP = parseInt($("#havePoint").val());
		var useP = $(this).val();
		var sumVal = parseInt($("#sumVal").text().replace(",",''));
		$("#pay-info-point").text(point+" P");
		
		if(useP =='' || useP == null){
			sumVal = sumVal.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#pay-info-point").text("0 P");
			$("#totalCash").text(sumVal+" 원");
			return false;
		}
		
		if(this.value > haveP){
			alert("보유 포인트 이상 사용은 불가능합니다");
			$(this).val(haveP);
			getHave = haveP.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#pay-info-point").text(getHave+" P");
		}
		
		if(this.value > sumVal){
			$(this).val(sumVal);
			sum = sumVal.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
			$("#pay-info-point").text(sum+" P");
		}
		
		var	pointInfo = parseInt($("#pay-info-point").text().replace(",",''));
		var op = (sumVal - pointInfo).toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
		$("#totalCash").text(op+" 원");
		paySum = parseInt($("#totalCash").text().replace(',',''));
		$("#paySum").val(paySum);
	})
	
	$("#usePoint").on('focus',function(){
		$(this).val($(this).val().replace(/[^\d]+/g,''));
	})
	
	$("#usePoint").on('blur',function(){
		$(this).val($(this).val().replace(/\B(?=(\d{3})+(?!\d))/g,","));
	})
	
	$(".agree").on('change',function(){
		if($("#terms1").prop('checked') && $("#terms2").prop('checked')){
			$("#payBtn").attr('disabled',false);
		}else{
			$("#payBtn").attr('disabled',true);
		}
	})
		
	$(".pay-way").on('click',function(){
		console.log($(this).val());
	})
	
	//결제버튼 클릭시 발생
	$("#payBtn").on('click',function(){
		var payWay = $("input[type=radio]:checked").val();
		var pointUpdate = parseInt($("#pay-info-point").text().replace(',',''));
		$("#pointUpdate").val(pointUpdate);
		var pointSum = parseInt($(".have-point").text().replace(',',''));
		$("#pointSum").val(pointSum);
		if(payWay == "kakaopay"){
			var total = parseInt($("#totalCash").text().replace(',',''));
			console.log("가격"+total);
			$.ajax({
				url : '/kakaoPay',
				data : {"total" : total},
				method : 'post',
				success : function(res){
					if(res.url !=null){
						window.open(res.url,"_blank","width=550,height=750,left=658,top=161");
					}
				}
			})
		}else{
			$("#payFrm").submit();
		}
	})
})
function sumbitTest(){
	$("#payFrm").submit();
}
</script>
