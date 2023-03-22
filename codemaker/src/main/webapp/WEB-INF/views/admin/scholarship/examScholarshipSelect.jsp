<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>시험 회원 목록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script>
$(function(){
	// 목록으로 가기
	$('#cancel').on('click', function(){
		$('#schof').attr('action', '/scholarship/selectAllScholarship');
		$('#schof').submit();
	});
	
	// 엑셀 다운로드
	$('#excelBtn').on('click', function(){
		$('#schof').attr('action', '/scholarship/excelScholarship');
		$('#schof').submit();
	});
	
	// 장학금 지급
	$('#agree').on('click', function(){
		$('#schof').attr('action', '/scholarship/insertScholarship');
		$('#schof').submit();
	});
	
})
</script>
<style>
.row{
	width: 100%;
    height: 1000px;
    margin-left: -2px;
}
.findLi{
	display: table-cell;
    font-size: 30px;
}
.addLine{
    border-left: solid 3px #005f86;
	border-top: solid 3px #005f86;
    border-right: solid 3px #005f86;
}
.addLine-b{
	border-bottom : solid 3px #005f86;
}
.findAtag{
	display: inline-block;
	width: 100%;
	height: 100%;
}
.firstCol{
	width : 270px;
	height : 40px; 
	float : left;
}
.lastCol{
	width : 270px;
	height :40px; 
	float : right;
}
button:focus{
	outline: none;
}
.table-responsive{
	height: 90%;
}
.thead-light{
	text-align: center;
}
.total{
	color: green;
}
.lsecnt{
	color: blue;
}
.examcnt{
	color: red;
}
.tdc{
	text-align: center;
}
.right{
    margin-bottom: 15px;
    text-align: right;
    width: 100%;
}
</style>
<body>
<form:form action="/scholarship/insertScholarship" id="schof" commandName="scholarshipVO" name="ScholarshipVO" method="post">
	<form:input type="hidden" path="searchSubject" value="${searchSubject }" />
	<form:input type="hidden" path="excelGn" value="3" />
	<form:input type="hidden" path="lesId" value="${lesId }"/>
	<input type="hidden" name="schlState" value="2"/>
	
	<div class="limiter" style="background-color:#f4f4f4">
		<div class="container-login100" style="padding: 40px;" >
			<div class="row" style="border:1px solid #ededed; padding:20px;background-color:white;">
				<h2>시험 완료 회원 목록</h2>
				<div class="right">
					<input type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#exampleModalCenter" value="장학금 지급">
					<input type="button" id="excelBtn" class="btn btn-sm btn-primary" value="엑셀 다운로드">
					<input type="button" id="cancel" class="btn btn-sm btn-primary" value="목록으로 가기">
				</div>
				<div class="table-responsive" id="inschl">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col" style="width: 5%;">순</th>
								<th scope="col" style="width: 30%;">강의명</th>
								<th scope="col" style="width: 10%;">회원 아이디</th>
								<th scope="col" style="width: 10%;">회원명</th>
								<th scope="col" style="width: 10%;">회원전화번호</th>
								<th scope="col" style="width: 10%;">회원평균성적</th>
							</tr>
						</thead>
						<tbody id="lesidx">
							<c:choose>
								<c:when test="${scholarshipList.size() ne 0}">
									<c:forEach items="${scholarshipList}" var="scholarship" varStatus="status">
										<tr data-lesid='${scholarship.lesId }'>
											<td class="tdc">${status.count }</td>
											<td>${scholarship.lesNm }</td>
											<td class="tdc">
												${scholarship.userId}
												<input type="hidden" name="userIdList" value="${scholarship.userId}">
											</td>
											<td class="tdc">${scholarship.userNm}</td>
											<td class="tdc">${scholarship.userTel}</td>
											<td class="tdc">${scholarship.userAvg}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="6" style="text-align: center;">데이터가 존재하지 않습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</form:form>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong style="color:red;">경 고!</strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	장학금을 지급하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="agree">장학금 지급</button>
        &nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">취소하기</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>