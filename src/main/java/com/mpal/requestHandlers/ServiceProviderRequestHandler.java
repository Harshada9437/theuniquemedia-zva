package com.mpal.requestHandlers;

import com.mpal.bo.request.serviceprovider.ServiceProviderBO;
import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;;
import com.mpal.dao.serviceprovider.ServiceProviderDAO;
import com.mpal.dao.serviceprovider.ServiceProviderTypesDAO;
import com.mpal.dto.serviceprovider.ServiceProviderDTO;
import com.mpal.dto.serviceprovider.ServiceProviderTypesDTO;
import com.mpal.rest.response.serviceprovider.ServiceTypeResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System2 on 8/12/2016.
 */
public class ServiceProviderRequestHandler {

    public boolean create_service_provider(ServiceProviderBO serviceProviderBO) {

        Boolean isProcessed = Boolean.TRUE;
        String msg="notcreated";
        Integer automobileId=null;

        ServiceProviderDAO serviceProviderDAO = new ServiceProviderDAO();
        try {
            serviceProviderDAO.insertServiceProvider(buildServiceProviderDTOFromBO(serviceProviderBO));
        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }

        if (isProcessed=false) {
            //EmailService.sendNewUserEmail(registrationRequestBO.getEmail(), userId);
        }

        return isProcessed;
    }

    private ServiceProviderDTO buildServiceProviderDTOFromBO(ServiceProviderBO requestBO) {

        ServiceProviderDTO ServiceProviderDTO = new ServiceProviderDTO();

        ServiceProviderDTO.setId(requestBO.getId());
        ServiceProviderDTO.setName(requestBO.getName());
        ServiceProviderDTO.setServiceProviderId(requestBO.getServiceProviderId());
        ServiceProviderDTO.setAddress(requestBO.getAddress());
        ServiceProviderDTO.setCity(requestBO.getCity());
        ServiceProviderDTO.setState(requestBO.getState());
        ServiceProviderDTO.setLat(requestBO.getLat());
        ServiceProviderDTO.setLog(requestBO.getLog());
        ServiceProviderDTO.setOpeningTime(requestBO.getOpeningTime());
        ServiceProviderDTO.setClosingTime(requestBO.getClosingTime());
        ServiceProviderDTO.setPhoneNo(requestBO.getPhoneNo());
        ServiceProviderDTO.setMobileNo(requestBO.getMobileNo());
        ServiceProviderDTO.setStatus(requestBO.getStatus());

        return ServiceProviderDTO;
    }

    public boolean updateServiceProvider(UpdateServiceProviderBO updateServiceProviderRequestBO) throws SQLException,
    IOException{

        Boolean isProcessed = Boolean.FALSE;
        ServiceProviderDAO serviceProviderDAO = new ServiceProviderDAO();
        try {
            isProcessed = serviceProviderDAO.updateServiceProvider(updateServiceProviderRequestBO);
        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }
        return isProcessed;
    }

    public List<ServiceTypeResponse> getServiceTypes() {

        ServiceProviderTypesDAO serviceProviderTypesDAO = new ServiceProviderTypesDAO();
        List<ServiceTypeResponse> getServiceTypesResponses = new ArrayList<ServiceTypeResponse>();
        try {
            List<ServiceProviderTypesDTO>  serviceProviderTypesDTOList = serviceProviderTypesDAO
                    .getAllServiceTypes();

            for (com.mpal.dto.serviceprovider.ServiceProviderTypesDTO serviceProviderTypesDTO : serviceProviderTypesDTOList) {
                ServiceTypeResponse getServiceTypeResponse = new ServiceTypeResponse();
                getServiceTypeResponse.setId(serviceProviderTypesDTO.getId());
                getServiceTypeResponse.setType(serviceProviderTypesDTO.getType());
                getServiceTypesResponses.add(getServiceTypeResponse);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        return getServiceTypesResponses;
    }

}
