<%@page import="kr.or.bit.dto.Sale"%>
<%@page import="java.util.List"%>
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
<script>
$.noConflict();

jQuery( document ).ready(function( $ ) {//화면 다 뜨면 시작
		var searchSource = [ "종로구 사직동", "종로구 당주동", "종로구 내수동", "종로구 인의동", "종로구 명륜1가", "종로구 창신동", "종로구 숭인동", "종로구 평동",
							 "종로구 홍파동", "종로구 평창동", "종로구 신영동", "종로구 무악동", "중구 회현동1가", "중구 충무로4가", "중구 인현동2가", "중구 신당동",
							 "중구 황학동", "중구 순화동", "중구 중림동", "용산구 후암동", "용산구 동자동", "용산구 원효로1가", "용산구 원효로4가", "용산구 효창동",
							 "용산구 도원동", "용산구 용문동", "용산구 문배동", "용산구 신계동", "용산구 한강로1가", "용산구 한강로2가", "용산구 용산동5가", "용산구 한강로3가",
							 "용산구 이촌동", "용산구 이태원동", "용산구 한남동", "용산구 서빙고동", "용산구 보광동", "성동구 상왕십리동", "성동구 하왕십리동", "성동구 홍익동",
							 "성동구 마장동", "성동구 행당동", "성동구 응봉동", "성동구 금호동1가", "성동구 금호동2가", "성동구 금호동3가", "성동구 금호동4가", "성동구 옥수동",
							 "성동구 성수동1가", "성동구 성수동2가", "광진구 중곡동", "광진구 구의동", "광진구 광장동", "광진구 자양동", "광진구 군자동", "동대문구 신설동",
							 "동대문구 용두동", "동대문구 제기동", "동대문구 전농동", "동대문구 답십리동", "동대문구 장안동", "동대문구 청량리동", "동대문구 회기동", "동대문구 휘경동",
							 "동대문구 이문동", "중랑구 면목동", "중랑구 상봉동", "중랑구 중화동", "중랑구 묵동", "중랑구 망우동", "중랑구 신내동", "성북구 돈암동",
							 "성북구 삼선동2가", "성북구 삼선동3가", "성북구 안암동1가", "성북구 안암동3가", "성북구 보문동4가", "성북구 보문동6가", "성북구 보문동3가", "성북구 정릉동",
							 "성북구 길음동", "성북구 종암동", "성북구 하월곡동", "성북구 상월곡동", "성북구 장위동", "성북구 석관동", "강북구 미아동", "강북구 번동",
							 "강북구 수유동", "강북구 우이동", "도봉구 쌍문동", "도봉구 방학동", "도봉구 창동", "도봉구 도봉동", "노원구 월계동", "노원구 공릉동",
							 "노원구 하계동", "노원구 상계동", "노원구 중계동", "은평구 수색동", "은평구 녹번동", "은평구 불광동", "은평구 갈현동", "은평구 구산동",
							 "은평구 응암동", "은평구 역촌동", "은평구 신사동", "은평구 증산동", "은평구 진관동", "서대문구 충정로3가", "서대문구 합동", "서대문구 천연동",
							 "서대문구 영천동", "서대문구 현저동", "서대문구 북아현동", "서대문구 홍제동", "서대문구 대현동", "서대문구 연희동", "서대문구 홍은동", "서대문구 북가좌동",
							 "서대문구 남가좌동", "마포구 아현동", "마포구 공덕동", "마포구 신공덕동", "마포구 도화동", "마포구 용강동", "마포구 토정동", "마포구 대흥동",
							 "마포구 염리동", "마포구 신수동", "마포구 현석동", "마포구 창전동", "마포구 상수동", "마포구 하중동", "마포구 신정동", "마포구 서교동",
							 "마포구 합정동", "마포구 망원동", "마포구 성산동", "마포구 중동", "마포구 상암동", "양천구 신정동", "양천구 목동", "양천구 신월동",
							 "강서구 염창동", "강서구 등촌동", "강서구 화곡동", "강서구 가양동", "강서구 마곡동", "강서구 내발산동", "강서구 공항동", "강서구 방화동",
							 "구로구 신도림동", "구로구 구로동", "구로구 고척동", "구로구 개봉동", "구로구 오류동", "구로구 궁동", "구로구 온수동", "구로구 천왕동",
							 "구로구 항동", "금천구 가산동", "금천구 독산동", "금천구 시흥동", "영등포구 영등포동", "영등포구 영등포동7가", "영등포구 여의도동", "영등포구 당산동2가",
							 "영등포구 당산동3가", "영등포구 당산동4가", "영등포구 당산동5가", "영등포구 당산동", "영등포구 도림동", "영등포구 문래동3가", "영등포구 문래동4가", "영등포구 문래동6가",
							 "영등포구 양평동2가", "영등포구 양평동3가", "영등포구 양평동4가", "영등포구 양평동5가", "영등포구 신길동", "영등포구 대림동", "동작구 노량진동", "동작구 상도동",
							 "동작구 본동", "동작구 흑석동", "동작구 동작동", "동작구 사당동", "동작구 대방동", "동작구 신대방동", "관악구 봉천동", "관악구 신림동",
							 "관악구 남현동", "서초구 방배동", "서초구 양재동", "서초구 우면동", "서초구 잠원동", "서초구 반포동", "서초구 서초동", "강남구 개포동",
							 "강남구 논현동", "강남구 대치동", "강남구 도곡동", "강남구 삼성동", "강남구 세곡동", "강남구 수서동", "강남구 신사동", "강남구 압구정동",
							 "강남구 역삼동", "강남구 율현동", "강남구 일원동", "강남구 자곡동", "강남구 청담동", "송파구 잠실동", "송파구 신천동", "송파구 풍납동",
							 "송파구 송파동", "송파구 석촌동", "송파구 가락동", "송파구 문정동", "송파구 장지동", "송파구 방이동", "송파구 오금동", "송파구 거여동",
							 "송파구 마천동", "강동구 명일동", "강동구 고덕동", "강동구 상일동", "강동구 길동", "강동구 둔촌동", "강동구 암사동", "강동구 성내동",
							 "강동구 천호동", "강동구 강일동"]; // 배열 형태로 
		$("#houseSearch").autocomplete({ //오토 컴플릿트 시작
			source : searchSource, // source 는 자동 완성 대상
			select : function(event, ui) { //아이템 선택시

			},
			focus : function(event, ui) { //포커스 가면
				return false;//한글 에러 잡기용도로 사용됨
			},
			minLength : 1,// 최소 글자수
			autoFocus : true, //첫번째 항목 자동 포커스 기본값 false
			classes : { //잘 모르겠음
				"ui-autocomplete" : "highlight"
			},
			delay : 200, //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
			//            disabled: true, //자동완성 기능 끄기
			position : {
				my : "right top",
				at : "right bottom"
			}, //잘 모르겠음
			close : function(event) { //자동완성창 닫아질때 호출
			}
		});
	
	$("#submitbtn").click(function() {
		var address= $("#houseSearch").val().trim();
		//console.log(address[0]+address[1]+address[2]);	
// 		location.href="'SelectaptListService.d4b?address="+address[0]+address[1]+address[2];
		location.href='SelectAptListService.d4b?search=' + address
	});
	
	});
</script>
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
									<input type="text" placeholder="법정동 검색" id="houseSearch"
										name="houseSearch" style="width: 200px; height: 50px;">
								<div class="input-group-append ">
									<button type="submit" class="btn btn-primary btn-block btn-lg" id="submitbtn">검색</button>
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