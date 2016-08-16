package com.mpal.rest.response.automobile;

import java.util.List;

/**
 * Created by System1 on 8/16/2016.
 */
public class AutomobileTypeResponseList {

    List<AutomobileTypeResponse> automobileTypeResponsesResponses;
    private  String messageType;
    private String message;

    public List<AutomobileTypeResponse> getAutomobileTypeResponsesResponses() {
        return automobileTypeResponsesResponses;
    }

    public void setAutomobileTypeResponsesResponses(List<AutomobileTypeResponse> automobileTypeResponsesResponses) {
        this.automobileTypeResponsesResponses = automobileTypeResponsesResponses;
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
        return "AutomobileTypeResponseList{" +
                "automobileTypeResponsesResponses=" + automobileTypeResponsesResponses +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
