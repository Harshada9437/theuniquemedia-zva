package com.mpal.dao.automobile;

import com.mpal.bo.request.automobile.UpdateAutomobileBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.automobile.AutomobileDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileDAO {

    public List<AutomobileDTO> getAutomobilesList() throws SQLException {
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
                automobileDTO.setId(resultSet.getInt("id"));
                automobileDTO.setCompany(resultSet.getString("company"));
                automobileDTO.setModel(resultSet.getString("model"));
                automobileDTO.setAutomobileTypeId(resultSet.getInt("automobile_type_id"));
                automobileDTO.setStatus(resultSet.getString("status"));
                index++;
                automobileTypeResponseList.add(automobileDTO);
            }
            if (index == 1) {
                throw new AutomobileNotFoundException("Invalid automobile type.");
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

    public Integer insertAutomobile(AutomobileDTO automobileDTO) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO automobile_details(company, model, automobile_type_id) VALUES (?,?,?)");

            preparedStatement.setString(parameterIndex++, automobileDTO.getCompany());
            preparedStatement.setString(parameterIndex++, automobileDTO.getModel());
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


    public String getValidationForModel(String model) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        String modelUsed = null;

        try {
            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();
            StringBuilder query1 = new StringBuilder(
                    "SELECT model FROM automobile_details where model = \"")
                    .append(model).append("\"");
            ResultSet resultSet = statement.executeQuery(query1.toString().toUpperCase());


            while (resultSet.next()) {

                modelUsed = resultSet.getString("model");
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return modelUsed;
    }

    public String getValidationForCompany(String company) throws SQLException{
        Connection connection = null;
        Statement statement = null;

        String companyUsed = null;

        try {

            connection = new ConnectionPool().getConnection();
            statement = connection.createStatement();

            StringBuilder query = new StringBuilder(
                    "SELECT company FROM automobile_details where company = \"")
                    .append(company).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString().toUpperCase());


            while (resultSet.next()) {

                companyUsed=resultSet.getString("company");

            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return companyUsed;
    }


    public Boolean updateAutomobile(UpdateAutomobileBO updateAutomobileBO) throws SQLException {
        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE automobile_details SET model =? , company =?  WHERE id =?;");

            preparedStatement.setString(parameterIndex++, updateAutomobileBO.getModel());

            preparedStatement.setString(parameterIndex++, updateAutomobileBO.getCompany());

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
        return isCreated;
    }
}
