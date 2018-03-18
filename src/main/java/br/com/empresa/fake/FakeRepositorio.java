package br.com.empresa.fake;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
//	private  final String HTTP_GTURNQUIST_QUOTERS_CFAPPS_IO_API_RANDOM = "http://gturnquist-quoters.cfapps.io/api/random";
	private  final String LOUIZZZ_AWS_API = "http://54.202.46.151:8080/logAplicacao";
	
	
	
	public String getGraficoTipoErros() {
		
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

//		LogErro forObject = restTemplate.getForObject(LOUIZZZ_AWS_API, LogErro.class);
		ResponseEntity<Object> forEntity = restTemplate.getForEntity(LOUIZZZ_AWS_API, Object.class);
		
		log.info(forEntity.toString());
		


		List<LogErro> erros = new ArrayList<LogErro>();
		erros.add(new LogErro());
		
		DataTableBuilder dataTableBuilder = new DataTableBuilder(erros );
		return dataTableBuilder.getCarregamentoInicialTabela();
	}
	
	
	




}
