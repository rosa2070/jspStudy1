<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 출력 -->
출력 : <%="홍길동" %><br />

출력 : ${"홍길동"}<br />
출력 : <c:out value="홍길동" /><br />

<%
	pageContext.setAttribute("name1", "박문수");
%>
출력 : ${ name1 }<br />
출력 : <c:out value="${name1 }" /><br />
출력 : <c:out value="${name2 }" default="임꺽정" /><br />
</body>
</html>