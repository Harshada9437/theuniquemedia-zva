package com.mpal.dao.automobileInfo;

import com.mpal.bo.request.automobileInfo.UpdateAutomobileInfoBO;
import com.mpal.dao.UtilClasses.ConnectionPool;
import com.mpal.dto.automobileInfo.AutomobileInfoDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by System2 on 8/12/2016.
 */
public class AutomobileInfoDAO {

    public Integer insertAutomobileinfo(AutomobileInfoDTO automobileinfoDTO) throws SQLException,
            IOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO automobile_info(id, name, automobileInfo_type_id, address, city, state, lat, log, phone_no, mobile_no, opening_time, closing_time, status ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(parameterIndex++, automobileinfoDTO.getId());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getName());
            preparedStatement.setInt(parameterIndex++, automobileinfoDTO.getAutomobileInfoId());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getAddress());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getCity());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getState());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getLat());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getLog());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getPhoneNo());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getMobileNo());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getOpeningTime());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getClosingTime());
            preparedStatement.setString(parameterIndex++, automobileinfoDTO.getStatus());

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
                            "Creating AutomobileInfo failed, no ID obtained.");
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

    public Boolean updateAutomobileInfo(UpdateAutomobileInfoBO updateautomobileInfoRequestBO) throws SQLException,
    IOException{

        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionPool().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE automobile_info SET name=?, address=?, city=?, state=?, lat=?, log=?, phone_no=?, mobile_no=?, opening_time=?, closing_time=?, status=? WHERE id=?;");

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getName());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getAddress());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getCity());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getState());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getLat());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getLog());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getPhoneNo());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getMobileNo());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getOpeningTime());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getClosingTime());

            preparedStatement.setString(parameterIndex++, updateautomobileInfoRequestBO.getStatus());

            preparedStatement.setInt(parameterIndex++, updateautomobileInfoRequestBO.getId());

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
