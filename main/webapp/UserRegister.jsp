<%@ page import="controller.UserRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%
String username = request.getParameter("name");
String useremail = request.getParameter("email");
String userpassword = request.getParameter("password");
String usercontact = request.getParameter("contact");
String usergender = request.getParameter("gender");
String hobbies = "";
String[] userhobby = request.getParameterValues("options");

if (username != null) {
	session.setAttribute("name", username);
}
if (useremail != null) {
	session.setAttribute("email", useremail);
}
if (userpassword != null) {
	session.setAttribute("password", userpassword);
}
if (usercontact != null) {
	session.setAttribute("contact", usercontact);
}

if (usergender != null) {
	session.setAttribute("gender", usergender);
}
if (userhobby != null) {
	session.setAttribute("hobby", userhobby);
}
%> --%>
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
	<div class="container">

		<form action="UserRegister" method="Post" id="registration_form"
			enctype="multipart/form-data">
			<h3 style="text-align: center" class="margin_top_file">Registration
				Form</h3>
			<div class="row form-row">
				<div class="col-md-6">

					<div class="form-group">
						<label for="img">Profile picture:</label><input type="file"
							id="img" name="img" />
							<img src="custom/image/default_profile.jpg" name="default_img"
							style="width: 170px; height: 170px;" id="default_img"> <img
							id="image_preview" style="max-width: 170px; max-height: 170px;" /><br />
						<span id="image_error">${messages.profile}</span>
					</div>

				</div>
			</div>

			<div class="row form-row ">
				<div class="col-md-6">
					<!-- First Name -->
					<div class="form-group">
						<label for="fname">Full Name:</label> <input type="text"
							class="form-control text-width" id="name" name="name"
							placeholder="Enter your name" /><span id="name_error">${messages.name}</span>
					</div>
				</div>
				<div class="col-md-6">

					<!-- Phone Number -->
					<div class="form-group">
						<label>Contact No:</label> <input type="text" class="form-control"
							id="contact" placeholder="Phone number" name="contact" /> <span
							id="contact_error">${messages.contact}</span>
					</div>

				</div>
			</div>

			<div class="row form-row">
				<div class="col-md-6">
					<!-- Email  -->
					<div class="form-group">
						<label for="mail">Email:</label> <input type="text"
							class="form-control text-width" id="mail" placeholder="Email-id"
							name="email" /> <span id="email_error">${messages.email}</span>
					</div>
				</div>
				<div class="col-md-6">
					<!-- password -->
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control text-width" id="pwd" placeholder="Password"
							name="password" /> <span id="password_error">${messages.password}</span>
					</div>
				</div>
			</div>

			<div class="row form-row">

				<!-- Radio btn  -->

				<div class="col-md-6">
					<div class="form-group">
						<label for="id1">Gender:</label><br /> <label
							class="radio-inline radio-class"> <input type="radio"
							name="gender" id="id1" value="female" /> Female
						</label><br /> <label class="radio-inline radio-class"> <input
							type="radio" name="gender" id="id2" value="male" /> Male
						</label><br /> <span id="radio_error">${messages.gender}</span>
					</div>
				</div>
				<!-- confirm password -->
				<div class="col-md-6">
					<div class="form-group">
						<label for="pwd2">Confirm Password:</label> <input type="password"
							class="form-control text-width" id="cpwd" name="cpassword"
							placeholder="Confirm-Password" /> <span
							id="confirm_password_error"></span>
					</div>
				</div>

			</div>

			<div class="row form-row">
				<div class="col-md-6">
					<!-- Hobby -->
					<label>Hobby</label><br />

					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check1"
							name="options" value="Sports"> <label
							class="form-check-label" for="check1">Sports</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check2"
							name="options" value="Study"> <label
							class="form-check-label" for="check2">Study</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check3"
							name="options" value="Dance"> <label
							class="form-check-label">Dance</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="check4"
							name="options" value="Music"> <label
							class="form-check-label">Music</label> <br /> <span
							id="check_error">${messages.hobby}</span>
					</div>
				</div>
				<div class="col-md-6">
					<!-- image upload -->
					<div class="form-group">
						<label for="fname">Date Of Birth:</label> <input type="date"
							class="form-control text-width" id="dob" name="dob" /> <span
							id="dob_error">${messages.dob}</span>
					</div>
				</div>

			</div>
			<!-- jQuery plugin code -->
			<label class="address_label_margin">Address:</label>

			<!-- <div class="container" style="margin: 150px auto"> -->
			<div class="margin-t-md">
				<div class="customer-form">
					<div class="card"></div>

					<!-- 					<form action="#" method="post" role="form" autocomplete="off">
 -->
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
													<option value="Madhya Pradesh">Madhya Pradesh</option>
													<option value="West Bengal">West Bengal</option>
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
						<div>
							<a class="btn btn-success btn-sm" id="add-more"
								href="javascript:;" role="button"><i class="fa fa-plus"></i>
								Add address</a>
						</div>
					</div>
										
				</div>
			</div>

			<div class="row btn-margin form-row">
				<div class="col-sm-1  submit_btn">

					<input type="submit" class="btn btn-default btn-primary"
						value="Submit">
				</div>
				<div class="col-sm-2">

					<a href="Userlogin.jsp" class="btn btn-default btn-primary">Back
						to login</a>
				</div>
			</div>
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
	<script type="text/javascript" src="custom/js/validation.js"></script>
	<!-- <script>
		$('a#add-more').cloneData({
			mainContainerId : 'main-container', // Main container Should be ID
			cloneContainer : 'container-item', // Which you want to clone
			removeButtonClass : 'remove-item', // Remove button for remove cloned HTML
			removeConfirm : true, // default true confirm before delete clone item
			removeConfirmMessage : 'Are you sure want to delete?', // confirm delete message
			//append: '<a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>', // Set extra HTML append to clone HTML
			minLimit : 1, // Default 1 set minimum clone HTML required
			/* 			maxLimit : 5, // Default unlimited or set maximum limit of clone HTML
			 */
			defaultRender : 1,
			afterRender: function() {
                console.info(':: After rendered callback called'); // Return clone object
            },
		});
	</script>
 -->	<jsp:include page="footer.jsp" />

</body>
</html>


