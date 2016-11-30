package com.zva.requestHandlers;


import com.zva.dao.zone.ZoneDAO;
import com.zva.dto.zone.ZoneDTO;
import com.zva.rest.response.zone.ZoneResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System-2 on 11/29/2016.
 */
public class ZoneRequestHandler {
    public List<ZoneResponse> getZones(int cityId) throws SQLException {

        ZoneDAO zoneDAO = new ZoneDAO();
        List<ZoneResponse> getZonesResponses = new ArrayList<ZoneResponse>();
            List<ZoneDTO> zoneDTOList = zoneDAO
                    .getAllZones(cityId);

            for (ZoneDTO zoneDTO : zoneDTOList) {
                ZoneResponse getZoneResponse = new ZoneResponse();
                getZoneResponse.setId(zoneDTO.getId());
                getZoneResponse.setCityId(zoneDTO.getCityId());
                getZoneResponse.setZone(zoneDTO.getZone());
                getZoneResponse.setStatus(zoneDTO.getStatus());
                getZonesResponses.add(getZoneResponse);
            }
        return getZonesResponses;
    }
}
