package br.com.cotiinformatica.domain.models;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

	@Id
	private UUID id;
	
	private String name;
	
	@Indexed(unique = true)
	private String email;
	
	private String phone;
	
	private String password;
	
	private Instant dateTimeCreated;
	
	private Instant dateTimeLastUpdated;
	
	@Transient
	private String accessToken;
	
	@Transient
	private String newPassword;
	
}
