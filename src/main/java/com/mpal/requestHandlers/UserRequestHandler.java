package com.mpal.requestHandlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mpal.bo.request.user.*;
import com.mpal.bo.response.LoginResponseBO;
import com.mpal.dao.user.UserAutomobileMapDAO;
import com.mpal.dao.user.UserServiceMapDAO;
import com.mpal.dao.user.UserTypesDAO;
import com.mpal.dao.user.UsersDAO;
import com.mpal.dto.user.*;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;
import com.mpal.rest.request.user.AutomobilesInfo;
import com.mpal.rest.request.user.ServiceInfo;
import com.mpal.rest.response.user.*;
import com.mpal.rest.util.EmailService;
import com.mpal.validation.UsersValidation;

public class UserRequestHandler {

	public Integer register(RegistrationRequestBO registrationRequestBO) {

		Boolean isProcessed = Boolean.TRUE;
		Integer userId=null;
		UsersDAO usersDAO = new UsersDAO();
		try {
			userId = usersDAO
					.insertUser(buildUsersDTOFromBO(registrationRequestBO));
		} catch (SQLException sq) {
			isProcessed = false;
		} catch (IOException sqlException) {
			isProcessed = false;
		}

		if (isProcessed && userId!=null) {
			EmailService.sendNewUserEmail(registrationRequestBO.getEmail(), userId);
		}

		return userId;
	}

	public Boolean verifyPhoneNumber(String mobile) {

		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		//String msg="unique";
		try {
			isProcessed = usersDAO.getValidationForPhoneNumber(mobile);
		} catch (SQLException sq) {
			isProcessed = false;
			//msg="mobile Number is already used";
		}
		return isProcessed;
	}

    public Boolean verifyEmail(String email) {

        Boolean isProcessed = Boolean.FALSE;
        UsersDAO usersDAO = new UsersDAO();
        try {
            isProcessed = usersDAO.getValidationForEmail(email);
        } catch (SQLException sq) {
            isProcessed = false;
        }
        return isProcessed;
    }

	public Boolean validUser(int userId) {

		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		try {
			UsersDTO userDTO = usersDAO.getUserById(userId);
			if(userDTO.getId() > 0 )
				isProcessed = Boolean.TRUE;
		} catch (SQLException sq) {
			isProcessed = false;
		}
		return isProcessed;
	}

	public Boolean verifyUser(Integer userId) {

		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		try {
			isProcessed = usersDAO.updateVerifiedUser(userId);
		} catch (SQLException sq) {
			isProcessed = false;
		} catch (IOException sqlException) {
			isProcessed = false;
		}
		return isProcessed;
	}

	public Boolean updateUser(UpdaterUserBO updateRequestBO) {

		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		try {
			isProcessed = usersDAO.updateUser(updateRequestBO);
		} catch (SQLException sq) {
			isProcessed = false;
		} catch (IOException sqlException) {
			isProcessed = false;
		}
		return isProcessed;
	}

	public LoginResponseBO login(LoginRequestBO loginRequestBO)
			throws SQLException {
		UsersValidation usersValidation = new UsersValidation();
		UsersDAO usersDAO = new UsersDAO();
		LoginResponseDTO loginResponseDTO = usersDAO
				.getNamePasswordForLoginValidationForEmailAndStatus(loginRequestBO
						.getEmail());
		LoginResponseBO loginResponseBO = new LoginResponseBO();
		Boolean isValidUser = usersValidation.validateEmailPassword(
				loginRequestBO, loginResponseDTO);
		if (isValidUser) {
			Long sessionId = new Date().getTime();
			usersDAO.updateSessionId(loginResponseDTO.getId(), sessionId);
			loginResponseBO.setSessionId(sessionId+"@"+loginResponseDTO.getId());
			loginResponseBO.setValidUser(isValidUser);
			loginResponseBO.setId(loginResponseDTO.getId());
			loginResponseBO.setName(loginResponseDTO.getName());
			loginResponseBO.setAddress(loginResponseDTO.getAddress());
			loginResponseBO.setMobile(loginResponseDTO.getMobile());
			loginResponseBO.setDOB(loginResponseDTO.getDOB());
			loginResponseBO.setGender(loginResponseDTO.getGender());
			loginResponseBO.setEmail(loginResponseDTO.getEmail());
			loginResponseBO.setMobile(loginResponseDTO.getMobile());
			loginResponseBO.setClientDetailsId(loginResponseDTO.getClientDetailsId());
			loginResponseBO.setLongitude(loginResponseDTO.getLongitude());
			loginResponseBO.setLatitude(loginResponseDTO.getLatitude());
			loginResponseBO.setIsVerified(loginResponseDTO.getIsVerified());
			loginResponseBO.setStatus(loginResponseDTO.getStatus());
			loginResponseBO.setUserTypeId(loginResponseDTO.getUserTypeId());
		}
		loginResponseBO.setValidUser(isValidUser);
		loginResponseBO.setId(loginResponseDTO.getId());
		return loginResponseBO;
	}

