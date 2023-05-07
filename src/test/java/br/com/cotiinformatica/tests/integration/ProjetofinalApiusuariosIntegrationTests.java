package br.com.cotiinformatica.tests.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Locale;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.application.dtos.AuthenticateDTO;
import br.com.cotiinformatica.application.dtos.AuthenticateResponseDTO;
import br.com.cotiinformatica.application.dtos.RegisterDTO;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjetofinalApiusuariosIntegrationTests {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private static String id;
	private static String email;
	private static String password;
	private static String accessToken;
	
	@Test
	@Order(1)
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
		
		email = dto.getEmail();
		password = dto.getPassword();
	}

	@Test
	@Order(2)
	public void authenticationTest() throws Exception {
		
		AuthenticateDTO dto = new AuthenticateDTO();
		
		dto.setEmail(email);
		dto.setPassword(password);
		
		MvcResult result =	mock.perform(
									post("/api/users/login")
									.contentType("application/json")
									.content(objectMapper.writeValueAsString(dto))
							)
							.andExpect(status().isOk())
							.andReturn();
		String content = result.getResponse().getContentAsString();
		AuthenticateResponseDTO response = objectMapper.readValue(content, AuthenticateResponseDTO.class);
		
		id = response.getId();
		accessToken = response.getAccessToken();
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
