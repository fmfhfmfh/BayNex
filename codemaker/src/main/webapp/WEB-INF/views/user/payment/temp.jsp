<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
$(function(){
	console.log("진입");
	opener.parent.sumbitTest();
	self.close();
})
</script>
</head>
<body>
결제일 : ${info.approved_at}<br>
주문번호 : ${info.partner_order_id}<br>
상품명 : ${info.item_name}<br>
</body>
</html>