<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='/fullcalendar/packages/core/main.css' rel='stylesheet' />
<link href='/fullcalendar/packages/daygrid/main.css' rel='stylesheet' />
<link href='/fullcalendar/packages/timegrid/main.css' rel='stylesheet' />
<link href='/fullcalendar/packages/list/main.css' rel='stylesheet' />

<script src='/fullcalendar/packages/core/main.js'></script>
<script src='/fullcalendar/packages/interaction/main.js'></script>
<script src='/fullcalendar/packages/daygrid/main.js'></script>
<script src='/fullcalendar/packages/timegrid/main.js'></script>
<script src='/fullcalendar/packages/list/main.js'></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var flag = true;
    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'dayGrid', 'list', 'interaction' ],
      header: {
    	 left: 'prev,next today',
         center: 'title',
         right: 'dayGridMonth,listWeek'
      },
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
    	// 종료 날짜 하루 빼준다.
    	moment(arg.end.setDate(arg.end.getDate() - 1)).format('YYYY-MM-DD HH:mm');
    	
    	$('.modal').find('#sDate').val(moment(arg.start).format('YYYY-MM-DD'));
    	$('.modal').find('#schTSdate').val(moment(arg.start).format('HH:mm'));
		$('.modal').find('#eDate').val(moment(arg.end).format('YYYY-MM-DD'));
		$('.modal').find('#schTEdate').val(moment(arg.end).format('HH:mm'));
		
		$('.modal').attr('style', 'padding-right : 17px; opacity : 1; display : block;');
		
        calendar.unselect();
      },
      editable: false,
   	  eventLimit: true,
      events: ${jarray},
      eventClick : function(info) {
		   	if(flag){
			   	//Show contextmenu:
				//Get window size:
				var winWidth = $(document).width();
				var winHeight = $(document).height();
				
				//Get pointer position:
				var posX = info.jsEvent.pageX;
				var posY = info.jsEvent.pageY;
				
				//Get contextmenu size:
				var menuWidth = $(".contextmenu").width();
				var menuHeight = $(".contextmenu").height();
				//Security margin:
				var secMargin = 10;
				//Prevent page overflow:
				if(posX + menuWidth + secMargin >= winWidth
				&& posY + menuHeight + secMargin >= winHeight){
				  //Case 1: right-bottom overflow:
				  posLeft = posX - menuWidth - secMargin + "px";
				  posTop = posY - menuHeight - secMargin + "px";
				}
				else if(posX + menuWidth + secMargin >= winWidth){
				  //Case 2: right overflow:
				  posLeft = posX - menuWidth - secMargin + "px";
				  posTop = posY + secMargin + "px";
				}
				else if(posY + menuHeight + secMargin >= winHeight){
				  //Case 3: bottom overflow:
				  posLeft = posX + secMargin + "px";
				  posTop = posY - menuHeight - secMargin + "px";
				}
				else {
				  //Case 4: default values:
				  posLeft = posX + secMargin + "px";
				  posTop = (posY-47) + secMargin + "px";
				};
				
				//Display contextmenu:
				$(".contextmenu").css({
				  "left": posLeft,
				  "top": posTop
				}).show();
				flag = false;
				
				// 일정 수정하기
				$('#ua').on('click', function(){
					$('#schId').val(info.event.id);
					$(".contextmenu").hide();
					
					$('.modal').attr('style', 'padding-right : 17px; opacity : 1; display : block;');
					$('#ff').attr('action','/admin/updateSchedule');
					$('.modal-title').text('일정 수정');
					$('#save-event').val('수정하기');
		 		    $('.modal').find('#schCont').val(info.event.title);
		 		    
		 			// 종료 날짜 하루 빼준다.
		 			if(info.event.end != null){
			 	    	moment(info.event.end.setDate(info.event.end.getDate() - 1)).format('YYYY-MM-DD HH:mm');
			 			$('.modal').find('#eDate').val(moment(info.event.end).format('YYYY-MM-DD'));
			 			$('.modal').find('#schTEdate').val(moment(info.event.end).format('HH:mm'));
		 			}else{
			 			$('.modal').find('#eDate').val(moment(info.event.start).format('YYYY-MM-DD'));
			 			$('.modal').find('#schTEdate').val(moment(info.event.start).format('HH:mm'));
		 			}
		 			
		 		    $('.modal').find('#sDate').val(moment(info.event.start).format('YYYY-MM-DD'));
		 	    	$('.modal').find('#schTSdate').val(moment(info.event.start).format('HH:mm'));
		 			
		 		    flag = true;
				});
				
				// 일정 삭제하기
				$('#da').on('click', function(){
					console.log('삭제');
					$('#schId').val(info.event.id);
		 		    flag = true;
					$(".contextmenu").hide();
					$('#ff').attr('action','/admin/deleteSchedule');
					$('#ff').submit();
				});
				
		   	}else{
		  		$(".contextmenu").hide();
		  		flag = true;
		   	}
	   }
      
    })
    calendar.render();
  });
  
  
  $(function(){
	  
	  // 일정 등록 및 수정
	  $('#save-event').on('click', function(){
		  // 일정 빈칸 체크
		  if($('#schCont').val() == null || $('#schCont').val() == ''){
			  alert('일정 내용을 입력해주세요.');
		  }else{
			  //schSdate,schEdate
			  var sDate = $('#sDate').val() + ' ' + $('#schTSdate').val();
			  var eDate = $('#eDate').val() + ' ' + $('#schTEdate').val();
			  $('#schSdate').val(sDate);
			  $('#schEdate').val(eDate);
			  
			  $('#ff').submit();
		  }
	  });
	  
	  
	  // 입력된 값 초기화
	  $(document).on('click', '.clo', function(){
		  $('.modal').find('form')[0].reset();
		  $('.modal-title').text('일정 등록');
		  $('#save-event').val('등록하기');
		  $('#ff').attr('action','/admin/insertSchedule');
		  $('.modal').attr('style', 'display : none;');
	  });
	  
	  var modal = document.getElementById('myModal');
	  
      window.onclick = function(event) {
          if (event.target == modal) {
			  $('.modal').find('form')[0].reset();
			  $('.modal-title').text('일정 등록');
			  $('#save-event').val('등록하기');
			  $('#ff').attr('action','/admin/insertSchedule');
			  $('.modal').attr('style', 'display : none;');
          }
      }

	  
		
  })
  
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}
#calendar {
	max-width: 900px;
	margin: 0 auto;
}
.contextmenu {
	display: none;
	position: absolute;
	width: 200px;
	margin: 0;
	padding: 0;
	background: #FFFFFF;
	border-radius: 5px;
	list-style: none;
	box-shadow: 0 15px 35px rgba(50, 50, 90, 0.1), 0 5px 15px
		rgba(0, 0, 0, 0.07);
	overflow: hidden;
	z-index: 999999;
}
.contextmenu li {
	border-left: 3px solid transparent;
	transition: ease .2s;
}
.contextmenu li a {
	display: block;
	padding: 10px;
	color: #B0BEC5;
	text-decoration: none;
	transition: ease .2s;
}
.contextmenu li:hover {
	background: #CE93D8;
	border-left: 3px solid #9C27B0;
}
.contextmenu li:hover a {
	color: #FFFFFF;
}

