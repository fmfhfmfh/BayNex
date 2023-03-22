<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
  var socket = null;  //전역 변수로 선언

  $(document).ready(function(){
    connectWS();
  });

  function connectWS(){
    var ws = new WebSocket("ws://localhost/websocket/echo.do");
    socket = ws;
    ws.open = function(message){
     console.log(message);
    };

    ws.onmessage = function(event){
      $("#socketAlert").text(event.data);
      $("#socketAlert").css("display", "block");
    };

    ws.onclose = function(event){
      console.log("Server disConnect");
    };

    ws.onerror = function(event){
      console.log("Server Error");
    };
  }
</script>
</head>
<body>
	<div id="socketAlert" class="alert alert-success" role="alert" style="display:none;"></div>
</body>
</html>
