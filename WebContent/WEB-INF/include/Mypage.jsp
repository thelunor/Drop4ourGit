<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String genericUserId = (String) session.getAttribute("genericUserId");

%>
<style>
a{
color : gray;
}
a:hover, a:focus, a:active, a.active {
	color: #ff6863;
	outline: 0;
}
.list-group-item{
color: gray;
}

.card-body{
text-align: center;
}
/* Style the close button */
#text
{   
    color:black;
    font-size:15px;
    font-weight:bold;
}

</style>
<script>
function doDisplay(){
    var con = document.getElementById("bookmark");
        con.style.display = 'none';
}


출처: https://mainia.tistory.com/2710 [녹두장군 - 상상을 현실로]

</script>
	<!-- Page Content -->
	<div class="container-fluid">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-2">
					<div class="list-group">
						<a href="#" class="list-group-item">북마크</a> 
						<a href="#" class="list-group-item">계약관리</a> 
						<a href="GetGenericUserEditService.d4b?genericUserId=<%=genericUserId%>" class="list-group-item">정보수정</a>
					</div>
				</div>
				<div class="col-lg-1"></div>
				<div class="col-lg-9">
				<h3 style="font-family: 'Jua', sans-serif;">북마크</h3>					
				<a href="#">24평</a> &nbsp; | &nbsp; <a href="#">32평</a> &nbsp; | &nbsp; <a href="#">42평</a> &nbsp;
					<hr>					
					<div class="row">
						<div class="col-lg-4">
							<div class="card bg-light text-dark" id="bookmark">
							<a id="text" class="close" href="javascript:doDisplay();"><i class="fas fa-star"></i></a>
								<img class="card-img-top img-fluid" src="./images/admin.jpg"
									alt="" width="220" height="220" id="image">
								<div class="card-body" id="contents">
									<h3 class="card-title">반포자이</h3>
									<h4>4억</h4>
									<p class="card-text">올수리 남향</p>
								</div>
							</div>
							<br>
						</div>
						<div class="col-lg-4">
							<div class="card bg-light text-dark">
								<img class="card-img-top img-fluid" src="./images/admin.jpg"
									alt="" width="220" height="220">
								<div class="card-body">
									<h3 class="card-title">반포자이</h3>
									<h4>4억</h4>
									<p class="card-text">올수리 남향</p>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="card bg-light text-dark ">
								<img class="card-img-top img-fluid" src="./images/admin.jpg"
									alt="" width="220" height="220">
								<div class="card-body">
									<h3 class="card-title">반포자이</h3>
									<h4>4억</h4>
									<p class="card-text">올수리 남향</p>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="card bg-light text-dark ">
								<img class="card-img-top img-fluid" src="./images/admin.jpg"
									alt="" width="220" height="220">
								<div class="card-body">
									<h3 class="card-title">반포자이</h3>
									<h4>4억</h4>
									<p class="card-text">올수리 남향</p>
								</div>
							</div>
						</div>
						<br><br><br>
						<div class="col-lg-4">
							<div class="card bg-light text-dark ">
								<img class="card-img-top img-fluid" src="./images/admin.jpg"
									alt="" width="220" height="220">
								<div class="card-body">
									<h3 class="card-title">반포자이</h3>
									<h4>4억</h4>
									<p class="card-text">올수리 남향</p>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="card bg-light text-dark ">
								<img class="card-img-top img-fluid" src="./images/admin.jpg"
									alt="" width="220" height="220">
								<div class="card-body">
									<h3 class="card-title">반포자이</h3>
									<h4>4억</h4>
									<p class="card-text">올수리 남향</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>