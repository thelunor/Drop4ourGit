<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">

<head>
    <meta charset="utf-8">
    <title>Drop 4our bit</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <jsp:include page="./css/css.jsp"></jsp:include>


<style type="text/css">
 h2, label {
     font-family: 'Jua', sans-serif;
 }
 span{
 color:#ff6863;
 }
b{
color : black;
font-size: 16px;
}
</style>
<script>
function checkAll(){
    if( $("#allCheck").is(':checked') ){
      $("input[name=check]").prop("checked", true);
    }else{
      $("input[name=check]").prop("checked", false);
    }
}
</script>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">
    <div class="culmn">
        <!--Home page style-->

        <!-- Top jsp -->
        <nav class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
            <jsp:include page="WEB-INF/include/Top.jsp"></jsp:include>

            <!-- Side jsp -->
            <jsp:include page="WEB-INF/include/Side.jsp"></jsp:include>
        </nav>
        <!--Login Sections-->

        <section id="join" class="about roomy-100">
                <div class="container">
                    <div class="about_content">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
    						<div class="signup-form">

                                    <br> <br> <br>
                                    <h2 style="text-align: center">약관동의</h2>
                                    <br>
                                    <hr>
  
                                    <div class="form-group">                                                                         
									<label class="fancy-checkbox"><input type="checkbox" id="allCheck" onclick="checkAll()">&nbsp;<b>이용약관, 개인정보 수집 및 이용, 위치정보 이용약관에 모두 동의합니다.</b></label>
									<br>
                                    </div>
                                     <jsp:include page="WEB-INF/include/Agree1.jsp"></jsp:include>
                                     <br>
                                     <jsp:include page="WEB-INF/include/Agree2.jsp"></jsp:include>
                                     <br>
                                     <jsp:include page="WEB-INF/include/Agree3.jsp"></jsp:include>

								<br>
								<div class="form-group">
								<div class="row">
								<div class="col-sm-6">
						            <button type="submit" class="btn btn-primary btn-block btn-lg" onclick="location.href='JoinREA.jsp'">Agree</button>
						        </div>
						        <div class="col-sm-6">
						        	 <button type="reset" class="btn btn-primary btn-block btn-lg" onclick="location.href='Main.jsp'">Cancel</button>
						        </div>	
						        </div> 
						        </div>
								<br>
								<br>
                                    <div class="text-center">이미 회원이신가요? <a href="Login_form.jsp">Click here</a></div>

                                    <br> <br> <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End off row-->
                </div>
                <!--End off container -->
        </section>

        <!-- scroll up-->
        <jsp:include page="WEB-INF/include/ScrollUp.jsp"></jsp:include>
        <!-- End off scroll up -->
        <jsp:include page="WEB-INF/include/Bottom.jsp"></jsp:include>
    </div>

    <!-- JS includes -->
    <jsp:include page="./js/js.jsp"></jsp:include>

<script>

</script>
</body>

</html>