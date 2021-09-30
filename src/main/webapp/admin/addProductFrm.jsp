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
    <script src="https://use.fontawesome.com/e49fd5ce0d.js"></script>

    <title>Hello, world!</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light nav-fill w-100" style="background-color: white;" >
  <div class="container-fluid">
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse w-100" id="navbarNav">
      <ul class="navbar-nav w-100">
      <li class="nav-item px-5" >
          <a class="nav-link" href="order.jsp">Orders</a>
        </li>
        <li class="nav-item px-5" >
          <a class="nav-link active"  href="addCategoryFrm.jsp">Add Category</a>
        </li>
        <li class="nav-item px-5" style="background-color: blue;" >
          <a class="nav-link" href="addProductFrm.jsp" Style="color:white" >Add Product</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link" href="changePassword.jsp">Change Password</a>
        </li>
        
        <li class="nav-item px-5">
          <a class="nav-link"  href="../Logout">Log out</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>
    
    <div class="container py-2" style="margin-top:100px">
    <h1 class="text-center py-5">Add Product</h1>
      <form id="frm" style="margin: 0px auto;" >
          <div class="row" style="margin: 0px auto;display: block;">        
        <div class="col-md-6" style="margin: 0px auto">
          <label for="pname" class="form-label">Product Name</label>
          <input type="text" class="form-control" id="pname" name="pname">
        </div>
    </div>
    <div class="row" style="margin: 0px auto;display: block;">        
        <div class="col-md-6" style="margin: 0px auto">
          <label for="pcategory" class="form-label">Enter Category</label>
          <select class="form-control" id="cataId" name="category">
          	<optgroup label="" id="optGrp">
          		<option value="" selected="">---Select Category---</option>
          	</optgroup>
          </select>
        </div>
    </div>
    <div class="row" style="margin: 0px auto;display: block;">        
        <div class="col-md-6" style="margin: 0px auto">
          <label for="pprice" class="form-label">Price</label>
          <input type="text" class="form-control" id="pprice" name="pprice">
        </div>
    </div>
    <div class="row" style="margin: 0px auto;display: block;">        
        <div class="col-md-6" style="margin: 0px auto">
          <label for="pimage" class="form-label">Choose Image</label>
          <input type="file" class="form-control" id="pimage" name="pimage">
        </div>
    </div>
    
        
        <div class="col-6 text-center" style="margin: 20px auto;">
          <button type="submit" class="btn btn-primary px-5" >Add</button>
        </div>

       
        
      </form>
      
    </div>
    
    
  </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js	"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="../assets/MyJS/addProduct.js"></script>
<style>
body {
 background-image: url("../assets/image/regimage.jpg");
 background-repeat: no-repeat;
background-size: cover;
}
</style>
<script>
$("#pname").blur(function(){
		
	let pname = $("#pname").val();
	console.log(pname.toUpperCase());
	$("#pname").val(pname.toUpperCase());
	  
	});
</script>