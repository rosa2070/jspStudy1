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

<table width="800" border="1" cellspacing="0">
<c:forEach var="dan" begin="0" end="9">
	<tr>
	<c:forEach var="col" begin="0" end="9">
		<c:choose>
			<c:when test="${ dan == 0 && col == 0}">
				<td></td>
			</c:when>
			<c:when test="${ dan == 0}">
				<td>X ${ col }</td>
			</c:when>
			<c:when test="${ col == 0 }">
				<td>${ dan } 단</td>
			</c:when>
			<c:otherwise>
					<td>${ dan } X ${ col } = ${ dan * col }</td>
			</c:otherwise>
			
			
		</c:choose>
	</c:forEach>
	</tr>
</c:forEach>
</table>

</body>
</html>