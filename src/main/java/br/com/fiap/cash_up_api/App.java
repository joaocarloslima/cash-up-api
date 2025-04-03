package br.com.fiap.cash_up_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Cash Up API", version = "v1", description = "API do projeto cash up", contact = @Contact(name = "João Carlos", email = "joao@cashup.com")))
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
