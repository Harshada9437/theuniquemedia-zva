package com.zva.api.services;

import com.zva.requestHandlers.ZoneRequestHandler;
import com.zva.rest.response.FailureResponse;
import com.zva.rest.response.util.ResponseGenerator;
import com.zva.rest.response.zone.ZoneResponseList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by System-2 on 11/28/2016.
 */
@Path("/zone")
public class ZoneService {
    @GET
    @Path("/list/{city_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getZoneList(@PathParam("city_id") int cityId/*, @HeaderParam("Auth") String auth*/) throws Exception {
          /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        ZoneRequestHandler zoneRequestHandler = new ZoneRequestHandler();
        ZoneResponseList zoneResponseList = new ZoneResponseList();
        try {
            zoneResponseList.setZones(zoneRequestHandler.getZones(cityId));
            return ResponseGenerator.generateSuccessResponse(zoneResponseList,"List  of zones");
        }catch (SQLException e){
            FailureResponse failureResponse = new FailureResponse();
            return ResponseGenerator.generateFailureResponse(failureResponse, "Can't display List  of zones");
        }
         /* } else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }
}
