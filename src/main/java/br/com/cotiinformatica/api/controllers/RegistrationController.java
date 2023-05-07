package br.com.cotiinformatica.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.application.dtos.ExceptionHandlerDTO;
import br.com.cotiinformatica.application.dtos.RegisterDTO;
import br.com.cotiinformatica.application.dtos.RegisterResponseDTO;
import br.com.cotiinformatica.application.interfaces.IUserAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Users", description = "Controller for users")
@RestController
public class RegistrationController {
	
	@Autowired
	private IUserAppService userAppService;

	@Operation(
		summary = "User registration",
		description = "ENDPOINT for the registration of an user",
		responses = {
				@ApiResponse(
					description = "Created",
					responseCode = "201",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisterResponseDTO.class))
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
	@PostMapping("/api/users/create")
	public ResponseEntity<RegisterResponseDTO> post(@Valid @RequestBody RegisterDTO dto) {
		
		RegisterResponseDTO response = userAppService.register(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
