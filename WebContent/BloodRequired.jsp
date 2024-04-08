<%@page import="com.obbs.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Blood required</title>
<style type="text/css">
body {
     background-image: url("./image/BloodDonation.PNG");
     background-size: cover;
     
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
</head>
<body>

	
	<% 
  
		List<PostBloodRequirementPojo> requirementList = new ArrayList<PostBloodRequirementPojo>();
		requirementList = (ArrayList) request.getAttribute("requirementList");
		System.out.println(requirementList + "This is the problem");
		Iterator itr = requirementList.iterator();
	%>

	<center>
	
		<br>
		<form method="get" action="home" modelAttribute="home">
			<div align="right">
				<input type="submit" name="home" class="btnContact"
					value="Back to HomePage" />
			</div>
		</form>
		<h3 align="center">List of recipients</h3>
		<table class="table table-hover" border='1' cellpadding=10
			align=center>
			<tr bgcolor=#06E9E9>
				<th scope="col">ID</th>
				<th scope="col">Recipient Name</th>
				<th scope="col">Contact Number</th>
				<th scope="col">Blood Group</th>
				<th scope="col">State</th>
				<th scope="col">Area</th>
				<th scope="col">PinCode</th>
				<th scope="col">HospitalName</th>
				<th scope="col">RequiredDate</th>
			</tr>
			<%
				while (itr.hasNext()) {
					PostBloodRequirementPojo requisterPojo = (PostBloodRequirementPojo) itr.next();
			%>
			<tr bgcolor="#F5FEFC">
				<td scope="row"><%=requisterPojo.getId()%></td>
				<td scope="row"><%=requisterPojo.getRequisterName()%></td>
				<td scope="row"><%=requisterPojo.getContactNumber()%></td>
				<td scope="row"><%=requisterPojo.getBloodGroup()%></td>
				<td scope="row"><%=requisterPojo.getState()%></td>
				<td scope="row"><%=requisterPojo.getArea()%></td>
				<td scope="row"><%=requisterPojo.getPinCode()%></td>
				<td scope="row"><%=requisterPojo.getHospitalName()%></td>
				<td scope="row"><%=requisterPojo.getDate()%></td>

			</tr>
			<%
				}
			%>
		</table>
		<h3>If you want to donate blood, please login or register in the
			below links</h3>
		<br> <br>

		<form method="get" action="donorSignIn" modelAttribute="donorSignIn">
			<div>
				<input type="submit" name="donorSignIn" class="btnContact"
					value="Donor Login" />
			</div>
		</form>
		<br>
		<form method="get" action="donorRegister"
			modelAttribute="donorRegister">
			<div>
				<input type="submit" name="donorRegister" class="btnContact"
					value="Donor Registration" />
			</div>
		</form>

	</center>
	
</body>
</html>