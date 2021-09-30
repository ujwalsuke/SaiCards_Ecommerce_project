let cust;

function getCustomer(){
	 $.ajax({
        url:"GetCustomer",
        type:'GET',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			
			console.log(data);
			cust=data;
			
			
            
        },
        error:function () {
            console.log("Fail");
            
        }
    })
}