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
			<h1 class="display-5 fw-bold">회원 정보</h1>
			<p class="col-md-8 fs-4">Membership Info</p>
			<!--    
			<h1 class="display-5 fw-bold">회원 가입</h1>
			<p class="col-md-8 fs-4">Membership Joining</p>
          -->    
		</div>
	</div>
	
	<div class="row align-items-md-stretch text-center">
		<h2 class='alert alert-danger'>회원정보가 수정되었습니다.</h2>
		<!--
		<h2 class='alert alert-danger'>회원가입을 축하드립니다.</h2>
		<h2 class='alert alert-danger'>사용자님 환영합니다</h2>
		<h2 class='alert alert-danger'>회원정보가 삭제되었습니다.</h2>
	-->
	</div>
	
	<jsp:include page="./footer.jsp" />
	
</div>
	
</body>
</html>