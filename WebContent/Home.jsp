<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
     href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
     rel="stylesheet" id="bootstrap-css">
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
     src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
body {
     background-image: url("./image/BloodDonation.PNG");
     background-size: cover;
     
}


section {
     padding: 100px 0;
}

section .section-title {
     text-align: center;
     margin-bottom: 50px;
     text-transform: uppercase;
}

#tabs {
     
}

#tabs h6.section-title {
     
}

#tabs .nav-tabs .nav-item.show .nav-link, .nav-tabs .nav-link.active {
     border-bottom: 4px solid !important;
     font-size: 20px;
     font-weight: bold;
     font-color: red;
}

#tabs .nav-tabs .nav-link {
     border: 1px solid transparent;
     border-top-left-radius: .25rem;
     border-top-right-radius: .25rem;
     font-size: 20px;
}
h4.thicker {
  font-weight: 1000;
}
</style>
</head>
<body>
     <section id="tabs">
     <div class="container">
           <h6 class="section-title h1">Online blood bank management system</h6>
           <div class="row">
                <div class="col-xs-12 ">
                     <nav>
                     <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                           <a class="nav-item nav-link" 
                           		id="nav-home-tab" 
                           		data-toggle="tab"
                                href="register" 
                                role="tab" 
                                aria-controls="nav-home"
                                aria-selected="true">User Registration</a> 
                          <a class="nav-item nav-link" 
                          		id="nav-profile-tab" 
                          		data-toggle="tab"
                                href="loginUser" 
                                role="tab" 
                                aria-controls="nav-profile"
                                aria-selected="false">User-Sign in</a> 
                          <a class="nav-item nav-link"
                                id="nav-contact-tab" 
                                data-toggle="tab" 
                                href="requirementFetch"
                                role="tab" 
                                aria-controls="nav-contact" 
                                aria-selected="false">Blood Requirement</a> 
                          <a class="nav-item nav-link" 
                          		id="nav-home-tab"
                                data-toggle="tab" 
                                href="feedbackFetch" 
                                role="tab"
                                aria-controls="nav-home" 
                                aria-selected="false">Feedback</a>
                     </div>
                     </nav>
                     <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
                           <div class="tab-pane fade show active" id="nav-home"
                                role="tabpanel" aria-labelledby="nav-home-tab">
                             <h4 >There is always a need for blood donors. Modern medical
                                     care, including surgery and medical treatment for many diseases,
                                     is not possible without the use of blood. A shortage of blood
                                     means that someone may not get prompt, adequate care. Whole blood
                                     is collected from healthy donors who are required to meet strict
                                     criteria concerning: Medical history and Physical health.The
                                     purpose of the blood bank management system is to simplify and
                                     automate the process of searching for blood in case of emergency
                                     and maintain the records of blood donors, recipients and blood
                                     stocks in the bank.</h4>
                           </div>
                           <div class="tab-pane fade" id="nav-profile" role="tabpanel"
                                aria-labelledby="nav-profile-tab"></div>
                           <div class="tab-pane fade" id="nav-contact" role="tabpanel"
                                aria-labelledby="nav-contact-tab"></div>
                           <div class="tab-pane fade" id="nav-about" role="tabpanel"
                                aria-labelledby="nav-about-tab"></div>
                     </div>

                </div>
           </div>
     </div>
     </section>
</body>
</html>
