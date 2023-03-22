// 문제 추가
var createExam = function() {
	str = '';
	str += '<div class="d5 d8">                                                                                                              ';
	str += '	<div class="d4 d8"></div>                                                                                                    ';
	str += '	<div class="d6">                                                                                                          ';
	str += '		<label for="sel1" class="sel1"> 문제를 입력해주세요. </label>                                                             ';
	str += '		<input type="text" name="queContList" class="form-control que" />                                                 ';
	str += '		<label for="sel4" class="sel4"> 배점을 입력해주세요.(숫자만 입력가능합니다.)&nbsp;&nbsp;&nbsp;</label>                                                            ';
	str += '		<input type="number" name="queScoreList" min="1" class="form-control que queS" />                                               ';
	str += '		<br>                                                                                       ';
	str += '		<label for="sel2"> 보기를 입력해주세요. </label>                                                                               ';
	str += '		<div class="anw">                                                                                                     ';
	str += '			<input type="text" name="ansContList" class="form-control radi ansContList" placeholder="보기1">                                ';
	str += '			<input type="checkbox" name="queAnswerList" value="1" class="chk" />                                              ';
	str += '		</div>                                                                                                                ';
	str += '		<div class="anw">                                                                                                     ';
	str += '			<input type="text" name="ansContList" class="form-control radi ansContList" placeholder="보기2">                                ';
	str += '			<input type="checkbox" name="queAnswerList" value="2" class="chk" />                                              ';
	str += '		</div>                                                                                                                ';
	str += '		<div class="anw">                                                                                                     ';
	str += '			<input type="text" name="ansContList" class="form-control radi ansContList" placeholder="보기3">                                ';
	str += '			<input type="checkbox" name="queAnswerList" value="3" class="chk" />                                              ';
	str += '		</div>                                                                                                                ';
	str += '		<div class="anw">                                                                                                     ';
	str += '			<input type="text" name="ansContList" class="form-control radi ansContList" placeholder="보기4">                                ';
	str += '			<input type="checkbox" name="queAnswerList" value="4" class="chk" />                                              ';
	str += '		</div>                                                                                                                ';
	str += '		<div class="anw">                                                                                                     ';
	str += '			<label for="sel5"> 문제 해설을 입력해주세요. </label>                                                                       ';
	str += '			<textarea class="form-control comment" rows="5" name="queExplainList"></textarea>    ';
	str += '		</div>                                                                                                                ';
	str += '		<div class="anw rig">                                                                                                 ';
	str += '			<input type="button" class="btn btn-default delBtn" value="문제 삭제">                                                ';
	str += '		</div>                                                                                                                ';
	str += '	</div>                                                                                                                  ';
	str += '</div>';
	
	$('#d2').append(str);
	
};