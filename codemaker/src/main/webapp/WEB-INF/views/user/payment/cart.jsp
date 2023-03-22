<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/json/jquery.serialize-object.js"></script>
<link href="/css/user/cart/user-cart.css" rel="stylesheet" />
<% int sum =0; %>
<div class="cart-box">
<c:choose>
	<c:when test="${fn:length(lessonList) ==0}">
		<%@ include file="/WEB-INF/views/user/payment/empty_cart.jsp" %>
	</c:when>
	<c:when test="${fn:length(lessonList) > 0}">
		<div class="cartBoxArea">
			<h3>강의 장바구니</h3>
			<table>
				<thead id="thead">
					<tr>
						<th>
							<span>
								<input type="checkbox" id="allChk" data-toggle="1" />
								<label for="allChk"/>
							</span>
						</th>
						<th>강의명</th>
						<th>강사명</th>
						<th>수강기간</th>
						<th>금액</th>
					</tr>
				</thead>
				<c:url value="/user/payViewList" var="payViewList"/>
				<form id="frm" method="post" action="${payViewList}" name="frm">
					<input type="hidden" value="0" id="chkNum"/>
					<tbody id="tbody">
						<c:forEach items="${lessonList}" var="lesson" varStatus="stat">
							<input type="hidden" value="${lesson.lesTerm}" id="lesTerm[${stat.index}]" name="lessonList[${stat.index}].lesTerm" readonly="readonly" disabled="disabled"/>
							<c:set value="${lesson.lesTerm}" var="lesTerm"/>
							<%
								int lesTerm =(int)(pageContext.getAttribute("lesTerm")); 
								Date now = new Date();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
								Calendar cal = Calendar.getInstance();
								cal.setTime(now);
								cal.add(Calendar.DATE, lesTerm);
							%>
							<input type="hidden" value="${lesson.lesId}" id="lesId[${stat.index}]" name="lessonList[${stat.index}].lesId" disabled="disabled"/>
							<input type="hidden" value="${lesson.lesNm}" id="lesNm[${stat.index}]" name="lessonList[${stat.index}].lesNm" disabled="disabled"/>
							<input type="hidden" value="${lesson.tchNm}" id="tchNm[${stat.index}]" name="lessonList[${stat.index}].tchNm" disabled="disabled"/>
							<input type="hidden" value="${lesson.lesCash}" class="lesC" id="lesCash[${stat.index}]" name="lessonList[${stat.index}].lesCash" disabled="disabled"/>
							<tr class="lessonTr">
								<td class="chk">
									<div>
										<input type="checkbox" class="lesChk" id="chk[${stat.index}]" name="chk[${stat.index}]" data-cash="${lesson.lesCash}" data-lesId="${lesson.lesId}">
										<label class="chklbl" for="chk[${stat.index}]"></label>
									</div>
								</td>
								<td>
									<div class="tdCenter fBold">
										<span>${lesson.lesNm}</span>
									</div>
								</td>
								<td class="tdLine tdCenter">
									<div>
										<span>${lesson.tchNm}</span>
									</div>
								</td>
								<td class="tdLine tdCenter">
									<div class="tdinDiv">
										<em class="txt">
											<%= sdf.format(now) %> ~ <%= sdf.format(cal.getTime()) %>
										</em>
									</div>
								</td>
								<td class="tdCenter">
									<div>
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${lesson.lesCash}" var="lesCash"/>
										<em class="won txt fBold">${lesCash}<span class="won">원</span></em>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</form>
			</table>
			<div class="les-delete"><span onclick="deleteLes()">선택강의 삭제</span></div>
			<div id="price">
				<span class="total">총 상품금액</span>
				<span class="total">
					<em class="txt" id="cash">0</em>원
				</span>
			</div>
			<div id="btnDiv">
				<c:url value="/user/selectSubject" var="lessonPage"/>
				<a href="${lessonPage}" class="lessonPage">강의 페이지로</a>
				<button id="sub">결제하기</button>
			</div>
		</div>
	</c:when>
</c:choose>
</div>
<script>
function deleteLes(){
	var len = $(".lesChk").length;
	console.log("길이"+len);
	var param = [];
	for(i=0; i<len; i++){
		param.push($("#chk\\["+i+"\\]:checked").attr("data-lesId"));
	}
	console.log("데이터확인"+param);
	$.ajax({
		url : "/user/cartDelete",
		data : {"data" : param},
		traditional : true,
		success : function(res){
			location.href="/user/cartView";
		},error : function(xhr){
			console.log("실패" + xhr);
		}
	})
}
$(function(){
	var length = $(".lesChk").length;
	$("#sub").on('click',function(){
		for(i=0; i<length; i++){
			$("#chk\\["+i+"\\]:checked").each(function(){
				$("#lesId\\["+i+"\\]").attr('disabled',false);
				$("#lesTerm\\["+i+"\\]").attr('disabled',false);
				$("#lesNm\\["+i+"\\]").attr('disabled',false);
				$("#tchNm\\["+i+"\\]").attr('disabled',false);
				$("#lesCash\\["+i+"\\]").attr('disabled',false);
			})
		}
		$("#frm").submit();
	})
	
	var cc = 0;
	var length = 0;
	var count = 0;
	
	$(".lesChk").on('change',function(){
		length = $(".lesChk").length;
		count = $('.lesChk:checked').length;
		cash = 0;
		for(i=0; i<length; i++){
			$("#chk\\["+i+"\\]:checked").each(function(){
				cash += parseInt($(this).data("cash"));
			})
		}
		$("#cash").text(cash.toLocaleString());
		
		//하나씩 체크할때 모두 체크되거나 체크를풀때 전체선택체크창 비/활성화
		if(count == length){
			$("#allChk").prop("checked", true);
		}else{
			$("#allChk").prop("checked", false);
		}
	})
	
	$("#allChk").on('click', function(){
		if($(this).prop("checked")){
			$("input[type='checkbox']").prop("checked", true);
			length = $(".lesChk").length;
			cash = 0;
			for(i=0; i<length; i++){
				cash += parseInt($("#lesCash\\["+i+"\\]").val());
			}
			$("#cash").text(cash.toLocaleString());	
		}else{
			$("input[type='checkbox']").prop("checked", false);
				cash -= parseInt($("#lesCash\\["+i+"\\]").val());
			$("#cash").text(0);	
		}
	})
})
</script>