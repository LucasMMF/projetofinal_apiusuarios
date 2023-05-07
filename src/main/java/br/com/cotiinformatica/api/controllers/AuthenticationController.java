package br.com.cotiinformatica.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.application.dtos.AuthenticateDTO;
import br.com.cotiinformatica.application.dtos.AuthenticateResponseDTO;
import br.com.cotiinformatica.application.dtos.ExceptionHandlerDTO;
import br.com.cotiinformatica.application.services.UserAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Users", description = "Controller for users")
@RestController
public class AuthenticationController {
	
	@Autowired
	private UserAppService userAppService;

	@Operation(
		summary = "User authentication",
		description = "ENDPOINT for the authentication of an user",
		responses = {
				@ApiResponse(
					description = "OK",
					responseCode = "200",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticateResponseDTO.class))
				),
				@ApiResponse(
					description = "Bad request", 
					responseCode = "400", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandlerDTO.class))
				),
				@ApiResponse(
					description = "Internal Server Error", 
					responseCode = "500", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandlerDTO.class))
				)
		}
	)
	@PostMapping("/api/users/login")
	public ResponseEntity<AuthenticateResponseDTO> post(@Valid @RequestBody AuthenticateDTO dto) {
		
		AuthenticateResponseDTO response = userAppService.authenticate(dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
