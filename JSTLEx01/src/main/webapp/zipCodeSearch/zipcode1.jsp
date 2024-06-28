<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="./zipcode_ok.jsp" method="post" name="frm">
	<fieldset>
		<legend>우편번호 검색</legend>
		<label for="dong">동이름 입력</label>
		<input type="text" id="dong" name="strdong" size="40" placeholder="동이름 입력" />
		<input type="submit" id="btn" value="우편번호 검색" />
	</fieldset>
</form>
</body>
</html>