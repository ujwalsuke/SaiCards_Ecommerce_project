$("#frm").on("submit",function (event) {

    event.preventDefault();
    let f = $(this).serialize();
	console.log(f)
    $.ajax({
        url:"CheckLogin",
        data:f,
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			let obj = data;
			console.log(obj);
            if(obj.Status==="Success"){
				window.location.href = "index.jsp";
				console.log("I am in xxxxxxxx");
	
			}else{
				Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
  				text: 'Something went wrong!',
				})
}
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
    
})

