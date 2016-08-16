package com.mpal.dao.serviceprovider;

import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.serviceprovider.ServiceProviderDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    IOException{

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
        }
        System.out.println("isCreated:::" + isCreated);
        return isCreated;

    }
}
