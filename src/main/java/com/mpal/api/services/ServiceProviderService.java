package com.mpal.api.services;

import com.mpal.bo.request.serviceprovider.ServiceProviderBO;
import com.mpal.bo.request.serviceprovider.UpdateServiceProviderBO;
import com.mpal.requestHandlers.ServiceProviderRequestHandler;

import com.mpal.rest.request.serviceprovider.UpdateServiceProviderRequest;
import com.mpal.rest.request.serviceprovider.ServiceProviderRequest;
import com.mpal.rest.response.serviceprovider.ServiceProviderCreationResponse;
import com.mpal.rest.response.serviceprovider.ServiceProviderResponseList;
import com.mpal.rest.response.serviceprovider.ServiceTypeResponseList;
import com.mpal.rest.response.serviceprovider.UpdateServiceProviderResponse;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by System2 on 8/12/2016.
 */

@Path("/serviceProvider")

public class ServiceProviderService {

    @POST
    @Path("/create")
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

        if (serviceproviderRequestHandler.createServiceProvider(serviceProviderBO)!=false) {

            serviceProvidercreationResponse.setMessageType("FAILURE");
            serviceProvidercreationResponse.setMessage("ServiceproviderCreation Failed");

        } else {
            serviceProvidercreationResponse.setMessageType("SUCCESS");
            serviceProvidercreationResponse.setMessage("Serviceprovider Created sucessfuly");

        }

        return ResponseGenerator.generateResponse(serviceProvidercreationResponse);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response UpdateServiceProvider(UpdateServiceProviderRequest updateServiceProvider) throws SQLException {
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
    }

    @GET
    @Path("/types")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServiceTypes() {
        ServiceProviderRequestHandler serviceProviderRequestHandler = new ServiceProviderRequestHandler();
        ServiceTypeResponseList serviceTypeResponse = new ServiceTypeResponseList();
        serviceTypeResponse.setServiceTypeResponses(serviceProviderRequestHandler.getServiceTypes());
        serviceTypeResponse.setMessageType("SUCCESS");
        serviceTypeResponse.setMessage("list of service types.");
        return ResponseGenerator.generateResponse(serviceTypeResponse);
    }

    @GET
    @Path("/list/{service_provider_type_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServiceProviders(@PathParam("service_provider_type_id") int service_provider_type_id) {
        ServiceProviderRequestHandler serviceProviderRequestHandler = new ServiceProviderRequestHandler();
        ServiceProviderResponseList serviceTypeResponse = new ServiceProviderResponseList();
        serviceTypeResponse.setServiceProviderResponses(serviceProviderRequestHandler.getServiceProvider(service_provider_type_id));
        serviceTypeResponse.setMessageType("SUCCESS");
        serviceTypeResponse.setMessage("list of service providers.");
        return ResponseGenerator.generateResponse(serviceTypeResponse);
    }
}
