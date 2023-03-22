<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap 사용 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

<!-- 시험 내역 page css -->
<link href="/css/user/mypage/mypage-exam.css" rel="stylesheet"/>

<script>
$(function() {
	
	// 시험 제공
	$('.regBtn').on('click', function(){
		// data-examid
		var examId = $(this).data('examid').split("/")[0];
		var searchEsScore = $(this).data('examid').split("/")[1];
		
		$('#examId').val(examId);
		$('#searchEsScore').val(searchEsScore);
		
        window.open('', "selectViewExam", 'width=1100,height=1100,resizable=no,scrollbars=yes,left=500,top=50');
         
        $('#subf').attr("action", "/examUser/selectViewExam");
        $('#subf').attr("target", "selectViewExam");
        $('#subf').submit();
	});
	
	// 조건에 따라 조회 - 등록상태
	$('#search').on('change', function(){
		$('#subf').attr("action", "/examUser/selectAllExam");
		$('#subf').removeAttr("target");
		$('#subf').submit();
	});
	
	// 시험 상세페이지 이동 data-exam_id
	$(document).on('click', '#examList tr td', function(){
// 		var searchLesId = $('#lesson').val();
// 		var searchSubId = $('#subject').val();
		var searchExamState = $('#search').val();
		
		if ($(this).attr('class') == 'm') {
			var examId = $(this).parent('tr').data("examid").split("/")[0];
			var searchEsScore = $(this).parent('tr').data("examid").split("/")[1];
			
			if(searchEsScore != '999'){
				$('#examId').val(examId);
				
				$('#subf').attr('action', '/examUser/selectExamScore');
				$('#subf').submit();
			}else{
				alert("시험 결과가 존재 하지 않습니다.");
			}
		}
	});
	
	// 페이징 처리 data-page
	$('.pageMV').on('click', function(){
		$('#subf').attr("action", "/examUser/selectAllExam");
		$('#subf').removeAttr("target");
		
		var page = $(this).data('page');
		str = '<input type="hidden" name="page" value="' + page + '">';
		$('#subf').append(str);
		
		$('#subf').submit();
	});
	
	// 수강 목록으로 가기
	$('#cancel').on('click', function(){
		$('#subf').attr("action", "/user/myLesson");
		$('#subf').submit();
	});
	
});

</script>
<title>examAllSelect</title>

</head>
<body>
<div class="card shadow exam-box">
	<div class="exam-box-item">
		<h3 id="hd">시험 목록</h3>
		<h4 id="hd">${examList[0].lesNm }</h4>
		<form:form name="examVO" commandName="examVO" id="subf" action="/examUser/selectAllExam" method="post">
			<input type="hidden" name="examId" id="examId" value="">
			<input type="hidden" name="searchEsScore" id="searchEsScore" value="">
			<input type="hidden" name="resultState" id="resultState" value="0">
			<input type="hidden" name="lesId" id="lesId" value="${examVO.lesId }">
			<div id="rldiv">
				<div id="left">
					<input type="button" id="cancel" class="btn btn-sm btn-primary" value="목록으로 가기"/>
				</div>
				<div id="right">
					<label>시험 평균 점수 : ${examList[0].avgScore  }  </label>
					<form:select path="searchEsFscore" cssClass="form-control" id="search">
						<form:option value="">시험 상태</form:option>
						<form:option value="0">시험 풀기</form:option>
						<form:option value="1">풀기 완료</form:option>
					</form:select>
				</div>
			</div>
			<div class="exam-tb-box">
				<table class="exam-tb" id="wul">
					<thead id ="tthe">
						<tr>
							<th style="vertical-align : text-bottom; width: 70px;">순</th>
							<th style="vertical-align : text-bottom; width: 420px;">강의 목차명</th>
							<th style="vertical-align : text-bottom; width: 420px;">시험명</th>
							<th style="vertical-align : text-bottom; width: 150px;">시험 첫 점수</th>
							<th style="vertical-align : text-bottom; width: 200px;">다시 풀기 점수</th>
							<th style="vertical-align : text-bottom; width: 180px;">시험 푼 날짜</th>
							<th style="vertical-align : text-bottom; width: 200px;">시험 상태</th>
						</tr>
					</thead>
					<tbody id="examList">
						<!-- 시험 문제 리스트 -->
						<c:if test="${examList.size() == 0}">
							<tr>
								<td colspan="7" style="text-align: center;">조회한 데이터가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach items="${examList}" var="exam" varStatus="status">
							<tr data-examid='${exam.examId }/${exam.searchEsScore}'>
								<!-- 시험 문제를 볼때 -->
								<td class='m'>${status.count }</td>
								<td class='m'>${exam.lidxCont }</td>
								<td class='m'>${exam.examNm }</td>
								<td class='m'>
									<c:choose>
										<c:when test="${exam.esFscore == 999}">
											-
										</c:when>
										<c:otherwise>
											${exam.esFscore } / ${exam.queTotal }
										</c:otherwise>
									</c:choose>
								</td>
								<td class='m'>
									<c:choose>
										<c:when test="${exam.esLscore == 999}">
											-
										</c:when>
										<c:otherwise>
											${exam.esLscore } / ${exam.queTotal }
										</c:otherwise>
									</c:choose>
								</td>
								<td class='m'><fmt:formatDate value="${exam.esEdate }" pattern="yyyy-MM-dd" /></td>
								<td>
									<c:choose>
										<c:when test="${exam.searchEsScore == '999' }">
											<input type="button" class="btn btn-default regBtn" data-examid="${exam.examId }/0" value="시험 풀기"> 
										</c:when>
										<c:otherwise>
											<input type="button" class="btn btn-default regBtn" data-examid="${exam.examId }/1" value="다시 풀기"> 
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 페이징 처리 -->
			<div class="py-4">
				<c:if test="${examList.size() ne 0 }">
					<ul class="pagination justify-content-end mb-0">
						<!-- 첫페이지가 아닐때 -->
						<c:if test="${examVO.page ne 1 }">
							<!-- 첫페이지로 가기 -->
							<li class="page-item active">
								<input type="button" class="page-link pageMove pageMV" value="&laquo;" data-page="1">
							</li>
							<!-- 이전 페이지로 가기 -->
							<li class="page-item active">
								<input type="button" class="page-link pageMove pageMV" value="&lt;" data-page="${examVO.page-1 }">
							</li>
						</c:if>
		
						<c:forEach begin="1" end="${pages }" var="i">
							<!-- 현재 있는 페이지와 구분 -->
							<c:choose>
								<c:when test="${i == examVO.page }">
									<!-- 보고 있는 페이지와 현재 선택된 페이지가 같을 때 -->
									<li class="page-item active"><span class="page-link"><strong>${i }</strong></span></li>
								</c:when>
								<c:otherwise>
									<li class="page-item active">
										<input type="button" class="page-link pageMove pageMV" value="${i}" data-page="${i}">
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
		
						<!-- 마지막페이지가 아닐때 -->
						<c:if test="${examVO.page ne pages }">
							<!-- 다음 페이지로 이동 -->
							<li class="page-item active">
								<input type="button" class="page-link pageMove pageMV" value="&gt;" data-page="${examVO.page+1 }">
							</li>
							<!-- 마지막 페이지로 이동 -->
							<li class="page-item active">
								<input type="button" class="page-link pageMove pageMV" value="&raquo;" data-page="${pages }">
							</li>
						</c:if>
		
					</ul>
				</c:if>
			</div>
		</form:form>
	</div>
</div>
</body>
</html>