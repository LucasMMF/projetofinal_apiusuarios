package br.com.cotiinformatica.application.interfaces;

import br.com.cotiinformatica.application.dtos.AuthenticateDTO;
import br.com.cotiinformatica.application.dtos.AuthenticateResponseDTO;
import br.com.cotiinformatica.application.dtos.PasswordRecoverDTO;
import br.com.cotiinformatica.application.dtos.PasswordRecoverResponseDTO;
import br.com.cotiinformatica.application.dtos.RegisterDTO;
import br.com.cotiinformatica.application.dtos.RegisterResponseDTO;

public interface IUserAppService {

	RegisterResponseDTO register(RegisterDTO dto);
	
	AuthenticateResponseDTO authenticate(AuthenticateDTO dto);
	
	PasswordRecoverResponseDTO passwordRecover(PasswordRecoverDTO dto);
	
}
