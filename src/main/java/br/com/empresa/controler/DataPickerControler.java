package br.com.empresa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.empresa.fake.FakeRepositorio;

@Controller
public class DataPickerControler {

	@Autowired
	private FakeRepositorio fakeRepository;

	@RequestMapping("/datapicker")
    public String datapicker() {
        return "datapicker";
    }
	
	@RequestMapping("/datapicker/datas")
	//FORMATO:	20/02/2018
    public ResponseEntity<String>  datapickerDatas(@RequestParam("datainicial") String datainicial, @RequestParam("datafinal") String datafinal) {
		System.out.println("--> " + datainicial );System.out.println("--> " + datafinal );
	    
		String registros = fakeRepository.getTabelaPorPeriodo(datainicial , datafinal);
		if (registros == null)
			return new ResponseEntity<String>(registros, HttpStatus.NOT_FOUND);

		return new ResponseEntity<String>(registros, HttpStatus.OK);
    }
}
