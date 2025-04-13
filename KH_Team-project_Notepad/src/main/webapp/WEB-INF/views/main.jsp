<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notepad</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
    
    <c:if test="${empty sessionScope.loginMember}">
        
        <div class="user-info">
        	<div class="action-buttons">
		        <div id="mainLoginBtn">
	            	<a href="${pageContext.request.contextPath}/loginPage" class="btn">로그인</a>
	        	</div>
	        	<div id="signUpBtn">
	            	<a href="${pageContext.request.contextPath}/signupPage" class="btn">회원가입</a>
	        	</div>
        	</div>
        </div>
        
        <h1>Notepad</h1>
        
        <div class="topic-filter">
            <button type="button" data-topic="all" class="active">전체</button>
            <button type="button" data-topic="0">자유</button>
        </div>
        
        <h3>전체 메모 개수: ${fn:length(postList)}개/ 
            체크된 메모 개수: ${checkedCount}개</h3>
        
        <hr>


        <div class="mainPosts">
            <c:forEach items="${openPostList}" var="openPost">
                <div class="openPost">
                    ${openPost.postNo}
                    ${openPost.postTitle}<br><br>
                    ${openPost.postContent}<br><br>
                    ${openPost.postTopic}
                    ${openPost.postOption}
                    ${openPost.memberId}<br>
                    ${openPost.regDate}
                </div>
            </c:forEach>  
        </div>    
    </c:if>
    
    <c:if test="${not empty sessionScope.loginMember}">
    	<div class="user-info">
	        <p class="welcome">${sessionScope.loginMember.memberId}님을 환영합니다</p><br>
	        <div class="action-buttons">
	        	<button type="button" id="logout" data-context-path="${pageContext.request.contextPath}">로그아웃</button>
	        	<a href="${pageContext.request.contextPath}/member/updatePage" class="btn">회원 정보 수정</a>
        	</div>
        </div>
        
        <h1>Notepad</h1>
        
        <div class="topic-filter">
            <button type="button" data-topic="all" class="active">전체</button>
            <button type="button" data-topic="0">자유</button>
            <button type="button" data-topic="1">질문</button>
            <button type="button" data-topic="2">취미</button>
            
            <h3>전체 메모 개수: ${fn:length(postList)}개 / 
                체크된 메모 개수: ${checkedCount}개</h3>
                
            <a href="${pageContext.request.contextPath}/addPost/add">메모 작성하기</a>
        </div>

        
        <div class="mainPosts">
            <div class="post-list" data-topic="0" style="display:none;">
                <c:forEach items="${firstTopicPostList}" var="firstTopicPost">
                    <div class="firstTopicPost">
                        ${firstTopicPost.postNo}
                        ${firstTopicPost.postTitle}<br><br>
                        ${firstTopicPost.postContent}<br><br>
                        ${firstTopicPost.postTopic}
                        ${firstTopicPost.postOption}
                        ${firstTopicPost.memberId}<br>
                        ${firstTopicPost.regDate}
                    </div>
                </c:forEach>
            </div>

            <div class="post-list" data-topic="1" style="display:none;">
                <c:forEach items="${secondTopicPostList}" var="secondTopicPost">
                    <div class="secondTopicPost">
                        ${firstTopicPost.postNo}
                        ${firstTopicPost.postTitle}<br><br>
                        ${firstTopicPost.postContent}<br><br>
                        ${firstTopicPost.postTopic}
                        ${firstTopicPost.postOption}
                        ${firstTopicPost.memberId}<br>
                        ${firstTopicPost.regDate}
                    </div>
                </c:forEach>
            </div>
            
            <div class="post-list" data-topic="2" style="display:none;">
                <c:forEach items="${thirdTopicPostList}" var="thirdTopicPost">
                    <div class="thirdTopicPost">
                        ${firstTopicPost.postNo}
                        ${firstTopicPost.postTitle}<br><br>
                        ${firstTopicPost.postContent}<br><br>
                        ${firstTopicPost.postTopic}
                        ${firstTopicPost.postOption}
                        ${firstTopicPost.memberId}<br>
                        ${firstTopicPost.regDate}
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:if>
    
    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>
        <c:remove var="message" scope="session" />
    </c:if>
    
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const buttons = document.querySelectorAll(".topic-filter button");
        const postLists = document.querySelectorAll(".post-list");

        buttons.forEach(btn => {
            btn.addEventListener("click", function () {
                const topic = this.getAttribute("data-topic");

                // 버튼 활성화 표시
                buttons.forEach(b => b.classList.remove("active"));
                this.classList.add("active");

                // 리스트 필터링
                postLists.forEach(list => {
                    if (topic === "all") {
                        list.style.display = "block"; // '전체' 클릭 시 모든 리스트 보이기
                    } else {
                        // 해당 토픽에 맞는 리스트만 보이기
                        list.style.display = list.getAttribute("data-topic") === topic ? "block" : "none";
                    }
                });
            });
        });
    });
</script>

<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>
