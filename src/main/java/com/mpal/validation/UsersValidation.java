package com.mpal.validation;

import com.mpal.bo.request.user.LoginRequestBO;
import com.mpal.bo.request.user.RegistrationRequestBO;
import com.mpal.dto.user.LoginResponseDTO;

public class UsersValidation {

	public Boolean validateRegistration(
			RegistrationRequestBO registrationRequestBO) {
		return Boolean.TRUE;
	}

	public Boolean validateEmailPassword(LoginRequestBO loginRequestBo,
			LoginResponseDTO loginResponseDTO) {
		Boolean isValid = Boolean.FALSE;
		if (loginResponseDTO == null) {
			isValid = Boolean.FALSE;
		} else if (!loginRequestBo.getPassword().equals(
				loginResponseDTO.getPassword())) {
			isValid = Boolean.FALSE;
		} else{
			isValid = Boolean.TRUE;
		}
		return isValid;
	}

}
