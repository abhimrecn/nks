 $(document).ready(function () {
    	 
    	 
    	
    	
    	 
    	 $('body').on('click', '.GetDetails', function (){
    		
    		 $.get("GetDetails.html?ProductId="+$(this).attr('value'), function (data, status) {
 	            if (status == "success") {
 	            //	$("#featuresProd").hide();
 	             	 $("#showProdDetails").html(data); 
 	             } 
 	          });  
    	       
    	    });
    	 
    	 $('body').on('click', '.addToCart', function (){
     		//alert($(this).attr('value'))
    		 $.get("addToCart.html?ProductId="+$(this).attr('value'), function (data, status) {
  	            if (status == "success") {
  	            	//alert(data);
  	            	 $(".cartNoOfProd").html(data);
  	             } 
  	          });  
    		
    	    });
    	 
    	 // get all products of particaluar category
    	
    	$('body').on('click', '.ProdCategory', function (){
    		
    		//alert("in all prod cat of "+$(this).attr('value'))
    		 $.get("getProductsListOfProductCAtegory.html?ProductCategory="+$(this).attr('value'), function (data, status) {
    	            if (status == "success") {
    	            	
    	            	$("#showProdDetails").html("<div class='span9'><ul class='thumbnails'> <div id='ShowProducts'></div></ul></div>");
    	            	
    	            	//$("#featuresProd").hide();
    	             	 $("#ShowProducts").html(data); 
    	             } 
    	          });  
    	 });
    			 
    	 
    	 
    	 
    	// get all products of particaluar subcategory
    	
    	$('body').on('click', '.active', function (){	 
    		
    		//alert("in all prodSub cat of "+$(this).attr('value'))
    		
    		
    		 $.get("getProductListOf_Subcategory.html?Product_SubCategory="+$(this).attr('value'), function (data, status) {
    	            if (status == "success") {
    	            	
    	            	$("#showProdDetails").html("<div class='span9'><ul class='thumbnails'> <div id='ShowProducts'></div></ul></div>");
    	            	//$("#featuresProd").hide();
    	             	 $("#ShowProducts").html(data); 
    	             } 
    	          });  
    		});
    	
    	
    	 $('body').on('click', '#SelectDates', function (){
             $.get("payment.html", function (data, status) {
                if (status == "success") {

                    $("#showProdDetails").show();
                     $("#showProdDetails").html(data);
                     
                 } 
              });  
           
        });
         
    	 
    	 $('body').on('click', '.cartDetails', function (){
     		
    		 $.get("cartDetails.html", function (data, status) {
 	            if (status == "success") {
 	            		
 	            	$("#showProdDetails").show();
 	             	 $("#showProdDetails").html(data); 
 	             } 
 	          });  
    	       
    	    });
    	
    	 
    	
    	$('body').on('click', '.RemoveItemFromCart', function (){
   		 
   		 //alert("remove the product of id "+$(this).attr('value')+".");
     		
   			  $.get("RemoveProductFromCart.html?Product_Id="+$(this).attr('value'), function (data, status) {
	           		 if (status == "success") {
	            		 $("#showProdDetails").show();
	             		 $("#showProdDetails").html(data); 
	             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
	            } 
	          });   
		 
	     }); 
		
		
   	  
  	  $('body').on('click', '.cartDetailsWenLogin', function (){
  	     	
   		 $.get("cartDetailsWenLogin.html", function (data, status) {
	            if (status == "success") {
	            		
	            	$("#showProdDetails").show();
	             	 $("#showProdDetails").html(data); 
	             } 
	          });  
   	       
   	    });
    	
		$('body').on('click', '.MinusQuantity', function (){
  		 
  		// alert("minus one quantity of product id "+$(this).attr('value')+".");
    		
  			  $.get("MinusQuantity.html?Product_Id="+$(this).attr('value'), function (data, status) {
	           		 if (status == "success") {
	            		 $("#showProdDetails").show();
	             		 $("#showProdDetails").html(data); 
	             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
	            } 
	          });   
		 
	     }); 
		
		$('body').on('click', '.IncreaseQuantity', function (){
	   		 
	   		 //alert("Add one quantity of product id "+$(this).attr('value')+".");
	     		
	   			   $.get("IncreaseQuantity.html?Product_Id="+$(this).attr('value'), function (data, status) {
		           		 if (status == "success") {
		            		 $("#showProdDetails").show();
		             		 $("#showProdDetails").html(data); 
		             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
		            } 
		          });    
			 
		     }); 
   

		
		
		

    	$('body').on('click', '.RemoveItemFromCartWhenNotLogin', function (){
   		 
   		 //alert("remove the product of id "+$(this).attr('value')+".");
     		
   			  $.get("RemoveItemFromCartWhenNotLogin.html?Product_Id="+$(this).attr('value'), function (data, status) {
	           		 if (status == "success") {
	            		 $("#showProdDetails").show();
	             		 $("#showProdDetails").html(data); 
	             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
	            } 
	          });   
		 
	     }); 
		
		
		$('body').on('click', '.MinusQuantityWhenNotLogin', function (){
  		 
  		 //alert("minus one quantity of product id "+$(this).attr('value')+".");
    		
  			  $.get("MinusQuantityWhenNotLogin.html?Product_Id="+$(this).attr('value'), function (data, status) {
	           		 if (status == "success") {
	            		 $("#showProdDetails").show();
	             		 $("#showProdDetails").html(data); 
	             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
	            } 
	          });   
		 
	     }); 
		
		$('body').on('click', '.IncreaseQuantityWhenNotLogin', function (){
	   		 
	   		// alert("Add one quantity of product id "+$(this).attr('value')+".");
	     		
	   			   $.get("IncreaseQuantityWhenNotLogin.html?Product_Id="+$(this).attr('value'), function (data, status) {
		           		 if (status == "success") {
		            		 $("#showProdDetails").show();
		             		 $("#showProdDetails").html(data); 
		             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
		            } 
		          });    
			 
		     }); 
   	
   
 	$('body').on('click', '.loginBtn', function (){	 
			$("#warn").hide();
   		 
   	 	});
 	

	
	 
	 $('body').on('click', '#submit1', function (){
		 
		 if($("#cal1").attr('value')== '' || $("#cal2").attr('value')== '')
			 {
			  alert("please input dates");
			  return false;
			 }
		 else
			 {
         $.post("reviewOrder.html?date1="+$('#cal1').attr('value')+"&date2="+$('#cal2').attr('value'), function (data, status) {
            if (status == "success") {
                $("#showProdDetails").show();
                 $("#showProdDetails").html(data); 
             } 
          });  
   
	     }
	}); 

	 $('#login').on('shown.bs.modal', function() {
	     //alert("alert will popup");
	      $('#inputEmail').focus();
	    })


	    $('body').on('click', '#PlaceOrder', function (){
	   		 
	   		
	     	$.get("PlaceOrderFinal.html?Start_date="+$("#date1").html()+"&End_date="+$("#date2").html(), function (data, status) {
		       if (status == "success") {
		           			
		            		// $("#showProdDetails").show();
		             		 $("#showProdDetails").html(data); 
		             	   	$('.cartNoOfProd').load('NoOfItemsInCart.html');// gets the response from the url and fills into the respective class or it.
		            } 
		          });    
			  });
	 
	 
		}); 