package com.mpal.rest.response.customer;

import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class RequestList {
    private List<RequestResponse> request;
    private String messageType;
    private String message;

    public List<RequestResponse> getRequest() {
        return request;
    }

    public void setRequest(List<RequestResponse> request) {
        this.request = request;
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
        return "RequestList{" +
                "request=" + request +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
