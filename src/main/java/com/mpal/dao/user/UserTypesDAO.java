package com.mpal.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.user.userTypesDTO;

public class UserTypesDAO implements IUserTypesDAO {
	public List<userTypesDTO> getAllUserTypes() throws SQLException
			 {
		List<userTypesDTO> userTypesDTOList = new ArrayList<userTypesDTO>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = new ConnectionPool().getConnection();
			statement = connection.createStatement();
			StringBuilder query = new StringBuilder("SELECT * FROM user_type");
			ResultSet resultSet = statement.executeQuery(query.toString());
			while (resultSet.next()) {
				userTypesDTO userTypesDTO = new userTypesDTO();
				userTypesDTO.setType(resultSet.getString(1));
				userTypesDTO.setStatus(resultSet.getString(2));
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
