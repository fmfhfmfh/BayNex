<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.save-com{
	height: 791px;
    display: flex;
    flex-direction: column;
    width: 65%;
    margin: 0 auto;
    justify-content: center;
    align-items: center;
}
.res-span{
	font-size: 34px;
    font-weight: 600;
}    
.btn, .btn:hover{
    color: white;
    background: rgb(0,95,134);
    font-weight: 600;
    width: 250px;
    height: 50px;
    font-size: 26px;
}
</style>
<div class="save-com">
	<span class="res-span">이력서 저장이 완료되었습니다</span>
	<button class="btn" onclick="location.href='<c:url value="/user/main"/>'">메인으로</button>
</div>
