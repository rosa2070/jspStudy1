<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session1.jsp -->
<%
	out.println(session.getId() + "<br />");
	out.println(session.getMaxInactiveInterval() + "<br />");
	out.println(new java.util.Date(session.getCreationTime()) + "<br />");
	out.println(new java.util.Date(session.getLastAccessedTime()) + "<br />");
%>
</body>
</html>