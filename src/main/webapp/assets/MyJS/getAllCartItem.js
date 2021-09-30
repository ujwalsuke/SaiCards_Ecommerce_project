$( document ).ready(function() {
    console.log( "ready!" );
getAllCartItem();



});
let total =0;



function getAllCartItem(){
	
	total=0;
		
		$.ajax({
			url:"CartItem",
			type:'GET',
		 dataType: 'json',
			success:function(data,textStatus,jqXHR){
				let list = data;
				console.log(list);
				document.getElementById("cntrBody").innerHTML =	list.map(addContent).join("")+`
				<div class="row p-5 shadow my-5 bg-body rounded" >
    <div class="col" align="right">
    	<div><p>Total :- ${total} Rs </p></div>
	<div><button  class="btn btn-primary" onclick="location.href='billDetail.jsp'" >CheckOut</button></div>	
    </div>
  </div>
				`;
	
				
			},
			error:function(jqXHR,textStatus,errorThrown){
				console.log("Fail");
				
			}
		});
	}
	
	
	function addContent(obj){
		total = total+(obj.price*obj.qty);
	return`
	  <div class="row p-5 shadow my-5 bg-body rounded" >
    <div class="col">
    	<div class="card border-secondary " style="width: 18rem;border-radius:10px">
  		<img src="data:image/png;base64, ${obj.imgdata}"  class="card-img-top" alt="..." style="border-radius:10px">
  		<div class="card-body text-center">
    		<h5 class="card-title">${obj.p_name}</h5>
    		<p class="card-text">${obj.price} Rs (per pcs)</p>
    		
 		 </div>
		</div>
    </div>
    <div class="col pt-5">
    <table class="table">
 
  <tbody>
    <tr>
      
      <td>QTY</td>
      <td><button onclick="decrement(${obj.item_id},${obj.qty})" class="mx-2"><i class="fa fa-minus px-1"></i></button>${obj.qty}<button onclick="increment(${obj.item_id},${obj.qty})" class="mx-2"><i class="fa fa-plus px-1"></i></button></td>
      
    </tr>
    <tr>
      
      <td>Amount</td>
      <td class="px-4">${obj.price*obj.qty}  RS</td>
      
    </tr>
    
  </tbody>
</table>
    </div>
  </div>
`;
	
}

function increment(id,qty){
	console.log(id,qty);
	let data = {'id':id,
	'qty':qty,
	'flag':1}
	$.ajax({
        url:"UpdateQty",
        data:data,
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			console.log("Success");
			getAllCartItem();
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
	
}
function decrement(id,qty){
	console.log(id,qty);
	
if(qty==1){
	Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
  				text: 'You can not reduce qty less than 1!',
				})
	
}else{
		let data = {'id':id,
	'qty':qty,
	'flag':0}
	$.ajax({
        url:"UpdateQty",
        data:data,
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			console.log("Success");
			getAllCartItem();
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}
	
	
}