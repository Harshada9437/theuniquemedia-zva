package com.mpal.requestHandlers;

import com.mpal.dao.services.ServiceDAO;
import com.mpal.dto.services.ServiceDTO;
import com.mpal.rest.response.services.ServiceResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class ServiceRequestHandler {
    public List<ServiceResponse> getService() throws SQLException{

        ServiceDAO serviceDAO = new ServiceDAO();
        List<ServiceResponse> getServiceTypesResponses = new ArrayList<ServiceResponse>();
        try {
            List<ServiceDTO>  serviceDTOList = serviceDAO
                    .getAllService();

            for (com.mpal.dto.services.ServiceDTO serviceDTO : serviceDTOList) {
                ServiceResponse getServiceResponse = new ServiceResponse();
                getServiceResponse.setId(serviceDTO.getId());
                getServiceResponse.setServiceName(serviceDTO.getServiceName());
                getServiceResponse.setImagePath(serviceDTO.getImagePath());
                getServiceResponse.setStatus(serviceDTO.getStatus());
                getServiceTypesResponses.add(getServiceResponse);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        return getServiceTypesResponses;
    }
}
