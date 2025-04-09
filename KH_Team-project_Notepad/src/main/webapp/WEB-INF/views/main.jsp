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
        <form action="/login" method="post">
            아이디 : <input type="text" name="userId"> <br>
            비밀번호 : <input type="password" name="userPw"> <br>
            <button>로그인</button>
            <a href="/signup">회원가입</a>
        </form>
    </c:if>
    
    <c:if test="${not empty sessionScope.loginMember}">
        <p>${sessionScope.loginMember.memberName} 환영합니다!</p>
        <button type="button" id="logout">로그아웃</button>
    </c:if>
    
    <h1>Notepad</h1>
    
    <div class="topic-filter">
        <button type="button" data-topic="all" class="active">전체</button>
        <button type="button" data-topic="0">공지</button>
        <button type="button" data-topic="1">개인</button>
        <button type="button" data-topic="2">업무</button>
    </div>
    
    <h3>전체 메모 개수: ${fn:length(postList)}개 / 
        체크된 메모 개수: ${checkedCount}개</h3>

    <hr>
    
    <h4>메모 작성</h4>
    <form action="/post/add" method="post" id="addForm">
        <div>
            제목: <input type="text" name="title" required>
        </div>
        <div>
            <textarea rows="5" cols="50" name="content"
            placeholder="내용을 입력하세요..." required></textarea>
        </div>
        <div>
            주제:
            <select name="topic">
                <option value="0">공지</option>
                <option value="1" selected>개인</option>
                <option value="2">업무</option>
            </select>
        </div>
        <div>
            옵션:
            <select name="option">
                <option value="0">공개</option>
                <option value="1">비공개</option>
                <option value="2">체크리스트</option>
            </select>
        </div>
    
        <button>등록하기</button>
    </form>
    
    <hr>
    
    <table id="postList" border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>주제</th>
                <th>옵션</th>
                <th>체크</th>
                <th>작성자</th>
                <th>등록일</th>
            </tr>
        </thead>
        
        <tbody>
            <c:forEach items="${postList}" var="post" varStatus="vs">
                <tr class="post-item" data-topic="${post.postTopic}">
                    <th>${vs.count}</th>
                    <td>
                        <a href="/post/detail?postNo=${post.postNo}">
                            ${post.postTitle}
                        </a>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${post.postTopic == 0}">공지</c:when>
                            <c:when test="${post.postTopic == 1}">개인</c:when>
                            <c:when test="${post.postTopic == 2}">업무</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${post.postOption == 0}">공개</c:when>
                            <c:when test="${post.postOption == 1}">비공개</c:when>
                            <c:when test="${post.postOption == 2}">체크리스트</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${post.postOption == 2}">
                            <c:if test="${post.postCheck}">✓</c:if>
                            <c:if test="${not post.postCheck}">□</c:if>
                        </c:if>
                    </td>
                    <td>${post.memberName}</td>
                    <td>${post.regDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>
        
        <c:remove var="message" scope="session" />
    </c:if>
    
    <script src="/resources/js/main.js"></script>
</body>
</html>