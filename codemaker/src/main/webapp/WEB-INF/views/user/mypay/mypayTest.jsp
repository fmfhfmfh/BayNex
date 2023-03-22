<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="/css/user/mypage/mypage-style3.css">
<link rel="stylesheet" href="/css/user/mypage/mypage-style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<!-- 필기노트내역 page css -->
<link href="/css/user/mypage/mypage-note.css" rel="stylesheet"/>


<script>
$(function(){

	$("#reBtn").on('click',function(){
		
		var lesTotal="";
		var payId = "";
		
	
		$('input:radio[name=payId]').each(function(){
			
			lesTotal=$("input:radio[name='payId']:checked").next().val();
			console.log(lesTotal);
			if(lesTotal >= 1){
				alert("수강중인 내역이 존재하므로 환불이 불가합니다.");
				return false;
				
			}else if($("#refundradio").is(":checked") == false){
				alert("환불할 내역을 선택해 주세요.");
				return false;
				
			}else{
				payId= $("input:radio[name='payId']:checked").val();
				var url = '/mypage/payRefundView?payId='+payId;
				
				var windowObj = window.open(url,'mypay_refund', 'width=449,height=680,resizable=no,scrollbars=yes,left=800,top=50');
			}
		})
	
	})
	
})

</script>  
<div class="card shadow note-box">
	<div class="note-box-item">
	<!-- 임시커밋용 -->
		<h3>포인트내역</h3>
		<div class="note-item-cont">
			<div id="pdfd">
				<button type="button" class="pdf-btn" id="reBtn">강의 환불</button>
			</div>
			<div class="note-tb-box">
				<table class="note-tb">
					<thead>
						<tr>
		                    <th scope="col">결제ID</th>
		                    <th scope="col">강의명</th>
		                    <th scope="col">결제일</th>
		                    <th scope="col">수강기간</th>
		                    <th scope="col">결제방식</th>
		                    <th scope="col">결제금액</th>
		                    <th scope="col">환불여부</th>
		                    <th scope="col">&nbsp;</th>
						</tr>
					</thead>
		
					<tbody id="myPay">
                	<c:forEach items="${myPay}" var="myPay">
                  <tr>
                    <td>
                      ${myPay.payId}
                    </td>
                    <td>
                      ${myPay.lesNm}
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                      <fmt:formatDate value="${myPay.payDate }" pattern="yyyy-MM-dd"></fmt:formatDate>
                      </span>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                      <fmt:formatDate value="${myPay.cosTerm }" pattern="yyyy-MM-dd"></fmt:formatDate>
                      </span>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                      	<c:choose>
							<c:when test="${myPay.payWay=='1'}">
								포인트결제
                        	</c:when>
	                        <c:otherwise>
	                        	카카오페이
	                        </c:otherwise>
                        </c:choose>
                      </span>
                    </td>
                    <td>
                          <fmt:formatNumber value="${myPay.paySum }"></fmt:formatNumber>원
                    </td>
                    <td>
                    	<c:choose>
							<c:when test="${myPay.payRefund=='N'}">
			                    <span class="badge badge-success">수강중</span>
							</c:when>
							<c:otherwise>
								<span class="badge badge-danger">환불완료</span>
							</c:otherwise>
                    	</c:choose>
                    	
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${myPay.payRefund=='N'}">
		                    	<input type="radio" id="refundradio" name="payId" value="${myPay.payId}">
		                    	<input type="hidden" id="lesTotal" name="lesTotal" value="${myPay.lesTotal}">
                    		</c:when>
                    		<c:otherwise>
                    			<input type="radio" id="refundradio" name="payId" value="${myPay.payId}" disabled="disabled">
		                    	<input type="hidden" id="lesTotal" name="lesTotal" value="${myPay.lesTotal}">
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                  </tr>
             	</c:forEach>
                </tbody>
              </table>
            </div>
	
	
<!-- 페이징 -->
  		 <div class="card-footer py-4">
              <nav aria-label="...">
					<c:if test="${myPay.size() ne 0 }">
                		<ul class="pagination justify-content-end mb-0">
						<c:if test="${page!=1}">
							<li class="page-item active">
			                   <a class="page-link pageMove" href="${cp}/mypage/selectAllMyPay?page=${page-1}"><</a>
			                 </li>
						</c:if>
						

	                  <c:forEach var ="i" begin="1" end="${pages }">
		                  <c:choose>
							<c:when test="${i==page}">
		                 	 	<li class="page-item active">
		                    	<a class="page-link" href="#">${i }</a>
		                   		</li>
		                  </c:when>
		                  <c:otherwise>
			                    <li class="page-item active">
			                    <a class="page-link" href="${cp}/mypage/selectAllMyPay?page=${i}">${i}</a>
			                 	</li>
		                  </c:otherwise>
		                  </c:choose>
	                  </c:forEach>
	                  
                  
                 		<c:if test="${page != pages }">
								<li class="page-item active">
                    				<a class="page-link pageMove" href="${cp}/mypage/selectAllMyPay?page=${page+1}">></a>
                  				</li>
						</c:if>
	                	</ul>
	                </c:if>
	              </nav>
	           </div>
		</div>
	</div>
</div>

