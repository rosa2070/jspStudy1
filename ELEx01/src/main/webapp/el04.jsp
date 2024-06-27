<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String name1 = "홍길동";
	pageContext.setAttribute("name2", "박문수");
	
	out.println(name1 + "<br />");
	out.println((String)pageContext.getAttribute("name2") + "<br />");
%>
<%=name1 %><br />
name 1 : ${ name1 }<br />
name 2 : ${ name2 }<br />
name 2 : ${ pageScope.name2 }<br />
name 2 : ${ pageScope['name2'] }<br />
</body>
</html>