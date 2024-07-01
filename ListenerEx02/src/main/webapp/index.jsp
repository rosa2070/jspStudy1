<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ServletContext context = getServletContext();

	context.setAttribute("name", "홍길동");
	out.println( "추가 완료<br />" );
	out.println( "context : " + context.getAttribute("name") + "<br />");
	
	context.setAttribute("name", "박문수");
	out.println( "수정 완료<br />" );
	out.println( "context : " + context.getAttribute("name") + "<br />");
	
	context.removeAttribute("name");
	out.println( "삭제 완료<br />" );
	out.println( "context : " + context.getAttribute("name") + "<br />");
	
	
%>
</body>
</html>