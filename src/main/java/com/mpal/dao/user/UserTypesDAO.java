package com.mpal.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.user.UserTypesDTO;

public class UserTypesDAO implements IUserTypesDAO {
	public List<UserTypesDTO> getAllUserTypes() throws SQLException
			 {
		List<UserTypesDTO> userTypesDTOList = new ArrayList<UserTypesDTO>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = new ConnectionPool().getConnection();
			statement = connection.createStatement();
			StringBuilder query = new StringBuilder("SELECT * FROM user_types");
			ResultSet resultSet = statement.executeQuery(query.toString());
			while (resultSet.next()) {
				UserTypesDTO userTypesDTO = new UserTypesDTO();
				userTypesDTO.setId(resultSet.getInt(1));
				userTypesDTO.setType(resultSet.getString(2));
				userTypesDTO.setStatus(resultSet.getString(3));
				userTypesDTOList.add(userTypesDTO);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userTypesDTOList;
             }
}
