function addToCart(p_id){
	let data = {p_id:p_id};
	    $.ajax({
        url:"CartItem",
        data:data,
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			let obj = data;
			console.log(obj);
			if(obj.Status==="Success"){
				Swal.fire(
  				'Added to cart!',
				'',
				'success'
  				
				)
	
			}else{
					window.location.href = "login.jsp";
			}
            
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}