<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml">
	<c:param name="key" value="f5eef3421c602c6cb7ea224104795888" />
	<c:param name="targetDt" value="20240622" />
</c:url>
<c:import var="xmlData" url="${ url }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

소스보기 : <br />

<textarea rows="50" cols="800">
${ xmlData }
</textarea>

</body>
</html>
