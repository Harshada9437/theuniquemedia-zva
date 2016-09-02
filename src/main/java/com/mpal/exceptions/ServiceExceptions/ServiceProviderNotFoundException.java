package com.mpal.exceptions.ServiceExceptions;

/**
 * Created by System1 on 9/2/2016.
 */

public class ServiceProviderNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceProviderNotFoundException(String message) {
        super(message);
    }
}
