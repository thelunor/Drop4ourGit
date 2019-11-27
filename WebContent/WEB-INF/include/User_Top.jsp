<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId=(String) session.getAttribute("userId");
	String type=(String) request.getAttribute("type");
	
 %>
<!-- Start Atribute Navigation -->
<div class="container">
	<div class="attr-nav">
		<ul>
			<li class="login">
				<%
					if (type != null && type.trim() != "") {
						out.print("<a href ='LogoutService.d4b'>로그아웃</a>");
					} else {
						out.print("<a href ='Login.jsp'>로그인</a>");
					}
				%>
			</li>
			<li class="join">
				<%
					if (type == null || type.trim() == "") {
						out.print("<a href='JoinPage.jsp'>회원가입</a>");
					} 
				%>							
			</li>
			<li class='mypage'>
				<%
					if (type.equals("U01")) {
						out.print("<a href='GetGenericUserMypageMainService.d4b?type=" + type + "'>마이페이지</a>");
					} else if (type.equals("U02")) {
						out.print("<a href='GetREAMypageService.d4b?type=" + type + "'>마이페이지</a>");
					}
				%>
			</li>
			<li class="side-menu">
				<%
					if (type.equals("A00")) {
						out.print("<a href='#'><i class='fa fa-bars'></i></a>");
					}
				%>
		</ul>
	</div>
	<!-- End Atribute Navigation -->

	<!-- Start Header Navigation -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbar-menu"></button>

		<a class="navbar-brand" href="./UserMain.jsp?userId=<%=userId%>&type=<%=type%>" > <img
			src="./images/logo2.png" class="logo logo-display m-top-10" alt="">
			<img src="./images/logo.jpg" class="logo logo-scrolled" alt="">
		</a>
	</div>
</div>

<!-- End Header Navigation -->