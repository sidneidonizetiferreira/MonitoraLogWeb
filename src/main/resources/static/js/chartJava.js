

$.getJSON("chart/bla", function(results) {
	
	var sss = results;

var ctx = document.getElementById('testeChart');
var myachrt = new Chart(ctx, sss );

});

$(document).ready(function(){
    $("button").click(function(){
        $.ajax({url: "chart/bla2", success: function(result){
//            $("#div1").html(result);
        	var bbb = result;

        	var ctx = document.getElementById('testeChart');
        	var myachrt = new Chart(ctx, bbb );
        }});
    });
});