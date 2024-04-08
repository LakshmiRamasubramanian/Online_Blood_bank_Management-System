<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>No Recipient Found</title>
</head>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background-color: #17a2b8;
	height: 100vh;
}

#login .container #login-row #login-column #login-box {
	margin-top: 120px;
	max-width: 1000px;
	width: 800px;
	height: 520px;
	border: 1px solid #9C9C9C;
	background-color: #EAEAEA;
}

#login .container #login-row #login-column #login-box #login-form {
	padding: 20px;
}

#login .container #login-row #login-column #login-box #login-form #register-link
	{
	margin-top: -85px;
}

.btnContact {
	width: 15%;
	border: none;
	border-radius: 1rem;
	padding: 1.5%;
	background: #17a2b8;
	font-weight: 600;
	color: #fff;
	cursor: pointer;
	align: center;
}

.btnContactSubmit {
	width: 15%;
	border-radius: 1rem;
	padding: 1.5%;
	color: #fff;
	background-color: #0062cc;
	border: none;
	cursor: pointer;
}
</style>
<body>
	<div id="login">
		<%--   <h3 class="text-center text-white pt-5">Login form</h3>--%>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<center>
							<h1>No Record Found</h1>
							<br>
							<form action="logout" method="post" modelAttribute="logout">
		<br>
		
		<div align="center">
			<input type="submit" name="logout" class="btnContact" value="Logout" />
		</div>
	</form>
						</center>
					</div>
				</div>
			</div>
		</div>
</body>
</html>