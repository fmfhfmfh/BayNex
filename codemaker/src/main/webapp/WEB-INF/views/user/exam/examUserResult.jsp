<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- main(css)-->
<link href="/vendor/user/main/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">

<!-- 시험 상세 내역 page css -->
<link href="/css/user/mypage/mypage-exam-result.css" rel="stylesheet"/>

<script>
$(function() {
	// 나가기
	$('#close').on('click', function(){
		self.close();
		
	});
})

</script>
<title>examSelect</title>
<body>
<div class="exam-select-box shadow" role="main">
	<div class="exam-select-item">
		<form:form action="/examUser/selectAllExam" id="examf" method="post" commandName="examVO" name="examVO">
			
			<form:input type="hidden" path="lesId" class="form-control" id="lesId" value="${lesId }"/>
			<form:input type="hidden" path="searchEsFscore" class="form-control" id="searchEsFscore" value="${searchEsFscore }"/>
			
			<div id="d2">
				<div id="d1"></div>
				<div id="d3" class="divBC">
					<h2 id="hh2">시험 결과</h2>
					<br> 
					<label for="sel1" class="sel1"><h5>${examScoreVO.examNm }</h5></label>
					<label for="sel1" class="sel1">총 문제 수: ${examResultList.size() } / 맞힌 개수 : ${examResultList[0].answerCount }</label>
				</div>
				<br>
				<c:forEach items="${examResultList }" var="examResult" varStatus="status">
					<br>
					<div class="d5">
						<div class="d4"></div>
						<div class="d6 divBC">
							<label for="sel2" class="sel2">${status.count }. ${examResult.queCont }</label><br>
							<label for="sel4" class="sel4">배점 : ${examResult.queScore }</label>
							<br>
							
							<c:forEach begin="${status.index*4 }" end="${status.count*4-1 }" items="${answersheetLists }" varStatus="vs" var="answersheet">
								<div class="anw">
									<c:choose>
										<c:when test="${vs.count eq fn:split(examResult.queAnswer, ',')[0] }">
											<label for="sel4" class="sel4" style="background-color: rgba(182, 244, 234);">
												${vs.count }. ${answersheet.ansCont }
											</label>
										</c:when>
										<c:when test="${vs.count eq fn:split(examResult.queAnswer, ',')[1] }">
											<label for="sel4" class="sel4" style="background-color: rgba(182, 244, 234);">
												${vs.count }. ${answersheet.ansCont }
											</label>
										</c:when>
										<c:when test="${vs.count eq fn:split(examResult.queAnswer, ',')[2] }">
											<label for="sel4" class="sel4" style="background-color: rgba(182, 244, 234);">
												${vs.count }. ${answersheet.ansCont }
											</label>
										</c:when>
										<c:when test="${vs.count eq fn:split(examResult.queAnswer, ',')[3] }">
											<label for="sel4" class="sel4" style="background-color: rgba(182, 244, 234);">
												${vs.count }. ${answersheet.ansCont }
											</label>
										</c:when>
										<c:otherwise>
											<label for="sel4" class="sel4">
												${vs.count }. ${answersheet.ansCont }
											</label>
										</c:otherwise>
									</c:choose>
								</div>
							</c:forEach>
							<hr>
							<div class="anw">
								<label for="sel5" class="sel5">입력한 답 : 
									<c:if test="${examResult.erAnswer != '0' }">
										${examResult.erAnswer }
									</c:if>
								</label><br>
								<label for="sel5" class="sel5">정답 : ${examResult.queAnswer } </label><br>
								<label for="sel5" class="sel5">문제해설 </label>
								<textarea class="form-control comment" rows="5" name="queExplain" readonly="readonly">${examResult.queExplain}</textarea>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</form:form>
		<div class="btns">
			<input type="button" class="btn btn-default" id="close" value="나가기">
		</div>
	</div>
</div>
</body>
