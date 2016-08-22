package com.mpal.dao.user;

import com.mpal.dao.UtilClasses.ConnectionPool;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/22/2016.
 */
public class UserServiceMapDAO {
    public static List<Integer> getListOfServices(int userId, String status) throws SQLException,IOException {
        List<Integer> serviceIds = new ArrayList<Integer>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT DISTINCT service_id FROM service_user_map where user_id = ")
                    .append(userId);
            if(status != null){
                query.append(" AND status = '").append(status).append("'");
            }
            ResultSet resultSet = statement.executeQuery(query.toString());
            while (resultSet.next()) {
                serviceIds.add(resultSet.getInt("service_id"));
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
        return serviceIds;

    }

    public Boolean updateUserServiceMapping(Integer serviceId, Integer userId, String status) throws SQLException,IOException {
        Boolean isUpdated = Boolean.FALSE;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection
                    .prepareStatement("UPDATE service_user_map SET status = ? where service_id = ? AND user_id = ?;");
            int parameterIndex = 1;
            preparedStatement.setString(parameterIndex++, status);
            preparedStatement.setInt(parameterIndex++, serviceId);
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

    public Boolean insertUserServiceMapping(Integer serviceId, Integer userId) throws SQLException,IOException {
        Boolean isInserted = Boolean.FALSE;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO service_user_map(service_id, user_id, status) VALUES (?,?,?);");
            int parameterIndex = 1;
            preparedStatement.setInt(parameterIndex++, serviceId);
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
}
