<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta charset="UTF-8">

<script src="/js/teacher/exam/exam.js"></script>

<!-- 시험 상세& 수정 page css -->
<link href="/css/teacher/exam/exam-update.css" rel="stylesheet"/>

<script>
$(function() {

	// #e6f4ea, queAnswer, anw
	// 정답 체크시 오버레이
	$(document).on('change', '.d6 .chk' ,function() {
		var ols = $(this).parents('.d6').children('.anw').children(".ansContList");
		var chks = $(this).parents('.d6').children('.anw').children('.chk');
		
		for(var i=0; i < chks.length; i++){
			if($(this).val() != chks[i].value){
				chks[i].checked = false;
				ols[i].style = 'background-color: #fff;';
			}else{
				if($(this).is(":checked") == true){
					ols[i].style = 'background-color: rgba(230, 244, 234);';
				}else{
					ols[i].style = 'background-color: #fff;';
				}
			}
		}
	});
	
	$(document).on('change', 'input[type=checkbox]' ,function() {
		var ol = $(this).prevAll("input[type=text]");
		
		if($(this).is(":checked") == true){
			ol.attr('style','background-color: rgba(230, 244, 234);');
		}else{
			ol.attr('style','background-color: #fff;');
		}
	});
	
	// 문제 추가
	$('#plusBtn').on('click', function() {
		createExam();
		
		$('.d8').attr('style','height : 588px;');
	});
	
	// 문제 삭제
	$(document).on('click', '.delBtn', function(){
		// 해당 문제 삭제
		var parent = $(this).parents('div .d5');
		// 부모 삭제
		parent.remove();
		
	});
	
	// 기존 문제 삭제
	$('.delIdBtn').on('click', function(){
		// 문제 삭제시에 hidden 태그를 생성해준다. data-queid
		str = '<input type="hidden" name="delqueIdList" value="'+ $(this).data('queid') +'">';
		$('#examf').append(str);
		
		// 해당 문제 삭제
		var parent = $(this).parents('div .d5');
		// 부모 삭제
		parent.remove();
	});
	
	// 목록으로 가기
	$('#cancle').on('click', function(){
		$('#examf').attr('action', '/exam/selectAllExam');
		$('#examf').submit();
	});
	
	// 수정 화면 요청
	$('#updateBtn').on('click', function(){
		$('#hh2').text('시험 수정');
		
		// readonly 제거
		$('.read').removeAttr("readonly");

		// class uhide 보이지 않게
		$('.uhide').attr('style','display: none');

		// class hide 보이게
		$('.hide').attr('style','display: inline-block');
		
		// 
		$('.d4').attr('style','height: 615px; ');
		$('.d5').attr('style','height: 615px; ');
		
		// 체크 박스 - 체크 방지 해제
		$('.chk').attr('onclick', 'return true;');
	});
	
	// 임시저장
	$('#temps').on('click', function(){
		// 빈칸 체크
		var state = 0;
		$('.form-control').each(function(index, data){
			if($(this).val().trim() == ''){
				alert('문제 또는 해설이 입력되지 않았습니다.');
				state = 1;
				return false;
			}
		});
		if(state == 0){
			if($('.chk:checked').length < $('.d5').length){
				alert('정답이 입력되지 않았습니다.');
				state = 1;
				return false;
			}
		}
		
		if(state == 0){
			str = '<input type="hidden" name="examState" value="1">';
			$('#examf').append(str);
			$('#examf').submit();
		}
	});
	
	// 등록하기 - 상태값을 수정하면 끝
	$('#regBtn').on('click', function(){
		// 빈칸 체크
		var state = 0;
		$('.form-control').each(function(index, data){
			if($(this).val().trim() == ''){
				alert('문제 또는 해설이 입력되지 않았습니다.');
				state = 1;
				return false;
			}
		});
		if(state == 0){
			if($('.chk:checked').length < $('.d5').length){
				alert('정답이 입력되지 않았습니다.');
				state = 1;
				return false;
			}
		}
		
		if(state == 0){
			str = '<input type="hidden" name="examState" value="2">';
			$('#examf').append(str);
			$('#examf').submit();
		}
	});
	
	// 시험 삭제
	$('#del').on('click', function(){
		$('#examf').attr('action', '/exam/deleteExam');
		$('#examf').submit();
	})

})

</script>
<title>examUpdate</title>

