<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">

	function fn_btnSignupClick(){
		location.href ="${pageContext.request.contextPath}/user/signupForm";
	} 


	$(document).ready(function(){
	    $('[data-toggle="popover"]').popover();   
	});

</script>

<!-- login form {s} -->
<form:form class="form-signin" name="form" id="form" role="form" modelAttribute="userVO" method="post" action="${pageContext.request.contextPath}/login/login">
	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">FREEHOON.COM</h1>
	</div>
	
	<div class="form-label-group">
		<form:input path="uid" id="uid" class="form-control" placeholder="User ID" required="" autofocus="" />
		<label for="uid" class="sr-only">User ID</label>
	</div>
	
	<div class="form-label-group">
		<form:password path="pwd" id="pwd" class="form-control" placeholder="User Password" required="" />
		<label for="pwd" class="sr-only">User Password</label>
	</div>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	
	<span style="font-size:11pt;">
		<a href="#" onClick="fn_btnSignupClick()">Sign up</a>
	</span>
	
	<a href="#" data-toggle="popover" title="Popover Header" data-content="Some content inside the popover">Toggle popover</a>
	
	<p class="mt-5 mb-3 text-muted text-center">© 2019. FREEHOON. All rights reserved.</p>
</form:form>
<!-- login form {e} -->
