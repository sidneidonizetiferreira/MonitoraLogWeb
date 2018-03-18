package br.com.empresa.fake;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.empresa.model.LogErro;
import br.com.empresa.model.graficos.DataTableBuilder;
import br.com.empresa.model.graficos.GraficoBarraBuilder;
import br.com.empresa.model.graficos.GraficoLineBuilder;
import br.com.empresa.model.graficos.GraficoPizzaBuilder;


@Service
public class FakeRepositorio {

	private static final Logger log = LoggerFactory.getLogger(FakeRepositorio.class);
	private RestTemplate restTemplate = new RestTemplate();
	private  final String HTTP_GTURNQUIST_QUOTERS_CFAPPS_IO_API_RANDOM = "http://gturnquist-quoters.cfapps.io/api/random";
	
	
	
	public String getGraficoTipoErros() {
		Object forObject = restTemplate.getForObject(HTTP_GTURNQUIST_QUOTERS_CFAPPS_IO_API_RANDOM, Object.class);
		log.info(forObject
				.toString());
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Legenda1", 10);
		map.put("Legenda2", 20);
		map.put("Legenda6", 30);
		map.put("Legenda3", 30);
		map.put("Legenda5", 20);
		map.put("Legenda4", 10);
		
		GraficoPizzaBuilder graficoPizzaBuilder = new GraficoPizzaBuilder(map);
		return graficoPizzaBuilder.getGraficoTipoErros();
	}

	


	public String getGraficoClassesComErros() {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ClaSSE1", 10);
		map.put("ClaSSE2", 20);
		map.put("ClaSSE3", 25);
		map.put("ClaSSE4", 35);
		map.put("ClaSSE5", 20);
		map.put("ClaSSE6", 5);

		GraficoBarraBuilder graficoBarraBuilder = new GraficoBarraBuilder(map);
		return graficoBarraBuilder.getGraficoBarras();
	}

		
	public String getTotalErrosPorPeriodo() {
		
		List<String> periodos = Arrays.asList("03/03","04/03","05/03","06/03");
		Map<String, List<Integer>> lines = new HashMap<>();
		
		lines.put("Line1", Arrays.asList(2,4,6,8));
		lines.put("Line2", Arrays.asList(3,2,2,4));
		lines.put("Line3", Arrays.asList(1,6,3,6));
		
		GraficoLineBuilder graficoLineBuilder = new GraficoLineBuilder(periodos, lines);
		return graficoLineBuilder.getTotalErrosPorPeriodo();
	}



	public String getCarregamentoInicialTabela() {
		LogErro l = new LogErro("1", "12/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe1", "metodo1", "123", "Exception", "asas", "asas");
		LogErro l2 = new LogErro("2", "12/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe2", "metodo2", "234", "NullPointerException", "", "");
		LogErro l3 = new LogErro("3", "13/02/2018", "123.234.345", "123.234.345", "com.tabajara.lalala", "classe3", "metodo3", "345", "Exception", "asas", "asas");
		LogErro l4 = new LogErro("4", "14/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe1", "metodo1", "123", "Exception", "", "");
		LogErro l5 = new LogErro("5", "15/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe2", "metodo2", "234", "NullPointerException", "assa", "");
		LogErro l6 = new LogErro("6", "16/02/2018", "123.234.345", "123.234.345", "com.tabajara.lululu", "classe6", "metodo6", "3456", "Exception", "", "asas");
		LogErro l7 = new LogErro("7", "12/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe1", "metodo1", "123", "Exception", "asas", "");
		LogErro l8 = new LogErro("8", "12/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe2", "metodo2", "234", "NullPointerException", "", "assa");
		LogErro l9 = new LogErro("9", "13/02/2018", "123.234.345", "123.234.345", "com.tabajara.lalala", "classe3", "metodo3", "345", "Exception", "", "");
		LogErro l10 = new LogErro("10", "14/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe1", "metodo1", "123", "Exception", "", "");
		LogErro l11= new LogErro("11", "15/02/2018", "123.234.345", "123.234.345", "com.tabajara", "classe2", "metodo2", "234", "NullPointerException", "", "");
		LogErro l12= new LogErro("12", "16/02/2018", "123.234.345", "123.234.345", "com.tabajara.lilili", "classe6", "metodo6", "3456", "Exception", "", "");
		List<LogErro> erros = Arrays.asList(l,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);

		DataTableBuilder dataTableBuilder = new DataTableBuilder(erros );
		return dataTableBuilder.getCarregamentoInicialTabela();
	}
	
	
	




}
