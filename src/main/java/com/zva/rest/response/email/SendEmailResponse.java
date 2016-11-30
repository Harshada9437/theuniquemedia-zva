package com.zva.rest.response.email;

/**
 * Created by Sumedh on 20-03-2016.
 */
public class SendEmailResponse {
    private String message;
    private String message_type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return message_type;
    }

    public void setMessageType(String message_type) {
        this.message_type = message_type;
    }

    @Override
    public String toString() {
        return "SendEmailResponse{" +
                "messageType='" + message_type + '\'' +
                "message='" + message + '\'' +
                '}';
    }
}
