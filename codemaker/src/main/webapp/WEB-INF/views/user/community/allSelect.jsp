<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<link href="/css/user/board/community/allSelect.css" rel="stylesheet"/>

<div class="article">
	<div>
		<div class="ds-flex">
			<br><br>
			<h2 class="fw-600 fc">커뮤니티 게시판</h2>
		</div>
		<div class="rightText">
			<select>
				<option value="1" selected="selected">제목</option>
				<option value="2">회원아이디</option>
			</select>
			<input type="text" class="textBt">
			<button type="button" class="btnCol">검색</button>
		</div>
		<br><br><br><br>
		<div>
			<div class="textCt">
				<table>
					<tr class="tr-bo">
						<th class="th-s">글번호</th>
						<th class="th-t">제목</th>
						<th class="th-d">작성일</th>
						<th class="th-s">조회수</th>
						<th class="th-s">작성자</th>
					</tr>
					<tbody>
						<c:forEach items="${postList}" var="postList">
							<tr style="font-size: 25px;">
								<td class="centerTd">${postList.postNo}</td>
								<td>
									<a class="a-title" href="${cp}/user/community/select?postNo=${postList.postNo}">${postList.postTitle}
										<c:set var="today" value="<%=new java.util.Date() %>"/>
										<c:set var="setDate"><fmt:formatDate value="${today}" pattern="yyyyMMddHHmmss"/></c:set>
										<fmt:parseDate var="date" value="${setDate}" pattern="yyyyMMddHHmmss"></fmt:parseDate>
										<fmt:parseNumber var="parseDate" value="${date.time / (1000*60*60*24)}"></fmt:parseNumber>
										<c:set var="setSaveDate"><fmt:formatDate value="${postList.postDate}" pattern="yyyyMMddHHmmss"/></c:set>
										<fmt:parseDate var="saveDate" value="${setSaveDate}" pattern="yyyyMMddHHmmss"></fmt:parseDate>
										<fmt:parseNumber var="parseSaveDate" value="${saveDate.time / (1000*60*60*24)}"></fmt:parseNumber>
										<c:set var="restDate" value="${parseDate - parseSaveDate}"></c:set>
										<c:if test="${restDate le 3}">
											<i class="newIcon">NEW</i>
										</c:if>
									</a>
									
								</td>
								<td><fmt:formatDate value="${postList.postDate}" pattern="yyyy-MM-dd" /></td>
								<td class="centerTd">${postList.postViews}</td>
								<td>${postList.userId}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<button type="button" class="btn" onclick="location.href='/user/community/insertView'">게시글 작성</button>
			</div>
		</div>
	</div>
</div>