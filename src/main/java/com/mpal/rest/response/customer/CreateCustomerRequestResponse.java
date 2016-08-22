package com.mpal.rest.response.customer;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class CreateCustomerRequestResponse {
    private String messageType;
    private String message;

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
        return "CreateCustomerRequestResponse{" +
                "messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
