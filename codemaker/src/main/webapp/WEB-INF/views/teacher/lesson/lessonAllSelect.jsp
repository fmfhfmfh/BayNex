<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!-- bootstrap 사용 설정 -->
<!-- <link rel="stylesheet" href="/css/teacher/lesson/lesson.css"> -->
<link rel="stylesheet" href="/css/teacher/lesson/button.css">
<!-- <link rel="stylesheet" href="/css/teacher/lesson/selectAllLesson.css"> -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>강의조회</title>

<style>

.card{
	height: auto;
    min-height: 1080px;
    border: 1px solid;
}
.select-container-area{
	width: 100%;
    margin: 4em auto 0;
    font-family: 'LotteMartDream';
}
h2{
	font-family: 'LotteMartDream';
	color : black;
	font-size: 2.0em;
	font-weight: 600;
	margin: 0 0 0 20px;
}
#wul {
	width: 1100px;
	margin-left: 200px;
}

#hd {
	margin-left: 15px;
}

#subject {
	width: 100px;
	display: inline-block;
	margin-right: 10px;
	margin-bottom: 10px;
}
#lesson {
	width: 400px;
	display: inline-block;
	margin-right: 10px;
	margin-bottom: 10px;
}
#right {
	text-align: right;
	margin: 0 20px 0 0;
}

#regBtn {
	margin-right: 10px;
	margin-bottom: 10px;
	margin-top: 8px;
}

#selectTab{
	padding-left: 30px;
	
}
#containerId{
    width: 1300px;
   	margin-left: 140px;
}


.delClass{
    width: 40px;
    height: 27px;
    font-size: 12px;
    float: left;
    margin-left: 30px;
    padding: 0px 0px 0px 0px;
    background: #af0000;
    border: none;
    color: white;
    border-radius: 2px;
}
.upClass{
	width: 40px;
    height: 27px;
    font-size: 12px;
    float: left;
    padding: 0px 0px 0px 0px;
    background: #09116d;
    border: none;
    color: white;
    border-radius: 2px;
    margin: 0 0 0 4px;
}
.reqClass{
	width: 40px;
    height: 27px;
    font-size: 12px;
    float: left;
    padding: 0px 0px 0px 0px;
    background: #212529;
    border: none;
    color: white;
    border-radius: 2px;
    margin: 0 0 0 4px;
}
.examClass{
	width: 40px;
    height: 27px;
    font-size: 12px;
    float: left;
    padding: 0px 0px 0px 0px;
    background: #147484;
    border: none;
    color: white;
    border-radius: 2px;
    margin: 0 0 0 4px;
}

#addBtn{
	   margin-bottom: 20px;
}
.form-control-label {
  font-size: .875rem;
  font-weight: 400;
  color: #525f7f;
}


#test{border: 3px solid #1447b9;
    background: #f5f5f5;
    font-weight: 500;
    border-radius: 5px;
    color: #1447b9;
}

.lesIdxTbody:hover{
	cursor: pointer;
}
h2{
	font-family: 'LotteMartDream';
}

.lesson-top{
	display: inline-block;
    width: 100%;
    margin: 10px 0 0 0px;
    height: 450px;
}
.th-1st{
    width: 20%;
    text-align: center;
    font-weight: 600 !important;
}
.th-2nd{
    width: 16%;
    text-align: center;
    font-weight: 600;
}
.th-3rd{
    width: 16%;
    text-align: center;
    font-weight: 600;
}
.th-4th{
    width: 16%;
    text-align: center;
    font-weight: 600;
}
.th-5th{
    width: 13%;
    text-align: center;
    font-weight: 600;
}
.th-6th{
    width: 28%;
    text-align: center;
    font-weight: 600;
}
.lesson-table-div{
/* 	border: 1px solid; */
	width: 100%;
}
.lesson-table{
/* 	border: 1px solid; */
	width: 100%;
}
.lesson-thead-light{
	padding: 8px;
	border: 1px solid;
	background-color: #e9ecef;
    border-color: #dee2e6;
    color: #495057;
    font-size: 20px;
}
.lesson-tr{
	height: 40px;
	font-size: 18px;
	border-bottom: 1px solid gainsboro;
}
.lesson-thread-tr{
	height: 48px;
}
.lesson-table-2nd-div{
	margin: 30px 0 0 0;
}
.th2-1st{
    width: 20%;
    text-align: center;
    font-weight: 600 !important;
    
}
.th2-2nd{
    width: 30%;
    text-align: center;
    font-weight: 600;
}
.th2-3rd{
    width: 15%;
    text-align: center;
    font-weight: 600;
}
.th2-4th{
    width: 23%;
    text-align: center;
    font-weight: 600;
}
.th2-5th{
    padding: 0 0 0 38px;
    color: #1b223c00;
}
.th2-3rd-td{
	width: 40%;
    text-align: center;
    font-weight: 600;
}
.3rd-td-div{
	display: inline-block !important;
}
.3rd-td-div2{
	float: left !important;
	width: 70px;
}
#selBtn{
	width: 50px;
    height: 35px;
    background: #312727;
    border: none;
    border-radius: 2px;
    font-weight: 600;
    color: white;
}


