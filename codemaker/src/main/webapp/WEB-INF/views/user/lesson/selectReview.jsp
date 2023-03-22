<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<!-- Main css -->
<link rel="stylesheet" href="/css/user/review/review-style.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
var startCount = 0;
	$(function() {

		$(document).on('click', '.star', function() {
			var cl = $(this).attr('class');
			// 	console.log(cl);
			if (cl == 'star btn btn-default btn-grey btn-xs') {
				startCount++;
				console.log(startCount);
				$(this).attr('class', 'star btn btn-warning btn-sm');
			} else {
				startCount--;
				console.log(startCount);
				$(this).attr('class', 'star btn btn-default btn-grey btn-xs');
			}
			
		});

		$("#reviewDel").on('click', function() {
			alert("수강후기가 삭제되었습니다.");
		});
		
		
		$(document).ready(function(){
			$('#reviewbox').on("click", function(){
				
				$('input[name=reviewStar]').attr('value',startCount).val();
				$("textarea[name=reviewCont]").val();
				
				if(startCount==0){
					alert("별점을 체크해 주세요.");
					return false;
				}
				var lesId= $("#lesId").val();
				var flag=true;
				
				$.ajax({
					url : "${cp}/user/insertReview",
					type : "post",
					data : $("#reviewform").serialize(),
					dataType : 'json',
					async: false, //비동기식인 ajax를 동기식으로 설정
					success : function(res) {
						if (res == "0") {
							alert("회원님이 수강한 강의가 아닙니다.");
							$('#new-review').val('');
							flag=false;
						}else {
							alert("수강후기를 작성합니다.");
							location.href="${cp}/user/selectReview?lesId="+lesId;
						}
					}
				});
					return flag;
				})
			});
})
</script>

<style>
body{
	margin : 0;
}
.container{
	margin: 12px auto 3px 33%;
}
.img-rounded {
    border-radius: 6px;
    width: 50px;
}
.btn.btn-warning.btn-xs {
	width: 25px;
    height: 22px;
}
.btn.btn-default.btn-grey.btn-xs {
    height: 24px;
    width: 26px;
}
.review-block {
    background: white;
    margin: 20px 106px 0 0;
}


img#starimg {
    width: 30px;
}
img#starimg2 {
    width: 20px;
}

#reviewDel{
	float : right;
}
h1{
    font-weight: 600;
    margin-bottom: 1.2em;
    font-size: 2.1rem;
    margin: 50px auto 25px 30%;
}
.row{
margin: 0 auto 0 33%;
}
.row1 {
    margin: 10px auto 93px -10px;
}

</style>

<body>
<!--     <div class="container"> -->
<h1>수강후기</h1>
<hr>
		<div class="row">
			<div class="col-sm-3">
				<div class="rating-block">
					<h3 class="bold padding-bottom-7">🔔 수강 별점 평균</h3>
					<h2 class="bold padding-bottom-7">${reviewAvg}<small>/ 5</small></h2>
					<c:forEach var="i" begin="1" end="${reviewAvg}">
<!-- 					<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align"> -->
<!-- 					  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> -->
<!-- 					</button> -->
					<img src="${cp}/images/user/icons/star.png" id="starimg">
					</c:forEach>
				</div>
			</div>
			
			<div class="col-sm-3">
