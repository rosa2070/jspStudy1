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
<!-- 반복문 -->
<c:forEach var="i" begin="1" end="5" step="2">
	Hello JSTL : ${ i }<br />
</c:forEach>

</body>
</html>