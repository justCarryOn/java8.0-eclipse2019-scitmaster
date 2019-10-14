<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>

	<form action="boardAction" method="get">
		<input type="hidden" value="boardWrite" name="action">
		<button>글등록</button>
	</form>

	
	<table>
	<c:forEach items="${bList}" var="board">
	<tr>
	<td>${board.boardSeq}</td>
	<td><a href="boardAction?action=detail&boardSeq=${board.boardSeq}" >${board.title}</a></td>
	<td>${board.indate}</td>
	<td>${board.id}</td>
	</tr>
	</c:forEach>
	</table>



</body>
</html>