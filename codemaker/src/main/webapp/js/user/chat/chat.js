var connect = function(){
	wsocket = new WebSocket("ws://localhost/chat-ws");

	wsocket.onopen = onOpen;
	wsocket.onmessage = onMessage;
	wsocket.onclose = onClose;
}

var disconnect = function(){
	wsocket.close();
}

var onOpen = function(evt){
	appendMessage("연결되었습니다.");
}

var onMessage= function(evt) {
    var data = evt.data;
    if (data.substring(0, 4) == "msg:") {
        appendMessage(data.substring(4));
    }
}
var onClose = function (evt) {
    appendMessage("연결을 끊었습니다.");
}

var send = function() {
    
	msg = $("#message").val();
	wsocket.send("msg:${MEMBER_INFO.userNm}:" + msg);
	$("#chat-input").val("");
}

var appendMessage = function(msg) {
 
	$("#chatMessageArea").append(msg+"<br>");
 
	var chatAreaHeight = $("#chatArea").height();
 
	var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
 
	$("#chatArea").scrollTop(maxScroll);
}

