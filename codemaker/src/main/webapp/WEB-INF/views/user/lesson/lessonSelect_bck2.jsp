<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/css/user/lesson/lesson-select.css" rel="stylesheet" type="text/css">
<div class="lesson-container" >
	<div class="lesson-header"  >
		<div class="lesson-header-left" >
			<div class="sub-info-id">
				<span class="fs-wf sub-id" >${lessonVO.subId}</span>
			</div>
			<div class="les-info-name">
				<span>${lessonVO.lesNm}</span>
			</div>
			<div class="les-info-cont">
				<span class="sub-cont">${lessonVO.lesCont}</span>
			</div>
		</div>
		<div class="lesson-header-right">
			<div class="les-btn-div">
				<div class="lesbtn">
					<c:url value="/user/selectReview" var="selectReview">
						<c:param name="lesId" value="${lesId}"></c:param>
					</c:url>
					<a class="fa-wf" href="${selectReview}">강의후기</a>
				</div>
				<div class="lesbtn">
					<button class="fa-wf" id="qnabtn">QnA</button>
				</div>
			</div>
		</div>
	</div>

	<div class="lesson-content-top" >
		<div class="lesson-content-left" >
			<div class="lesson-content card shadow">
				<div class="lesson-content-detail-top">
				<c:set var="price" value="${lessonVO.lesCash}"/>
					<span class="prices"><fmt:formatNumber type="number" maxFractionDigits="3" value="${price}"/></span><span class="wons">원</span>
				</div>
				<div class="lesson-content-detail-middle">
					<div class="detail-middle-term">수강기간</div>
					<div class="detail-middle-video">강의영상</div>
					<div class="detail-middle-exam">퀴즈</div>
				</div>
				<div class="lesson-content-detail-middle2nd">
					<div class="detail-middle2nd-term">${lessonVO.lesTerm}<span class="wons">일</span></div>
					<div class="detail-middle2nd-video">${lesIdxList.size()}</div>
					<div class="detail-middle2nd-exam">퀴즈갯수</div>
				</div>
				<div class="lesson-content-detail-bottom">
					<c:url value="/user/payView" var="pay">
						<c:param name="lesId" value="${lesId}" />
					</c:url>
					<a class="fa-black" onclick="pay('${lesId}')">결제하기</a>
				</div>
			</div>
			<div class="lesson-content-button">
				<div class="cartbtn" >
					<a class="fa-wf" onclick="addCart('${lesId}','${MEMBER_INFO.userId}')">담기</a><br>
				</div>
			</div>
		</div>
		<div class="lesson-content-right" >
			<div class="teacher-top">
				<img id="teacher-img" src="/images/user/lesson/teacher.png">
			</div>
			<div class="teacher-bottom">
				<div class="teacher-name">
					<h3 class="teacher-name-h3">${lessonVO.tchNm }</h3>
				</div>
				<div class="teacher-cont">
					<p class="teachr-cont-p">${lessonVO.tchIntro}</p>
				</div>
			</div>
		</div>
	</div>
	
	<div class="lesson-content-bottom">
		<div class="lesson-content-bottom-in" >
			<c:forEach items="${lesIdxList}" var="lesIdxList" varStatus="status">
				<div class="lesson-content-section-out" >
					<div class="lesson-content-section-in" >
						<div class="lesson-index bg-index"> 	
							<span class="lesson-index-num">${lesIdxList.lidxNum}</span>
							<div class="lesson_content_section">
							<div class="lesson-index-cont">
								<h2 class="lidx-cont-h2">${lesIdxList.lidxCont}</h2>
							</div>
							<c:if test="${MEMBER_INFO.userId != null && MEMBER_INFO.userId == lesIdxList.userId}">
								<div class="lidx-img">
									<div class="lidx-img-1st">
										<a href="#" id="videoClick_${status.index}" value="${lesIdxList.lidxPath}" class="videoA" data-lidxid="${lesIdxList.lidxId}" >
										<img class="video-img" src="/images/user/lesson/video2.png"></a>
									</div>
									<div class="lidx-img-2nd">
										<c:choose>
											<c:when test="${lesIdxList.lidxCurtime /lesIdxList.lidxDurtime == 1}">
												<span class="video-end">완료</span>
											</c:when>
											<c:when test="${lesIdxList.lidxCurtime /lesIdxList.lidxDurtime != 1}">
												미완료(<fmt:formatNumber value="${lesIdxList.lidxCurtime /lesIdxList.lidxDurtime}" type="percent"/>)
											</c:when>
										</c:choose>
									</div>
									<div class="lidx-img-3rd">
										<a href=""><img class="note-img" src="/images/user/lesson/note.png"></a>
									</div>
								</div>
							</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="qna-content">
		<div id="qna">
		QnA
		</div>
	</div>
</div>
<script>
function addCart(lesId,userId){
	console.log(lesId,userId);
	$.ajax({
		method : "post",
		url : "/user/cart",
		data : {lesId:lesId,userId:userId},
		dataType : "json",
		success : function(res){
			if(res.code==0){
				alert(res.msg);
			}else{
				var check = confirm("장바구니에 강의를 담았습니다\n장바구니로 이동하시겠습니까?");
				if(check){
					location.href="${pageContext.request.contextPath}/user/cartView";
				}
			}
		}
	})
}

function pay(lesId){
	console.log("유저아이디"+lesId);
	$.ajax({
		method : "post",
		url : "/user/payCheck",
		data : {lesId:lesId},
		dataType : "json",
		success : function(res){
			if(res.code==0){
				alert(res.msg);
			}else{
				console.log("여기?");
				location.href="${pageContext.request.contextPath}/user/payView?lesId="+lesId;
			}
		}
	})
}

$(function() {
	// qna클릭시 스크롤 이동
	$('#qnabtn').on('click',function(){
		var location = document.querySelector('#qna').offsetTop;
		window.scrollTo({top:location, behavior:'smooth'});
	})
	// 강의영상 클릭시
	$('a[id^="videoClick_"]').on('click',function(){
		var path = $(this).attr('value');
		var lidxId = $(this).data('lidxid');
		window.open("/user/selectYoutube?lidxPath="+path+"&lidxId="+lidxId, "video_popup", "width=1100,height=900, left=30, top=30");
	})
	
})
</script>