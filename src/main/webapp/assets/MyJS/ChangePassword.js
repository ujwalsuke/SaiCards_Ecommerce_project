$("#frm").on("submit",function (event) {

    event.preventDefault();
    let f = $(this).serialize();
	console.log(f)
    $.ajax({
        url:"ChangePassword",
        data:f,
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			let obj = data;
			console.log(obj);
			if(obj.Status==="Success"){
				Swal.fire(
  				'Password Changed!',
				'',
				'success'
  				
				)
	
	
			}else{
				Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
  				text: 'Something went wrong!',
				})
}

document.getElementById("old_password").value="";
document.getElementById("new_password").value="";
document.getElementById("cnfrm_password").value="";
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
    
})

