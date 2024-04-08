<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.obbs.model.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	background: #17a2b8;
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

.btnContactSubmit {
	width: 10%;
	border-radius: 1rem;
	padding: 1%;
	color: red;
	background-color: red;
	border: none;
	cursor: pointer;
}

.btnContact {
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

<title>Donor search form</title>
</head>
<body>
<br>
<br>
<form:form method="get" action="inbox">
<div align="right">
			<input class="btnContact" type="submit" name="inbox" value="Inbox" />
		</div>
		</form:form>	
	<form action="logout" method="post" modelAttribute="logout">
		<br>
		
		<div align="right">
			<input type="submit" name="logout" class="btnContact" value="Logout" />
		</div>
	</form>
	<center>
		<h3 style="color: red;">
			<%
				String message = (String) request.getAttribute("donornotfound");
				if (message != null) {
			%>
			<a href="postBloodRequirement" style="color: white"> <%
 	out.println(message);
 	}
 %>
			</a>
		</h3>
	</center>
	<form:form method="get" action="recipientRequests"
		modelAttribute="recipient">
		<div class="container contact-form">
			<h3>Search for donor availability</h3>
			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<input type="text" name="area" class="form-control"
							placeholder="Enter the area *" value="" required />
					</div>



					<div class="form-group">
						<select class="form-control" name="bloodGroup" required>
							<option value="">Select the
								Blood Group</option>
							<%
								List<BloodGroupPojo> allBloodGroups = (List) request.getAttribute("allBloodGroups");
									System.out.println("jsp:" + allBloodGroups);
									for (int i = 0; i < allBloodGroups.size(); i++) {
							%>

							<option
								value="<%=((BloodGroupPojo) allBloodGroups.get(i)).getBloodGroup()%>">

								<%=((BloodGroupPojo) allBloodGroups.get(i)).getBloodGroup()%>

							</option>
							<%
								}
							%>
						</select>
					</div>
					
					<div class="form-group">
						<pre>  
                  <input type="submit" name="submit" class="btnContact"
								value="Search">
	
	</form:form>
	</pre>
	</div>

	</div>
</body>
</html>