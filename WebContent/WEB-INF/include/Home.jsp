<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drop 4 Bit</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.about_bottom_content {
	padding-left: 80px;
	padding-right: 80px;
}
</style>
</head>
<body>
	<section id="hello" class="home bg-mega">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="main_home">
				<jsp:include page="Search.jsp"></jsp:include>			
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
						<br>
						<jsp:include page="../../Chart_0.jsp"></jsp:include>
						<br> <br> <br>
						<jsp:include page="../../barChart.jsp"></jsp:include>
					</div>
					<div class="col-md-6">
						<br>
						<jsp:include page="../../Chart_1.jsp"></jsp:include>
						<br> <br> <br>
						<p>혜리부분</p>
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