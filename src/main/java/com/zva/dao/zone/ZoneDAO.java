package com.zva.dao.zone;

import com.zva.dao.UtilClasses.ConnectionHandler;
import com.zva.dto.zone.ZoneDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System-2 on 11/29/2016.
 */
public class ZoneDAO {
    public List<ZoneDTO> getAllZones(int cityId) throws SQLException {
        List<ZoneDTO> allZones = new ArrayList<ZoneDTO>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT z.id, z.zone, c.city, z.status\n" +
                    " FROM zone_mstr z inner join city_mstr_mstr c\n" +
                    "on z.city_mstr_id=c.id  \n" +
                    "where z.city_mstr_id =" + cityId);
            ResultSet resultSet = statement.executeQuery(query.toString());

            while (resultSet.next()) {
                ZoneDTO zoneDTO = new ZoneDTO();
                zoneDTO.setId(resultSet.getInt("id"));
                zoneDTO.setCityId(resultSet.getInt("city"));
                zoneDTO.setZone(resultSet.getString("zone"));
                zoneDTO.setStatus(resultSet.getString("status"));
                allZones.add(zoneDTO);
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
        return allZones;
    }
}
