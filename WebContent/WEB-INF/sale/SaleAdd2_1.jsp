<%@page import="kr.or.bit.dto.Sale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<%
	Sale sale = new Sale();
	sale = (Sale) request.getAttribute("sale2");
%>
<c:set var="saleData" value="<%=sale%>"></c:set>
<html class="no-js" lang="en">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap"
	rel="stylesheet">

<head>
<meta charset="utf-8">
<title>Drop 4our bit</title>
<meta name="description" content="">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js">
	
</script>
<link rel="stylesheet"
	href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">
<link rel="stylesheet"
	href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">

<jsp:include page="../../css/css.jsp"></jsp:include>
<style>
h2 {
	font-family: 'Jua', sans-serif;
}
</style>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">
	<div class="culmn">
		<!--Home page style-->

		<!-- Top jsp -->
		<nav
			class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
			<jsp:include page="./../include/REAUser_Top.jsp"></jsp:include>

			<!-- Side jsp -->
			<jsp:include page="./../include/Side.jsp"></jsp:include>
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
					<br>
					<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;매물
								사진</label>
				<form action="InsertSaleImgService.d4b" method="post" id="ajaxForm" enctype="multipart/form-data">
								
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<img id="preview1" src="images/picture.png" alt="Profile">
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="file" name="file" id="getfile1"
											onchange="imageURL1()"><br>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<img id="preview2" src="images/picture.png" alt="Profile">
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="file" name="file" id="getfile2"
											onchange="imageURL2()"><br>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<img id="preview3" src="images/picture.png" alt="Profile">
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="file" name="file" id="getfile3"
											onchange="imageURL3()"><br>
									</div>
								</div>
							</div>
							<br><br>
							<div class="form-group">
									<div class="row">
										<div class="col-sm-4">
										</div>
										<div class="col-sm-4">
											<button type="submit" id="ajaxBtn" class="btn btn-primary btn-block btn-lg">사진 등록</button>
										</div>
										<div class="col-sm-4">
										</div>
									</div>
								</div>
							</form>
							
						<form action="InsertSaleService.d4b" method="post" id="UploadForm">
							<br> <br>
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
									<br><br>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-3">
										</div>
										<div class="col-sm-3">
											<button type="submit" class="btn btn-primary btn-block btn-lg">매물 등록</button>
										</div>
										<div class="col-sm-3">
											<button type="reset" class="btn btn-primary btn-block btn-lg">취소</button>
										</div>
										<div class="col-sm-3">
										</div>
									</div>
								</div>
								<br> <br> <br>
							</div>
						</div>
						</form>
					</div>
					<br> <br>
				</div>
			</div>
	</div>


	</section>

	<!-- scroll up-->
	<jsp:include page="./../include/ScrollUp.jsp"></jsp:include>
	<!-- End off scroll up -->
	<jsp:include page="./../include/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="../../js/js.jsp"></jsp:include>
	<script>
	
	function imageURL1 () { 
		var file1 = document.querySelector('#getfile1');
		var fileList = file1.files ;
	    
	    // 읽기
	    var reader = new FileReader();
	    reader.readAsDataURL(fileList [0]);

	    //로드 한 후
	    reader.onload = function  () {
	        document.querySelector('#preview1').src = reader.result ;
	    }; 
	}; 
	function imageURL2 () { 
		var file2 = document.querySelector('#getfile2');
		var fileList = file2.files ;
	    var reader = new FileReader();
	    reader.readAsDataURL(fileList [0]);
	    reader.onload = function  () {
	        document.querySelector('#preview2').src = reader.result ;
	    }; 
	}; 
	function imageURL3 () { 
		var file3 = document.querySelector('#getfile3');
		var fileList = file3.files ;
	    var reader = new FileReader();
	    reader.readAsDataURL(fileList [0]);
	    reader.onload = function  () {
	        document.querySelector('#preview3').src = reader.result ;
	    }; 
	}; 
	
	
	$(function(){
		$("#ajaxBtn").click(function(){
		 
			$.ajax({
				url : 'InsertSaleImgService.d4b',
				data : formData,
				processData: false,
		        contentType: false,
		        type: 'POST',
		        success: function (data) {
		            alert("이미지 업로드 성공");
		        }
				
			});
		});
	});
	</script>

</body>

</html>