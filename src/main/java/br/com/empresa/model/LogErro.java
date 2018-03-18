package br.com.empresa.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogErro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public LogErro() {};
	

//	private @Getter @Setter String logAplicacao     ;
	private @Getter @Setter String applicationName          ;
	private @Getter @Setter String date   ;
	private @Getter @Setter String serverAddress         ;
	private @Getter @Setter String exceptionPackage       ;
	private @Getter @Setter String exceptionClass       ;
	private @Getter @Setter String exceptionMethod       ;
	private @Getter @Setter String exceptionLine        ;
	private @Getter @Setter String exceptionType     ;
	private @Getter @Setter String exceptionMessage          ;
	private @Getter @Setter String stackTrace		;

	@Override
	public String toString() {
		return "LogErro [applicationName=" + applicationName + ", date=" + date + ", serverAddress=" + serverAddress
				+ ", exceptionPackage=" + exceptionPackage + ", exceptionClass=" + exceptionClass + ", exceptionMethod="
				+ exceptionMethod + ", exceptionLine=" + exceptionLine + ", exceptionType=" + exceptionType
				+ ", exceptionMessage=" + exceptionMessage + ", stackTrace=" + stackTrace + "]";
	}

	
	
	
	
	
}
