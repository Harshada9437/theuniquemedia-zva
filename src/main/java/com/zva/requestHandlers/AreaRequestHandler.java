package com.zva.requestHandlers;

;
import com.zva.dao.area.AreaDAO;
import com.zva.dto.area.AreaDTO;
import com.zva.rest.response.area.AreaResponse;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by System2 on 8/12/2016.
 */
public class AreaRequestHandler {

    public List<AreaResponse> getAreas(int zoneId) throws SQLException{
        AreaDAO areaDAO = new AreaDAO();
        List<AreaResponse> serviceProviderList = new ArrayList<AreaResponse>();
        try {
            serviceProviderList = getServiceProviderResponseListFromDTOs(areaDAO.getAreas(zoneId));
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return serviceProviderList;
    }

    private List<AreaResponse> getServiceProviderResponseListFromDTOs(List<AreaDTO> areaDTOS) throws SQLException{
        List<AreaResponse> areaResponseList = new ArrayList<AreaResponse>();
        Iterator<AreaDTO> areaDTOIterator = areaDTOS.iterator();
        while(areaDTOIterator.hasNext()){
            AreaDTO areaDTO = areaDTOIterator.next();
            AreaResponse areaResponse = new AreaResponse(areaDTO.getId(),
                    areaDTO.getArea(),
                    areaDTO.getZone(),
                    areaDTO.getStatus());
            areaResponseList.add(areaResponse);
        }
        return areaResponseList;
    }
}
