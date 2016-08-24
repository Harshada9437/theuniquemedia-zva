package com.mpal.dao.user;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.user.UserAutomobileMapDTO;
import com.mpal.dto.user.UsersDTO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/22/2016.
 */
public class UserAutomobileMapDAO {
    public List<Integer> getListOfAutomobiles(int userId, String status) throws SQLException, IOException{
        List<Integer> automobileDetailsIds = new ArrayList<Integer>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT DISTINCT automobile_details_id FROM automobile_details_user_map where user_id = ")
                    .append(userId);
            if(status != null){
                query.append(" AND status = '").append(status).append("'");
            }
            ResultSet resultSet = statement.executeQuery(query.toString());
            while (resultSet.next()) {
                automobileDetailsIds.add(resultSet.getInt("automobile_details_id"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return automobileDetailsIds;
    }

    public Boolean updateUserAutomobileMapping(int automobileDetailsId, int userId, String status) throws SQLException {
        Boolean isUpdated = Boolean.FALSE;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection
                    .prepareStatement("UPDATE automobile_details_user_map SET status = ? where automobile_details_id = ? AND user_id = ?;");
            int parameterIndex = 1;
            preparedStatement.setString(parameterIndex++, status);
            preparedStatement.setInt(parameterIndex++, automobileDetailsId);
            preparedStatement.setInt(parameterIndex++,
                    userId);

            int i = preparedStatement.executeUpdate();
            isUpdated = i> 0;
        } catch (SQLException sqlException) {
            connection.rollback();
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    public Boolean insertUserAutomobileMapping(int automobileDetailsId, int userId) throws SQLException,IOException {
        Boolean isInserted = Boolean.FALSE;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO automobile_details_user_map(automobile_details_id, user_id, status) VALUES (?,?,?);");
            int parameterIndex = 1;
            preparedStatement.setInt(parameterIndex++, automobileDetailsId);
            preparedStatement.setInt(parameterIndex++,
                    userId);
            preparedStatement.setString(parameterIndex++,
                    "A");
            int i = preparedStatement.executeUpdate();
            isInserted = i > 0;
        } catch (SQLException sqlException) {
            connection.rollback();
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isInserted;
    }

    public List<UserAutomobileMapDTO> getUsersAutomobileMapList(int userId) throws SQLException,
            IOException {
        Connection connection = null;
        Statement statement = null;
        List<UserAutomobileMapDTO> userAutomobileMapResponseList = new ArrayList<UserAutomobileMapDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM automobile_details_user_map where user_id = ")
                    .append(userId);
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                UserAutomobileMapDTO userAutomobileMapDTO = new UserAutomobileMapDTO();
                userAutomobileMapDTO.setId(resultSet.getInt("id"));
                userAutomobileMapDTO.setUserId(resultSet.getInt("user_id"));
                userAutomobileMapDTO.setAutomobileDetailsId( resultSet.getInt("automobile_details_id"));
                userAutomobileMapDTO.setStatus( resultSet.getString("status"));
                userAutomobileMapResponseList.add(userAutomobileMapDTO);
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

        return userAutomobileMapResponseList;
    }
}
