<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- Bootstrap theme -->
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css"> --%>

<title>board</title>

<script>
	$(document).on('click', '#btnSave', function(e){
		e.preventDefault();
		
		$("#form").submit();
	});
	
	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		
		location.href="${pageContext.request.contextPath}/board/getBoardList";
	});
</script>
<style>
body {
  padding-top: 70px;
  padding-bottom: 30px;
}

.theme-dropdown .dropdown-menu {
  position: static;
  display: block;
  margin-bottom: 20px;
}

.theme-showcase > p > .btn {
  margin: 5px 0;
}

.theme-showcase .navbar .container {
  width: auto;
}

</style>
</head>
<body>
	<article>
		<div class="container theme-showcase" role="main">
			<h2>board Form</h2>
			<form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post" action="${pageContext.request.contextPath}/board/insertBoard">
				<div class="mb-3">
					<label for="title">제목</label>
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
					<div class="invalid-feedback">
						Title is required.
					</div>
				</div>
				
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">
					<div class="invalid-feedback">
						Your username is required.
					</div>
				</div>
				
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요"></textarea>
					<div class="invalid-feedback">
						Content is required.
					</div>
				</div>
				
				<div class="mb-3">
					<label for="tag">TAG</label>
					<input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
				</div>
			
			</form:form>
			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
		
	</article>
</body>
</html>