	private UsersDTO buildUsersDTOFromBO(RegistrationRequestBO requestBO) {
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUserTypeId(requestBO.getUserTypeId());
		usersDTO.setName(requestBO.getName());
		usersDTO.setAddress(requestBO.getAddress());
		usersDTO.setMobile(requestBO.getMobile());
		usersDTO.setEmail(requestBO.getEmail());
		usersDTO.setGender(requestBO.getGender());
		usersDTO.setDOB(requestBO.getDOB());
		usersDTO.setLatitude(requestBO.getLatitude());
		usersDTO.setLongitude(requestBO.getLongitude());
		usersDTO.setPassword(requestBO.getPassword());
		usersDTO.setClientDetailsId(requestBO.getClientDetailsId());
		return usersDTO;
	}

	private GetUserResponse buildUsersResponseFromDTO(UsersDTO usersDTO) {
		GetUserResponse userResponse = new GetUserResponse();
		userResponse.setId(usersDTO.getId());
		userResponse.setUserTypeId(usersDTO.getUserTypeId());
		userResponse.setName(usersDTO.getName());
		userResponse.setAddress(usersDTO.getAddress());
		userResponse.setMobile(usersDTO.getMobile());
		userResponse.setEmail(usersDTO.getEmail());
		userResponse.setGender(usersDTO.getGender());
		userResponse.setDOB(usersDTO.getDOB());
		userResponse.setLatitude(usersDTO.getLatitude());
		userResponse.setLongitude(usersDTO.getLongitude());
		userResponse.setClientDetailsId(usersDTO.getClientDetailsId());
		userResponse.setStatus(usersDTO.getStatus());
		return userResponse;
	}

