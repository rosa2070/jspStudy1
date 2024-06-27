<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  page.jsp  -->
<%
	// String => Object
	pageContext.setAttribute("data1", "value1");
	String data1 = (String)pageContext.getAttribute("data1");
	out.println(data1 + "<br />");
	
	// Date => Object
	pageContext.setAttribute("data2", new java.util.Date());
	java.util.Date date = (java.util.Date) pageContext.getAttribute("data2");
	out.println(date + "<br />");
	out.println(date.toLocaleString() + "<br />");
	
	// Wrapper
	// int : 10 + pageContext
	pageContext.setAttribute("data3", 10);
	//pageContext.setAttribute("data3", Integer.valueOf(10));
	
	//Integer i1 = (Integer)pageContext.getAttribute("data3");
	int i1 = (Integer)pageContext.getAttribute("data3");
	//out.println(i1.intValue() + "<br />");
	out.println(i1 + "<br />");

%>
</body>






</html>