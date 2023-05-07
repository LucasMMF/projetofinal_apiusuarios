package br.com.cotiinformatica.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
	
	@Query("{email : ?0}")
	Optional<User> findByEmail(String email);
	
	@Query("{email : ?0, password : ?1}")
	Optional<User> findByEmailAndPassword(String email, String Password);
	
}
