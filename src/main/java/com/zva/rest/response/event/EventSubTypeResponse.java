package com.zva.rest.response.event;

/**
 * Created by System-2 on 11/29/2016.
 */
public class EventSubTypeResponse {
    private int id;
    private int eventTypeId;
    private String subType;
    private String status;

    public EventSubTypeResponse(int id, int eventTypeId, String subType, String status) {
        this.id = id;
        this.eventTypeId = eventTypeId;
        this.subType = subType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public String getSubType() {
        return subType;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "EventSubTypeResponse{" +
                "id=" + id +
                ", eventTypeId=" + eventTypeId +
                ", subType='" + subType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
