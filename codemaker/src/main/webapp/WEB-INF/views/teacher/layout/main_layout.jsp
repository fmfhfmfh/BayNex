<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>  	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/views/admin/layout/main_commonLib.jsp" %>
</head>
<style>
	@font-face {
		font-family: 'LotteMartDream';
		font-style: normal;
		font-weight: 300;
		src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
	}
	#body {
		font-family: 'LotteMartDream' !important;
	}
</style>
<body class="sidebar-fixed sidebar-dark header-light header-fixed" id="body">
	<div class="wrapper">
		<tiles:insertAttribute name="left"/>
		<div class="page-wrapper">
			<tiles:insertAttribute name="header"/>
			<div class="content-wrapper" style="background-color: #e8eaec;">
				<div class="content">
					<tiles:insertAttribute name="content"/>
				</div> <!-- content -->
			</div> <!-- content-wrapper -->
		</div> <!-- page-wrapper -->
	</div> <!-- wrapper -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>