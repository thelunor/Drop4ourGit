<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String genericUserId = (String) session.getAttribute("genericUserId");

%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
a {
	color: gray;
}

a:hover, a:focus, a:active, a.active {
	color: #ff6863;
	outline: 0;
}

.list-group-item {
	color: gray;
}

.contain {
  position: relative;
  width: 100%;
  max-width: 400px;
}

.contain #text{
  position: absolute;
  top: 10%;
  left: 90%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}
.contain #text:hover {
  color: yellow;
}
/* Style the close button */
#text {
	color: black;
	font-size: 18px;
	font-weight: bold;
}
.card_top_border {
	height:4px;
	width: 100%;
	background-color: #ff6863;
}

.card-body {
	overflow: hidden;
}

.card-body ul {
	width: 55%;
	margin: 0 auto;
}

.card-body ul li {
	line-height: 3rem;
}

.card-body ul li i {
	margin-right: 10px;
}
</style>
<script>
var close = document.getElementsByClassName("close");
function deleteBookmark(){
   for (var i = 0; i < close.length; i++) {
   	  close[i].onclick = function() {
   	    var div = this.parentElement.parentElement.parentElement;
   	    div.style.display = "none";
   	  }
   	}
}
</script>
<!-- Page Content -->
<div class="container-fluid">
	<div class="col-lg-12">
		<div class="row">
			<div class="col-lg-2">
				<div class="list-group">
					<a href="#" class="list-group-item">북마크</a> <a href="#"
						class="list-group-item">계약관리</a> <a
						href="GetGenericUserEditService.d4b?genericUserId=<%=genericUserId%>"
						class="list-group-item">정보수정</a>
				</div>
			</div>
			<div class="col-lg-1"></div>
			<div class="col-lg-9">
				<h3 style="font-family: 'Jua', sans-serif;">북마크</h3>
				<a href="#">24평</a> &nbsp; | &nbsp; <a href="#">32평</a> &nbsp; |
				&nbsp; <a href="#">42평</a> &nbsp;
				<hr>
				<div class="row">
					<div class="col-lg-4" onclick="deleteBookmark()" id="bookmark">
						<div class="card_top_border"></div>
						<div class="card">
						<div class="contain">
							<img class="card-img-top img-fluid" src="./images/admin.jpg" width="220" height="220">			
							<span id="text" class="close"><i class="fas fa-star"></i></span> 		
							</div>
							<div class="card-body">
								<ul>
								<li style="font-size: 30px; text-align: center; color:black;"><b>반포자이</b></li>
									<li><i class="fa fa-check-circle text-primary"></i> 4억</li>
									<li><i class="fa fa-check-circle text-primary"></i> 올수리 남향</li>
								</ul>
							</div>
						 </div>
					<br>
					</div>

					<div class="col-lg-4" onclick="deleteBookmark()" id="bookmark">
						<div class="card_top_border"></div>
						<div class="card">
						<div class="contain">
							<img class="card-img-top img-fluid" src="./images/admin.jpg" width="220" height="220">			
							<span id="text" class="close"><i class="fas fa-star"></i></span> 		
							</div>
							<div class="card-body">
								<ul>
								<li style="font-size: 30px; text-align: center; color:black;"><b>반포자이1</b></li>
									<li><i class="fa fa-check-circle text-primary"></i> 4억</li>
									<li><i class="fa fa-check-circle text-primary"></i> 올수리 남향</li>
								</ul>
							</div>
						 </div>
					<br>	 
					</div>
					<div class="col-lg-4" onclick="deleteBookmark()" id="bookmark">
						<div class="card_top_border"></div>
						<div class="card">
						<div class="contain">
							<img class="card-img-top img-fluid" src="./images/admin.jpg" width="220" height="220">			
							<span id="text" class="close"><i class="fas fa-star"></i></span> 		
							</div>
							<div class="card-body">
								<ul>
								<li style="font-size: 30px; text-align: center; color:black;"><b>반포자이2</b></li>
									<li><i class="fa fa-check-circle text-primary"></i> 4억</li>
									<li><i class="fa fa-check-circle text-primary"></i> 올수리 남향</li>
								</ul>
							</div>
						 </div>
					<br>	 
					</div>
					<br>
					<br>
					<br>
					<div class="col-lg-4" onclick="deleteBookmark()" id="bookmark">
						<div class="card_top_border"></div>
						<div class="card">
						<div class="contain">
							<img class="card-img-top img-fluid" src="./images/admin.jpg" width="220" height="220">			
							<span id="text" class="close"><i class="fas fa-star"></i></span> 		
							</div>
							<div class="card-body">
								<ul>
								<li style="font-size: 30px; text-align: center; color:black;"><b>반포자이3</b></li>
									<li><i class="fa fa-check-circle text-primary"></i> 4억</li>
									<li><i class="fa fa-check-circle text-primary"></i> 올수리 남향</li>
								</ul>
							</div>
						 </div>
					<br>						 
					</div>
					<div class="col-lg-4" onclick="deleteBookmark()" id="bookmark">
						<div class="card_top_border"></div>
						<div class="card">
						<div class="contain">
							<img class="card-img-top img-fluid" src="./images/admin.jpg" width="220" height="220">			
							<span id="text" class="close"><i class="fas fa-star"></i></span> 		
							</div>
							<div class="card-body">
								<ul>
								<li style="font-size: 30px; text-align: center; color:black;"><b>반포자이4</b></li>
									<li><i class="fa fa-check-circle text-primary"></i> 4억</li>
									<li><i class="fa fa-check-circle text-primary"></i> 올수리 남향</li>
								</ul>
							</div>
						 </div>
					<br>						 
					</div>
					<div class="col-lg-4" onclick="deleteBookmark()" id="bookmark">
						<div class="card_top_border"></div>
						<div class="card">
						<div class="contain">
							<img class="card-img-top img-fluid" src="./images/admin.jpg" width="220" height="220">			
							<span id="text" class="close"><i class="fas fa-star"></i></span> 		
							</div>
							<div class="card-body">
								<ul>
								<li style="font-size: 30px; text-align: center; color:black;"><b>반포자이5</b></li>
									<li><i class="fa fa-check-circle text-primary"></i> 4억</li>
									<li><i class="fa fa-check-circle text-primary"></i> 올수리 남향</li>
								</ul>
							</div>
						 </div>
					</div>	
					<br>									
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>