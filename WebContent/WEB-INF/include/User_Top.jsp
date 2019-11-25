<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	String genericUserId = null;
	String reaId = null;
	String type = null;
	genericUserId = (String) session.getAttribute("genericUserId");
	reaId = (String) session.getAttribute("reaUserId");
	type = (String) request.getAttribute("type");
	System.out.println(type);
 %>
<!-- Start Atribute Navigation -->
<div class="container">
	<div class="attr-nav">
		<ul>
			<li class="login">
				<%
					if (request.getAttribute("type") != null) {
						out.print("<a href ='LogoutService.d4b'>로그아웃</a>");
					} else {
						out.print("<a href ='Login.jsp'>로그인</a>");
					}
				%>
			</li>
			<li class="join">
				<%
					if (request.getAttribute("type") == null) {
						out.print("<a href='JoinPage.jsp'>회원가입</a>");
					} 
				%>							
			</li>
			<li class='mypage'>
				<%
					if (type.equals("U01")) {
						out.print("<a href='Main.jsp'>마이페이지</a>");
					} else if (type.equals("U02")) {
						out.print("<a href='GetREAMypageService.d4b?reaId="+reaId+"'>마이페이지</a>");
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
			src="./images/logo2.png" class="logo logo-display m-top-10" alt="">
			<img src="./images/logo.jpg" class="logo logo-scrolled" alt="">
		</a>
	</div>
</div>

<!-- End Header Navigation -->