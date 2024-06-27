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

<!--  core 제어문 -->
<c:set var="country" value="canada" scope="page" />
<c:choose>
	<c:when test="${ country == 'korea' }">
		<c:out value="${ country }" />는 춥다
	</c:when>
	<c:when test="${ country == 'canada' }">
		<c:out value="${ country }" />는 더 춥다
	</c:when>
	<c:otherwise>
		겨울에 안춥다
	</c:otherwise>
	
</c:choose>

</body>
</html>