package br.com.cotiinformatica.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDTO {

	private String message;
	private String id;
	private String name;
	private String email;
	private String phone;
	
}
