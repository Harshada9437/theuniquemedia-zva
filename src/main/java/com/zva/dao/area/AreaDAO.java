package com.zva.dao.area;

import com.zva.dao.UtilClasses.ConnectionHandler;
import com.zva.dto.area.AreaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System2 on 8/12/2016.
 */
public class AreaDAO {

    public List<AreaDTO> getAreas(int zoneId) throws SQLException {
            Connection connection = null;
            Statement statement = null;
            List<AreaDTO> areaDTOList = new ArrayList<AreaDTO>();
            try {
                connection = new ConnectionHandler().getConnection();
                statement = connection.createStatement();
                StringBuilder query = new StringBuilder("SELECT a.id, a.area, z.zone, a.status\n" +
                        " FROM area_mstr a inner join zone_mstr z\n" +
                        "on a.zone_mstr_id=z.id  \n" +
                        "where a.zone_mstr_id =" + zoneId);
                ResultSet resultSet = statement.executeQuery(query.toString()
                        .trim());

                int index=1;
                while (resultSet.next()) {
                    AreaDTO areaDTO = new AreaDTO();
                    areaDTO.setId(resultSet.getInt("id"));
                    areaDTO.setArea(resultSet.getString("area"));
                    areaDTO.setZone(resultSet.getString("zone"));
                    areaDTO.setStatus(resultSet.getString("status"));
                    index++;
                    areaDTOList.add(areaDTO);
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
            return areaDTOList;
        }
}
