<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="/css/user/lesson/subject-select.css"/>
<!-- 컨텐츠부분 메인박스 -->
<div class="lesson-main-box">
	<!-- 리스트 박스 -->
	<div class="lesson-list-box">
		<c:forEach items="${subjectList}" var="subList">
			<!-- 과목박스 -->		
			<div class="sublist-box shadow">
				<div class="subject-header" data-subNm = "${subList.subNm}">
					<div class="subject-subnm-box">
						<span>${subList.subNm}</span>
					</div>
				</div>
				<div class="img-box">
					<div class="img-cont">
						<img alt="database" src="/img/icon/database-storage.svg">
					</div>
				</div>
				<!-- 박스안에 글 시작부분 -->
				<div class="sub-coment-box">
					<!-- 과목정보 -->
					<div class="sub-coment-item">
						<c:forEach items="${lessonList}" var="lesList">
							<c:if test="${subList.subId == lesList.subId}">
								<div class="">
									<c:url value="/user/selectLessonPage" var="user">
										<c:param name="lesId" value="${lesList.lesId}"/>
									</c:url>
										<span class="info-lesnm"><a href="${user}">${lesList.lesNm}</a></span>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<!-- 과목 상자 안에 구분선 -->
					<div class="divider">
						<div></div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<script>
$(function(){
	var len = $(".subject-header").length;
	for(i = 0; i<len; i++){
		var subNm = $(".subject-header").eq(i).attr("data-subNm");	//과목    
		var header = $(".subject-header").eq(i);
		var subNmBox = $(".subject-subnm-box").eq(i);
		var img = $(".subject-header").eq(i).next().children().children();
		if(subNm == 'DB'){
			header.attr('class','subject-header shDB');
			subNmBox.attr('class','subject-subnm-box ssDB');
			img.attr('src','/img/codingLogo/database.svg');
		}else if(subNm =='Spring'){
			header.attr('class','subject-header shSpring');
			subNmBox.attr('class','subject-subnm-box ssSpring');
			img.attr('src','/img/codingLogo/spring.svg');
		}else if(subNm =='Java'){
			header.attr('class','subject-header shJava');
			subNmBox.attr('class','subject-subnm-box ssJava');
			img.attr('src','/img/codingLogo/java.svg');
		}else if(subNm =='Python'){
			header.attr('class','subject-header shPython');
			subNmBox.attr('class','subject-subnm-box ssPython');
			img.attr('src','/img/codingLogo/python.svg');
		}else if(subNm =='JSP'){
			header.attr('class','subject-header shJSP');
			subNmBox.attr('class','subject-subnm-box ssJSP');
			img.attr('src','/img/codingLogo/jsp.svg');
		}else if(subNm =='HTML/CSS'){
			header.attr('class','subject-header shCss');
			subNmBox.attr('class','subject-subnm-box ssCss');
			img.attr('src','/img/codingLogo/css.svg');
		}else if(subNm =='Android'){
			header.attr('class','subject-header shAndroid');
			subNmBox.attr('class','subject-subnm-box ssAndroid');
			img.attr('src','/img/codingLogo/android.svg');
		}else{
			header.css("background","#0a0a0ad1");
			subNmBox.css("background","#ffffff47");
			img.attr('src','/img/codingLogo/default.svg');
		}
	}
})
</script>