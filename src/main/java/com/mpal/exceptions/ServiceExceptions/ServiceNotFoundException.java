package com.mpal.exceptions.ServiceExceptions;

/**
 * Created by System1 on 8/16/2016.
 */
public class ServiceNotFoundException extends RuntimeException{
    private static final long serialVersionSID=1L;
    public ServiceNotFoundException(String message) {
        super(message);
    }
}
