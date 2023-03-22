<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/css/user/lesson/lesson-select.css" rel="stylesheet" type="text/css">
<div class="lesson-container" >
	<div class="lesson-header"  >
		<div class="lesson-header-left" >
			<div class="back-div">
				<a href="/user/selectSubject"><img class="back-img" src="/images/teacher/lesson/back3.png"></a>
			</div>
		
			<div class="les-info-div card shadow">
				<div class="les-info-sub-name" data-subnm ="${lessonVO.subNm}">
					${lessonVO.subNm}
				</div>
				<div class="les-info-top">
					<div class="les-detail-title">
						<span class="les-ds">ο 수업상세</span>
					</div>
					<div class="les-detail-cont">
						<p class="les-dp">${lessonVO.lesDetail}</p>
					</div>
				</div>
				<div class="les-info-middle">
					<div class="les-course-title">
						<span class="les-ds">ο 코스</span>
					</div>
					<div class="les-detail-cont">
						<span class="detail-s"><div class="course-img-div"><img class="course-img" src="/images/user/lesson/date.png"></div>기간 ${lessonVO.lesTerm}일</span>
						<span class="detail-s"><div class="course-img-div"><img class="course-img" src="/images/user/lesson/play.png"></div>영상 ${lesIdxList.size()}</span>
						<span class="detail-s"><div class="course-img-div"><img class="course-img" src="/images/user/lesson/monitor.png"></div>시험 ${examCnt}</span>
					</div>
				</div>
				<c:if test="${payVO == null && MEMBER_INFO.userId != null}">
					<div class="les-info-bottom">
						<div class="les-detail-price">
							<c:set var="price" value="${lessonVO.lesCash}"/>
							<span class="prices"><fmt:formatNumber type="number" maxFractionDigits="3" value="${price}"/></span><span class="wons">원</span>
						</div>
						<div class="lesson-content-detail-bottom">
							<c:url value="/user/payView" var="pay">
							<c:param name="lesId" value="${lesId}" />
							</c:url>
						<a class="fa-white" onclick="pay('${lesId}')">결제하기</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="lesson-header-right">
			<div class="sub-info-div">
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
					<c:if test="${payVO != null }">
						<div class="lesbtn">
							<button class="fa-wf" id="noteBtn">필기노트</button>
						</div>
					</c:if>
                    <div class="lesbtn">
                        <button class="fa-wf" id="chat">채팅</button>
					</div>
				</div>
				<div class="sub-info-top">
					<div class="les-info-name">
						<span>${lessonVO.lesNm}</span>
					</div>
					<div class="les-info-cont">
						<span class="sub-cont">${lessonVO.lesCont}</span>
					</div>
				</div>
				<div class="sub-info-bottom">
					<div class="teacher-top">
					<c:url value="/user/teacherImg" var="userTImg">
						<c:param name="tchProfile" value="${teacherVo.tchProfile}"/>
					</c:url>
					<img id="teacher-img" src="${userTImg}">
					</div>
					<div class="teacher-bottom">
						<div class="teacher-name">
							<h3 class="teacher-name-h3">${lessonVO.tchNm}</h3>
						</div>
						<div class="teacher-cont">
							<p class="teachr-cont-p">${lessonVO.tchIntro}</p>
						</div>
					</div>
				</div>
				<div class="lesson-content-button">
					<div class="cartbtn" >
						<a class="fa-wf" onclick="addCart('${lesId}','${MEMBER_INFO.userId}')">담기</a><br>
					</div>
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
										<c:forEach items="${examList }" var="exam">
											<c:if test="${exam.lidxId == lesIdxList.lidxId}">
												<c:choose>
													<c:when test="${exam.esFscore == '999' }">
														<a href="#" class="exam" data-examid="${exam.examId }/0">
															<img class="note-img" src="/images/user/lesson/note.png">
														</a>
													</c:when>
													<c:otherwise>
														<a href="#" class="exam" data-examid="${exam.examId }/1">
															<img class="note-img" src="/images/user/lesson/note.png">
														</a>
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
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
</div>
<form action="/examUser/selectViewExam" method="post" id="subf">
	<input type="hidden" name="examId" value="" id="examId">
	<input type="hidden" name="searchEsScore" value="" id="searchEsScore">
