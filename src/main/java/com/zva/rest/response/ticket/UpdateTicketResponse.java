package com.zva.rest.response.ticket;

import com.zva.rest.response.util.GenericResponse;

/**
 * Created by System-2 on 11/29/2016.
 */
public class UpdateTicketResponse implements GenericResponse {
    private String message;
    private String messageType;

    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    @Override
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "UpdateTicketResponse{" +
                "message='" + message + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
