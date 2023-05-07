package br.com.cotiinformatica.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components()).info(
			new Info()
				.title("API Usuários - COTI Informática")
				.description("API Spring Boot para controle de usuários.")
				.contact(
					new Contact()
						.name("Lucas Mateus Midão Fernandes")
						.email("mateusmidao@gmail.com")
						.url("https://github.com/LucasMMF")
				)
				.version("v1")
		);
	}
	
}
