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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<jsp:include page="./css/css.jsp"></jsp:include>


<style type="text/css">
h2 {
	font-family: 'Jua', sans-serif;
}

input {
	height: 40px;
}

form-control {
	height: 40px;
}

.genderbox {
	padding: 1px;
	border: 1px solid #cccccc;
	height: 40px;
}

#tdId, #tdEmail, #tdPw, #tdCh {
	font-size: 13px;
	font-family: 'Jua', sans-serif;
	color: #ff6600;
}

.form-group input[type="text"], input[type="email"], input[type="password"]
	{
	border: 1px solid #e5e5e5;
}
</style>

</head>

<body data-spy="scroll" data-target=".navbar-collapse">
	<div class="culmn">
		<!--Home page style-->

		<!-- Top jsp -->
		<nav
			class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
			<jsp:include page="./include/Top.jsp"></jsp:include>

			<!-- Side jsp -->
			<jsp:include page="./include/Side.jsp"></jsp:include>
		</nav>
		<!--Login Sections-->

		<section id="join" class="about roomy-100">
			<form action="Join_ok.jsp" method="post" name="loginForm">
				<div class="container">
					<div class="about_content">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="signup-form">

									<br> <br> <br>
									<h2 style="text-align: center">매물 수정</h2>
									<br>
									<hr>
									<br>
								</div>
							</div>
						</div>
						<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;매물
							사진</label>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">

									<img id="preview" src="images/picture.png" alt="Profile">
									<br> <br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
										type="file" name="filename"><br>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<img id="preview" src="images/picture.png" alt="Profile">
									<br> <br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
										type="file" name="filename"><br>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<img id="preview" src="images/picture.png" alt="Profile">
									<br> <br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
										type="file" name="filename"><br>
								</div>
								<br> <br>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label>매물 주소 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdCh"></span></label>
									<input type="text" class="form-control" name="userPassCheck"
										id="userPassCheck" required="required">
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-4">
											<label>아파트</label> <input type="text" class="form-control"
												name="userPassCheck" id="userPassCheck" required="required">
										</div>
										<div class="col-sm-4">
											<label>동</label> <input type="text" class="form-control"
												name="userPassCheck" id="userPassCheck" required="required"
												placeholder="000동">
										</div>
										<div class="col-sm-4">
											<label>층</label> <input type="text" class="form-control"
												name="userPassCheck" id="userPassCheck" required="required"
												placeholder="0층 / 00층">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label>면적 선택 &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
										class="form-control" style="width: 95%">
										<option value="type1">24평 (전용 59㎡)</option>
										<option value="type2">32평 (전용84.9㎡)</option>
										<option value="type3">42평 (전용 116㎡)</option>
									</select>
								</div>
								<div class="form-group">
									<label>거래 유형 &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
										class="form-control" style="width: 95%">
										<option value="sale">매매</option>
										<option value="type2">전세</option>
									</select>
								</div>
								<div class="form-group">
									<label>거래 금액 (매매가 | 보증금)&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
										type="password" class="form-control" name="User_Pwd"
										id="User_Pwd" required="required" placeholder="0억 0000천 만원">
								</div>

								<div class="form-group">
									<label>향(선택) &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
										class="form-control" style="width: 95%">
										<option value="blank">-</option>
										<option value="type2">남향</option>
										<option value="type2">남동향</option>
										<option value="type2">남서향</option>
										<option value="type2">동향</option>
										<option value="type2">서향</option>
										<option value="type2">북향</option>
										<option value="type2">북동향</option>
										<option value="type2">북서향</option>
									</select>
								</div>
								<div class="form-group">
									<label>간단한 내용 &nbsp;&nbsp;&nbsp;&nbsp;</label>
									<p>
										<textarea cols="70" rows="3" placeholder="매물에 관한 부가적인 내용"></textarea>
									</p>
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-sm-6">
											<button type="submit"
												class="btn btn-primary btn-block btn-lg">Register</button>
										</div>
										<div class="col-sm-6">
											<button type="reset" class="btn btn-primary btn-block btn-lg">Cancel</button>
										</div>
									</div>
								</div>

								<br> <br> <br>
							</div>
						</div>
					</div>
				</div>
				<!--End off row-->

				<!--End off container -->
			</form>
		</section>

		<!-- scroll up-->
		<jsp:include page="./include/ScrollUp.jsp"></jsp:include>
		<!-- End off scroll up -->
		<jsp:include page="./include/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="./js/js.jsp"></jsp:include>


</body>

</html>