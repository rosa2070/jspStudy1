<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
emp.jsp

<hr />

<form action="./controller" method="post">
	<input type="hidden" name="path" value="emp_ok" />
	사원명 <input type="text" name="ename">
	<input type="submit" value="사원명 검색" />
</form>
</body>
</html>