package com.mpal.api.services;

//import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mpal.bo.request.user.*;
import com.mpal.bo.response.LoginResponseBO;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;
import com.mpal.requestHandlers.UserRequestHandler;
import com.mpal.rest.request.user.*;
import com.mpal.rest.response.user.LoginResponse;
import com.mpal.rest.response.user.RegistrationResponse;
import com.mpal.rest.response.user.UpdateResponse;
import com.mpal.rest.response.user.UserLoggedInResponse;
import com.mpal.rest.response.user.UserResponseList;
import com.mpal.rest.response.user.UserTypesResponse;
import com.mpal.rest.util.ResponseGenerator;
//import com.mpal.validation.RequestValidation;

@Path("/user")
public class UsersService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(LoginRequest loginRequest) {
        LoginRequestBO loginRequestBO = new LoginRequestBO();
        loginRequestBO.setEmail(loginRequest.getEmail());
        loginRequestBO.setPassword(loginRequest.getPassword());
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        LoginResponse loginResponse = new LoginResponse();
        try {
            LoginResponseBO loginResponseBO = userRequestHandler
                    .login(loginRequestBO);
            if (loginResponseBO.getValidUser()) {
                loginResponse.setUserId(loginResponseBO.getId());
                loginResponse.setMessage(String.valueOf(loginResponseBO
                        .getSessionId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            loginResponse.setMessage(e.getMessage());
        }
        return ResponseGenerator.generateResponse(loginResponse);
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(RegistrationRequest registrationRequest) {
        RegistrationRequestBO registrationRequestBO = new RegistrationRequestBO();
        registrationRequestBO.setUserType(registrationRequest.getType());
        registrationRequestBO.setName(registrationRequest.getName());
        registrationRequestBO.setMobile(registrationRequest.getMobile());
        registrationRequestBO.setEmail(registrationRequest.getEmail());
        registrationRequestBO.setPassword(registrationRequest.getPassword());
        registrationRequestBO.setClientDetailsId(registrationRequest.getClientDetailsId());


        UserRequestHandler userRequestHandler = new UserRequestHandler();
        RegistrationResponse registrationResponse = new RegistrationResponse();
        if (userRequestHandler.register(registrationRequestBO)) {
            registrationResponse.setMessage("SUCCESS");
        } else {
            registrationResponse.setMessage("FAILURE");
        }
        return ResponseGenerator.generateResponse(registrationResponse);
    }

  /*  @GET
    @Path("/confirm")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmUser(@QueryParam("id") int id) {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        RegistrationResponse registrationResponse = new RegistrationResponse();
        if (userRequestHandler.verifyUser(id)) {
            registrationResponse.setMessage("SUCCESS");
        } else {
            registrationResponse.setMessage("FAILURE");
        }
        return ResponseGenerator.generateResponse(registrationResponse);
    }*/

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UpdateUserRequest updateUser/*,@HeaderParam("sessionId") String sessionId*/) {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {
            UpdaterUserBO updateRequestBO = new UpdaterUserBO();
            updateRequestBO.setId(updateUser.getId());
            updateRequestBO.setName(updateUser.getName());
            updateRequestBO.setMobile(updateUser.getMobile());
            updateRequestBO.setEmail(updateUser.getEmail());

            UserRequestHandler userRequestHandler = new UserRequestHandler();
            UpdateResponse updateResponse = new UpdateResponse();
            if (userRequestHandler.updateUser(updateRequestBO)) {
                updateResponse.setMessage("SUCCESS");
            } else {
                updateResponse.setMessage("FAILURE");
            }
            return ResponseGenerator.generateResponse(updateResponse);
        } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }
    }*/

    @GET
    @Path("/userTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserTypes() {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        UserTypesResponse userTypesResponse = new UserTypesResponse();
        userTypesResponse.setGetTypesResponseList(userRequestHandler
                .getUserTypes());
        return ResponseGenerator.generateResponse(userTypesResponse);
    }

    @GET
    @Path("/userInfo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id/*, @HeaderParam("sessionId") String sessionId*/) {
        //if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {
            UserRequestHandler userRequestHandler = new UserRequestHandler();
            Object response = null;
            try {
                response = userRequestHandler.getUserById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (UserNotFoundException e) {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMessage(e.getMessage());
                return ResponseGenerator.generateResponse(loginResponse);
            }
            return ResponseGenerator.generateResponse(response);
        } /*else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
   // }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(LogoutRequest logoutRequest) //@HeaderParam("sessionId") String sessionId)
                           {
       // if (sessionId != null && RequestValidation.isRequestValid(sessionId)) {
            UserRequestHandler userRequestHandler = new UserRequestHandler();
            Boolean isLoggedOut = userRequestHandler.logout(logoutRequest
                    .getUserId());
            LoginResponse loginResponse = new LoginResponse();
            if (isLoggedOut) {
                loginResponse.setMessage("SUCCESS");
                return ResponseGenerator.generateResponse(loginResponse);
            } else {
                loginResponse.setMessage("FAILURE");
                return ResponseGenerator.generateResponse(loginResponse);
            }
        /*} else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }

    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        List<UserResponseList> response = null;
        try {
            response = userRequestHandler.getUsersList();
        } catch (UserNotFoundException e) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage(e.getMessage());
            return ResponseGenerator.generateResponse(loginResponse);
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/loggedIn")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserLoggedIn() {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        List<UserLoggedInResponse> response = null;
        try {
            response = userRequestHandler.getUserLoggedIn();
        } catch (UserNotFoundException e) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage(e.getMessage());
            return ResponseGenerator.generateResponse(loginResponse);
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/forgot/{emailId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response forgotPassword(@PathParam("emailId") String emailId) {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        Boolean mailSent = userRequestHandler.forgotPassword(emailId);
        LoginResponse loginResponse = new LoginResponse();
        if (mailSent) {
            loginResponse.setMessage("SUCCESS");
            return ResponseGenerator.generateResponse(loginResponse);
        } else {
            loginResponse.setMessage("FAILURE");
            return ResponseGenerator.generateResponse(loginResponse);
        }
    }

    @POST
    @Path("/changePassword")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePassword(ChangePasswordRequest changePwdReq) {
        ChangePasswordBO changePwdBO = new ChangePasswordBO(
                changePwdReq.getUserId(), changePwdReq.getOldPassword(),
                changePwdReq.getNewPassword());

        UserRequestHandler userRequestHandler = new UserRequestHandler();
        UpdateResponse updateResponse = new UpdateResponse();
        if (userRequestHandler.changePassword(changePwdBO)) {
            updateResponse.setMessage("Password Updated");
        } else {
            updateResponse.setMessage("FAILURE");
        }
        return ResponseGenerator.generateResponse(updateResponse);
    }

}
