package com.mpal.rest.response.user;

import java.util.List;

/**
 * Created by System1 on 8/23/2016.
 */
public class MechanicByServiceResponse {
    private List<MechanicResponse> mechanicsList;
    private String messageType;
    private  String message;

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

    public List<MechanicResponse> getMechanicsList() {
        return mechanicsList;
    }

    public void setMechanicsList(List<MechanicResponse> mechanicsList) {
        this.mechanicsList = mechanicsList;
    }

    @Override
    public String toString() {
        return "MechanicByServiceResponse{" +
                "mechanicsList=" + mechanicsList +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
