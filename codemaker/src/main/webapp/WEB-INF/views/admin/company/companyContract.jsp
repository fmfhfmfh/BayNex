<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>title</title>
<script src="/js/admin/company/html2canvas.js"></script>
<script src="/js/admin/company/jspdf.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
@font-face {
    font-family: 'NotoSerifKR';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NotoSerifKR.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.header{
	width: 589px;
    font-size: 35px;
    text-align: center;
    padding: 8px;
    margin: 0 auto;
    height: 57px;
    border:2px solid black;
}
#ptag{
	text-align: center;
	margin: 0px;
}
.frame{
	width: 900px;
    margin: 0px auto 0;
   font-family: 'NotoSerifKR';
}
.text1st{
	line-height: 6px;
    margin: 70px 0 40px 41px;
}
.text2nd{
    margin: 20px 65px 10px;
    line-height: 5px;
}
.date{
	margin: 30px 0 3px 400px;
}
.sign{
	padding: 38px;
    height: 300px;
    margin: -25px 0 0px 0px;
}
.signdiv{
	width: 49%;
    float: left
}
#stampId{
	margin-left: 34px;
    width: 87px;
    float: left;
}
.stamp .1st{
	width: 70%;
    float: left
}
.stamp .2nd{
	width: 30%;
    float: left
}
#signpad{
	width: 400px;
	height: 200px;
}
#submitBtn{
	margin-left: 427px;
}
.btn-sm {
  	font-size: .875rem;
  	line-height: 1.5;
  	padding: .25rem .5rem;
  	border-radius: .375rem;
}
.btn {
  	font-size: 13px;
    font-weight: 500;
    line-height: 1.5;
    text-align: center;
    display: inline-block;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
    border: 1px solid transparent;
    border-radius: .375rem;
    width: 63px;
    height: 30px;
    margin: 10px 0 0 0;
}
.btn-info {
  	color: #fff;
  	border-color: #888888;
  	background-color: #888888;
  	box-shadow: 0 4px 6px rgba(50, 50, 93, .11), 0 1px 3px rgba(0, 0, 0, .08);
}

.btn-info:hover {
  	color: #fff;
  	border-color: #888888;
  	background-color: #888888;
}
.btn-success{
	border: 2px solid #005F86;
    background-color: #005F86;
    box-shadow: 0 4px 6px rgba(50, 50, 93, .11), 0 1px 3px rgba(0, 0, 0, .08);
    width: 120px;
    height: 40px;
    border-radius: 36px;
    margin: 40px 0 0 400px;
    font-size: 17px;
    color: white;
    font-weight: 600;
}

</style>
</head>
<body>

<div id="pdfDiv">
	<div class="frame" >
		<div class="header"><p id="ptag"><strong>표준 산학협력 협약서(안)</strong></p></div>
		
		<div class="content" >
			<div class="text1st">
				<p>&nbsp;&nbsp;&nbsp;이 협약서는 codemaker(이하 "갑"이라 한다)과 ○○회사(이하 "을"이라 한다)는 상호간의 협력에 관한 필요한 사항을</p>
				<p>정하고 이를 성실하게 준수할 것을 목적으로 하며 codemaker는 우수한 인재를 양성하며 기업에 지원하고 기업은 </p>
				<p>codemaker에 인재개발을 위하여 노력하여 상호 공동발전 및 우호증진을 위하여 다음과 같이 산학협력 협약을 체결한다.</p>
			</div>
			
			<div class="text2nd" >
				<p>1. "갑"은 "을"에게 수료예정자 및 수료자를 추천하고, 다양하고 폭넓은 취업 기회를 쌓을 수 있도록 최선의 기회를</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;제공한다.</p> 
			</div>
			<div class="text2nd" >
				<p>2. "을"은 "갑"의 구인 상황에 적극적으로 지원한다.</p>
			</div>
			<div class="text2nd" >
				<p>3. "갑"과 "을"은 우수 인재 양성을 위하여 상호간에 기술·장비 등 제한 여건의 협조 요청에 특별한 사유가 없는 한 </p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;성실히 협조한다.</p>
			</div>
			<div class="text2nd" >
				<p>4. "갑"과 "을"이 상호 신의성실 원칙에 따라 이 협약서를 준수하기 위한 노력을 하여야 하며, 상호간에 중대한 </p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;사항을 위반하거나, "갑"이 추천한 인재에 대하여 부당 행위를 한 경우 "갑"의 요청에 의해 이 협약을 </p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;취소할 수 있다.</p>
			</div>
			<div class="text2nd" >
				<p>5. 기타 이 협약서에 평가되지 아니한 사항에 대하여는 상호 협의하에 결정한다.</p>
			</div>
			<div class="text2nd" >
				<p>본 협약서는 2부를 작성하여 "갑", "을"이 기명날인한 후 각각 1부씩 보관한다.</p>
			</div>
			
			<div class="date">
			
						<jsp:useBean id="toDay" class="java.util.Date"/>
						<fmt:formatDate value="${toDay}" pattern="yyyy년 MM월dd일"/>
			</div>
			
			<div class="sign" >
				<div class="signdiv codeSign" >
					<div>
						<p>[갑] 학원명 :  codemaker</p>
					</div>
					서명 공간
					<div style="width:400px; height:200px;">
					<canvas id="canvas" style="border:1px solid black"></canvas>
					</div>
					<div id="erase-div">
					<button type="button" class="btn btn-sm btn-info" id="erase">지우기</button>
					</div>
				</div>
				
				<div class="signdiv companySign" >
					<div class="stamp 1st">
					  <p>[을]  회사명 : ${companyVO.comNm}</p>
					  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주 소 : ${companyVO.comAdd}</p>
					  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대 표 : ${companyVO.comOwner}</p>
					</div>
					<div class="stamp 2nd" id="stamp2Id">
					    <img id="stampId" src="/images/admin/company/stamp.png" alt="직인">
					</div>
				</div>
			</div>
		</div>
	</div>	
