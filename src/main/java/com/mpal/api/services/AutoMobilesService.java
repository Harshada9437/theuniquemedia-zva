package com.mpal.api.services;

/**
 * Created by System1 on 8/6/2016.
 */

import com.mpal.bo.request.automobile.AutomobilesBO;
import com.mpal.bo.request.automobile.UpdateAutomobileBO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.requestHandlers.AutomobileRequestHandler;
import com.mpal.rest.request.automobile.AutomobileRequest;
import com.mpal.rest.request.automobile.UpdateAutomobileRequest;
import com.mpal.rest.response.automobile.AutomobileCreationResponse;
import com.mpal.rest.response.automobile.AutomobileResponseList;
import com.mpal.rest.response.automobile.AutomobileTypeResponseList;
import com.mpal.rest.response.automobile.UpdateAutomobileResponse;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/automobile")
public class AutoMobilesService {

    @GET
    @Path("/list/{automobile_type_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobileList(@PathParam("automobile_type_id") int automobileTypeId) throws SQLException, AutomobileNotFoundException{
        AutomobileRequestHandler automobileRequestHandler = new AutomobileRequestHandler();
        AutomobileResponseList automobileResponseL= new AutomobileResponseList();
        try {
            automobileResponseL.setAutomobileResponses(automobileRequestHandler.getAutomobileByTypeId(automobileTypeId));
                automobileResponseL.setMessageType("SUCCESS");
                automobileResponseL.setMessage("Automobiles are available");
        }catch (AutomobileNotFoundException e) {
            automobileResponseL.setMessageType("FAILURE");
            automobileResponseL.setMessage("Invalid Automobile Type id.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(automobileResponseL);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateAutomobile(AutomobileRequest automobileRequest) throws SQLException {
        AutomobileRequestHandler automobileRequestHandler = new AutomobileRequestHandler();
        AutomobileCreationResponse automobilecreationResponse = new  AutomobileCreationResponse();
        AutomobilesBO automobilesBO = new AutomobilesBO();
        try {
            automobilesBO.setModel(automobileRequest.getModel());
            automobilesBO.setCompany(automobileRequest.getCompany());
            automobilesBO.setAutomobileTypeId(automobileRequest.getAutomobileTypeId());

            String msg = automobileRequestHandler.create(automobilesBO);
            if (msg.equals("created")) {
                automobilecreationResponse.setMessageType("SUCCESS");
                automobilecreationResponse.setMessage("Created sucessfuly");
            } else {
                automobilecreationResponse.setMessageType(msg);
                automobilecreationResponse.setMessage("AutomobileCreation Failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(automobilecreationResponse);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateAutomobile(UpdateAutomobileRequest updateAutomobile) throws SQLException {

        AutomobileRequestHandler automobileRequestHandler= new AutomobileRequestHandler();
        UpdateAutomobileResponse updateautomobileResponse = new UpdateAutomobileResponse();
        UpdateAutomobileBO updateautomobileRequestBO = new UpdateAutomobileBO();
        try {
            updateautomobileRequestBO.setId(updateAutomobile.getId());
            updateautomobileRequestBO.setModel(updateAutomobile.getModel());
            updateautomobileRequestBO.setCompany(updateAutomobile.getCompany());
            updateautomobileRequestBO.setAutomobileTypeId(updateAutomobile.getAutomobileTypeId());

            if (automobileRequestHandler.updateAutomobile(updateautomobileRequestBO)) {
                updateautomobileResponse.setMessageType("SUCCESS");
                updateautomobileResponse.setMessage("Automobile updated successfully");
            } else {
                updateautomobileResponse.setMessageType("FAILURE");
                updateautomobileResponse.setMessage("Unable to update the Automobile");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(updateautomobileResponse);
    }

    @GET
    @Path("/types")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobile() throws SQLException {
        AutomobileRequestHandler automobileRequestHandler = new AutomobileRequestHandler();
        AutomobileTypeResponseList automobileTypeResponse = new AutomobileTypeResponseList();
        try {
            automobileTypeResponse.setAutomobileTypeResponsesResponses(automobileRequestHandler.getAutomobileTypes());
            automobileTypeResponse.setMessageType("SUCCESS");
            automobileTypeResponse.setMessage("list of automobile types.");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(automobileTypeResponse);
    }
}
