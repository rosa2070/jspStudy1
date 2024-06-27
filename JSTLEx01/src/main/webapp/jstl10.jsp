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

<c:set var="hm" value="<%=new java.util.HashMap() %>" />
<c:set target="${ hm }" property="name1" value="홍길동" />
<c:set target="${ hm }" property="name2" value="박문수" />

<c:forEach var="data" items="${ hm }">
	${ data.key } = ${ data.value }<br />
</c:forEach>
</body>
</html>