.modal-body {
    position: relative;
    -ms-flex: 1 1 auto;
    flex: 1 1 auto;
    padding: 1rem;
    height: 300px;
}
.modal-table{
	width: 100%;
    font-size: 21px;
    text-align: center;
}
.modal-tr-1{
	background: #056a9a;
    color: white;
}
a:hover {
    color: #545252;
    text-decoration: underline;
 }
</style>
<script>
$(function(){
	
	// 강의목차 조회
	$('.lesIdxTbody').on("click","tr",function(){
		console.log("뭐떠라");
		var lesVal = $(this).data("lesid");
		console.log(lesVal);
	 	$.ajax({
		url:'/teacherL/selectAllLessonIndex',
		data:{'lesId':lesVal},
		method:'get',
		dataType:'json',
		success:function(data){
			var html="";
			console.log(data);
			for(var i=0; i<data.length; i++){
				var lesIdxList = data[i];
				html +="<tr>";
				html +="<td>" +lesIdxList.lidxNum+ "</td>";
				html +="<td>"+lesIdxList.lidxCont+"</td>";
				html +="</tr>";
			}
			$('.lesTbody').html(html);
		},
		error:function(data){
			alert('안됨');
			console.log(data);
		}
		})
	})
	
	// 시험 버튼
	$('#lesTbody').on('click', '.examClass', function(){
		alert('시험을 등록하시겠습니까?');
		var searchLesId=$(this).data("lesid");
		var searchSubId=$(this).data("subid");
		document.location="/exam/selectAllExam?searchLesId="+searchLesId+"&searchSubId="+searchSubId;
	})
	
	// 요청버튼
	$('#lesTbody').on('click','.reqClass',function(){
		alert('승인요청합니다.');
		var lesid = $(this).data("lesid");
		var check = $(this).data("check");
		console.log(lesid);
		document.location="/teacherL/deleteLesson?lesId="+lesid+"&check="+check;
	})
	
	if('${no}' != null && '${no}' != ''){
		alert('${no}');
	}
		
})	

// 과목선택하고 강의조회버튼
var selLes = function(){
	var subVal = $("#subject option:selected").val();
	console.log(subVal);
	$.ajax({
		url:'/teacherL/selectLesson',
		data:{'subId':subVal},
		method:'get',
		dataType:'json',
		success:function(data){
			var html="";
			for(var i=0; i<data.length; i++){
				var lessonList =  data[i];
				html += "<tr class=lesson-tr data-lesid='"+lessonList.lesId+"' data-toggle=modal data-target=#exampleModalCenter>";
				html += "<td class=th-1st>" + lessonList.lesNm+ "</td>";
				html += "<td class=th-2nd>" + lessonList.lesCont+ "</td>";
				var sdate = new Date(lessonList.lesSdate);
				console.log(moment(sdate).format('YYYY-MM-DD'));
				html += "<td class=th-3rd>" + moment(sdate).format('YYYY-MM-DD') + "</td>";
				var edate = new Date(lessonList.lesEdate);
				console.log(moment(edate).format('YYYY-MM-DD'));
				html += "<td class=th-4th>" + moment(edate).format('YYYY-MM-DD') + "</td>";
				html += "<td class=th-5th>" + lessonList.lesTerm + "</td>";
				var lescash = lessonList.lesCash;
				html += "<td class=th-6th>" + lescash.toLocaleString()+ "</td>";
				html += "</tr>";
			}
			$('.lesIdxTbody').html(html);
		},
		error:function(data){
			console.log(data);
			alert('안됨');
		}
	})
}

