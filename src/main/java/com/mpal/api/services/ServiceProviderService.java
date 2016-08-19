package com.mpal.api.services;

import com.mpal.bo.request.serviceprovider.ServiceProviderBO;
import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;
import com.mpal.requestHandlers.ServiceProviderRequestHandler;

import com.mpal.rest.request.serviceprovider.UpdateServiceProviderRequest;
import com.mpal.rest.request.serviceprovider.ServiceProviderRequest;
import com.mpal.rest.response.serviceprovider.ServiceProviderCreationResponse;
import com.mpal.rest.response.serviceprovider.ServiceTypeResponseList;
import com.mpal.rest.response.serviceprovider.UpdateServiceProviderResponse;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by System2 on 8/12/2016.
 */

@Path("/service_provider")

public class ServiceProviderService {

    @POST
    @Path("/create_service_provider")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateServiceProvider(ServiceProviderRequest serviceRequest) {


        ServiceProviderBO serviceProviderBO = new ServiceProviderBO();


        serviceProviderBO.setId(serviceRequest.getId());
        serviceProviderBO.setName(serviceRequest.getName());
        serviceProviderBO.setServiceProviderId(serviceRequest.getServiceProviderId());
        serviceProviderBO.setAddress(serviceRequest.getAddress());
        serviceProviderBO.setCity(serviceRequest.getCity());
        serviceProviderBO.setState(serviceRequest.getState());
        serviceProviderBO.setLat(serviceRequest.getLat());
        serviceProviderBO.setLog(serviceRequest.getLog());
        serviceProviderBO.setStatus(serviceRequest.getStatus());
        serviceProviderBO.setPhoneNo(serviceRequest.getPhoneNo());
        serviceProviderBO.setMobileNo(serviceRequest.getMobileNo());
        serviceProviderBO.setOpeningTime(serviceRequest.getOpeningTime());
        serviceProviderBO.setClosingTime(serviceRequest.getClosingTime());


        ServiceProviderRequestHandler serviceproviderRequestHandler = new ServiceProviderRequestHandler();

        ServiceProviderCreationResponse serviceProvidercreationResponse = new ServiceProviderCreationResponse();

        if (serviceproviderRequestHandler.create_service_provider(serviceProviderBO)!=false) {

            serviceProvidercreationResponse.setMessageType("FAILURE");
            serviceProvidercreationResponse.setMessage("ServiceproviderCreation Failed");

        } else {
            serviceProvidercreationResponse.setMessageType("SUCCESS");
            serviceProvidercreationResponse.setMessage("Serviceprovider Created sucessfuly");

        }

        return ResponseGenerator.generateResponse(serviceProvidercreationResponse);
    }

    @POST
    @Path("/update_service_provider")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response UpdateServiceProvider(UpdateServiceProviderRequest updateServiceProvider/*,@HeaderParam("sessionId") String sessionId*/) throws IOException, SQLException {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {


        UpdateServiceProviderBO updateserviceProviderRequestBO = new UpdateServiceProviderBO();

        updateserviceProviderRequestBO.setName(updateServiceProvider.getName());
        updateserviceProviderRequestBO.setAddress(updateServiceProvider.getAddress());
        updateserviceProviderRequestBO.setCity(updateServiceProvider.getCity());
        updateserviceProviderRequestBO.setState(updateServiceProvider.getState());
        updateserviceProviderRequestBO.setMobileNo(updateServiceProvider.getMobileNo());
        updateserviceProviderRequestBO.setPhoneNo(updateServiceProvider.getPhoneNo());
        updateserviceProviderRequestBO.setLat(updateServiceProvider.getLat());
        updateserviceProviderRequestBO.setLog(updateServiceProvider.getLog());
        updateserviceProviderRequestBO.setOpeningTime(updateServiceProvider.getOpeningTime());
        updateserviceProviderRequestBO.setClosingTime(updateServiceProvider.getClosingTime());
        updateserviceProviderRequestBO.setStatus(updateServiceProvider.getStatus());
        updateserviceProviderRequestBO.setId(updateServiceProvider.getId());

        ServiceProviderRequestHandler serviceProviderRequestHandler = new ServiceProviderRequestHandler();
        UpdateServiceProviderResponse updateServiceProviderResponse = new UpdateServiceProviderResponse();
        if (serviceProviderRequestHandler.updateServiceProvider(updateserviceProviderRequestBO)) {
            updateServiceProviderResponse.setMessageType("SUCCESS");
            updateServiceProviderResponse.setMessage("ServiceProvider updated successfully");
        } else {
            updateServiceProviderResponse.setMessageType("FAILURE");
            updateServiceProviderResponse.setMessage("Unable to update the ServiceProvider");
        }
        return ResponseGenerator.generateResponse(updateServiceProviderResponse);
    } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }
    }*/

    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobile() {
        ServiceProviderRequestHandler serviceProviderRequestHandler = new ServiceProviderRequestHandler();
        ServiceTypeResponseList serviceTypeResponse = new ServiceTypeResponseList();
        serviceTypeResponse.setServiceTypeResponses(serviceProviderRequestHandler.getServiceTypes());
        serviceTypeResponse.setMessageType("SUCCESS");
        serviceTypeResponse.setMessage("list of service types.");
        return ResponseGenerator.generateResponse(serviceTypeResponse);
    }

}
