<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글</title>
</head>
<body>
	
	<c:if test="${sessionScope.loginId==board.id}">
	
	<form action="boardAction" method="post">
	<input type="hidden" name="action" value="delete">
	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	<button>삭제하기</button>	
	</form>
	
	<form action="boardAction" method="get">
	<input type="hidden" name="action" value="goUpdate">
	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	<button>수정하기</button>	
	</form>
	
	</c:if>


	<h1>제목 : ${board.title}</h1>
	<br><br>
	<h4>게시자 : ${board.id}</h4>
	<br><br>
	<h4>등록일 : ${board.indate}</h4>
	<br><br>
	내용 : ${board.content}
	<br>
	
	<a href="boardAction?action=board">목록으로</a>
	
</body>
</html>