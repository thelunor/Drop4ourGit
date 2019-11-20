<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drop 4 Bit</title>
<style>
.about_bottom_content {
	padding-left: 30px;
	padding-right: 30px;
}
</style>
</head>
<body>
	<section id="hello" class="home bg-mega">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="main_home">
					<div class="home_border">
						<div class="home_text">
							<h1 class="text-white">
								맞춤형 집 <br />구하는 기술
							</h1>
							<br>
						</div>
						<div class="input-group">
							<input class="form-control" placeholder="자치구 명으로 검색" type="text">
							<span class="input-group-addon" type="button"><i
								class="fa fa-search"></i></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<br>
	<section>
		<div class="container-fulid">
			<div class="row">
				<div class="about_bottom_content">
					<div class="col-md-6">
						<jsp:include page="../Chart_0.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<!--End off row-->
		</div>
		<!--End off container -->
		<br> <br> <br> <br>
	</section>
	<!--End off About section -->
</body>
</html>