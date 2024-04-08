<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
	width:800px;
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
</style>
</head>
<body>
	
	<div id="login">
		<%--   <h3 class="text-center text-white pt-5">Login form</h3>--%>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
					<br>
					<center>
		<h5 style="color:red;">
			<%
          String donorMessage=(String)request.getAttribute("d_msg");
      if(donorMessage!=null)
      {
    	  out.println(donorMessage);
      }
      %>
		</h5>
		<h5 style="color:red;">
			<%
          String invalid=(String)request.getAttribute("invalid");
      if(invalid!=null)
      {
    	  out.println(invalid);
      }
      %>
		</h5>
	</center>
						<form:form id="login-form" class="form" method="get"
							action="donorLogin">
							<h3 class="text-center text-info">Donor Login</h3>
							<div class="form-group">
								<label for="email" class="text-info">Email<hi style="color:red;">*</hi> </label><br> <input
									type="email" name="email" id="email" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password<hi style="color:red;">*</hi> </label><br>
								<input type="password" name="password" id="password"
									class="form-control" required>
							</div>
							
							<div class="form-group">
<pre> 
                                          

         <a href="donorRegister" class="btn btn-info btn-md">Register</a>  <input type="submit" name="submit" class="btn btn-info btn-md"value="Login"></form:form>   <a href="home" class="btn btn-info btn-md">Back to Home</a></div></pre>
	</div>					
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>