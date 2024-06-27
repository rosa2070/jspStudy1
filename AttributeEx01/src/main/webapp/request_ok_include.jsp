<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// request_ok_include.jsp
	out.println("request_ok_include.jsp 페이지 호출<br />");
	out.println("data1 : " + request.getParameter("data1") + "<br />");
	out.println("data2 : " + request.getParameter("data2") + "<br />");
	out.println("data3 : " + (String)request.getAttribute("data3") + "<br />");
%>
