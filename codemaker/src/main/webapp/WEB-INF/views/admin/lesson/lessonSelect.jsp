<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/admin/lesson/lesson-select.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
$(function(){
	//강의 승인 상태 변경
	$('#regBtn-modal').on('click', function() {
		$('#lesState').val("3");
		$.ajax({
			url : '/admin/updateLesson',
			method : 'post',
			data : $('#ff').serialize(),
			success : function(res){
				alert("강의가 등록되었습니다.");
				opener.parent.location.reload();
   				self.close();
			},
			error: function(xhr){
				alert("상태"+xhr.status);
			}
		});
	});
	
	// 반려
	$('#cancle').on('click', function() {
		$('#lesState').val("4");
		$('#lesCash').val("0");
		$('#lesTerm').val("0");
		$.ajax({
			url : '/admin/updateLesson',
			method : 'post',
			data : $('#ff').serialize(),
			success : function(res){
				alert("강의가 반려되었습니다.");
				opener.parent.location.reload();
   				self.close();
			},
			error: function(xhr){
				alert("상태"+xhr.status);
			}
		});
	});
	
	
	// 강의영상 클릭시
	$('a[id^="videoClick_"]').on('click',function(){
		var path = $(this).attr('value');
		var lidxId = $(this).data('lidxid');
		window.open("/admin/selectYoutube?lidxPath="+path+"&lidxId="+lidxId, "video_popup", "width=1100,height=900, left=30, top=30");
	});
	
})

</script>


<div class="lesson-detail-box">
	<h2 class="h2-a">강의 상세 조회</h2>
	<div class="">
		<div class="lesson-detail-item">
			<span class="lesson-info">강의명</span>
			<span class="span-st">${lessonVO.lesNm}</span>			
		</div>
		<div class="lesson-detail-item">
			<span class="lesson-info">강의소개</span>
			<span class="span-st">${lessonVO.lesCont}</span>
		</div>
		<div class="lesson-detail-item">
			<span class="lesson-info">담당선생님</span>
			<span class="span-st">${lessonVO.tchNm}</span>
		</div>
		<c:if test="${lessonVO.lesState == '3' }">
			<div class="lesson-detail-item">
				<span class="lesson-info">강의기간</span>
				<span class="span-st">${lessonVO.lesTerm}일</span>
			</div>
			<div class="lesson-detail-item">
				<span class="lesson-info">강의비용</span>
				<span class="span-st">${lessonVO.lesCash}원</span>
			</div>
		</c:if>
	</div>
	<div class="lesson-index-div">
		<h3 class="h3-a">강의 목차</h3>
		<table class="lesson-index-tb">
			<thead>
				<tr class="tr-st1">
					<th class="th-st" scope="col">강의No.</th>
					<th class="th-st" scope="col">강의명</th>
					<th class="th-st" scope="col">동영상</th>
				</tr>
			</thead>
			<tbody id="lesTbody">
				<c:forEach items="${lessonVO.lessonIndexList}" var="lessonIndex" >
					<tr class="trtr tr-st2">
						<td>${lessonIndex.lidxNum}강</td>
						<td>${lessonIndex.lidxCont}</td>
						<td><a href="#" id="videoClick_${status.index}" value="${lessonIndex.lidxPath}" class="videoA" data-lidxid="${lessonIndex.lidxId}" >
							<img class="video-img" src="/images/user/lesson/video2.png"></a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${lessonVO.lesState == '2'}">
		<div class="run-btn-box">
			<input type="button" class="run-btn fw-600 " value="승인" id="regBtn" data-toggle=modal data-target="#exampleModalCenter">
			<input type="button" class="run-btn fw-600 " value="반려" id="cancle" >
		</div>
	</c:if>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalCenterTitle">강의개설 정보</h3>
      </div>
      <div class="modal-body">
      	<form action="/admin/updateLesson" id="ff" method="post">
      		<input type="hidden"  value="${lessonVO.lesId}" name="lesId">
      		<input type="hidden" name="lesState" id="lesState">
			<div class="les-md-div2">
	     		<h4 class="h4-st">강의 신청기간</h4>
			</div>
	     	<div class="les-md-div">
				<div class="les-div-3">
					<label class="les-lb">시작일</label>
					<input type="date"  class="les-input-1 les-input-1-shadow chk"  name="lesSdate" id="lesSdate">
				</div>
				<div class="les-div-3">
					<label class="les-lb">종료일</label>
					<input type="date" class="les-input-1 les-input-1-shadow chk"  name="lesEdate" id="lesEdate">
				</div>
			</div>
			<div class="les-md-div">
				<div class="les-div-3">
					<label class="les-lb">수강료</label>
					 <input type="number"  class="les-input-1 les-input-1-shadow chk"  placeholder="수강료" name="lesCash" id="lesCash" min="1" >&nbsp;원
				</div>
			</div>
			<div class="les-md-div">
				<div class="les-div-3">
					<label class="les-lb">기간</label>
					<input type="number"  class="les-input-1 les-input-1-shadow chk"  placeholder="기간"  name="lesTerm" id="lesTerm"  min="1"  >&nbsp;일
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary btn-st" data-dismiss="modal" style="font-weight: 600;" id="regBtn-modal">등록</button>
        <button type="button" class="btn btn-secondary btn-st" data-dismiss="modal" style="font-weight: 600;">취소</button>
      </div>
    </div>
  </div>
</div>
<!-- /Modal -->

