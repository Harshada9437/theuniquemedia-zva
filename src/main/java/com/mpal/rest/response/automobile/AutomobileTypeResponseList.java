package com.mpal.rest.response.automobile;

import java.util.List;

/**
 * Created by System1 on 8/8/2016.
 */
public class AutomobileTypeResponseList {

    List<AutomobileResponseList> automobileResponseLists;
    private  String messageType;
    private String message;

    public List<AutomobileResponseList> getAutomobileResponseLists() {
        return automobileResponseLists;
    }

    public void setAutomobileResponseLists(List<AutomobileResponseList> automobileResponseLists) {
        this.automobileResponseLists = automobileResponseLists;
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
                "automobileResponseLists=" + automobileResponseLists +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
