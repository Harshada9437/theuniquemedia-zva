package com.mpal.rest.response.automobileInfo;

/**
 * Created by System1 on 8/13/2016.
 */
public class UpdateAutomobileInfoResponse {

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
