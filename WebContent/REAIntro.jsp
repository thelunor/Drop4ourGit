<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<head>
	<meta charset="UTF-8">
	<title>공인중개사 소개 페이지</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- CSS style -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
	<!-- include summernote css/js-->
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
	
	<jsp:include page="css/css.jsp" />
	
	<style type="text/css">
		a {
		    color: #797979;
		}
		
		a:hover {
		    color: #212529;
		}
		
		h2 {
			font-family: 'Jua', sans-serif;
			text-align: center;
		}
		
		h1, h3 {
		font-family: 'Jua', sans-serif;
		text-align: center;
		}
		
		.clearfix:after {
			content: '';
			display: block;
			clear: both;
			float: none;
		}
	</style>
	
	<script type="text/javascript">
		$.noConflict();
		jQuery( document ).ready(function( $ ) {//화면 다 뜨면 시작
			// 두 줄은 충돌방지
			
			// 여기부터 날짜입력 달력
			var monthNames = [];
			for(var i = 1 ; i <=12 ;i++){
				monthNames.push(i + "월")
			}
			
			$("#selectdate").datepicker({
				dateFormat: "yy. mm. dd",
				prevText:"이전달", //이전달 Tool tip text
				nextText:"다음달",  //다음달 Tool tip text
				monthNames: monthNames,//['1월','2월'] 배열 //각 월표현
				yearSuffix: '년',
				numberOfMonths: 1			
			})
			
			$('#selectdate').datepicker("option","onSelect",function(selectedDate){
				//selectedDate 선택한 날짜를 받는 변수
				//console.log(selectedDate);
				//div 달력
			});
			
		})
		
