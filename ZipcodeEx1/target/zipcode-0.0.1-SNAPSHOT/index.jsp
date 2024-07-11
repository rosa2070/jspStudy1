<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.exam.zipcode.ZipcodeDAO" %>
<%@ page import="com.exam.zipcode.ZipcodeTO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.searchZipcode("신사");
	
	out.println("<table border='1'>");
	for (ZipcodeTO to : lists) {
		out.println("<tr>");
		out.println("<td>" + to.getZipcode() + "<td/>");
		out.println("<td>" + to.getSido() + "<td/>");
		out.println("<td>" + to.getGugun() + "<td/>");
		out.println("<td>" + to.getDong() + "<td/>");
		out.println("<td>" + to.getRi() + "<td/>");
		out.println("<td>" + to.getBunji() + "<td/>");
		out.println("</tr>");
	}
	out.println("</table>");
%>
</body>
</html>