package com.mpal.rest.response.serviceprovider;

import java.util.List;

/**
 * Created by System1 on 8/16/2016.
 */
public class ServiceTypeResponseList {

    private List<ServiceTypeResponse> serviceTypeResponses;
    private String messageType;
    private String message;

    public List<ServiceTypeResponse> getServiceTypeResponses() {
        return serviceTypeResponses;
    }

    public void setServiceTypeResponses(List<ServiceTypeResponse> serviceTypeResponses) {
        this.serviceTypeResponses = serviceTypeResponses;
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
        return "ServiceTypeResponseList{" +
                "serviceTypeResponses=" + serviceTypeResponses +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
