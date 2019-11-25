<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Drop 4our bit</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=668464eb0d779bb6eecda046a974a34b"></script>
<jsp:include page="./css/css.jsp"></jsp:include>
<style type="text/css">
.main_featured .head_title {
   width: 70%;
   margin: 0 auto;
}

h2, h4, h6, h3{
   font-family: 'Jua', sans-serif;
}


a.btn :hover {
   background-color: #eee;
   border-color: #eee;
   border: 0.5px solid #eee;
   color: #ff6863;
}

a.btn  {
   color: #fff;
   background-color: #ff6863;
   border-color: #ff6863;
   border: 2px solid #eee;
   padding: 1rem 1rem;
   float : right;
}



.modal-wrapper {
  width: 100%;
  height: 100%;
  position: fixed;
  background:    rgb(242, 242, 242, 0.5);  
  top: 0; 
  left: 0;
  visibility: hidden;
  Z-index: 1;

}

.modal-wrapper.open {
  opacity: 1;
  visibility: visible;
}

.modal {
  width: 400px;
  height: 600px;
  display: block;
  position: relative;
  top: 40%; 
  left: 38%;
  background: #fff;
  opacity: 0;
  transition: all 0.5s ease-in-out;
}

.modal-wrapper.open .modal {
  margin-top: -200px;
  opacity: 1;
}


.btn-close {
  font-size: 28px;
  display: block;
  float: right;
  color: #fff;
}

.content {
  padding: 10%;
}
.head { 
  width: 100%;
  height: 50px;
  padding: 10px;
  overflow: hidden;
  background: #ff6863;
}

</style>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">

            <div class="houseDetail">
               <div class="page-wrapper">
                 <a class="btn trigger" href="#">Real Estate Agent</a>
               </div>
            </div>
      <!-- End off featured slider -->
      
<!-- Modal -->                  
<div class="modal-wrapper">
  <div class="modal">
    <div class="head">
      <a class="btn-close trigger" href="#">
        <i class="fa fa-times" aria-hidden="true"></i>
      </a>
    </div>
   	 <div class="content">
            <div class="information">
            <h3 style="text-align: center;">로그인</h3>
            <br>
            <div class="form-group">
               <label>아이디 </label> 
               <input type="text" class="form-control" required="required" placeholder="아이디" style="width:320px">
               <label>비밀번호 </label> 
               <input type="text" class="form-control" required="required" placeholder="비밀번호" style="width:320px">
            </div>
            <br>         
            <div class="form-group">
               <button type="submit" class="btn btn-primary btn-block btn-lg">Click</button>
               <br>
               <hr>
            </div>
	            <br>
	            <span>계정이 없으세요? <a href="#"></a></span> <br><br>      
	            <div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block btn-lg" style="padding-left: 6px;">공인중개사 회원가입</button>
						</div>
					</div>        
					<div class="col-sm-6">
						<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block btn-lg" style="padding-left: 27px;">일반 회원가입</button>
						</div>
					</div>        
	            </div>
	    	</div>
	 	 </div>
	</div>
</div>
   <!-- JS includes -->
   <jsp:include page="./js/js.jsp"></jsp:include>
<script>

$( document ).ready(function() {
     $('.trigger').on('click', function() {
        $('.modal-wrapper').toggleClass('open');
       $('.page-wrapper').toggleClass('blur-it');
        return false;
     });
     $('[data-toggle="tooltip"]').tooltip(); 
   });
</script>   
</body>
</html>