<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.exam.model1.EmpTO" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<EmpTO> lists = (ArrayList<EmpTO>) request.getAttribute("lists");

	StringBuilder sbHtml = new StringBuilder();
	
	sbHtml.append("<table width='800' border='1' cellpadding='0'>");
		
	for (EmpTO to : lists) {
		sbHtml.append("<tr>");
		sbHtml.append("<td>" + to.getEmpno() + "</td>");
		sbHtml.append("<td>" + to.getEname() + "</td>");
		sbHtml.append("<td>" + to.getJob() + "</td>");
		sbHtml.append("<td>" + to.getMgr() + "</td>");
		sbHtml.append("<td>" + to.getHiredate() + "</td>");
		sbHtml.append("<td>" + to.getSal() + "</td>");
		sbHtml.append("<td>" + to.getComm() + "</td>");
		sbHtml.append("<td>" + to.getDeptno() + "</td>");
		sbHtml.append("</tr>");
	}
	sbHtml.append("</table>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
emp_ok.jsp

<%=sbHtml.toString() %>

</body>
</html>