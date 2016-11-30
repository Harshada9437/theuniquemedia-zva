package com.zva.requestHandlers;

import com.zva.dao.cities.CityDAO;
import com.zva.dto.city.CityDTO;
import com.zva.rest.response.cities.CityResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class CityRequestHandler {
    public List<CityResponse> getCities(int stateId) throws SQLException{

        CityDAO cityDAO = new CityDAO();
        List<CityResponse> getCityResponses = new ArrayList<CityResponse>();
        try {
            List<CityDTO> cityDTOList = cityDAO
                    .getAllCities(stateId);

            for (CityDTO cityDTO : cityDTOList) {
                CityResponse getCityResponse = new CityResponse();
                getCityResponse.setId(cityDTO.getId());
                getCityResponse.setState(cityDTO.getState());
                getCityResponse.setCity(cityDTO.getCity());
                getCityResponse.setStatus(cityDTO.getStatus());
                getCityResponses.add(getCityResponse);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        return getCityResponses;
    }
}
