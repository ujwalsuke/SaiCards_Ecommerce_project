$("#frm").on("submit",function (event) {

    event.preventDefault();
    let f = $(this).serialize();
	console.log(f)
    $.ajax({
        url:"../Category",
        data:f,
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			console.log("Success");
			getAllCategories();
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
    
})

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
			document.getElementById("cataDiv").innerHTML = list.map(addContent).join("");
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}

function addContent(obj){
	return`<tr>
      <td><i class="fa fa-archive px-2"></i>${obj.category_name}</td>
      <td style="float:right"><button onclick="deleteCategory(${obj.id})" class="btn btn-primary px-2" >Delete</button></td>
      
    </tr>`;
	
}

function deleteCategory(cata_id){
	console.log(cata_id);
	    $.ajax({
        url:"../DeleteCategory",
        data:{id:cata_id},
        type:'POST',
		 dataType: 'json',
        success:function (data,textStatus,jqXHR) {
			console.log(data);
			getAllCategories();
				Swal.fire(
  				'',
  				'Deleted!',
  				'success'
				)
			
            
        },
        error:function name(params) {
            console.log("Fail");
            
        }
    })
}