<%@page import="kr.or.bit.dto.SaleImage"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.bit.dto.Sale"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String genericUserId = (String) session.getAttribute("genericUserId");
	String reaId = (String) session.getAttribute("reaUserId");
	String search=(String)request.getAttribute("search");
	System.out.println(search);
	String name[] = search.split(" ");
	System.out.println(name[0]);
%>
<script src="http://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<style type="text/css">
h5{
font-family: 'Jua', sans-serif;
}
a.btn :hover {
   color: #fff;
   background-color: #ff6863;
   border-color: #ff6863;
   border: 0.5px solid #eee;
}

a.btn  {
   color: #ff6863;
   background-color: #eee;
   border-color: #eee;
   border: 2px solid #eee;
   padding: 1rem 1rem;
}

.teamskillbar {
	position: relative;
	display: block;
	margin-bottom: 15px;
	width: 100%;
	background: #f2f2f2;
	height: 10px;
	-webkit-transition: 0.4s linear;
	transition: 0.4s linear;
	-webkit-transition-property: width, background-color;
	transition-property: width, background-color;
}

.teamskillbar h6 {
	position: absolute;
	top: -25px;
	left: 0;
}

.teamskillbar-bar {
	height: 10px;
	width: 0px;
	background: #ff6863;
	position: absolute;
	left: 0px;
	top: 0px;
}
.slick-items, .detail{
text-align: center;
}
.main_featured .head_title {
	width: 70%;
	margin: 0 auto;
}

.btnJoin {
	color: #fff;
	background-color: #ff6863;
	border: 2px solid;
	border-color: #ff6863;
	padding: 1rem 3rem;
}

.btnJoin:hover {
	background-color: #eee;
	border-color: #eee;
	border: 2px solid #eee;
	color: #ff6863;
}

.modal-wrapper {
	width: 100%;
	height: 100%;
	position: fixed;
	background: rgb(242, 242, 242, 0.5);
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
	left: 38%;
	background: #fff;
	opacity: 0;
	transition: all 0.5s ease-in-out;
}

