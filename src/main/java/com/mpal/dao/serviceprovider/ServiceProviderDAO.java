package com.mpal.dao.serviceprovider;

import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.serviceprovider.ServiceProviderDTO;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System2 on 8/12/2016.
 */
public class ServiceProviderDAO {

    public Integer insertServiceProvider(ServiceProviderDTO serviceProviderDTO) throws SQLException,
            IOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO service_provider(id, name, service_provider_type_id, address, city, state, lat, log, phone_no, mobile_no, opening_time, closing_time, status ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(parameterIndex++, serviceProviderDTO.getId());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getName());
            preparedStatement.setInt(parameterIndex++, serviceProviderDTO.getServiceProviderId());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getAddress());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getCity());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getState());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getLat());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getLog());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getPhoneNo());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getMobileNo());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getOpeningTime());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getClosingTime());
            preparedStatement.setString(parameterIndex++, serviceProviderDTO.getStatus());

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
                            "Creating serviceProvider failed, no ID obtained.");
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

    public Boolean updateServiceProvider(UpdateServiceProviderBO updateServiceProviderRequestBO) throws SQLException,
            IOException {

        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE service_provider SET name=?, address=?, city=?, state=?, lat=?, log=?, phone_no=?, mobile_no=?, opening_time=?, closing_time=?, status=? WHERE id=?;");

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getName());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getAddress());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getCity());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getState());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getLat());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getLog());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getPhoneNo());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getMobileNo());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getOpeningTime());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getClosingTime());

            preparedStatement.setString(parameterIndex++, updateServiceProviderRequestBO.getStatus());

            preparedStatement.setInt(parameterIndex++, updateServiceProviderRequestBO.getId());

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
            return isCreated;

        }
    }

    public List<ServiceProviderDTO> getAllServiceProviderByTypeId(int service_provider_type_id) throws SQLException, UserNotFoundException {
            Connection connection = null;
            Statement statement = null;
            ServiceProviderDTO serviceProviderDTO = null;
            List<ServiceProviderDTO> ServiceProviderDTOList = new ArrayList<ServiceProviderDTO>();
            try {
                connection = new ConnectionPool().getConnection();
                statement = connection.createStatement();
                StringBuilder query = new StringBuilder(
                        "SELECT * FROM service_provider where service_provider_type_id = ").append(service_provider_type_id);
                ResultSet resultSet = statement.executeQuery(query.toString()
                        .trim());

                serviceProviderDTO = new ServiceProviderDTO();
                while (resultSet.next()) {
                    serviceProviderDTO.setId(resultSet.getInt("id"));
                    serviceProviderDTO.setName(resultSet.getString("name"));
                    serviceProviderDTO.setAddress(resultSet.getString("address"));
                    serviceProviderDTO.setCity(resultSet.getString("city"));
                    serviceProviderDTO.setState(resultSet.getString("state"));
                    serviceProviderDTO.setMobileNo(resultSet.getString("mobile_no"));
                    serviceProviderDTO.setPhoneNo(resultSet.getString("phone_no"));
                    serviceProviderDTO.setLat(resultSet.getString("lat"));
                    serviceProviderDTO.setLog(resultSet.getString("log"));
                    serviceProviderDTO.setOpeningTime(resultSet.getString("opening_time"));
                    serviceProviderDTO.setClosingTime(resultSet.getString("closing_time"));
                    serviceProviderDTO.setServiceProviderId(resultSet.getInt("service_provider_type_id"));
                    serviceProviderDTO.setStatus(resultSet.getString("status"));
                    ServiceProviderDTOList.add(serviceProviderDTO);
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
            return ServiceProviderDTOList;
        }
}
