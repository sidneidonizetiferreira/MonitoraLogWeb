package br.com.empresa.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ClientServicesRepository {

	private static final Logger log = LoggerFactory.getLogger(ClientServicesRepository.class);

//	private  final String JSON_DATATABLE_POR_DATA = "http://54.70.83.42:8080//consultarLogByData";
	//http://localhost:8080/consultarLogByData?appName=AP000100&startDate=2017-11-29&endDate=2017-11-30
	private  final String JSON_DATATABLE_POR_DATA = "http://localhost:8080//consultarLogByData";

//	private  final String JSON_TIPOS_ERROS = "http://54.70.83.42:8080/consultarErrosRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5";
	private  final String JSON_TIPOS_ERROS = "http://localhost:8080//consultarErrosRecorrentesPeriodo";

//	private  final String JSON_CLASSES_ERROS = "http://54.70.83.42:8080/consultarClassesRecorrentesPeriodo";
	private  final String JSON_CLASSES_ERROS = "http://localhost:8080//consultarClassesRecorrentesPeriodo";

//	private  final String JSON_ERROS_PERIODOS = "http://localhost:8080/consultarTotalErrosPorPeriodo?appName=AP000100&startDate=2017-11-29&endDate=2017-11-30";
	private  final String JSON_ERROS_PERIODOS = "http://localhost:8080//consultarTotalErrosPorPeriodo";

	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	public ResponseEntity<String> getGraficoTipoErros(String dataInicio, String dataFinal) {
		ResponseEntity<String> response  = restTemplate().getForEntity( JSON_TIPOS_ERROS + "?appName=AP000100&startDate="+dataInicio +"&endDate=" + dataFinal +"&limit=5", String.class);
		return response;
	}


	public ResponseEntity<String> getGraficoClassesComErros(String dataInicio, String dataFinal) {
		ResponseEntity<String> response  = restTemplate().getForEntity(JSON_CLASSES_ERROS + "?appName=AP000100&startDate="+dataInicio +"&endDate=" + dataFinal +"&limit=5" , String.class);
		return response;
	}

//Servico indisponivel
//	public String getTotalErrosPorPeriodo() {
////	ResponseEntity<String> response  = restTemplate().getForEntity(JSON_ERROS_PERIODOS , String.class);
//	
//	GraficoLineBuilder graficoLineBuilder = new GraficoLineBuilder(periodos, lines);
//	return graficoLineBuilder.getTotalErrosPorPeriodo();
//}


	public ResponseEntity<String> getExceptionsPorPeriodo(String dataInicio , String dataFinal) {
		ResponseEntity<String> response  = restTemplate().getForEntity(JSON_DATATABLE_POR_DATA + "?appName=AP000100&startDate="+dataInicio +"&endDate=" + dataFinal, String.class) ;
		return response;
	}
	
	
	public ResponseEntity<String> getTotalErrosNoPeriodo(String dataInicio , String dataFinal) {
		ResponseEntity<String> response  = restTemplate().getForEntity(JSON_ERROS_PERIODOS + "?appName=AP000100&startDate="+dataInicio +"&endDate=" + dataFinal, String.class) ;
		return response;
	}
	
}
