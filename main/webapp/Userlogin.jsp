<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User login form</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="custom/css/style.css" />
<!-- Fontawesome CSS CDN -->
</head>
<body class="bg-info bg_custom_color">
	<%-- <%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("user")==null)
		response.sendRedirect("Userlogin.jsp");
%> --%>
	<div class="container">
		<form action="Userlogin" method="post" class="px-3" id="login_form">
			<!-- Login Form Start -->
			<div class="row justify-content-center wrapper" id="login-box">
				<div class="col-lg-10 my-auto myShadow">
					<div class="row">
						<div class="col-lg-7 bg-white p-4">
							<h1 class="text-center font-weight-bold text-primary">Sign
								in to Account</h1>
							<hr class="my-3" />
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"> <i
										class="far fa-envelope fa-lg fa-fw"></i></span>
								</div>
								<input type="text" id="mail" name="email"
									class="form-control rounded-0" placeholder="E-Mail" />

							</div>
							<span id="email_error"></span>
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
										class="fas fa-key fa-lg fa-fw"></i></span>
								</div>
								<input type="password" id="pwd" name="password"
									class="form-control rounded-0" placeholder="Password"
									autocomplete="off" />
							</div>
							<span id="password_error"></span>
							<div class="form-group clearfix">
								<div class="forgot float-right">
									<a href="ForgetPassword.jsp" id="forgot-link">Forgot
										Password?</a>
								</div>
							</div>
							<div class="form-group">
								<input type="submit" id="login-btn" value="Sign In"
									class="btn btn-primary btn-lg btn-block myBtn" />
							</div>
						</div>
						<div
							class="col-lg-5 d-flex flex-column justify-content-center myColor p-4">
							<h1 class="text-center font-weight-bold text-white">Hello
								Friends!</h1>
							<hr class="my-3 bg-light myHr" />
							<p class="text-center font-weight-bolder text-light lead">Enter
								your personal details and start your journey with us!</p>
							<!-- <button class="btn btn-outline-light btn-lg align-self-center font-weight-bolder mt-4 myLinkBtn"
                            id="register-link">Sign Up</button> -->
							<a href="UserRegister.jsp" id="register-link"
								class="btn btn-outline-light btn-lg align-self-center font-weight-bolder mt-4 myLinkBtn">Sign
								Up</a>

						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- jQuery CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="custom/js/customValidation.js"></script>
	<%--  	<%@ include file="footer.jsp" %>  
 --%>
</body>
</html>