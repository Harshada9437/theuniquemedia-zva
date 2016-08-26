package com.mpal.exceptions.RequestException;

import com.mpal.errormodels.ErrorMessage;
import com.mpal.exceptions.RequestException.RequestNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by System1 on 8/26/2016.
 */
public class RequestNotFoundExceptionMapper implements
        ExceptionMapper<RequestNotFoundException> {
    @Override
    public Response toResponse(RequestNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage("Requsts not found");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage)
                .build();
    }
}
