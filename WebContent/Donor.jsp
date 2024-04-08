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
.error{color:red}  
</style>
</head>
<body>
       <form:form method="post" action="donorRequests" modelAttribute="donor">
              <div class="container-fluid">
                     <section class="container">
                           <div class="container-page">
                                  <div class="col-md-6">
                                         <h3 class="dark-grey">Donor Registration</h3>

                                         <div class="form-group col-lg-12">
                                                <label>Name</label> <form:input type="text" name="donorName" path="donorName"  
                                                       class="form-control" placeholder="Donor Name *" required="required"/>
                                                       <small>      <form:errors  path="donorName"  cssClass="error"/></small>
                                         </div>

                                         <div class="form-group col-lg-6">
                                                <label>Number</label> <form:input type="number"
                                                       path="contactNumber" name="contactNumber" class="form-control"
                                                       placeholder="Your Phone *"  required="required" />
                                                       <small>      <form:errors  path="contactNumber" cssClass="error"/></small>
                                         </div>
                                         
                                         <div class="form-group col-lg-6">
                                                <label for="job">State</label>
                                                <form:select class="form-control" name="state" path="state" required="required">
                                                       <form:option  value="" class="hidden" >Select the
                                                              state</form:option>
                                                       <%
                                                                     List<StatesPojo> allStates = (List)request.getAttribute("allStates");
                                                                     for(int i=0;i<allStates.size();i++)
                                                                     {
                                                                     
                                                                     %>



                                                       <form:option value="<%=((StatesPojo)allStates.get(i)).getState()%>">

                                                              <%=((StatesPojo)allStates.get(i)).getState()%>

                                                       </form:option>
                                                       <%
                                                                     }
                                                                     %>
                                                </form:select>
                                         <small>      <form:errors  path="state" cssClass="error"/></small>
                                         </div>

                                         <div class="form-group col-lg-6">
                                                <label>Area</label> <form:input type="text" name="area" path="area"
                                                       placeholder="Enter your Area *"  required="required" class="form-control"/>
                                                       <small>      <form:errors  path="area" cssClass="error"/></small>
                                         </div>

                                         <div class="form-group col-lg-6">
                                                <label>Pincode</label> <form:input  placeholder="Enter Your pincode*" 
                                                               class="form-control" name="pinCode"  path="pinCode"
                                                                     type="number" required="required" maxlength="6"  />
                                                              <small><form:errors path="pinCode" cssClass="error"/></small>
                                         </div>
                                         <div class="form-group col-lg-6">
                                                <label>Email</label> <form:input type="email" name="email" path="email"
                                                       class="form-control" placeholder="Enter your Email *"  required="required"/>
                                                       <small>      <form:errors  path="email" cssClass="error"/></small>
                                         </div>
                                         <div class="form-group col-lg-6">
                                                <label>Password</label> <form:password  name="password" path="password"
                                                       class="form-control" placeholder="Enter your Password *"   required="required"/>
                                                       <small>      <form:errors  path="password" cssClass="error"/></small>
                                         </div>

                                         <div class="form-group col-lg-6">

                                                <label for="job">Blood Group</label> <form:select class="form-control"
                                                       path="bloodGroup"  name="bloodGroup" required="required">
                                                       <form:option class="hidden" value="">Select the
                                                              Blood Group</form:option>
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
                                                <small>      <form:errors  path="bloodGroup"  cssClass="error"/></small>
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
