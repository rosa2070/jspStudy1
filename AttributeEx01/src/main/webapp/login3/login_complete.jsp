<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();

	int flag = 1;
	if (cookies != null && cookies.length > 0) {
		for (int i=0; i<cookies.length; i++) {
			if ( cookies[i].getName().equals("cid")) {
				flag = 0;
				break;
			}
		}
	}
	if (flag == 1) {
		out.println("<script type='text/javascript'>");
		out.println("alert( '로그인 해야합니다');");
		out.println("location.href='login_form.jsp';");
		out.println("</script>");
		
	} else {
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