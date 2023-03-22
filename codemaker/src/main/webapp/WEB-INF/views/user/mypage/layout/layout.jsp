<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
#imglogo {
	width: 200px;
}

#imgicon {
	width: 40px;
	height: 40px;
}

.imgMain {
	width: 250px;
	height: 300px;
}

#at {
	color: #2c2e2e;
}

#navicon {
	width: 40px;
	height: 40px;
}

#usericon {
	width: 100px;
	height: 100px;
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
#page-top *{
	font-family: 'LotteMartDream' !important;
}
</style>


<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

 <%@ include file="/WEB-INF/views/user/mypage/layout/commonLib.jsp"%>

</head>

<body id="page-top">
	<div id="wrapper">
		<tiles:insertAttribute name="left" />
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="content" />
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />

</body>
 <%@ include file="/WEB-INF/views/user/mypage/layout/commonLib_2.jsp"%>


</html>