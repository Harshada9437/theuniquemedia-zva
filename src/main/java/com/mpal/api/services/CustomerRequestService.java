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
    public Response createRequest(CustomerRequest customerRequest) throws SQLException {
        CreateCustomerRequestBO createCustomerRequestBO = new CreateCustomerRequestBO();
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        CreateCustomerRequestResponse createCustomerRequestResponse = new CreateCustomerRequestResponse();
        try {
            createCustomerRequestBO.setAutomobileDetailsId(customerRequest.getAutomobileDetailsId());
            createCustomerRequestBO.setCustomerId(customerRequest.getCustomerId());
            createCustomerRequestBO.setMechanicId(customerRequest.getMechanicId());
            createCustomerRequestBO.setServiceId(customerRequest.getServiceId());

            String token = customerRequestHandler.createCustomerRequest(createCustomerRequestBO);
            if (token != null) {
                createCustomerRequestResponse.setMessage(token);
                createCustomerRequestResponse.setMessageType("SUCCESS");
            } else {
                createCustomerRequestResponse.setMessage("CREATION FAILED");
                createCustomerRequestResponse.setMessageType("FAILURE");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(createCustomerRequestResponse);
    }

    @POST
    @Path("/update/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRequest(UpdateCustomerRequest updateCustomerRequest, @PathParam("token") String token)throws SQLException,RequestNotFoundException {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        UpdateCustomerResponse updatecustomerResponse = new UpdateCustomerResponse();
        try {
            UpdateCustomerRequestBO updatecustomerRequestBO = new UpdateCustomerRequestBO();

            updatecustomerRequestBO.setStatus(updateCustomerRequest.getStatus());

            updatecustomerRequestBO.setUpdatedBy(updateCustomerRequest.getUpdatedBy());

            if (customerRequestHandler.updateCustomerRequest(updatecustomerRequestBO, token)) {
                updatecustomerResponse.setMessagetype("SUCCESS");
                updatecustomerResponse.setMessage("Customer Request updated successfully");
            } else {
                updatecustomerResponse.setMessagetype("FAILURE");
                updatecustomerResponse.setMessage("Unable to update the Customer Request");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch (RequestNotFoundException e){
            updatecustomerResponse.setMessagetype("FAILURE");
            updatecustomerResponse.setMessage("Invalid token.");
        }
        return ResponseGenerator.generateResponse(updatecustomerResponse);
    }

    @GET
    @Path("/list/byToken/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestListByToken(@PathParam("token") String token)throws SQLException,RequestNotFoundException {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListResponse response = new ReqeustListResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestListByToken(token));
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("Failure");
            response.setMessage("Invalid token.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/list/byCustomer/{customer_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestListByCustomer(@PathParam("customer_id") int customerId)throws SQLException,RequestNotFoundException {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListCResponse response = new ReqeustListCResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestListByCustomer(customerId));
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("FAILURE");
            response.setMessage("Invalid customerId.");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/list/byMechanic/{mechanic_id }")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestListByMechanic(@PathParam("mechanic_id") int mechanicId )throws RequestNotFoundException,SQLException {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListMResponse response = new ReqeustListMResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestListByMechanic(mechanicId ));
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (RequestNotFoundException e) {
            response.setMessageType("FAILURE");
            response.setMessage("Invalid mechanicId.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/requestInfo/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("token") String token) throws SQLException,RequestNotFoundException{
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
            requsetResponse.setMessageType("Failure");
            requsetResponse.setMessage("Invalid token.");
        }
        return ResponseGenerator.generateResponse(response);
    }


    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestList( )throws SQLException {
        CustomerRequestHandler customerRequestHandler = new CustomerRequestHandler();
        ReqeustListResponse response = new ReqeustListResponse();
        try {
            response.setRequests(customerRequestHandler.getRequestList());
            response.setMessageType("SUCCESS");
            response.setMessage("Requests are available.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }
}

