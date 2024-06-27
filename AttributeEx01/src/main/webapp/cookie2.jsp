<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//cookie2.jsp
	Cookie[] cookies = request.getCookies();
	// 1 - session id
	out.println(cookies.length + "<br />");
	
	if (cookies != null && cookies.length > 0) {
		for (int i = 0; i<cookies.length; i++) {
			out.println(cookies[i].getName() + "<br />");
			out.println(cookies[i].getValue() + "<br />");
		}
	}
%>
