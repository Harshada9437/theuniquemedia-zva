package com.mpal.exceptions.AutomobileServiceExceptions;

public class AutomobileNotFoundException extends RuntimeException {
    private static final long serialVersionAID=1L;
    public AutomobileNotFoundException(String message) {
        super(message);
    }
}
