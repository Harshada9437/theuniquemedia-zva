package com.mpal.api.services;

import com.mpal.bo.request.customer.CreateCustomerRequestBO;
import com.mpal.bo.request.customer.UpdateCustomerRequestBO;
import com.mpal.exceptions.RequestException.RequestNotFoundException;
import com.mpal.requestHandlers.CustomerRequestHandler;
import com.mpal.rest.request.customer.CustomerRequest;
import com.mpal.rest.request.customer.UpdateCustomerRequest;
import com.mpal.rest.response.customer.*;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

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

    @POST
    @Path("/update/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRequest(UpdateCustomerRequest updateCustomerRequest, @PathParam("token") String token/*,@HeaderParam("sessionId") String sessionId*/) {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {


        UpdateCustomerRequestBO updatecustomerRequestBO = new UpdateCustomerRequestBO();

        updatecustomerRequestBO.setStatus( updateCustomerRequest.getStatus());

        updatecustomerRequestBO.setUpdatedBy(updateCustomerRequest.getUpdatedBy());

        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();

        UpdateCustomerResponse updatecustomerResponse = new UpdateCustomerResponse();

        if (customerRequestHandler.updateCustomerRequest(updatecustomerRequestBO,token)) {
            updatecustomerResponse.setMessagetype("SUCCESS");
            updatecustomerResponse.setMessage("Customer Request updated successfully");
        } else {
            updatecustomerResponse.setMessagetype("FAILURE");
            updatecustomerResponse.setMessage("Unable to update the Customer Request");
        }
        //System.out.println(updatecustomerRequestBO);
        return ResponseGenerator.generateResponse(updatecustomerResponse);
    } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }
    }*/

    @GET
    @Path("/list/byToken/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestListByToken(@PathParam("token") String token) {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListResponse response = new ReqeustListResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestListByToken(token));
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("Failure");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/list/byCustomer/{customer_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestListByCustomer(@PathParam("customer_id") int customer_id) {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListResponse response = new ReqeustListResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestListByCustomer(customer_id));
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("FAILURE");
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/list/byMechanic/{mechanic_id }")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestListByMechanic(@PathParam("mechanic_id") int mechanic_id ) {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListResponse response = new ReqeustListResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestListByMechanic(mechanic_id ));
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("FAILURE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/requestInfo/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("token") String token/*, @HeaderParam("sessionId") String sessionId*/) {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        Object response = null;
        GetRequestResponse requsetResponse=new GetRequestResponse();
        try {
                requsetResponse = customerRequestHandler.getRequestByToken(token);
                requsetResponse.setMessageType("SUCCESS");
                return ResponseGenerator.generateResponse(requsetResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RequestNotFoundException e) {
            requsetResponse.setMessageType("FAILURE");
        }
        return ResponseGenerator.generateResponse(response);
    } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    //}


    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestList( ) {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        RequestList response = new RequestList();
        try {
            response.setRequest(customerRequestHandler.getRequestList());
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("FAILURE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

}

