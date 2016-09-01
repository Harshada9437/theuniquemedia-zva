package com.mpal.requestHandlers;

import com.mpal.bo.request.serviceprovider.ServiceProviderBO;
import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;;
import com.mpal.dao.serviceprovider.ServiceProviderDAO;
import com.mpal.dao.serviceprovider.ServiceProviderTypesDAO;
import com.mpal.dto.serviceprovider.ServiceProviderDTO;
import com.mpal.dto.serviceprovider.ServiceProviderTypesDTO;
import com.mpal.rest.response.serviceprovider.ServiceProviderResponse;
import com.mpal.rest.response.serviceprovider.ServiceTypeResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by System2 on 8/12/2016.
 */
public class ServiceProviderRequestHandler {

    public boolean createServiceProvider(ServiceProviderBO serviceProviderBO) throws SQLException {

        Boolean isProcessed = Boolean.TRUE;

        ServiceProviderDAO serviceProviderDAO = new ServiceProviderDAO();
        try {
            serviceProviderDAO.insertServiceProvider(buildServiceProviderDTOFromBO(serviceProviderBO));
        } catch (SQLException sq) {
            isProcessed = false;
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

    public boolean updateServiceProvider(UpdateServiceProviderBO updateServiceProviderRequestBO) throws SQLException {

        Boolean isProcessed = Boolean.FALSE;
        ServiceProviderDAO serviceProviderDAO = new ServiceProviderDAO();
        try {
            isProcessed = serviceProviderDAO.updateServiceProvider(updateServiceProviderRequestBO);
        } catch (SQLException sq) {
            isProcessed = false;
        }
        return isProcessed;
    }

    public List<ServiceTypeResponse> getServiceTypes() throws SQLException {

        ServiceProviderTypesDAO serviceProviderTypesDAO = new ServiceProviderTypesDAO();
        List<ServiceTypeResponse> getServiceTypesResponses = new ArrayList<ServiceTypeResponse>();
        try {
            List<ServiceProviderTypesDTO>  serviceProviderTypesDTOList = serviceProviderTypesDAO
                    .getAllServiceTypes();

            for (com.mpal.dto.serviceprovider.ServiceProviderTypesDTO serviceProviderTypesDTO : serviceProviderTypesDTOList) {
                ServiceTypeResponse getServiceTypeResponse = new ServiceTypeResponse();
                getServiceTypeResponse.setId(serviceProviderTypesDTO.getId());
                getServiceTypeResponse.setType(serviceProviderTypesDTO.getType());
                getServiceTypeResponse.setStatus(serviceProviderTypesDTO.getStatus());
                getServiceTypesResponses.add(getServiceTypeResponse);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        return getServiceTypesResponses;
    }

    public List<ServiceProviderResponse> getServiceProvider(int serviceProviderTypeId) throws SQLException {
        ServiceProviderDAO serviceProviderDAO = new ServiceProviderDAO();
        List<ServiceProviderResponse> getServiceProviderResponses = new ArrayList<ServiceProviderResponse>();
        try {
            List<ServiceProviderDTO>  serviceProviderDTOList = serviceProviderDAO
                    .getAllServiceProviderByTypeId(serviceProviderTypeId);

            for (com.mpal.dto.serviceprovider.ServiceProviderDTO serviceProviderDTO : serviceProviderDTOList) {
                ServiceProviderResponse getServiceResponse = new ServiceProviderResponse();
                getServiceResponse.setId(serviceProviderDTO.getId());
                getServiceResponse.setName(serviceProviderDTO.getName());
                getServiceResponse.setAddress(serviceProviderDTO.getAddress());
                getServiceResponse.setCity(serviceProviderDTO.getCity());
                getServiceResponse.setState(serviceProviderDTO.getState());
                getServiceResponse.setMobileNo(serviceProviderDTO.getMobileNo());
                getServiceResponse.setPhoneNo(serviceProviderDTO.getPhoneNo());
                getServiceResponse.setLat(serviceProviderDTO.getLat());
                getServiceResponse.setLog(serviceProviderDTO.getLog());
                getServiceResponse.setOpeningTime(serviceProviderDTO.getOpeningTime());
                getServiceResponse.setClosingTime(serviceProviderDTO.getClosingTime());
                getServiceResponse.setServiceProviderId(serviceProviderDTO.getServiceProviderId());
                getServiceResponse.setStatus(serviceProviderDTO.getStatus());
                getServiceProviderResponses.add(getServiceResponse);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        return getServiceProviderResponses;
    }
}
