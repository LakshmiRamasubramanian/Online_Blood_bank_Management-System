<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.obbs.model.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recipient Registration</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<style type="text/css">
.register {
	background: -webkit-linear-gradient(left, #3931af, #00c6ff);
	margin-top: 3%;
	padding: 3%;
}

.register-left {
	text-align: center;
	color: #fff;
	margin-top: 4%;
	background: #CFE9F3;
}

.register-left input {
	float: center;
	margin-top: 10%;
	border: none;
	border-radius: 1.5rem;
	padding: 2%;
	background: #0062cc;
	color: #fff;
	font-weight: 600;
	width: 50%;
	cursor: pointer;
}

.register-right {
	background: #CFE9F3;
	border-top-left-radius: 10% 50%;
	border-bottom-left-radius: 10% 50%;
}

@
-webkit-keyframes mover { 0% {
	transform: translateY(0);
}

100%
{
transform






:







translateY






(-20
px




);
}
}
@
keyframes mover { 0% {
	transform: translateY(0);
}

100%
{
transform






:







translateY






(-20
px




);
}
}
h3 {
	text-align: center;
	color: Black;
	font-size: 250%;
}

.register-left p {
	text-align: center;
	color: #C71585;
	font-size: 200%;
}

.register .register-form {
	padding: 10%;
	margin-top: 10%;
}

.btnRegister {
	float: right;
	margin-top: 10%;
	border: none;
	border-radius: 1.5rem;
	padding: 2%;
	background: #0062cc;
	color: #fff;
	font-weight: 600;
	width: 50%;
	cursor: pointer;
}

.register .nav-tabs {
	margin-top: 3%;
	border: none;
	background: #0062cc;
	border-radius: 1.5rem;
	width: 28%;
	float: right;
}

.register .nav-tabs .nav-link {
	padding: 2%;
	height: 34px;
	font-weight: 600;
	color: #fff;
	border-top-right-radius: 1.5rem;
	border-bottom-right-radius: 1.5rem;
	cursor: default;
}

.register .nav-tabs .nav-link:hover {
	border: none;
}

.register .nav-tabs .nav-link.active {
	width: 100px;
	color: #0062cc;
	border: 2px solid #0062cc;
	border-top-left-radius: 1.5rem;
	border-bottom-left-radius: 1.5rem;
}

.register-heading {
	text-align: center;
	margin-top: 8%;
	margin-bottom: -15%;
	color: #C71585;
}

.btnContact {
	width: 7%;
	border: none;
	border-radius: 1rem;
	padding: 0.75%;
	background: #0062cc;
	font-weight: 600;
	color: white;
	cursor: pointer;
}

.btnContactSubmit {
	width: 15%;
	border-radius: 1rem;
	padding: 0.75%;
	color: #fff;
	background-color: #0062cc;
	border: none;
	cursor: pointer;
}

.error {
	color: red
}
</style>
	<meta charset="ISO-8859-1">
	<title>Register user</title>
</head>
<body>
	<br>

	<form method="get" action="home" modelAttribute="home">
		<div align="right">
			<input type="submit" name="home" path="home" class="btnContact"
				value="Back to home" />
		</div>
	</form>
	<form:form method="get" action="registerUser"
		modelAttribute="registerUsers">
		<div class="container register">
			<div class="row">
				<div class="col-md-3 register-left">
					<center>
						<br> <br> <br> <br> <br>
						<h3>Welcome!</h3>
						<p>Register here to enroll you as a recipient.</p>
				</div>
				</center>
				<div class="col-md-9 register-right">
					<ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">Recipient</a></li>

					</ul>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<h3 class="register-heading">Registration Form</h3>
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<form:input class="form-control" name="firstName"
											path="firstName" placeholder="First Name *" type="text"
											required="required" />
										<small><form:errors path="firstName" cssClass="error" /></small>
									</div>
									<div class="form-group">
										<form:input class="form-control" name="lastName"
											path="lastName" placeholder="Last Name *" type="text"
											required="required" />
										<small> <form:errors path="lastName" cssClass="error" /></small>
									</div>
									<div class="form-group">
										<form:password class="form-control" name="password"
											path="password" placeholder="Password *" required="required" />

										<small><form:errors path="password" cssClass="error" /></small>
									</div>

									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <form:radiobutton
													name="gender" path="gender" value="male" /> <span>
													Male </span>
											</label> <label class="radio inline"> <form:radiobutton
													name="gender" path="gender" value="female" /> <span>Female
											</span>
											</label> <small> <form:errors path="gender" cssClass="error" /></small>
										</div>
										<div class="form-group">
											<form:input name="contactNumber" path="contactNumber"
												maxlength="10" class="form-control"
												placeholder="Your Phone *" type="number" required="required"/>

											<small> <form:errors path="contactNumber"
													cssClass="error" /></small>
										</div>
										<div class="form-group">
											<form:input class="form-control"
												placeholder="Enter Your Weight *" type="number"
												name="weight" path="weight" required="required" />
											<small> <form:errors path="weight" cssClass="error" /></small>
										</div>

									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<form:input type="email" class="form-control"
											placeholder="Your Email *" name="email" path="email" />
										<small> <form:errors path="email" cssClass="error"
												required="required" /></small>
									</div>

									<div class="form-group">

										<form:select class="form-control" name="state" path="state"
											required="required">
											<form:option value="" class="hidden">Select the
                                                                                  state*</form:option>
											<%
                                                                     List<StatesPojo> allStates = (List)request.getAttribute("allStates");
                                                                     for(int i=0;i<allStates.size();i++)
                                                                     {
                                                                     
                                                                     %>



											<form:option
												value="<%=((StatesPojo)allStates.get(i)).getState()%>">

												<%=((StatesPojo)allStates.get(i)).getState()%>

											</form:option>
											<%
                                                                     }
                                                                     %>
										</form:select>
										<small> <form:errors path="state" cssClass="error" /></small>
									</div>
									<div class="form-group">
										<form:input type="text" class="form-control" name="area"
											path="area" placeholder="Enter Your Area *"
											required="required" />
										<small><form:errors path="area" cssClass="error" /></small>
									</div>
									<div class="form-group">
										<form:input placeholder="Enter Your pincode*"
											class="form-control" name="pinCode" path="pinCode"
											type="number" required="required" maxlength="6" />
										<small><form:errors path="pinCode" cssClass="error" /></small>
									</div>
									<div class="form-group">
										<form:select class="form-control" name="bloodGroup"
											path="bloodGroup" required="required">
											<form:option value="" class="hidden">Select the
                                                                                  Blood Group*</form:option>
											<%
                                                                     List<BloodGroupPojo> allBloodGroups = (List)request.getAttribute("allBloodGroups");
                                                                     for(int i=0;i<allBloodGroups.size();i++)
                                                                     {
                                                                     
                                                                     %>
											<form:option
												value="<%=((BloodGroupPojo)allBloodGroups.get(i)).getBloodGroup()%>">

												<%=((BloodGroupPojo)allBloodGroups.get(i)).getBloodGroup()%>

											</form:option>
											<%
                                                                     }
                                                                     %>
										</form:select>
										<small> <form:errors path="bloodGroup"
												cssClass="error" /></small>
									</div>
									<div class="form-group">
										<form:input type="number" class="form-control" name="age"
											path="age" placeholder="Enter Your Age *" required="required" />
										<small> <form:errors path="age" cssClass="error" /></small>
									</div>

									<input type="submit" class="btnRegister" value="Register" />

								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		</div>

	</form:form>
</body>
</html>
