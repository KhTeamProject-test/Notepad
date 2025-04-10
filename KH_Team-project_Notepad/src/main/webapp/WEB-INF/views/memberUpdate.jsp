<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 수정 페이지</title>

	<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

	<h1>${sessionScope.loginMember}</h1>
	
	<h4>유저 정보 수정</h4>
	
	<form action="/member/update" method="post">
		비밀번호 : <input type="password" name="memberPw"> <br>
		비밀번호 확인 : <input type="password" name="memberPwCheck"> <br>
		이름 : <input type="text" name="memberName"> <br>
		
		<input type="hidden" name="memberId" value="${param.memberId}">
		<button>수정</button> <button>취소</button>
	</form>
	
	<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			//JS 영역
			alert("${message}");
			// JSP 해석 순위
			// 1순위 : Java(EL / JSTL)
			// 2순위 : Front(HTML / CSS / JS)
		</script>
		
		<%-- message를 한 번만 출력하고 제거 --%>
		<c:remove var="message" scope="session" />
	
	</c:if>

	<script src="/resources/js/main.js"></script>
</body>
</html>