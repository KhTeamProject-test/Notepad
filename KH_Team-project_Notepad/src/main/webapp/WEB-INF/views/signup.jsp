<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signup.css">
</head>
<body>
	<h1><a href="${pageContext.request.contextPath}/main">Notepad</a></h1>

	<form action="${pageContext.request.contextPath}/signup" method="post">
		<div class="form-group">
			<!-- 아이디는 영어 대소문자와 숫자만 사용, 최소 3자 ~ 최대 10자 -->
			<label for="memberId">아이디</label> <input type="text" id="memberId"
				name="memberId" 
				pattern="^(?=.*[a-zA-Z])[a-zA-Z0-9]{3,10}$"
				placeholder="대소문자, 숫자 3~10자"
				required>
		</div>
		
		<div class="form-group">
			<!-- 비밀번호는 최소 6자 이상, 대소문자 영어 각 1개 이상, 숫자 1개 이상, 특수문자(!@#_) 1개 이상 포함 -->
			<label for="memberPw">비밀번호</label> <input type="password"
				id="memberPw" name="memberPw" 
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#_])[a-zA-Z\d!@#_]{6,}$"
				placeholder="영어, 숫자, (!@#_) 포함 및 최소 6자"
				required>
		</div>
			
		<div class="form-group">	
			<!-- 한글 또는 영문만 입력 가능하며, 최대 10자 -->
			<label for="memberName">이름</label> <input type="text"
				id="memberName" name="memberName" 
				maxlength="10" 
				pattern="^[가-힣a-zA-Z]{1,10}$" 
				placeholder="한글, 영문 최대 10자"
				required>
		</div>
		
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
