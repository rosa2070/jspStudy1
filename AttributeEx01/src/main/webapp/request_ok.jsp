<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// request_ok.jsp
	request.setCharacterEncoding("utf-8");

	String data1 = request.getParameter("data1");
	out.println(data1 + "<br />");
	
	out.println("시작<br />");
	
	request.setAttribute("data3", "value3");
%>
<!-- include -->
<jsp:include page="request_ok_include.jsp">
	<jsp:param name="data2" value="value2" />
</jsp:include>
<%
	out.println("끝<br />");
%>