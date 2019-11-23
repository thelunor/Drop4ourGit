<%@page import="kr.or.bit.dto.Sale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<%
	Sale sale = new Sale();
	sale = (Sale) request.getAttribute("sale2");
	System.out.println(sale.toString());
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

<jsp:include page="./css/css.jsp"></jsp:include>
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
								<h2 style="text-align: center">매물 사진 등록</h2>
								<br>
								<hr>
								<br>
							</div>
						</div>
					</div>
					<div>
						<form action="InsertSaleImgService.d4b" class="dropzone">
							<%-- <input type="hidden" name="aptNum" value="<%=aptNum%>"> --%>
							<div class="row">
								<div class="col-sm-5"></div>
								<div class="col-sm-2">
									<button type="submit" class="btn btn-primary btn-block btn-sm"
										id="submitBtn" style="padding-left: 32px;">${saleData.aptNum}</button>
								</div>
								<div class="col-sm-5"></div>
							</div>
						</form>
					<br> <br>
					</div>
					<br> <br>

				</div>
			</div>
	</div>


	</section>

	<!-- scroll up-->
	<jsp:include page="./WEB-INF/include/ScrollUp.jsp"></jsp:include>
	<!-- End off scroll up -->
	<jsp:include page="./WEB-INF/include/Bottom.jsp"></jsp:include>
	</div>

	<!-- JS includes -->
	<jsp:include page="./js/js.jsp"></jsp:include>
	<script>
		
	</script>

</body>

</html>