package com.mpal.api.services;

import com.mpal.bo.request.automobileInfo.AutomobileInfoBO;
import com.mpal.bo.request.automobileInfo.UpdateAutomobileInfoBO;
import com.mpal.requestHandlers.AutomobileInfoRequestHandler;

import com.mpal.rest.request.automobileInfo.UpdateAutomobileInfoRequest;
import com.mpal.rest.request.automobileInfo.AutomobileInfoRequest;
import com.mpal.rest.response.automobileInfo.UpdateAutomobileInfoResponse;
import com.mpal.rest.response.automobileInfo.AutomobileInfoCreationResponse;
import com.mpal.rest.util.ResponseGenerator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by System2 on 8/12/2016.
 */

@Path("/automobile_info")

public class AutoMobileInfoService {

    @POST
    @Path("/create_automobile_info")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateAutomobileInfo(AutomobileInfoRequest automobileRequest) {


        AutomobileInfoBO automobileinfoBO = new AutomobileInfoBO();


        automobileinfoBO.setId(automobileRequest.getId());
        automobileinfoBO.setName(automobileRequest.getName());
        automobileinfoBO.setAutomobileInfoId(automobileRequest.getAutomobileInfoId());
        automobileinfoBO.setAddress(automobileRequest.getAddress());
        automobileinfoBO.setCity(automobileRequest.getCity());
        automobileinfoBO.setState(automobileRequest.getState());
        automobileinfoBO.setLat(automobileRequest.getLat());
        automobileinfoBO.setLog(automobileRequest.getLog());
        automobileinfoBO.setStatus(automobileRequest.getStatus());
        automobileinfoBO.setPhoneNo(automobileRequest.getPhoneNo());
        automobileinfoBO.setMobileNo(automobileRequest.getMobileNo());
        automobileinfoBO.setOpeningTime(automobileRequest.getOpeningTime());
        automobileinfoBO.setClosingTime(automobileRequest.getClosingTime());


        AutomobileInfoRequestHandler automobileinfoRequestHandler = new AutomobileInfoRequestHandler();

        AutomobileInfoCreationResponse automobileinfocreationResponse = new  AutomobileInfoCreationResponse();

        if (automobileinfoRequestHandler.create_automobile_info(automobileinfoBO)!=false) {

            automobileinfocreationResponse.setMessageType("FAILURE");
            automobileinfocreationResponse.setMessage("AutomobileInfoCreation Failed");

        } else {
            automobileinfocreationResponse.setMessageType("SUCCESS");
            automobileinfocreationResponse.setMessage("AutomobileInfo Created sucessfuly");

        }

        return ResponseGenerator.generateResponse(automobileinfocreationResponse);
    }

    @POST
    @Path("/update_automobile_info")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response UpdateAutomobileInfo(UpdateAutomobileInfoRequest updateAutomobileInfo/*,@HeaderParam("sessionId") String sessionId*/) throws IOException, SQLException {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {


        UpdateAutomobileInfoBO updateautomobileInfoRequestBO = new UpdateAutomobileInfoBO();

        updateautomobileInfoRequestBO.setName(updateAutomobileInfo.getName());
        updateautomobileInfoRequestBO.setAddress(updateAutomobileInfo.getAddress());
        updateautomobileInfoRequestBO.setCity(updateAutomobileInfo.getCity());
        updateautomobileInfoRequestBO.setState(updateAutomobileInfo.getState());
        updateautomobileInfoRequestBO.setMobileNo(updateAutomobileInfo.getMobileNo());
        updateautomobileInfoRequestBO.setPhoneNo(updateAutomobileInfo.getPhoneNo());
        updateautomobileInfoRequestBO.setLat(updateAutomobileInfo.getLat());
        updateautomobileInfoRequestBO.setLog(updateAutomobileInfo.getLog());
        updateautomobileInfoRequestBO.setOpeningTime(updateAutomobileInfo.getOpeningTime());
        updateautomobileInfoRequestBO.setClosingTime(updateAutomobileInfo.getClosingTime());
        updateautomobileInfoRequestBO.setStatus(updateAutomobileInfo.getStatus());
        updateautomobileInfoRequestBO.setId(updateAutomobileInfo.getId());

        AutomobileInfoRequestHandler automobileInfoRequestHandler= new AutomobileInfoRequestHandler();
        UpdateAutomobileInfoResponse updateautomobileInfoResponse = new UpdateAutomobileInfoResponse();
        if (automobileInfoRequestHandler.updateAutomobileInfo(updateautomobileInfoRequestBO)) {
            updateautomobileInfoResponse.setMessageType("SUCCESS");
            updateautomobileInfoResponse.setMessage("Automobile updated successfully");
        } else {
            updateautomobileInfoResponse.setMessageType("FAILURE");
            updateautomobileInfoResponse.setMessage("Unable to update the Automobile");
        }
        return ResponseGenerator.generateResponse(updateautomobileInfoResponse);
    } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }
    }*/

}
