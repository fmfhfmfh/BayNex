<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/codemirror/codemirror.js"></script>
<script type="text/javascript" src="/js/codemirror/javascript.js"></script>
<script type="text/javascript" src="/js/codemirror/codetest.js"></script>
<link href="/css/user/coding/coding-test.css" rel="stylesheet">
<link href="/css/user/coding/codemirror.css" rel="stylesheet">
<link href="/css/user/coding/eclipse.css" rel="stylesheet">
<div class="shadow coding-container">
	<!-- content 1번째 섹션 -->
	<div class="lang-select coding-item1">
		<div>
			<span style="color:#ffffffb8;">직사각형 별 찍기</span>
			<button class="list-btn" onclick="location.href='/user/coding/solution'">목록으로</button>
		</div>
	</div>
	
	<!-- content 2번째 섹션 -->
	<div class="coding-item2">
		<!-- 2번째 섹션 first -->
		<div class="coding-item2-section1">
			<div class="solution-box">
				<h6>문제 설명</h6>
				<div>
					<p>
						이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.<br> 별(*) 문자를 이용해 가로의 길이가
						n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
					</p>
					<h5>제한 조건</h5>
					<ul>
						<li>n과 m은 각각 1000 이하인 자연수입니다.</li>
					</ul>
					<h5>예시</h5>
					<p>입력</p>
					<div class="highlight">
						<pre class="codehilite"><!-- 
							 --><code>5 3</code>
						</pre>
					</div>
					<p>출력</p>
					<div class="highlight">
						<pre class="codehilite"><!-- 
							 --><code>*****<br>*****<br>*****</code>
						</pre>
					</div>
				</div>
			</div>
		</div>
		<!-- 2번째 섹션 second -->
		<div class="coding-item2-section2">
			<div class="main-box">
				<div class="coding-box">
					<textarea class="codemirror-textarea" spellcheck="false" id="code" rows="30" cols="1000"></textarea>
				</div>
				<div class="result-box-area">
					<div id="result-cl">
						<div class="h3-div"><h3>실행결과</h3></div>
						<div class="result-item">
							<div id="result">실행결과가 여기에 표시됩니다</div>
						</div>
					</div>
					<div id="run-box">
						<button id="run">코드실행</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 <script>
 $(document).ready(function(){
	//codemirror 설정
    var code = $(".codemirror-textarea")[0];
	//에디터 설정
    var editor = CodeMirror.fromTextArea(code,{
		lineNumbers : true,
		lineWrapping : true,
		mode : "javascript",
		theme : 'eclipse',
		val : code.value,
		indentWithTabs : true,
		autofocus : true,
    });
	//에디터 사이즈 설정
    editor.setSize("100%","100%");
	
	//초기 기본데이터 (자바로 설정)
	var ran1 = Math.floor(Math.random()*5+1);
	var ran2 = Math.floor(Math.random()*5+1);
	var txt = java5(ran1,ran2);
	editor.setValue(txt);
	
	$("#run").click(function(){
		var to_compile = {
				 "LanguageChoice": "4",
				 "Program": editor.getValue(),
				 "Input": "",
				 "CompilerArgs" : ""
				};
		console.log("값"+editor.getValue());
		console.log("줄 수 "+editor.lineCount());
			$.ajax ({
			     url: "https://rextester.com/rundotnet/api",
			     type: "POST",
			     data: to_compile
			}).done(function(data) {
			 	if(data.Errors!= '' && data.Errors !=null){
				 	$("#result").text(data.Errors);
				 	$("#result").css({"color":"red"});
				 	console.log("에러" + data.Errors);
			 	}else{
			 		var res = "<table><tr><td>입력값 → "+ data.Result +"</td></tr>";
			 			res += "<tr><td>기대값 → " + ran1+"</td></tr>"; 
			 		if(data.Result == ran1){
			 			res += "<tr><td style='color:#91fffa;'>테스트를 통과하셨습니다 (☞ﾟヮﾟ)☞</td></tr>";
			 		}else{
			 			res += "<tr><td style='color:red;'>테스트를 실패하셨습니다 (;´༎ຶД༎ຶ`)</td></tr>";
			 		}
			 		res += "</table>";
				 	$("#result").html(res);
				 	$("#result").css({"color":"white"});
			 	}
			 	var json = JSON.stringify(data);
			 	console.log(JSON.stringify(data));
			 	console.log("성공");
			}).fail(function(data, err) {
			 	console.log("실패");
			     alert("fail " + JSON.stringify(data) + " " + JSON.stringify(err));
			});
	});
    
 });
 </script>