<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1><a href="${pageContext.request.contextPath}/main">Notepad</a></h1>
	
	<h2>회원가입</h2>

	<form action="${pageContext.request.contextPath}/signup" method="post">
		<label for="memberId">아이디:</label> <input type="text" id="memberId"
			name="memberId" required> <br>
		<br> <label for="memberPw">비밀번호:</label> <input type="password"
			id="memberPw" name="memberPw" required> <br>
		<br> <label for="memberName">이름:</label> <input type="text"
			id="memberName" name="memberName" required> <br>
		<br>

		<button type="submit">가입하기</button>
	</form>

	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>

		<c:remove var="message" scope="session" />
	</c:if>
</body>
</html>
