$( document ).ready(function() {
    console.log( "ready!" );
getAllCartItem();
getCustomer();



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
				document.getElementById("tblBody").innerHTML =	list.map(addContent).join("")+`
				
    <tr>
      
      <td>Total</td>
      <td></td>
      <td>${total}Rs</td>
    </tr>
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
	 <tr>
      
      <td>${obj.p_name}</td>
      <td>${obj.qty}</td>
      <td>${obj.price*obj.qty} Rs</td>
    </tr>
`;
	
}

function placeOrder(){
		
		$.ajax({
			url:"PlaceOrder",
			datatype:'JSON',
			type:'GET',
			success:function(data,textStatus,jqXHR){
				
				
				console.log(total);
				Swal.fire(
							  '',
							  'Your order is placed successfully',
							  'success'
							  
							).then(function(){
								location.href="index.jsp"
							});
			
			},
			error:function(jqXHR,textStatus,errorThrown){
				console.log("Fail");
				
			}
		});
		
			
		
	}


function initiatePayment(){
	console.log("XXX");
    $.ajax({
        url:"CreateOrder",
        data:{amount:total},
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			let obj = data;
			console.log(obj);
			
			var options = {
    "key": "rzp_test_KmycnDS3FGyZ4v", // Enter the Key ID generated from the Dashboard
    "amount": total*100, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Sai Cards",
    "description": "",
    "image": "",
    "order_id": "", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "handler": function (response){
        placeOrder();
		
    },
    "prefill": {
        "name": cust.name,
        "email": cust.email,
        "contact": cust.mob_no
    },
    "notes": {
        "address": "Saicards Amravati"
    },
    "theme": {
        "color": "#3399cc"
    }
};
var rzp1 = new Razorpay(options);
rzp1.on('payment.failed', function (response){
        alert(response.error.code);
        alert(response.error.description);
        alert(response.error.source);
        alert(response.error.step);
        alert(response.error.reason);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id);
});
rzp1.open();

     
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
	
}