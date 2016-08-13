package com.mpal.dao.automobile;

/**
 * Created by System1 on 8/11/2016.
 */

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.automobile.AutomobileTypesDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutomobileTypesDAO implements IAutomobileTypesDAO {
    public List<AutomobileTypesDTO> getAllAutomobileTypes() throws SQLException
    {
        List<AutomobileTypesDTO> automobileTypesDTOList = new ArrayList<AutomobileTypesDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM automobile_type");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index=1;
            while (resultSet.next()) {
                AutomobileTypesDTO automobileTypesDTO = new AutomobileTypesDTO();
                automobileTypesDTO.setId(resultSet.getInt("id"));
                automobileTypesDTO.setType(resultSet.getString("type"));
                index++;
                automobileTypesDTOList.add(automobileTypesDTO);
            }
            if (index == 1) {
                throw new AutomobileNotFoundException("Invalid automobile");
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
        return automobileTypesDTOList;
    }

    public int getAutomobileIdByType(String type) throws SQLException, IOException
    {
        Connection connection = null;
        Statement statement = null;
        int id=0;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder( "SELECT id FROM automobile_types where type = \"")
                    .append(type).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index = 1;
            while (resultSet.next()) {
                 id= resultSet.getInt("id");
                index++;
            }
            if (index == 1) {
                throw new AutomobileNotFoundException("Invalid automobile");
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
        return id;
    }
}
