<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/codemirror/codemirror.js"></script>
<script type="text/javascript" src="/js/codemirror/javascript.js"></script>
<script type="text/javascript" src="/js/codemirror/codeLanguage.js"></script>
<link href="/css/user/coding/coding-practice.css" rel="stylesheet">
<link href="/css/user/coding/codemirror.css" rel="stylesheet">
<link href="/css/user/coding/eclipse.css" rel="stylesheet">
<div class="shadow coding-container">
	<div class="lang-select">
		<div>
			<span class="fc-b8">언어선택</span>
			<select id="selectLang">
				<option value="4">Java</option>
				<option value="5">Python</option>
				<option value="1">C#</option>
				<option value="35">Oracle</option>
			</select>
			<button class="fc-b8 list-btn" onclick="golist()">목록으로</button>
		</div>
	</div>
	<div class="main-box">
		<div class="coding-box">
			<textarea class="codemirror-textarea" spellcheck="false" id="code" rows="30" cols="1000"></textarea>
		</div>
		<div class="result-box-area">
			<div id="result-cl">
				<div class="h3-div"><h3>실행결과</h3></div>
				<div class="result-item">
					<pre id="result">실행결과가 여기에 표시됩니다</pre>
				</div>
			</div>
			<div id="run-box">
				<button id="run">코드실행</button>
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
	
	$("#code").click(function(){
		console.log("클릭"+editor.getSelection());
	})
	//초기 기본데이터 (자바로 설정)
	var txt = java();
	editor.setValue(txt);
	
	//언어선택시 실행
	$("#selectLang").on('change',function(){
		var value = $(this).val();
		console.log("값 "+value);
		 
		if(value == 4){	//java
			txt=java();
		}else if(value == 1){	//C#
			txt=cs();
		}else if(value == 5){	//python
			txt=python();
		}else if(value == 35){	//oracle
			txt=oracle();
		}
		editor.setValue(txt);
	})
	
	$("#run").click(function(){
		var val= $("#selectLang").val();
		console.log("이건 값 "+val);
		var to_compile = {
				 "LanguageChoice": val,
				 "Program": editor.getValue(),
				 "Input": "",
				 "CompilerArgs" : ""
				};
		console.log("값"+editor.getValue());
		console.log("줄 수 "+editor.lineCount());
		if($("#selectLang").val()==35){
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
				 	$("#result").html(data.Result);
				 	$("#result").css({"color":"white"});
			 	}
			 	var json = JSON.stringify(data);
			 	console.log(JSON.stringify(data));
			 	console.log("성공");
			}).fail(function(data, err) {
			 	console.log("실패");
			     alert("fail " + JSON.stringify(data) + " " + JSON.stringify(err));
			});
		}else{
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
				 	$("#result").text(data.Result);
			 	}
			 	var json = JSON.stringify(data);
			 	console.log(JSON.stringify(data));
			 	console.log("성공");
			}).fail(function(data, err) {
			 	console.log("실패");
			     alert("fail " + JSON.stringify(data) + " " + JSON.stringify(err));
			});
		}
	});
    
 });
 function golist(){
	 console.log("이동");
	 location.href="/user/codingtest";
 }
 </script>