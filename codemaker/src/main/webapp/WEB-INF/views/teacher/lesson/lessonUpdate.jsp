<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/teacher/lesson/mypage-style.css">
<link rel="stylesheet" href="/css/teacher/lesson/button.css">
<link rel="stylesheet" href="/css/teacher/lesson/lessonUpdate.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/js/teacher/exam/exam.js"></script>

<style>

</style>

<script>
$(function(){
	
// 	var sdate = $('#lesSdate').val();
// 	document.getElementById('lesSdate').value = new Date(sdate).toISOString().substring(0, 10);
	var index = 0;
	// 강의목록 추가
	$('#addLesBtn').on('click', function() {
		console.log('눌림');
		
		str ='<div class="lesIdx-list-div" id="lesIdx-md-div['+index+']">';
		str +='	<div class="lesIdx-md-div">';
		str +='		<div class=lesIdx-div-1>';
		str +='			<label class="les-lb">차수</label>';
		str +='			<input type="number" class="les-input-1 les-input-1-shadow chk" name="lesIdxListInsert['+index+'].lidxNum" id="lidxNum" min="1">';
		str +='		</div>';
		str +='		<div class=lesIdx-div-2>';
		str +='			<label class="les-lb">강의목차 제목</label>';
		str +='			<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="제목" name="lesIdxListInsert['+index+'].lidxCont" id="lidxCont">';
		str +='		</div>';
		str +='	</div>';
		str +='	<div class="lesIdx-md-div">';
		str +='		<div class=lesIdx-div-3>';
		str +='			<label class="les-lb">주소</label>';
		str +='			<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="주소" name="lesIdxListInsert['+index+'].lidxPath" id="lidxPath">';
		str +='		</div>';
		str +='		<div class=lesIdx-div-4>';
		str +='			<label class="les-lb2">전체시간</label>';
		str +='			<input type="number" class="les-input-1 les-input-1-shadow chk" placeholder="전체시간" name="lesIdxListInsert['+index+'].lidxDurtime" id="lidxDurtime" min="1">';
		str +='		</div>';
		str +='		<input type="button" class="newIdxDelBtn" value="삭제"  data-del="lesIdx-md-div['+index+']">';
		str +='		<hr class="hr-1">';
		str +='	</div>';
		str +='</div>';
	        
		index++;
			
      	
      	$('.lesIdx-div').append(str);
		
	})
	
	// 새로 생성된 강의목차 삭제
	$('.lesIdx-div').on('click','.newIdxDelBtn',function(){
		console.log('삭제버튼!!');
		var del=$(this).data("del");
		console.log(del);
		$("div[id='"+del+"']").remove();
// 		$('#'+del).remove();
		console.log(del);
	})
	    
	
	// 원래있던 강의목차 삭제
	$('.lesIdx-div').on('click','.idxDelBtn',function(){
		alert("삭제됩니다!")
		var lidxId = $(this).data("lidxid");
		var del=$(this).data("del");
		console.log(lidxId);
		console.log(del);
		
		$("div[id=lesIdx-md-div"+del).remove();
		str ='<input type="hidden" name="lesIdxListDelete" value="'+lidxId+'" >';
		$('#lesForm').append(str);
		
	})
	
	
		
	// 수정 버튼(수정화면으로 이동)
	$('#update').on('click',function(){
		$('#h2Title').text('강의 수정');
		$('input[type=text]').removeAttr("readonly");
		$('input[type=number]').removeAttr("readonly");
		$('#lesDetail').removeAttr("readonly");
		$("#addLesBtn").attr("style",'display:inline-block');
		$(".idxDelBtn").attr("style",'display:inline-block');
		$("#update-real").attr("style",'display:inline-block');
		$("#delete").attr("style",'display:none');
		$("#update").attr("style",'display:none');
	})
	
	// 삭제 버튼
	$('#delete').on('click',function(){
		alert('삭제되었습니다.');
		document.location="/teacherL/deleteLesson?lesId=${lessonVO.lesId}&check=1";
	})
	
	// 수정 버튼
	$('#update-real').on('click',function(){
		alert('수정되었습니다.');
		$('#lesForm').submit();
	})
	
	
	// 목록 버튼
	$('#cancel').on('click',function(){
		document.location="/teacherL/selectSubject";
	})
	
	
	
})
// 강의등록 빈칸 체크
function lessonChk(){
	var flag = '0';
	
	if(flag =='0'){
		$('.chk').each(function(i, data){
			if($(this).val() == ''){
				alert('빈칸을 입력하시오');
				flag = '0';
				return false;
			}
			flag = '1';
		})
		
		if(flag =='1'){
			$('#push').attr('data-target','#exampleModalCenter');
		}
	}
}


</script>


