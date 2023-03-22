<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<title>질의응답</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/teacher/lesson/lesson.css">
<link rel="stylesheet" href="/css/user/qna/qnaSelect.css">
<script>
$(document).ready(function(){
	var count = 0;
	$("#listbutton").on("click", function(){
		document.location="/teacher/selectAllQna";
	});
	
	$("#insertbutton").on("click", function(){
		if($("#replyCont").val() == null || $("#replyCont").val() == ''){
			alert("내용을 입력해주세요");
			return;
		}else{
			if(confirm("작성하시겠습니까?")){
				$('#inre').submit();
				return;
			}else{
				return;
			}
		}
	})
	
	$("button[id^=rreply]").on('click', function(){
		var root = $(this).val();
		var str = "";
		count++
		if(count == 1){
			str += "<form id='rreplyInsert' method='POST' action='/teacher/insertrReply'>"
			str += "<li>";
			str += "<hr>";
			str += "	<div class='CommentWriter'>";
			str += "		<div class='comment_inbox'>";
			str += "			<span>작성자 : ${S_TEACHER.tchId}</span>";
			str += "			<textarea class='comment_inbox_text' id='replyCont' name='rreplyCont' placeholder='댓글을 입력해주세요'></textarea>";
			str += "		</div>";
			str += "		<div class='comment_attach'>";
			str += "			<div>";
			str += "				<button style='float:right; color:#b7b7b7;' id='rreplybutton' class='button btn_register'>등록</button>";
			str += "			</div>";
			str += "		</div>";
			str += "	</div>";
			str += "</li>";
			str += "<input type='hidden' name='root' value='"+ root +"'>";
			str += "<input type='hidden' name='qnaId' value='${qnaVo.qnaId}'>";
			str += "<input type='hidden' name='replyWriter' value='${S_TEACHER.tchId}'>";
			str += "</form>";
			
			$(this).closest('li').after(str);
			
		}else if(count == 2){
			count = 0;
		}
	});
	
	$("button[id^=delbutton]").on('click', function(){
		var but = $(this).val();
		if(confirm("삭제하시겠습니까?")){
			$('#delre').append("<input type='hidden' name='replyId' value='"+but+"'>")
			$('#delre').submit();
		}else{
			return;
		}
	})
	
	
	$("button[id='rreplybutton']").on('click', function(){
		if(confirm("등록하시겠습니까?")){
			$("#rreplyInsert").submit();
			return;
		}else{
			return;
		}
	})
	
});

</script>
<style>
	.card{
		width: 80%;
	    height: auto;
	    margin: 20px auto 0;
	    border: none;
	    padding: 40px;
	}
	.titleDiv{
		text-align:center;
		margin:20px;
	}
	#title{
		color : #1d25af;
		font-weight: 600;
		font-family: 'LotteMartDream';
		font-size: 35px;
	}
	.row{
		margin: 50px 130px 0;
		background-color: white;
	}
	.btnClass{
		float:right;
		width: 80px;
		margin-right: 10px;
	}
	.header{
		float: right;
	}
	.headerId{
		width: 100%;
		text-align: right;
		font-size: 20px;
    	font-weight: 600;
	}
	.headerDate{
		width: 100%;
		text-align: right;
		color: #a9a8a8;
   		font-size: 17px;
    	font-weight: 400;
    	margin-top: -10px;
	}
	#idImg{
		width: 20px;
	}
	.contentDiv{
		margin: 30px;
	    border: 2px solid #c1bebe;
	    height: 350px;
	    padding: 20px;
	    font-size: 18px;
    	font-weight: 500;
	}
	#listbutton{
		width: 80px;
   		margin-left: 30px;
	}
	.btnDiv{
		margin-right: 19px;
	}
	.contents{
		min-height:100px;
	}
	.condiv {
		height : 20px;
	}
	.CommentWriter{
		margin: 12px 0 29px;
	    padding: 16px 10px 10px 18px;
	    border: 2px solid #6f63631a;
	    border-radius: 6px;
	    box-sizing: border-box;
	    background-color: #fdfcfc;
	    height: 125px;
	    width: 820px;
	    margin-left:auto;
	    margin-right:auto;
	}
	.CommentWriter .comment_inbox_text {
	    display: block;
	    width: 100%;
	    min-height: 17px;
	    padding-right: 1px;
	    border: 0;
	    font-size: 18px;
	    resize: none;
	    box-sizing: border-box;
	    background: transparent;
	    color: var(--skinTextColor);
	    outline: 0;
	}
	.CommentWriter .register_box .button {
	    display: inline-block;
	    min-width: 46px;
	    height: 34px;
	    line-height: 36px;
	    font-size: 13px;
	    color: var(--skinCommentWriterText);
	    border-radius: 6px;
	    box-sizing: border-box;
	    font-weight: 700;
	    text-align: center;
	    vertical-align: top;
	}
	label{
		text-transform: none;
	}
	p{
		line-height: 2.5;
		margin-bottom: 0;
	}
