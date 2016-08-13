package com.mpal.exceptions.AutomobileServiceExceptions;

import com.mpal.errormodels.ErrorMessage;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;

import javax.ws.rs.core.Response;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Created by System1 on 8/6/2016.
 */
@Provider
public class AutomobileNotFoundExceptionMapper implements
		ExceptionMapper<AutomobileNotFoundException> {
	@Override
	public Response toResponse(AutomobileNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage("Automobile not found");
		return Response.status(Response.Status.NOT_FOUND).entity(errorMessage)
				.build();
	}
}