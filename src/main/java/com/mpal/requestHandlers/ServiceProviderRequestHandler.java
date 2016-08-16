package com.mpal.requestHandlers;

import com.mpal.bo.request.serviceprovider.ServiceProviderBO;
import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;
import com.mpal.dao.serviceprovider.ServiceProviderDAO;
import com.mpal.dto.serviceprovider.ServiceProviderDTO;

import java.io.IOException;
import java.sql.SQLException;

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

}