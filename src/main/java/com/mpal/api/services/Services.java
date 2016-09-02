package com.mpal.api.services;

import com.mpal.requestHandlers.ServiceRequestHandler;
import com.mpal.rest.response.services.ServiceResponseList;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by System1 on 8/31/2016.
 */
@Path("/services")
public class Services {
    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServiceTypes() throws SQLException {
        ServiceRequestHandler serviceRequestHandler = new ServiceRequestHandler();
        ServiceResponseList serviceResponse = new ServiceResponseList();
        serviceResponse.setServices(serviceRequestHandler.getService());
        serviceResponse.setMessageType("SUCCESS");
        serviceResponse.setMessage("list of services.");
        return ResponseGenerator.generateResponse(serviceResponse);
    }
}
