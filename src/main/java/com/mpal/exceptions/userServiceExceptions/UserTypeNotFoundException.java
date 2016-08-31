package com.mpal.exceptions.userServiceExceptions;

/**
 * Created by Sumedh on 31-08-2016.
 */
public class UserTypeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserTypeNotFoundException(String message) {
        super(message);
    }
}
