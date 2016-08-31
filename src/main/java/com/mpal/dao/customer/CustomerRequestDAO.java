package com.mpal.dao.customer;

import com.mpal.bo.request.customer.UpdateCustomerRequestBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.customer.CustomerRequestDTO;
import com.mpal.dto.customer.RequestCDTO;
import com.mpal.dto.customer.RequestDTO;
import com.mpal.dto.customer.RequestMDTO;
import com.mpal.exceptions.RequestException.RequestNotFoundException;
import com.mpal.util.DateUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class CustomerRequestDAO {
    public Boolean createCustomerRequest(CustomerRequestDTO customerRequestDTO) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Boolean isCreated = Boolean.FALSE;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO request(mechanic_id, service_id, customer_id, automobile_details_id, token) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(parameterIndex++, customerRequestDTO.getMechanicId());
            preparedStatement.setInt(parameterIndex++, customerRequestDTO.getServiceId());
            preparedStatement.setInt(parameterIndex++, customerRequestDTO.getCustomerId());
            preparedStatement.setInt(parameterIndex++, customerRequestDTO.getAutomobileDetailsId());
            preparedStatement.setString(parameterIndex++, customerRequestDTO.getToken());

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
                    .prepareStatement("UPDATE request SET status =?, updated_by =?, updated_dtm =? WHERE token =?;");


            preparedStatement.setString(parameterIndex++, updateCustomerRequestBO.getStatus());

            preparedStatement.setInt(parameterIndex++, updateCustomerRequestBO.getUpdatedBy());

            java.util.Date date = new java.util.Date();
            Timestamp t1 = new Timestamp(date.getTime());
            String updated_date = DateUtil.getDateStringFromTimeStamp(t1);

            preparedStatement.setString(parameterIndex++, updated_date);

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
        return isCreated;
    }


    public List<RequestCDTO> getRequestListByCustomer(int customer_id) throws SQLException,
            IOException {
        Connection connection = null;
        Statement statement = null;
        List<RequestCDTO> requestResponseList = new ArrayList<RequestCDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT u.name as mech_name, u.mobile as mech_no, u.email as mech_email,s.id as service_id,s.service_name as service_name,a.company as make,a.model as model," +
                            "r.id,r.token,r.status,r.created_dtm,r.updated_dtm,r.updated_by\n" +
                            "FROM request r\n" +
                            "INNER JOIN users u\n" +
                            "   ON u.id = r.mechanic_id\n" +
                            "INNER JOIN services s\n" +
                            "   ON s.id=r.service_id\n" +
                            "INNER JOIN automobile_details a\n" +
                            "   ON a.id=r.automobile_details_id\n" +
                            "where r.customer_id =").append(customer_id);
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                RequestCDTO customerRequestDTO = new RequestCDTO();
                customerRequestDTO.setMechName(resultSet.getString("mech_name"));
                customerRequestDTO.setMechNo(resultSet.getString("mech_no"));
                customerRequestDTO.setMechEmail(resultSet.getString("mech_email"));
                customerRequestDTO.setServiceId(resultSet.getInt("service_id"));
                customerRequestDTO.setServiceName(resultSet.getString("service_name"));
                customerRequestDTO.setMake(resultSet.getString("make"));
                customerRequestDTO.setModel(resultSet.getString("model"));
                customerRequestDTO.setId(resultSet.getInt("id"));
                String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                customerRequestDTO.setCreatedDtm(create_date);
                String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                customerRequestDTO.setUpdatedDtm(update_date);
                customerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                customerRequestDTO.setToken(resultSet.getString("token"));
                customerRequestDTO.setStatus(resultSet.getString("status"));
                requestResponseList.add(customerRequestDTO);
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

    public CustomerRequestDTO getRequestByToken(String token) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        CustomerRequestDTO customerRequestDTO = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM request where token =\"").append(token).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString()
                    .trim());

            customerRequestDTO = new CustomerRequestDTO();
            int index = 1;
            while (resultSet.next()) {
                customerRequestDTO.setId(resultSet.getInt("id"));
                customerRequestDTO.setMechanicId(resultSet.getInt("mechanic_id"));
                customerRequestDTO.setCustomerId(resultSet.getInt("customer_id"));
                customerRequestDTO.setAutomobileDetailsId(resultSet.getInt("automobile_details_id"));
                customerRequestDTO.setServiceId(resultSet.getInt("service_id"));
                customerRequestDTO.setCreatedDtm(resultSet.getString("created_dtm"));
                customerRequestDTO.setUpdatedDtm(resultSet.getString("updated_dtm"));
                customerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                customerRequestDTO.setToken(resultSet.getString("token"));
                customerRequestDTO.setStatus(resultSet.getString("status"));
                index++;
            }

            if (index == 1) {
                throw new RequestNotFoundException("Invalid request");
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

        return customerRequestDTO;
    }

    public List<RequestMDTO> getRequestByMechanic(int mechanic_id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        List<RequestMDTO> requestResponseList = new ArrayList<RequestMDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT u1.name as customer_name, u1.mobile as customer_no,  u1.email as customer_email\n" +
                            ",s.id as service_id,s.service_name as service_name \n" +
                            ",a.company as make,a.model as model,\n" +
                            "r.id,r.token,r.status,r.created_dtm,r.updated_dtm,r.updated_by\n" +
                            "FROM request r\n" +
                            "INNER JOIN users u1\n" +
                            "   ON u1.id = r.customer_id\n" +
                            "INNER JOIN services s\n" +
                            "   ON s.id=r.service_id\n" +
                            "INNER JOIN automobile_details a\n" +
                            "   ON a.id=r.automobile_details_id\n" +
                            "where r.mechanic_id =").append(mechanic_id);
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                RequestMDTO customerRequestDTO = new RequestMDTO();
                customerRequestDTO.setCustomerName(resultSet.getString("customer_name"));
                customerRequestDTO.setCustomerNo(resultSet.getString("customer_no"));
                customerRequestDTO.setCustomerEmail(resultSet.getString("customer_email"));
                customerRequestDTO.setServiceId(resultSet.getInt("service_id"));
                customerRequestDTO.setServiceName(resultSet.getString("service_name"));
                customerRequestDTO.setMake(resultSet.getString("make"));
                customerRequestDTO.setModel(resultSet.getString("model"));
                customerRequestDTO.setId(resultSet.getInt("id"));
                String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                customerRequestDTO.setCreatedDtm(create_date);
                String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                customerRequestDTO.setUpdatedDtm(update_date);
                customerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                customerRequestDTO.setToken(resultSet.getString("token"));
                customerRequestDTO.setStatus(resultSet.getString("status"));
                requestResponseList.add(customerRequestDTO);
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

    public List<RequestDTO> getRequestListByToken(String token) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        List<RequestDTO> requestResponseList = new ArrayList<RequestDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT u.name as mech_name, u.mobile as mech_no, u.email as mech_email,\n" +
                            " u1.name as customer_name, u1.mobile as customer_no,  u1.email as customer_email\n" +
                            ",s.id as service_id,s.service_name as service_name \n" +
                            ",a.company as make,a.model as model,\n" +
                            "r.id,r.token,r.status,r.created_dtm,r.updated_dtm,r.updated_by\n" +
                            "FROM request r\n" +
                            "INNER JOIN users u\n" +
                            "   ON u.id = r.mechanic_id\n" +
                            "INNER JOIN users u1\n" +
                            "   ON u1.id = r.customer_id\n" +
                            "INNER JOIN services s\n" +
                            "   ON s.id=r.service_id\n" +
                            "INNER JOIN automobile_details a\n" +
                            "   ON a.id=r.automobile_details_id\n" +
                            "where r.token=\"").append(token).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                RequestDTO customerRequestDTO = new RequestDTO();
                customerRequestDTO.setMechName(resultSet.getString("mech_name"));
                customerRequestDTO.setMechNo(resultSet.getString("mech_no"));
                customerRequestDTO.setMechEmail(resultSet.getString("mech_email"));
                customerRequestDTO.setCustomerName(resultSet.getString("customer_name"));
                customerRequestDTO.setCustomerNo(resultSet.getString("customer_no"));
                customerRequestDTO.setCustomerEmail(resultSet.getString("customer_email"));
                customerRequestDTO.setServiceId(resultSet.getInt("service_id"));
                customerRequestDTO.setServiceName(resultSet.getString("service_name"));
                customerRequestDTO.setMake(resultSet.getString("make"));
                customerRequestDTO.setModel(resultSet.getString("model"));
                customerRequestDTO.setId(resultSet.getInt("id"));
                String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                customerRequestDTO.setCreatedDtm(create_date);
                String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                customerRequestDTO.setUpdatedDtm(update_date);
                customerRequestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                customerRequestDTO.setToken(resultSet.getString("token"));
                customerRequestDTO.setStatus(resultSet.getString("status"));
                requestResponseList.add(customerRequestDTO);
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

    public List<RequestDTO> getRequestList() throws SQLException {
            Connection connection = null;
            Statement statement = null;
            List<RequestDTO> requestResponseList = new ArrayList<RequestDTO>();
            try {
                connection = new ConnectionPool().getConnection();
                statement = connection.createStatement();
                String query = "SELECT u.name as mech_name, u.mobile as mech_no, u.email as mech_email,\n" +
                        " u1.name as customer_name, u1.mobile as customer_no,  u1.email as customer_email\n" +
                        ",s.id as service_id,s.service_name as service_name \n" +
                        ",a.company as make,a.model as model,\n" +
                        "r.id,r.token,r.status,r.created_dtm,r.updated_dtm,r.updated_by\n" +
                        "FROM request r\n" +
                        "INNER JOIN users u\n" +
                        "   ON u.id = r.mechanic_id\n" +
                        "INNER JOIN users u1\n" +
                        "   ON u1.id = r.customer_id\n" +
                        "INNER JOIN services s\n" +
                        "   ON s.id=r.service_id\n" +
                        "INNER JOIN automobile_details a\n" +
                        "   ON a.id=r.automobile_details_id;";
                ResultSet resultSet = statement.executeQuery(query.toString());

                while (resultSet.next()) {
                    RequestDTO requestDTO = new RequestDTO();
                    requestDTO.setMechName(resultSet.getString("mech_name"));
                    requestDTO.setMechNo(resultSet.getString("mech_no"));
                    requestDTO.setMechEmail(resultSet.getString("mech_email"));
                    requestDTO.setCustomerName(resultSet.getString("customer_name"));
                    requestDTO.setCustomerNo(resultSet.getString("customer_no"));
                    requestDTO.setCustomerEmail(resultSet.getString("customer_email"));
                    requestDTO.setServiceId(resultSet.getInt("service_id"));
                    requestDTO.setServiceName(resultSet.getString("service_name"));
                    requestDTO.setMake(resultSet.getString("make"));
                    requestDTO.setModel(resultSet.getString("model"));
                    requestDTO.setId(resultSet.getInt("id"));
                    String create_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("created_dtm"));
                    requestDTO.setCreatedDtm(create_date);
                    String update_date = DateUtil.getDateStringFromTimeStamp(resultSet.getTimestamp("updated_dtm"));
                    requestDTO.setUpdatedDtm(update_date);
                    requestDTO.setUpdatedBy(resultSet.getInt("updated_by"));
                    requestDTO.setToken(resultSet.getString("token"));
                    requestDTO.setStatus(resultSet.getString("status"));
                    requestResponseList.add(requestDTO);
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
