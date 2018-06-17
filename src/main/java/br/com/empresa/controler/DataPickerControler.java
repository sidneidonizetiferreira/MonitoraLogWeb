package br.com.empresa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.empresa.fake.FakeRepositorio;
import br.com.empresa.model.graficos.GeradorComponentes;

@Controller
public class DataPickerControler {

	@Autowired
	private GeradorComponentes geradorComponentes;

	@RequestMapping("/datapicker")
    public String datapicker() {
        return "datapicker";
    }
	
	@RequestMapping("/datapicker/datas")
    public ResponseEntity<String>  datapickerDatas(@RequestParam("datainicial") String datainicial, @RequestParam("datafinal") String datafinal) {
	    
		String registros = geradorComponentes.getTabelaPorPeriodo(datainicial , datafinal);
		if (registros == null)
			return new ResponseEntity<String>(registros, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(registros, HttpStatus.OK);
    }
	
	@RequestMapping("/chart/consultarErrosRecorrentesPeriodo")
    public ResponseEntity<String>  consultarErrosRecorrentesPeriodo(@RequestParam("datainicial") String datainicial, @RequestParam("datafinal") String datafinal) {
	    
		String registros = geradorComponentes.getGraficoTipoErros(datainicial , datafinal);
		if (registros == null)
			return new ResponseEntity<String>(registros, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(registros, HttpStatus.OK);
    }
	
	@RequestMapping("/chart/consultarClassesRecorrentesPeriodo")
    public ResponseEntity<String>  consultarClassesRecorrentesPeriodo(@RequestParam("datainicial") String datainicial, @RequestParam("datafinal") String datafinal) {
	    
		String registros = geradorComponentes.getGraficoClassesComErros(datainicial , datafinal);
		if (registros == null)
			return new ResponseEntity<String>(registros, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(registros, HttpStatus.OK);
    }
	
	@RequestMapping("/chart/consultarTotalErrosPeriodo")
    public ResponseEntity<String>  consultarTotalErrosPeriodo(@RequestParam("datainicial") String datainicial, @RequestParam("datafinal") String datafinal) {
	    
		String registros = geradorComponentes.getTotalErrosPorPeriodo(datainicial , datafinal);
		if (registros == null)
			return new ResponseEntity<String>(registros, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(registros, HttpStatus.OK);
    }
	
}
