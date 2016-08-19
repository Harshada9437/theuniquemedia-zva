package com.mpal.requestHandlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mpal.bo.request.user.*;
import com.mpal.bo.response.LoginResponseBO;
import com.mpal.dao.user.UserTypesDAO;
import com.mpal.dao.user.UsersDAO;
import com.mpal.dto.user.LoginResponseDTO;
import com.mpal.dto.user.UserTypesDTO;
import com.mpal.dto.user.UsersDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;
import com.mpal.rest.response.user.GetTypesResponse;
import com.mpal.rest.response.user.GetUserResponse;
import com.mpal.rest.response.user.UserLoggedInResponse;
import com.mpal.rest.response.user.UserResponseList;
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

	public Boolean validUser(Integer userId) {

		Boolean isProcessed = Boolean.FALSE;
		UsersDAO usersDAO = new UsersDAO();
		try {
			UsersDTO userDTO = usersDAO.getUserById(userId);
			if(userDTO.getId() > 0)
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
		}
		loginResponseBO.setValidUser(isValidUser);
		loginResponseBO.setId(loginResponseDTO.getId());
		return loginResponseBO;
	}

	private UsersDTO buildUsersDTOFromBO(RegistrationRequestBO requestBO) {
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUserType(requestBO.getUserType());
		usersDTO.setName(requestBO.getName());
		usersDTO.setMobile(requestBO.getMobile());
		usersDTO.setEmail(requestBO.getEmail());
		usersDTO.setPassword(requestBO.getPassword());
		usersDTO.setClientDetailsId(requestBO.getClientDetailsId());
		return usersDTO;
	}

	private GetUserResponse buildUsersResponseFromDTO(UsersDTO usersDTO) {
		GetUserResponse userResponse = new GetUserResponse();
		userResponse.setId(usersDTO.getId());
		userResponse.setUserType(usersDTO.getUserType());
		userResponse.setName(usersDTO.getName());
		userResponse.setMobile(usersDTO.getMobile());
		userResponse.setEmail(usersDTO.getEmail());
		userResponse.setClientDetailsId(usersDTO.getClientDetailsId());
		return userResponse;
	}

	public List<GetTypesResponse> getUserTypes() {
		UserTypesDAO usersTypesDAO = new UserTypesDAO();
		List<GetTypesResponse> getTypesResponses = new ArrayList<GetTypesResponse>();
		try {
			List<UserTypesDTO> UserTypesDTOList = usersTypesDAO
					.getAllUserTypes();

			for (com.mpal.dto.user.UserTypesDTO UserTypesDTO : UserTypesDTOList) {
				GetTypesResponse getTypesResponse = new GetTypesResponse();
				getTypesResponse.setType(UserTypesDTO.getType());
				getTypesResponse.setStatus(UserTypesDTO.getStatus());
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
		UserTypesDAO userTypesDAO = new UserTypesDAO();
		GetUserResponse userResponse = buildUsersResponseFromDTO(usersDAO
				.getUserById(id));
		//userResponse.setUserType(userTypesDAO.getAllUserTypes());
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
					usersDTO.getUserType(),
					usersDTO.getName(),
					usersDTO.getMobile(),
					usersDTO.getEmail(),
					usersDTO.getClientDetailsId(),
					usersDTO.isVerified());
			userResponseListResponse.add(userResponseList);
		}
		return userResponseListResponse;
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

    public List<UserResponseList> getUserByType(String type) throws SQLException,
				UserNotFoundException {
			UsersDAO usersDAO = new UsersDAO();
			List<UserResponseList> userList = new ArrayList<UserResponseList>();
			try {
				userList = getUserResponseListFromDTOs(usersDAO.getUserByType(type));
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (AutomobileNotFoundException s) {
				s.printStackTrace();
			}
			return userList;
		}
}
