<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 로그인 안됨 => 세션이 없음
	if (session.getAttribute("sid") == null) {
		// 로그인 안됨
		out.println("<script type='text/javascript'>");
		out.println("alert( '로그인 해야합니다');");
		out.println("location.href='login_form.jsp';");
		out.println("</script>");
	} else {
		// 로그인 됨

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 되었습니다.<br /><br />
<a href="logout_ok.jsp">로그아웃</a>
</body>
</html>
<%
	}
%>