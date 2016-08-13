package com.mpal.rest.response.automobile;

/**
 * Created by System2 on 8/12/2016.
 */
public class UpdateAutomobileResponse {
    private String message;
    private  String messagetype;

    public String getMessageType() {
        return messagetype;
    }

    public void setMessageType(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getsMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UpdateResponse{" + "messageType='" + messagetype + '\''
                + "Message='" + message + '\''
                + '}';
    }
}
