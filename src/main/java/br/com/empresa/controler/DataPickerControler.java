package br.com.empresa.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataPickerControler {

	@RequestMapping("/datapicker")
    public String datapicker() {
        return "datapicker";
    }
	
	@RequestMapping("/datapicker/datas")
	//FORMATO:	20/02/2018
    public String datapickerDatas(@RequestParam("datainicial") String datainicial, @RequestParam("datafinal") String datafinal) {
		System.out.println("--> " + datainicial );System.out.println("--> " + datafinal );
	    return "index";
    }
}
