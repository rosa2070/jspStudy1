<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	String saveId = "tester";
	String savePassword = "1234";
	
	int flag = 2;
	if (saveId.equals(id) && savePassword.equals(password)) {
		flag = 0;
		
		Cookie cookie1 = new Cookie("cid", id);
		Cookie cookie2 = new Cookie("cgrade", "B");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	} else {
		flag = 1;
	}
	
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('로그인 되었습니다.')");
		out.println("location.href='login_complete.jsp';");
	} else if (flag == 1) {
		out.println("alert('아이디, 비밀번호 오류.');");
		out.println("history.back();");
	} else {
		out.println("alert('기타 에러.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>