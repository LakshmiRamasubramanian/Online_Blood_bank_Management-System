<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>posted in home</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background-color: #17a2b8;
	height: 100vh;
}

#login .container #login-row #login-column #login-box {
	margin-top: 120px;
	max-width: 600px;
	height: 420px;
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

.btnContactSubmit
{
    width: 10%;
    border-radius: 1rem;
    padding: 1.5%;
    color: #fff;
    background-color: #17a2b8;
    border: none;
    cursor: pointer;
}
.btnContact {
    width: 20%;
    border: none;
    border-radius: 1rem;
    padding: 1.5%;
    background: #17a2b8;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
}

</style>
</head>
<body>
	<center>
		<div id="login">
			<%--   <h3 class="text-center text-white pt-5">Login form</h3>--%>
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="login-column" class="col-md-6">
						<div id="login-box" class="col-md-12">



							<h1>Successfully posted your requirement in HomePage.You
								will get a donor soon!</h1>
							<div align="center">
								<form action="logout" method="post"  modelAttribute="logout">
								<br>
								
	
       <div align="center">
     <input type="submit" name="logout" class="btnContact" value="Logout" />
     </div>
      <br>
       <br>
       <a href="searchDonor" class="btnContact">Search again</a></form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</center>
</body>
</html>
