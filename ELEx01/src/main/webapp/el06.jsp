<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "홍길동");
	request.setAttribute("name", "박문수");
	session.setAttribute("name", "임꺽정");
	application.setAttribute("name", "장길순");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

name : ${ name }<br />
name : ${ sessionScope.name }<br />

</body>
</html>