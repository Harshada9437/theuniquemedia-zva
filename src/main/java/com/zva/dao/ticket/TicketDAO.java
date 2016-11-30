package com.zva.dao.ticket;

import com.zva.dao.UtilClasses.ConnectionHandler;
import com.zva.dto.ticket.*;

import com.zva.util.DateUtil;

import java.sql.*;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class TicketDAO {
    public int createTicket(TicketDTO ticketDTO) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int id = 0;
        try {
            int parameterIndex = 1;
            connection = new ConnectionHandler().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("INSERT INTO request_tickets_details(request_details_id, vendor_id, updated_date, status) VALUES (?,?,?,?)");
            preparedStatement.setInt(parameterIndex++, ticketDTO.getRequestId());
            preparedStatement.setInt(parameterIndex++, ticketDTO.getVendorId());

            java.util.Date date = new java.util.Date();
            Timestamp t1 = new Timestamp(date.getTime());
            String updated_date = DateUtil.getDateStringFromTimeStamp(t1);

            preparedStatement.setString(parameterIndex++, updated_date);
            preparedStatement.setString(parameterIndex++, ticketDTO.getStatus());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }
            try {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException(
                            "Creating student failed, no ID obtained.");
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                throw sqlException;
            }
        } catch (SQLException sqlException) {
            connection.rollback();
            sqlException.printStackTrace();
            throw sqlException;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return id;
    }

    public static TicketDTO getTicketById(int id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        TicketDTO ticketDTO = new TicketDTO();
        try {
            connection = new ConnectionHandler().getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM request_tickets_details where id =" + id);
            ResultSet resultSet = statement.executeQuery(query.toString());
            int index = 1;
            while (resultSet.next()) {
                ticketDTO.setRequestId(resultSet.getInt("request_details_id"));
                ticketDTO.setStatus(resultSet.getString("status"));
                index++;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ticketDTO;
    }

   /* public void insertTicketLog(TicketDTO ticketDTO) {
    }*/

    public Boolean updateTicket(TicketDTO ticketDTO) throws SQLException {
        boolean isCreated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            int parameterIndex = 1;
            connection = new ConnectionHandler().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement("UPDATE request_tickets_details SET status =?, updated_date=?, updated_by=? WHERE id =?;");

            preparedStatement.setString(parameterIndex++, ticketDTO.getStatus());

            java.util.Date date = new java.util.Date();
            Timestamp t1 = new Timestamp(date.getTime());
            String updated_date = DateUtil.getDateStringFromTimeStamp(t1);

            preparedStatement.setString(parameterIndex++, updated_date);

            preparedStatement.setInt(parameterIndex++, ticketDTO.getUpdatedBy());

            preparedStatement.setInt(parameterIndex++, ticketDTO.getId());


            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
                isCreated = Boolean.TRUE;
            } else {
                connection.rollback();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
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
