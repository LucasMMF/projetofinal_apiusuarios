package br.com.cotiinformatica.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users", description = "Controller for users")
@RestController
public class RegistrationController {

	@Operation(
		summary = "User registration",
		description = "ENDPOINT for the registration of an user"
	)
	@PostMapping("/api/users/create")
	public ResponseEntity<Object> post() {
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
	}
	
}
