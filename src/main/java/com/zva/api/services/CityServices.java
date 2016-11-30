package com.zva.api.services;

import com.zva.requestHandlers.CityRequestHandler;
import com.zva.rest.response.FailureResponse;
import com.zva.rest.response.cities.CityResponseList;
import com.zva.rest.response.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by System1 on 8/31/2016.
 */
@Path("/city")
public class CityServices {
    @GET
    @Path("/list/{state_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityList(@PathParam("state_id") int stateId/*, @HeaderParam("Auth") String auth*/) throws Exception {
        /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        CityResponseList cityResponseList = new CityResponseList();
        try {
            CityRequestHandler cityRequestHandler = new CityRequestHandler();
            cityResponseList.setCities(cityRequestHandler.getCities(stateId));
            return ResponseGenerator.generateSuccessResponse(cityResponseList, "List  of cities");
        } catch (SQLException e) {
            FailureResponse failureResponse = new FailureResponse();
            return ResponseGenerator.generateFailureResponse(failureResponse, "Can't display List  of cities");
        }
         /* } else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }
}
