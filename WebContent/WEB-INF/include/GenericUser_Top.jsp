<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String genericUserId = (String) session.getAttribute("genericUserId");
%>
<!-- Start Atribute Navigation -->
<div class="container">
	<div class="attr-nav">
		<ul>
			<li class="login">
				<%
					if (session.getAttribute("genericUserId") != null) {
						out.print("<a href ='LogoutService.d4b'>로그아웃</a>");
					} else {
						out.print("<a href ='Login.jsp'>로그인</a>");
					}
				%>
			</li>
			<li class="main"><a href="Main.jsp">메인</a></li>
		</ul>
	</div>
	<!-- End Atribute Navigation -->

	<!-- Start Header Navigation -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbar-menu"></button>

		<a class="navbar-brand" href="<%=request.getContextPath() %>/Main.jsp"> <img
			src="<%=request.getContextPath() %>/images/logo1.png" class="logo logo-display m-top-10" alt="">
			<img src="<%=request.getContextPath() %>/images/logo.jpg" class="logo logo-scrolled" alt="">
		</a>
	</div>
</div>

<!-- End Header Navigation -->
