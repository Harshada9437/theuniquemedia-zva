package com.mpal.rest.response.customer;

/**
 * Created by System2 on 8/23/2016.
 */
public class UpdateCustomerResponse {
    private String message;
    private  String messagetype;

    public String getMessage() {
        return message;
    }

    public String getMessageType() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UpdateCustomerResponse{" + "messageType='" + messagetype + '\''
                + "Message='" + message + '\''
                + '}';
    }
}
