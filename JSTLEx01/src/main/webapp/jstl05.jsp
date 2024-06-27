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
시작<br />

<c:if test="false">
	무조건 실행<br />
</c:if>

끝 <br />

<c:set var="country" value="korea" scope="page" />
<c:if test="${ country == 'korea' }">
	대한민국 입니다 <br />
</c:if>

</body>
</html>