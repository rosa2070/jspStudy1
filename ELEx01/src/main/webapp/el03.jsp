<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  el01.jsp -->

<table width="800" border="1">
<tr>
	<td width="300">표현식</td>
	<td>값</td>
</tr>
<tr>
	<td>\$ { 2 < 5 } </td>
	<td>${ 2 < 5 } </td>
</tr>
<tr>
	<td>\${2 lt 5 }</td>
	<td>${2 lt 5 }</td>
</tr>
<tr>
	<td>\${ (2 < 3) ? "작다" : "크다" }</td>
	<td>${ (2 < 3) ? "작다" : "크다" }</td>
</tr>
</table>
</body>
</html>