<%@page import="kr.or.bit.utils.ThePager"%>
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
	//String genericUserId = (String) session.getAttribute("userId");
	//String reaId = (String) session.getAttribute("reaId");
	String userId = (String) session.getAttribute("userId");
	String search= (String) request.getAttribute("search");
	int pageCount = (int) request.getAttribute("pageCount");
	int count = (int) request.getAttribute("count");
	int pageSize = (int) request.getAttribute("pageSize");
	int cPage = (int) request.getAttribute("cPage");
	System.out.println("userId: "+userId);
	System.out.println("search: "+search);
	System.out.println("pageCount: " + pageCount);
	System.out.println("count: " + count);
	System.out.println("pageSize: " + pageSize);
	System.out.println("cPage: " + cPage);
%>
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=58b9f2ab38f9ccb70e8d94e99bcaab94&libraries=LIBRARY"></script>
<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=58b9f2ab38f9ccb70e8d94e99bcaab94&libraries=services,clusterer,drawing"></script>
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
</style>
<script type="text/javascript">
	        $(function () {
	            $(window).scroll(function () {
	                if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	                    $.ajax({
	                        url: 'InfiniteScroll',
	                        type: 'post',
	                        data: {
	                            "search": $("#search").val()
	                        },
	                        dataType: 'json',
	                        success: function (data) {
	                            $("#tbody").empty();
	    
	                            $.each(data, function (index, element) {
	    
 	                                console.log(element);
	    
// 	                                var dNametable = "";
// 	                                dNametable += "<tr>";
// 	                                dNametable += "<td>" + element.eName + "</td>";
// 	                                dNametable += "<td>" + element.empNo + "</td>";
// 	                                dNametable += "<td>" + element.job + "</td>";
// 	                                dNametable += "<td>" + element.sal + "</td>";
// 	                                dNametable += "<td>" + element.dName + "</td>";
// 	                                dNametable += "<td>" + "<button type='button' class='btn-group-sm' id='edit_btn' onclick=" + "location.href = 'editForm.d4b?empNo="+element.empNo+"' > 수정</button > " + "</td > ";
// 	                                dNametable += "<td>" + "<button type='button' class='btn-group-sm' id='delete_btn' onclick=" + "
// 	                                location.href = 'deleteInfo.d4b?empNo="+element.empNo+"' > 삭제</button > " + "</td > ";
// 	                                dNametable += "</tr>";
	    
// 	                                $('#tbody').append(dNametable);
	                            })
	                        }
	                    })
	                }
	            })
	        });
</script>
<%
	Map<Sale, SaleImage> saleMap = (Map<Sale, SaleImage>)request.getAttribute("saleMap");
	System.out.println(saleMap);
%>
<h6>300개 이상의 매물</h6>
<input type="hidden" value="<%=search%>" id="search">
<p style="font-size: 13px">거래 가격의 비율이 높을 수록 평균 가격보다 낮습니다.</p>
<br>
<div class="row">
	<div class="col-lg-7" id="items">
		<c:set var="priceList" value="priceList"></c:set>
		<c:set var="stringPrice" value="stringPrice"></c:set>
		<c:set var="listLength" value="listLength"></c:set>
		<c:set var="listLength" value="listLength"></c:set>
		<c:set var="saleData" value=""></c:set>
		<c:forEach var="sale" items="<%=saleMap%>" varStatus="status">
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
		                <input type="text" class="form-control" value="전용면적   ${sale.key.aptSize}㎡">
		                <br>
		                <div class="skill_bar sm-m-top-50">
		                    <div class="teamskillbar clearfix m-top-20" data-percent="${79830 / sale.key.price * 100}%">
		                        <h6>거래 가격 : ${sale.key.price}</h6>
		                        <div class="teamskillbar-bar"></div>
		                    </div>
		                    <!-- End Skill Bar -->
		                    <div class="teamskillbar clearfix m-top-50" data-percent="">
		                        <h6>${sale.key.etc}</h6>
		                        <div class="teamskillbar-bar"></div>
		                    </div>
		                    <!-- End Skill Bar -->
		                </div>
		                <a class="btn trigger" href="GetSaleDataService.d4b?aptNum=${sale.key.aptNum}">See the Details</a>
		            </div>
		        </div>
		    </div>
		    <hr>
		</c:forEach>
		    <div>
		<%
			int pagersize=5;
			ThePager pager=new ThePager(count, cPage, pageSize, pagersize, "SelectAtpListService.d4b?pageSize="+ pageSize + "&cPage=" + cPage + "&search=" + search);
		%>
		<%=pager.toString() %>
	</div>
    </div>


    <!-- map -->
    <div class="col-lg-5">
        <div id="map" style="width: 100%; height: 100%;"></div>
    </div>
	</div>

<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3 // 지도의 확대 레벨
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
   
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('강남구 역삼동', function(result, status) {
	    // 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
		} 
	});    

   // 마커가 표시될 위치입니다 
   var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);

   // 마커를 생성합니다
   var marker = new kakao.maps.Marker({
      position : markerPosition
   });

   // 마커가 지도 위에 표시되도록 설정합니다
   marker.setMap(map);

   // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
   // marker.setMap(null);
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
});
   
</script>