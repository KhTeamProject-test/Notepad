<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>

    <h1>${sessionScope.loginMember.memberName} 님, 메모를 작성하세요</h1>

    <form action="${pageContext.request.contextPath}/addPost" method="post">
        <div>
            <label>제목:</label>
            <input type="text" name="title" required />
        </div>

        <div>
            <label>내용:</label>
            <textarea name="content" rows="8" required></textarea>
        </div>

        <div>
            <label>주제:</label>
            <select name="topic">
                <option value="0">자유</option>
                <option value="1">질문</option>
                <option value="2">취미</option>
            </select>
        </div>

        <div>
            <label>옵션:</label>
            <select name="option">
                <option value="0">공개</option>
                <option value="1">비공개</option>
                <option value="2">체크리스트</option>
            </select>
        </div>

        <button type="submit">등록</button>
        <button type="button" onclick="location.href='${pageContext.request.contextPath}/post/list'">취소</button>
    </form>

    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${sessionScope.message}");
        </script>
        <c:remove var="message" scope="session"/>
    </c:if>

</body>
</html>
