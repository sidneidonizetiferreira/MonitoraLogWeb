package br.com.empresa.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.empresa.model.graficos.GraficoBarraBuilder;
import br.com.empresa.model.graficos.GraficoLineBuilder;
import br.com.empresa.model.graficos.GraficoPizzaBuilder;


@Service
public class FakeRepositorio {

	private static final Logger log = LoggerFactory.getLogger(FakeRepositorio.class);
	private  final String LISTAR_LOG = "http://54.70.83.42:8080/listarLogAplicacao";
	private  final String JSON_DATATABLE_POR_DATA = "http://54.70.83.42:8080//consultarLogByData";
	
	private  final String JSON_TIPOS_ERROS = "";
	private  final String JSON_CLASSES_ERROS = "";
	private  final String JSON_ERROS_PERIODOS = "";
	
	
	private String jsonFromTXT = "";
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
public String getGraficoTipoErros() {
		
//		ResponseEntity<String> response  = restTemplate().getForEntity(JSON_TIPOS_ERROS , String.class);
//		String json = response.getBody();
		
		String json = "{ \"Exception\" : \"12\", \"NullPointer\" : \"23\", \"MainFrameException\" : \"34\", \"LalalaException\" : \"34\",  \"ALgumException\" : \"34\",  \"exceptionLine\" : \"45\"}"; 
		
		GraficoPizzaBuilder	 graficoPizzaBuilder = new GraficoPizzaBuilder(json);
		return graficoPizzaBuilder.getGraficoTipoErros();
	}

	


public String getGraficoClassesComErros() {
	
//	ResponseEntity<String> response  = restTemplate().getForEntity(JSON_CLASSES_ERROS , String.class);
//	String json = response.getBody();
	
	String json = "{ \"ClaSSE1\" : \"12\", \"ClaSSE2\" : \"23\",  \"ClaSSE5\" : \"34\",  \"ClaSSE6\" : \"45\"}";

	GraficoBarraBuilder graficoBarraBuilder = new GraficoBarraBuilder(json);
	return graficoBarraBuilder.getGraficoBarras();
}

	
public String getTotalErrosPorPeriodo() {
	
	List<String> periodos = Arrays.asList("03/03","04/03","05/03","06/03","07/03","08/03");
	Map<String, List<Integer>> lines = new HashMap<>();
	
	lines.put("Line1", Arrays.asList(2,4,6,8 ,7,1));
//	lines.put("Line2", Arrays.asList(3,2,2,4));
//	lines.put("Line3", Arrays.asList(1,6,3,6));
	
//	ResponseEntity<String> response  = restTemplate().getForEntity(JSON_ERROS_PERIODOS , String.class);
	
	GraficoLineBuilder graficoLineBuilder = new GraficoLineBuilder(periodos, lines);
	return graficoLineBuilder.getTotalErrosPorPeriodo();
}


	public String getTabelaPorPeriodo(String dataInicio , String dataFinal) {
		ResponseEntity<String> response
		  = restTemplate().getForEntity(JSON_DATATABLE_POR_DATA , String.class , dataInicio , dataFinal) ;
		return response.getBody();
	}

	public String getCarregamentoInicialTabela() {
//		carregarJsonDeAquivoTxt();
//		return jsonFromTXT ;
		ResponseEntity<String> response
		  = restTemplate().getForEntity(LISTAR_LOG , String.class);
		return response.getBody();		
	}
	

	
	
	private void carregarJsonDeAquivoTxt() {
		String fileName = "fileTest.txt";
		jsonFromTXT = "[";
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(s -> {
				jsonFromTXT += s;
			});

			jsonFromTXT += "]";	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCarregamentoTabelaFAKE() {
		carregarJsonDeAquivoTxt();
		return jsonFromTXT ;
	}
	
	




}