package com.mpal.rest.response.serviceprovider;

import java.util.List;

/**
 * Created by System1 on 8/26/2016.
 */
public class ServiceProviderResponseList {
    private List<ServiceProviderResponse> serviceProviderResponses;
    private String messageType;
    private String message;

    public List<ServiceProviderResponse> getServiceProviderResponses() {
        return serviceProviderResponses;
    }

    public void setServiceProviderResponses(List<ServiceProviderResponse> serviceProviderResponses) {
        this.serviceProviderResponses = serviceProviderResponses;
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
        return "ServiceProviderResponseList{" +
                "serviceProviderResponses=" + serviceProviderResponses +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
