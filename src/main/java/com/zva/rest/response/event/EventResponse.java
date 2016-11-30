package com.zva.rest.response.event;

/**
 * Created by System-2 on 11/29/2016.
 */
public class EventResponse {
    private int id;
    private String type;
    private String status;

    public EventResponse(int id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
