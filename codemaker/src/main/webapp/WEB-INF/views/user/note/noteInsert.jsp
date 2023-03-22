<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- summernote -->
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.0/jquery.js"></script> 
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>

<script>
$(function(){
	$('#noteCont').summernote({
		placeholder: '내용을 입력해주세요',
        tabsize: 2,
        height: 500,
        width: 600,
        disableResizeEditor: true, // 사이즈 조절 불가
		toolbar: [
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['view', ['fullscreen', 'codeview', 'help']]
		]
	});
	
	// 등록하기
	$('#regBtn').on('click', function(){
		// 빈칸이 있을 경우 등록 안됨.
		if($('#noteTitle').val() == '' || $('#noteCont').val() == ''){
// 			Console.log('aa');
			alert('내용을 입력해주세요.');
		}else{
			$.ajax({
				url : '/note/insertNote',
				method : 'post',
				data : $('#notef').serialize(),
				success : function(res) {
					alert("노트가 등록되었습니다.");
					// 부모창 리로드
					opener.location.reload();
					window.close();
				},
				error : function(xhr) {
					alert("상태" + xhr.status);
				}
			});
		}
		
	});
	
	// 작성 취소
	$('#cancle').on('click', function(){
		window.close();
	});
})

</script>
<style>
body{
 	background-color: snow;
}
#d1{
 	margin: 15px;
}
#pt{
	font-size: 25px;
}
.nfn{
	color: #32325d;
}
#noteTitle{
	width: 600px;
}
#d2{
	text-align: right;
}
#regBtn{
	margin-right: 5px;
}
</style>
<title>note Insert</title>
</head>
<body>
<div id="d1">
	<p class="mb-0 nfn" id="pt"><strong>필기 노트</strong></p>
	<br>
	<form id="notef" action="/note/insertNote" method="post">
		<label for="title" class="nfn" id="nt"><strong>필기 제목</strong></label>
		<div class="mb-3">
			<input type="text" id="noteTitle" class="form-control" name="noteTitle">
		</div>
		<br>
		<div class="mb-3">
			<textarea id="noteCont" name="noteCont"></textarea>
		</div>
		<div class="mb-3" id="d2">
			<input type="button" class="btn btn-sm btn-primary" value="저장하기" id="regBtn">
			<input type="button" class="btn btn-sm btn-primary" value="작성취소" id="cancle">
		</div>
	</form>
</div>
</body>
</html>