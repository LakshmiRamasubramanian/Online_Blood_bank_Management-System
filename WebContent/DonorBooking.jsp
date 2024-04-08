<%@page import="com.obbs.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Donor Booking</title>
<style type="text/css">
body {
	background-image: url("./image/BloodDonation.PNG");
	background-size: cover;
}

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
</style>
</head>
<body>
	<br>
	<form action="logout" method="post" modelAttribute="logout">

		<div align="right">
			<input type="submit" name="logout" class="btnContact2" value="Logout" />
		</div>
	</form>
	<center>
		<h1>Book your slot</h1>
	</center>
	
	<% 
		List<PostBloodRequirementPojo> requirementList = new ArrayList<PostBloodRequirementPojo>();
		requirementList = (ArrayList) request.getAttribute("requirementList");
		List<PostBloodRequirementPojo> compatibilityList = new ArrayList<PostBloodRequirementPojo>();
		compatibilityList = (ArrayList) request.getAttribute("compatibilityList");
		int dId =(int)request.getAttribute("donorId");
		String donorBloodGroup =(String)request.getAttribute("donorBloodGroup");
		
		
		
	%>
	<br>
	<br>
	<%   if(requirementList!=null)
	{
		Iterator itr = requirementList.iterator();
		%>
	<center><h1>Matched Recipients</h1>
		<table class="table table-hover" border='1' cellpadding=10
			align=center>
			<tr bgcolor=#06E9E9>
				<th>ID</th>
				<th>Recipient Name</th>
				<th>Contact Number</th>
				<th>Blood Group</th>
				<th>State</th>
				<th>Area</th>
				<th>PinCode</th>
				<th>HospitalName</th>
				<th>Required Date</th>
				<th>Slot Booking</th>
			</tr>
			<%
				while (itr.hasNext()) {
					PostBloodRequirementPojo requisterPojo = (PostBloodRequirementPojo) itr.next();
			%>
			<tr bgcolor="#F5FEFC">
				<td><%=requisterPojo.getId()%></td>
				<td><%=requisterPojo.getRequisterName()%></td>
				<td><%=requisterPojo.getContactNumber()%></td>
				<td><%=requisterPojo.getBloodGroup()%></td>
				<td><%=requisterPojo.getState()%></td>
				<td><%=requisterPojo.getArea()%></td>
				<td><%=requisterPojo.getPinCode()%></td>
				<td><%=requisterPojo.getHospitalName()%></td>
				<td><%=requisterPojo.getDate()%></td>

				<form:form method="get" action="slotBooking">
					<input type="hidden" name="recipientId"
						value="<%= requisterPojo.getId()%>" />
					<% System.out.println(requisterPojo.getId()); %>
					<input type="hidden" name="recipientName"
						value="<%= requisterPojo.getRequisterName()%>" />
					<input type="hidden" name="hospitalName"
						value="<%= requisterPojo.getHospitalName()%>" />
					<input type="hidden" name="recipientBloodGroup"
						value="<%= requisterPojo.getBloodGroup()%>" />
					<input type="hidden" name="donorId" value="<%=dId%>" />
					<input type="hidden" name="donorBloodGroup"
						value="<%=donorBloodGroup%>" />
					<input type="hidden" name="area"
						value="<%=requisterPojo.getArea()%>" />
					<input type="hidden" name="userMailID"
						value="<%=requisterPojo.getUserMailID()%>" />

					<%System.out.println("Donor booking" +requisterPojo.getUserMailID()); %>

					<input type="hidden" name="requiredDate"
						value="<%=requisterPojo.getDate()%>" />
					<input type="hidden" name="donorName"
						value="<%=session.getAttribute("donorName")%>" />
					<td><center>
							<button class="w3-button w3-teal" name="booking">Booking</button>
						</center></td>

				</form:form>
			</tr>
			<%
				}
			%>
		</table>
	</center>
	<%  } else
	{
		%>
		<h3 align="center" style="color: red">
		<br>
		<%		
	    String message=(String)request.getAttribute("message");
	    if(message !=null)
	    {
	       out.println(message);
	    }%>
	</h3>
	<% } %>
		
	<br>
	<%   if(compatibilityList!=null)
	{
		Iterator iterator =compatibilityList.iterator();
		%>
	<center><h1>Compatible Recipients</h1>
		<table class="table table-hover" border='1' cellpadding=10
			align=center>
			<tr bgcolor=#06E9E9>
				<th>ID</th>
				<th>Recipient Name</th>
				<th>Contact Number</th>
				<th>Blood Group</th>
				<th>State</th>
				<th>Area</th>
				<th>PinCode</th>
				<th>HospitalName</th>
				<th>Required Date</th>
				<th>Slot Booking</th>
			</tr>
			<%
				while (iterator.hasNext()) {
					PostBloodRequirementPojo requisterPojo = (PostBloodRequirementPojo) iterator.next();
			%>
			<tr bgcolor="#F5FEFC">
				<td><%=requisterPojo.getId()%></td>
				<td><%=requisterPojo.getRequisterName()%></td>
				<td><%=requisterPojo.getContactNumber()%></td>
				<td><%=requisterPojo.getBloodGroup()%></td>
				<td><%=requisterPojo.getState()%></td>
				<td><%=requisterPojo.getArea()%></td>
				<td><%=requisterPojo.getPinCode()%></td>
				<td><%=requisterPojo.getHospitalName()%></td>
				<td><%=requisterPojo.getDate()%></td>

				<form:form method="get" action="slotBooking">
					<input type="hidden" name="recipientId"
						value="<%= requisterPojo.getId()%>" />
					<% System.out.println(requisterPojo.getId()); %>
					<input type="hidden" name="recipientName"
						value="<%= requisterPojo.getRequisterName()%>" />
					<input type="hidden" name="hospitalName"
						value="<%= requisterPojo.getHospitalName()%>" />
					<input type="hidden" name="recipientBloodGroup"
						value="<%= requisterPojo.getBloodGroup()%>" />
					<input type="hidden" name="donorId" value="<%=dId%>" />
					<input type="hidden" name="donorBloodGroup"
						value="<%=donorBloodGroup%>" />
					<input type="hidden" name="area"
						value="<%=requisterPojo.getArea()%>" />
					<input type="hidden" name="userMailID"
						value="<%=requisterPojo.getUserMailID()%>" />

					<%System.out.println("Donor booking" +requisterPojo.getUserMailID()); %>

					<input type="hidden" name="requiredDate"
						value="<%=requisterPojo.getDate()%>" />
					<input type="hidden" name="donorName"
						value="<%=session.getAttribute("donorName")%>" />
					<td><center>
							<button class="w3-button w3-teal" name="booking">Booking</button>
						</center></td>

				</form:form>
			</tr>
			<%
				}
			%>
		</table>
	</center>
	<%} %>
		

</body>
</html>