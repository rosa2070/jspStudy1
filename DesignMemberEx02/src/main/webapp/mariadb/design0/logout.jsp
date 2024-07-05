<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
</head>
<body>
<div class="container py-4">
	
	<jsp:include page="./menu.jsp" />  

	<div class="p-5 mb-4 bg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">회원 아웃</h1>
			<p class="col-md-8 fs-4">Membership Logout</p>      
		</div>
	</div>
	
	<div class="container" align="center">
		<div class="col-md-4 col-md-offset-4">
			<h3 class="form-signin-heading">로그아웃해 주세요</h3>
		</div>
	</div>

   <jsp:include page="./footer.jsp" />

</div>	

</body>
</html>