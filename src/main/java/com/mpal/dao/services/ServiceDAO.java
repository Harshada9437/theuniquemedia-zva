package com.mpal.dao.services;

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.serviceprovider.ServiceProviderTypesDTO;
import com.mpal.dto.services.ServiceDTO;
import com.mpal.exceptions.ServiceExceptions.ServiceNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class ServiceDAO {
    public List<ServiceDTO> getAllService() throws SQLException{
        List<ServiceDTO> serviceDTOList = new ArrayList<ServiceDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM services");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index=1;
            while (resultSet.next()) {
                ServiceDTO serviceDTO = new ServiceDTO();
                serviceDTO.setId(resultSet.getInt("id"));
                serviceDTO.setServiceName(resultSet.getString("service_name"));
                serviceDTO.setImagePath(resultSet.getString("image_path"));
                serviceDTO.setStatus(resultSet.getString("status"));
                index++;
                serviceDTOList.add(serviceDTO);
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
        return serviceDTOList;
    }
}
