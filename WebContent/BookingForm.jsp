<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.obbs.model.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Slot booking</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	background-color: #17a2b8;
}

.contact-form {
	background-color: #EAEAEA;
	margin-top: 10%;
	margin-bottom: 5%;
	width: 70%;
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
	background-color: #0062cc;
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
</style>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %> 
	<form action="logout" method="post" modelAttribute="logout">
		<br>
		<div align="right">
			<input type="submit" name="logout" class="btnContact2" value="Logout" />
		</div>
	</form>
	<%
              SlotBookingPojo slotFields = (SlotBookingPojo) request.getAttribute("slotBookingPojo");
        
           
       %>
	<form:form method="get" action="confirmSlot">
		<div class="container contact-form">
			<div Class="heading">
				<h3 align="center">Confirm your slot</h3>
			</div>
			</h1>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						Recipient Id <input required class="form-control"
							name="recipientId" placeholder="<%=slotFields.getRecipientId()%>"
							value="<%=slotFields.getRecipientId()%>" readonly>
					</div>
					<div class="form-group">
						Recipient Name <input required class="form-control"
							name="recipientName" placeholder="<%=slotFields.getRecipientName()%>"
							value="<%=slotFields.getRecipientName()%>" readonly>
					</div>
					<div class="form-group">
						Donor Id <input required class="form-control" name="donorId"
							placeholder="<%=slotFields.getDonorId()%>"
							value="<%=slotFields.getDonorId()%>" readonly>
					</div>
					<div class="form-group">
						Donor Name <input required class="form-control" name="donorName"
							placeholder="<%=slotFields.getDonorName()%>"
							value="<%=slotFields.getDonorName()%>" readonly>
					</div>
					<div class="form-group">
						Hospital Name <input required class="form-control"
							name="hospitalName"
							placeholder="<%=slotFields.getHospitalName()%>"
							value="<%=slotFields.getHospitalName()%>" readonly>
					</div>
					
					<div class="form-group">
						Area <input required class="form-control" name="area"
							placeholder="<%=slotFields.getArea()%>"
							value="<%=slotFields.getArea()%>" readonly>
					</div>
						<div class="form-group">
						Required Date<input required class="form-control" name="requiredDate"
							placeholder="<%=slotFields.getRequiredDate()%>"
							value="<%=slotFields.getRequiredDate()%>" readonly>
					</div>
					Date
					<div class="form-group">
						<input class="form-control" name="date" id="date" data-provide="datepicker"
							placeholder="Click here to book the slot" required>
						<script type="text/javascript">
        var date = new Date();
date.setDate(date.getDate());

$('#date').datepicker({ 
    startDate: date
});</script>
<h5 style="color:red;">
<%
if(message!=null){
 out.println(message);
}
%>
</h5>
					</div>
					<div class="form-group">
						Select Time slot<select  class="form-control" id=time name="timeSlot"  required=" required">
						
							<option value="" class="hidden" selected disabled>Select Time Slot*</option>
							<option value="9AM-11AM">9AM-12AM</option>
							<option value="12AM-1PM">12AM-1PM</option>
							<option value="2PM-4PM">2PM-4PM</option>
							<option value="4PM-6PM">4PM-6PM</option>

						</select>

					</div>
					<input type="hidden" name="userMailID"
						value="<%=slotFields.getUserMailID()%>" />
						<%System.out.println( "booking Form " +slotFields.getUserMailID()); %>
							<%System.out.println( "booking Form " +slotFields.getDonorName()); %>
					<div class="form-group">
						<center>
							<input type="submit" name="booking" class="btnContact"
								value="Confirm Your slot" />
						</center>
					</div>
				</div>
			</div>
	</form:form>
</body>
</html>

