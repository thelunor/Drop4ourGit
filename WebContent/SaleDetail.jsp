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
h2, h4, h6, h3{
	font-family: 'Jua', sans-serif;
}
/*
Featured section style
========================*/
.main_featured .head_title {
	width: 70%;
	margin: 0 auto;
}

.slick-center .featured_img {
	position: relative;
}

.slick-center .featured_img:before {
	content: "+";
	width: 50px;
	height: 50px;
	line-height: 50px;
	position: absolute;
	left: 43.5%;
	right: 43.5%;
	top: 35%;
	color: #000;
	background-color: #fff;
	border-radius: 50%;
	font-size: 3rem;
	z-index: 2;
	cursor: pointer;
}

.slick-center .featured_img a {
	position: absolute;
	left: 43.5%;
	right: 43.5%;
	top: 35%;
	display: block;
	width: 50px;
	height: 50px;
	z-index: 3;
}

.featured_img a {
	display: none;
}

.featured_slider {
	width: 100%;
	height: 250px;
	margin: 20px auto;
	text-align: center;
}

.featured_img img {
	width: 100%;
	height: 100%;
}

.featured_slider div {
	margin-right: 5px;
}

.slick-slide {
	opacity: .6;
}

.slick-center {
	display: block;
	max-width: 10% !important;
	max-height: 20% !important;
	opacity: 1;
}

a.btn :hover {
   background-color: #eee;
   border-color: #eee;
   border: 0.5px solid #eee;
   color: #ff6863;
}

a.btn  {
   color: #fff;
   background-color: #ff6863;
   border-color: #ff6863;
   border: 2px solid #eee;
   padding: 1rem 1rem;
   float : right;
}

.page-wrapper {
  width: 100%;
  height: 100%;
  background-size: cover;
}

.blur-it {
  filter: blur(4px);
}

.modal-wrapper {
  width: 100%;
  height: 100%;
  position: fixed;
  background: 	rgb(242, 242, 242, 0.5);  
  top: 0; 
  left: 0;
  visibility: hidden;
  Z-index: 1;

}

.modal-wrapper.open {
  opacity: 1;
  visibility: visible;
}

.modal {
  width: 400px;
  height: 600px;
  display: block;
  position: relative;
  top: 40%; 
  left: 50%;
  background: #fff;
  opacity: 0;
  transition: all 0.5s ease-in-out;
}

.modal-wrapper.open .modal {
  margin-top: -200px;
  opacity: 1;
}

.head { 
  width: 100%;
  height: 50px;
  padding: 10px;
  overflow: hidden;
  background: #ff6863;
}

.btn-close {
  font-size: 28px;
  display: block;
  float: right;
  color: #fff;
}

.content {
  padding: 10%;
}

