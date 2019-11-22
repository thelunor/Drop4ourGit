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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0d0c0a21e3bf46994d7f7a41d9cc729f&libraries=services"></script>

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
			<jsp:include page="./WEB-INF/include/Top.jsp"></jsp:include>

			<!-- Side jsp -->
			<jsp:include page="./WEB-INF/include/Side.jsp"></jsp:include>
		</nav>
		<!--Login Sections-->

		<section id="join" class="about roomy-100">

			<div class="container">
				<div class="about_content">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="signup-form">
								<br> <br> <br>
								<h2 style="text-align: center">매물 등록</h2>
								<br>
								<hr>
								<br>
							</div>
						</div>
					</div>
					<div>
						<form action="InsertSaleImgService.d4b"
							enctype="multipart/form-data" id="fileUploadForm">
							<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;매물
								사진</label>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<img id="preview1" src="images/picture.png" alt="Profile">
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="file" name="files" id="getfile" onchange="imageURL1(this)"><br>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<img id="preview2" src="images/picture.png" alt="Profile">
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="file" name="files" id="getfile" onchange="imageURL2(this)"><br>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<img id="preview3" src="images/picture.png" alt="Profile">
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="file" name="files" class="getfile" onchange="imageURL3(this)"><br>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5"></div>
								<div class="col-sm-2">
									<button type="submit" class="btn btn-primary btn-block btn-sm"
										id="submitBtn" style="padding-left:32px;">사진 등록</button>
								</div>
								<div class="col-sm-5"></div>
							</div>
						</form>
					</div>
					<br><br>
					<form action="InsertSaleService.d4b" enctype="multipart/form-data"
						id="fileUploadForm">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label>면적 선택 &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
										class="form-control" style="width: 95%" name="aptSize"
										id="aptSize">
										<option value="24">24평 (전용 59㎡)</option>
										<option value="32">32평 (전용84.9㎡)</option>
										<option value="42">42평 (전용 116㎡)</option>
									</select>
								</div>
								<div class="form-group">
									<label>거래 유형 &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
										class="form-control" style="width: 95%" name="type" id="type">
										<option value="sale">매매</option>
										<option value="lease">전세</option>
									</select>
								</div>


								<div class="form-group">
									<label>주소 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdCh"></span></label>
									<div class="row">
										&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
											class="form-control" name="addr" id="addr"
											required="required" placeholder="주소" style="width: 76%;">
										&nbsp;&nbsp; <input type="button" onclick="searchAddr()"
											value="주소 검색"><br> <br>
									</div>
									<div id="map"
										style="width: 300px; height: 300px; margin-top: 10px; margin-left: 17%; display: none"></div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-4">
											<label>아파트</label> <input type="text" class="form-control"
												name="aptName" id="aptName" required="required">
										</div>
										<div class="col-sm-4">
											<label>동</label> <input type="text" class="form-control"
												name="aptDong" id="aptDong" required="required"
												placeholder="000동">
										</div>
										<div class="col-sm-4">
											<label>호</label> <input type="text" class="form-control"
												name="aptHo" id="aptHo" required="required"
												placeholder="000호">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label>거래 금액 (매매가 | 보증금)&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
										type="password" class="form-control" name="price" id="price"
										required="required" placeholder="0억 0000천 만원">
								</div>
								<div class="form-group">
									<label>향(선택) &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
										class="form-control" style="width: 95%" name="direction"
										id="direction">
										<option value="blank">-</option>
										<option value="south">남향</option>
										<option value="southEast">남동향</option>
										<option value="southWest">남서향</option>
										<option value="east">동향</option>
										<option value="west">서향</option>
										<option value="north">북향</option>
										<option value="northEast">북동향</option>
										<option value="northWest">북서향</option>
									</select>
								</div>
								<div class="form-group">
									<label>매물특징 &nbsp;&nbsp;&nbsp;&nbsp;</label>
									<p>
										<textarea cols="70" rows="3" placeholder="매물에 관한 부가적인 내용"
											name="etc" id="etc"></textarea>
									</p>
								</div>
								<input type="hidden" id="isContract" name="isContract"
									value="false">
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6">
											<button type="submit"
												class="btn btn-primary btn-block btn-lg" id="submitBtn">Register</button>
										</div>
										<div class="col-sm-6">
											<button type="reset" class="btn btn-primary btn-block btn-lg">Cancel</button>
										</div>
									</div>
								</div>

								<br> <br> <br>
							</div>
						</div>
					</form>

				</div>
			</div>

			<!--End off row-->
			<input type="hidden" value="<%=session.getAttribute("reaId")%>"
				name="reaId" id="reaId">
			<!--End off container -->
		</section>

		<!-- scroll up-->
		<jsp:include page="./WEB-INF/include/ScrollUp.jsp"></jsp:include>
		<!-- End off scroll up -->
		<jsp:include page="./WEB-INF/include/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="./js/js.jsp"></jsp:include>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div
		mapOption = {
			center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
			level : 5
		// 지도의 확대 레벨
		};

		//지도를 미리 생성
		var map = new daum.maps.Map(mapContainer, mapOption);
		//주소-좌표 변환 객체를 생성
		var geocoder = new daum.maps.services.Geocoder();
		//마커를 미리 생성
		var marker = new daum.maps.Marker({
			position : new daum.maps.LatLng(37.537187, 127.005476),
			map : map
		});

		function searchAddr() {
			new daum.Postcode({
				oncomplete : function(data) {
					var addr = data.address; // 최종 주소 변수

					// 주소 정보를 해당 필드에 넣는다.
					document.getElementById("addr").value = addr;
					// 주소로 상세 정보를 검색
					geocoder.addressSearch(data.address, function(results,
							status) {
						// 정상적으로 검색이 완료됐으면
						if (status === daum.maps.services.Status.OK) {

							var result = results[0]; //첫번째 결과의 값을 활용

							// 해당 주소에 대한 좌표를 받아서
							var coords = new daum.maps.LatLng(result.y,
									result.x);
							// 지도를 보여준다.
							mapContainer.style.display = "block";
							map.relayout();
							// 지도 중심을 변경한다.
							map.setCenter(coords);
							// 마커를 결과값으로 받은 위치로 옮긴다.
							marker.setPosition(coords)
						}
					});
				}
			}).open();
		}

		//사진 미리보기
		/* 
		var file = document.querySelector('#getfile1');
		file.onchange = function() {
			var fileList = file.files;
			// 읽기
			var reader = new FileReader();
			reader.readAsDataURL(fileList[0]);
			//로드 한 후
			reader.onload = function() {
				document.querySelector('#preview1').src = reader.result;
			};
		};
 */
 function imageURL1(input) {
     if (input.files && input.files[0]) {
         var reader = new FileReader();

         reader.onload = function(e) {
             $('#preview1').attr('src', e.target.result);
         }

         reader.readAsDataURL(input.files[0]);
     }
 }
 function imageURL2(input) {
     if (input.files && input.files[0]) {
         var reader = new FileReader();

         reader.onload = function(e) {
             $('#preview2').attr('src', e.target.result);
         }

         reader.readAsDataURL(input.files[0]);
     }
 }
 function imageURL3(input) {
     if (input.files && input.files[0]) {
         var reader = new FileReader();

         reader.onload = function(e) {
             $('#preview3').attr('src', e.target.result);
         }

         reader.readAsDataURL(input.files[0]);
     }
 }
		
		
		
		
		//파일 업로드 비동기처리
		$(document).ready(function() {

			$("#submitBtn").click(function(event) {

				//stop submit the form, we will post it manually.
				event.preventDefault();
				// Get form
				var form = $('#fileUploadForm')[0];
				// Create an FormData object 
				var data = new FormData(form);
				// If you want to add an extra field for the FormData
				//data.append("CustomField", "This is some extra data, testing");
				// disabled the submit button
				$("#submitBtn").prop("disabled", true);
				$.ajax({
					type : "POST",
					enctype : 'multipart/form-data',
					url : "InsertSaleImgService.d4b",
					data : data,
					processData : false,
					contentType : false,
					cache : false,
					timeout : 600000,
					success : function(data) {
						console.log("SUCCESS : ", data);
						$("#submitBtn").prop("disabled", false);

					},
					error : function(e) {
						console.log("ERROR : ", e);
						$("#submitBtn").prop("disabled", false);

					}
				});

			});

		});
	</script>

</body>

</html>