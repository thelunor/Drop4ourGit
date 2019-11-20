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
        h2 {
            font-family: 'Jua', sans-serif;

        }

        input {
            height: 40px;
        }

        form-control {
            height: 40px;
        }

        .genderbox {
            padding: 1px;
            border: 1px solid #cccccc;
            height: 40px;
        }

        #tdId,
        #tdEmail,
        #tdPw,
        #tdCh {
            font-size: 13px;
            font-family: 'Jua', sans-serif;
            color: #ff6600;
        }

        .form-group input[type="text"],
        input[type="email"],
        input[type="password"] {
            border: 1px solid #e5e5e5;
        }
        /* Center the avatar image inside this container */
		.imgcontainer {
		  text-align: center;
		}		
		/* Avatar image */
		img.avatar {
		  border-radius: 50%;
		}
    </style>

</head>

<body data-spy="scroll" data-target=".navbar-collapse">
    <div class="culmn">
        <!--Home page style-->

        <!-- Top jsp -->
        <nav class="navbar navbar-light navbar-expand-lg  navbar-fixed ivory no-background bootsnav">
            <jsp:include page="./include/Top.jsp"></jsp:include>

            <!-- Side jsp -->
            <jsp:include page="./include/Side.jsp"></jsp:include>
        </nav>
        <!--Login Sections-->

        <section id="join" class="about roomy-100">
            <form action="Join_ok.jsp" method="post" name="loginForm">
                <div class="container">
                    <div class="about_content">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
    						<div class="signup-form">

                                    <br> <br> <br>
                                    <h2 style="text-align: center">공인중개사회원 회원가입</h2>
                                    <br>
                                    <hr>
                                    <div class="form-group" style="text-align : center">
										   <img id="preview" src="images/profile.png" style="width:200px"  alt="Profile">
                                    <br>
                            		<br>
                                     &nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="filename"><br>
                                    </div>     
                                    <br>   
                                    <br> 
                                    <div class="form-group">                                                                         
                                        <label>아이디 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdId"></span></label>
                                        <input type="text" class="form-control" name="User_Id" id="User_Id" required="required">
                                    </div>
                                     <div class="form-group">
                                        <label>비밀번호 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdPw"></span></label>
                                        <input type="password" class="form-control" name="User_Pwd" id="User_Pwd"
                                            required="required" placeholder="영문+숫자 7자 이상">
                                    </div>
                                    <div class="form-group">
                                        <label>비밀번호 확인 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdCh"></span></label>
                                        <input type="password" class="form-control" name="userPassCheck"
                                            id="userPassCheck" required="required" placeholder="영문+숫자 7자 이상">
                                    </div>                                                                       
                                    <div class="form-group">
                                        <label>이름 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdId"></span></label>
                                        <input type="text" class="form-control" name="User_Name" id="User_Name" required="required">
                                    </div>  
                                    <div class="form-group">
                                        <label>휴대폰번호 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdCh"></span></label>
                                        <input type="password" class="form-control" name="userPassCheck"
                                            id="userPassCheck" required="required" placeholder="010-0000-0000">
                                    </div>
                                    <div class="form-group">
                                        <label>사업자등록번호 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdId"></span></label>
                                        <input type="text" class="form-control" name="User_Name" id="User_Name" required="required" placeholder="000-00-00000">
                                    </div>                                     
                                    <div class="form-group">
                                        <label>사무소 이름 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdId"></span></label>
                                        <input type="text" class="form-control" name="Name" id="Name" required="required">
                                    </div>
                                    <div class="form-group">
                                        <label>사무소 전화번호 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdId"></span></label>
                                        <input type="text" class="form-control" name="Name" id="Name" required="required" placeholder="02-0000-0000">
                                    </div>                                                                         
                                    <div class="form-group">
                                        <label>사무소 주소 &nbsp;&nbsp;&nbsp;&nbsp;<span id="tdCh"></span></label>
                                        <input type="text" class="form-control" name="userPassCheck"
                                            id="userPassCheck" required="required" placeholder="기본주소">
                                        <input type="text" class="form-control" name="userPassCheck"
                                            id="userPassCheck" required="required" placeholder="상세주소">                                            
                                    </div>



								<div class="form-group">
								<div class="row">
								<div class="col-sm-6">
						            <button type="submit" class="btn btn-primary btn-block btn-lg">Sign Up</button>
						        </div>
						        <div class="col-sm-6">
						        	 <button type="reset" class="btn btn-primary btn-block btn-lg">Cancel</button>
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
            </form>
        </section>

        <!-- scroll up-->
        <jsp:include page="./include/ScrollUp.jsp"></jsp:include>
        <!-- End off scroll up -->
        <jsp:include page="./include/Bottom.jsp"></jsp:include>
    </div>

    <!-- JS includes -->
    <jsp:include page="./js/js.jsp"></jsp:include>


</body>

</html>