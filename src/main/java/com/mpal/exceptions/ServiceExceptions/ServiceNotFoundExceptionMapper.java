package com.mpal.exceptions.ServiceExceptions;

import com.mpal.errormodels.ErrorMessage;
import com.mpal.exceptions.ServiceExceptions.ServiceNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by System1 on 8/16/2016.
 */
public class ServiceNotFoundExceptionMapper implements
        ExceptionMapper<ServiceNotFoundException> {
    @Override
    public Response toResponse(ServiceNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage("Service not found");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage)
                .build();
    }
}
