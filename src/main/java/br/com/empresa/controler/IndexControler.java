package br.com.empresa.controler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.empresa.model.graficos.GeradorComponentes;

@Controller
public class IndexControler {

	@Autowired
	private GeradorComponentes geradorComponentes;
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	private String dataInicial = "2017-11-01";
	private String dataFinal = "2018-06-11";
	
	public IndexControler() {
		/*
		 * LOGICA PARA CARREGAR LOGS DOS ULTIMOS 07 DIAS 
		 * COMENTADA PARA EXIBIR AS DATAS EXISTENTES NO BANCO DE DADOS
		 

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        dataFinal = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();    
        dataInicial = dateFormat.format(todate1);
        
        */

	}
	

	@RequestMapping(value = "/chart/carregamentoInicialException", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialException() {
		String chart = geradorComponentes.getGraficoTipoErros(dataInicial, dataFinal);
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}

	@RequestMapping(value = "/chart/carregamentoInicialClassesComErros", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialClassesComErros() {
		String chart = geradorComponentes.getGraficoClassesComErros(dataInicial, dataFinal);
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}

	@RequestMapping(value = "/chart/carregamentoInicialPorPeriodo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialPorPeriodo() {
		String chart = geradorComponentes.getTotalErrosPorPeriodo(dataInicial, dataFinal);
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/chart/carregamentoInicialListagemExceptions", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialListagemExceptions() {
		String chart = geradorComponentes.getTabelaPorPeriodo(dataInicial, dataFinal);
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}

}
