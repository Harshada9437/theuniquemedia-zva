package com.mpal.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mpal.bo.request.user.*;
import com.mpal.rest.response.user.*;
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
                loginResponse.setMessageType("SUCCESS");
                loginResponse.setUserId(loginResponseBO.getId());
                loginResponse.setMessage(String.valueOf(loginResponseBO
                        .getSessionId()));
            }
            else {
                loginResponse.setMessageType("FAILURE");
                loginResponse.setMessage("Invalid User.");
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
        if(!userRequestHandler.verifyEmail(registrationRequest.getEmail())){
            if (userRequestHandler.register(registrationRequestBO)!=null) {
                int userId=userRequestHandler.register(registrationRequestBO);
                registrationResponse.setMessageType("SUCCESS");
                registrationResponse.setMessage("Created user id:-" + userId );
            } else {
                registrationResponse.setMessageType("FAILURE");
                registrationResponse.setMessage("Registration Failed");
            }
        } else {
            registrationResponse.setMessageType("FAILURE");
            registrationResponse.setMessage("Email exist");
        }

        return ResponseGenerator.generateResponse(registrationResponse);
    }

    @GET
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
    }


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
                updateResponse.setMessageType("SUCCESS");
                updateResponse.setMessage("User updated successfully");
            } else {
                updateResponse.setMessageType("FAILURE");
                updateResponse.setMessage("Unable to update the user");
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
                if(userRequestHandler.validUser(id)) {
                    GetUserResponse userResponse = userRequestHandler.getUserById(id);
                    userResponse.setMessageType("SUCCESS");
                    return ResponseGenerator.generateResponse(userResponse);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (UserNotFoundException e) {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMessageType("FAILURE");
                loginResponse.setMessage("Invalid User");
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
                loginResponse.setMessageType("SUCCESS");
                loginResponse.setMessage("Log out successfully.");
                return ResponseGenerator.generateResponse(loginResponse);
            } else {
                loginResponse.setMessageType("FAILURE");
                loginResponse.setMessage("Unable to Log out current user.");
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
            loginResponse.setMessageType("SUCCESS");
            loginResponse.setMessage("Password sent to your registered email address.");
            return ResponseGenerator.generateResponse(loginResponse);
        } else {
            loginResponse.setMessageType("FAILURE");
            loginResponse.setMessage("Invalid email address.");
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
            updateResponse.setMessageType("SUCCESS");
            updateResponse.setMessage("Password Updated.");
        } else {
            updateResponse.setMessageType("FAILURE");
            updateResponse.setMessage("Password Updatation failed.");
        }
        return ResponseGenerator.generateResponse(updateResponse);
    }

}
