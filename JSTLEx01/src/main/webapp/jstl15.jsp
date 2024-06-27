<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import var="htmlData" url="https://m.daum.net" charEncoding="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

소스보기 : <br />

<textarea rows="50" cols="800">
${ htmlData }
</textarea>

</body>
</html>
