<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<script>
		$(() => {
			console.log("페이지 로딩 시 실행");
		});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
