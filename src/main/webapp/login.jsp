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
    
 <nav class="navbar navbar-expand-lg navbar-light" style="background-color: transparent;border-style: solid;border-width: 1px;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SaiCards</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item px-5">
          <a class="nav-link " aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="#">About Us</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="#">Cart</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link active" href="login.jsp">login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
    
    <div class="container py-2" style="margin-top:100px">
    <h1 class="text-center py-5">login</h1>
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

        <div class="row" style="margin: 0px auto;display: block;">        
            <div class="col-md-6" style="margin: 0px auto">
              <p style="display: inline-block;" for="email" class="form-label">Not Registered ? <a href="regFrm.jsp">Click here</a></p><p style="float: right;display: inline-block;" for="email" class="form-label"><a href="#">forgot password ?</a></p>
              
            </div>
        </div>
        
      </form>
    </div>
    
    
  </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="assets/MyJS/submitLogin.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
body {
 background-image: url("assets/image/regimage.jpg");
 background-repeat: no-repeat;
background-size: cover;
}
</style>