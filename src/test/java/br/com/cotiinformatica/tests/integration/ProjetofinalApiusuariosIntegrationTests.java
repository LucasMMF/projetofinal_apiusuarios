package br.com.cotiinformatica.tests.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetofinalApiusuariosIntegrationTests {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void registrationTest() throws Exception {
		mock.perform(
				post("/api/users/create")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(null))
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
