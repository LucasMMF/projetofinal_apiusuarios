package br.com.cotiinformatica.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users", description = "Controller for users")
@RestController
public class PasswordRecoveryController {

	@Operation(
		summary = "User's password recovery",
		description = "ENDPOINT for the recovery of an user's password"
	)
	@PostMapping("/api/users/password-recover")
	public ResponseEntity<Object> post() {
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
	}
	
}
