<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1><a href="${pageContext.request.contextPath}/main">Notepad</a></h1>
	
	<h2>로그인</h2>

	<form action="${pageContext.request.contextPath}/login" method="post">
		<label for="userId">아이디:</label> <input type="text" id="userId"
			name="userId" required> <br>
		<br> <label for="userPw">비밀번호:</label> <input type="password"
			id="userPw" name="userPw" required> <br>
		<br>

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
