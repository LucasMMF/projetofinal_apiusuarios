package br.com.cotiinformatica.tests.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.application.dtos.RegisterDTO;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetofinalApiusuariosIntegrationTests {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void registrationTest() throws Exception {
		
		RegisterDTO dto = new RegisterDTO();
		Faker faker = new Faker(Locale.of("pt", "BR"));
		
		dto.setName(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		dto.setPhone(faker.number().digits(10).toString());
		dto.setPassword("@Teste1234");
		
		mock.perform(
				post("/api/users/create")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))
		)
		.andExpect(status().isCreated());
	}

	@Test
	public void authenticationTest() throws Exception {
		mock.perform(
				post("/api/users/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(null))
		)
		.andExpect(status().isOk());
	}
	
	@Test
	public void passwordRecoveryTest() throws Exception {
		mock.perform(
				post("/api/users/password-recover")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(null))
		)
		.andExpect(status().isOk());
	}

}
