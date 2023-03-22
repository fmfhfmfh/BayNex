

$(function(){
	var action='';
	var type='';
	var subno = 0;
	var subId2='';
//	var list = new Array();
	var checkArr = new Array();
	
	// 과목등록 버튼 클릭
	$('#addBtn').on('click',function(){
		action = 'insert';
//		method="post"
		$('#modal-title').text("과목 등록");
		$('#myModal').modal();
		$('.modal').attr('style', 'padding-right : 17px; opacity : 1; display : block;');
	})
	
	// 수정 버튼 클릭
	$('#subTbody').on('click','#upBtn',function(){
//		alert('수정 눌림');
		action = 'update';
		
		var row = $(this).parent().parent();
		var tr = row.children();
		var subId = tr.eq(1).text();
		var subNm = tr.eq(2).text();
		
		console.log(subId);
		console.log(subNm);
		
		$('#modal-title').text("과목 수정");
		$('#subId').val(subId);
		$('#subNm').val(subNm);
		$('#myModal').modal();
		$('.modal').attr('style', 'padding-right : 17px; opacity : 1; display : block;');
	})
	
	
	//Modal의 submit 버튼 클릭
	$('#modalSubmit').on('click',function(){
		console.log('눌림');
		var url='';
		
		if(action ==  'insert'){
			url='/admin/insertSubject';
			alert('등록되었습니다');
		}else if(action == 'update'){
			url='/admin/updateSubject';
			alert('수정되었습니다');
		}
		console.log(url);
		var data ={ "subNm" : $('#subNm').val(),
					 "subId" : $('#subId').val()
		}
	
		console.log(data);
		
		
		$.ajax({
			url : url,
			data : data,
			sucess : function(data){
						$('#myModal').modal('toggle');
			},
			complete : function(data){
						location.reload();
			},
			error : function(data){
						alert('안됨');
			}
		})
	})
	
	// 체크박스 전체선택&전체해제
	$('#mainCheckbox').on('click',function(){
		if($('#mainCheckbox').is(':checked')){
			// 전체선택
			$('input[name="checkRow"]').prop('checked',true);
//			$('input[name="checkRow"]').each(function(){
//				// 배열생성
//				var checkL = $('input[name="checkRow"]').length;
//				console.log(checkL);
//				// 배열에 값 주입
//				checkArr = new Array(checkL);
//				for(var i=0; i<checkL; i++){
//					checkArr[i] = $('input[name="checkRow"]').eq(i).val();
//				}
//				console(checkArr[i]);
//			})
			// 전체해제
		}else{
			$('input[name="checkRow"]').prop('checked',false);
		}
		
	})
	
	// 선택삭제 버튼 클릭
	$('#delBtn').on('click',function(){
		
		// 체크박스 선택한것만 
		$('input:checkbox[name=checkRow]').each(function(){
			if ($(this).is(':checked')) {
					var id = $(this).val();
					console.log(id);
					checkArr.push(id);
			}
		})
		console.log(checkArr);
		alert('삭제되었습니다');
		
		//체크한 항목의 val값 가져오는지?
		$.ajax({
			url:'/admin/deleteSubject',
			data : {"checkArr" : checkArr},
			success:function(data){
			},complete : function(data){
						location.reload();
			},error : function(data){
//				alert('안됨');
			}
		})
	
	})

})


