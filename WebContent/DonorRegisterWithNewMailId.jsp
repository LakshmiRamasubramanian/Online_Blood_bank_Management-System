<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.obbs.model.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration-Donor</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
body {
	background-color: #CFE9F3;
}
</style>
</head>
<body>
<%
   DonorPojo donorPojo = (DonorPojo) request.getAttribute("donorPojo");
System.out.println("age age age check JSP JSP JSP");
System.out.println(donorPojo.getArea());

%>

	<form:form method="post" action="donorRequests">
		<div class="container-fluid">
			<section class="container">
				<div class="container-page">
					<div class="col-md-6">
						<h3 class="dark-grey">Donor Registration</h3>

						<div class="form-group col-lg-12">
							<label>Name</label> <input type="text" name="donorName" pattern="[A-Za-z]{3,50}"
								class="form-control" placeholder="Donor Name *"  value="<%=donorPojo.getDonorName()%>" minlength="3" maxlength="50" required>
						</div>

						<div class="form-group col-lg-6">
							<label>Number</label> <input type="tel" pattern="^\d{10}$"
								name="contactNumber" class="form-control"
								placeholder="Your Phone *"  value="<%=donorPojo.getContactNumber()%>"required />
						</div>
						<br>
						<div class="form-group col-lg-6">
							<label for="job">State</label> <select class="form-control" name="state" required="required">
								<option value="<%=donorPojo.getState()%>" ><%=donorPojo.getState()%></option>
								<%
										List<StatesPojo> allStates = (List)request.getAttribute("allStates");
										for(int i=0;i<allStates.size();i++)
										{
										
										%>



								<option value="<%=((StatesPojo)allStates.get(i)).getState()%>">

									<%=((StatesPojo)allStates.get(i)).getState()%>

								</option>
								<%
										}
										%>
							</select>
						</div>

						<div class="form-group col-lg-6">
							<label>Area</label> <input type="text" name="area"
								placeholder="Enter your Area *"   value="<%=donorPojo.getArea()%>" required class="form-control">
						</div>

						<div class="form-group col-lg-6">
							<label>Pincode</label> <input type="tel" pattern="^\d{6}$"
								name="pinCode" class="form-control"
								placeholder="Enter your PinCode *"  value="<%=donorPojo.getPinCode()%>" required>
						</div>
						<div class="form-group col-lg-6">
							<label>Email</label> <input type="text" name="email"
								class="form-control" placeholder="Enter Your Email *" required>
						</div>
						
                   <p style="color:red;">This mail Id is already exists,Try another one</p>
						<div class="form-group col-lg-6">
							<label>Password</label> <input type="password" name="password"
		class="form-control" placeholder="Enter your Password *" value="<%=donorPojo.getPassword()%>"  minlength="5" maxlength="15" required>
						</div>

						<div class="form-group col-lg-6">

							<label for="job">Blood Group</label>
							 <select class="form-control" name="bloodGroup" required="required">
								<option value="<%=donorPojo.getBloodGroup()%>" ><%=donorPojo.getBloodGroup()%></option>
								<%
										List<BloodGroupPojo> allBloodGroups = (List)request.getAttribute("allBloodGroups");
										for(int i=0;i<allBloodGroups.size();i++)
										{
										
										%>



								<option
									value="<%=((BloodGroupPojo)allBloodGroups.get(i)).getBloodGroup()%>">

									<%=((BloodGroupPojo)allBloodGroups.get(i)).getBloodGroup()%>

								</option>
								<%
										}
										%>
							</select>
						</div>
					</div>

					<div class="col-md-6">
						<h3 class="dark-grey">Terms and Conditions</h3>
						<p>In the days before your donation, eat healthy, iron-rich
							foods such as spinach, red meat, fish, poultry, beans,
							iron-fortified cereals and raisins.</p>
						<p>Get a good night's sleep</p>
						<p>At least 3 hours before donating, eat a balanced meal and
							avoid fatty foods, such as hamburgers, fries, or ice cream.</p>
						<p>Alcoholic beverages lead to dehydration. Try to avoid
							drinking alcohol 24 hours before giving blood. If you do drink
							alcohol, make sure to compensate by drinking extra water.</p>
						<p>After you donate blood, you will be provided with a light
							snack and something to drink.</p>
						<button type="submit" class="btn btn-primary" value="Request">Register</button>
	</form:form>
	<a href="requirementFetch" class="btn btn-primary">Previous page</a>
	</div>
	</div>
	</section>
	</div>

</body>
</html>