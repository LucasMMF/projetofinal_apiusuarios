package br.com.cotiinformatica.domain.services;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.interfaces.IUserDomainService;
import br.com.cotiinformatica.domain.models.User;
import br.com.cotiinformatica.infrastructure.components.MD5Component;
import br.com.cotiinformatica.infrastructure.repositories.UserRepository;

@Service
public class UserDomainService implements IUserDomainService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MD5Component md5Component;

	@Override
	public void register(User user) {
		
		Optional<User> optional = userRepository.findByEmail(user.getEmail());
		
		if (optional.isPresent())
			throw new IllegalArgumentException("O email informado já foi cadastrado.");
		
		try {
			
			user.setPassword(md5Component.encryptToMD5(user.getPassword()));
			
		} catch (NoSuchAlgorithmException ex) {
			
			ex.printStackTrace();
			
		}
		
		user.setId(UUID.randomUUID());
		user.setDateTimeCreated(Instant.now());
		user.setDateTimeLastUpdated(user.getDateTimeCreated());
		
		userRepository.save(user);
	}

	@Override
	public User authenticate(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User passwordRecover(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
