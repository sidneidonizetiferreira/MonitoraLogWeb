package br.com.empresa.model.graficos;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.empresa.model.LogErro;

public class DataTableBuilder {

	private ObjectMapper mapper = new ObjectMapper();
	private List<LogErro> erros;
	
	
	public DataTableBuilder(List<LogErro> erros) {
		this.erros = erros;
	}


	public String getCarregamentoInicialTabela() {

		Object[] array = this.erros.toArray();
		
		List<Object> lista = Arrays.asList(array);
		String jsonInString = null;

		try {

			// Convert object to JSON string
//			jsonInString = mapper.writeValueAsString(lista);
//			System.out.println(jsonInString);//printa in line

			// Convert object to JSON string and pretty print
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lista);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;
	}

}
