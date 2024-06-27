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

<c:set var="name0" value="홍길동"></c:set>
<c:set var="name1" value="홍길동" scope="page"></c:set>
<!--  pageContext.setAttribute("name1", "홍길동") -->
<c:set var="name2" value="박문수" scope="request"></c:set>
<!--  request.setAttribute("name2", "박문수") -->
<c:set var="name3" value="임꺽정" scope="session"></c:set>
<c:set var="name4" value="장길산" scope="application"></c:set>

출력 : <c:out value="${ pageScope.name0 }"></c:out><br />
출력 : <c:out value="${ pageScope.name1 }"></c:out><br />
출력 : <c:out value="${ requestScope.name2 }"></c:out><br />
출력 : <c:out value="${name3 }"></c:out><br />
출력 : <c:out value="${name4 }"></c:out><br />

</body>
</html>