<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<head>
	<meta charset="UTF-8">
	<title>관리자 소개 페이지</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- CSS style -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
	<jsp:include page="css/css.jsp" />
	
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
		
		h1, h3 {
		font-family: 'Jua', sans-serif;
		text-align: center;
		}
		
		.clearfix:after {
			content: '';
			display: block;
			clear: both;
			float: none;
		}
		
		/* ======== Calendar ======== */
		.my-calendar {
			width: 700px;
			margin: 30px;
			padding: 20px 20px 10px;
			text-align: center;
			font-weight: 800;
			border: 1px solid #ddd;
			cursor: default;
		}
		
		.my-calendar .clicked-date {
			border-radius: 25px;
			margin-top: 36px;
			float: left;
			width: 42%;
			padding: 46px 0 26px;
			background: #ddd;
		}
		
		.my-calendar .calendar-box {
			float: right;
			width: 58%;
			padding-left: 30px;
		}
		
		.clicked-date .cal-day {
			font-size: 24px;
		}
		
		.clicked-date .cal-date {
			font-size: 130px;
		}
		
		.ctr-box {
			padding: 0 16px;
			margin-bottom: 20px;
			font-size: 20px;
		}
		
		.ctr-box .btn-cal {
			position: relative;
			float: left;
			width: 25px;
			height: 25px;
			margin-top: 5px;
			font-size: 16px;
			cursor: pointer;
			border: none;
			background: none;
		}
		
		.ctr-box .btn-cal:after {
			content: '<';
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			line-height: 25px;
			font-weight: bold;
			font-size: 20px;
		}
		
		.ctr-box .btn-cal.next {
			float: right;
		}
		
		.ctr-box .btn-cal.next:after {
			content: '>';
		}
		
		.cal-table {
			width: 100%;
		}
		
		.cal-table th {
			width: 14.2857%;
			padding-bottom: 5px;
			font-size: 16px;
			font-weight: 900;
		}
		
		.cal-table td {
			padding: 3px 0;
			height: 50px;
			font-size: 15px;
			vertical-align: middle;
		}
		
		.cal-table td.day {
			position: relative;
			cursor: pointer;
		}
		
		.cal-table td.today {
			background: #ff6863;
			border-radius: 50%;
			color: #fff;
		}
		
		.cal-table td.day-active {
			background: #ffd255;
			border-radius: 50%;
			color: #fff;
		}
		
		.timeline {
			list-style: none;
			padding: 20px 0 20px;
			position: relative;
		}
		
		.timeline:before {
			top: 0;
			bottom: 0;
			position: absolute;
			content: " ";
			width: 3px;
			background-color: #eeeeee;
			left: 50%;
			margin-left: -1.5px;
		}
		
		.timeline>li {
			margin-bottom: 20px;
			position: relative;
		}
		
		.timeline>li:before, .timeline>li:after {
			content: " ";
			display: table;
		}
		
		.timeline>li:after {
			clear: both;
		}
		
		.timeline>li:before, .timeline>li:after {
			content: " ";
			display: table;
		}
		
		.timeline>li:after {
			clear: both;
		}
		
		.timeline>li>.timeline-panel {
			width: 46%;
			float: left;
			border: 1px solid #d4d4d4;
			border-radius: 2px;
			padding: 20px;
			position: relative;
			-webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
			box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
		}
		
		.timeline>li>.timeline-panel:before {
			position: absolute;
			top: 26px;
			right: -15px;
			display: inline-block;
			border-top: 15px solid transparent;
			border-left: 15px solid #ccc;
			border-right: 0 solid #ccc;
			border-bottom: 15px solid transparent;
			content: " ";
		}
		
		.timeline>li>.timeline-panel:after {
			position: absolute;
			top: 27px;
			right: -14px;
			display: inline-block;
			border-top: 14px solid transparent;
			border-left: 14px solid #fff;
			border-right: 0 solid #fff;
			border-bottom: 14px solid transparent;
			content: " ";
		}
		
		.timeline>li>.timeline-badge {
			color: #fff;
			width: 50px;
			height: 50px;
			line-height: 50px;
			font-size: 1.4em;
			text-align: center;
			position: absolute;
			top: 16px;
			left: 50%;
			margin-left: -25px;
			background-color: #999999;
			z-index: 100;
			border-top-right-radius: 50%;
			border-top-left-radius: 50%;
			border-bottom-right-radius: 50%;
			border-bottom-left-radius: 50%;
		}
		
		.timeline>li.timeline-inverted>.timeline-panel {
			float: right;
		}
		
		.timeline>li.timeline-inverted>.timeline-panel:before {
			border-left-width: 0;
			border-right-width: 15px;
			left: -15px;
			right: auto;
		}
		
		.timeline>li.timeline-inverted>.timeline-panel:after {
			border-left-width: 0;
			border-right-width: 14px;
			left: -14px;
			right: auto;
		}
		
		.timeline-badge.primary {
			background-color: #2e6da4 !important;
		}
		
		.timeline-badge.success {
			background-color: #3f903f !important;
		}
		
		.timeline-badge.warning {
			background-color: #f0ad4e !important;
		}
		
		.timeline-badge.danger {
			background-color: #d9534f !important;
		}
		
		.timeline-badge.info {
			background-color: #5bc0de !important;
		}
		
		.timeline-title {
			margin-top: 0;
			color: inherit;
		}
		
		.timeline-body>p, .timeline-body>ul {
			margin-bottom: 0;
		}
		
		.timeline-body>p+p {
			margin-top: 5px;
		}
		
		@media ( max-width : 767px) {
			ul.timeline:before {
				left: 40px;
			}
			ul.timeline>li>.timeline-panel {
				width: calc(100% - 90px);
				width: -moz-calc(100% - 90px);
				width: -webkit-calc(100% - 90px);
			}
			ul.timeline>li>.timeline-badge {
				left: 15px;
				margin-left: 0;
				top: 16px;
			}
			ul.timeline>li>.timeline-panel {
				float: right;
			}
			ul.timeline>li>.timeline-panel:before {
				border-left-width: 0;
				border-right-width: 15px;
				left: -15px;
				right: auto;
			}
			ul.timeline>li>.timeline-panel:after {
				border-left-width: 0;
				border-right-width: 14px;
				left: -14px;
				right: auto;
			}
		}
	</style>
	
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
	<div class="culmn">
		<!--Home page style-->

		<nav class="navbar navbar-light navbar-expand-lg navbar-fixed ivory no-background bootsnav">
		<!-- Top jsp -->
			<jsp:include page="WEB-INF/include/Admin_top.jsp" />

		<!-- Side jsp -->
			<jsp:include page="WEB-INF/include/Side.jsp" />
		</nav>
		<!-- Container -->
		<section id="join" class="about roomy-100">
			<form action="addInfo.d4b" method="post" name="JoinForm" enctype="multipart/form-data">
				<div class="container">
					<div class="about_content">
						<div class="row">
							<!-- Left -->
							<div class="col-md-3" style="border: 1px solid rgb(211, 211, 211); padding-top: 15px; padding-bottom: 15px; height: 500px; width: 200px; position: fixed;">
								<div class="signup-form">
									<div class="form-group" style="text-align : center">
										<img id="preview" src="./images/profile.png" style="width:200px" alt="Profile">
									</div>
								</div>
								<div style="margin-top: 10px; margin-bottom: 10px;">
									<hr>
								</div>
								<div>
									두번째 소개
								</div>
								<div style="margin-top: 10px; margin-bottom: 10px;">
									<hr>
								</div>
								<div>
									세번째 소개
								</div>
							</div>
							<!-- Left End -->
							
							<!-- Right -->
							<div class="col-md-9" style="margin-left: 240px;">
								<div style="margin-left: 80px;">
									<!-- 첫 소개 글머리 -->
									<div>
										<section>
											<div style="margin-bottom: 32px;">
												<div>
													<div>
														<h4>
															안녕하세요. 비트 부동산에 오신 것을 환영합니다.
														</h4>
													</div>
													<div style="margin-top: 8px;">
														회원가입: 2018.
													</div>
												</div>
											</div>
										</section>
									</div>
									
									<!-- 두 번째 소개 -->
									<div>
										<section>
											<div style="width: 40px; height: 40px; margin-top: 10px; margin-bottom: 10px;">
												<img alt="house" src="./images/house.png">
											</div>
											<div>
												서울 강남구 비트부동산 010-1234-5678
											</div>
										</section>
										<div style="margin-top: 20px; margin-bottom: 20px;">
											<hr>
										</div>
									</div>
									
									<!-- 세 번째 매물 -->
									<div>
										<section>
											<div class="container-fluid">
												<div class="col-lg-12 text-center" style="background-color: #cccccc;">
													<div id="myCarousel" class="carousel slide" data-ride="carousel">
														<!-- Indicators -->
														<ul class="carousel-indicators">
															<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
															<li data-target="#myCarousel" data-slide-to="1"></li>
															<li data-target="#myCarousel" data-slide-to="2"></li>
														</ul>
														
														<!-- Slideshow -->
														<div class="carousel-inner">
															<div class="carousel-item active">
																<img src="images/84a.jpg" width="100%">
																<h5>1111</h5>
																<br>
															</div>
															<div class="carousel-item">
																<img src="images/84a.jpg" width="100%">
																<h5>2222</h5>
																<br>
															</div>
															<div class="carousel-item">
																<img src="images/84a.jpg" width="100%">
																<h5>3333</h5>
																<br>
															</div>
														</div>
														
														<!-- Left and right controls -->
														<a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
															<span class="carousel-control-prev-icon"></span>
														</a>
														<a class="carousel-control-next" href="#myCarousel" data-slide="next">
															<span class="carousel-control-next-icon"></span>
														</a>
													</div>
												</div>
											</div>
										</section>
										<div style="margin-top: 20px; margin-bottom: 20px;">
											<hr>
										</div>
									</div>
									
									<!-- 네 번째 후기 -->
									<div>
										<section>
											<h4><div>후기</div></h4>
											<div role="tablist">
												<div>
													<h6>계약을 완료한 분들의 후기</h6>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 김김김
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 이이이
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 박박박
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 김김김
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 이이이
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 박박박
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 김김김
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 이이이
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 박박박
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 김김김
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 이이이
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<div>
													<div style="margin-top: 24px; margin-bottom: 24px;">
														<span>2019.01.01.</span>
														<div style="float: right;">
															작성자: 박박박
														</div>
													</div>
													<div style="margin-top: 12px;">
														<div>
															방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요. 그리고 수건도 챙겨가세요 일회용컵도 챙겨가세요 엄청 모기가 엄청 많네요..
														</div>
													</div>
												</div>
												<div style="margin-top: 20px; margin-bottom: 20px;">
													<hr>
												</div>
												<!--이전 링크 -->
												<c:if test="${cpage>1}">
													<a href="board_list.jsp?cp=${cpage-1}&ps=${pagesize}">이전</a>
												</c:if> 
												<!--페이지 리스트 구현  -->
												<c:forEach var="i" begin="1" end="${pagecount}" step="1">
													<c:choose>
														<c:when test="${cpage==i}">
															<font color='red'>[${i}]</font>
														</c:when>
														<c:otherwise>
															<a href="board_list.jsp?cp=${i}&ps=${pagesize}">[${i}]</a>
														</c:otherwise>
													</c:choose>
												</c:forEach> <!--다음 링크 --> <c:if test="${cpage<pagecount}">
													<a href="board_list.jsp?cp=${cpage+1}&ps=${pagesize}">다음</a>
												</c:if>
											</div>
										</section>
									</div>
								</div>
							</div>
							<!-- Right End -->
							
						</div>
					</div>
				</div>
			</form>
		</section>
		<!-- scroll up-->
		<div class="scrollup">
			<a href="#"><i class="fa fa-chevron-up"></i></a>
		</div>
		<!-- End off scroll up -->
		<jsp:include page="WEB-INF/include/Bottom.jsp" />
	</div>
	
	<!-- JS includes -->
	<jsp:include page="js/js.jsp" />
</body>
</html>