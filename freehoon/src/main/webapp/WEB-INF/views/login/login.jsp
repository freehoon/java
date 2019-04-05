<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<c:set var="globalCtx" value="${pageContext.request.contextPath}" scope="request"/>

<c:url var="registUserFormUrl" value="/user/registUserForm">
	<c:if test="${not empty pagination.page}"><c:param name="page" value="${pagination.page}"/></c:if>
	<c:if test="${not empty pagination.range}"><c:param name="range" value="${pagination.range}"/></c:if>
</c:url>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>

<script>
	
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
		
		<!-- login form {s} -->
		<form class="form-signin">
			<div class="text-center mb-4">
				
				<h1 class="h3 mb-3 font-weight-normal">FREEHOON.COM</h1>
			</div>
			
			<div class="form-label-group">
				<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
				<label for="inputEmail">Email address</label>
			</div>
			
			<div class="form-label-group">
				<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
				<label for="inputPassword">Password</label>
			</div>
			
			<div class="checkbox mb-3">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<p class="mt-5 mb-3 text-muted text-center">© 2017-2019</p>
		</form>
				
		<!-- login form {e} -->
	</div>
	</article>
</body>
</html>