package com.ideas.springboot.formulario.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class FormularioChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormularioChatApplication.class, args);
	}

}
