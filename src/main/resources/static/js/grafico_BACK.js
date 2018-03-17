
					$.getJSON("chart1/testJson", function(results) {
						var labels = [], data = [];

						var arrayJson = results;
						arrayJson.forEach(function(obj) {
							var dataOcorrencia = obj.dataOcorrencia;
							var tipoExcessao = obj.tipoExcessao;
							labels.push(tipoExcessao);
							data.push(tipoExcessao);
						})

						var ctx = document.getElementById("myChart")
								.getContext("2d");
						var myChart = new Chart(ctx, {
							//     		  line , bar , doughnut , pie
							type : 'pie',
							data : {
								labels : labels,
								datasets : [ {
									data : [12, 19, 3],
									borderColor : ['rgba(0, 250, 0, 0.5)','rgba(0, 255, 255, 0.8)','rgba(0, 64, 255, 0.5)']
								} ]
							}
						});

						var ctx2 = document.getElementById("myChart2")
								.getContext("2d");
						var myChart2 = new Chart(ctx2, {
							//     		  line , bar , doughnut , pie
							type : 'line',
							data : {
								labels : labels,
								datasets : [ {
									data : [12, 19, 9 ],
									borderColor : 'rgba(0, 250, 0, 0.5)'
								} ]
							}
						});

						var ctx3 = document.getElementById("myChart3")
								.getContext("2d");
						var myChart3 = new Chart(ctx3, {
							//     		  line , bar , doughnut , pie
							type : 'line',
							data : {
								labels : nomeClassesComErros,
								datasets : [ {
									label : 'Total',
									data : quantidadeClassesErros,
									fill : false,
									backgroundColor : 'rgba(255,99,132,0.2)',
									borderColor : 'rgba(255,99,132,1)',
									borderWidth : 2,
									hoverBackgroundColor: "rgba(255,99,132,0.4)",
								    hoverBorderColor: "rgba(255,99,132,1)",
									options : {
										scales : {
											yAxes: [{
											      stacked: true,
											      gridLines: {
											        display: true,
											        color: "rgba(255,99,132,0.2)"
											      }
											    }],
											    xAxes: [{
											      gridLines: {
											        display: false
											      }
											    }]

										}
									}
								} ]
							}
						});

					});
					
					
//	-----------------------------------------------------------------------
					

					var nomeExcecao = [], quantidade = [], coresGraficoPizza = []
					quantidadeClassesErros = [], nomeClassesComErros = [], corDasBarras = '',
					dataExcessoes = [] , 
					quantidadeParaCadaPeriodoErrosExceptions1 = [],
					quantidadeParaCadaPeriodoErrosExceptions2 = [],
					quantidadeParaCadaPeriodoErrosExceptions3 = [],
					quantidadeParaCadaPeriodoErrosExceptions4 = [],
					quantidadeParaCadaPeriodoErrosExceptions5 = [],
					legendaTipoErro = [] , coresPorPeriodo = [];



					$.getJSON("chart/carregamentoInicialDaPagina", function(results) {

						var objJson = results;
						
						//Grafico Pizza
						nomeExcecao = objJson.nomeExcessoes;
						quantidadeTotalExceptions = objJson.quantidadeTotalExceptions;
						coresGraficoPizza = objJson.coresGraficoPizza;
						
						//Grafico Barras
						quantidadeClassesErros = objJson.quantidadeTotalClassesErros;
						nomeClassesComErros = objJson.nomeClassesComErros;
						corDasBarras = objJson.corFixaBarra;
						
						//Grafico line
						dataExcessoes = objJson.dataExcessoes;
						quantidadeParaCadaPeriodoErrosExceptions1 = objJson.quantidadeParaCadaPeriodoErrosExceptions1;
						quantidadeParaCadaPeriodoErrosExceptions2 = objJson.quantidadeParaCadaPeriodoErrosExceptions2;
						quantidadeParaCadaPeriodoErrosExceptions3 = objJson.quantidadeParaCadaPeriodoErrosExceptions3;
						quantidadeParaCadaPeriodoErrosExceptions4 = objJson.quantidadeParaCadaPeriodoErrosExceptions4;
						quantidadeParaCadaPeriodoErrosExceptions5 = objJson.quantidadeParaCadaPeriodoErrosExceptions5;
						legendaTipoErro = objJson.legendaTipoErro
						coresPorPeriodo = objJson.coresPorPeriodo;

						var ctx = document.getElementById("exceptionChart").getContext("2d");
						var myChart = new Chart(ctx, {
							//line , bar , doughnut , pie
							type : 'pie',
							data : {
								labels : nomeExcecao,
								datasets : [ {
									data : quantidadeTotalExceptions,
									backgroundColor : coresGraficoPizza,
									borderWidth : 1
								} ]
							}
						});

						var ctx2 = document.getElementById("classesChart").getContext("2d");
						var myChart2 = new Chart(ctx2, {
							//     		  line , bar , doughnut , pie
							type : 'bar',
							data : {
								labels : nomeClassesComErros,
								datasets : [ {
									label : 'Total',
									data : quantidadeClassesErros,
									fill : false,
									backgroundColor : corDasBarras,
									borderColor : 'rgba(255,99,132,1)',
									borderWidth : 2,
									hoverBackgroundColor: "rgba(255,99,132,0.4)",
								    hoverBorderColor: "rgba(255,99,132,1)",
									options : {
										scales : {
											yAxes: [{
											      stacked: true,
											      gridLines: {
											        display: true,
											        color: "rgba(255,99,132,0.2)"
											      }
											    }],
											    xAxes: [{
											      gridLines: {
											        display: false
											      }
											    }]

										}
									}
								} ]
							}
						});
						
						var ctx3 = document.getElementById("errosPeriodoChart").getContext("2d");
						var myChart3 = new Chart(
								ctx3,
								{
									type : 'line',
									data : {
										labels : dataExcessoes,// periodo
										datasets : [
												{
													label : legendaTipoErro[0],
													data : quantidadeParaCadaPeriodoErrosExceptions1,
													borderColor : coresPorPeriodo[0]
												},
												{
													label : legendaTipoErro[1],
													data : quantidadeParaCadaPeriodoErrosExceptions2,
													borderColor : coresPorPeriodo[1]
												},
												{
													label : legendaTipoErro[2],
													data : quantidadeParaCadaPeriodoErrosExceptions3,
													borderColor : coresPorPeriodo[2]
												}, 
												{
													label : legendaTipoErro[3],
													data : quantidadeParaCadaPeriodoErrosExceptions4,
													borderColor : coresPorPeriodo[3]
												},
												{
													label : legendaTipoErro[4],
													data : quantidadeParaCadaPeriodoErrosExceptions5,
													borderColor : coresPorPeriodo[4]
												} 
												]

									}

								});
						
						
						
						

					});

					
			