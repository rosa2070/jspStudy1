<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name1", "홍길동");
	request.setAttribute("name2", "박문수");
	session.setAttribute("name3", "임꺽정");
	application.setAttribute("name4", "장길순");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name1 : ${ pageScope.name1 }<br />
name2 : ${ requestScope.name2 }<br />
name3 : ${ sessionScope.name3 }<br />
name4 : ${ applicationScope.name4 }<br />

name1 : ${ name1 }<br />
name2 : ${ name2 }<br />
name3 : ${ name3 }<br />
name4 : ${ name4 }<br />
</body>
</html>