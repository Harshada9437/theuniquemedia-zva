package com.mpal.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.user.UserTypesDTO;
import com.mpal.exceptions.userServiceExceptions.UserTypeNotFoundException;

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
				userTypesDTO.setId(resultSet.getInt("id"));
				userTypesDTO.setType(resultSet.getString("type"));
				userTypesDTO.setStatus(resultSet.getString("status"));
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

    public Integer getUserTypesDetails(int userTypeId) throws SQLException {
        Connection connection = null;
        Statement statement = null;
		int typeId=0;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT id FROM user_types where id = " + userTypeId);
            ResultSet resultSet = statement.executeQuery(query.toString());
			int index=1;
            while (resultSet.next()) {
                typeId=resultSet.getInt(1);
				index++;
			}
			if(index==1){
				throw new UserTypeNotFoundException("Invalid type id");
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
        return typeId;
    }
}
