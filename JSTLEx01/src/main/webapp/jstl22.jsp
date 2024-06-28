<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>    
    
<%-- <s:setDataSource 
	var="ds" 
	dataSource="jdbc/mariadb1"/>
	
	<s:query var="rs" dataSource="${ ds }">
--%>

<s:query var="rs" dataSource="jdbc/mariadb1">
	select deptno, dname, loc from dept2
</s:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

<table width="800" border="1" cellspacing="0">
<tr>
	<c:forEach var="columnName" items="${ rs.columnNames }">
		<td>${ columnName }</td>
	</c:forEach>
</tr>

<c:forEach var="row" items="${ rs.rows }">
<tr>
	<td>${ row.deptno }</td>
	<td>${ row.dname }</td>
	<td>${ row.loc }</td>
</tr>
</c:forEach>
</table>

</body>
</html>




