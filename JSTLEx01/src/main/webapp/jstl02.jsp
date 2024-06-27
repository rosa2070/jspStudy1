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

<c:set var="name1" value="홍길동"></c:set>
<c:set var="name2">박문수</c:set>
출력 : ${name1 }<br />
출력 : <c:out value="${name2}"></c:out><br />
출력 : <c:out value="name2"></c:out><br />
</body>
</html>