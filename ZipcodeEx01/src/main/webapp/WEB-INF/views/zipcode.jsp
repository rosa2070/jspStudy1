<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
zipcode.jsp

<hr/>

<form action="./controller" method="post">
    <input type="hidden" name="path" value="zipcode_ok" />
    동이름 <input type="text" name="strDong" />
    <input type="submit" value="동이름 검색" />
</form>
</body>
</html>
