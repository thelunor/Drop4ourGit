<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = (String) session.getAttribute("userId");
	String type= "U02";
	
	//System.out.println("reaIdㅡㅡㅡ"+ reaId);
%>
<!-- Start Atribute Navigation -->
<div class="container">
	<div class="attr-nav">
		<ul>
			<li class="login"><a href ='LogoutService.d4b'>로그아웃</a></li>
			<li class="main"><a href="UserMain.jsp?type=<%=type%>">메인</a></li>
			<li class="main"><a href="GetREAMypageService.d4b?type=<%=type%>">마이페이지</a></li>
			<li class="main"><a href="GetREAIntroDataService.d4b?type=<%=type%>">소개페이지</a></li>
		</ul>
	</div>
	<!-- End Atribute Navigation -->

	<!-- Start Header Navigation -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbar-menu"></button>

		<a class="navbar-brand" href="./Main.jsp"> <img
			src="./images/logo1.png" class="logo logo-display m-top-10" alt="">
			<img src="./images/logo.jpg" class="logo logo-scrolled" alt="">
		</a>
	</div>
</div>

<!-- End Header Navigation -->
