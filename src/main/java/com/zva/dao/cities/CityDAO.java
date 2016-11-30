package com.zva.dao.cities;

import com.zva.dao.UtilClasses.ConnectionHandler;
import com.zva.dto.city.CityDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class CityDAO {
    public List<CityDTO> getAllCities(int stateId) throws SQLException {
        List<CityDTO> cityDTOList = new ArrayList<CityDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT c.id, s.state as state, c.city, c.status\n" +
                    " FROM city_mstr c inner join state_mstr s\n" +
                    "on c.state_mstr_id=s.id  \n" +
                    "where c.state_mstr_id =" + stateId);
            ResultSet resultSet = statement.executeQuery(query.toString());
            while (resultSet.next()) {
                CityDTO cityDTO = new CityDTO();
                cityDTO.setId(resultSet.getInt("id"));
                cityDTO.setState(resultSet.getString("state"));
                cityDTO.setCity(resultSet.getString("city"));
                cityDTO.setStatus(resultSet.getString("status"));
                cityDTOList.add(cityDTO);
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
        return cityDTOList;
    }
}
