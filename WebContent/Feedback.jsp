<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.obbs.model.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<titl>Feedback
</title>
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
.btnContact2 {
     width: 10%;
     border: none;
     border-radius: 1rem;
     padding: 1%;
     background-color:#fff;
     font-weight: 600;
     color:  #17a2b8;
     cursor: pointer;
}
</style>
</head>
<body>

     <form action="logout" method="post" modelAttribute="logout">
           <div align="right">
                <input type="submit" name="logout" class="btnContact2" value="Logout" />
           </div>
     </form>
     
           <form:form method="get" action="feedback">
                <div class="container contact-form">
                <div Class="heading">
                     <h3 align="center">Enter Your Feedback</h3>
                </div>
                </h1>
                <div class="row">
                     <div class="col-md-6">
                           <div class="form-group">
                                <input required class="form-control" type="text" name="name" placeholder="<%=session.getAttribute("donorName")%>" 
                                value="<%=session.getAttribute("donorName")%>" readonly>
                           </div>

                           <div class="form-group">

                             <input required class="form-control" type="text" name="hospitalName" 
                             placeholder="<%=session.getAttribute("hospitalName")%>" value="<%=session.getAttribute("hospitalName")%>"  readonly>
                           </div>
                           <div class="form-group">
                                <input required class="form-control" type="text" name="city"
                                     placeholder="<%=session.getAttribute("area")%>" value="<%=session.getAttribute("area")%>" readonly>
                           </div>
                           Enter your feedback :
                           <div class="form-group">
                                <textarea rows="5" cols="50" name="Feedback" required>
         </textarea>
                           </div>
                           <div class="form-group">
                                <center>
                <input type="submit" class="btnContact" value="Submit" />

                                </center>
                           </div>
     </div>
     </div>
     </form:form>

</body>
</html>


