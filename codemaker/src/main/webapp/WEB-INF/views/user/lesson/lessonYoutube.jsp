<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>   
<script>

      // 2. This code loads the IFrame Player API code asynchronously.
      var tag = document.createElement('script');

      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      // 3. This function creates an <iframe> (and YouTube player)
      //    after the API code downloads.
      var player;
      var curTime;
      var durTime;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: '800',
          width: '1100',
          videoId: '${lidxPath}',
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
      }

      // 4. The API will call this function when the video player is ready.
      function onPlayerReady(event) {
        event.target.playVideo();
       
      }

      // 5. The API calls this function when the player's state changes.
      //    The function indicates that when playing a video (state=1),
      //    the player should play for six seconds and then stop.
      var done = false;
      
      function onPlayerStateChange(event) {
          console.log(event);
          curTime = player.getCurrentTime();
          durTime = player.getDuration()

		// 일시정지 버튼눌렀을때
		if (event.data == YT.PlayerState.PAUSED && !done) {
        	// 현재시간
        	 console.log(curTime);
        	// 전체시간
        	 console.log(durTime)
        	 done = false;
        }
		// 영상을 끝까지 보았을때
		if (event.data == YT.PlayerState.ENDED && !done) {
        	// 현재시간
        	 console.log(curTime);
        	// 전체시간
        	 console.log(durTime)
        	 
        	 done = true;
        }
      }
	var btn = function(){
// 		alert('클릭');
		var lidxId = $('#btn').data('lidxid');
		console.log(lidxId);
		// 현재시간
   	 	console.log(curTime);
   		 // 전체시간
	 	console.log(durTime);
   		 
   		$.ajax({
   			url:"/user/updateLessonPage",
   			type:"get",
   			data:{'curTime' : curTime,
   				  'lidxId' : lidxId},
   			success:function(data){
				opener.parent.location.reload();
   				self.close();
   			},error:function(){
   			}
   		}) 
	}
	
	$(function(){
		$(window).on('beforeunload', function(){
			var lidxId = $('#btn').data('lidxid');
	 		alert(lidxId);
			// 현재시간
			console.log(curTime);
			// 전체시간
			console.log(durTime);

			$.ajax({
				url : "/user/updateLessonPage",
				type : "get",
				// 	    			async:false,
				data : {
					'curTime' : curTime,
					'lidxId' : lidxId
				},
				success : function(data) {
					opener.document.location.reload();
				},
				error : function() {
				}
			})

		})
	})
</script>

<!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
<div id="player"></div>
<div>
	<button id="btn" type="button"  onclick="btn()" data-lidxid="${lidxId}">강의 종료
	</button>
</div>

