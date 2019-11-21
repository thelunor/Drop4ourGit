<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Drop 4our bit</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=668464eb0d779bb6eecda046a974a34b"></script>
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

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
}

@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
		/* Hide the carousel text when the screen is less than 600 pixels wide */
	}
}

.carousel-control.right, .carousel-control.left {
	background-image: none;
	color: #fff;
}

.carousel-indicators li {
	border-color: #ff;
}

.carousel-indicators li.active {
	background-color: #fff;
}

ol, ul {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	vertical-align: baseline;
	text-decoration: none;
	list-style: none;
	font-weight: bold;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

</style>
</head>
<jsp:include page="./css/css.jsp"></jsp:include>

<body data-spy="scroll" data-target=".navbar-collapse">

	<div class="culmn">
		<!--Home page style-->

		<!-- Top jsp -->
		<nav
			class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
			<jsp:include page="WEB-INF/include/Top.jsp"></jsp:include>
			<!-- Side jsp -->
			<jsp:include page="WEB-INF/include/Side.jsp"></jsp:include>
		</nav>
		<!--Join Sections-->
		<section id="id" class="about roomy-100">
			<div class="container">
				<div class="about_content">
					<h1 style="font-family: 'Jua', sans-serif; text-align: center;">매물
						리스트</h1>
					<br> <br>
					<div class="row">
						<div class="col-md-8">
							<div class="input-group">
								<form action="1Detail2.jsp" method="post">
									<input type="text" placeholder="법정동 검색" id="member_search"
										name="member_search" style="width: 200px; height: 50px;">
								</form>
								<div class="input-group-append ">
									<button type="submit" class="btn btn-primary btn-block btn-lg">검색</button>
								</div>
							</div>
							<br>
						</div>
					</div>
					<jsp:include page="Topic.jsp"></jsp:include>
					<br>
					<div class="row">
						<div class="col-md-12">
							<jsp:include page="WEB-INF/include/HouseList.jsp"></jsp:include>
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