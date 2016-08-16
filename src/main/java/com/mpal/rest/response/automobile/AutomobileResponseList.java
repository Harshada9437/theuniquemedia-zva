package com.mpal.rest.response.automobile;

import java.util.List;

/**
 * Created by System1 on 8/8/2016.
 */
public class AutomobileResponseList {

    List<AutomobileResponse> automobileResponses;
    private  String messageType;
    private String message;

    public List<AutomobileResponse> getAutomobileResponses() {
        return automobileResponses;
    }

    public void setAutomobileResponses(List<AutomobileResponse> automobileResponses) {
        this.automobileResponses = automobileResponses;
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
        return "AutomobileResponseList{" +
                "automobileResponses=" + automobileResponses +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
