<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password Form</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" />
<!-- Font awesome CSS CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="custom/css/style.css" />
</head>
<body>
<body class="bg-info bg_custom_color">
	<div class="container">
		<form action="ForgetPasswordServlet" method="post" class="px-3"
			id="forget_form">
			<div class="row justify-content-center wrapper" id="login-box">
				<div class="col-lg-10 my-auto myShadow">
					<div class="row">
						<div class="col-lg-7 bg-white p-4">
							<h1 class="text-center font-weight-bold text-primary">Forgot
								Your Password?</h1>
							<hr class="my-3" />
							<p class="lead text-center text-secondary">To reset your
								password, enter the registered e-mail adddress and set New
								Password!!</p>

							<div id="forgotAlert"></div>
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
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
									class="form-control rounded-0" placeholder="New Password"
									autocomplete="off" />
							</div>
							<span id="password_error"></span>

							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
										class="fas fa-key fa-lg fa-fw"></i></span>
								</div>
								<input type="password" id="cpwd" name="password"
									class="form-control rounded-0" placeholder="Confirm Password"
									autocomplete="off" />
							</div>
							<span id="confirm_password_error"></span>

							<div class="form-group">
								<input type="submit" id="forgot-btn" value="Reset Password"
									class="btn btn-primary btn-lg btn-block myBtn" />
							</div>
						</div>
						<div
							class="col-lg-5 d-flex flex-column justify-content-center myColor p-4">
							<h1 class="text-center font-weight-bold text-white">Reset
								Password!</h1>
							<hr class="my-4 bg-light myHr" />
							<a href="Userlogin.jsp"
								class="btn btn-outline-light btn-lg font-weight-bolder myLinkBtn align-self-center"
								id="back-link">Back</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- Login Form End -->

	</div>
	<!-- jQuery CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="custom/js/customValidation.js"></script>
	<%-- 	<%@ include file="footer.jsp"%>
 --%>
</body>
</html>