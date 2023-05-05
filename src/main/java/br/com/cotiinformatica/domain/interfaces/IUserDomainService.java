package br.com.cotiinformatica.domain.interfaces;

import br.com.cotiinformatica.domain.models.User;

public interface IUserDomainService {

	void register(User user);
	
	User authenticate(String email, String senha);
	
	User passwordRecover(String email);
	
}
