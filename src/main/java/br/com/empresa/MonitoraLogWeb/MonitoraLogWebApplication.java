package br.com.empresa.MonitoraLogWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("br.com.empresa")
@SpringBootApplication
public class MonitoraLogWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoraLogWebApplication.class, args);
	}
}
