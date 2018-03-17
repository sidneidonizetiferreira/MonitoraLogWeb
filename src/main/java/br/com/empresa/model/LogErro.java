package br.com.empresa.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class LogErro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public LogErro(String idOcorrencia, String dataOcorrencia, String sistema, String ipserver, String pacoteErro,
			String classeErro, String metodoErro, String linhaErro, String tipoExcessao, String msgErro,
			String stackTrace) {
		this.idOcorrencia = idOcorrencia;
		this.dataOcorrencia = dataOcorrencia;
		this.sistema = sistema;
		this.ipserver = ipserver;
		this.pacoteErro = pacoteErro;
		this.classeErro = classeErro;
		this.metodoErro = metodoErro;
		this.linhaErro = linhaErro;
		this.tipoExcessao = tipoExcessao;
		this.msgErro = msgErro;
		this.stackTrace = stackTrace;
	}
	private @Getter @Setter String idOcorrencia     ;
	private @Getter @Setter String dataOcorrencia   ;
	private @Getter @Setter String sistema          ;
	private @Getter @Setter String ipserver         ;
	private @Getter @Setter String pacoteErro       ;
	private @Getter @Setter String classeErro       ;
	private @Getter @Setter String metodoErro       ;
	private @Getter @Setter String linhaErro        ;
	private @Getter @Setter String tipoExcessao     ;
	private @Getter @Setter String msgErro          ;
	private @Getter @Setter String stackTrace		;
	
	
}
