package br.com.empresa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.empresa.fake.FakeRepositorio;

@Controller
public class IndexControler {

	@Autowired
	private FakeRepositorio fakeRepository;
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	

	@RequestMapping(value = "/chart/carregamentoInicialException", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialException() {
		String chart = fakeRepository.getGraficoTipoErros();
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}

	@RequestMapping(value = "/chart/carregamentoInicialClassesComErros", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialClassesComErros() {
		String chart = fakeRepository.getGraficoClassesComErros();
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}

	@RequestMapping(value = "/chart/carregamentoInicialPorPeriodo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> carregamentoInicialPorPeriodo() {
		String chart = fakeRepository.getTotalErrosPorPeriodo();
		if (chart == null)
			return new ResponseEntity<String>(chart, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(chart, HttpStatus.OK);
	}

}
