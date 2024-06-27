<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	// param_ok.jsp
	request.setCharacterEncoding("utf-8");
%>
이름 : ${ param.irum }<br />
성적 1 : ${ param.sung }<br />

<c:forEach var="p" items="${ paramValues }">
	<c:forEach var="val" items="${ p.value }">
		${ p.key } : ${ val }<br />
	</c:forEach>
</c:forEach>



