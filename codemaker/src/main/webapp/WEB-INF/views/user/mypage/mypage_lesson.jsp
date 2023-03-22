<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<jsp:useBean id="now" class="java.util.Date"/>
<script src="/js/poshytip/jquery.poshytip.js"></script>
<link href="/css/user/mypage/mypage-lesson.css" rel="stylesheet">
<div class="card shadow myles-box-area">
	<div class="myles-box-big">
		<div class="lesson-header">
			<c:url value="/user/myLesson" var="mylesson"/>
			<c:url value="/user/myLesson/finish" var="finish"/>
			<div>
				<span class="select-point les-studying">
					<c:if test="${point=='studying'}">⚫</c:if>
				</span>
				<span class="select-a"><a href="${mylesson}" class="fw-600">수강중</a></span>
			</div>
			<div>
				<span class="select-point les-complete">
					<c:if test="${point=='complete'}">⚫</c:if>
				</span>
				<span class="select-a"><a href="${finish}" class="fw-600">수강완료</a></span>
			</div>
		</div>
		<div class="divider"></div>
		<!-- 수강목록 새로만드는중 -->
		<div class="lesson-box">
			<c:forEach items="${plList}" var="lesson">
				<!-- payDate : 결제일(강의 시작일) , cosTerm : 종료일(강의 종료일) -->
				<fmt:formatDate value="${lesson.payDate}" var="startLes" pattern="yyyy.MM.dd"/>
				<fmt:formatDate value="${lesson.cosTerm}" var="endLes" pattern="yyyy.MM.dd"/>
				<!-- 남은일수 구하기 -->
				<!-- cosTerm 강의 일수(ex, 90일) -->
				<fmt:parseNumber value="${lesson.cosTerm.time / (1000*60*60*24)}" integerOnly="true" var="costerm" />
				<fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true " var="today"></fmt:parseNumber>
				<fmt:parseNumber value="${costerm-today}" integerOnly="true" var="expire"/>
				<div class="lesson-item">
					<div class="lesson-item-top">
						<!-- 사진 -->
						<div class="item-top1">
							<c:choose>
								<c:when test="${lesson.subNm == 'DB'}"><c:url value="/img/codingLogo/database.svg" var="cdImg"/></c:when>
								<c:when test="${lesson.subNm == 'Spring'}"><c:url value="/img/codingLogo/spring.svg" var="cdImg"/></c:when>
								<c:when test="${lesson.subNm == 'Java'}"><c:url value="/img/codingLogo/java.svg" var="cdImg"/></c:when>
								<c:when test="${lesson.subNm == 'Python'}"><c:url value="/img/codingLogo/python.svg" var="cdImg"/></c:when>
								<c:when test="${lesson.subNm == 'JSP'}"><c:url value="/img/codingLogo/jsp.svg" var="cdImg"/></c:when>
								<c:when test="${lesson.subNm == 'CSS'}"><c:url value="/img/codingLogo/css.svg" var="cdImg"/></c:when>
								<c:otherwise><c:url value="/img/codingLogo/default.svg" var="cdImg"/></c:otherwise>
							</c:choose>
							<img class="sub-img" alt="subject" src="${cdImg}">
						</div>
						<!-- 과목명, 강의명 -->
						<div class="item-top2">
							<span class="t2 item-subnm fw-600">${lesson.subNm}</span>
							<span class="t2 fw-600">${lesson.lesNm}</span>
						</div>
						<!-- 재생버튼, 시험버튼 -->
						<div class="item-top3">
							<c:url value="/user/selectLessonPage" var="lessonPage"><c:param name="lesId" value="${lesson.lesId}"/></c:url>
							<c:url value="/examUser/selectAllExam" var="selectAllExam"><c:param name="lesId" value="${lesson.lesId}"></c:param></c:url>
							<div><a href="${lessonPage}"><img class="btn-img" alt="playbtn" src="/img/codingLogo/playbtn.svg"></a></div>
							<c:choose>
								<c:when test="${fin == 'fin'}">
									<div style="display: none;"><a href="${selectAllExam}"><img class="btn-img" alt="testbtn" src="/img/codingLogo/testbtn.svg"></a></div>
								</c:when>
								<c:otherwise>
									<div><a href="${selectAllExam}"><img class="btn-img" alt="testbtn" src="/img/codingLogo/testbtn.svg"></a></div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="lesson-item-mid">
						<!-- 강의설명 -->
						<div class="fw-600">${lesson.lesCont}</div>
						<!-- 강의 진행도 -->
						<div class="remain-day">
							<fmt:parseNumber value="${((lesson.lesTerm - expire) / lesson.lesTerm)*100}" integerOnly="true" var="remainDay"/>
							<c:if test="${remainDay >100}">
								<c:set value="100" var="remainDay"></c:set>
							</c:if>
							<div class="fw-600">${remainDay}%</div>
							<div class="progress">
								<div class="progress-bar" style="width: ${remainDay}%;"></div>
							</div>
						</div>
					</div>
					<div class="lesson-item-btm">
						<!-- 코드메이커 -->
						<div class="fw-600">코드메이커</div>
						<!-- 수강날짜 -->
						<div class="fw-600">${startLes}~${endLes}</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script>
$(function(){
	
	$(".exam-btn").on("click",function(){
		var lesid = $(this).data('lesid');
		console.log(lesid);
		location.href= "/examUser/selectAllExam";
	})
	
	var sublen = $(".item-subnm").length;
	for(i=0; i<sublen; i++){
		var subnm = $(".item-subnm").eq(i);
		if(subnm.text()=='DB'){subnm.css("background","#032f42");}
		else if(subnm.text()=='Spring'){subnm.css("background","#064806")}
		else if(subnm.text()=='Java'){subnm.css("background","#920d0d")}
		else if(subnm.text()=='Python'){subnm.css("background","#750075")}
		else if(subnm.text()=='JSP'){subnm.css("background","#544c4c")}
		else if(subnm.text()=='CSS'){subnm.css("background","#de8a21eb")}
		else {subnm.css("background","#000000")}
	}
})
</script>