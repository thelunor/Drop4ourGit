<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	String genericUserId = (String) session.getAttribute("genericUserId");
	String reaId = (String) session.getAttribute("reaId");
	String type = (String) request.getAttribute("type");
 %>
<!-- Start Atribute Navigation -->
<div class="container">
	<div class="attr-nav">
		<ul>
			<li class="login">
				<%
					if (genericUserId != "") {
						out.print("<a href ='LogoutService.d4b'>로그아웃</a>");
					} else if( reaId != "" ){ 
						out.print("<a href ='LogoutService.d4b'>로그아웃</a>");

					} else {
						out.print("<a href ='Login.jsp'>로그인</a>");
					}
				%>
			</li>
			<li class='mypage'>
				<%
					if (request.getAttribute("type").equals("U01")) {
						out.print("<a href='Main.jsp'>마이페이지</a>");
					} else if (request.getAttribute("type").equals("U02")) {
						out.print("<a href='GetREAMypageService.d4b'>마이페이지</a>");
					}
				%>
			</li>

			<li class="side-menu">
				<%
					String id = null;
					id = (String) session.getAttribute("id");

					if (id != null) {
						if (id.equals("admin")) {
							out.print("<a href='#'><i class='fa fa-bars'></i></a>");
						}
					}
				%>
			
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
