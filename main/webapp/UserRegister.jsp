<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controller.UserRegister"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page import="model.User"%>
<%@ page import="model.Address"%>




<%
User user = (User) session.getAttribute("CurrentUser");
String userName = request.getParameter("user");
session.setAttribute("userName", userName);
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet" />
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.3.1/minty/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/3.3.2/select2.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.css">
<!-- Bootstrap -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link href="custom/css/style.css" rel="stylesheet" type="text/css" />

</head>

<body class="bg-info bg_custom_color">
	<c:set var="user" scope="session" value="${sessionScope.CurrentUser}" />
	<c:set var="profile" scope="request"
		value='<%=request.getParameter("user")%>' />

	<div class="container">

		<form action="UserRegister" method="Post" id="registration_form"
			enctype="multipart/form-data">
			<h3 style="text-align: center" class="margin_top_file header_tag">Registration
				Form</h3>
				
			<div class="row form-row">
				<div class="col-md-6">

					<div class="form-group">
						<label for="img">Profile picture:</label><input type="file"
							id="img" name="img" /> <img
							src="custom/image/default_profile.jpg" name="default_img"
							style="width: 170px; height: 170px;" id="default_img"> <img
							src="data:image/jpg;base64,${user.base64Image}"
							id="image_preview" style="display: none" /><br /> <input
							type="hidden" value="${user.base64Image}" name="oldImage">
						<br /> <span id="image_error"></span>
					</div>

				</div>
			</div>

			<div class="row form-row ">
				<div class="col-md-6">
					<!-- First Name -->
					<div class="form-group">
						<label for="fname">Full Name:</label> <input type="text"
							class="form-control text-width" id="name" name="name"
							placeholder="Enter your name" value="${user.userName}" /><span
							id="name_error">${messages.name}</span>
					</div>
				</div>
				<div class="col-md-6">

					<!-- Phone Number -->
					<div class="form-group">
						<label>Contact No:</label> <input type="text" class="form-control"
							id="contact" placeholder="Phone number" name="contact"
							value="${user.userContact}" /> <span id="contact_error">${messages.contact}</span>
					</div>

				</div>
			</div>

			<div class="row form-row">
				<div class="col-md-6">
					<!-- Email  -->
					<div class="form-group">
						<label for="mail">Email:</label> <input type="text"
							class="form-control text-width" id="mail" placeholder="Email-id"
							name="email" value="${user.userEmail}" /> <span id="email_error"></span><br>
						<span id="result"></span>
					</div>
				</div>
				<div class="col-md-6">
					<!-- password -->
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control text-width" id="pwd" placeholder="Password"
							name="password" value="${user.userPassword}" /> <span
							id="password_error">${messages.password}</span>
					</div>
				</div>
			</div>

			<div class="row form-row">

				<!-- Radio btn  -->
				<div class="col-md-6">
					<div class="form-group">
						<label for="id1">Gender:</label><br /> <label
							class="radio-inline radio-class"> <input type="radio"
							name="gender" id="id1" value="female"
							${user.userGender  eq 'female' ? 'checked' : ''} /> Female
						</label><br /> <label class="radio-inline radio-class"> <input
							type="radio" name="gender" id="id2" value="male"
							${user.userGender  eq 'male' ? 'checked' : ''} /> Male
						</label><br /> <span id="radio_error">${messages.gender}</span>
					</div>
				</div>

				<!-- confirm password -->
				<div class="col-md-6">
					<div class="form-group">
						<label for="pwd2">Confirm Password:</label> <input type="password"
							class="form-control text-width" id="cpwd" name="cpassword"
							placeholder="Confirm-Password" value="${user.userPassword}" /> <span
							id="confirm_password_error"></span>
					</div>
				</div>

			</div>

			<div class="row form-row">
				<div class="col-md-6">

					<!-- Hobby -->
					<label>Hobby</label> <br />
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check1"
							name="options" value="Sports"
							${fn:contains(user.userHobby, 'Sports')  ? 'checked' : ''}>
						<label class="form-check-label" for="check1">Sports</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check2"
							name="options" value="Study"
							${fn:contains(user.userHobby, 'Study')  ? 'checked' : ''}>
						<label class="form-check-label" for="check2">Study</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check3"
							name="options" value="Dance"
							${fn:contains(user.userHobby, 'Dance')  ? 'checked' : ''}>
						<label class="form-check-label">Dance</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check4"
							name="options" value="Music"
							${fn:contains(user.userHobby, 'Music')  ? 'checked' : ''}>
						<label class="form-check-label">Music</label> <br /> <span
							id="check_error">${messages.hobby}</span>
					</div>

				</div>
				<div class="col-md-6">
					<!-- image upload -->
					<div class="form-group">
						<label for="fname">Date Of Birth:</label> <input type="date"
							class="form-control text-width" id="dob" name="dob"
							value="${user.userDOB}" /> <span id="dob_error">${messages.dob}</span>
					</div>
				</div>

			</div>
			<!-- jQuery plugin code -->
			<label class="address_label_margin">Address:</label>

			<div class="margin-t-md">
				<div class="customer-form">
					<div class="card"></div>
					<c:choose>
						<c:when
							test="${(profile == 'admin') || (profile == 'userEdit') || (profile == 'adminEdit')}">
							<div id="main-container">
								<c:forEach items="${AddressList}" var="address"
									varStatus="count">
									<div class="panel card container-item">
										<div class="panel-body">
											<div class="panel-body">
												<input type="hidden" name="addressId[]"
													value="${address.addId}">
												<div class="row">
													<div class="col-sm-4">
														<div class="form-group">
															<label class="control-label" for="address_line_one_0">Street</label>
															<input type="text" id="street" class="form-control"
																name="address[]" maxlength="255"
																value="${address.addStreet}"> <span
																id="street_error">${messages.street}</span>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="control-label" for="address_line_two_0">Landmark</label>
															<input type="text" id="landmark" class="form-control"
																name="landmark[]" maxlength="255"
																value="${address.addLandmark}"> <span
																id="landmark_error">${messages.landmark}</span>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="control-label" for="address_line_two_0">Pincode</label>
															<input type="text" id="pincode" class="form-control"
																name="pincode[]" maxlength="255"
																value="${address.addPincode}"> <span
																id="pincode_error">${messages.pincode}</span>
														</div>
													</div>
												</div>
												<div class="row">
													<c:forEach var="item" items="${address.addCity}">
														<div class="col-sm-6">
															<div class="form-group">
																<label class="control-label" for="city_0">City</label> <select
																	class="form-control" name="city[]" id="city"
																	style="height: auto;">
																	<option value="0">Select City</option>
																	<option value="Ahemdabad"
																		${item  eq 'Ahemdabad' ? 'selected' : ''}>Ahemdabad</option>
																	<option value="Junagadh"
																		${item  eq 'Junagadh' ? 'selected' : ''}>Junagadh</option>
																	<option value="Mumbai"
																		${item  eq 'Mumbai' ? 'selected' : ''}>Mumbai</option>
																	<option value="Surat"
																		${item  eq 'Surat' ? 'selected' : ''}>Surat</option>
																	<option value="Vadodara"
																		${address.addCity  eq 'Vadodara' ? 'selected' : ''}>Vadodara</option>
																</select> <span id="city_error">${messages.city}</span>
															</div>
														</div>
													</c:forEach>

													<c:forEach var="item" items="${address.addState}">

														<div class="col-sm-6">
															<div class="form-group">
																<label class="control-label" for="state_0">State</label>
																<select class="form-control" name="state[]" id="state"
																	style="height: auto;">
																	<option value="0">Select State</option>
																	<option value="Gujarat"
																		${item  eq 'Gujarat' ? 'selected' : ''}>Gujarat</option>
																	<option value="Maharashtra"
																		${item eq 'Maharashtra' ? 'selected' : ''}>Maharashtra</option>
																	<option value="Goa" ${item  eq 'Goa' ? 'selected' : ''}>Goa</option>
																	<option value="Punjab"
																		${item  eq 'Punjab' ? 'selected' : ''}>Punjab</option>
																	<option value="Assam"
																		${item  eq 'Assam' ? 'selected' : ''}>Assam</option>
																</select> <span id="state_error">${messages.state}</span>
															</div>
														</div>
													</c:forEach>


												</div>


												<div class="row">
													<div class="col-sm-12">
														<div>
															<a href="javascript:void(0)"
																class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>

							<div>
								<a class="btn btn-success btn-sm" id="add-more"
									href="javascript:;" role="button"><i class="fa fa-plus"></i>
									Add address</a>
							</div>
						</c:when>
						<c:otherwise>
							<div id="main-container">
								<div class="panel card container-item">
									<div class="panel-body">
										<div class="panel-body">

											<div class="row">
												<div class="col-sm-4">
													<div class="form-group">
														<label class="control-label" for="address_line_one_0">Street</label>
														<input type="text" id="street" class="form-control"
															name="address[]" maxlength="255"> <span
															id="street_error">${messages.street}</span>
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group">
														<label class="control-label" for="address_line_two_0">Landmark</label>
														<input type="text" id="landmark" class="form-control"
															name="landmark[]" maxlength="255"> <span
															id="landmark_error">${messages.landmark}</span>
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group">
														<label class="control-label" for="address_line_two_0">Pincode</label>
														<input type="text" id="pincode" class="form-control"
															name="pincode[]" maxlength="255"> <span
															id="pincode_error">${messages.pincode}</span>
													</div>
												</div>
											</div>
											<div class="row">

												<div class="col-sm-6">
													<div class="form-group">
														<label class="control-label" for="city_0">City</label> <select
															class="form-control" name="city[]" id="city"
															style="height: auto;">
															<option value="0">Select City</option>
															<option value="Ahemdabad">Ahemdabad</option>
															<option value="Junagadh">Junagadh</option>
															<option value="Mumbai">Mumbai</option>
															<option value="Surat">Surat</option>
															<option value="Vadodara">Vadodara</option>
														</select> <span id="city_error">${messages.city}</span>
													</div>
												</div>


												<div class="col-sm-6">
													<div class="form-group">
														<label class="control-label" for="state_0">State</label> <select
															class="form-control" name="state[]" id="state"
															style="height: auto;">
															<option value="0">Select State</option>
															<option value="Gujarat">Gujarat</option>
															<option value="Maharashtra">Maharashtra</option>
															<option value="Goa">Goa</option>
															<option value="Punjab">Punjab</option>
															<option value="Assam">Assam</option>
														</select> <span id="state_error">${messages.state}</span>
													</div>
												</div>
											</div>


											<div class="row">
												<div class="col-sm-12">
													<div>
														<a href="javascript:void(0)"
															class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div>
								<a class="btn btn-success btn-sm" id="add-more"
									href="javascript:;" role="button"><i class="fa fa-plus"></i>
									Add address</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>


