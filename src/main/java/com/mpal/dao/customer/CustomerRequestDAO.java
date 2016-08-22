package com.mpal.dao.customer;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.customer.CreateCustomerRequestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