var addLes = function(){
	document.location="/teacherL/insertViewLesson";
}


</script>

<div class="card">
	<div class="select-container-area">
		<div class="card-body text-center">
			<div>
				<button class="button button-inline button-small button-success form-control-label" id="addBtn" style="float: right;" onclick="addLes()">강의 등록</button>
			</div>
		</div>
		<div class="lesson-top">
		<h2>강의 조회 및 개설</h2>
			<div id="right">
				<select class="form-control" id="subject" name="subId">
					<option value="0">과목</option>
					<c:forEach items="${subjectList}" var="sub">
						<c:choose>
							<c:when test="${sub.subOut == 'N'}">
								<option value="${sub.subId}">${sub.subNm}</option>
							</c:when>
						</c:choose>
					</c:forEach>
				</select> 
				<input id="selBtn" type="button" value="조회" onclick="selLes()">
			</div>
			<div class="lesson-table-div">
				<table class="lesson-table">
					<thead class="lesson-thead-light">
						<tr class="lesson-thread-tr">
							<th class="th-1st" scope="col">강의명</th>
							<th class="th-2nd" scope="col">소개</th>
							<th class="th-3rd" scope="col">개설날짜</th>
							<th class="th-4th" scope="col">마감날짜</th>
							<th class="th-5th" scope="col">기간</th>
							<th class="th-6th" scope="col">수강료</th>
						</tr>
					</thead>
					<tbody class="lesIdxTbody">
		
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalCenterTitle">강의목차 조회</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <table class="modal-table">
					<tr class="modal-tr-1">
						<th>차순</th>
						<th>목차내용</th>
					</tr>
					<tbody class="lesTbody">
					
					</tbody>
				</table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- /Modal -->
		
		<div class="lesson-down">
			<h2>임시 저장된 강의</h2>
			<div class="lesson-table-2nd-div">
				<div class="table-responsive">
					<table class="lesson-table">
							<thead class="lesson-thead-light" >
								<tr class="lesson-thread-tr" >
									<th class="th2-1st" scope="col">강의No.</th>
									<th class="th2-2nd" scope="col">강의명</th>
									<th class="th2-3rd" scope="col">강의/시험</th>
									<th class="th2-4th" scope="col">강의승인상태</th>
									<th class="th2-5th">-</th>
								</tr>
							</thead>
							<tbody id="lesTbody">
								<c:forEach items="${noLessonList}" var="no" varStatus="status">
									<tr class="lesson-tr">
										<td class="th2-1st">${status.count}</td>
										<td class="th2-2nd"><a href="/teacherL/updateViewLesson?lesId=${no.lesId}&subId=${no.subId}">${no.lesNm}</a></td>
										<td class="th2-3rd">${no.lessonCnt}/${no.examCnt}</td>
										<td class="th2-4th">
											<div class="3rd-td-div" style="display:inline-block;">
												<c:choose>
													<c:when test="${no.lesState=='1'}">
														<div class="3rd-td-div2" style="float: left; width: 70px;">임시저장</div>
													</c:when>
													<c:when test="${no.lesState=='2'}">
														<div class="3rd-td-div2" style="float: left; width: 70px;">승인중</div>
													</c:when>
													<c:when test="${no.lesState=='4'}">
														<div class="3rd-td-div2" style="float: left; width: 70px;">승인반환</div>
													</c:when>
												</c:choose>
											</div>
										</td>
										<td class="th2-4rd-td" >
										<c:if test="${no.lesState!='2' }">
											<input class="reqClass" type="button" value="요청" data-lesid="${no.lesId}" data-check="2">
											<input class="examClass" type="button" value="시험" data-lesid="${no.lesId}" data-subid="${no.subId}">
										</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
