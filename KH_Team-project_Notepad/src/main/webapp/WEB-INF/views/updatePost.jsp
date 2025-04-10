<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${post.postTitle} 수정 페이지</title>
</head>
<body>

    <h1>${sessionScope.loginMember.memberName}</h1>

    <h4>메모 수정</h4>

    <form action="${pageContext.request.contextPath}/post/update" method="post" id="updateForm">
        <div>
            제목: <input type="text" name="title" value="${post.postTitle}" required>
        </div>
        <div>
            <textarea name="content" rows="5" cols="50" placeholder="내용을 입력하세요..." required>${post.postContent}</textarea>
        </div>
        <div>
            주제:
            <select name="topic">
                <option value="0" <c:if test="${post.postTopic == 0}">selected</c:if>>자유</option>
                <option value="1" <c:if test="${post.postTopic == 1}">selected</c:if>>질문</option>
                <option value="2" <c:if test="${post.postTopic == 2}">selected</c:if>>취미</option>
            </select>
        </div>
        <div>
            옵션:
            <select name="option">
                <option value="0" <c:if test="${post.postOption == 0}">selected</c:if>>공개</option>
                <option value="1" <c:if test="${post.postOption == 1}">selected</c:if>>비공개</option>
                <option value="2" <c:if test="${post.postOption == 2}">selected</c:if>>체크리스트</option>
            </select>
        </div>

        <!-- postNo를 안전하게 전달 -->
        <input type="hidden" name="postNo" value="${post.postNo}">

        <button type="submit">수정 완료</button>
    </form>

    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${sessionScope.message}");
        </script>
        <c:remove var="message" scope="session" />
    </c:if>

</body>
</html>