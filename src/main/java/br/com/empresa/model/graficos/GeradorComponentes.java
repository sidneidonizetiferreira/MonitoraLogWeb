package br.com.empresa.model.graficos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.empresa.repository.ClientServicesRepository;

@Service
public class GeradorComponentes {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private ClientServicesRepository repository;
	
	// http://localhost:8080/consultarErrosRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5
	public String getGraficoTipoErros(String dataInicio, String dataFinal) {
		ResponseEntity<String> response  = repository.getGraficoTipoErros(dataInicio,dataFinal);
		GraficoPizzaBuilder graficoPizzaBuilder = new GraficoPizzaBuilder(response.getBody());
		return graficoPizzaBuilder.getGraficoTipoErros();
	}

	
	// http://localhost:8080/consultarClassesRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5
	public String getGraficoClassesComErros(String dataInicio, String dataFinal) {
		ResponseEntity<String> response = repository.getGraficoClassesComErros(dataInicio, dataFinal);
		GraficoBarraBuilder graficoBarraBuilder = new GraficoBarraBuilder(response.getBody());
		return graficoBarraBuilder.getGraficoBarras();
	}

	
	// http://localhost:8080/consultarTotalErrosPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30
	public String getTotalErrosPorPeriodo(String dataInicio, String dataFinal) {
		List<String> periodos = Arrays.asList("03/03", "04/03", "05/03", "06/03", "07/03", "08/03");
		Map<String, List<Integer>> lines = new HashMap<>();
		lines.put("AP000100", Arrays.asList(2, 9, 3, 15, 7, 1));

		GraficoLineBuilder graficoLineBuilder = new GraficoLineBuilder(periodos, lines);
		return graficoLineBuilder.getTotalErrosPorPeriodo();
	}
	
	
	public String getTabelaPorPeriodo(String dataInicio , String dataFinal) {
		ResponseEntity<String> response = repository.getExceptionsPorPeriodo(dataInicio, dataFinal) ;
		return response.getBody();
	}
	
	
	public String getTotalErrosNoPeriodo(String dataInicio , String dataFinal) {
		ResponseEntity<String> response = repository.getTotalErrosNoPeriodo(dataInicio, dataFinal) ;
		return response.getBody();
	}
	
}
