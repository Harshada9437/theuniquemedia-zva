package com.zva.rest.response.ticket;

import com.zva.rest.response.util.GenericResponse;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class CreateTicketResponse implements GenericResponse{
    private String messageType;
    private String message;

    public String getMessageType() {
        return messageType;
    }

    @Override
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreateTicketResponse{" +
                "messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
