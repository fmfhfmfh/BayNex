<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/teacher/lesson/mypage-style.css">
<link rel="stylesheet" href="/css/teacher/lesson/button.css">
<link rel="stylesheet" href="/css/teacher/lesson/lessonInsert.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/js/teacher/exam/exam.js"></script>

<style>
.lesson-div{
	padding:19px 0 0 0;
}
</style>

<script>
$(function(){
		var index = 1;
	
	// 강의목록 추가
	$('#addLesBtn').on('click', function() {
		console.log('눌림');
		
		str="";
		str +='<div class="lesIdx-list-div" id="lesIdx-md-div['+index+']">';
		str +='	<div class="lesIdx-md-div">';
		str +='	<div class=lesIdx-div-1>';
		str +='		<label class="les-lb2">차수</label>';
		str +='		<input type="number" class="les-input-1 les-input-1-shadow chk" name="lesIdxList['+index+'].lidxNum" id="lidxNum${status.index}" min="1">${lesIdxList.lidxNum}';
		str +='	</div>';
		str +='	<div class=lesIdx-div-2>';
		str +='		<label class="les-lb2">강의목차 제목</label>';
		str +='		<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="제목" name="lesIdxList['+index+'].lidxCont" id="lidxCont${status.index}" value="${lesIdxList.lidxCont}">';
		str +='	</div>';
		str +='	</div>';
		str +='<div class="lesIdx-md-div">';
		str +='	<div class=lesIdx-div-3>';
		str +='		<label class="les-lb2">주소</label>';
		str +='		<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="주소" name="lesIdxList['+index+'].lidxPath" id="lidxPath${status.index}" value="${lesIdxList.lidxPath}">';
		str +='	</div>';
		str +='	<div class=lesIdx-div-4>';
		str +='		<label class="les-lb2">전체시간</label>';
		str +='		<input type="number" class="les-input-1 les-input-1-shadow chk" placeholder="전체시간" name="lesIdxList['+index+'].lidxDurtime" id="lidxDurtime${status.index}" min="1" value="${lesIdxList.lidxDurtime}">';
		str +='	</div>';
		str +='		<input type="button" class="newIdxDelBtn" value="삭제"  data-del="lesIdx-md-div['+index+']">';
		str +='	<hr class="hr-1">';
		str +='</div>';
		str +='</div >';
      	
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

	// 강의등록 버튼
	$('#push').on('click', function(){
// 		alert('등록');
		lessonChk();
	})
	
	// 취소 버튼
	$('#cancel').on('click',function(){
		document.location="/teacherL/selectSubject";
	})
	
	
	// 모달창 시험 등록버튼
	$('#yesBtn').on('click',function(){
		$('#modalChk').val('Y');
		$('#lesForm').submit();
		
	})
	
	// 모달창 취소 버튼
	$('#noBtn').on('click',function(){
		$('#modalChk').val('N');
		alert('등록되었습니다!');
		$('#lesForm').submit();
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


<!-- 강의 추가 -->
<div class="card" >
	<div class="select-container-area">
	<form id="lesForm" action="${cp}/teacherL/insertLesson" method="POST" >
	<input type="hidden" id="modalChk" name="modalChk" value="">
		<div class="lesson-top">	
			<div class="les-title-div">
				<h2>강의등록</h2>
			</div>	
			<div class="lesson-div shadow">
				<div class="les-div-3">
					<label class="les-lb">강의과목</label>
					<select name="subId" id="subId">
	  					<option value="0">과목</option>
						<c:forEach items="${subjectList}" var="sub"	>
							<c:choose>
								<c:when test="${sub.subOut == 'N'}">
									<option value="${sub.subId}">${sub.subNm}</option>
								</c:when>
							</c:choose>
						</c:forEach>
	  				</select>              
				</div>
				<div class="les-div-2">
					<label class="les-lb">강의명</label>
					<input type="text"  class="les-input-1 les-input-1-shadow chk" placeholder="강의명" name="lesNm" id="lesNm">
				</div>
				<div class="les-div-2">
					<label class="les-lb">강의소개</label>
					<input type="text"  class="les-input-1 les-input-1-shadow chk" placeholder="소개" name="lesCont" id="lesCont" >
				</div>
				<div class="les-div-4">
					<label class="les-lb">상세내용</label>
					<textarea rows="6" cols="25" class="les-input-2 les-input-1-shadow chk" placeholder="상세설명" name="lesDetail" id="lesDetail" style="resize: none;" ></textarea>
				</div>
			</div>
		</div>
		<div class="lesson-bottom shadow">
			<div class="les-add-btn">
               	<button type="button" class="button button-inline button-small button-success form-group label"  id="addLesBtn">목차추가</button>
            </div>
            <div class="lesIdx-div">
            	<input type="hidden" value="lidxId">
           		<div class="lesIdx-list-div" id="lesIdx-md-div">
           			<div class="lesIdx-md-div">
            			<div class=lesIdx-div-1>
            				<label class="les-lb2">차수</label>
							<input type="number" class="les-input-1 les-input-1-shadow" name="lesIdxList[0].lidxNum" id="lidxNum${status.index}" min="1">${lesIdxList.lidxNum}
            			</div>
            			<div class=lesIdx-div-2>
            				<label class="les-lb2">강의목차 제목</label>
							<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="제목" name="lesIdxList[0].lidxCont" id="lidxCont${status.index}" value="${lesIdxList.lidxCont}">
            			</div>
           			</div>
            		<div class="lesIdx-md-div">
            			<div class=lesIdx-div-3>
            				<label class="les-lb2">주소</label>
							<input type="text" class="les-input-1 les-input-1-shadow chk" placeholder="주소" name="lesIdxList[0].lidxPath" id="lidxPath${status.index}" value="${lesIdxList.lidxPath}">
            			</div>
            			<div class=lesIdx-div-4>
            				<label class="les-lb2">전체시간</label>
							<input type="number" class="les-input-1 les-input-1-shadow chk" placeholder="전체시간" name="lesIdxList[0].lidxDurtime" id="lidxDurtime${status.index}"  min="1" value="${lesIdxList.lidxDurtime}">
            			</div>
	            		<hr class="hr-1">
            		</div>
           		</div >
            </div>
            <div class="buttonDiv">
				<button type="button" class="button button-inline button-small button-primary form-group label" id="push" data-toggle=modal data-target="">등록</button>
				<button type="button" class="button button-inline button-small button-danger form-group label" id="cancel" >취소</button>
			</div>   
		
		</div>
	</form>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <h2 class="h2Modal">시험을 등록하시겠습니까?</h2>
        <button type="button" class="btn btn-secondary yesBtn" data-dismiss="modal" id="yesBtn">네</button>
        <button type="button" class="btn btn-secondary noBtn" data-dismiss="modal" id="noBtn">아니오</button>
      </div>
<!--       <div class="modal-footer"> -->
<!--       </div> -->
    </div>
  </div>
</div>
<!-- /Modal -->