</form>
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
		document.location="/user/selectAllQna?lesId=${lesId}";
	});
	
    // 채팅버튼 클릭시
    $('#chat').on('click',function(){
        if(${MEMBER_INFO.userId == null}){
            alert("로그인후 이용해주세요");
            return;
        }else{
            window.open("/chat/realchat?lesId=${lessonVO.lesId}", "_blank",'width=500,height=700,resizable=no,left=1000,top=300,scrollbars=no');
        }
    });    
    
	// 강의영상 클릭시
	$('a[id^="videoClick_"]').on('click',function(){
		var path = $(this).attr('value');
		var lidxId = $(this).data('lidxid');
		window.open("/user/selectYoutube?lidxPath="+path+"&lidxId="+lidxId, "video_popup", "width=1100,height=900, left=30, top=30");
	});
	
	// 시험 문제 화면 요청
	$('.exam').on('click', function(){
		var examId = $(this).data('examid').split("/")[0];
		var searchEsScore = $(this).data('examid').split("/")[1];
		
		$('#examId').val(examId);
		$('#searchEsScore').val(searchEsScore);
		
        window.open('', "selectViewExam", 'width=1100,height=1100,resizable=no,scrollbars=yes,left=500,top=50');
         
        $('#subf').attr("target", "selectViewExam");
        $('#subf').submit();
        
	});
	
	// 강의 노트
	$('#noteBtn').on('click', function(){
		var windowObj = window.open('/note/insertViewNote','noteInsert', 'width=630,height=800,resizable=no,scrollbars=yes,left=1200,top=50');
	});
	
	
	// 과목에 따라서 색 바뀜
	var subNm = $('.les-info-sub-name').data('subnm');	// 과목
	var subName = $('.les-info-sub-name');
	var cartBtn = $('.cartbtn');
	var lessonIndex = $('.lesson-index');
	if(subNm == 'DB'){
		subName.attr('class','les-info-sub-name ssDB');
		cartBtn.attr('class','cartbtn ssDB');
		lessonIndex.attr('class','lesson-index shDB');
	}else if(subNm =='Spring'){
		subName.attr('class','les-info-sub-name ssSpring');
		cartBtn.attr('class','cartbtn ssSpring');
		lessonIndex.attr('class','lesson-index shSpring');
	}else if(subNm =='Java'){
		subName.attr('class','les-info-sub-name ssJava');
		cartBtn.attr('class','cartbtn ssJava');
		lessonIndex.attr('class','lesson-index shJava');
	}else if(subNm =='Python'){
		subName.attr('class','les-info-sub-name ssPython');
		cartBtn.attr('class','cartbtn ssPython');
		lessonIndex.attr('class','lesson-index shPython');
	}else if(subNm =='JSP'){
		subName.attr('class','les-info-sub-name ssJSP');
		cartBtn.attr('class','cartbtn ssJSP');
		lessonIndex.attr('class','lesson-index shJSP');
	}else if(subNm =='HTML/CSS'){
		subName.attr('class','les-info-sub-name ssCss');
		cartBtn.attr('class','cartbtn ssCss');
		lessonIndex.attr('class','lesson-index shCss');
	}else if(subNm =='Android'){
		subName.attr('class','les-info-sub-name ssAndroid');
		cartBtn.attr('class','cartbtn ssAndroid');
		lessonIndex.attr('class','lesson-index shAndroid');
	}else{
		header.css("background","#0a0a0ad1");
		subNmBox.css("background","#ffffff47");
		img.attr('src','/img/codingLogo/default.svg');
	}
	
})
</script>