</style>
	<div class="card">
			
			<div class="lesnm-div">
			<span class="lesnm-sp">${qnaVo.subNm} > <u>${qnaVo.lesNm}</u></span>
			</div>			
			<div class="title-top">
				<div class="title-btn">
					<button type="button" id="listbutton" style="float:right;" class="btn btn-primary">목록</button>
				</div>
				<div class="title-div">
					<label class="control-label label-st">${qnaVo.qnaId}</label><br>
					${qnaVo.qnaTitle}
					<div class="title-mid">
						<label class="control-label label-st">${qnaVo.userId}</label><br>
						<label class="control-label label-st">작성일 <fmt:formatDate value="${qnaVo.qnaDate}" pattern="yyyy-MM-dd" /></label><br>
						
					</div>
				</div>
			</div>

			<br>
			<div class="cont-mid">
				<label class="control-label" >${qnaVo.qnaCont}</label>
			</div>
			
			<div>
				<div>
			
					<div class="reply-div">
					댓글
					</div>
			<br>
				<div>
					<ul id="ultag">
						<c:forEach var="reply" items="${replyList}">
							<li class="contents">
							<hr>
								<div style="margin-left:${60*reply.replylevel}px;" class="condiv">
									<div class="condiv" style="margin-bottom:10px;">
										<c:if test="${reply.replylevel > 1}">
										 	▶
										</c:if>
										<span style="font-size:1.3em; font-weight:800" id="defendant">${reply.replyWriter}</span>
										<span style="font-size:0.9em; font-weight:300; color:gray;"><fmt:formatDate value="${reply.replyDate}" pattern="yyyy-MM-dd HH:mm"/></span>
									</div>
									<div class="condiv">
										<div class="condiv">
											<p class="p-color">${reply.replyCont}</p>
										</div>
									</div>
									<div class="btn-div">
										<br>
										<c:if test="${reply.replyOut != 'Y'}">
											<c:choose>
												<c:when test="${reply.replyWriter != S_TEACHER.tchId}">
													<button class="del-color" id="rreply" type="button" name="rreplyRoot" value="${reply.replyId}">답글</button>
													<button class="rep-color" id="replyComplain" type="button" name="replyComplain" value="${reply.replyId}">신고</button>
												</c:when>
												<c:otherwise>
													<form id="delre" action="/teacher/deleteReply">
														<input type="hidden" value="${qnaVo.qnaId}" name="qnaId">
														<button class="del-color" type="button" id="delbutton" value="${reply.replyId}">삭제</button>
													</form>
												</c:otherwise>
											</c:choose>
										</c:if>	
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			
			<hr>
			<form id="inre" action="/teacher/insertReply" method="POST">	
				<input type="hidden" name="replyWriter" value="${S_TEACHER.tchId}">
				<input type="hidden" name="qnaId" value="${qnaVo.qnaId}">
				<input type="hidden" name="quserId" value="${qnaVo.userId}">
				<input type="hidden" name="replyRoot" value="">
				<div class="CommentWriter">
					<div class="comment_inbox">
						<span>작성자 : ${S_TEACHER.tchId}</span>
						<textarea class="comment_inbox_text" id="replyCont" name="replyCont" placeholder="댓글을 입력해주세요"></textarea>
					</div>
					<div class="comment_attach">
						<div>
							<button style="float:right; color:#696969;" type="button" id="insertbutton" class="button btn_register">등록</button>
						</div>
					</div>
				</div>
			</form>
			<hr>
			
		</div>
	</div>
</div>