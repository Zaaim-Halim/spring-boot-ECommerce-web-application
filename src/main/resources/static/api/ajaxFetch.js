/**
 * 
 */
function handleListProduct(event)
{
  event.preventDefault();
  fire_ajax1();
}
function  fire_ajax1()
{
	$.ajax({
        type: "GET",
        url: "/listProduct",
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$("#app").empty();
        	$("#app").append(data);
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

function handleAddProduct(event)
{
  event.preventDefault();
  fire_ajax();
}
function  fire_ajax()
{
	$.ajax({
        type: "GET",
        url: "/addProduct",
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$("#app").empty();
        	$("#app").append(data);
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

// Search 
function dropDown(event){
		    var val = $("#search").val();
		    if(val.length > 1){
		    	$.ajax({
		            type: "GET",
		            url: "/search?value="+val,
		            processData: false,// prevent jQuery from automatically
		            // transforming the data into a query string
		            contentType: false,
		            cache: false,
		            timeout: 6000,
		            success: function (data) {
		            	$('.dropdown-toggle').dropdown();
		            	$("#dropdown-container").empty();
		            	$("#dropdown-container").append(data);
		            	
		            },
		    	  error: function (e) {

		              console.log("ERROR : ", e);
		             
		          }
		      });
		    	
		    }
			
		}