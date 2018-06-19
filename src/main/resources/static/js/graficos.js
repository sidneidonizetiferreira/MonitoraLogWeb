var oTable ;


$.getJSON("chart/carregamentoInicialException", function(results) {
	var ctx = document.getElementById("exceptionChart").getContext("2d");
	var myChart = new Chart(ctx, results);
	
});

$.getJSON("chart/carregamentoInicialClassesComErros", function(results) {
	var ctx = document.getElementById("classesChart").getContext("2d");
	var myChart = new Chart(ctx, results);
	
});

$.getJSON("chart/carregamentoInicialPorPeriodo", function(results) {
	var ctx = document.getElementById("errosPeriodoChart").getContext("2d");
	var myChart = new Chart(ctx, results);
	
});


$.getJSON( "/chart/carregamentoInicialListagemExceptions" , function( results ) {
	
	if ( $.fn.dataTable.isDataTable( '#tabela' ) ) {
		oTable.clear();
		oTable.destroy();
    	
		oTable =  $('#tabela').DataTable({
    		data : results,
    		columns : [ 
    		{
    		    className:      "details-control",
    		    data:           null,
    		    defaultContent: ""
    		},        
    		 {
    			data : "date"
    		}, {
    			data : "applicationName"
    		}, {
    			data : "serverAddress"
    		}, {
    			data : "exceptionPackage"
    		}, {
    			data : "exceptionClass"
    		}, {
    			data : "exceptionMethod"
    		}, {
    			data : "exceptionLine"
    		}, {
    			data : "exceptionType"
    		}, {
    			data : "exceptionMessage"
    		} ]

    				
    	});
		

	
	}
	else {
		oTable =  $('#tabela').DataTable({
    		data : results,
    		columns : [ 
    		{
    		    className:      "details-control",
    		    data:           null,
    		    defaultContent: ""
    		},        
    		 {
    			data : "date"
    		}, {
    			data : "applicationName"
    		}, {
    			data : "serverAddress"
    		}, {
    			data : "exceptionPackage"
    		}, {
    			data : "exceptionClass"
    		}, {
    			data : "exceptionMethod"
    		}, {
    			data : "exceptionLine"
    		}, {
    			data : "exceptionType"
    		}, {
    			data : "exceptionMessage"
    		} ]

    				
    	});
    	 
    	// Add event listener for opening and closing details
 	    $('#tabela tbody').on('click', 'td.details-control', function () {

 	        var tr = $(this).closest('tr');
 	        var row = oTable.row( tr );
 	        
 	 
 	        if ( row.child.isShown() ) {
 	            // This row is already open - close it
 	            row.child.hide();
 	            tr.removeClass('shown');
 	        }
 	        else {
 	            // Open this row
 	            row.child( format(row.data()) ).show();
 	            tr.addClass('shown');
 	        }
 	    } );
 	    
    	}//FECHA IF INIT
 	    
    	
    }).done(function() {
        console.log( "second success" );
    })
    .fail(function() {
      console.log( "error" );
    })
    .always(function() {
      console.log( "complete" );
    });



function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>StackTrace:</td>'+
            '<td>'+d.stackTrace+'</td>'+
        '</tr>'+
    '</table>';
};






	$("#my_form").submit(function(event){
		
		event.preventDefault(); //prevent default action 
	    var form_data = $(this).serialize(); //Encode form elements for submission
	    
	    
	    $.getJSON( "/datapicker/datas" , form_data ,  function( fromServer ) {
	    	
	    	
	    	if ( $.fn.dataTable.isDataTable( '#tabela' ) ) {
	    		oTable.clear();
	    		oTable.destroy();
	        	
	    		oTable =  $('#tabela').DataTable({
	        		data : fromServer,
	        		columns : [ 
	        		{
	        		    className:      "details-control",
	        		    data:           null,
	        		    defaultContent: ""
	        		},        
	        		 {
	        			data : "date"
	        		}, {
	        			data : "applicationName"
	        		}, {
	        			data : "serverAddress"
	        		}, {
	        			data : "exceptionPackage"
	        		}, {
	        			data : "exceptionClass"
	        		}, {
	        			data : "exceptionMethod"
	        		}, {
	        			data : "exceptionLine"
	        		}, {
	        			data : "exceptionType"
	        		}, {
	        			data : "exceptionMessage"
	        		} ]

	        				
	        	});
	    		
	    
	    	
	    	}
	    	else {
	    		oTable =  $('#tabela').DataTable({
	        		data : fromServer,
	        		columns : [ 
	        		{
	        		    className:      "details-control",
	        		    data:           null,
	        		    defaultContent: ""
	        		},        
	        		 {
	        			data : "date"
	        		}, {
	        			data : "applicationName"
	        		}, {
	        			data : "serverAddress"
	        		}, {
	        			data : "exceptionPackage"
	        		}, {
	        			data : "exceptionClass"
	        		}, {
	        			data : "exceptionMethod"
	        		}, {
	        			data : "exceptionLine"
	        		}, {
	        			data : "exceptionType"
	        		}, {
	        			data : "exceptionMessage"
	        		} ]

	        				
	        	});
	        	 
	        	// Add event listener for opening and closing details
	     	    $('#tabela tbody').on('click', 'td.details-control', function () {

	     	        var tr = $(this).closest('tr');
	     	        var row = oTable.row( tr );
	     	        
	     	 
	     	        if ( row.child.isShown() ) {
	     	            // This row is already open - close it
	     	            row.child.hide();
	     	            tr.removeClass('shown');
	     	        }
	     	        else {
	     	            // Open this row
	     	            row.child( format(row.data()) ).show();
	     	            tr.addClass('shown');
	     	        }
	     	    } );
	     	    
	        	}//FECHA IF INIT
	     	    
	        	
	        }).done(function() {
	            console.log( "second success" );
	        })
	        .fail(function() {
	          console.log( "error" );
	        })
	        .always(function() {
	          console.log( "complete" );
	        });
	    
	    
	   

		  $.getJSON("chart/consultarErrosRecorrentesPeriodo", form_data ,  function(results) {
			var ctx = document.getElementById("exceptionChart").getContext("2d");
			var myChart = new Chart(ctx, results);
		  });
		  
		  
		$.getJSON("chart/consultarClassesRecorrentesPeriodo",form_data , function(results) {
			var ctx = document.getElementById("classesChart").getContext("2d");
			var myChart = new Chart(ctx, results);
			
		});
		
		$.getJSON("chart/consultarTotalErrosPeriodo",form_data , function(results) {
			var ctx = document.getElementById("errosPeriodoChart").getContext("2d");
			var myChart = new Chart(ctx, results);
			
		});
	        
	    	
	        
	    });   


	    $(".datepicker").datepicker({
	        language: "pt-BR",
	        autoclose: true,
	        format: 'yyyy-mm-dd',
	        todayHighlight: true,
	        constrainInput: false 
	    });	
