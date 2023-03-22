<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
#cont1{padding-top:80px; }
#lessonCont{border-radius:10px; padding: 20px 0 22px; text-align:center;font-size: 26px;}
</style>

	<div class="container">
		<h2>강의 리스트</h2>
			<div id="cont1" style="border:1px solid blue;">
			
				<div id="lessonCont" style="border:1px solid black;">
					강의소개
					<br>
					<br>
					<br>	
					
				</div>
				<div style="border:1px solid black;">
					장바구니<br>
					담기
				</div>
			
			
			</div>
			
		<c:forEach items="${lessonList}" var="lessonList">
			<div class="mb-3">
				<label>강의 이름 : </label> <label>${lessonList.les_nm}</label>
			</div>
			<div class="mb-3">
				<label>강의 내용 : </label> <label>${lessonList.les_cont}</label>
			</div>
			<div class="mb-3">
				<label>담당 쌤 : </label> <label>${lessonList.tch_id}</label>
			</div>
			<br>
		</c:forEach>
	</div>
	
