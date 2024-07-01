<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  index.jsp--%>
<a href="./controller">view1</a><br/>
<a href="./controller?path=view1">view1</a><br/>
<a href="./controller?path=view2">view2</a><br/>

<hr/>

<form action="./controller" method="get">
    <input type="hidden" name="path" value="view1">
    데이터 <input type="text" name="data" />
    <input type="submit" value="내용 전송">
</form>

<form action="./controller" method="get">
    <input type="hidden" name="path" value="view2">
    데이터 <input type="text" name="data" />
    <input type="submit" value="내용 전송">
</form>
</body>
</html>
