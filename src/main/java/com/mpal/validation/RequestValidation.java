package com.mpal.validation;

import com.mpal.dao.user.UsersDAO;
import com.mpal.exceptions.userServiceExceptions.UserNotFoundException;

import java.sql.SQLException;

public class RequestValidation {
    public static Boolean isRequestValid(String sessionId){
        String[] sessionIdParts = sessionId.split("@");
        Boolean isValidRequest = Boolean.FALSE;
        try {
            String sessionIdForUser = new UsersDAO().getSessionIdForUserId(Integer.parseInt(sessionIdParts[1]));
            if(sessionIdForUser.equals(sessionIdParts[0])){
                isValidRequest = Boolean.TRUE;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }

        return isValidRequest;
    }
}
