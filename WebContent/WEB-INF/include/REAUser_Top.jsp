<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String reaId = (String) session.getAttribute("reaUserId");
%>
<!-- Start Atribute Navigation -->
<div class="container">
	<div class="attr-nav">
		<ul>
			<li class="login">
				<%
					if (session.getAttribute("reaUserId") != null) {
						out.print("<a href ='LogoutService.d4b'>로그아웃</a>");
					} else {
						out.print("<a href ='Login.jsp'>로그인</a>");
					}
				%>
			</li>
			<li class="main"><a href="Main.jsp">메인</a></li>
			<li class="main"><a href="GetREAUserByIdService.d4b?reaUserId=<%=reaId%>">마이페이지</a></li>
			<li class="main"><a href="GetREAIntroDataService.d4b?reaUserId=<%=reaId%>">소개페이지</a></li>
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
