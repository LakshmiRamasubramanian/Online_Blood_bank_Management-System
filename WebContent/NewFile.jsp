<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.obbs.model.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post requirement</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
body {
	background-color: #17a2b8;
}

.contact-form {
	background-color: #EAEAEA;
	margin-top: 10%;
	margin-bottom: 5%;
	width: 70%;
	align: center;
}

.contact-form .form-control {
	border-radius: 1rem;
}

.contact-image {
	text-align: center;
}

.contact-image img {
	border-radius: 6rem;
	width: 11%;
	margin-top: -3%;
	transform: rotate(29deg);
}

.contact-form form {
	padding: 14%;
}

.contact-form form .row {
	margin-bottom: -7%;
}

.contact-form h3 {
	margin-bottom: 8%;
	margin-top: -10%;
	text-align: center;
	color: #17a2b8;
}

.contact-form .btnContact {
	width: 50%;
	border: none;
	border-radius: 1rem;
	padding: 1.5%;
	background-color: #17a2b8;
	font-weight: 600;
	color: #fff;
	cursor: pointer;
}

.btnContactSubmit {
	width: 50%;
	border-radius: 1rem;
	padding: 1.5%;
	color: #fff;
	background-color: #17a2b8;
	border: none;
	cursor: pointer;
}

.btnContactSubmit2 {
	width: 10%;
	border-radius: 1rem;
	padding: 1%;
	color: red;
	background-color: red;
	border: none;
	cursor: pointer;
}

.btnContact2 {
	width: 10%;
	border: none;
	border-radius: 1rem;
	padding: 1%;
	background: white;
	font-weight: 800;
	color: #17a2b8;
	cursor: pointer;
}
.error {
	color: red
}
</style>
</head>
<body>
	<form action="logout" method="post" modelAttribute="logout">
		<br>
		<div align="right">
			<input type="submit" name="logout" class="btnContact2" value="Logout" />
		</div>
	</form>
	<form:form method="get" action="insertBloodRequirement" modelAttribute="requisterPojo">
		<div class="container contact-form">
			<div Class="heading">
				<h3 align="center">Post Your Blood Requirement</h3>
			</div>
			</h1>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
										<form:input class="form-control" name="requisterName"
											path="requisterName" placeholder="Requister Name *" type="text"
											required="required" />
										<small><form:errors path="requisterName" cssClass="error" /></small>
									</div>
					<div class="form-group">
						<form:input class="form-control"  type="number"
							name="contactNumber" path="contactNumber" placeholder="Contact Number *" required="required"/>
							<small><form:errors path="contactNumber" cssClass="error" /></small>
					</div>
					<div class="form-group">

						<form:select class="form-control"  name="state" path="state" required="required">
							<form:option value="" class="hidden">Select
								the state</form:option>
							<%
								List<StatesPojo> allStates = (List) request.getAttribute("allStates");
									for (int i = 0; i < allStates.size(); i++) {
							%>



							<form:option value="<%=((StatesPojo) allStates.get(i)).getState()%>">

								<%=((StatesPojo) allStates.get(i)).getState()%>

							</form:option>
							<%
								}
							%>
						</form:select>
					</div>
					<div class="form-group">
						<form:input  class="form-control" type="text" name="area" path="area"
							placeholder="Enter your Area *" required="required"/>
					</div>

					<div class="form-group">
						<form:input  class="form-control" type="number" 
							name="pinCode" path="pinCode" placeholder="Enter your PinCode *" required="required"/>
							<small><form:errors path="pinCode" cssClass="error" /></small>
							
					</div>


					<div class="form-group">
						<form:select class="form-control" name="bloodGroup" path="bloodGroup" required="required">
							<form:option value="" class="hidden" >Select
								the Blood Group</form:option>
							<%
								List<BloodGroupPojo> allBloodGroups = (List) request.getAttribute("allBloodGroups");
									for (int i = 0; i < allBloodGroups.size(); i++) {
							%>



							<form:option
								value="<%=((BloodGroupPojo) allBloodGroups.get(i)).getBloodGroup()%>">

								<%=((BloodGroupPojo) allBloodGroups.get(i)).getBloodGroup()%>

							</form:option>
							<%
								}
							%>
						</form:select>

					</div>

					<div class="form-group">
						<form:select name="hospitalName" path="hospitalName" class="form-control"
							required="required">
							<form:option value="" class="hidden">Select
								the Hospital</form:option>
							<%
								List<HospitalPojo> allHospitals = (List) request.getAttribute("allHospitals");
									for (int i = 0; i < allHospitals.size(); i++) {
							%>



							<form:option
								value="<%=((HospitalPojo) allHospitals.get(i)).getHospitalName()%>">

								<%=((HospitalPojo) allHospitals.get(i)).getHospitalName()%>

							</form:option>
							<%
								}
							%>
						</form:select>
					</div>
					
				<div class="form-group">

						<pre>
<input type="submit" name="Post your requirement" class="btnContact"
								value="Post your requirement" />       <a href="searchDonor"
								class="btnContact">Search again</a>
						</pre>
					</div>
				</div>
			</div>
	</form:form>


</body>
</html>