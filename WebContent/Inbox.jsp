<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>
<%@page import="com.obbs.entity.*"%>
<%@page import="com.obbs.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Fetching donor details</title>
<style>
.btnContactSubmit {
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
	background: #17a2b8;
	font-weight: 800;
	color: white;
	cursor: pointer;
}
body {
     background-image: url("./image/BloodDonation.PNG");
     background-size: cover;
     
}
</style>
</head>
<body>
	<br>
	<br>
	<form action="logout" method="post" modelAttribute="logout">
		<br>
		<div align="right">
			<input type="submit" name="logout" class="btnContact2" value="Logout" />
		</div>
	</form>
	<br>
	<center><h3>Slot Confirmation Details</h3></center>
	<br>
	<%
	ArrayList details = (ArrayList) request.getAttribute("details");
		Iterator itr = details.iterator();
%>
	<table class="table table-hover" border='2' cellpadding=10 align=center>
		<thead class="thead-dark">
			<tr bgcolor=#06E9E9>
				<th scope="col">Recipient ID</th>
				<th scope="col">Recipient Name</th>
				<th scope="col">Donor ID</th>
				<th scope="col">Donor Name</th>
				<th scope="col">Donor Contact Number</th>
				<th scope="col">Hospital Name</th>
				<th scope="col">Area</th>
				<th scope="col">Booking Date</th>
				<th scope="col">Time Slot</th>

			</tr>
		</thead>
		<tbody>
			<%
			while (itr.hasNext()) {
				SlotBookingPojo pojo = (SlotBookingPojo) itr.next();
		%>
			<tr bgcolor="#F5FEFC">

				<td scope="row"><%=pojo.getRecipientId()%></td>
				<td scope="row"><%=pojo.getRecipientName()%></td>
				<td scope="row"><%=pojo.getDonorId()%></td>
				<td scope="row"><%=pojo.getDonorName()%></td>
				<td scope="row"><%=pojo.getContactNumber()%></td>
				<td scope="row"><%=pojo.getHospitalName()%></td>
				<td scope="row"><%=pojo.getArea()%></td>
				<td scope="row"><%=pojo.getDate()%></td>
				<td scope="row"><%=pojo.getTimeSlot()%></td>

			</tr>

			<%
			}
		%>
		</tbody>
	</table>

	<br>
	<br>
	<form action="searchDonor" method="get">

		<div align="center">
			<input type="submit" name="searchDonor" class="btnContact"
				value="Search Donor" />
		</div>
	</form>
</body>
</html>