<form:form action="/exam/updateExam" id="examf" method="post" commandName="examVO" name="examVO">
	<input type="hidden" name="searchSubId" value="${examVO.searchSubId}">
	<input type="hidden" name="searchLesId" value="${examVO.searchLesId}">
	<input type="hidden" name="searchExamState" value="${examVO.searchExamState}">
	<input type="hidden" name="examId" value="${examVO.examId}">
	<input type="hidden" name="lesId" value="${examVO.lesId}">
	<input type="hidden" name="lidxId" value="${examVO.lidxId}">
	
	<div id="d2">
		<div id="d1"></div>
		<br>
		<div id="d3">
			<h2 id="hh2">시험</h2>
			<br> 
			<label for="sel1" id="sel1">
				<h4 class="uhide">${ev.examNm }</h4>
				<input type="text" name="examNm" id="examNm" class="form-control read hide" value="${ev.examNm }" readonly="readonly">
			</label>
		</div>
		<br>
		<c:forEach items="${questionList }" var="question" varStatus="status">
			<br>
			<div class="d5">
				<div class="d4"></div>
				<div class="d6">
					<label for="sel2" class="sel2 uhide"><h5>${status.count }. ${question.queCont }</h5></label><br>
					<label for="sel2" class="sel2 hide">문제를 입력해주세요.</label>
					<input type="hidden" name="questionList[${status.index }].queId" class="form-control" value="${question.queId }"/>
					<input type="text" name="questionList[${status.index }].queCont" class="form-control que read hide" value="${question.queCont }"  readonly="readonly"/> 
					<label for="sel4" class="sel4 hide">배점을 입력해주세요.(숫자만 입력가능합니다.)&nbsp;&nbsp;&nbsp;</label>
					<label for="sel4" class="sel4 uhide">배점 : </label>
					<input type="number" name="questionList[${status.index }].queScore" class="form-control que read queS" min="1" value="${question.queScore }" readonly="readonly"/>
					<br>
					<label for="sel3" class="hide">보기를 입력해주세요. </label>
					<c:forEach begin="${status.index*4 }" end="${status.count*4-1 }" items="${answersheetLists }" varStatus="vs" var="answersheet">
						<input type="hidden" name="answersheetLists[${vs.index }].ansId" class="form-control" value="${answersheet.ansId }"/>
						<div class="anw">
							<c:choose>
								<c:when test="${vs.count eq fn:split(question.queAnswer, ',')[0] }">
									<input type="text" name="answersheetLists[${vs.index }].ansCont" class="form-control radi read ansContList" 
											value="${answersheet.ansCont }" readonly="readonly" style="background-color: rgba(230, 244, 234) "/>
									<input type="checkbox" name="questionList[${status.index }].queAnswer" value="${vs.count }" class="chk read" onclick="return false;" checked="checked" />
								</c:when>
								<c:when test="${vs.count eq fn:split(question.queAnswer, ',')[1] }">
									<input type="text" name="answersheetLists[${vs.index }].ansCont" class="form-control radi read ansContList" 
											value="${answersheet.ansCont }" readonly="readonly" style="background-color: rgba(230, 244, 234) "/>
									<input type="checkbox" name="questionList[${status.index }].queAnswer" value="${vs.count }" class="chk read" onclick="return false;" checked="checked" />
								</c:when>
								<c:when test="${vs.count eq fn:split(question.queAnswer, ',')[2] }">
									<input type="text" name="answersheetLists[${vs.index }].ansCont" class="form-control radi read ansContList" 
											value="${answersheet.ansCont }" readonly="readonly" style="background-color: rgba(230, 244, 234) "/>
									<input type="checkbox" name="questionList[${status.index }].queAnswer" value="${vs.count }" class="chk read" onclick="return false;" checked="checked" />
								</c:when>
								<c:when test="${vs.count eq fn:split(question.queAnswer, ',')[3] }">
									<input type="text" name="answersheetLists[${vs.index }].ansCont" class="form-control radi read ansContList" 
											value="${answersheet.ansCont }" readonly="readonly" style="background-color: rgba(230, 244, 234) "/>
									<input type="checkbox" name="questionList[${status.index }].queAnswer" value="${vs.count }" class="chk read" onclick="return false;" checked="checked" />
								</c:when>
								<c:otherwise>
									<input type="text" name="answersheetLists[${vs.index }].ansCont" class="form-control radi read ansContList" 
											value="${answersheet.ansCont }" readonly="readonly" />
									<input type="checkbox" name="questionList[${status.index }].queAnswer" value="${vs.count }" class="chk read" onclick="return false;" />						
								</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>
					<div class="anw">
						<label for="sel5" class="sel5 hide">문제해설을 입력해주세요.</label>
						<textarea class="form-control comment read" rows="5" name="questionList[${status.index }].queExplain" readonly="readonly">${question.queExplain}</textarea>
					</div>
					<div class="anw rig">
						<input type="button" class="btn btn-default delIdBtn hide" value="문제삭제" data-queid="${question.queId }">
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</form:form>
<div class="btns">
	<input type="button" class="btn btn-default hide" id="plusBtn" value="문제추가">
	<input type="button" class="btn btn-default hide" id="temps" value="임시저장">
	<c:if test="${ev.examState == '1'}">
		<input type="button" class="btn btn-default uhide" id="updateBtn" value="수정하기">
		<input type="button" class="btn btn-default uhide" id="examDelBtn" value="시험 삭제하기" data-toggle="modal" data-target="#exampleModalCenter">
		<input type="button" class="btn btn-default" id="regBtn" value="등록하기"> 
	</c:if>
	<c:if test="${ev.examState == '2'}">
		<input type="button" class="btn btn-default uhide" id="updateBtn" value="수정하기">
		<input type="button" class="btn btn-default uhide" id="examDelBtn" value="시험 삭제하기" data-toggle="modal" data-target="#exampleModalCenter">
	</c:if>
	<c:if test="${ev.examState == '5'}">
		<input type="button" class="btn btn-default uhide" id="updateBtn" value="수정하기">
		<input type="button" class="btn btn-default uhide" id="examDelBtn" value="시험 삭제하기" data-toggle="modal" data-target="#exampleModalCenter">
	</c:if>
	<input type="button" class="btn btn-default" id="cancle" value="목록으로 가기">
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong>경 고!</strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	해당 시험을 삭제하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="del">삭제하기</button>
        &nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="clo">취소하기</button>
      </div>
    </div>
  </div>
</div>