	public List<GetTypesResponse> getUserTypes() {
		UserTypesDAO usersTypesDAO = new UserTypesDAO();
		List<GetTypesResponse> getTypesResponses = new ArrayList<GetTypesResponse>();
		try {
			List<UserTypesDTO> userTypesDTOList = usersTypesDAO
					.getAllUserTypes();

			for (com.mpal.dto.user.UserTypesDTO userTypesDTO : userTypesDTOList) {
				GetTypesResponse getTypesResponse = new GetTypesResponse();
				getTypesResponse.setId(userTypesDTO.getId());
				getTypesResponse.setType(userTypesDTO.getType());
				getTypesResponse.setStatus(userTypesDTO.getStatus());
				getTypesResponses.add(getTypesResponse);
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		}

		return getTypesResponses;

	}

	 public GetUserResponse getUserById(int id) throws SQLException,
			UserNotFoundException {
		UsersDAO usersDAO = new UsersDAO();
		GetUserResponse userResponse = buildUsersResponseFromDTO(usersDAO
				.getUserById(id));
		return userResponse;
	}

	public Boolean logout(int userId) {
		Boolean isLoggedOut = Boolean.FALSE;
		try {
			UsersDAO usersDAO = new UsersDAO();
			isLoggedOut = usersDAO.updateSessionId(userId, null);

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return isLoggedOut;
	}

	public List<UserResponseList> getUsersList() {
		List<UserResponseList> userList = null;
		try {
			UsersDAO usersDAO = new UsersDAO();
			userList = getUserResponseListFromDTOs(usersDAO.getUsersList());
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException s) {
			s.printStackTrace();
		}
		return userList;
	}

	private List<UserResponseList> getUserResponseListFromDTOs(List<UsersDTO> usersDTOs) throws SQLException{
		List<UserResponseList> userResponseListResponse = new ArrayList<UserResponseList>();
		Iterator<UsersDTO> usersDTOIterator = usersDTOs.iterator();
		while(usersDTOIterator.hasNext()){
			UsersDTO usersDTO = usersDTOIterator.next();
			UserResponseList userResponseList = new UserResponseList(usersDTO.getId(),
					usersDTO.getName(),
					usersDTO.getAddress(),
					usersDTO.getMobile(),
					usersDTO.getEmail(),
					usersDTO.getGender(),
					usersDTO.getDOB(),
					usersDTO.getLatitude(),
					usersDTO.getLongitude(),
					usersDTO.getUserTypeId(),
					usersDTO.getClientDetailsId(),
					usersDTO.getIsVerified(),
					usersDTO.getStatus());
			userResponseListResponse.add(userResponseList);
		}
		return userResponseListResponse;
	}

	private List<MechanicResponse> getMechanicResponseListFromDTOs(List<MechanicDTO> usersDTOs) throws SQLException{
		List<MechanicResponse> mechanicResponseListResponse = new ArrayList<MechanicResponse>();
		Iterator<MechanicDTO> usersDTOIterator = usersDTOs.iterator();
		while(usersDTOIterator.hasNext()){
			MechanicDTO usersDTO = usersDTOIterator.next();
			MechanicResponse mechanicResponseList = new MechanicResponse(usersDTO.getId(),
					usersDTO.getName(),
					usersDTO.getAddress(),
					usersDTO.getMobile(),
					usersDTO.getEmail(),
					usersDTO.getGender(),
					usersDTO.getLatitude(),
					usersDTO.getLongitude(),
					usersDTO.getStatus(),
					usersDTO.getRequestedAutomobile(),
					usersDTO.getIsHired());
			mechanicResponseListResponse.add(mechanicResponseList);
		}
		return mechanicResponseListResponse;
	}

	public Boolean forgotPassword(String emailId) {
		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		try {
			LoginResponseDTO dto = usersDAO
					.getNamePasswordForLoginValidationForEmailAndStatus(emailId);
			if (dto != null && dto.getId() != 0 && dto.getPassword() != null) {
				isProcessed = EmailService.sendForgotPasswordEmail(emailId,
						dto.getPassword());
			}
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isProcessed;
	}

	public List<UserLoggedInResponse> getUserLoggedIn() {
		UsersDAO usersDAO = new UsersDAO();
		List<UserLoggedInResponse> userList = null;
		try {
			userList = usersDAO.getUserLoggedIn();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public boolean changePassword(ChangePasswordBO updateRequestBO) {
		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		try {
			isProcessed = usersDAO.changePassword(updateRequestBO);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return isProcessed;
	}

    public List<UserResponseList> getUserByType(int user_type_id) throws SQLException,
				UserNotFoundException {
			UsersDAO usersDAO = new UsersDAO();
			List<UserResponseList> userList = new ArrayList<UserResponseList>();
			try {
				userList = getUserResponseListFromDTOs(usersDAO.getUserByTypeId(user_type_id));
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (AutomobileNotFoundException s) {
				s.printStackTrace();
			}
			return userList;
		}

    public Boolean assignAutomobile(AssignAutomobilesRequestBO assignAutomobilesRequestBO) throws SQLException,IOException {

		Boolean isCreated = Boolean.FALSE;
		List<AutomobilesInfo> automobileInfoList = assignAutomobilesRequestBO.getAutomobileInfoList();
		Iterator<AutomobilesInfo> automobilesInfoIterator = automobileInfoList.iterator();
		UserAutomobileMapDAO userAutomobileMapDAO = new UserAutomobileMapDAO();
		try {
			while (automobilesInfoIterator.hasNext()) {
				AutomobilesInfo automobilesInfo = automobilesInfoIterator.next();
				Integer userId = automobilesInfo.getUserId();
				List<Integer> oldAssignedAutomobiles = userAutomobileMapDAO.getListOfAutomobiles(userId,null);
				List<Integer> newAssignedAutomobiles = automobilesInfo.getAutomobileDetailsIds();
				Iterator<Integer> newAssignedAutomobilesIterator = newAssignedAutomobiles.iterator();
				Iterator<Integer> oldAssignedAutomobilesIterator = oldAssignedAutomobiles.iterator();
				while (newAssignedAutomobilesIterator.hasNext()){
					Integer automobileDetailsId = newAssignedAutomobilesIterator.next();
					if(oldAssignedAutomobiles.contains(automobileDetailsId)){
						userAutomobileMapDAO.updateUserAutomobileMapping(automobileDetailsId, userId, "A");
					}else{
						userAutomobileMapDAO.insertUserAutomobileMapping(automobileDetailsId, userId);
					}
				}

				while (oldAssignedAutomobilesIterator.hasNext()){
					Integer automobileDetailsId = oldAssignedAutomobilesIterator.next();
					if(!newAssignedAutomobiles.contains(automobileDetailsId)){
						userAutomobileMapDAO.updateUserAutomobileMapping(automobileDetailsId, userId, "I");
					}
				}
				isCreated = Boolean.TRUE;

			}
		} catch (SQLException s) {
			s.printStackTrace();
			isCreated = Boolean.FALSE;
		} catch (IOException e) {
			e.printStackTrace();
			isCreated = Boolean.FALSE;
		}
		return isCreated;
	}

	public Boolean assignServices(AssignServicesRequestBO assignServicesRequestBO) throws SQLException, IOException {
		Boolean isCreated = Boolean.FALSE;
		List<ServiceInfo> serviceInfoList = assignServicesRequestBO.getServiceInfoList();
		Iterator<ServiceInfo> serviceInfoIterator = serviceInfoList.iterator();
		UserServiceMapDAO userServiceMapDAO = new UserServiceMapDAO();
		try {
			while (serviceInfoIterator.hasNext()) {
				ServiceInfo serviceInfo = serviceInfoIterator.next();
				Integer userId = serviceInfo.getUserId();
				List<Integer> oldAssignedService = UserServiceMapDAO.getListOfServices(userId,null);
				List<Integer> newAssignedService = serviceInfo.getServiceIds();
				Iterator<Integer> newAssignedServiceIterator = newAssignedService.iterator();
				Iterator<Integer> oldAssignedServiceIterator = oldAssignedService.iterator();
				while (newAssignedServiceIterator.hasNext()){
					Integer serviceId = newAssignedServiceIterator.next();
					if(oldAssignedService.contains(serviceId)){
						userServiceMapDAO.updateUserServiceMapping(serviceId, userId, "A");
					}else{
						userServiceMapDAO.insertUserServiceMapping(serviceId, userId);
					}
				}

				while (oldAssignedServiceIterator.hasNext()){
					Integer serviceId = oldAssignedServiceIterator.next();
					if(!newAssignedService.contains(serviceId)){
						userServiceMapDAO.updateUserServiceMapping(serviceId, userId, "I");
					}
				}
				isCreated = Boolean.TRUE;

			}
		} catch (SQLException s) {
			s.printStackTrace();
			isCreated = Boolean.FALSE;
		} catch (IOException e) {
			e.printStackTrace();
			isCreated = Boolean.FALSE;
		}
		return isCreated;
	}

    public List<MechanicResponse> getMechanicsList(int service_id, int automobile_detail_id) throws SQLException, IOException {
			UsersDAO usersDAO = new UsersDAO();
			List<MechanicResponse> mechanicList = new ArrayList<MechanicResponse>();
			try {
				mechanicList = getMechanicResponseListFromDTOs(usersDAO.getMechanicByServiceId(service_id,automobile_detail_id));
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (IOException s) {
				s.printStackTrace();
			}
			return mechanicList;
		}

    public List<UserAutomobileMapResponseList> getUserAutomobileMapList(int userId)  throws SQLException, IOException {
		List<UserAutomobileMapResponseList> userList = null;
		try {
			UserAutomobileMapDAO userAutomobileMapDAO = new UserAutomobileMapDAO();
			userList = getUserMapResponseListFromDTOs(userAutomobileMapDAO.getUsersAutomobileMapList(userId));
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException s) {
			s.printStackTrace();
		}
		return userList;
	}

	private List<UserAutomobileMapResponseList> getUserMapResponseListFromDTOs(List<UserAutomobileMapDTO> userDTOs) throws SQLException{
			List<UserAutomobileMapResponseList> userResponseListResponse = new ArrayList<UserAutomobileMapResponseList>();
			Iterator<UserAutomobileMapDTO> usersDTOIterator = userDTOs.iterator();
			while(usersDTOIterator.hasNext()){
				UserAutomobileMapDTO usersDTO = usersDTOIterator.next();
				UserAutomobileMapResponseList userResponseList = new UserAutomobileMapResponseList(usersDTO.getId(),
						usersDTO.getUserId(),
						usersDTO.getAutomobileDetailsId(),
						usersDTO.getStatus());
				userResponseListResponse.add(userResponseList);
			}
			return userResponseListResponse;
		}

	public List<UserServiceMapResponseList> getUserServiceMapList(int userId) throws SQLException, IOException {
			List<UserServiceMapResponseList> userList = null;
			try {
				UserServiceMapDAO userServiceMapDAO = new UserServiceMapDAO();
				userList = getUserServiceMapResponseListFromDTOs(userServiceMapDAO.getUsersAutomobileMapList(userId));
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (IOException s) {
				s.printStackTrace();
			}
			return userList;
		}

	private List<UserServiceMapResponseList> getUserServiceMapResponseListFromDTOs(List<UserServiceMapDTO> userDTOs) throws SQLException{
			List<UserServiceMapResponseList> userResponseListResponse = new ArrayList<UserServiceMapResponseList>();
			Iterator<UserServiceMapDTO> usersDTOIterator = userDTOs.iterator();
			while(usersDTOIterator.hasNext()){
				UserServiceMapDTO usersDTO = usersDTOIterator.next();
				UserServiceMapResponseList userResponseList = new UserServiceMapResponseList(usersDTO.getId(),
						usersDTO.getUserId(),
						usersDTO.getServiceId(),
						usersDTO.getStatus());
				userResponseListResponse.add(userResponseList);
			}
			return userResponseListResponse;
		}
}



