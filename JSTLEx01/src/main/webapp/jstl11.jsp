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

<!--  header : 전송에 포함 사항(클라이언트 아이피, 서버이름 ..) -->

<c:forEach var="h" items="${ headerValues }">
	<c:forEach var="val" items="${ h.value }">
		param : ${ h.key } / values ; ${ val }<br />
	</c:forEach>
</c:forEach>
</body>
</html>