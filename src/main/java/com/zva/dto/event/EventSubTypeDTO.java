package com.zva.dto.event;

/**
 * Created by System-2 on 11/29/2016.
 */
public class EventSubTypeDTO {
    private int id;
    private int eventTypeId;
    private String subType;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventSubTypeDTO that = (EventSubTypeDTO) o;

        if (id != that.id) return false;
        if (eventTypeId != that.eventTypeId) return false;
        if (subType != null ? !subType.equals(that.subType) : that.subType != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + eventTypeId;
        result = 31 * result + (subType != null ? subType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventSubTypeDTO{" +
                "id=" + id +
                ", eventTypeId=" + eventTypeId +
                ", subType='" + subType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
