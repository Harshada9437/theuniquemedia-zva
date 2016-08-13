package com.mpal.rest.response.automobileInfo;

/**
 * Created by System2 on 8/12/2016.
 */
public class AutomobileInfoCreationResponse {

    private String messagetype;
    private String message;

    public String getMessageType() {
        return messagetype;
    }

    public void setMessageType(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AutomobileInfoCreationResponse{" + "messagetype='" + messagetype
                + '\'' + ", message='" + message + '\'' + '}';
    }
}
