package com.mpal.rest.response.services;

import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class ServiceResponseList {
    private List<ServiceResponse> services;
    private String messageType;
    private String message;

    public List<ServiceResponse> getServices() {
        return services;
    }

    public void setServices(List<ServiceResponse> services) {
        this.services = services;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServiceResponseList{" +
                "services=" + services +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