.modal-wrapper.open .modal {
	margin-top: -200px;
	opacity: 1;
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

.head {
	width: 100%;
	height: 50px;
	padding: 10px;
	overflow: hidden;
	background: #ff6863;
}
</style>
<%
	
	Map<Sale, SaleImage> saleMap = (Map<Sale, SaleImage>)request.getAttribute("saleMap");
	ArrayList<String> priceList=new ArrayList<String>();
	String stringPrice=null;
	for ( Map.Entry<Sale, SaleImage> entry : saleMap.entrySet() ) {
	    System.out.println("key : " + entry.getKey() +" / value : " + entry.getKey());
	}


	/*  for(Sale sale : list){
		double num = 79830;
		int price= Integer.parseInt(sale.getPrice()); 
		double price2= num / price * 100; 
		stringPrice = Double.toString(price2)+ "%";
	 	saleMap.put(sale, stringPrice);
	 } */

 
//  Collections.sort(keyList, new Comparator() {
// 		public int compare(Object o1, Object o2) {
// 			Object v1 = saleMap.get(o1);
// 			Object v2 = saleMap.get(o2);
// 			return ((Comparable) v2).compareTo(v1);
// 		}
// 	});
 
//  for(Sale str : keyList){
// 	 System.out.println(str);
//  }
 
//  System.out.println(saleMap.toString());
//  System.out.println(saleMap.values());
%>
<h6> 300개 이상의 매물</h6>
<input type="hidden" id="dongName" value="<%=name[0]%>">
<p style="font-size: 13px">거래 가격의 비율이 높을 수록 평균 가격보다 낮습니다.</p>
<br>
<div class="row">
	<div class="col-lg-7" id="items">
 <c:set var="priceList" value="priceList"></c:set>
 <c:set var="stringPrice" value="stringPrice"></c:set>
 <c:set var="listLength" value="listLength"></c:set>
  <c:set var="listLength" value="listLength"></c:set>
 <c:set var="saleData" value=""></c:set>
<%-- <c:forEach var="sale" items="<%=list%>" varStatus="status"> --%>
<%--  <c:forEach var="i" begin="0" end="<%=listLength %>" step="1"> --%>
<c:forEach var="sale" items="<%=saleMap%>" varStatus="status">
		<!-- items inner -->
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-7">
				<div class="slick-items">
					<div>
						<img src="reaimg/${sale.value.saleImgSaveName1}" alt="매물사진1" width="500" height="220">
					</div>
					<div>
						<img src="reaimg/${sale.value.saleImgSaveName2}" alt="매물사진2" width="500" height="220">
					</div>
					<div>
						<img src="reaimg/${sale.value.saleImgSaveName3}" alt="매물사진3" width="500" height="220">
					</div>
				</div>
			</div>
			<!-- 내용 -->
			<div class="col-lg-4">
			<div class="detail" style="text-align: center;">
				<h5>${sale.key.aptName}</h5>
				<input type="text" class="form-control"	value="전용면적   ${sale.key.aptSize}㎡">			
					<br>
					<div class="skill_bar sm-m-top-50">
						<div class="teamskillbar clearfix m-top-20" data-percent="${sale.value}">
							<h6>거래 가격 : ${sale.key.price}</h6>
							<div class="teamskillbar-bar"></div>
						</div>
						<!-- End Skill Bar -->

						<div class="teamskillbar clearfix m-top-50" data-percent="30%">
							<h6>${sale.key.etc}</h6>
							<div class="teamskillbar-bar"></div>
						</div>
						<!-- End Skill Bar -->
					</div>		
				<div class="page-wrapper">					
				 <a class="btn trigger" href="GetSaleDataService.d4b?aptNum=${sale.key.aptNum}">See the Details</a>		
				 </div>
				 </div>
			</div>
		</div>
		<hr>
	</c:forEach>	
	</div>
	<!-- map -->
	<div class="col-lg-5">
		<div id="map" style="width: 100%; height: 100%;"></div>
	</div>

</div>

	<div class="modal-wrapper">
		<div class="modal">
			<div class="head">
				<a class="btn-close trigger" href="#"> <i class="fa fa-times"
					aria-hidden="true"></i>
				</a>
			</div>
			<div class="content">
			  <form action="LoginService.d4b" method="post" name="loginForm">
				<div class="information">
					<h3 style="text-align: center;">로그인</h3>
					<br>
					<div class="form-group">
						<label>아이디 </label> 
						<input class="form-control" type="text" name="id" id="id" placeholder="ID" style="width: 320px" required="required">
						<label>비밀번호 </label> 
						<input class="form-control" type="password" name="pwd" id="pwd" required="required" placeholder="PASSWORD" style="width: 320px">
					</div>
					<br>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block btn-lg">Click</button>
						<br>
						<hr>
					</div>
					<br> <span>계정이 없으신가요?</span> <br>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">

								<button type="submit" class="btnJoin" onclick="location.href='JoinCheckGeneric.jsp'">
									<i class="fas fa-user"></i> 일반
								</button>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<button type="submit" class="btnJoin"
									style="padding-left: 20px; padding-right: 20px;" onclick="location.href='JoinCheckREA.jsp'">
									<i class="fas fa-home"></i> 공인중개인
								</button>
							</div>
						</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	
<script>	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(37.5173552, 127.0452494), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	// 마커가 표시될 위치입니다 
	var markerPosition = new kakao.maps.LatLng(37.5173552, 127.0452494);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

$(function(){
	
	$('.slick-items').slick({
		autoplay : true,
		dots : true,
		speed : 300 /* 이미지가 슬라이딩시 걸리는 시간 */,
		infinite : true,
		autoplaySpeed : 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */,
		arrows : true,
		slidesToShow : 1,
		slidesToScroll : 1,
		fade : false
	});		
	
	$('.trigger').click(function(){
   	 $('.modal-wrapper').toggleClass('open');
        $('.page-wrapper').toggleClass('blur-it');
         return false;
    });
    $('[data-toggle="tooltip"]').tooltip(); 	
	
});
	
</script>