<!-- 강의 수정 -->
<div class="card" >
	<div class="select-container-area">
	<form id="lesForm" action="${cp}/teacherL/updateLesson" method="POST" >
	<input type="hidden" name="lesId" value="${lessonVO.lesId}">
	<input type="hidden" name="subId">
		<div class="lesson-top">	
			<div class="les-title-div">
				<h2 id="h2Title">강의 상세</h2>
			</div>	
		<div class="lesson-div shadow">
			<div class="les-div-1">
				<label class="les-sub-lb">과목</label>
				<label class="les-sub-lb">${lessonVO.subNm}</label>
			</div>
			<div class="les-div-2">
				<label class="les-lb">강의명</label>
				<input type="text"  class="les-input-1 les-input-1-shadow chk" placeholder="강의명" name="lesNm" id="lesNm" value="${lessonVO.lesNm}"  readonly="readonly">
			</div>
			<div class="les-div-2">
				<label class="les-lb">강의소개</label>
				<input type="text"  class="les-input-1 les-input-1-shadow chk" placeholder="소개" name="lesCont" id="lesCont" value="${lessonVO.lesCont}" readonly="readonly">
			</div>
<!-- 			<div class="les-md-div"> -->
<!-- 				<div class="les-div-3"> -->
<!-- 					<label class="les-lb">개설날짜</label> -->
<%-- 					<input type="date"  class="les-input-1 les-input-1-shadow chk"  name="lesSdate" id="lesSdate" value="<fmt:formatDate value="${lessonVO.lesSdate}" pattern="yyyy-MM-dd"/>"> --%>
<!-- 				</div> -->
<!-- 				<div class="les-div-3"> -->
<!-- 					<label class="les-lb">종료날짜</label> -->
<%-- 					<input type="date" class="les-input-1 les-input-1-shadow chk"  name="lesEdate" id="lesEdate" value="<fmt:formatDate value="${lessonVO.lesEdate}" pattern="yyyy-MM-dd"/>"> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="les-md-div"> -->
<!-- 				<div class="les-div-3"> -->
<!-- 					<label class="les-lb">수강료</label> -->
<%-- 					 <input type="text"  class="les-input-1 les-input-1-shadow chk"  placeholder="수강료" name="lesCash" id="lesCash" value="${lessonVO.lesCash}"> --%>
<!-- 				</div> -->
<!-- 				<div class="les-div-3"> -->
<!-- 					<label class="les-lb">기간</label> -->
<%-- 					<input type="text"  class="les-input-1 les-input-1-shadow chk"  placeholder="기간"  name="lesTerm" id="lesTerm"  value="${lessonVO.lesTerm}"> --%>
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="les-div-4">
				<label class="les-lb">상세내용</label>
				<textarea rows="6" cols="25" class="les-input-2 les-input-1-shadow chk" placeholder="상세설명" name="lesDetail" id="lesDetail" style="resize: none;"readonly="readonly" >${lessonVO.lesDetail}</textarea>
			</div>
		</div>
		
		</div>
		<div class="lesson-bottom shadow">
			<div class="les-add-btn">
               	<button type="button" class="button button-inline button-small button-success form-group label"  id="addLesBtn" style="display: none">목차추가</button>
            </div>
            <div class="lesIdx-div">
            	<input type="hidden" value="lidxId">
            	<c:forEach items="${lesIdxList}" var="lesIdxList"  varStatus="status">
            		<div class="lesIdx-list-div" id="lesIdx-md-div${status.index}">
            			<div class="lesIdx-md-div">
	            			<div class=lesIdx-div-1>
	            				<label class="les-lb2">차수</label>
								<input type="number" class="les-input-1 les-input-1-shadow chk" name="lesIdxList[${status.index}].lidxNum" id="lidxNum${status.index}" min="1" value="${lesIdxList.lidxNum}" readonly="readonly">
	            			</div>
	            			<div class=lesIdx-div-2>
	            				<label class="les-lb2">강의목차 제목</label>
								<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="제목" name="lesIdxList[${status.index}].lidxCont" id="lidxCont${status.index}" value="${lesIdxList.lidxCont}" readonly="readonly">
	            			</div>
            			</div>
	            		<div class="lesIdx-md-div">
	            			<div class=lesIdx-div-3>
	            				<label class="les-lb2">주소</label>
								<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="주소" name="lesIdxList[${status.index}].lidxPath" id="lidxPath${status.index}" value="${lesIdxList.lidxPath}" readonly="readonly">
	            			</div>
	            			<div class=lesIdx-div-4>
	            				<label class="les-lb2">전체시간</label>
								<input type="number" class="les-input-1 les-input-1-shadow chk" placeholder="전체시간" name="lesIdxList[${status.index}].lidxDurtime" id="lidxDurtime${status.index}" min="1" value="${lesIdxList.lidxDurtime}" readonly="readonly">
	            			</div>
							<input type="button" class="idxDelBtn" value="삭제" data-lidxid="${lesIdxList.lidxId}"  data-del="${status.index}" style="display: none">
	            			<input type="hidden" name="lesIdxList[${status.index}].lidxId" id="lidxId${status.index}" value="${lesIdxList.lidxId}" >
		            		<hr class="hr-1">
	            		</div>
            		</div >
            	</c:forEach>
            </div>
		</div>
        <div class="buttonDiv">
			<button type="button" class="button button-inline button-small button-cancel form-group label cancel" id="cancel" >목록</button>
			<button type="button" class="button button-inline button-small button-danger form-group label delete" id="delete" >삭제</button>
			<button type="button" class="button button-inline button-small button-primary form-group label update" id="update" >수정</button>
			<button type="button" class="button button-inline button-small button-primary form-group label update" id="update-real" style="display: none">수정</button>
		</div>   
	</form>
	</div>
</div>

