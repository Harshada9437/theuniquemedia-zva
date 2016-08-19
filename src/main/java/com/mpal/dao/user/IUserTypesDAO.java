package com.mpal.dao.user;

import com.mpal.dto.user.UserTypesDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hp on 07-02-2016.
 */
public interface IUserTypesDAO {
	List<UserTypesDTO> getAllUserTypes() throws SQLException;
}
