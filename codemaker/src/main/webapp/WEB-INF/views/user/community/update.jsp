<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>커뮤니티 게시판</title>
<!-- summernote js,css -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="js/user/community/summernote-ko-KR.js"></script>

<!-- 화면 css -->
<link href="/css/user/board/community/insert.css" rel="stylesheet">

<div class="article">
	<c:url value="/user/community/update" var="update"/>
	<form action="${update}" id="updateForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th class="ts-23">제목</th>
				<th><input type="text" name="postTitle" class="ttype" value="${postList.postTitle}"/></th>
			</tr>
			<tr>
				<th class="ts-23">내용</th>
				<th><textarea id="summernote" name="postContent">${postList.postContent}</textarea></th>
			</tr>
			<tr>
				<th class="ts-23">파일</th>
				<th><input type='file' name='filePath' multiple='multiple' value="파일추가"></th>
			</tr>
		</table>
		<div class="buttons">
			<button type="button" class="butBack" onclick="location.href='/user/community'">돌아가기</button>
			<button type="submit" class="sub" onclick="location.href='/user/community/select'">수정완료</button>
		</div>
	</form>
</div>

<script>
	$(document).ready(function() {
		$('#summernote').summernote({
// 			placeholder: 'content',
			width: 700,
			height: 500,
			focus: true, 
			lang : 'ko-KR'
		});
	});
</script>