<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
    body {
              font-family: 'Varela Round', sans-serif;
              background :#F5F9F4;
       }
       .modal-confirm {           
              color: #434e65;
              width: 525px;
       }
       .modal-confirm .modal-content {
              padding: 20px;
              font-size: 16px;
              border-radius: 5px;
              border: none;
       }
       .modal-confirm .modal-header {
              background: #e85e6c;
              border-bottom: none;   
        position: relative;
              text-align: center;
              margin: -20px -20px 0;
              border-radius: 5px 5px 0 0;
              padding: 35px;
       }
       .modal-confirm h4 {
              text-align: center;
              font-size: 36px;
              margin: 10px 0;
       }
       .modal-confirm .form-control, .modal-confirm .btn {
              min-height: 40px;
              border-radius: 3px; 
       }
       .modal-confirm .close {
        position: absolute;
              top: 15px;
              right: 15px;
              color: #fff;
              text-shadow: none;
              opacity: 0.5;
       }
       .modal-confirm .close:hover {
              opacity: 0.8;
       }
       .modal-confirm .icon-box {
              color: #fff;        
              width: 95px;
              height: 95px;
              display: inline-block;
              border-radius: 50%;
              z-index: 9;
              border: 5px solid #fff;
              padding: 15px;
              text-align: center;
       }
       .modal-confirm .icon-box i {
              font-size: 58px;
              margin: -2px 0 0 -2px;
       }
       .modal-confirm.modal-dialog {
              margin-top: 80px;
       }
    .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
              background: #eeb711;
              text-decoration: none;
              transition: all 0.4s;
        line-height: normal;
              border-radius: 30px;
              margin-top: 10px;
              padding: 6px 20px;
              min-width: 150px;
        border: none;
    }
       .modal-confirm .btn:hover, .modal-confirm .btn:focus {
              background: #eda645;
              outline: none;
       }
       .trigger-btn {
              display: inline-block;
              margin: 100px auto;
              font-size: 50px;
       }
</style>
<title>Insert title here</title>
</head>
<body>
<div class="text-center">
       <!-- Button HTML (to Trigger Modal) -->
       <a href="#myModal" class="trigger-btn" data-toggle="modal">No Donor Found!!! Please Click Here to Post Your Requirement...</a>
</div>

<!-- Modal HTML -->
<div id="myModal" class="modal fade">
       <div class="modal-dialog modal-confirm">
              <div class="modal-content">
                     <div class="modal-header">
                           <div class="icon-box">
                                  <i class="material-icons">&#xE5CD;</i>
                           </div>
                           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                     </div>
                     <div class="modal-body text-center">
                           <h4>Extremely Sorry!!!</h4>      
                           <p>Do you want to post your requirement??</p>
       <a href="postBloodRequirement"><button class="btn btn-success" >Post Your Requirement</button></a>
                     </div>
              </div>
       </div>
</div>     
</body>
</html>
