package com.mpal.exceptions.RequestException;

/**
 * Created by System1 on 8/26/2016.
 */
public class RequestNotFoundException extends RuntimeException {
        private static final long serialVersionRID = 1L;

        public RequestNotFoundException(String message) {
            super(message);
        }
}