/* 		// summernote 충돌로 인해 일단 보류
		jQuery( document ).ready(function( $ ) {//화면 다 뜨면 시작
		     $('#summernote').summernote({
				height: 200, // set editor height
				minHeight: null, // set minimum height of editor
				maxHeight: null, // set maximum height of editor
				focus: true // set focus to editable area after initializing summernote
		     });
		}); */
	</script>
	
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
	<div class="culmn">
		<!--Home page style-->

		<nav class="navbar navbar-light navbar-expand-lg navbar-fixed ivory no-background bootsnav">
		<!-- Top jsp -->
			<jsp:include page="WEB-INF/include/Admin_top.jsp" />

		<!-- Side jsp -->
			<jsp:include page="WEB-INF/include/Side.jsp" />
		</nav>
		<!-- Container -->
		<section id="join" class="about roomy-100">
			<div class="container">
				<div class="about_content">
					<div class="row">
						<!-- Left -->
						<div class="col-md-3" style="border: 1px solid rgb(211, 211, 211); padding-top: 15px; padding-bottom: 15px; height: 500px; width: 200px; position: fixed;">
							<div class="signup-form">
								<div class="form-group" style="text-align : center">
									<img id="preview" src="./images/profile.png" style="width:200px" alt="Profile">
								</div>
							</div>
							<div style="margin-top: 10px; margin-bottom: 10px;">
								<hr>
							</div>
							<div>
								두번째 소개
							</div>
							<div style="margin-top: 10px; margin-bottom: 10px;">
								<hr>
							</div>
							<div>
								세번째 소개
							</div>
						</div>
						<!-- Left End -->
						
						<!-- Right -->
						<div class="col-md-9" style="margin-left: 240px;">
							<div style="margin-left: 80px;">
								<!-- 첫 소개 글머리 -->
								<div>
									<section>
										<div style="margin-bottom: 32px;">
											<div>
												<div>
													<h4>
														안녕하세요. 비트 부동산에 오신 것을 환영합니다.
													</h4>
												</div>
												<div style="margin-top: 8px;">
													회원가입: 2018.
												</div>
											</div>
										</div>
									</section>
								</div>
								
								<!-- 두 번째 소개 -->
								<div>
									<section>
										<div style="width: 40px; height: 40px; margin-top: 10px; margin-bottom: 10px;">
											<img alt="house" src="./images/house.png">
										</div>
										<div>
											서울 강남구 비트부동산 010-1234-5678
										</div>
									</section>
									<div style="margin-top: 20px; margin-bottom: 20px;">
										<hr>
									</div>
								</div>
								
								<!-- 세 번째 매물 -->
								<div>
									<section>
										<div class="container-fluid">
											<div class="col-lg-12 text-center" style="background-color: #cccccc;">
												<div id="myCarousel" class="carousel slide" data-ride="carousel">
													<!-- Indicators -->
													<ul class="carousel-indicators">
														<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
														<li data-target="#myCarousel" data-slide-to="1"></li>
														<li data-target="#myCarousel" data-slide-to="2"></li>
													</ul>
													
													<!-- Slideshow -->
													<div class="carousel-inner">
														<div class="carousel-item active">
															<img src="images/84a.jpg" width="100%">
															<h5>1111</h5>
															<br>
														</div>
														<div class="carousel-item">
															<img src="images/84a.jpg" width="100%">
															<h5>2222</h5>
															<br>
														</div>
														<div class="carousel-item">
															<img src="images/84a.jpg" width="100%">
															<h5>3333</h5>
															<br>
														</div>
													</div>
													
													<!-- Left and right controls -->
													<a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
														<span class="carousel-control-prev-icon"></span>
													</a>
													<a class="carousel-control-next" href="#myCarousel" data-slide="next">
														<span class="carousel-control-next-icon"></span>
													</a>
												</div>
											</div>
										</div>
									</section>
									<div style="margin-top: 20px; margin-bottom: 20px;">
										<hr>
									</div>
								</div>
								
								<!-- 네 번째 후기 -->
								<div>
									<section>
										<h4><div>후기</div></h4>
										<div>
											<div>
												<h6>계약을 완료한 분들의 후기</h6>
											</div>
											<div style="margin-top: 20px; margin-bottom: 20px;">
												<hr>
											</div>
												<form name="" action="" method="post">
													<table style="border: 0;">
														<tr>
															<td style="text-align: right;">
																<span>
																	날짜:
																</span>
															</td>
															<td>
																<input type="text" id="selectdate" placeholder="날짜입력" 
																	style="text-align: left;" readonly>
															</td>
															<td align="right">
																<label>작성자: </label>
																<span id="writer" style="width: 100%;">작성자아이디</span>										
															</td>
														</tr>
														<tr>
															<td align="left" colspan="3" width="100%">
																<textarea id="summernote" name="content" class="ckeditor"
																	rows="3" cols="100" >방이 추워요</textarea>
															</td>
														</tr>
													</table>
												</form>
											<div style="margin-top: 20px; margin-bottom: 20px;">
												<hr>
											</div>
											<div>
												<div style="margin-top: 24px; margin-bottom: 24px;">
													<span>2019.01.01.</span>
													<div style="float: right;">
														작성자: 김김김
													</div>
												</div>
												<div style="margin-top: 12px;">
													<div>
														방은 좋고 예쁜데 클렌징폼이랑 빗같은건 구비되어 있지 않아서 참고하셔야할것같아요.
													</div>
												</div>
											</div>
											<div style="margin-top: 20px; margin-bottom: 20px;">
												<hr>
											</div>
											
											<!--이전 링크 -->
											<c:if test="${cpage>1}">
												<a href="board_list.jsp?cp=${cpage-1}&ps=${pagesize}">이전</a>
											</c:if> 
											<!--페이지 리스트 구현  -->
											<c:forEach var="i" begin="1" end="${pagecount}" step="1">
												<c:choose>
													<c:when test="${cpage==i}">
														<font color='red'>[${i}]</font>
													</c:when>
													<c:otherwise>
														<a href="board_list.jsp?cp=${i}&ps=${pagesize}">[${i}]</a>
													</c:otherwise>
												</c:choose>
											</c:forEach> <!--다음 링크 --> <c:if test="${cpage<pagecount}">
												<a href="board_list.jsp?cp=${cpage+1}&ps=${pagesize}">다음</a>
											</c:if>
										</div>
									</section>
								</div>
							</div>
						</div>
						<!-- Right End -->
						
					</div>
				</div>
			</div>
		</section>
		<!-- scroll up-->
		<div class="scrollup">
			<a href="#"><i class="fa fa-chevron-up"></i></a>
		</div>
		<!-- End off scroll up -->
		<jsp:include page="WEB-INF/include/Bottom.jsp" />
	</div>
	
	<!-- JS includes -->
	<jsp:include page="js/js.jsp" />
	
</body>
</html>