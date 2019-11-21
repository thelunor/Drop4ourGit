<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap"
	rel="stylesheet">
<head>
<meta charset="utf-8">
<title>Drop 4our bit</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="./css/css.jsp"></jsp:include>

<style type="text/css">
.input-group {
	height: 50px;
}

a {
	color: #797979;
}

a:hover {
	color: #212529;
}

h2 {
	font-family: 'Jua', sans-serif;
	text-align: center;
}

input {
	text-align: center;
}
.btn-group:hover {
   background-color: #eee;
   border-color: #eee;
   border: 0.5px solid #eee;
   color: #ff6863;
}

.btn-group {
   color: #fff;
   background-color: #ff6863;
   border-color: #ff6863;
   border: 2px solid #eee;
   padding: 0.5rem 1rem;
}
</style>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">

	<div class="culmn">
		<!--Home page style-->

		<!-- Top jsp -->
		<nav
			class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
			<jsp:include page="WEB-INF/include/REA_Top.jsp"></jsp:include>


			<!-- Side jsp -->
			<jsp:include page="WEB-INF/include/Side.jsp"></jsp:include>
		</nav>
		<!--Join Sections-->

		<section id="id" class="about roomy-100">

			<div class="container">
				<div class="about_content">
					<h2>중개인 마이 페이지</h2>
					<br> <br>
					<div class="row">
						<div class="col-md-6" style="text-align: center">
							<img id="preview" src="images/profile.png" style="width: 200px"
								alt="Profile"> <br> <br> <input type="text"
								class="form-control" name="User_Id" id="User_Id"
								required="required" placeholder="중개인 이름"> <br>
						</div>
						<div class="col-md-6">
							<label>사업자 등록번호 &nbsp;&nbsp;&nbsp;&nbsp;</label> <input
								type="text" class="form-control" name="User_Id" id="User_Id"
								required="required"> <label>사무소 이름
								&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text" class="form-control"
								name="User_Id" id="User_Id" required="required"> <label>연락처
								&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text" class="form-control"
								name="User_Id" id="User_Id" required="required"> <label>사무소
								주소 &nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
								class="form-control" name="User_Id" id="User_Id"
								required="required"> <br>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-12">
							<jsp:include page="WEB-INF/include/TableContract.jsp"></jsp:include>
						</div>
					</div>


				</div>
			</div>

			<!--End off container -->
		</section>


		<!-- scroll up-->
		<jsp:include page="WEB-INF/include/ScrollUp.jsp"></jsp:include>
		<!-- End off scroll up -->
		<jsp:include page="WEB-INF/include/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="./js/js.jsp"></jsp:include>


</body>
</html>