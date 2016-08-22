package com.mpal.dao.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mpal.bo.request.user.ChangePasswordBO;
import com.mpal.bo.request.user.UpdaterUserBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.automobile.AutomobileDTO;
import com.mpal.dto.user.LoginResponseDTO;
import com.mpal.dto.user.UsersDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;
import com.mpal.rest.response.user.UserLoggedInResponse;
import com.mpal.rest.response.user.UserResponseList;

public class UsersDAO {

    public Integer insertUser(UsersDTO usersDTO) throws SQLException,
            IOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO users(user_type_id, address, name, mobile, email, gender, DOB, latitude, longitude, password, client_details_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(parameterIndex++, usersDTO.getUserTypeId());
            preparedStatement.setString(parameterIndex++, usersDTO.getName());
            preparedStatement.setString(parameterIndex++, usersDTO.getAddress());
            preparedStatement.setString(parameterIndex++, usersDTO.getMobile());
            preparedStatement.setString(parameterIndex++, usersDTO.getEmail());
            preparedStatement.setString(parameterIndex++, usersDTO.getGender());
            preparedStatement.setString(parameterIndex++,(usersDTO.getDOB()));
            preparedStatement.setString(parameterIndex++, usersDTO.getLatitude());
            preparedStatement.setString(parameterIndex++, usersDTO.getLongitude());
            preparedStatement.setString(parameterIndex++,
                    usersDTO.getPassword());
            preparedStatement.setInt(parameterIndex++, usersDTO.getClientDetailsId());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }

