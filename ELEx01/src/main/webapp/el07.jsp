<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%
	BoardTO to = new BoardTO();
	to.setSubject("제목1");
	to.setWriter("작성자 1");
	
	pageContext.setAttribute("to", to);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//to = (BoardTO)pageContext.getAttribute("to");
	//out.println(to.getWriter() + "<br />");
	//out.println(to.getSubject() + "<br />");
%>
${ to.subject } <br />
${ to.writer }<br />
</body>
</html>