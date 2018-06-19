package br.com.empresa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.empresa.repository.FakeRepositorio;

@Controller
public class TabelaPeriodoControler {
	
	@Autowired
	private FakeRepositorio fakeRepository;
	
	@RequestMapping("/tabela")
    public String tabela() {
        return "tabela_por_periodo";
    }
	
	@RequestMapping(value = "/chart/carregamentoInicialTabela", method = RequestMethod.GET, produces = "application/json")
	public  ResponseEntity<String> carregamentoInicialTabela() {
		
		String registros = fakeRepository.getCarregamentoInicialTabela();
		if (registros == null)
			return new ResponseEntity<String>(registros, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(registros, HttpStatus.OK);
	}

}
