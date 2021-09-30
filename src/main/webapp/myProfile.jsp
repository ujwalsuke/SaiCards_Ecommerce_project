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
  <nav class="navbar navbar-expand-lg navbar-light nav-fill w-100" >
  <div class="container-fluid">
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse w-100" id="navbarNav">
      <ul class="navbar-nav w-100">
      <li class="nav-item px-5" >
          <a class="nav-link"   href="index.jsp">Home</a>
        </li>
        <li style="background-color: blue;" class="nav-item px-5">
          <a Style="color:white" class="nav-link active" aria-current="page" href="#">My Profile</a>
        </li>
        <li class="nav-item px-5" >
          <a class="nav-link" href="cart.jsp" >My Cart</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="myorder.jsp">My order</a>
        </li>
         <li  class="nav-item px-5">
          <a  class="nav-link active" aria-current="page" href="changePassword.jsp">Change Password</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="Logout">Log out</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<div class="container" id="cntrBody">
  <div class="row p-5 shadow my-5 bg-body rounded" >
    <div class="col" align="center">
    <div class="col-md-6">
          <label style="float:left" for="firstName" class="form-label" >First Name</label>
          <input type="text" class="form-control" id="firstName"  name="f_name" value="<%=c.getF_name() %>" disabled>
        </div>
        <div class="col-md-6">
          <label  for="lastName" class="form-label" style="float:left" >Last Name</label>
          <input type="text" class="form-control" id="lastName"  name="l_name" value="<%=c.getL_name() %>" disabled>
        </div>
        <div class="col-md-6">
          <label for="address" class="form-label" style="float:left">Address</label>
          <input type="text" class="form-control" id="address"  name="address" value="<%=c.getAddress() %>" disabled>
        </div>
        <div class="col-md-6">
          <label for="mobNo" class="form-label" style="float:left">Mobile No</label>
          <input type="tel" class="form-control" id="mobNo"  name="mob_no" value="<%=c.getMob_no() %>" disabled>
        </div>
        <div class="col-md-6">
          <label for="email" class="form-label" style="float:left">Email</label>
          <input type="email" class="form-control" id="email" name="email" value="<%=c.getEmail() %>" disabled>
        </div>
        <div class="col-md-6">
          <label for="city" class="form-label" style="float:left">City</label>
          <input type="text" class="form-control" id="city" name="city" value="<%=c.getCity() %>" disabled>
        </div>
        <div class="col-md-6">
          <label for="pincode" class="form-label" style="float:left">Pincode</label>
          <input type="text" class="form-control" id="pincode" name="pincode" value="<%=c.getPincode() %>" disabled>
        </div>
    
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js	"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


  </body>
</html>
<style>

</style>