package br.com.empresa.model.graficos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.empresa.model.graficos.GraficoBarraBuilder;
import br.com.empresa.model.graficos.GraficoLineBuilder;
import br.com.empresa.model.graficos.GraficoPizzaBuilder;

@Service
public class GeradorComponentes {

	private final String URL_JSON_DATATABLE_POR_DATA = "http://54.70.83.42:8080//consultarLogByData";
	private final String URL_JSON_TIPOS_ERROS = "http://54.70.83.42:8080//consultarErrosRecorrentesPeriodo";
	private final String URL_JSON_CLASSES_ERROS = "http://54.70.83.42:8080//consultarClassesRecorrentesPeriodo";
	private final String URL_JSON_ERROS_PERIODOS = "http://54.70.83.42:8080//consultarTotalErrosPeriodo";

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	// http://localhost:8080/consultarErrosRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5
	public String getGraficoTipoErros(String dataInicio, String dataFinal) {
		ResponseEntity<String> response  = restTemplate().getForEntity( URL_JSON_TIPOS_ERROS + "?appName=AP000100&startDate="+dataInicio +"&endDate=" + dataFinal +"&limit=5", String.class);
		String json = response.getBody();
		
		GraficoPizzaBuilder graficoPizzaBuilder = new GraficoPizzaBuilder(json);
		return graficoPizzaBuilder.getGraficoTipoErros();
	}

	
	// http://localhost:8080/consultarClassesRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5
	public String getGraficoClassesComErros(String dataInicio, String dataFinal) {
		ResponseEntity<String> response = restTemplate().getForEntity(URL_JSON_CLASSES_ERROS
				+ "?appName=AP000100&startDate=" + dataInicio + "&endDate=" + dataFinal + "&limit=5", String.class);
		String json = response.getBody();

		GraficoBarraBuilder graficoBarraBuilder = new GraficoBarraBuilder(json);
		return graficoBarraBuilder.getGraficoBarras();
	}

	
	// http://localhost:8080/consultarTotalErrosPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30
	public String getTotalErrosPorPeriodo(String dataInicio, String dataFinal) {
		
//		ResponseEntity<String> response = restTemplate().getForEntity(URL_JSON_ERROS_PERIODOS
//				+ "?appName=AP000100&startDate=" + dataInicio + "&endDate=" + dataFinal, String.class);
//		String json = response.getBody();
		
//		System.out.println(json);//esta devolvendo 404
		
		List<String> periodos = Arrays.asList("03/03", "04/03", "05/03", "06/03", "07/03", "08/03");
		Map<String, List<Integer>> lines = new HashMap<>();
		lines.put("AP000100", Arrays.asList(2, 4, 6, 8, 7, 1));

		GraficoLineBuilder graficoLineBuilder = new GraficoLineBuilder(periodos, lines);
		return graficoLineBuilder.getTotalErrosPorPeriodo();
	}
	
	
	public String getTabelaPorPeriodo(String dataInicio , String dataFinal) {
		ResponseEntity<String> response
		  = restTemplate().getForEntity(URL_JSON_DATATABLE_POR_DATA , String.class , dataInicio , dataFinal) ;
		return response.getBody();
	}

}
