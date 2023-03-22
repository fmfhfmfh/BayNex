<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 썸머노트 설정 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.0/jquery.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js" defer></script>

<!-- 노트css -->
<link href="/css/user/mypage/mypage-note-select.css" rel="stylesheet"/>
<script>
	$(document).ready(function() {
		// 써머노트 사용
		$('#summernote').summernote({
	        tabsize: 2,
	        height: 600,
	        width: 820,
	        airmode : true,
	        disableResizeEditor: true, // 사이즈 조절 불가
			toolbar: [
			]
		});
		// 읽기만 가능
		$('#summernote').summernote('disable');
		// 필기내용 넣어주기
		$('#summernote').summernote('code', '${noteVO.noteCont}');
		
		// 수정
		$('#updateBtn').on('click', function(){
			document.location = "/note/updateViewNote?noteId=${noteVO.noteId }";
		});
		
		// 삭제
		$('#delBtn').on('click', function(){
			document.location = "/note/deleteNote?noteId=${noteVO.noteId }";
		});
		
		// 목록
		$('#btnList').on('click', function(){
			document.location = "/note/selectPageNote";
		});
	});
</script>
<div class="note-select-box shadow" role="main">
	<div class="note-select-item">
		<p class="mb-0 nfn" id="pt"><strong>필기 노트</strong></p>
		<div class="divider"></div>
		<form name="form" id="form" role="form">
			<label for="title" class="nfn" id="nt"><strong>필기 제목</strong></label>
			<div class="mb-3">
				<input type="text" id="noteTitle" class="form-control" name="noteTitle" value="${noteVO.noteTitle }" readonly="readonly">
			</div>
			<div class="mb-3">
				<textarea class="form-control" id="summernote" name="noteCont" readonly="readonly"></textarea>
			</div>
		</form>
		<div id="d1">
			<button type="button" class="btn btn-sm btn-primary" id="updateBtn">수정</button>
			<button type="button" class="btn btn-sm btn-primary" id="delBtn">삭제</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		</div>
	</div>
</div>

