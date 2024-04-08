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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Fetching donor details</title>
<style type="text/css">
body {
     background-image: url("./image/BloodDonation.PNG");
     background-size: cover;
     
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
.btnContactSubmit2
{
    width: 10%;
    border-radius: 1rem;
    padding: 1%;
    color: red;
    background-color: red;
    border: none;
    cursor: pointer;
}
.btnContact2{
    width: 10%;
    border: none;
    border-radius: 1rem;
    padding: 1%;
    background: #17a2b8;
    font-weight: 800;
    color:white ;
    cursor: pointer;
}
</style>
</head>
<body>
<form action="logout" method="post"  modelAttribute="logout">
	<br>
       <div align="right">
     <input type="submit" name="logout" class="btnContact2" value="Logout" />
       </div></form>
	
<%
	ArrayList details = (ArrayList) request.getAttribute("details");
		
		ArrayList compatibilityDetails = (ArrayList) request.getAttribute("compatibilityDetails");
		
%>
<%  
if(details!=null)
{
	Iterator itr = details.iterator();
%>
<center><h1>Matched Donors</h1></center>
<center>
<table class="table table-hover" border='2' cellpadding=10 align=center>
 <thead class="thead-dark">
		<tr  bgcolor=#06E9E9>
			<th scope="col"> ID</th>
			<th scope="col"> Name</th>
			<th scope="col"> Blood Group</th>
			<th scope="col">Area</th>
			<th scope="col">State</th>
			<th scope="col">Pincode</th>
			<th scope="col">Contact Number</th>
			
			
		</tr>
</thead>
<tbody>
		<%
			while (itr.hasNext()) {
				DonorPojo pojo = (DonorPojo) itr.next();
		%>
		<tr bgcolor="#F5FEFC">
			
			<td  scope="row"><%=pojo.getId()%></td>
			<td  scope="row"><%=pojo.getDonorName()%></td>
			<td  scope="row"><%=pojo.getBloodGroup()%></td>
			<td  scope="row"><%=pojo.getArea()%></td>
			<td  scope="row"><%=pojo.getState()%></td>
			<td  scope="row"><%=pojo.getPinCode()%></td>
			<td  scope="row"><%=pojo.getContactNumber()%></td>
			</tr>

		<%
			}
		%>
</tbody>
</table>
</center>
<%} 
else
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

	<%  
if(compatibilityDetails!=null)
{
	Iterator iterator = compatibilityDetails.iterator();
%>
	<br><center> <h1>Compatible Donors</h1></center>
	<center>
<table class="table table-hover" border='2' cellpadding=10 align=center>
 <thead class="thead-dark">
		<tr  bgcolor=#06E9E9>
			<th scope="col"> ID</th>
			<th scope="col"> Name</th>
			<th scope="col"> Blood Group</th>
			<th scope="col">Area</th>
			<th scope="col">State</th>
			<th scope="col">Pincode</th>
			<th scope="col">Contact Number</th>
			
			
		</tr>
</thead>
<tbody>
		<%
			while (iterator.hasNext()) {
				DonorPojo pojo = (DonorPojo) iterator.next();
		%>
		<tr bgcolor="#F5FEFC">
			
			<td  scope="row"><%=pojo.getId()%></td>
			<td  scope="row"><%=pojo.getDonorName()%></td>
			<td  scope="row"><%=pojo.getBloodGroup()%></td>
			<td  scope="row"><%=pojo.getArea()%></td>
			<td  scope="row"><%=pojo.getState()%></td>
			<td  scope="row"><%=pojo.getPinCode()%></td>
			<td  scope="row"><%=pojo.getContactNumber()%></td>
			</tr>

		<%
			}
		%>
</tbody>
</table>
</center>
<%} 
%>
	<br>
	
	
<center><h4>These are the donors available for your need. Contact the above mentioned persons and save a life</h4></center>	
<br><br>
       <form action="searchDonor" method="get" >
	
       <div align="center">
     <input type="submit" name="searchDonor" class="btnContact" value="Search again" />
       </div></form>
       <br><br>
        <div align="center">
     <a href="postBloodRequirement" class="btnContact" >Click here to post your requirement</a>
       </div>
</body>
</html>
      
