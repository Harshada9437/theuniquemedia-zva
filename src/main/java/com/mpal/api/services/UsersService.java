package com.mpal.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mpal.bo.request.user.*;
import com.mpal.dao.user.UsersDAO;
import com.mpal.dto.user.UsersDTO;
import com.mpal.exceptions.ServiceExceptions.ServiceNotFoundException;
import com.mpal.exceptions.userServiceExceptions.UserTypeNotFoundException;
import com.mpal.rest.request.user.AssignAutomobilesRequest;
import com.mpal.rest.response.FailureResponse;
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
    public Response login(LoginRequest loginRequest)throws SQLException,UserNotFoundException {
        LoginRequestBO loginRequestBO = new LoginRequestBO();
        loginRequestBO.setEmail(loginRequest.getEmail());

        loginRequestBO.setPassword(loginRequest.getPassword());
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        LoginResponse loginResponse = new LoginResponse();
        try {
            LoginResponseBO loginResponseBO = userRequestHandler
                    .login(loginRequestBO);
            UsersDAO usersDAO = new UsersDAO();
            UsersDTO usersDTO = usersDAO.getUserById(loginResponseBO.getId());

            if (loginResponseBO.getValidUser()) {
                if (usersDTO.getStatus().equals("A")) {
                    loginResponse.setMessageType("SUCCESS");
                    loginResponse.setUserId(loginResponseBO.getId());
                    loginResponse.setName(loginResponseBO.getName());
                    loginResponse.setAddress(loginResponseBO.getAddress());
                    loginResponse.setMobile(loginResponseBO.getMobile());
                    loginResponse.setEmail(loginResponseBO.getEmail());
                    loginResponse.setGender(loginResponseBO.getGender());
                    loginResponse.setDOB(loginResponseBO.getDOB());
                    loginResponse.setLatitude(loginResponseBO.getLatitude());
                    loginResponse.setLongitude(loginResponseBO.getLongitude());
                    loginResponse.setClientDetailsId(loginResponseBO.getClientDetailsId());
                    loginResponse.setStatus(loginResponseBO.getStatus());
                    loginResponse.setUserTypeId(loginResponseBO.getUserTypeId());
                    loginResponse.setIsVerified(loginResponseBO.getIsVerified());
                    loginResponse.setMessage(String.valueOf(loginResponseBO
                            .getSessionId()));
                } else {
                    loginResponse.setMessageType("FAILURE");
                    loginResponse.setMessage("Inactive User.");
                }
            } else {
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
    public Response registerUser(RegistrationRequest registrationRequest) throws SQLException {
        RegistrationRequestBO registrationRequestBO = new RegistrationRequestBO();
        registrationRequestBO.setUserTypeId(registrationRequest.getUserTypeId());
        registrationRequestBO.setName(registrationRequest.getName());
        registrationRequestBO.setAddress(registrationRequest.getAddress());
        registrationRequestBO.setMobile(registrationRequest.getMobile());
        registrationRequestBO.setEmail(registrationRequest.getEmail());
        registrationRequestBO.setGender(registrationRequest.getGender());
        registrationRequestBO.setDOB(registrationRequest.getDob());
        registrationRequestBO.setLatitude(registrationRequest.getLatitude());
        registrationRequestBO.setLongitude(registrationRequest.getLongitude());
        registrationRequestBO.setPassword(registrationRequest.getPassword());
        registrationRequestBO.setClientDetailsId(registrationRequest.getClientDetailsId());

        UserRequestHandler userRequestHandler = new UserRequestHandler();
        RegistrationResponse registrationResponse = new RegistrationResponse();

        userRequestHandler.verifyPhoneNumber(registrationRequest.getMobile());

        if (!userRequestHandler.verifyEmail(registrationRequest.getEmail())) {

            if (!userRequestHandler.verifyPhoneNumber(registrationRequest.getMobile())) {

                int userId = userRequestHandler.register(registrationRequestBO);
                if (userId != 0) {
                    registrationResponse.setMessageType("SUCCESS");
                    registrationResponse.setMessage("Created user successfully");
                    registrationResponse.setUserId(userId);
                } else {
                    registrationResponse.setMessageType("FAILURE");
                    registrationResponse.setMessage("Registration Failed");
                }

            } else {
                registrationResponse.setMessage("Mobile_number exist");
            }
        }
        else {
            registrationResponse.setMessageType("FAILURE");
            registrationResponse.setMessage("Email exist");
        }

        return ResponseGenerator.generateResponse(registrationResponse);
    }

    @GET
    @Path("/confirm")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmUser(@QueryParam("id") int id) throws SQLException {
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
    public Response updateUser(UpdateUserRequest updateUser) throws SQLException {
        UpdaterUserBO updateRequestBO = new UpdaterUserBO();
        updateRequestBO.setId(updateUser.getId());
        updateRequestBO.setName(updateUser.getName());
        updateRequestBO.setAddress(updateUser.getAddress());
        updateRequestBO.setMobile(updateUser.getMobile());
        updateRequestBO.setEmail(updateUser.getEmail());
        updateRequestBO.setGender(updateUser.getGender());
        updateRequestBO.setDOB(updateUser.getDOB());
        updateRequestBO.setLatitude(updateUser.getLatitude());
        updateRequestBO.setLongitude(updateUser.getLongitude());
        updateRequestBO.setStatus(updateUser.getStatus());

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
    }

    @GET
    @Path("/userTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserTypes() throws SQLException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        UserTypesResponse userTypesResponse = new UserTypesResponse();
        try {
            userTypesResponse.setGetTypesResponseList(userRequestHandler.getUserTypes());
            userTypesResponse.setMessageType("SUCCESS");
            userTypesResponse.setMessage("Available user types.");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(userTypesResponse);
    }

    @GET
    @Path("/userInfo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) throws SQLException,UserNotFoundException{
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        Object response = null;
        try {
            if (userRequestHandler.validUser(id)) {
                GetUserResponse userResponse = userRequestHandler.getUserById(id);
                userResponse.setMessageType("SUCCESS");
                return ResponseGenerator.generateResponse(userResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            FailureResponse failureResponse = new FailureResponse();
            failureResponse.setMessageType("FAILURE");
            failureResponse.setMessage("Invalid User");
            return ResponseGenerator.generateResponse(failureResponse);
        }
        return ResponseGenerator.generateResponse(response);
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(LogoutRequest logoutRequest) throws SQLException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        Boolean isLoggedOut = userRequestHandler.logout(logoutRequest
                .getUserId());
        LogoutResponse logoutResponse = new LogoutResponse();
        if (isLoggedOut) {
            logoutResponse.setMessageType("SUCCESS");
            logoutResponse.setMessage("Log out successfully.");
            return ResponseGenerator.generateResponse(logoutResponse);
        } else {
            logoutResponse.setMessageType("FAILURE");
            logoutResponse.setMessage("Unable to Log out current user.");
            return ResponseGenerator.generateResponse(logoutResponse);
        }

    }

    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() throws SQLException{
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        List<UserResponseList> response = null;
        try {
            response = userRequestHandler.getUsersList();
        } catch (UserNotFoundException e) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage(e.getMessage());
            return ResponseGenerator.generateResponse(loginResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/loggedIn")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserLoggedIn() throws SQLException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        List<UserLoggedInResponse> response = null;
        try {
            response = userRequestHandler.getUserLoggedIn();
        } catch (UserNotFoundException e) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage(e.getMessage());
            return ResponseGenerator.generateResponse(loginResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/forgot/{emailId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response forgotPassword(@PathParam("emailId") String emailId) throws SQLException {
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
            updateResponse.setMessage("Password Updation failed.");
        }
        return ResponseGenerator.generateResponse(updateResponse);
    }

    @GET
    @Path("/list/{user_type_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByTypeList(@PathParam("user_type_id") int userTypeId) throws SQLException,UserTypeNotFoundException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        UserResponse userResponseL = new UserResponse();
        try {
            userResponseL.setUserResponseList(userRequestHandler.getUserByTypeId(userTypeId));
            userResponseL.setMessageType("SUCCESS");
            userResponseL.setMessage("Users are available");
        } catch (UserTypeNotFoundException e) {
            userResponseL.setMessageType("FAILURE");
            userResponseL.setMessage("INVALID USER TYPE");
        } catch (UserNotFoundException e){
            userResponseL.setMessageType("SUCCESS");
            userResponseL.setMessage("Users are not available for this type");
        } catch(SQLException e) {
           e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(userResponseL);
    }

    @POST
    @Path("/{user_type_id}/assignAutomobiles")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignMechanicsForAutomobiles(AssignAutomobilesRequest assignAutomobilesRequest, @PathParam("user_type_id") int userTypeId) throws SQLException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        AssignAutomobilesRequestBO assignAutomobilesRequestBO = new AssignAutomobilesRequestBO();
        assignAutomobilesRequestBO.setAutomobileInfoList(assignAutomobilesRequest.getAutomobilesInfoList());
        Boolean isCreated = userRequestHandler.assignAutomobile(assignAutomobilesRequestBO);
        AssignAutomobilesResponse assignAutomobilesResponse = new AssignAutomobilesResponse();
        if (isCreated) {
            assignAutomobilesResponse.setMessageType("SUCCESS");
            assignAutomobilesResponse.setMessage("automobiles are assigned.");
        } else {
            assignAutomobilesResponse.setMessageType("FAILURE");
            assignAutomobilesResponse.setMessage("automobiles can't be assigned.");
        }
        return ResponseGenerator.generateResponse(assignAutomobilesResponse);
    }

    @POST
    @Path("/{user_type_id}/assignServices")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignMechanicsForServices(AssignServicesRequest assignServicesRequest, @PathParam("user_type_id") int userTypeId) throws SQLException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        AssignServicesRequestBO assignServicesRequestBO = new AssignServicesRequestBO();
        assignServicesRequestBO.setServiceInfoList(assignServicesRequest.getServiceInfoList());
        Boolean isCreated = userRequestHandler.assignServices(assignServicesRequestBO);
        AssignServicesResponse assignServicesResponse = new AssignServicesResponse();
        if (isCreated) {
            assignServicesResponse.setMessageType("SUCCESS");
            assignServicesResponse.setMessage("services are assigned.");
        } else {
            assignServicesResponse.setMessageType("FAILURE");
            assignServicesResponse.setMessage("services can't be assigned.");
        }

        return ResponseGenerator.generateResponse(assignServicesResponse);
    }

    @GET
    @Path("/{user_type_id}/{service_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMechanicByByService(@PathParam("user_type_id") int userTypeId, @PathParam("service_id") int serviceId,
                                           @QueryParam("automobile_details_id") int automobileDetailsId) throws SQLException,ServiceNotFoundException{
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        MechanicByServiceResponse mechanicByServiceResponse = new MechanicByServiceResponse();
        try {
            mechanicByServiceResponse.setMechanicsList(userRequestHandler.getMechanicsList(serviceId, automobileDetailsId));
            mechanicByServiceResponse.setMessageType("SUCCESS");
            mechanicByServiceResponse.setMessage("Available mechanics.");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ServiceNotFoundException e)
        {
            mechanicByServiceResponse.setMessageType("FAILURE");
            mechanicByServiceResponse.setMessage("Invalid service id.");
        }
        return ResponseGenerator.generateResponse(mechanicByServiceResponse);
    }


    @GET
    @Path("/{user_type_id}/listAssignedAutomobiles/{user_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserAutomobileMapList(@PathParam("user_type_id") int userTypeId,@PathParam("user_id") int userId) throws SQLException,UserNotFoundException {
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        List<UserAutomobileMapResponseList> response = null;
        try {
            response = userRequestHandler.getUserAutomobileMapList(userId);
        } catch (UserNotFoundException e) {
            FailureResponse failureResponse = new FailureResponse();
            failureResponse.setMessageType("FAILURE");
            failureResponse.setMessage("Invalid User");
            return ResponseGenerator.generateResponse(failureResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }

    @GET
    @Path("/{user_type_id}/listAssignedServices/{user_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserServiceMapList(@PathParam("user_type_id") int userTypeId,@PathParam("user_id") int userId) throws SQLException,UserNotFoundException{
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        List<UserServiceMapResponseList> response = null;
        try {
            response = userRequestHandler.getUserServiceMapList(userId);
        } catch (UserNotFoundException e) {
            FailureResponse failureResponse = new FailureResponse();
            failureResponse.setMessageType("FAILURE");
            failureResponse.setMessage("Invalid User");
            return ResponseGenerator.generateResponse(failureResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseGenerator.generateResponse(response);
    }
}