.modal-open .modal{
	overflow-x : hidden;
	overflow-y : auto;
}
.modal {
	display: none; 
	position: fixed;
	padding-top: 130px;
	left: 120px;
	z-index: 1;
	background-color: rgb(0,0,0); 
	background-color: rgba(0,0,0,0.4);
	opacity: 0;
}
.modal-content {
	box-shadow : 0 5px 15px rgba(0,0,0,0.5);
	position : relative;
    background-color: #fff;
	background-clip : padding-box;
	padding-left: 15px;
	border : 1px solid rgba(0,0,0,0.2);
	border-radius : 6px;
	outline: 0;
}
.modal-header{
	padding-top: 9px;
    padding-left: 5px;
    padding-bottom: 0px;
	border-bottom: 1px solid #e5e5e5;
}
.modal-header .close{
	margin-top: -2px;
}
button.clsoe{
	padding: 0;
	cursor: porinter;
	background: 0 0;
	border: 0;
	font-family: inherit;
}
.close{
	float: right;
	font-size: 21px;
	font-weight: 700;
	line-height: 1;
	color: #000;
	text-shadow: 0 1px 0 #fff;
	opacity: 0.8;
}
.modal-title{
	margin: 0;
	line-height: 1.42857143;
	font-size: 20px;
}
.modal-body{
	position: relative;
	padding: 15px;
}
.modal-footer{
	padding: 5px;
	text-align: right;
	border-top: 1px solid #e5e5e5;
	margin-bottom: 0;
	margin-left: 5px;
}
.btn-primary{
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}
.btn{
	display: inline-block;
	margin-bottom: 0;
	font-weight: 400;
	text-align: center;
	white-space: nowrap;
	background-image: none;
	border: 1px solid transparent;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	border-radius: 4px;
	cursor: pointer;
}
.btn-default{
	color: #333;
	background-color: #fff;
	border-color: #ccc;
}
.modal-dialog {
    width: 600px;
    margin: 30px auto;
    position: relative;
}
#save-event{
	margin-right: 5px;
}
.row{
	margin-bottom: 5px;
}
.col-xs-4{
	margin-right: 5px;
	font-weight: bold;
}
.title{
	margin-left: 12px;
}
#clo{
	height: 34px;
    color: #fff;
    background-color: #337ab7;
    border-color: #337ab7;
    width: 70px;
}
</style>
</head>
<body>
	<div id='calendar'></div>

	<ul class="contextmenu">
		<li><a id="ua" data-toggle="modal">일정 수정하기</a></li>
		<li><a id="da" href="#">일정 삭제하기</a></li>
	</ul>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content">
				<form action="/admin/insertSchedule" method="post" id="ff">
					<input type="hidden" name="schId" id="schId" value=""/>
					<input type="hidden" id="schSdate" name="schSdate" value="">
			  		<input type="hidden" id="schEdate" name="schEdate" value="">
			  		
					<div class="modal-header">
						<h4 class="modal-title">일정 등록</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<label class="col-xs-4" for="starts-at">스케줄 시작일</label> 
								<input type="date" name="sDate" id="sDate" />
								<input type="time" name="schTSdate" id="schTSdate" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<label class="col-xs-4" for="ends-at">스케줄 종료일</label> 
								<input type="date" name="eDate" id="eDate" />
								<input type="time" name="schTEdate" id="schTEdate" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<label class="col-xs-4 title" for="title">스케줄 내용</label> 
								<input type="text" name="schCont" id="schCont" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-primary" id="save-event" value="등록하기">
						<input type="button" class="btn btn-primary clo" value="닫기">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
