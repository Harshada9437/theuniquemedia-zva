package com.mpal.api.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mpal.rest.request.email.SendEmailRequest;
import com.mpal.rest.response.email.SendEmailResponse;
import com.mpal.rest.response.requestAuth.RequestAuthenticationResponse;
import com.mpal.rest.util.EmailService;
import com.mpal.rest.util.ResponseGenerator;
import com.mpal.validation.RequestValidation;

@Path("/email")
public class SendEmailService {

    @POST
    @Path("/bulkEmail")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmailList(SendEmailRequest emailRequest, @HeaderParam("sessionId") String sessionId) {
        if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {
            SendEmailResponse emailResponse = new SendEmailResponse();
            if (EmailService.sendEmails(emailRequest)) {

                emailResponse.setMessageType("Success");
                emailResponse.setMessage("Email Sending Successful");

            } else {
                emailResponse.setMessageType("Failure");
                emailResponse.setMessage("Email Sending Unsuccessful");
            }
            return ResponseGenerator
                    .generateResponse(emailResponse);
        } else {
            RequestAuthenticationResponse requestAuthenticationResponse = new RequestAuthenticationResponse();
            requestAuthenticationResponse.setFailureMessage("Unauthorized access");
            return ResponseGenerator.generateResponse(requestAuthenticationResponse);
        }
    }
}