<c:choose>
<c:when test="${profile == 'userEdit' || profile == 'adminEdit' }">
	<div class="row btn-margin form-row">

				<div class="col-sm-1  submit_btn">

					<input type="submit"
						class="btn btn-default btn-primary register_btn" value="Submit">
				</div>
				<div class="col-sm-2">

					<a href=""
						class="btn btn-default btn-primary cancel">Cancel</a>
				</div>
			</div>
	
</c:when>
<c:otherwise>
<div class="row btn-margin form-row">

				<div class="col-sm-1  submit_btn">

					<input type="submit"
						class="btn btn-default btn-primary register_btn" value="Submit">
				</div>
				<div class="col-sm-2">

					<a href="Userlogin.jsp"
						class="btn btn-default btn-primary btn_hide">Back to login</a>
				</div>
			</div>

</c:otherwise>
</c:choose>
					</form>
	</div>

	<!-- address code ends -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
		
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/3.3.2/select2.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.js"></script>
	<script src="https://cdn.ckeditor.com/4.5.1/standard/ckeditor.js"></script>
	<script src="custom/js/plugin.js" type="text/javascript"></script>
	<script type="text/javascript" src="custom/js/customValidation.js"></script>
	<script type="custom/js/adduser.js"></script>
	<!-- <script type="custom/js/custom.js"></script> -->

	<script>
		$(document).ready(
				function() {

					$("#mail").change(
							function() {
								console.log("change function called");
								var mail = $("#mail").val();
								console.log(mail);
								$.ajax({
									type : 'GET',
									data : {
										email : mail
									},
									url : 'UserRegister',
									success : function(result) {
										console.log("success");
										if (result == "true") {
											console.log("condition true");
											$("#result").html(
													"Email already exist!!")
													.css("color", "red");
											$("#mail").css("border-bottom",
													"4px solid #F90A0A");
											$("#register_btn").prop("disabled",
													true);
										} else {
											console.log("condition false");
											$("#result").html("");
											$("#mail").css("border-bottom",
													"4px solid #34F458");
											$("#register_btn").prop("disabled",
													false);
										}
									}
								});
							});
				});
	</script>
	<script type="text/javascript">
		var parsed = new URL(location);
		var uname = parsed.searchParams.get("user");
		if (uname === 'ADD') {
			$(".btn_hide").hide();
		} else if (uname === 'adminEdit') {
			$(".btn_hide").hide();
			$("#default_img").hide();
			$(".header_tag").text("Update Profile");
			$(".register_btn").prop("value", "Update");
			$("#registration_form").attr("action", "UpdateProfile");
			$("#mail").attr("readonly", "readonly");
			$("#pwd").attr("readonly", "readonly");
			$("#cpwd").attr("readonly", "readonly");
			$("#image_preview").css({
				"display" : "block",
				"max-width" : "170px",
				"max-height" : "170px"
			});
			$(".cancel").attr("href","AdminHomePage.jsp")
		} else if (uname === 'userEdit') {
			$(".btn_hide").hide();
			$("#default_img").hide();
			$(".header_tag").text("Update Profile");
			$(".register_btn").prop("value", "Update");
			$("#registration_form").attr("action", "UpdateProfile");
			$("#mail").attr("readonly", "readonly");
			$("#pwd").attr("readonly", "true");
			$("#cpwd").attr("readonly", "true");
			$("#image_preview").css({
				"display" : "block",
				"max-width" : "170px",
				"max-width" : "170px"
			});
			$(".cancel").attr("href","UserHomePage.jsp")

		} else if (uname === 'admin') {
			$(".btn_hide").hide();
			$("#default_img").hide();
			$(".header_tag").text("Update Profile");
			$(".register_btn").prop("value", "Update");
			$("#registration_form").attr("action", "UpdateProfile");
			$("#mail").attr("readonly", "readonly");
			$("#pwd").attr("readonly", "true");
			$("#cpwd").attr("readonly", "true"); 
			$("#image_preview").css({
				"display" : "block",
				"max-width" : "170px",
				"max-width" : "170px"
			});
			$(".cancel").attr("href","AdminHomePage.jsp")

		}
	</script>
	<jsp:include page="footer.jsp" />
</body>
</html>


