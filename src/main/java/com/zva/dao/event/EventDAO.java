package com.zva.dao.event;

import com.zva.dao.UtilClasses.ConnectionHandler;
import com.zva.dto.event.EventDTO;
import com.zva.dto.event.EventSubTypeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System-2 on 11/29/2016.
 */
public class EventDAO {

    public List<EventDTO> getEvents() throws SQLException {
        List<EventDTO> events = new ArrayList<EventDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM city_mstr");
            ResultSet resultSet = statement.executeQuery(query.toString());
            while (resultSet.next()) {
                EventDTO eventDTO = new EventDTO();
                eventDTO.setId(resultSet.getInt("id"));
                eventDTO.setType(resultSet.getString("type"));
                eventDTO.setStatus(resultSet.getString("status"));
                events.add(eventDTO);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return events;
    }

    public List<EventSubTypeDTO> getEventSubTypes(int eventId) throws SQLException {
        List<EventSubTypeDTO> eventSubTypes = new ArrayList<EventSubTypeDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT c.id, s.type as event_type , m.sub_type, c.status\n" +
                    " FROM event_sub_type_map c inner join event_type s\n" +
                    "on c.event_type_id=s.id  \n" +
                    "inner join event_sub_type m\n" +
                    "on c.sub_type_id= m.id \n" +
                    "where c.event_type_id =" + eventId);
            ResultSet resultSet = statement.executeQuery(query.toString());
            while (resultSet.next()) {
                EventSubTypeDTO eventSubTypeDTO = new EventSubTypeDTO();
                eventSubTypeDTO.setId(resultSet.getInt("id"));
                eventSubTypeDTO.setEventTypeId(resultSet.getInt("event_type"));
                eventSubTypeDTO.setSubType(resultSet.getString("sub_type"));
                eventSubTypeDTO.setStatus(resultSet.getString("status"));
                eventSubTypes.add(eventSubTypeDTO);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw  e;
            }
        }
        return eventSubTypes;
    }
}
