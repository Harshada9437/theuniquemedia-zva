package com.mpal.exceptions.ServiceExceptions;

/**
 * Created by System1 on 9/1/2016.
 */
public class ServiceProviderTypeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceProviderTypeNotFoundException(String message) {
        super(message);
    }
}
