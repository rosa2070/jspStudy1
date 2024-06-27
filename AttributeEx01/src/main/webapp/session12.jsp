<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  session12.jsp -->
<%
	// 크롬에서...
	
	//session11.jsp -> session12.jsp -> 브라우저 재접속 -> session12.jsp -> session11.jsp
	
	out.println((String)session.getAttribute("data1") + "<br />");
	out.println((Integer)session.getAttribute("data2") + "<br />");
%>
</body>
</html>