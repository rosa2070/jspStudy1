<%@page import="com.exam.member.model1.MemberDAO"%>
<%@page import="com.exam.member.model1.MemberTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDAO dao = new MemberDAO();
	
%>

    