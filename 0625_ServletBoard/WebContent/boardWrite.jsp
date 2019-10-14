<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글등록</title>
</head>
<body>

	<form action="boardAction" method="post">
	<c:if test="${board.boardSeq==null}">
	
	<input type="hidden" name="action" value="write">
		
	</c:if>
	
	<c:if test="${board.boardSeq!=null}">
	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	<input type="hidden" name="action" value="update">
		
	</c:if>
		제목 : <input type="text" name="title" value="${board.title}"><br>
		내용 : <br><textarea rows="10" cols="30" name="content">${board.content}</textarea>
		
	<c:if test="${board.boardSeq==null}">
		<br><input type="submit" value="글등록">
		</c:if>
	<c:if test="${board.boardSeq!=null}">
		<br><input type="submit" value="글수정">
	</c:if>
	</form>
	

</body>
</html>