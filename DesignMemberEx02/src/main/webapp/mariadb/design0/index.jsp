<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="../../css/bootstrap.min.css" />
</head>
<body>
<div class="container py-4">

	<jsp:include page="./menu.jsp" />

	<div class="p-5 mb-4 bg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">도서 쇼핑몰에 오신 것을 환영합니다</h1>
			<p class="col-md-8 fs-4">BookMarket</p>      
		</div>
	</div>

	<div class="container">
		<div class="col-md-12 text-center">
			<div class="h-100 p-5">
				<h3>Welcome to Web Market!</h3>
				현재 접속 시각 : 10:30:20 오전          
			</div>
		</div>   
	</div>
	
	<jsp:include page="./footer.jsp" />
	
</div>

</body>
</html>
  