<!-- 				<h4>Rating breakdown</h4> -->
					<br><br>
				<div class="pull-left">
					<div class="pull-left" style="width:35px; line-height:1;">
						<div style="height:9px; margin:5px 0;"><b>5⭐️ </b></div>
					</div>
					<div class="pull-left" style="width:180px;">
						<div class="progress" style="height:9px; margin:8px 0;">
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="5" aria-valuemin="0" aria-valuemax="5" style="width: 1000%">
							<span class="sr-only">80% Complete (danger)</span>
						  </div>
						</div>
					</div>
					<div class="pull-right" style="margin-left:10px;">${reviewStarVo.five}</div>
				</div>
				<div class="pull-left">
					<div class="pull-left" style="width:35px; line-height:1;">
						<div style="height:9px; margin:5px 0;"><b>4⭐️</b> </div>
					</div>
					<div class="pull-left" style="width:180px;">
						<div class="progress" style="height:9px; margin:8px 0;">
						  <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="4" aria-valuemin="0" aria-valuemax="5" style="width: 80%">
							<span class="sr-only">80% Complete (danger)</span>
						  </div>
						</div>
					</div>
					<div class="pull-right" style="margin-left:10px;">${reviewStarVo.four}</div>
				</div>
				<div class="pull-left">
					<div class="pull-left" style="width:35px; line-height:1;">
						<div style="height:9px; margin:5px 0;"><b>3⭐️</b> </div>
					</div>
					<div class="pull-left" style="width:180px;">
						<div class="progress" style="height:9px; margin:8px 0;">
						  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="3" aria-valuemin="0" aria-valuemax="5" style="width: 60%">
							<span class="sr-only">80% Complete (danger)</span>
						  </div>
						</div>
					</div>
					<div class="pull-right" style="margin-left:10px;">${reviewStarVo.three}</div>
				</div>
				<div class="pull-left">
					<div class="pull-left" style="width:35px; line-height:1;">
						<div style="height:9px; margin:5px 0;"><b>2⭐️</b></div>
					</div>
					<div class="pull-left" style="width:180px;">
						<div class="progress" style="height:9px; margin:8px 0;">
						  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="5" style="width: 40%">
							<span class="sr-only">80% Complete (danger)</span>
						  </div>
						</div>
					</div>
					<div class="pull-right" style="margin-left:10px;">${reviewStarVo.two}</div>
				</div>
				<div class="pull-left">
					<div class="pull-left" style="width:35px; line-height:1;">
						<div style="height:9px; margin:5px 0;"><b>1⭐️</b> </div>
					</div>
					<div class="pull-left" style="width:180px;">
						<div class="progress" style="height:9px; margin:8px 0;">
						  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="5" style="width: 20%">
							<span class="sr-only">80% Complete (danger)</span>
						  </div>
						</div>
					</div>
					<div class="pull-right" style="margin-left:10px;">${reviewStarVo.one}</div>
				</div>
			</div>			
		</div>			
		
		<form id="reviewform" action="${cp}/user/insertReview?lesId=${lesId}" method="POST">
		<input type="hidden" value="${lesId}" id="lesId" name="lesId">
		<div class="row" style="margin-top:40px;">
		<div class="col-md-6">
    	<div class="well well-sm">
            <div class="text-right">
              <a class="btn btn-success btn-green" id="reviewbox">후기 작성</a>
          <div class="review-block-rate"><br>
          <input type="hidden" name="reviewStar" value="">
          <c:forEach var="i" begin="1" end="5">
			<button type="button" class="star btn btn-default btn-grey btn-xs" id="reviewStar" aria-label="Left Align">
			  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
			</c:forEach>
		</div>
		
      </div>
        <br>
           <textarea class="form-control animated" cols="100" rows="8" id="new-review" name="reviewCont" placeholder="수강후기를 작성해주세요."></textarea>
            <div class="row" id="post-review-box" style="display:none;">
<!--                 <div class="col-md-12"> -->
<!--                     <form accept-charset="UTF-8" action="" method="post"> -->
<!--                         <input id="ratings-hidden" name="rating" type="hidden">  -->
        
<!--                         <div class="text-right"> -->
<!--                             <div class="stars starrr" data-rating="0"></div> -->
<!--                             <a class="btn btn-danger btn-sm" href="#" id="close-review-box" style="display:none; margin-right: 10px;"> -->
<!--                             <span class="glyphicon glyphicon-remove"></span>Cancel</a> -->
<!--                             <button class="btn btn-success btn-lg" type="submit">Save</button> -->
<!--                         </div> -->
<!--                     </form> -->
<!--                 </div> -->
            </div>
        </div> 
		</div>
	</div>	
	</form>
		
		<div class="row">
			<div class="col-sm-7">
				<hr/>
				<div class="review-block">
					<div class="row1">
						<c:forEach items="${reviewList }" var="reviewList">
						<div class="col-sm-3">
							<img src="${cp}/images/user/icons/reviewimage2.png" class="img-rounded">
							<div class="review-block-name">‍👨‍${reviewList.userId}</div>
							
						</div>

						<div class="col-sm-9">
							<div class="review-block-rate">
								<c:forEach var="i" begin="1" end="${reviewList.reviewStar}">
								<img src="${cp}/images/user/icons/star.png" id="starimg2">
<!-- 								<button type="button" class="btn btn-warning btn-xs" aria-label="Left Align"> -->
<!-- 								  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> -->
<!-- 								</button> -->
								</c:forEach>
<!-- 								<input type="button" class="" value="삭제"> -->
								
								<c:choose>
									<c:when test="${reviewList.userId == MEMBER_INFO.userId}">
										<a href="${cp}/user/deleteReview?lesId=${lesId}&reviewId=${reviewList.reviewId}" id="reviewDel"><span>🗑️삭제</span></a>
									</c:when>
								</c:choose>
								
								<input type="hidden" value="${reviewList.reviewId}">
							
<!-- 								<button type="button" class="btn btn-default btn-grey btn-xs" aria-label="Left Align"> -->
<!-- 								  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> -->
<!-- 								</button> -->
							</div>
							<div class="review-block-date"><fmt:formatDate value="${reviewList.reviewDate}" pattern="yyyy-MM-dd"/><br/></div>
							<div class="review-block-description">${reviewList.reviewCont }</div>
						<hr/>
						</div>
						</c:forEach>
					</div>

		

<!--     </div> /container -->
					
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

</html>