<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div id="text-center">
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