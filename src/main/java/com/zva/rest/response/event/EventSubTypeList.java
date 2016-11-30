package com.zva.rest.response.event;

import com.zva.rest.response.util.GenericResponse;

import java.util.List;

/**
 * Created by System-2 on 11/29/2016.
 */
public class EventSubTypeList implements GenericResponse {
    private List<EventSubTypeResponse> eventSubTypes;
    private String messageType;
    private String message;

    public List<EventSubTypeResponse> getEventSubTypes() {
        return eventSubTypes;
    }

    public void setEventSubTypes(List<EventSubTypeResponse> eventSubTypes) {
        this.eventSubTypes = eventSubTypes;
    }

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
        return "EventSubTypeList{" +
                "eventSubTypes=" + eventSubTypes +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
