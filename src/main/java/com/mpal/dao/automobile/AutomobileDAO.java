package com.mpal.dao.automobile;

import com.mpal.bo.request.automobile.UpdateAutomobileBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.automobile.AutomobileDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileDAO {

    public List<AutomobileDTO> getAutomobilesList() throws SQLException,
            IOException {
        Connection connection = null;
        Statement statement = null;
        List<AutomobileDTO> automobileResponseList = new ArrayList<AutomobileDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM automobile_details ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                AutomobileDTO automobileDTO = new AutomobileDTO();
                automobileDTO.setCompany(resultSet.getString("company"));
                automobileDTO.setModel(resultSet.getString("model"));
                automobileDTO.setBuiltYear( resultSet.getString("builtYear"));
                automobileDTO.setAutomobileTypeId( resultSet.getInt("automobileTypeId"));
                automobileDTO.setStatus(resultSet.getString("status"));
                automobileResponseList.add(automobileDTO);
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

        return automobileResponseList;
    }

    public List<AutomobileDTO> getAutomobileByTypeId(int automobileTypeId) throws SQLException, AutomobileNotFoundException {
        Connection connection = null;
        Statement statement = null;
        List<AutomobileDTO> automobileTypeResponseList=new ArrayList<AutomobileDTO>();
        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM automobile_details where automobile_type_id = ").append(automobileTypeId);
            ResultSet resultSet = statement.executeQuery(query.toString()
                    .trim());
            int index = 1;
            while (resultSet.next()) {
                AutomobileDTO automobileDTO = new AutomobileDTO();
                automobileDTO.setCompany(resultSet.getString("company"));
                automobileDTO.setModel(resultSet.getString("model"));
                automobileDTO.setBuiltYear(resultSet.getString("builtYear"));
                automobileDTO.setAutomobileTypeId(resultSet.getInt("automobileTypeId"));
                automobileDTO.setStatus(resultSet.getString("status"));
                index++;
                automobileTypeResponseList.add(automobileDTO);
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
        return automobileTypeResponseList;
    }

    public Integer insertAutomobile(AutomobileDTO automobileDTO) throws SQLException,
            IOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO automobile_details(company, model, built_year, automobile_type_id) VALUES (?,?,?,?)");

            preparedStatement.setString(parameterIndex++, automobileDTO.getCompany());
            preparedStatement.setString(parameterIndex++, automobileDTO.getModel());
            preparedStatement.setString(parameterIndex++, automobileDTO.getBuiltYear());
            preparedStatement.setInt(parameterIndex++, automobileDTO.getAutomobileTypeId());

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
                            "Creating Automobile failed, no ID obtained.");
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

    public Boolean updateAutomobile(UpdateAutomobileBO updateAutomobileBO) throws SQLException,
            IOException {
        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE automobile_details SET model =? , company =? ,  built_year =? WHERE id =?;");

            preparedStatement.setString(parameterIndex++, updateAutomobileBO.getModel());

            preparedStatement.setString(parameterIndex++, updateAutomobileBO.getCompany());

            preparedStatement.setString(parameterIndex++, updateAutomobileBO.getBuiltYear());

            preparedStatement.setInt(parameterIndex++, updateAutomobileBO.getId());

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
