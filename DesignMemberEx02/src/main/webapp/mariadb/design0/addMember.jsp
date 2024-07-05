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
			<h1 class="display-5 fw-bold">회원 가입</h1>
			<p class="col-md-8 fs-4">Membership Joining</p>      
		</div>
	</div>
	
	<div class="container">
		<form action="" method="post" name="wfrm">
			<div class="mb-3 row">
				<label class="col-sm-2 ">아이디</label>
				<div class="col-sm-3">
					<input type="text" name="id" class="form-control" placeholder="id" />
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">비밀번호</label>
				<div class="col-sm-3">
					<input type="password" name="password" class="form-control" placeholder="password" />
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">비밀번호확인</label>
				<div class="col-sm-3">
					<input type="password" name="password_confirm" class="form-control" placeholder="password confirm" />
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">이름</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control" placeholder="name" />
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-10">
					<input type="radio" name="gender" value="남" checked /> 남 
					<input type="radio" name="gender" value="여" /> 여
				</div>
			</div>
			
			<div class="mb-3 row">
				<label class="col-sm-2">생일</label>
				<div class="col-sm-10">
					<div class="row">
						<div class="col-sm-2">
							<input type="text" name="birthyy" size="6" maxlength="4" class="form-control" placeholder="년(4자)" /> 
						</div>
						<div class="col-sm-2">
							<select name="birthmm" class="form-select">
								<option value="">월</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select> 
						</div>
						<div class="col-sm-2">
							<input type="text" name="birthdd" size="4" maxlength="2" class="form-control" placeholder="일" />
						</div>
					</div>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2">이메일</label>
				<div class="col-sm-10">
					<div class="row">
						<div class="col-sm-4">
							<input type="text" name="mail1" maxlength="50" class="form-control" placeholder="email" />
						</div> @
						<div class="col-sm-3">
							<select name="mail2" class="form-select">
								<option selected>naver.com</option>
								<option>daum.net</option>
								<option>gmail.com</option>
								<option>nate.com</option>
							</select>
						</div>
					</div>
				</div>		
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">전화번호</label>
				<div class="col-sm-3">
					<input type="text" name="phone" class="form-control" placeholder="phone" />
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">주소</label>
				<div class="col-sm-5">
					<input type="text" name="address" class="form-control" placeholder="address" />
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 text-center">
					<input type="submit" value="회원등록" class="btn btn-primary" /> 
					<input type="reset" value="등록취소" class="btn btn-primary" />
				</div>
			</div>
		</form>
	</div>

   <jsp:include page="./footer.jsp" />

</div>	

</body>
</html>