package br.com.cotiinformatica.application.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.application.dtos.AuthenticateDTO;
import br.com.cotiinformatica.application.dtos.AuthenticateResponseDTO;
import br.com.cotiinformatica.application.dtos.PasswordRecoverDTO;
import br.com.cotiinformatica.application.dtos.PasswordRecoverResponseDTO;
import br.com.cotiinformatica.application.dtos.RegisterDTO;
import br.com.cotiinformatica.application.dtos.RegisterResponseDTO;
import br.com.cotiinformatica.application.interfaces.IUserAppService;
import br.com.cotiinformatica.domain.interfaces.IUserDomainService;
import br.com.cotiinformatica.domain.models.User;

@Service
public class UserAppService implements IUserAppService {
	
	@Autowired
	private IUserDomainService userDomainService;

	@Override
	public RegisterResponseDTO register(RegisterDTO dto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		User user = modelMapper.map(dto, User.class);
		
		userDomainService.register(user);
		
		RegisterResponseDTO response = modelMapper.map(user, RegisterResponseDTO.class);
		response.setMessage("Conta de usuário criada com sucesso.");
		
		return response;
		
	}

	@Override
	public AuthenticateResponseDTO authenticate(AuthenticateDTO dto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		User user = userDomainService.authenticate(dto.getEmail(), dto.getPassword());
		
		AuthenticateResponseDTO response = modelMapper.map(user, AuthenticateResponseDTO.class);
		response.setMessage("Usuário autenticado com sucesso.");
		
		return response;
		
	}

	@Override
	public PasswordRecoverResponseDTO passwordRecover(PasswordRecoverDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
