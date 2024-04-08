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
<title>Fetching feedback details</title>

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
</style>
</head>
<body>
<br>

<%
          String message=(String)request.getAttribute("message");
      if(message!=null)
      {%>
 <h1> <center>   <% out.println(message);%></center></h1>
      <br>
      <form method="get" action="home" modelAttribute="home">
                <div align="right">
                     <input type="submit" name="home" class="btnContact" value="Back to home" />
                </div>
           </form>
    <% }
      else
      {%>
      
	<form action="home" method="get"  modelAttribute="homepage">
	
	<div align="right">
     <input type="submit" name="home" class="btnContact" value="Back to homepage" />
       </div>
       </form>
       <br>
       
      <%
     ArrayList details = (ArrayList) request.getAttribute("details");
           Iterator itr = details.iterator();
%>
<table class="table table-hover" border='2' cellpadding=10 align=center>
 <thead class="thead-dark">
		<tr  bgcolor=#06E9E9>
                <th scope="col"> ID</th>
                <th scope="col"> Name</th>
                <th scope="col"> Hospital Name</th>
                <th scope="col">City</th>
                <th scope="col">Feedback</th>
                
                
                
           </tr>
</thead>
<tbody>
           <%
                while (itr.hasNext()) {
                     FeedbackPojo feedbackPojo = (FeedbackPojo) itr.next();
           %>
          <tr bgcolor="#F5FEFC">
                <td  scope="row"><%=feedbackPojo.getId()%></td>
                <td  scope="row"><%=feedbackPojo.getName()%></td>
                <td  scope="row"><%=feedbackPojo.getHospitalName()%></td>
                <td  scope="row"><%=feedbackPojo.getCity()%></td>
                <td  scope="row"><%=feedbackPojo.getFeedback()%></td>
                
                </tr>

           <%
                }
           %>
</tbody>
</table>
<%} %>
</body>
</html>