            try {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException(
                            "Creating user failed, no ID obtained.");
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean getValidationForEmail(String email) throws SQLException,
            UserNotFoundException {
        Connection connection = null;
        Statement statement = null;
        Boolean isProcessed = Boolean.FALSE;
        try
        {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT email FROM users where email = \"")
                    .append(email).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {

                isProcessed = true;

            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isProcessed;
    }

    public Boolean updateUser(UpdaterUserBO updateUserBO) throws SQLException,
            IOException {
        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE users SET name =? , mobile =? ,  email =? , status =? , address=? , latitude=? , longitude=? , gender=? , DOB=? WHERE id =?;");

            preparedStatement.setString(parameterIndex++, updateUserBO.getName());

            preparedStatement.setString(parameterIndex++, updateUserBO.getMobile());

            preparedStatement.setString(parameterIndex++, updateUserBO.getEmail());

            preparedStatement.setString(parameterIndex++, updateUserBO.getStatus());

            preparedStatement.setString(parameterIndex++, updateUserBO.getAddress());

            preparedStatement.setString(parameterIndex++, updateUserBO.getLatitude());

            preparedStatement.setString(parameterIndex++, updateUserBO.getLongitude());

            preparedStatement.setString(parameterIndex++, updateUserBO.getGender());

            preparedStatement.setString(parameterIndex++, updateUserBO.getDOB());

            preparedStatement.setInt(parameterIndex++, updateUserBO.getId());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
                isCreated = Boolean.TRUE;
            } else {
                connection.rollback();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isCreated;
    }

    public Boolean updateSessionId(int userId, Long sessionId)
            throws SQLException {
        boolean isUpdated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            StringBuffer query = new StringBuffer(
                    "UPDATE users SET sessionId = ").append(sessionId)
                    .append(" WHERE id = ").append(userId);
            preparedStatement = connection.prepareStatement(query.toString());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
                isUpdated = Boolean.TRUE;
            } else {
                connection.rollback();
            }
        } catch (SQLException sqlException) {
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

    public Boolean updateVerifiedUser(int userId)
            throws SQLException, IOException {
        boolean isUpdated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            StringBuffer query = new StringBuffer(
                    "UPDATE users SET isVerified = ").append("'true'")
                    .append(" WHERE id = ").append(userId);
            preparedStatement = connection.prepareStatement(query.toString());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
                isUpdated = Boolean.TRUE;
            } else {
                connection.rollback();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    public LoginResponseDTO getNamePasswordForLoginValidationForEmailAndStatus(
            String email) throws SQLException,
            UserNotFoundException {
        Connection connection = null;
        Statement statement = null;
        LoginResponseDTO loginResponseDTO = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT id, password FROM users where email = \"")
                    .append(email).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int rowCount = 0;
            loginResponseDTO = new LoginResponseDTO();
            while (resultSet.next()) {
                loginResponseDTO.setEmail(email);
                loginResponseDTO.setId(resultSet.getInt("id"));
                loginResponseDTO.setPassword(resultSet.getString("password"));
                rowCount++;
            }
            if (rowCount == 0) {
                throw new UserNotFoundException("User name invalid");
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
        return loginResponseDTO;
    }

    public UsersDTO getUserById(int id) throws SQLException, UserNotFoundException {
        Connection connection = null;
        Statement statement = null;
        UsersDTO usersDTO = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM users where id = ").append(id);
            ResultSet resultSet = statement.executeQuery(query.toString()
                    .trim());

            usersDTO = new UsersDTO();
            int index = 1;
            while (resultSet.next()) {
                usersDTO.setId(resultSet.getInt("id"));
                usersDTO.setUserTypeId(resultSet.getInt("user_type_id"));
                usersDTO.setName(resultSet.getString("name"));
                usersDTO.setAddress(resultSet.getString("address"));
                usersDTO.setMobile(resultSet.getString("mobile"));
                usersDTO.setEmail(resultSet.getString("email"));
                usersDTO.setGender(resultSet.getString("gender"));
                usersDTO.setDOB(resultSet.getString("DOB"));
                usersDTO.setLatitude(resultSet.getString("latitude"));
                usersDTO.setLongitude(resultSet.getString("longitude"));
                usersDTO.setPassword(resultSet.getString("password"));
                usersDTO.setClientDetailsId(resultSet.getInt("client_details_id"));
                usersDTO.setStatus(resultSet.getString("status"));
                index++;
            }

            if (index == 1) {
                throw new UserNotFoundException("Invalid user");
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

        return usersDTO;
    }

    public List<UsersDTO> getUsersList() throws SQLException,
            IOException {
        Connection connection = null;
        Statement statement = null;
        List<UsersDTO> userResponseList = new ArrayList<UsersDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM users ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                UsersDTO usersDTO = new UsersDTO();
                usersDTO.setId(resultSet.getInt("id"));
                usersDTO.setUserTypeId(resultSet.getInt("user_type_id"));
                usersDTO.setName( resultSet.getString("name"));
                usersDTO.setAddress( resultSet.getString("address"));
                usersDTO.setMobile( resultSet.getString("mobile"));
                usersDTO.setEmail( resultSet.getString("email"));
                usersDTO.setGender( resultSet.getString("gender"));
                usersDTO.setDOB( resultSet.getString("DOB"));
                usersDTO.setLatitude( resultSet.getString("latitude"));
                usersDTO.setLongitude( resultSet.getString("longitude"));
                usersDTO.setPassword(resultSet.getString("password"));
                usersDTO.setClientDetailsId(resultSet.getInt("client_details_id"));
                usersDTO.setStatus(resultSet.getString("status"));
                usersDTO.setIsVerified(resultSet.getString("isVerified"));
                userResponseList.add(usersDTO);
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

        return userResponseList;
    }

    public List<UserLoggedInResponse> getUserLoggedIn() throws SQLException,
            IOException {
        Connection connection = null;
        Statement statement = null;
        List<UserLoggedInResponse> userLoggedinList = new ArrayList<UserLoggedInResponse>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE sessionId IS NOT NULL";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                UserLoggedInResponse userResponse = new UserLoggedInResponse(
                        resultSet.getInt("id"),
                        resultSet.getString("email"));
                userLoggedinList.add(userResponse);
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

        return userLoggedinList;
    }

    public Boolean changePassword(ChangePasswordBO changePwdBO) {
        Boolean isProcessed = Boolean.FALSE;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            String query = "SELECT password FROM users WHERE id="
                    + changePwdBO.getUserId();

            ResultSet resultSet = statement.executeQuery(query);
            String oldDBpassword = null;
            while (resultSet.next()) {
                oldDBpassword = resultSet.getString("password");
            }

            if (oldDBpassword != null && changePwdBO.getOldPassword() != null
                    && oldDBpassword.equals(changePwdBO.getOldPassword())) {
                if (updatePassword(changePwdBO.getNewPassword(),
                        changePwdBO.getUserId(), connection)) {
                    isProcessed = Boolean.TRUE;
                }
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
        return isProcessed;
    }

    private boolean updatePassword(String newPassword, int userId,
                                   Connection connection) throws SQLException {
        boolean isUpdated = false;
        connection.setAutoCommit(false);
        String query = "UPDATE users SET password=\"" + newPassword
                + "\" WHERE id=" + userId;

        PreparedStatement preparedStatement = connection
                .prepareStatement(query);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            connection.commit();
            isUpdated = Boolean.TRUE;
        } else {
            connection.rollback();
        }
        return isUpdated;
    }

    public String getSessionIdForUserId(
            int userId) throws SQLException, IOException,
            UserNotFoundException {
        Connection connection = null;
        Statement statement = null;
        String sessionId = "";
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT sessionId FROM users where id = ")
                    .append(userId);
            ResultSet resultSet = statement.executeQuery(query.toString());
            int rowCount = 0;
            while (resultSet.next()) {
                sessionId = resultSet.getBigDecimal("sessionId") + "";
                rowCount++;
            }
            if (rowCount == 0) {
                throw new UserNotFoundException("User name invalid");
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
        return sessionId;
    }

    public List<UsersDTO> getUserByTypeId(int user_type_id) throws SQLException, UserNotFoundException
        {
            Connection connection = null;
            Statement statement = null;
            List<UsersDTO> userTypeResponseList=new ArrayList<UsersDTO>();
            try {
                connection = new ConnectionPool().getConnection();
                statement = connection.createStatement();
                StringBuilder query = new StringBuilder(
                        "SELECT * FROM users where user_type_id = \"")
                        .append(user_type_id).append("\"");
                ResultSet resultSet = statement.executeQuery(query.toString()
                        .trim());
                int index = 1;
                while (resultSet.next()) {
                    UsersDTO usersDTO = new UsersDTO();
                    usersDTO.setId(resultSet.getInt("id"));
                    usersDTO.setName(resultSet.getString("name"));
                    usersDTO.setAddress(resultSet.getString("address"));
                    usersDTO.setMobile(resultSet.getString("mobile"));
                    usersDTO.setEmail(resultSet.getString("email"));
                    usersDTO.setGender(resultSet.getString("gender"));
                    usersDTO.setDOB(resultSet.getString("DOB"));
                    usersDTO.setLatitude(resultSet.getString("latitude"));
                    usersDTO.setLongitude(resultSet.getString("longitude"));
                    usersDTO.setUserTypeId(resultSet.getInt("user_type_id"));
                    usersDTO.setClientDetailsId(resultSet.getInt("client_details_id"));
                    usersDTO.setStatus(resultSet.getString("status"));
                    usersDTO.setIsVerified(resultSet.getString("isVerified"));
                    index++;
                    userTypeResponseList.add(usersDTO);
                }
                if (index == 1) {
                    throw new UserNotFoundException("Invalid user");
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
            return userTypeResponseList;
        }

}
