package com.mpal.dao.serviceprovider;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.serviceprovider.ServiceProviderTypesDTO;
import com.mpal.exceptions.ServiceExceptions.ServiceNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/16/2016.
 */
public class ServiceProviderTypesDAO implements IServiceProviderTypesDAO {

    @Override
    public List<ServiceProviderTypesDTO> getAllServiceTypes() throws SQLException {

        List<ServiceProviderTypesDTO> serviceProviderTypesDTOList = new ArrayList<ServiceProviderTypesDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM service_provider_type");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index=1;
            while (resultSet.next()) {
                ServiceProviderTypesDTO serviceProviderTypesDTO = new ServiceProviderTypesDTO();
                serviceProviderTypesDTO.setId(resultSet.getInt("id"));
                serviceProviderTypesDTO.setType(resultSet.getString("type"));
                index++;
                serviceProviderTypesDTOList.add(serviceProviderTypesDTO);
            }
            if (index == 1) {
                throw new ServiceNotFoundException("Invalid service");
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
        return serviceProviderTypesDTOList;
    }
}
