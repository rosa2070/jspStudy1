<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  session11.jsp -->
<%
	session.setAttribute("data1", "value1");
	session.setAttribute("data2", 10);
	
	out.println((String)session.getAttribute("data1") + "<br />");
	out.println((Integer)session.getAttribute("data2") + "<br />");
%>
</body>
</html>