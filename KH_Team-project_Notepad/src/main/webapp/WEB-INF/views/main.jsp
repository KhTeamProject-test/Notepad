<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notepad</title>
    
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
    
    <c:if test="${empty sessionScope.loginMember}">
	   	 <a href="${pageContext.request.contextPath}/loginPage">로그인</a>
     	</div>
     	<div id="signUpBtn">
     		<a href="${pageContext.request.contextPath}/signupPage">회원가입</a>
     	</div>
     	
     	<h1>Notepad</h1>
     	
     	<div class="topic-filter">
	        <button type="button" data-topic="all" class="active">전체</button>
	        <button type="button" data-topic="0">공지</button>
	        <button type="button" data-topic="1">공개</button>
	    </div>
	    
	    <h3>전체 메모 개수: ${fn:length(postList)}개/ 
	        체크된 메모 개수: ${checkedCount}개</h3>
     	
	</c:if>
	
	
	
	<c:if test="${not empty sessionScope.loginMember}">
		<p> ${session.loginMember}님을 환영합니다</p><br>
        <button type="button" id="logout">로그아웃</button>
        
        <h1>Notepad</h1>
        
        <div class="topic-filter">
	        <button type="button" data-topic="all" class="active">전체</button>
	        <button type="button" data-topic="0">자유</button>
	        <button type="button" data-topic="1">질문</button>
	        <button type="button" data-topic="2">취미</button>
		  
		    <h3>전체 메모 개수: ${fn:length(postList)}개 / 
		        체크된 메모 개수: ${checkedCount}개</h3>
			
			<form action="${pageContext.request.contextPath}/addPost" method="get">
			    <button type="submit">메모 작성하기</button>
			</form>
	    </div>
        
	</c:if>
    	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>

		<c:remove var="message" scope="session" />
	</c:if>
    <script src="/resources/js/main.js"></script>
</body>
</html>