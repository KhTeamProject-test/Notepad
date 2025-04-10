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
    
        <button type="button" id="logout">로그아웃</button>
        
    <h1>Notepad</h1>
    
    <div class="topic-filter">
        <button type="button" data-topic="all" class="active">전체</button>
        <button type="button" data-topic="0">공지</button>
        <button type="button" data-topic="1">공개</button>
        <button type="button" data-topic="2">비공개</button>
        <button type="button" data-topic="3">Checked</button>
    </div>
    
    <h3>전체 메모 개수: ${fn:length(postList)}개 / 
        체크된 메모 개수: ${checkedCount}개</h3>
	
	<div id="newMemo">새 메모 작성하기</div>
	
    <hr>
    
    	
    
    <hr>
    
    
    
    <script src="/resources/js/main.js"></script>
</body>
</html>