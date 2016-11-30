package com.zva.rest.response.zone;

import com.zva.rest.response.util.GenericResponse;

import java.util.List;

/**
 * Created by System-2 on 11/29/2016.
 */
public class ZoneResponseList implements GenericResponse {
    private List<ZoneResponse> zones;
    private String messageType;
    private String message;

    public List<ZoneResponse> getZones() {return zones;}

    public void setZones(List<ZoneResponse> zones) {this.zones = zones;}

    public String getMessageType() {return messageType;}

    public String getMessage() {return message;}

    @Override
    public void setMessageType(String messageType) {this.messageType = messageType;}

    @Override
    public void setMessage(String message) {this.message = message;}

    @Override
    public String toString() {
        return "ZoneResponseList{" +
                "zones=" + zones +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
