package com.zva.rest.response.area;

import com.zva.rest.response.util.GenericResponse;

import java.util.List;

/**
 * Created by System1 on 8/26/2016.
 */
public class AreaResponseList implements GenericResponse {
    private List<AreaResponse> areas;
    private String messageType;
    private String message;

    public List<AreaResponse> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaResponse> areas) {
        this.areas = areas;
    }

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
        return "AreaResponseList{" +
                "areas=" + areas +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
