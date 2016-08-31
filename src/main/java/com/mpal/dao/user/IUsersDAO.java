package com.mpal.dao.user;

import java.sql.SQLException;

import com.mpal.dto.user.LoginResponseDTO;
import com.mpal.dto.user.UsersDTO;

public interface IUsersDAO {
	Boolean insertUser(UsersDTO usersDTO) throws SQLException;

	LoginResponseDTO getNamePasswordForLoginValidationForName(String email)
			throws SQLException;
}
