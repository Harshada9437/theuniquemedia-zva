package com.zva.api.services;

import com.zva.requestHandlers.EventRequesthandler;
import com.zva.rest.response.FailureResponse;
import com.zva.rest.response.event.EventResponseList;
import com.zva.rest.response.event.EventSubTypeList;
import com.zva.rest.response.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/event")
public class EventService {

    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobileList(/*, @HeaderParam("Auth") String auth*/) {
        /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        EventRequesthandler eventRequesthandler = new EventRequesthandler();
        EventResponseList eventResponseList = new EventResponseList();
        try {
            eventResponseList.setEvents(eventRequesthandler.getEventList());
            return ResponseGenerator.generateSuccessResponse(eventResponseList, "List  of events");
        } catch (SQLException e) {
            FailureResponse failureResponse = new FailureResponse();
            return ResponseGenerator.generateFailureResponse(failureResponse, "Can't display List  of events");
        }
         /* } else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }


    @GET
    @Path("/list/subTypes/{event_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobile(@PathParam("event_id") int eventId/*, @HeaderParam("Auth") String auth*/) throws Exception {
          /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        EventRequesthandler eventRequesthandler = new EventRequesthandler();
        EventSubTypeList eventSubTypeList = new EventSubTypeList();
        try {
            eventSubTypeList.setEventSubTypes(eventRequesthandler.getEventSubTypes(eventId));
            return ResponseGenerator.generateSuccessResponse(eventSubTypeList, "List  of event's sub types");
        } catch (SQLException e) {
            FailureResponse failureResponse = new FailureResponse();
            return ResponseGenerator.generateFailureResponse(failureResponse, "Can't display List  of event's sub types");
        }
          /* } else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }
}
