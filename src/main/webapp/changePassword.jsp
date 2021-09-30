<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if(session.getAttribute("Cust")==null){
		response.sendRedirect("login.jsp");
	}
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
        <li  class="nav-item px-5">
          <a class="nav-link active" aria-current="page" href="myProfile.jsp">My Profile</a>
        </li>
        <li class="nav-item px-5" >
          <a class="nav-link" href="cart.jsp" >My Cart</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="myorder.jsp">My order</a>
        </li>
        <li style="background-color: blue;" class="nav-item px-5">
          <a Style="color:white" class="nav-link active" aria-current="page" href="#">Change Password</a>
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
     <h1 class="text-center py-5">Change Password</h1>
      <form id="frm" style="margin: 0px auto;">
          
    <div class="row" style="margin: 0px auto;display: block;">
        <div class="col-md-6" style="margin: 0px auto">
          <label for="password" class="form-label">Old Password</label>
          <input type="password" class="form-control" id="old_password" name="old_password">
        </div>
    </div>
    <div class="row" style="margin: 0px auto;display: block;">
        <div class="col-md-6" style="margin: 0px auto">
          <label for="password" class="form-label">New Password</label>
          <input type="password" class="form-control" id="new_password" name="new_password">
        </div>
    </div>
    <div class="row" style="margin: 0px auto;display: block;">
        <div class="col-md-6" style="margin: 0px auto">
          <label for="password" class="form-label">Confirm New Password</label>
          <input type="password" class="form-control" id="cnfrm_password" name="cnfrm_password">
        </div>
    </div>
        
        <div class="col-6 text-center" style="margin: 20px auto;">
          <button type="submit" class="btn btn-primary px-5" >Submit</button>
        </div>

        
        
      </form>
    
    </div>
  </div>
</div>
    
    
  </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="assets/MyJS/ChangePassword.js"></script>
<style>

</style>