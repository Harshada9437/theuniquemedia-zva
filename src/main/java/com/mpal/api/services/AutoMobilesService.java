package com.mpal.api.services;

/**
 * Created by System1 on 8/6/2016.
 */

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mpal.dao.automobile.AutomobileTypesDAO;
import com.mpal.bo.request.automobile.AutomobilesBO;
import com.mpal.bo.request.automobile.UpdateAutomobileBO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.requestHandlers.AutomobileRequestHandler;
import com.mpal.rest.response.automobile.AutomobileTypeResponseList;
import com.mpal.rest.request.automobile.AutomobileRequest;
import com.mpal.rest.response.automobile.AutomobileCreationResponse;
import com.mpal.rest.request.automobile.UpdateAutomobileRequest;
import com.mpal.rest.response.automobile.UpdateAutomobileResponse;
import com.mpal.rest.util.ResponseGenerator;

@Path("/automobile")
public class AutoMobilesService {

    @GET
    @Path("/list/{type}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobileList(@PathParam("type") String type) throws SQLException, IOException {
        AutomobileRequestHandler automobileRequestHandler = new AutomobileRequestHandler();
        AutomobileTypesDAO automobileTypesDAO= new AutomobileTypesDAO();
        AutomobileTypeResponseList automobileResponseL= new AutomobileTypeResponseList();
        int automobileTypeId=automobileTypesDAO.getAutomobileIdByType(type);
        try {
            automobileResponseL.setAutomobileResponseLists(automobileRequestHandler.getAutomobileByTypeId(automobileTypeId));
            if(automobileResponseL == null) {
                automobileResponseL.setMessageType("SUCCESS");
                automobileResponseL.setMessage("Automobiles are not available");
            }
            else {
                automobileResponseL.setMessageType("SUCCESS");
                automobileResponseL.setMessage("Automobiles are available");
            }
        }catch (AutomobileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(automobileResponseL);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateAutomobile(AutomobileRequest automobileRequest) {


        AutomobilesBO automobilesBO = new AutomobilesBO();

        automobilesBO.setModel(automobileRequest.getModel());
        automobilesBO.setCompany(automobileRequest.getCompany());
        automobilesBO.setAutomobileTypeId(automobileRequest.getAutomobileTypeId());
        automobilesBO.setBuiltYear(automobileRequest.getBuiltYear());

        AutomobileRequestHandler automobileRequestHandler = new AutomobileRequestHandler();
        AutomobileCreationResponse automobilecreationResponse = new  AutomobileCreationResponse();

        if (automobileRequestHandler.create(automobilesBO)!=false) {
            automobilecreationResponse.setMessageType("FAILURE");
            automobilecreationResponse.setMessage("AutomobileCreation Failed");

        } else {
            automobilecreationResponse.setMessageType("SUCCESS");
            automobilecreationResponse.setMessage("Created sucessfuly");

        }

        return ResponseGenerator.generateResponse(automobilecreationResponse);
    }

    @POST
    @Path("/update_automobile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateAutomobile(UpdateAutomobileRequest updateAutomobile/*,@HeaderParam("sessionId") String sessionId*/) {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {


        UpdateAutomobileBO updateautomobileRequestBO = new UpdateAutomobileBO();

        updateautomobileRequestBO.setId(updateAutomobile.getId());
        updateautomobileRequestBO.setModel( updateAutomobile.getModel());
        updateautomobileRequestBO.setCompany( updateAutomobile.getCompany());
        updateautomobileRequestBO.setBuiltYear( updateAutomobile.getBuiltYear());
        updateautomobileRequestBO.setAutomobileTypeId( updateAutomobile.getAutomobileTypeId());

        AutomobileRequestHandler automobileRequestHandler= new AutomobileRequestHandler();
        UpdateAutomobileResponse updateautomobileResponse = new UpdateAutomobileResponse();
        if (automobileRequestHandler.updateAutomobile(updateautomobileRequestBO)) {
            updateautomobileResponse.setMessageType("SUCCESS");
            updateautomobileResponse.setMessage("Automobile updated successfully");
        } else {
            updateautomobileResponse.setMessageType("FAILURE");
            updateautomobileResponse.setMessage("Unable to update the Automobile");
        }
        return ResponseGenerator.generateResponse(updateautomobileResponse);
    } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }
    }*/




}
