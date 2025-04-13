<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	<h1><a href="${pageContext.request.contextPath}/main">Notepad</a></h1>

	<form action="${pageContext.request.contextPath}/login" method="post">
		<div class="form-group">
			<label for="userId">아이디  </label> <input type="text" 
				id="userId" name="userId" required>
		</div>
		
		<div class="form-group">
		 	<label for="userPw">비밀번호  </label> <input type="password"
				id="userPw" name="userPw" required>
		</div>

		<button type="submit">로그인</button>
	</form>

	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>

		<c:remove var="message" scope="session" />
	</c:if>
</body>
</html>
