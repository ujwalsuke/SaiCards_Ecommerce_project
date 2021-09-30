$("#frm").on("submit",function (event) {

    event.preventDefault();
	let myForm = document.getElementById('frm');
    var fd = new FormData(myForm);
	console.log(fd);
    $.ajax({
			url:'../Products',
			dataType: 'json',
			data:fd,
			type:'POST',
			contentType: false,
            processData: false,
			
			success:function(data,textStatus,jqXHR){
				let obj = data;
				console.log(obj);
				if(obj.Status==="Success"){
				Swal.fire(
  				'Good job!',
  				'Added Successfully!',
  				'success'
				)
	
			}else{
					Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
  				text: 'Productname already exists!',
				})
			}
				
			},
			error:function(jqXHR,textStatus,errorThrown){
				console.log("Fail");
				Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
  				text: 'Something went wrong!',
				})
				
			},
			
		})
		
	});


$( document ).ready(function() {
    console.log( "ready!" );

 getAllCategories();

});

function getAllCategories(){
	 $.ajax({
        url:"../Category",
        type:'GET',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			
			let list = data;
			console.log(data);
			document.getElementById("optGrp").innerHTML = `<option value="" selected="">---Select Category---</option>
			${list.map(addContent).join("")}
			`
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}

function addContent(obj){
	return`<option value="${obj.id}">${obj.category_name}</option>`;
	
}