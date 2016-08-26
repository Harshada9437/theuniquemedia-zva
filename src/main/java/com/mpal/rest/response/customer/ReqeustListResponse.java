package com.mpal.rest.response.customer;

import java.util.List;

/**
 * Created by System1 on 8/26/2016.
 */
public class ReqeustListResponse {
    private List<RequestResponseList> requests;
    private String messageType;
    private String message;

    public List<RequestResponseList> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestResponseList> requests) {
        this.requests = requests;
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
        return "ReqeustListResponse{" +
                "requests=" + requests +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
