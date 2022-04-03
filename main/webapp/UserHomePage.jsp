<%@ page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!--  <script type="text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>  -->


<meta charset="ISO-8859-1">
<title>User Home Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="custom/css/style.css">
</head>

<body class="bg_custom_color">
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
				<a class="navbar-brand whitecolor" href="Userlogin.jsp">Home</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!-- <li><a href="#">View Profile<span
							class="sr-only">(current)</span></a> -->
					<li><a href="UserRegister.jsp">Edit Profile<span
							class="sr-only">(current)</span></a>
				</ul>
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
					<th colspan="7" style="text-align: center">User Details</th>
				</tr>

				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Gender</th>
					<th>Hobby</th>
					<th>Profile Picture</th>
					<th>Date of Birth</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${specificUserData}">
					<tr>
						<td>${user.userName}</td>
						<td>${user.userEmail}</td>
						<td>${user.userContact}</td>
						<td>${user.userGender}</td>
						<td>${user.userHobby}</td>
						<td><img src="data:image/jpg;base64,${user.base64Image}"
							width="100" height="100"></td>
						<td>${user.userDOB}</td>
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
	<script src="custom/js/datatable.js"></script>
	<script>
		$(document).ready(
				function() {
					$('#example').DataTable(
							{
								"lengthMenu" : [ [ 3, 5, 7, 10, "All" ],
										[ 3, 5, 7, 10, "All" ] ]
							});
				});
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>