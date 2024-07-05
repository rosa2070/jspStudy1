<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.exam.member.model1.MemberDAO"%>
<%@page import="com.exam.member.model1.MemberTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	request.setCharacterEncoding("UTF-8");

	MemberTO to = new MemberTO();
	to.setId(request.getParameter("id"));
	to.setPassword(request.getParameter("password"));
	to.setName(request.getParameter("name"));
	to.setGender(request.getParameter("gender"));
	to.setBirth(request.getParameter("birthyy") + "-" + request.getParameter("birthmm") + "-" + request.getParameter("birthdd"));
	to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
	to.setPhone(request.getParameter("phone"));
	to.setAddress(request.getParameter("address"));
	
	LocalDateTime currentDateTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDateTime = currentDateTime.format(formatter);
	
	to.setRegistDay(formattedDateTime);
	
	MemberDAO dao = new MemberDAO();
	int flag = dao.addMember(to);
	
	if (flag == 0) {
		response.sendRedirect("resultMember.jsp?msg=1");
	}
%>

