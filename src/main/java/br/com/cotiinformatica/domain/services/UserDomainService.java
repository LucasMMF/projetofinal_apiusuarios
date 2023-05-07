package br.com.cotiinformatica.domain.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.interfaces.IUserDomainService;
import br.com.cotiinformatica.domain.models.User;
import br.com.cotiinformatica.infrastructure.components.MD5Component;
import br.com.cotiinformatica.infrastructure.repositories.UserRepository;
import br.com.cotiinformatica.infrastructure.security.TokenCreator;

@Service
public class UserDomainService implements IUserDomainService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MD5Component md5Component;
	
	@Autowired
	private TokenCreator tokenCreator;

	@Override
	public void register(User user) {
		
		Optional<User> optional = userRepository.findByEmail(user.getEmail());
		
		if (optional.isPresent())
			throw new IllegalArgumentException("O email informado já foi cadastrado.");
		
		user.setPassword(md5Component.encryptToMD5(user.getPassword()));
		user.setId(UUID.randomUUID());
		user.setDateTimeCreated(Instant.now());
		user.setDateTimeLastUpdated(user.getDateTimeCreated());
		
		userRepository.save(user);
	}

	@Override
	public User authenticate(String email, String password) {
			
		Optional<User> optional = userRepository.findByEmailAndPassword(email, md5Component.encryptToMD5(password));
		
		if (optional.isEmpty())
			throw new IllegalArgumentException("Acesso negado. Usuário não encontrado.");
		
		User user = optional.get();
		user.setAccessToken(tokenCreator.generateToken(user.getEmail()));
		
		return user;
	}

	@Override
	public User passwordRecover(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
