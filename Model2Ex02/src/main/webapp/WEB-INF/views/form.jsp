<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

form.jsp<br />

<form action="./controller" method ="post">
    <input type="hidden" name="path" value = "form_ok">
    데이터<input type="text" name="data" >
    <input type="submit" value="내용전송" >
</form>
</body>
</html>