<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
upload.jsp

<hr />

<form action="upload_ok.jsp" method="post" enctype="multipart/form-data">
첨부파일:<input type="file" name="upload" />
<input type="submit" value="파일 업로드" />
</form>

</body>
</html>