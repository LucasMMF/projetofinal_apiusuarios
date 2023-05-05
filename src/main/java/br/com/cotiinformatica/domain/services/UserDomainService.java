package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.interfaces.IUserDomainService;
import br.com.cotiinformatica.domain.models.User;

public class UserDomainService implements IUserDomainService {

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
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
