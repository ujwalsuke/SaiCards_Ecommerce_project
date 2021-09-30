<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.saicards.model.Customer" %>
    
<%
	HttpSession session1 = request.getSession();
	Customer c =(Customer) session1.getAttribute("Cust");
	
%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
   <nav class="navbar navbar-expand-lg navbar-light" style="background-repeat: no-repeat;background-size: cover;background-image: url('assets/image/regimage.jpg');border-style: solid;border-width: 1px;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SaiCards</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item px-5">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="#">About Us</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="cart.jsp">Cart</a>
        </li>
        <%if(c!=null){ %>
        <li class="nav-item px-5">
          <a class="nav-link" href="#">hello<%=c.getF_name() %></a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="myProfile.jsp">My Account</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="Logout">logout</a>
        </li>
        <%}else{ %>
         <li class="nav-item px-5">
          <a class="nav-link" href="login.jsp">login</a>
        </li>
        <%} %>
      </ul>
    </div>
  </div>
</nav>
<div class="container py-5">
<select onchange="sortCards()" class="form-select w-50 mx-auto my-3" aria-label="Default select example" id="sortDiv">
  
</select>
  <div class="row" id="rowBody">
    
    
   
    
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js	"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="assets/MyJS/getAllProducts.js"></script>
<script src="assets/MyJS/addToCart.js"></script>
  </body>
</html>
<style>

</style>