</style>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">

	<div class="culmn">
		<!--Home page style-->

		<!-- Top jsp -->
		<nav
			class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
			<jsp:include page="./common/Top.jsp"></jsp:include>

			<!-- Side jsp -->
			<jsp:include page="./common/Side.jsp"></jsp:include>
		</nav>
		<!--Detail Sections-->
		<div class="container-fluid">
			<div class="main_featured m-top-100">
				<h2 style="text-align: center;">매물 상세 페이지</h2>
				<br>
			</div>

			<div class="featured_slider">
				<div>
					<div class="featured_img">
						<img src="./images/house.jpg" alt="" /> <a
							href="./images/house.jpg" class="popup-img"></a>
					</div>
				</div>
				<div>
					<div class="featured_img">
						<img src="./images/house1.jpg" alt="" /> <a
							href="./images/house1.jpg" class="popup-img"></a>
					</div>
				</div>
				<div>
					<div class="featured_img">
						<img src="./images/house2.jpg" alt="" /> <a
							href="./images/house2.jpg" class="popup-img"></a>
					</div>
				</div>
				<div>
					<div class="featured_img">
						<img src="./images/house1.jpg" alt="" /> <a
							href="./images/house1.jpg" class="popup-img"></a>
					</div>
				</div>
			</div>
			</div>
			<div class="container">
			<br> <br> <br> <br>
			<div class="row">
				<div class="col-md-12">
				<div class="houseDetail">
					<div class="page-wrapper">
					  <a class="btn trigger" href="#">Real Estate Agent</a>
					</div>
					<h4 style="color:#ff6863;"><i class="fas fa-home"></i>&nbsp;역삼래미안 아파트</h4> 										
					<input type="text" class="form-control" name="userPassCheck"
						id="userPassCheck" required="required" placeholder="도로명 주소">
						<br>
					<!-- Button -->
					<p style="font-size: 20px; font-family: 'Jua', sans-serif;">방
						4개 &nbsp;|&nbsp; 욕실 1개 &nbsp;|&nbsp; 화장실 1개 &nbsp;|&nbsp; 드레스룸 1개</p>
					<br>
					<div class="box">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>면적 </label> <input type="password" class="form-control"
										required="required" placeholder="면적">
								</div>
								<div class="form-group">
									<label>유형 </label> <input type="password" class="form-control"
										required="required" placeholder="매매 / 전세">
								</div>
								<div class="form-group">
									<label>방향 </label> <input type="password" class="form-control"
										required="required" placeholder="방향">
								</div>								
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>매매가 </label> <input type="password" class="form-control"
										required="required" placeholder="매매가">
								</div>
								<div class="form-group">
									<label>보증금 </label> <input type="password" class="form-control"
										required="required" placeholder="보증금">
								</div>
								<div class="form-group">
									<label>특징 </label> <input type="password" class="form-control"
										required="required" placeholder="특징">
								</div>																
							</div>
						</div>
					</div>
					<br>
					<p style="font-size: 15px; font-family: 'Jua', sans-serif;"><i class="fas fa-subway"></i> 5분 거리 &nbsp; &nbsp;| &nbsp; &nbsp;
					<i class="fas fa-school"></i> 10분 거리 &nbsp; &nbsp;| &nbsp; &nbsp; <i class="fas fa-tree"></i> 5분 거리 </p>
				 <div id="map" style="width: 90%; height: 300px;"></div>	
				 <br> <br> <br> <br>				 					
				</div>
				</div>
			</div>
		</div>
		<!-- End off featured slider -->
		
<!-- Modal -->						
<div class="modal-wrapper">
  <div class="modal">
    <div class="head">
      <a class="btn-close trigger" href="#">
        <i class="fa fa-times" aria-hidden="true"></i>
      </a>
    </div>
    <div class="content">
				<div class="information">
				<br>
				<h3 style="text-align: center;">로얄 부동산</h3>
				<br>
                 <div class="form-group" style="text-align : center">
                    <img id="preview" src="./images/profile.png" style="width:150px" alt="Profile">
                 </div>		
				<br>
				<a href="#" data-toggle="tooltip" title="010-1234-1234" style="float:right; color:#ff6863;">전화번호 &nbsp;&nbsp;&nbsp; &nbsp;</a>
				<br><br>
				<div class="form-group">
					<label>사무소 주소 </label> <input type="text" class="form-control"
						required="required" placeholder="주소">
				</div>
				<br>			
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block btn-lg">Click</button>
				</div>					
				</div>
    </div>
  </div>
</div>

		<!-- scroll up-->
		<div class="scrollup">
			<a href="#"><i class="fa fa-chevron-up"></i></a>
		</div>
		<!-- End off scroll up -->
		<jsp:include page="./common/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="./js/js.jsp"></jsp:include>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
   center : new kakao.maps.LatLng(37.497520, 127.049972), // 지도의 중심좌표
   level : 1
// 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition = new kakao.maps.LatLng(37.497520, 127.049972);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
   position : markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);

$( document ).ready(function() {
	  $('.trigger').on('click', function() {
	     $('.modal-wrapper').toggleClass('open');
	    $('.page-wrapper').toggleClass('blur-it');
	     return false;
	  });
	  $('[data-toggle="tooltip"]').tooltip(); 
	});
</script>	
</body>
</html>