<%@ page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User Data</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<!-- <link
	href="https://cdn.datatables.net/responsive/2.2.9/css/dataTables.responsive.css"> -->

<link
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="custom/css/style.css" rel="stylesheet">
<style type="text/css">
.switch {
	position: relative;
	display: inline-block;
	width: 50px;
	height: 25px;
}

.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 20px;
	width: 20px;
	left: 4px;
	bottom: 3px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196F3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}

.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}
</style>


</head>
<body class="all_page_background">
	<%-- <jsp:include page="header.jsp" /> --%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="AdminHomePage.jsp">Admin</a> <a
					class="navbar-brand content-center">User Management System</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Userlogin.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<table id="example"
			class="table table-striped table-bordered table_css">
			<thead>
				<tr>
					<th colspan="9" style="text-align: center">User Details</th>
				</tr>

				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Gender</th>
					<th>Hobby</th>
					<th>Profile Picture</th>
					<th>Date of Birth</th>
					<th>Edit/Delete</th>
					<th>Role</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.userName}</td>
						<td>${user.userEmail}</td>
						<td>${user.userContact}</td>
						<td>${user.userGender}</td>
						<td>${user.userHobby}</td>
						<td><img src="data:image/jpg;base64,${user.base64Image}"
							width="100" height="100"></td>
						<td>${user.userDOB}</td>
						<td><a href="AdminEdit?userId=${user.userId}"><i
								class="fa fa-pencil-square-o fa-lg " aria-hidden="true"></i></a>
							&nbsp;&nbsp;<a id="${user.userId}" class="delete"><i
								class="fa fa-trash fa-lg " aria-hidden="true"></i></a></td>
						<td>
							<!-- Default switch -->
							<div class="custom-control custom-switch">
								<label class="switch"> <input type="checkbox"
									class="role_admin" id="${user.userId}"> <span
									class="slider round"></span>
								</label>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	<!-- <script src="custom/js/datatable.js"></script>
 -->
	<!-- 	<script src="custom/js/change_role.js"></script>
 -->
	<script>
		$(document).ready(function() {
			
			$('#example').DataTable({
				"lengthMenu": [[3, 5, 7, 10, "All"], [3, 5, 7, 10, "All"]]
			});
			
			$(document).on("click", ".delete", function() {

				var rowToDelete = this;
				var userId = +this.id;
				$.ajax({
					url : "DeleteUser",
					type : "post",
					data : ({
						userId : userId,
					}),
					success : function(data) {
						alert("sucess");
						$(rowToDelete).closest('tr').fadeOut(100, function() {
							$(this).remove();
						});
					}
				});
			});
			
			$(document).on("change",".role_admin" , function() {

				var rowToDelete = this;
				var trid = +this.id;
				$.ajax({
					url : "ChangeRole",
					type : "post",
					data : ({
						trid : trid,
					}),
					success : function(data) {
						alert("sucess");
						$(rowToDelete).closest('tr').fadeOut(100, function() {
							$(this).remove();
						});
					}
				})
			});

		});
	</script>
	<jsp:include page="footer.jsp" />
</body>
</html>