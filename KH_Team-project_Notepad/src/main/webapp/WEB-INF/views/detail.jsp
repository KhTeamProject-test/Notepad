<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${post.postTitle} 상세 조회</title>
    <link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>

    <h1>${sessionScope.loginMember.memberName}</h1>

    <h1>${post.postTitle}</h1>

    <div class="post-info">
        <div>
            주제: 
            <c:choose>
                <c:when test="${post.postTopic == 0}">공지</c:when>
                <c:when test="${post.postTopic == 1}">개인</c:when>
                <c:when test="${post.postTopic == 2}">업무</c:when>
            </c:choose>
        </div>
        
        <div>
            옵션: 
            <c:choose>
                <c:when test="${post.postOption == 0}">공개</c:when>
                <c:when test="${post.postOption == 1}">비공개</c:when>
                <c:when test="${post.postOption == 2}">체크리스트</c:when>
            </c:choose>
        </div>
        
        <c:if test="${post.postOption == 2}">
            <div class="check-status">
                체크 상태:
                <c:if test="${post.postCheck}">
                    <span class="green">완료 ✓</span>
                </c:if>
                <c:if test="${not post.postCheck}">
                    <span class="red">미완료 □</span>
                </c:if>
            </div>
        </c:if>
    </div>

    <div>
        작성일: ${post.regDate}
    </div>

    <div class="content">${post.postContent}</div>
    
    <div class="btn-container">
        <div>
            <button type="button" id="goToList">목록으로</button>
        </div>
        
        <c:if test="${sessionScope.loginMember.memberNo == post.memberNo}">
            <div>
                <c:if test="${post.postOption == 2}">
                    <button id="toggleCheckBtn">체크 상태 변경</button>
                </c:if>
                <button id="updateBtn">수정</button>
                <button id="deleteBtn">삭제</button>
            </div>
        </c:if>
    </div>
    
    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>
        
        <c:remove var="message" scope="session" />
    </c:if>
    
    <script src="/resources/js/detail.js"></script>
</body>
</html>