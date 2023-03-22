<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>장학금 관리</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script>
$(function(){
	if('${scholarshipVO.searchGn}' == '1'){
		findPwShow();
	}else{
		findIdShow();
	}
	
	$('#fIBtn').on('click', function(){
		findIdShow();
	});
	
	$('#fPBtn').on('click', function(){
		findPwShow();
	});
	
	// 과목 검색 조건 - 장학금 지급할 내역
	$('#searchSubject').on('change', function(){
		$('#schof').submit();
	});
	
	// 과목 검색 조건 - 장학금 지급한 내역
	$('#searchASubject').on('change', function(){
		var str = '<input type="hidden" name="searchGn" value="1">';
		$('#schof').append(str);
		
		$('#schof').submit();
	});
	
	// 수강중인 회원 상세 조회
	$('.total').on('click', function(){
		if($(this).text() != '0'){
			var lesId = $(this).parents('tr').data('lesid');
			var str = '<input type="hidden" name="lesId" value="'+ lesId +'">';
			str += '<input type="hidden" name="curGn" value="1">';
			$('#schof').append(str);
			
			$('#schof').attr('action', '/scholarship/selectCurAllLesson');
			$('#schof').submit();
		}else{
			alert('데이터가 없습니다.');			
		}
		
	});
	
	// 완강 회원 상세 조회
	$('.lescnt').on('click', function(){
		if($(this).text() != '0'){
			var lesId = $(this).parents('tr').data('lesid');
			var str = '<input type="hidden" name="lesId" value="'+ lesId +'">';
			str += '<input type="hidden" name="curGn" value="2">';
			$('#schof').append(str);
			
			$('#schof').attr('action', '/scholarship/selectLessonScholarship');
			$('#schof').submit();
		}else{
			alert('데이터가 없습니다.');			
		}
	});
	
	// 시험 완료 회원 상세 조회
	$('.examcnt').on('click', function(){
		if($(this).text() != '0'){
			var lesId = $(this).parents('tr').data('lesid');
			var str = '<input type="hidden" name="lesId" value="'+ lesId +'">';
			$('#schof').append(str);
			
			$('#schof').attr('action', '/scholarship/selectExamScholarship');
			$('#schof').submit();
		}else{
			alert('데이터가 없습니다.');			
		}
	});
	
	// 완강 장학금 지급 회원 상세 조회
	$('.lesPayCnt').on('click', function(){
		if($(this).text() != '0'){
			var lesId = $(this).parents('tr').data('lesid');
			var str = '<input type="hidden" name="lesId" value="'+ lesId +'">';
			str += '<input type="hidden" name="searchGn" value="1">';
			str += '<input type="hidden" name="curGn" value="4">';
			$('#schof').append(str);
			
			$('#schof').attr('action', '/scholarship/selectLessonPayScholarship');
			$('#schof').submit();
		}else{
			alert('데이터가 없습니다.');			
		}
	});
	
	// 시험 장학금 지급 회원 상세 조회
	$('.examPayCnt').on('click', function(){
		if($(this).text() != '0'){
			var lesId = $(this).parents('tr').data('lesid');
			var str = '<input type="hidden" name="lesId" value="'+ lesId +'">';
			str += '<input type="hidden" name="searchGn" value="1">';
			str += '<input type="hidden" name="curGn" value="5">';
			$('#schof').append(str);
			
			$('#schof').attr('action', '/scholarship/selectExamPayScholarship');
			$('#schof').submit();
		}else{
			alert('데이터가 없습니다.');			
		}
	});
	
	// 총 지급 회원 상세 조회
	$('.totalPay').on('click', function(){
		if($(this).text() != '0'){
			var lesId = $(this).parents('tr').data('lesid');
			var str = '<input type="hidden" name="lesId" value="'+ lesId +'">';
			str += '<input type="hidden" name="searchGn" value="1">';
			str += '<input type="hidden" name="curGn" value="6">';
			str += '<input type="hidden" name="totalPay" value="' + $(this).text() + '">';
			$('#schof').append(str);
			
			$('#schof').attr('action', '/scholarship/selectTotalPayScholarship');
			$('#schof').submit();
		}else{
			alert('데이터가 없습니다.');			
		}
	});
	
	
	
})

function findIdShow(){
	$("#last").attr('class','findLi lastCol addLine-b');
	$("#first").attr('class','findLi firstCol addLine');
	$("#fCId").css({
		color : "#007fb2",
		"font-weight" : "bold"
	})
	$("#fCPw").css({
		color : "black",
		"font-weight": "normal"
	})
	$('#inschl').attr('style', 'display: block;');
	$('#outschl').attr('style', 'display: none;');
	$('#searchSubject').attr('style', 'display: block;');
	$('#searchASubject').attr('style', 'display: none;');
}

