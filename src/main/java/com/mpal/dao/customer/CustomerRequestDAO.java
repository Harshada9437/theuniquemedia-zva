package com.mpal.dao.customer;

import com.mpal.bo.request.customer.UpdateCustomerRequestBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.customer.CreateCustomerRequestDTO;
import com.mpal.dto.user.UsersDTO;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;
import com.mpal.util.DateUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class CustomerRequestDAO {
    public Boolean createCustomerRequest(CreateCustomerRequestDTO createCustomerRequestDTO) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Boolean isCreated = Boolean.FALSE;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO request(mechanic_id, service_id, customer_id, automobile_details_id, token) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(parameterIndex++, createCustomerRequestDTO.getMechanicId());
            preparedStatement.setInt(parameterIndex++, createCustomerRequestDTO.getServiceId());
            preparedStatement.setInt(parameterIndex++, createCustomerRequestDTO.getCustomerId());
            preparedStatement.setInt(parameterIndex++, createCustomerRequestDTO.getAutomobileDetailsId());
            preparedStatement.setString(parameterIndex++, createCustomerRequestDTO.getToken());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                isCreated = Boolean.TRUE;
                connection.commit();
            } else {
                connection.rollback();
                isCreated = Boolean.TRUE;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            isCreated = Boolean.TRUE;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                isCreated = Boolean.TRUE;
            }
        }
        return isCreated;
    }

    public Boolean updateCustomerRequest(UpdateCustomerRequestBO updateCustomerRequestBO, String token) throws SQLException,
            IOException {
        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE request SET status =?, updated_by =? WHERE token =?;");


            preparedStatement.setString(parameterIndex++, updateCustomerRequestBO.getStatus());

            preparedStatement.setInt(parameterIndex++, updateCustomerRequestBO.getUpdatedBy());

            preparedStatement.setString(parameterIndex++, token);

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

        //System.out.println("isCreated:::" + isCreated);

        return isCreated;
    }


    public List<CreateCustomerRequestDTO> getRequestListByCustomer(int customer_id) throws SQLException,
                IOException {
            Connection connection = null;
            Statement statement = null;
            List<CreateCustomerRequestDTO> requestResponseList = new ArrayList<CreateCustomerRequestDTO>();
            try {
                connection = new ConnectionPool().getConnection();
                statement = connection.createStatement();
                StringBuilder query = new StringBuilder(
                        "SELECT * FROM request where customer_id =").append(customer_id);
                ResultSet resultSet = statement.executeQuery(query.toString());

                while (resultSet.next()) {
                    CreateCustomerRequestDTO createCustomerRequestDTO = new CreateCustomerRequestDTO();
                    createCustomerRequestDTO.setId(resultSet.getInt("id"));
                    createCustomerRequestDTO.setCustomerId(resultSet.getInt("customer_id"));
                    createCustomerRequestDTO.setMechanicId( resultSet.getInt("mechanic_id"));
                    createCustomerRequestDTO.setAutomobileDetailsId( resultSet.getInt("automobile_details_id"));
                    createCustomerRequestDTO.setServiceId( resultSet.getInt("service_id"));
                    String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                    createCustomerRequestDTO.setCreatedDtm( create_date);
                    String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                    createCustomerRequestDTO.setUpdatedDtm( update_date);
                    createCustomerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                    createCustomerRequestDTO.setToken( resultSet.getString("token"));
                    createCustomerRequestDTO.setStatus( resultSet.getString("status"));
                    requestResponseList.add(createCustomerRequestDTO);
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

            return requestResponseList;
        }

    public CreateCustomerRequestDTO getRequestByToken(String token) throws SQLException
    {
            Connection connection = null;
            Statement statement = null;
            CreateCustomerRequestDTO createCustomerRequestDTO = null;
            try {
                connection = new ConnectionPool().getConnection();
                statement = connection.createStatement();
                StringBuilder query = new StringBuilder(
                        "SELECT * FROM request where token =\"").append(token).append("\"");
                ResultSet resultSet = statement.executeQuery(query.toString()
                        .trim());

                createCustomerRequestDTO= new CreateCustomerRequestDTO();
                int index = 1;
                while (resultSet.next()) {
                    createCustomerRequestDTO.setId(resultSet.getInt("id"));
                    createCustomerRequestDTO.setMechanicId(resultSet.getInt("mechanic_id"));
                    createCustomerRequestDTO.setCustomerId(resultSet.getInt("customer_id"));
                    createCustomerRequestDTO.setAutomobileDetailsId(resultSet.getInt("automobile_details_id"));
                    createCustomerRequestDTO.setServiceId(resultSet.getInt("service_id"));
                    createCustomerRequestDTO.setCreatedDtm(resultSet.getString("created_dtm"));
                    createCustomerRequestDTO.setUpdatedDtm(resultSet.getString("updated_dtm"));
                    createCustomerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                    createCustomerRequestDTO.setToken(resultSet.getString("token"));
                    createCustomerRequestDTO.setStatus(resultSet.getString("status"));
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

            return createCustomerRequestDTO;
        }

    public List<CreateCustomerRequestDTO> getRequestByMechanic(int mechanic_id) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        List<CreateCustomerRequestDTO> requestResponseList = new ArrayList<CreateCustomerRequestDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM request where mechanic_id =").append(mechanic_id);
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                CreateCustomerRequestDTO createCustomerRequestDTO = new CreateCustomerRequestDTO();
                createCustomerRequestDTO.setId(resultSet.getInt("id"));
                createCustomerRequestDTO.setCustomerId(resultSet.getInt("customer_id"));
                createCustomerRequestDTO.setMechanicId( resultSet.getInt("mechanic_id"));
                createCustomerRequestDTO.setAutomobileDetailsId( resultSet.getInt("automobile_details_id"));
                createCustomerRequestDTO.setServiceId( resultSet.getInt("service_id"));
                String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                createCustomerRequestDTO.setCreatedDtm( create_date);
                String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                createCustomerRequestDTO.setUpdatedDtm( update_date);
                createCustomerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                createCustomerRequestDTO.setToken( resultSet.getString("token"));
                createCustomerRequestDTO.setStatus( resultSet.getString("status"));
                requestResponseList.add(createCustomerRequestDTO);
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

        return requestResponseList;
    }

    public List<CreateCustomerRequestDTO> getRequestListByToken(String token) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        List<CreateCustomerRequestDTO> requestResponseList = new ArrayList<CreateCustomerRequestDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM request where token =\"").append(token).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                CreateCustomerRequestDTO createCustomerRequestDTO = new CreateCustomerRequestDTO();
                createCustomerRequestDTO.setId(resultSet.getInt("id"));
                createCustomerRequestDTO.setCustomerId(resultSet.getInt("customer_id"));
                createCustomerRequestDTO.setMechanicId( resultSet.getInt("mechanic_id"));
                createCustomerRequestDTO.setAutomobileDetailsId( resultSet.getInt("automobile_details_id"));
                createCustomerRequestDTO.setServiceId( resultSet.getInt("service_id"));
                String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                createCustomerRequestDTO.setCreatedDtm( create_date);
                String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                createCustomerRequestDTO.setUpdatedDtm( update_date);
                createCustomerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                createCustomerRequestDTO.setToken( resultSet.getString("token"));
                createCustomerRequestDTO.setStatus( resultSet.getString("status"));
                requestResponseList.add(createCustomerRequestDTO);
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

        return requestResponseList;
    }
}
