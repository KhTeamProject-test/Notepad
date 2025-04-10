<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notepad</title>

<link rel="stylesheet" href="/resources/css/mainPage.css">
</head>
<body>
	
	 <div id="mainLoginBtn">
	    <a href="${pageContext.request.contextPath}/loginPage">로그인</a>
	    <a href="${pageContext.request.contextPath}/signupPage">회원가입</a>
     </div>
	
	<h1>Notepad</h1>
    
    <div class="topic-filter">
        <button type="button" data-topic="all" class="active">전체</button>
        <button type="button" data-topic="0">공지</button>
        <button type="button" data-topic="1">공개</button>
        
    </div>
    
    <h3>전체 메모 개수: ${fn:length(openPostList)}개
        </h3>

    <hr>
    <div>
	    1
    </div>
    
    

    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>
        
        <c:remove var="message" scope="session" />
    </c:if>

	<script src="/resources/js/mainPage.js"></script>
</body>
</html>