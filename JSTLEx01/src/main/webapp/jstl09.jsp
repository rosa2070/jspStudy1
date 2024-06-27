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

<c:set var="intArr" value="<%= new int[]{1, 2, 3, 4, 5} %>"></c:set>
<c:out value="${ intArr[0] }"/><br />
<c:out value="${ intArr[1] }"/><br />
<c:out value="${ intArr[9] }"/><br />

<hr />

<c:forEach var="data" items="${ intArr }" begin="2" end="4">
	<c:out value="${ data }" /><br />
</c:forEach>

<c:set var="strArr" value='<%= new String[]{"aa", "bb", "cc", "dd", "ee"} %>'/>
<c:forEach var="data" items="${ strArr }" begin="2" end="4">
	<c:out value="${ data }" /><br />
</c:forEach>

</body>
</html>