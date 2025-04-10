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
		
		<div id="mainLoginBtn">
	   	 <a href="/loginPage">로그인</a>
	   	 <a href="${pageContext.request.contextPath}/loginPage">로그인</a>
     	</div>
     	<div id="signUpBtn">
     		<a href="${pageContext.request.contextPath}/signupPage">회원가입</a>
     	</div>
     	
     	<div id="newMemo"><a href="/addPost">새 메모 작성하기</a></div>
     	
     	<h1>Notepad</h1>
     	
     	<div class="topic-filter">
	        <button type="button" data-topic="all" class="active">전체</button>
	        <button type="button" data-topic="0">공지</button>
	        <button type="button" data-topic="1">공개</button>
	    </div>
	    
	    <h3>전체 메모 개수: ${fn:length(postList)}개/ 
	        체크된 메모 개수: ${checkedCount}개</h3>
	    
	    <hr>
	    
	  
	    <div class="mainPosts">
		    <c:forEach items="${openPostList}" var="openPost">
		    	<div class="openPost">
		    		${openPost.memberName}
		    		
		    	</div>
		    </c:forEach>  
	    </div>    
	        
	    
	</c:if>
	
	
	
	<c:if test="${not empty sessionScope.loginMember}">
		<p> ${session.loginMember}님을 환영합니다</p><br>
        <button type="button" id="logout">로그아웃</button>
        
        <h1>Notepad</h1>
        
        <div class="topic-filter">
	        <button type="button" data-topic="all" class="active">전체</button>
	        <button type="button" data-topic="0">공지</button>
	        <button type="button" data-topic="1">공개</button>
	        <button type="button" data-topic="2">비공개</button>
	        <button type="button" data-topic="3">Checked</button>
		  
		    <h3>전체 메모 개수: ${fn:length(postList)}개 / 
		        체크된 메모 개수: ${checkedCount}개</h3>
			
			<div id="newMemo"><a href="/addPost">새 메모 작성하기</a></div>
	    </div>
        
	</c:if>
    
    <%-- session 범위에 message가 있을 경우  --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			//JS 영역
			alert("${message}")
			// JSP 해석 순위
			// 1순위 : Java
			// 2순위 : Front(HTML/CSS/JS)
		</script>
		
		<%-- message를 한번만 출력하고 제거 --%>
		<c:remove var="message" scope="session"/>
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