package com.mpal.rest.response.serviceprovider;

/**
 * Created by System2 on 8/12/2016.
 */
public class ServiceProviderCreationResponse {

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
        return "ServiceProviderCreationResponse{" + "messagetype='" + messagetype
                + '\'' + ", message='" + message + '\'' + '}';
    }
}
