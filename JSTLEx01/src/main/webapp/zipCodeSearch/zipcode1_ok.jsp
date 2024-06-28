<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<s:setDataSource
	var="ds"
	dataSource="jdbc/mariadb1"
	scope="page" />
	
<s:query var="rs" dataSource="${ ds }">
	select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?
	<s:param value="${param.strdong }%" />
</s:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="1000" border="1" cellspacing="0">
<tr>
	<c:forEach var="columnName" items="${ rs.columnNames }">
		<td>${ columnName }</td>
	</c:forEach>
</tr>

<c:forEach var="row" items="${ rs.rows }">
	<tr>
		<td>${ row.zipcode }</td>
		<td>${ row.sido }</td>
		<td>${ row.gugun }</td>
		<td>${ row.dong }</td>
		<td>${ row.ri }</td>
		<td>${ row.bunji }</td>
	</tr>
</c:forEach>
</table>

</body>
</html>