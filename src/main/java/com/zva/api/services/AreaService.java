package com.zva.api.services;


import com.zva.requestHandlers.AreaRequestHandler;
import com.zva.rest.response.FailureResponse;
import com.zva.rest.response.area.AreaResponseList;
import com.zva.rest.response.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by System2 on 8/12/2016.
 */

@Path("/area")

public class AreaService {
    @GET
    @Path("/list/{zone_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServiceProviders(@PathParam("zone_id") int zoneId/*, @HeaderParam("Auth") String auth*/) throws Exception {
       /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        AreaRequestHandler areaRequestHandler = new AreaRequestHandler();
        AreaResponseList areaResponseList = new AreaResponseList();
        try {
            areaResponseList.setAreas(areaRequestHandler.getAreas(zoneId));
            return ResponseGenerator.generateSuccessResponse(areaResponseList, "List of areas");
        } catch (SQLException e) {
            FailureResponse failureResponse = new FailureResponse();
            return ResponseGenerator.generateFailureResponse(failureResponse, "Can't display List  of areas");
        }
       /* } else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }
}
