<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/tiles/layouts/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>user regist</title>


<script>
	$(document).on('click', '#btnSave', function(e){
		e.preventDefault();

		$("#form").submit();
	});
	
	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		
		location.href="${pageContext.request.contextPath}/user/getUserList";
	});
	
	$(document).ready(function(){
		var mode = '<c:out value="${mode}"/>';
		if ( mode == 'edit'){
			//입력 폼 셋팅
			$("#reg_id").prop('readonly', true);
			$("input:hidden[name='bid']").val(<c:out value="${boardContent.bid}"/>);
			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
			$("#reg_id").val('<c:out value="${boardContent.reg_id}"/>');
			$("#title").val('<c:out value="${boardContent.title}"/>');
			$("#content").val('<c:out value="${boardContent.content}"/>');
			$("#tag").val('<c:out value="${boardContent.tag}"/>');
		}
	});

</script>

</head>
<body>
	<article>
		<div class="container" role="main">
			<h2>User Regist Form</h2>
			<form:form name="form" id="form" role="form" modelAttribute="userVO" method="post" action="${pageContext.request.contextPath}/user/insertUser">

				<div class="row">
					<div class="mb-3">
						<label for="uid">아이디</label>
						<form:input path="uid" id="uid" class="form-control" placeholder="아이디을 입력해 주세요" />
					</div>
				</div>


				<div class="row">
					<div class="mb-3">
						<label for="name">이름</label>
						<form:input path="name" id="name" class="form-control" placeholder="이름을 입력해 주세요" />
					</div>
				</div>
				
				<div class="row">
					<div class="mb-3">
						<label for="pwd">비밀번</label>
						<form:input path="pwd" id="pwd" class="form-control" placeholder="비밀번호를 입력해 주세요" />
					</div>
				</div>
				
				<div class="row">
					<div class="mb-3">
						<label for="email">이메일</label>
						<form:input path="email" id="email" class="form-control" placeholder="이메일을 입력해 주세요" />
					</div>
				</div>

				<div class="row">
					<div class="mb-3">
						<label for="grade">등급</label>					
						<form:select path="grade" class="custom-select d-block w-100" id="grade">
							<form:option value="">Choose...</form:option>
							<form:option value="admin">관리자</form:option>
							<form:option value="manager">매니져</form:option>
							<form:option value="user">일반사용자</form:option>
						</form:select>
					</div>
				</div>
			</form:form>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
		
	</article>
	<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>
</body>
</html>