$( document ).ready(function() {
    console.log( "ready!" );
    getAllOrder();



});




function getAllOrder(){
		$.ajax({
			url:"../GetOrder",
			type:'GET',
		 dataType: 'json',
			success:function(data,textStatus,jqXHR){
				let list = data;
				console.log(list);
				document.getElementById("cntrBody").innerHTML =	list.map(addContent).join("");
				
				
	
				
			},
			error:function(jqXHR,textStatus,errorThrown){
				console.log("Fail");
				
			}
		});
	}
	
	
	function addContent(obj){
		
	return`
	  <div class="row p-5 shadow my-5 bg-body rounded" >
		<h3 class="text-center">Order Status:-${obj.status}</h3>
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
      <td>${obj.qty}</td>
      
    </tr>
    <tr>
      
      <td>Amount</td>
      <td>${obj.price*obj.qty}  RS</td>
      
    </tr>
    
  </tbody>
</table>
    </div>
<div class="py-3">${getDispatchBtn(obj)}</div>
  </div>
`;
	
}

function getDispatchBtn(obj){
	if(obj.status=="Placed"){
		return`<button style="float:right"  class="btn btn-primary" onclick="dispatch(${obj.item_id})" >Initiate Delievery</button>`
		
	}else{
		return``;
		
	}
}

function dispatch(item_id){
	    $.ajax({
        url:"../UpdateStatus",
        data:{item_id:item_id,status:1},
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			let obj = data;
			console.log(obj);
			  getAllOrder();
  
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}