function findPwShow(){
	$('#inschl').attr('style', 'display: none;');
	$('#outschl').attr('style', 'display: block;');
	$('#searchSubject').attr('style', 'display: none;');
	$('#searchASubject').attr('style', 'display: block;');
	
	$("#first").attr('class','findLi firstCol addLine-b');
	$("#last").attr('class','findLi lastCol addLine');
	$("#fCPw").css({
		color : "#007fb2",
		"font-weight" : "bold"
	})
	$("#fCId").css({
		color : "black",
		"font-weight": "normal"
	})
}
</script>
<style>
.abtn {
    background-color: transparent;
    border: none;
    cursor: pointer;
}
.abtn:hover{
    text-decoration: underline;
}
.row{
	width: 100%;
    height: 1000px;
    margin-left: -2px;
}
.findLi{
	display: table-cell;
    font-size: 30px;
}
.addLine{
    border-left: solid 3px #005f86;
	border-top: solid 3px #005f86;
    border-right: solid 3px #005f86;
}
.addLine-b{
	border-bottom : solid 3px #005f86;
}
.findAtag{
	display: inline-block;
	width: 100%;
	height: 100%;
}
.firstCol{
	width : 270px;
	height : 40px; 
	float : left;
}
.lastCol{
	width : 270px;
	height :40px; 
	float : right;
}
button:focus{
	outline: none;
}
.table-responsive{
	height: 90%;
}
.thead-light{
	text-align: center;
}
.total{
	color: green;
}
.lescnt{
	color: blue;
}
.examcnt{
	color: red;
}
.totalPay{
	color: green;
}
.lesPayCnt{
	color: blue;
}
.examPayCnt{
	color: red;
}
.tdc{
	text-align: center;
}
.right{
    margin-top: 50px;
    margin-bottom: 15px;
    width: 100%;
}
.searchC{
	float: right;
	width: 150px;
}
</style>
<body>
<form:form action="/scholarship/selectAllScholarship" id="schof" commandName="scholarshipVO" name="ScholarshipVO" method="post">
	<div class="limiter" style="background-color:#f4f4f4">
		<div class="container-login100" style="padding: 40px;" >
			<div class="row" style="border:1px solid #ededed; padding:20px;background-color:white;">
				<div id="cng" class="div2">
					<ul>
						<li class="findLi firstCol" id="first">
							<button id="fIBtn" class="findAtag" type="button">
								<span id="fCId">장학금 지급</span>
							</button>
						</li>
						<li class="findLi lastCol" id="last">
							<button id="fPBtn" class="findAtag" type="button" >
								<span id="fCPw">장학금 지급 내역</span>
							</button>
						</li>
					</ul>
				</div>
				<div class="right">
					<form:select path="searchSubject" cssClass="form-control searchC" id="searchSubject">
						<form:option value="">과목</form:option>
						<form:options items="${subjectList }" itemLabel="subNm" itemValue="subId"/>
					</form:select>
					
					<form:select path="searchASubject" cssClass="form-control searchC" id="searchASubject">
						<form:option value="">과목</form:option>
						<form:options items="${subjectList }" itemLabel="subNm" itemValue="subId"/>
					</form:select>
				</div>
				<div class="table-responsive" id="inschl">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col" style="width: 5%;">순</th>
								<th scope="col" style="width: 40%;">강의명</th>
								<th scope="col" style="width: 15%;">수강중인<br>회원 수</th>
								<th scope="col" style="width: 15%;">완강한<br>회원 수</th>
								<th scope="col" style="width: 15%;">시험을 완료한<br>회원 수</th>
							</tr>
						</thead>
						<tbody id="lesidx">
							<c:choose>
								<c:when test="${scholarshipList.size() ne 0}">
									<c:forEach items="${scholarshipList}" var="scholarship" varStatus="status">
										<tr data-lesid='${scholarship.lesId }'>
											<td class="tdc">${status.count }</td>
											<td>${scholarship.lesNm }</td>
											<td class="tdc"><button class="total abtn">${scholarship.totalCnt }</button></td>
											<td class="tdc"><button class="lescnt abtn">${scholarship.completeLesCnt }</button></td>
											<td class="tdc"><button class="examcnt abtn">${scholarship.completeExamCnt }</button></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5" style="text-align: center;">데이터가 존재하지 않습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				
				<div class="table-responsive" id="outschl">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col" style="width: 5%;">순</th>
								<th scope="col" style="width: 40%;">강의명</th>
								<th scope="col" style="width: 10%;">지급일</th>
								<th scope="col" style="width: 15%;">완강<br>지급 수</th>
								<th scope="col" style="width: 15%;">시험<br>지급 수</th>
								<th scope="col" style="width: 15%;">총<br>지급 금액</th>
							</tr>
						</thead>
						<tbody id="lesidx">
							<c:choose>
								<c:when test="${scholarshipAList.size() ne 0}">
									<c:forEach items="${scholarshipAList}" var="scholarship" varStatus="status">
										<tr data-lesid='${scholarship.lesId }'>
											<td class="tdc">${status.count }</td>
											<td>${scholarship.lesNm }</td>
											<td class="tdc"><fmt:formatDate value="${scholarship.schlDate }" pattern="yyyy-MM-dd" /></td>
											<td class="tdc"><button class="lesPayCnt abtn">${scholarship.completeLesPay }</button></td>
											<td class="tdc"><button class="examPayCnt abtn">${scholarship.completeExamPay }</button></td>
											<td class="tdc"><button class="totalPay abtn">${scholarship.totalPay }</button></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="6" style="text-align: center;">데이터가 존재하지 않습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</form:form>
</body>
</html>