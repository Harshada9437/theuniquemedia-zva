package com.mpal.dao.automobile;

/**
 * Created by System1 on 8/11/2016.
 */

import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.automobile.AutomobileTypesDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileTypeNotFoundException;

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
            StringBuilder query = new StringBuilder("SELECT * FROM automobile_types");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index=1;
            while (resultSet.next()) {
                AutomobileTypesDTO automobileTypesDTO = new AutomobileTypesDTO();
                automobileTypesDTO.setId(resultSet.getInt("id"));
                automobileTypesDTO.setType(resultSet.getString("type"));
                index++;
                automobileTypesDTOList.add(automobileTypesDTO);
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

    public Integer getAutomobileTypesDetails(int automobileTypeId) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        int typeId=0;
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT id FROM automobile_types where id = " + automobileTypeId);
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index=1;
            while (resultSet.next()) {
                typeId=resultSet.getInt(1);
                index++;
            }
            if(index==1){
                throw new AutomobileTypeNotFoundException("Invalid type id");
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
        return typeId;
    }
}
