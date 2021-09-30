$( document ).ready(function() {
    console.log( "ready!" );

getAllCategories();
 getAllProducts();

});

function getAllProducts(){
	 $.ajax({
        url:"Products",
        type:'GET',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			
			let list = data;
			console.log(data);
			document.getElementById("rowBody").innerHTML = list.map(addContent).join("");
			
			
            
        },
        error:function () {
            console.log("Fail");
            
        }
    })
}


function addContent(obj){
	return`
	<div class="col m-5">
      <div class="card border-secondary " style="width: 18rem;border-radius:10px">
  		<img src="data:image/png;base64, ${obj.imgdata}" class="card-img-top" alt="..." style="border-radius:10px">
  		<div class="card-body text-center">
    		<h5 class="card-title">${obj.p_name}</h5>
    		<p class="card-text">${obj.p_price} Rs (per pcs)</p>
    		<button onclick="addToCart(${obj.p_id})" class="btn btn-primary" >Add to Cart</button>
 		 </div>
		</div>
    </div>
`;
	
}

function getAllCategories(){
	 $.ajax({
        url:"Category",
        type:'GET',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			
			let list = data;
			console.log(data);
			document.getElementById("sortDiv").innerHTML = "<option value='-1'  selected>Sort By Categories</option>"+list.map(addSortContent).join("");
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}

function addSortContent(obj){
	return`
	<option value="${obj.id}">${obj.category_name}</option>
	`;
}

function sortCards(){
	let id = document.getElementById("sortDiv").value;
	console.log(id);
	if(id==-1){
		getAllProducts();
		
	}else{
		$.ajax({
        url:"SortByCata",
        data:{cata_id:id},
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			console.log(data);
			let list = data;
			document.getElementById("rowBody").innerHTML = list.map(addContent).join("");
			
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
		
	}
}

