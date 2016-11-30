package com.zva.rest.response.event;

import com.zva.rest.response.util.GenericResponse;

import java.util.List;

/**
 * Created by System-2 on 11/29/2016.
 */
public class EventResponseList implements GenericResponse {
    private List<EventResponse> events;
    private String messageType;
    private String message;

    public List<EventResponse> getEvents() {
        return events;
    }

    public void setEvents(List<EventResponse> events) {
        this.events = events;
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
        return "EventResponseList{" +
                "events=" + events +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
