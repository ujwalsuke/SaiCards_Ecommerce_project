<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.saicards.model.Customer" %>
    
<%
	HttpSession session1 = request.getSession();
	Customer c =(Customer) session1.getAttribute("Cust");
	if(c==null){
		response.sendRedirect("login.jsp");
	}
	
	
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://use.fontawesome.com/e49fd5ce0d.js"></script>

    <title>Hello, world!</title>
  </head>
  <body>

<h1 class="text-center pt-5">Bill Details</h1>
<div class="container shadow my-5 bg-body rounded" id="cntrBody">
  <div class="row p-5 " >
    <div class="col" >
    <table class="table table-striped">
  <thead>
    <tr>
      
      <th scope="col">Product Name</th>
      <th scope="col">Qty</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody id="tblBody">
    
</table>
    
    </div>
    <div class="col" >
    	<table class="table">
  
  <tbody>
    <tr>
      
      <td>Name</td>
      <td><%=c.getF_name() %><%=c.getL_name() %></td>
      
    </tr>
    <tr>
      
      <td>Mob No</td>
      <td><%=c.getMob_no() %></td>

    </tr>
    <tr>
      
      <td>Shipping Address</td>
      <td><%=c.getAddress() %>-<%=c.getPincode() %></td>
      
    </tr>
   
  </tbody>
</table>
    </div>
  </div>
  <div class="row p-3" >
  	<div class="col" align="right" ><button onclick="initiatePayment()" class="btn btn-primary px-5" >Place Order</button></div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js	"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="assets/MyJS/billDetail.js"></script>
<script src="assets/MyJS/getCustomer.js"></script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>

  </body>
</html>