</div>

<div>
	<button type="button" id="savePdf" class="btn btn-sm btn-success form-control-label" data-comnm="${companyVO.comNm}" data-comid="${companyVO.comId}">제출</button>
</div>




<script>

(function(obj){
obj.init();
$(obj.onLoad);
	var comId = $(this).data("comid");
	var allText=$('.frame').html();

})((function(){
var canvas = $("#canvas");
var div = canvas.parent("div");
// 캔버스의 오브젝트를 가져옵니다.
var ctx = canvas[0].getContext("2d");
var drawble = false;
function canvasResize(){
canvas[0].height = div.height();
canvas[0].width = div.width();
}
// pc에서 서명을 할 경우 사용되는 이벤트입니다.
function draw(e){
function getPosition(){
return {
X: e.pageX - canvas[0].offsetLeft,
Y: e.pageY - canvas[0].offsetTop
}
}
switch(e.type){
case "mousedown":{
drawble = true;
ctx.beginPath();
ctx.moveTo(getPosition().X, getPosition().Y);
}
break;
case "mousemove":{
if(drawble){
ctx.lineTo(getPosition().X, getPosition().Y);
ctx.stroke();
}
}
break;
case "mouseup":
case "mouseout":{
drawble = false;
ctx.closePath();
}
break;
}
}
// 스마트 폰에서 서명을 할 경우 사용되는 이벤트입니다.
function touchdraw(e){
function getPosition(){
return {
X: e.changedTouches[0].pageX - canvas[0].offsetLeft,
Y: e.changedTouches[0].pageY - canvas[0].offsetTop
}
}
switch(e.type){
case "touchstart":{
drawble = true;
ctx.beginPath();
ctx.moveTo(getPosition().X, getPosition().Y);
}
break;
case "touchmove":{
if(drawble){
// 스크롤 이동등 이벤트 중지..
e.preventDefault();
ctx.lineTo(getPosition().X, getPosition().Y);
ctx.stroke();
}
}
break;
case "touchend":
case "touchcancel":{
drawble = false;
ctx.closePath();
}
break;
}
}
// 참고로 mousedown은 touchstart와 mousemove는 touchmove, mouseup은 touchend와 같습니다.
// mouseout와 touchcancel은 서로 다른 동작인데, mouseout은 canvas 화면을 벗어났을 때이고 touchcancel는 모바일에서 터치가 취소, 즉 에러가 났을 때 입니다.
return {
init: function(){
// 캔버스 사이즈 조절
$(window).on("resize", canvasResize);
canvas.on("mousedown", draw);
canvas.on("mousemove", draw);
canvas.on("mouseup", draw);
canvas.on("mouseout", draw);
// 저장
$("#save").on("click", function(){
// a 태그를 만들어서 다운로드를 만듭니다.
var link = document.createElement('a');
// base64데이터 링크 달기
link.href = canvas[0].toDataURL("image/png");
// 다운로드시 파일명 지정
link.download = "image.png";
// body에 추가
document.body.appendChild(link);
link.click();
document.body.removeChild(link);
// 다운로드용 a 태그는 다운로드가 끝나면 삭제합니다.
form.remove();
});

// 지우기
$('#erase').on('click',function(){
    ctx.clearRect(0, 0, canvas[0].width, canvas[0].height);
    // 컨텍스트 리셋
    ctx.beginPath();
})



},
onLoad: function(){
// 캔버스 사이즈 조절
canvasResize();
}
}
})());



$(document).ready(function() {
	$('#savePdf').click(function() { // pdf저장 button id
// 	    var comNm = $(this).data("comnm"); // 회사명
	    var comId = $(this).data("comid"); // 회사 아이디
	 	$("#erase-div").css({"display":"none"});
	    html2canvas($('#pdfDiv')[0]).then(function(canvas) { //저장 영역 div id
	    	
	    // 캔버스를 이미지로 변환
	    var imgData = canvas.toDataURL('image/png');
	    console.log(imgData);
// 	    window.open("data:application/pdf;base64, " +imgData.base64EncodedPDF);

	    $.ajax({
	 		url:"/admin/company/companyPdf",
	 		type:"post",
	 		dataType:"json",
	 		data : {'imgData' : imgData,
	 				'comId' : comId},
	 		success:function(data){
	 			console.log(imgData);
// 	 			opener.parent.location.reload();
// 	 			self.close();
	 			},error:function(data){
// 	 				alert('안됨');
	 				opener.parent.location.reload();
	 				self.close();
	 			}
	 	})
	});
  });
})

</script>
</body>
</html>

