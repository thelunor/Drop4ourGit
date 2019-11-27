<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bit.dto.BookMark"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dao.BookMarkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String genericUserId = (String) session.getAttribute("userId");
	BookMarkDao dao = new BookMarkDao();
	List<BookMark> bmList = new ArrayList<BookMark>();
	bmList = dao.getBookMark(genericUserId); //reaId로 리스트 불러오기	
%>	

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	width : 100%;
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
h6{
font-family: 'Jua', sans-serif;
}
</style>
<script>
$(function() {
	getBookMark('24');			
});

function getBookMark(aptSize){
	$.ajax({
        url : 'BookMarkList',
        type : 'post',
        data : {"userId" : $("#myId").val()},
        dataType : 'json',
        success : function(data) {	
        	$("#bmContent").empty();
            $.each(data, function(index, element) {   

            	
            	if(element.aptSize==aptSize){
            		
            		var content = "";
					content += "<div class='col-lg-4' onclick='deleteBookmark()' id='bookmark'>";
					content += "<div class='card_top_border'></div>";
					content += "<div class='card'>";
					content += "<div class='contain'>";
					content += "<img class='card-img-top img-fluid' src='./images/admin.jpg' width='100%' height='220'>";			
					content += "<span id='text' class='close'><i class='fas fa-star'></i></span>"; 		
					content += "</div>";
					content += "<div class='card-body'>";
					content += "<ul>";
					content += "<h6 style='text-align:center;'><b>"+element.aptName+"</b></h6>";
					content += "<li><i class='fa fa-check-circle text-primary'></i>"+element.type+"</li>";	
					content += "<li><i class='fa fa-check-circle text-primary'></i>"+element.price+"만 원</li>";
					content += "</ul>";
					content += "</div>";
					content += "</div>";
					content += "<br>";
					content += "</div>";  
					
					$('#bmContent').append(content);
            	}
            });
        }
    });	
		
}

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
					<a class="list-group-item"></a>
					<a href="#" class="list-group-item">북마크</a> <a href="#"
						class="list-group-item">계약관리</a> <a
						href="GetGenericUserEditService.d4b?genericUserId=<%=genericUserId%>"
						class="list-group-item">정보수정</a>
				</div>
			</div>
			<div class="col-lg-1"></div>
			<div class="col-lg-9">
				<h3 style="font-family: 'Jua', sans-serif;">북마크</h3>
				<div class="row">
				<div class="col-sm-12">
				<input type="hidden" id="myId" value="<%=genericUserId%>">
 
				<a href="#" onclick="getBookMark('24')">24평</a> &nbsp; | &nbsp; <a href="#" onclick="getBookMark('32')">32평</a>&nbsp; |
				&nbsp; <a href="#" onclick="getBookMark('42')">42평</a> &nbsp;

				<h6 style="float: right;"><img src="images/love.gif" style="width: 40px; height: 30px;"><%=genericUserId%> 님의 페이지입니다</h6>
				</div>
				</div>
				<hr>
				<div class="row" id="bmContent">
				<br>									
			</div>
		</div>
	</div>
</div>
</div>
<!-- /.container -->
<script>
$("#deleteBookmark")

</script>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>