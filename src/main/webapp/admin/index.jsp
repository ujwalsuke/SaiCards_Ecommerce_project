<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
 
    <div class="container py-2" style="margin-top:100px">
    <h1 class="text-center py-5">Admin login</h1>
      <form id="frm" style="margin: 0px auto;">
          <div class="row" style="margin: 0px auto;display: block;">        
        <div class="col-md-6" style="margin: 0px auto">
          <label for="email" class="form-label">Email</label>
          <input type="email" class="form-control" id="email" name="email">
        </div>
    </div>
    <div class="row" style="margin: 0px auto;display: block;">
        <div class="col-md-6" style="margin: 0px auto">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" name="password">
        </div>
    </div>
        
        <div class="col-6 text-center" style="margin: 20px auto;">
          <button type="submit" class="btn btn-primary px-5" >login</button>
        </div>

      
        
      </form>
    </div>
    
    
  </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../assets/MyJS/adminLogin.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
body {
 background-image: url("../assets/image/regimage.jpg");
 background-repeat: no-repeat;
background-size: cover;
}
</style>