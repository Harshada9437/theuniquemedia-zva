package com.mpal.api.services;

import com.mpal.bo.request.customer.CreateCustomerRequestBO;
import com.mpal.requestHandlers.CustomerRequestHandler;
import com.mpal.rest.request.customer.CustomerRequest;
import com.mpal.rest.response.customer.CreateCustomerRequestResponse;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/request")
public class CustomerRequestService {
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRequest(CustomerRequest customerRequest) {
        CreateCustomerRequestBO createCustomerRequestBO = new CreateCustomerRequestBO();
        createCustomerRequestBO.setAutomobileDetailsId(customerRequest.getAutomobileDetailsId());
        createCustomerRequestBO.setCustomerId(customerRequest.getCustomerId());
        createCustomerRequestBO.setMechanicId(customerRequest.getMechanicId());
        createCustomerRequestBO.setServiceId(customerRequest.getServiceId());

        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        String token = customerRequestHandler.createCustomerRequest(createCustomerRequestBO);
        CreateCustomerRequestResponse createCustomerRequestResponse = new CreateCustomerRequestResponse();
        if (token != null) {
            createCustomerRequestResponse.setMessage(token);
            createCustomerRequestResponse.setMessageType("SUCCESS");
        } else {
            createCustomerRequestResponse.setMessage("CREATION FAILED");
            createCustomerRequestResponse.setMessageType("FAILURE");
        }
        return ResponseGenerator.generateResponse(createCustomerRequestResponse);
    }
}
