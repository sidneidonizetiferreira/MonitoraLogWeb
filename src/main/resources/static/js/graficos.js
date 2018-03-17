


$.getJSON("chart/carregamentoInicialException", function(results) {
	var ctx = document.getElementById("exceptionChart").getContext("2d");
	var myChart = new Chart(ctx, results);
	
});

$.getJSON("chart/carregamentoInicialClassesComErros", function(results) {
	var ctx = document.getElementById("classesChart").getContext("2d");
	var myChart = new Chart(ctx, results);
	
});

$.getJSON("chart/carregamentoInicialPorPeriodo", function(results) {
	console.log("----");
	var ctx = document.getElementById("errosPeriodoChart").getContext("2d");
	var myChart = new Chart(ctx, results);
	
});
