<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="globalCtx" value="${pageContext.request.contextPath}" scope="request"/>

<c:url var="writeFormUrl" value="/board/boardForm">
	<c:if test="${not empty pagination.page}"><c:param name="page" value="${pagination.page}"/></c:if>
	<c:if test="${not empty pagination.range}"><c:param name="range" value="${pagination.range}"/></c:if>
</c:url>

<c:url var="contentViewURL" value="/board/getBoardContent">
</c:url>

<c:url var="getBoardListURL" value="/board/getBoardList">
</c:url>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>board</title>

<script>
	$(document).on('click', '#btnWriteForm', function(e){
		e.preventDefault();
		
		location.href = "${writeFormUrl}";
	});
	
	$(document).on('click', '#btnSearch', function(e){
		e.preventDefault();
		var url = "${getBoardListURL}";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();
		console.log(url);
		location.href = url;
		
	});
	
	function fn_contentView(bid) {
		var url = "${contentViewURL}";
		url = url + "?bid=" + bid;
		
		location.href = url;
	}
	
	function fn_prev(page, range, rangeSize, searchType, keyword) {
		
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var url = "${globalCtx}/board/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		
		location.href = url;
	}

	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "${getBoardListURL}";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		console.log(url);
		location.href = url;
		
	}
	
	function fn_next(page, range, rangeSize, searchType, keyword) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		
		var url = "${globalCtx}/board/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		
		location.href = url;
	}
	
</script>

<style>
	#paginationBox{
		padding : 10px 0px;
	}
</style>
 
</head>
<body>
	<article>
	<div class="container">
		<h2>board list</h2>
		
		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<colgroup>
					<col style="width:5%;" />
					<col style="width:auto;" />
					<col style="width:15%;" />
					<col style="width:10%;" />
					<col style="width:10%;" />
				</colgroup>
				<thead>
					<tr>
						<th>NO</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty boardList }" >
							<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
						</c:when> 
						<c:when test="${!empty boardList}">
							<c:forEach var="list" items="${boardList}">
								<tr>
									<td><c:out value="${list.bid}"></c:out></td>
									<td>
										<a href="#" onClick="fn_contentView(<c:out value="${list.bid}"/>)" >
											<c:out value="${list.title}"/>
										</a>
									</td>
									<td><c:out value="${list.reg_id}"/></td>
									<td><c:out value="${list.view_cnt}"/></td>
									<td><c:out value="${list.reg_dt}"/></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div>
			<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
		</div>

		<!-- pagination{s} -->
		<div id="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}')">Previous</a></li>
				</c:if>
				
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}' )"> ${idx} </a></li>
				</c:forEach>
				
				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}')">Next</a></li>
				</c:if>
			</ul>
		</div>
		<!-- pagination{e} -->
		<!-- search{s} -->
		<div class="form-group row justify-content-center">
			<div style="padding-right:10px">
				<select class="form-control form-control-sm" name="searchType" id="searchType">
					<option value="title" <c:if test="${pagination.searchType eq 'title'}">selected</c:if> >제목</option>
					<option value="content" <c:if test="${pagination.searchType eq 'content'}">selected</c:if>>본문</option>
					<option value="reg_id" <c:if test="${pagination.searchType eq 'reg_id'}">selected</c:if>>작성자</option>
				</select>
			</div>
			<div style="padding-right:10px">
				<input type="text" class="form-control form-control-sm" name="keyword" id="keyword" value="${pagination.keyword}">
			</div>
			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
			</div>
		</div>
		<!-- search{e} -->

	</div>
	</article>
</body>
</html>