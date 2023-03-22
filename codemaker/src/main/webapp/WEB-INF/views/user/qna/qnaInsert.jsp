<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>QNA 작성</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.0/jquery.js"></script> 
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js" defer></script>

<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

<script>
$(document).ready(function() {
	$('.summernote').summernote({
		width : 700,
		height: 300,
		lang: "ko-KR"
	});
	
	$('#insertbutton').on('click', function(){
    	var qnaTitle = $('input[name="qnaTitle"]').val();
    	var qnaCont = $('textarea[name="qnaCont"]').val();
    	
    	if(qnaTitle == '' || qnaTitle == null){
    		alert("제목을 입력하세요");
    		return;
    	} else if(qnaCont == '' || qnaCont == null){
    		alert("내용을 입력하세요");
    		return;
    	} else {
    		alert("게시글 등록이 완료되었습니다.")
    		$("#insertQna").submit();
    	}
    })
    
    $("#listBtn").on("click", function(){
    	if(confirm("작성을 취소하시겠습니까?")){
    		document.location="/user/selectAllQna?lesId=${param.lesId}";
    	}else{
    		return;
    	}
    })
})	
</script>
<style>
.note-editable p{
	text-align:left;
	font-size: 1.0em;
	}
	.card{
		width:70%;
		height:auto;
		margin:30px auto;
		min-height:900px;
		font-size: 1.2em;
/* 		border: none; */
	}
	h2{
		color : #1d25af;
		font-family: 'LotteMartDream';
		font-weight: 700;
		text-align : center;
		font-size:2.0em;
	}
#ff{
	margin: 50px 130px 0;
	background-color: white;
}
.pagination .page-item:first-child .page-link, .pagination .page-item:last-child .page-link
{
 height: 37px; 
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
div, li{
 font-family: 'LotteMartDream';
  font-weight: 500;
}
.table th{
font-family: 'LotteMartDream';
  font-weight: 700;
  font-size: 1.5em;
  text-align: center;
}
.table td{
font-family: 'LotteMartDream';
  font-weight: 500;
  font-size: 1.2em;
  text-align: center;
  line-height: 40px;
}
.table tr{
	border-top: 2px solid #bdbdbd;
    border-bottom: 2px solid #bdbdbd;
}
.card .table {
   margin-bottom: 70px;
   
}
#banner{
	margin: 20px;
}
.fix{
	margin-left : auto;
	margin-right : auto;
}
	th{
		padding : 10px;
	}
	input{
		border: 1px solid gray !important;
	}
	.note-editable {
		height:450px !important;
	}
	.note-popover{
		display:none;
	}
</style>
<div class="card shadow">
	<div id="banner">	
		<h2>QNA 등록</h2>
		<br>
	</div>	
	<div class="fix">
		<form id="insertQna" method="POST" action="/user/insertQna">
			<table>
				<tr>
					<th>제목</th>
					<th><input type="text" name="qnaTitle" style="width:700px;"></th>
				</tr>
				<tr>
					<th>내용</th>
					<th><textarea style="margin-left:100px; text-align:left;" class="summernote" name="qnaCont"></textarea></th>
				</tr>
			</table>
			<div class="col-sm-10">
				<input type="hidden" name="userId" value="${MEMBER_INFO.userId}"/>
				<input type="hidden" name="lesId" value="${param.lesId}" />
			</div>
			<div class="form-group" style="float:right;">
				<button style="font-size: 1.0em;" type="button" id="insertbutton" class="btn btn-success">등록</button>
				<button style="font-size: 1.0em;" type="button" id="listBtn" class="btn btn-warning">나가기</button>
			</div>	
		</form>
	</div>
</div>

